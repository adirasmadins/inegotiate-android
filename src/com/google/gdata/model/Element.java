package com.google.gdata.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gdata.model.ElementVisitor.StoppedException;
import com.google.gdata.model.atom.Category;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.Objects;
import com.google.gdata.util.common.base.Objects.ToStringHelper;
import com.google.gdata.util.common.base.Pair;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.wireformats.ContentCreationException;
import com.google.gdata.wireformats.ContentValidationException;
import com.google.gdata.wireformats.ObjectConverter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Element {
    private static final Logger LOGGER;
    private final ElementKey<?, ?> key;
    private final ElementState state;

    private static class ElementState {
        private Map<QName, Attribute> attributes;
        private Map<QName, Object> elements;
        private volatile boolean locked;
        private Object value;

        private ElementState() {
        }

        public String toString() {
            ToStringHelper helper = Objects.toStringHelper(this);
            if (this.attributes != null) {
                helper.add("attributes", this.attributes.values());
            }
            if (this.elements != null) {
                helper.add("elements", this.elements.values());
            }
            if (this.value != null) {
                helper.add("value", this.value);
            }
            return helper.toString();
        }
    }

    static {
        LOGGER = Logger.getLogger(Element.class.getName());
    }

    public static ElementKey<?, ?> getDefaultKey(Class<? extends Element> type) {
        Preconditions.checkNotNull(type, "type");
        try {
            return (ElementKey) ElementKey.class.cast(type.getField("KEY").get(null));
        } catch (NoSuchFieldException nsfe) {
            throw new IllegalArgumentException("Unable to access KEY field:" + type, nsfe);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Unable to access KEY field:" + type, iae);
        } catch (IllegalAccessException iae2) {
            throw new IllegalArgumentException("Unable to access KEY field:" + type, iae2);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Unable to access KEY field:" + type, npe);
        }
    }

    public Element(ElementKey<?, ?> elementKey) {
        Preconditions.checkNotNull(elementKey, "elementKey");
        this.key = bindKey(elementKey, getClass());
        this.state = new ElementState();
    }

    public Element(QName qName) {
        this.key = ElementKey.of(qName, String.class, getClass());
        this.state = new ElementState();
    }

    public Element(ElementKey<?, ?> elementKey, Element source) {
        this.key = bindKey(elementKey, getClass());
        this.state = source.state;
    }

    private static ElementKey<?, ?> bindKey(ElementKey<?, ?> key, Class<? extends Element> type) {
        return key.getElementType() == type ? key : ElementKey.of(key.getId(), key.getDatatype(), type);
    }

    public final boolean isLocked() {
        return this.state.locked;
    }

    public Element lock() {
        this.state.locked = true;
        if (this.state.attributes != null) {
            for (Attribute att : this.state.attributes.values()) {
                att.lock();
            }
        }
        if (this.state.elements != null) {
            for (Object childObj : this.state.elements.values()) {
                if (childObj instanceof Element) {
                    ((Element) childObj).lock();
                } else {
                    for (Element child : castElementCollection(childObj)) {
                        child.lock();
                    }
                }
            }
        }
        return this;
    }

    private void throwExceptionIfLocked() {
        boolean z;
        if (this.state.locked) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "%s instance is read only", getElementId());
    }

    public ElementKey<?, ?> getElementKey() {
        return this.key;
    }

    public QName getElementId() {
        return this.key.getId();
    }

    public Iterator<Attribute> getAttributeIterator() {
        return getAttributeIterator(null);
    }

    public Iterator<Attribute> getAttributeIterator(ElementMetadata<?, ?> metadata) {
        return new AttributeIterator(this, metadata, this.state.attributes);
    }

    public int getAttributeCount() {
        return this.state.attributes != null ? this.state.attributes.size() : 0;
    }

    public boolean hasAttribute(QName id) {
        return this.state.attributes == null ? false : this.state.attributes.containsKey(id);
    }

    public boolean hasAttribute(AttributeKey<?> childKey) {
        return hasAttribute(childKey.getId());
    }

    public Object getAttributeValue(QName id) {
        if (this.state.attributes == null) {
            return null;
        }
        Attribute attribute = (Attribute) this.state.attributes.get(id);
        if (attribute != null) {
            return attribute.getValue();
        }
        return null;
    }

    public <T> T getAttributeValue(AttributeKey<T> key) {
        Attribute attribute = this.state.attributes == null ? null : (Attribute) this.state.attributes.get(key.getId());
        Object value = attribute == null ? null : attribute.getValue();
        if (value == null) {
            return null;
        }
        try {
            return ObjectConverter.getValue(value, key.getDatatype());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Unable to convert value " + e + " to datatype " + key.getDatatype());
        }
    }

    public Element setAttributeValue(QName id, Object attrValue) {
        return setAttributeValue(AttributeKey.of(id), attrValue);
    }

    public Element setAttributeValue(AttributeKey<?> key, Object attrValue) {
        if (attrValue == null) {
            removeAttributeValue((AttributeKey) key);
        } else {
            setAttribute(key, new Attribute(key, attrValue));
        }
        return this;
    }

    private void setAttribute(AttributeKey<?> attKey, Attribute attribute) {
        throwExceptionIfLocked();
        if (this.state.attributes == null) {
            this.state.attributes = new LinkedHashMap();
        }
        this.state.attributes.put(attKey.getId(), attribute);
    }

    @Deprecated
    public Object removeAttribute(QName id) {
        return removeAttributeValue(id);
    }

    public Object removeAttributeValue(QName id) {
        throwExceptionIfLocked();
        Attribute removed = this.state.attributes == null ? null : (Attribute) this.state.attributes.remove(id);
        return removed == null ? null : removed.getValue();
    }

    @Deprecated
    public Object removeAttribute(AttributeKey<?> key) {
        return removeAttributeValue((AttributeKey) key);
    }

    public Object removeAttributeValue(AttributeKey<?> key) {
        return removeAttributeValue(key.getId());
    }

    public Iterator<Element> getElementIterator() {
        return getElementIterator(null);
    }

    public Iterator<Element> getElementIterator(ElementMetadata<?, ?> metadata) {
        return new ElementIterator(this, metadata, this.state.elements);
    }

    public int getElementCount() {
        int elementCount = 0;
        if (this.state.elements != null) {
            for (Object elementValue : this.state.elements.values()) {
                if (elementValue instanceof Collection) {
                    elementCount += castElementCollection(elementValue).size();
                } else {
                    elementCount++;
                }
            }
        }
        return elementCount;
    }

    public Element getElement(QName id) {
        Object mapValue = getElementObject(id);
        if (mapValue instanceof Element) {
            return (Element) mapValue;
        }
        Preconditions.checkArgument(!(mapValue instanceof Collection), "The getElement(*) method was called for a repeating element.  Use getElements(*) instead.");
        return null;
    }

    public <D, T extends Element> T getElement(ElementKey<D, T> childKey) {
        Element child = getElement(childKey.getId());
        if (child == null) {
            return null;
        }
        try {
            return adapt(childKey, child);
        } catch (ContentCreationException e) {
            throw new IllegalArgumentException("Unable to adapt to " + childKey.getElementType(), e);
        }
    }

    private Object getElementObject(QName id) {
        if (this.state.elements == null) {
            return null;
        }
        if (QName.ANY_LOCALNAME.equals(id.getLocalName())) {
            XmlNamespace ns = id.getNs();
            if (ns != null) {
                String uri = ns.getUri();
                Builder<Element> builder = ImmutableList.builder();
                for (Entry<QName, Object> entry : this.state.elements.entrySet()) {
                    XmlNamespace keyNs = ((QName) entry.getKey()).getNs();
                    if (keyNs != null && uri.equals(keyNs.getUri())) {
                        Object value = entry.getValue();
                        if (value instanceof Element) {
                            builder.add((Element) value);
                        } else {
                            builder.addAll(castElementCollection(value));
                        }
                    }
                }
                return builder.build();
            }
        }
        return this.state.elements.get(id);
    }

    private Object getElementObject(ElementKey<?, ?> childKey) {
        return getElementObject(childKey.getId());
    }

    public Object getElementValue(QName id) {
        Element e = getElement(id);
        return e == null ? null : e.getTextValue();
    }

    public <V> V getElementValue(ElementKey<V, ? extends Element> key) {
        Element e = getElement((ElementKey) key);
        return e == null ? null : e.getTextValue(key);
    }

    public boolean hasElement(QName id) {
        return this.state.elements == null ? false : this.state.elements.containsKey(id);
    }

    public boolean hasElement(ElementKey<?, ?> childKey) {
        return hasElement(childKey.getId());
    }

    public List<Element> getElements(QName id) {
        Builder<Element> builder = ImmutableList.builder();
        Object obj = getElementObject(id);
        if (obj != null) {
            if (obj instanceof Element) {
                builder.add((Element) obj);
            } else {
                for (Object e : castElementCollection(obj)) {
                    builder.add(e);
                }
            }
        }
        return builder.build();
    }

    public <T extends Element> List<T> getElements(ElementKey<?, T> key) {
        Builder<T> builder = ImmutableList.builder();
        Object obj = getElementObject((ElementKey) key);
        if (obj != null) {
            Class<? extends T> childType = key.getElementType();
            if (!(obj instanceof Element)) {
                for (Element e : castElementCollection(obj)) {
                    if (childType.isInstance(e)) {
                        builder.add(childType.cast(e));
                    }
                }
            } else if (childType.isInstance(obj)) {
                builder.add(childType.cast(obj));
            }
        }
        return builder.build();
    }

    public Set<Element> getElementSet(QName id) {
        ImmutableSet.Builder<Element> builder = ImmutableSet.builder();
        Object obj = getElementObject(id);
        if (obj != null) {
            if (obj instanceof Element) {
                builder.add((Element) obj);
            } else {
                for (Object e : castElementCollection(obj)) {
                    builder.add(e);
                }
            }
        }
        return builder.build();
    }

    public <T extends Element> Set<T> getElementSet(ElementKey<?, T> key) {
        ImmutableSet.Builder<T> builder = ImmutableSet.builder();
        Object obj = getElementObject((ElementKey) key);
        if (obj != null) {
            Class<? extends T> childType = key.getElementType();
            if (!(obj instanceof Element)) {
                for (Element e : castElementCollection(obj)) {
                    if (childType.isInstance(e)) {
                        builder.add(childType.cast(e));
                    }
                }
            } else if (childType.isInstance(obj)) {
                builder.add(childType.cast(obj));
            }
        }
        return builder.build();
    }

    public Element setElement(QName id, Element element) {
        removeElement(id);
        if (element != null) {
            addElement(id, element);
        }
        return this;
    }

    public Element setElement(Element element) {
        Preconditions.checkNotNull(element);
        setElement(element.getElementKey(), element);
        return this;
    }

    public Element setElement(ElementKey<?, ?> key, Element element) {
        removeElement((ElementKey) key);
        if (element != null) {
            addElement((ElementKey) key, element);
        }
        return this;
    }

    public Element addElement(Element element) {
        Preconditions.checkNotNull(element);
        addElement(element.getElementKey(), element);
        return this;
    }

    public Element addElement(QName id, Element element) {
        Preconditions.checkNotNull(element);
        addElement(ElementKey.of(id, element.getElementKey().getDatatype(), element.getClass()), element);
        return this;
    }

    public Element addElement(ElementKey<?, ?> key, Element element) {
        throwExceptionIfLocked();
        if (this.state.elements == null) {
            this.state.elements = new LinkedHashMap();
        }
        ElementKey<?, ?> elementKey = element.getElementKey();
        key = calculateKey(key, elementKey);
        if (!key.equals(elementKey)) {
            try {
                element = createElement(key, element);
            } catch (ContentCreationException e) {
                throw new IllegalArgumentException("Key " + key + " cannot be applied" + " to element with key " + elementKey);
            }
        }
        QName id = key.getId();
        Object obj = this.state.elements.get(id);
        if (obj == null) {
            this.state.elements.put(id, element);
        } else if (obj instanceof Collection) {
            castElementCollection(obj).add(element);
        } else {
            Collection<Element> collect = createCollection(key);
            collect.add((Element) obj);
            collect.add(element);
            this.state.elements.put(id, collect);
        }
        return this;
    }

    private ElementKey<?, ?> calculateKey(ElementKey<?, ?> key, ElementKey<?, ?> sourceKey) {
        Class<?> keyType = key.getElementType();
        Class<? extends Element> sourceType = sourceKey.getElementType();
        if (keyType == sourceType || !keyType.isAssignableFrom(sourceType)) {
            return key;
        }
        return ElementKey.of(key.getId(), key.getDatatype(), sourceType);
    }

    public Element removeElement(QName id) {
        throwExceptionIfLocked();
        if (this.state.elements != null) {
            this.state.elements.remove(id);
        }
        return this;
    }

    public Element removeElement(ElementKey<?, ?> childKey) {
        return removeElement(childKey.getId());
    }

    public boolean removeElement(Element element) {
        return removeElement(element.getElementKey(), element);
    }

    public boolean removeElement(ElementKey<?, ?> childKey, Element element) {
        throwExceptionIfLocked();
        boolean removed = false;
        if (this.state.elements == null) {
            return false;
        }
        Element obj = getElementObject((ElementKey) childKey);
        if (obj instanceof Collection) {
            Collection<Element> collect = castElementCollection(obj);
            Iterator<Element> iter = collect.iterator();
            while (iter.hasNext()) {
                if (iter.next() == element) {
                    iter.remove();
                    removed = true;
                    break;
                }
            }
            if (!collect.isEmpty()) {
                return removed;
            }
            removeElement((ElementKey) childKey);
            return removed;
        } else if (obj != element) {
            return false;
        } else {
            removeElement((ElementKey) childKey);
            return true;
        }
    }

    public boolean replaceElement(Element toRemove, Element toAdd) {
        throwExceptionIfLocked();
        if (toAdd == null) {
            return removeElement(toRemove);
        }
        QName id = toRemove.getElementId();
        if (id.equals(toAdd.getElementId())) {
            if (this.state.elements != null) {
                Element obj = this.state.elements.get(id);
                if (obj instanceof List) {
                    List<Element> list = castElementList(obj);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == toRemove) {
                            list.set(i, toAdd);
                            return true;
                        }
                    }
                } else if (obj instanceof Set) {
                    Set<Element> set = castElementSet(obj);
                    if (set.remove(toRemove)) {
                        set.add(toAdd);
                    }
                } else if (obj == toRemove) {
                    this.state.elements.put(id, toAdd);
                    return true;
                }
            }
            return false;
        }
        boolean removed = removeElement(toRemove);
        if (!removed) {
            return removed;
        }
        addElement(toAdd);
        return removed;
    }

    private <T extends Element> List<T> castElementList(Object obj) {
        return (List) obj;
    }

    private <T extends Element> Set<T> castElementSet(Object obj) {
        return (Set) obj;
    }

    private <T extends Element> Collection<T> castElementCollection(Object obj) {
        return (Collection) obj;
    }

    private <T extends Element> Collection<T> createCollection(ElementKey<?, ?> key) {
        if (Category.class.isAssignableFrom(key.getElementType())) {
            return Sets.newLinkedHashSet();
        }
        return Lists.newArrayList();
    }

    public void clear() {
        throwExceptionIfLocked();
        this.state.value = null;
        this.state.attributes = null;
        this.state.elements = null;
    }

    public Object getTextValue() {
        return this.state.value;
    }

    public <V> V getTextValue(ElementKey<V, ?> key) {
        if (this.state.value == null) {
            return null;
        }
        try {
            return ObjectConverter.getValue(this.state.value, key.getDatatype());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Unable to convert value " + e + " to datatype " + key.getDatatype());
        }
    }

    public Element setTextValue(Object newValue) {
        throwExceptionIfLocked();
        this.state.value = checkValue(this.key, newValue);
        return this;
    }

    Object checkValue(ElementKey<?, ?> elementKey, Object newValue) {
        if (newValue != null) {
            boolean z;
            Class<?> datatype = elementKey.getDatatype();
            if (datatype != Void.class) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Element must not contain a text node");
            Preconditions.checkArgument(datatype.isInstance(newValue), "Invalid class: %s", newValue.getClass().getCanonicalName());
        }
        return newValue;
    }

    public boolean hasTextValue() {
        return this.state.value != null;
    }

    public Element resolve(ElementMetadata<?, ?> metadata) throws ContentValidationException {
        ValidationContext vc = new ValidationContext();
        Element narrowed = resolve(metadata, vc);
        if (vc.isValid()) {
            return narrowed;
        }
        throw new ContentValidationException("Invalid data", vc);
    }

    public Element resolve(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        if (metadata == null) {
            return this;
        }
        Element narrowed = narrow(metadata, vc);
        narrowed.validate(metadata, vc);
        Iterator<Element> childIterator = narrowed.getElementIterator();
        if (childIterator.hasNext()) {
            List<Pair<Element, Element>> replacements = Lists.newArrayList();
            while (childIterator.hasNext()) {
                Element child = (Element) childIterator.next();
                Element resolved = child.resolve(metadata.bindElement(child.getElementKey()), vc);
                if (resolved != child) {
                    replacements.add(Pair.of(child, resolved));
                }
            }
            for (Pair<Element, Element> pair : replacements) {
                narrowed.replaceElement((Element) pair.getFirst(), (Element) pair.getSecond());
            }
        }
        return narrowed;
    }

    protected Element narrow(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        ElementKey<?, ?> narrowedKey = metadata.getKey();
        Class<?> narrowedType = narrowedKey.getElementType();
        if (!narrowedType.isInstance(this)) {
            if (!getClass().isAssignableFrom(narrowedType)) {
                LOGGER.severe("Element of type " + getClass() + " cannot be narrowed to type " + narrowedType);
            }
            try {
                this = adapt(narrowedKey, this);
            } catch (ContentCreationException e) {
                LOGGER.log(Level.SEVERE, "Unable to adapt " + getClass() + " to " + narrowedType, e);
            }
        }
        return this;
    }

    protected Element adapt(Element source, ElementMetadata<?, ?> sourceMeta, String kind) {
        ElementKey<?, ?> adaptorKey = sourceMeta.adapt(kind);
        if (adaptorKey != null) {
            try {
                source = adapt(adaptorKey, source);
            } catch (ContentCreationException e) {
                LOGGER.log(Level.SEVERE, "Unable to adapt " + source.getClass() + " to " + adaptorKey.getElementType(), e);
            }
        }
        return source;
    }

    protected <T extends Element> T adapt(ElementKey<?, T> key, Element source) throws ContentCreationException {
        Preconditions.checkNotNull(key);
        Class<? extends T> adaptingTo = key.getElementType();
        if (source == null || adaptingTo.isInstance(source)) {
            return (Element) adaptingTo.cast(source);
        }
        Object[] objArr = new Object[]{source.getClass(), adaptingTo};
        Preconditions.checkArgument(source.getClass().isAssignableFrom(adaptingTo), "Cannot adapt from element of type %s to an element of type %s", objArr);
        return createElement(key, source);
    }

    protected void validate(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        if (metadata != null) {
            metadata.validate(vc, this);
        }
    }

    public void visit(ElementVisitor ev, ElementMetadata<?, ?> meta) {
        visit(ev, null, meta);
    }

    private void visit(ElementVisitor ev, Element parent, ElementMetadata<?, ?> meta) throws StoppedException {
        if (ev.visit(parent, this, meta)) {
            visitChildren(ev, meta);
        }
        ev.visitComplete(parent, this, meta);
    }

    private void visitChildren(ElementVisitor ev, ElementMetadata<?, ?> meta) throws StoppedException {
        Iterator<Element> childIterator = getElementIterator(meta);
        while (childIterator.hasNext()) {
            Element child = (Element) childIterator.next();
            child.visit(ev, this, meta == null ? null : meta.bindElement(child.getElementKey()));
        }
    }

    protected boolean sameClassAs(Object o) {
        return o != null && getClass().equals(o.getClass());
    }

    protected static boolean eq(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else {
            return o1.equals(o2);
        }
    }

    public static <E extends Element> E createElement(ElementKey<?, E> key) throws ContentCreationException {
        return createElement(key, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E extends com.google.gdata.model.Element> E createElement(com.google.gdata.model.ElementKey<?, E> r7, com.google.gdata.model.Element r8) throws com.google.gdata.wireformats.ContentCreationException {
        /*
        if (r8 == 0) goto L_0x0021;
    L_0x0002:
        r4 = r8.getElementKey();
        r4 = r7.equals(r4);
        if (r4 == 0) goto L_0x0021;
    L_0x000c:
        r4 = r7.getElementType();
        r4 = r4.isInstance(r8);
        if (r4 == 0) goto L_0x0021;
    L_0x0016:
        r4 = r7.getElementType();
        r4 = r4.cast(r8);
        r4 = (com.google.gdata.model.Element) r4;
    L_0x0020:
        return r4;
    L_0x0021:
        r3 = r7.getElementType();
        if (r8 == 0) goto L_0x0046;
    L_0x0027:
        r4 = 2;
        r0 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r5 = com.google.gdata.model.ElementKey.class;
        r0[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 1;
        r5 = r8.getClass();	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r0[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 2;
        r1 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r1[r4] = r7;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 1;
        r1[r4] = r8;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
    L_0x003f:
        r4 = construct(r3, r0, r1);	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = (com.google.gdata.model.Element) r4;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        goto L_0x0020;
    L_0x0046:
        r4 = 1;
        r0 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r5 = com.google.gdata.model.ElementKey.class;
        r0[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 1;
        r1 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r1[r4] = r7;	 Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        goto L_0x003f;
    L_0x0055:
        r2 = move-exception;
        if (r8 == 0) goto L_0x006f;
    L_0x0058:
        r4 = 1;
        r0 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r5 = r8.getClass();	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r0[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 1;
        r1 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r1[r4] = r8;	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
    L_0x0068:
        r4 = construct(r3, r0, r1);	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = (com.google.gdata.model.Element) r4;	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        goto L_0x0020;
    L_0x006f:
        r4 = 0;
        r0 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        r4 = 0;
        r1 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x0076, IllegalAccessException -> 0x0090, InstantiationException -> 0x00aa, InvocationTargetException -> 0x00c4 }
        goto L_0x0068;
    L_0x0076:
        r2 = move-exception;
        r4 = new com.google.gdata.wireformats.ContentCreationException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Constructor not found: ";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x0090:
        r2 = move-exception;
        r4 = new com.google.gdata.wireformats.ContentCreationException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Constructor not found: ";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00aa:
        r2 = move-exception;
        r4 = new com.google.gdata.wireformats.ContentCreationException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Constructor not found: ";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00c4:
        r2 = move-exception;
        r4 = new com.google.gdata.wireformats.ContentCreationException;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Constructor not found: ";
        r5 = r5.append(r6);
        r5 = r5.append(r3);
        r5 = r5.toString();
        r6 = r2.getCause();
        r4.<init>(r5, r6);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gdata.model.Element.createElement(com.google.gdata.model.ElementKey, com.google.gdata.model.Element):E");
    }

    private static <T> T construct(Class<? extends T> clazz, Class<?>[] argTypes, Object[] args) throws SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Constructor<T> ctc : clazz.getDeclaredConstructors()) {
            if (paramsValid(ctc.getParameterTypes(), argTypes)) {
                ctc.setAccessible(true);
                return ctc.newInstance(args);
            }
        }
        return clazz.getConstructor(argTypes).newInstance(args);
    }

    private static boolean paramsValid(Class<?>[] paramTypes, Class<?>[] argTypes) {
        if (paramTypes.length != argTypes.length) {
            return false;
        }
        for (int i = 0; i < paramTypes.length; i++) {
            if (!paramTypes[i].isAssignableFrom(argTypes[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Element) {
            return this.state.equals(((Element) obj).state);
        }
        return false;
    }

    public String toString() {
        ToStringHelper helper = Objects.toStringHelper(this);
        helper.addValue(getElementId() + "@" + Integer.toHexString(hashCode()));
        Iterator<Attribute> aIter = getAttributeIterator();
        while (aIter.hasNext()) {
            Attribute att = (Attribute) aIter.next();
            helper.add(att.getAttributeKey().getId().toString(), att.getValue());
        }
        if (hasTextValue()) {
            helper.addValue(getTextValue());
        }
        return helper.toString();
    }
}
