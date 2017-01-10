package com.google.gdata.model;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.wireformats.ContentCreationException;
import com.google.gdata.wireformats.ObjectConverter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ElementMetadataImpl<D, E extends Element> extends MetadataImpl<D> implements ElementMetadata<D, E> {
    private static final ElementValidator DEFAULT_VALIDATOR;
    private final AdaptationRegistry adaptations;
    private final ImmutableMap<QName, AttributeKey<?>> attributes;
    private final Cardinality cardinality;
    private final ElementKey<D, E> elemKey;
    private final ImmutableMap<QName, ElementKey<?, ?>> elements;
    private final boolean isContentRequired;
    private final boolean isFlattened;
    private final Object properties;
    private Collection<XmlNamespace> referencedNamespaces;
    private final ImmutableMap<QName, AttributeKey<?>> renamedAttributes;
    private final ImmutableMap<QName, ElementKey<?, ?>> renamedElements;
    private final ElementKey<D, E> sourceKey;
    private final ElementValidator validator;
    private final VirtualElementHolder virtualElementHolder;

    static {
        DEFAULT_VALIDATOR = new MetadataValidator();
    }

    ElementMetadataImpl(Schema schema, ElementTransform transform, ElementKey<?, ?> parent, ElementKey<D, E> key, MetadataContext context) {
        super(schema, transform, parent, key, context);
        this.referencedNamespaces = null;
        this.elemKey = key;
        TransformKey transformSource = transform.getSource();
        if (transformSource != null) {
            ElementKey<D, E> transformSourceKey = ElementKey.of(transformSource.getKey().getId(), key.getDatatype(), key.getElementType());
            if (transformSourceKey.equals(this.elemKey)) {
                this.sourceKey = this.elemKey;
            } else {
                this.sourceKey = transformSourceKey;
            }
        } else {
            this.sourceKey = this.elemKey;
        }
        transform = ElementTransform.mergeSource(schema, key, transform, context);
        this.cardinality = (Cardinality) MetadataImpl.firstNonNull(transform.getCardinality(), Cardinality.SINGLE);
        this.isContentRequired = ((Boolean) MetadataImpl.firstNonNull(transform.getContentRequired(), Boolean.valueOf(true))).booleanValue();
        this.validator = (ElementValidator) MetadataImpl.firstNonNull(transform.getValidator(), DEFAULT_VALIDATOR);
        this.properties = transform.getProperties();
        this.virtualElementHolder = transform.getVirtualElementHolder();
        this.isFlattened = transform.isFlattened();
        this.attributes = getAttributes(transform.getAttributes().values());
        this.renamedAttributes = getRenamedAttributes();
        this.elements = getElements(transform.getElements().values());
        this.renamedElements = getRenamedElements();
        if (transform.getAdaptations().isEmpty()) {
            this.adaptations = null;
        } else {
            this.adaptations = AdaptationRegistryFactory.create(schema, transform);
        }
    }

    private ImmutableMap<QName, AttributeKey<?>> getAttributes(Collection<AttributeInfo> infos) {
        Builder<QName, AttributeKey<?>> builder = ImmutableMap.builder();
        for (AttributeInfo info : infos) {
            builder.put(info.key.getId(), info.key);
        }
        return builder.build();
    }

    private ImmutableMap<QName, AttributeKey<?>> getRenamedAttributes() {
        Builder<QName, AttributeKey<?>> builder = ImmutableMap.builder();
        Iterator i$ = this.attributes.values().iterator();
        while (i$.hasNext()) {
            AttributeKey<?> key = (AttributeKey) i$.next();
            QName boundName = bindAttribute(key).getName();
            if (!boundName.equals(key.getId())) {
                builder.put(boundName, key);
            }
        }
        return builder.build();
    }

    private ImmutableMap<QName, ElementKey<?, ?>> getElements(Collection<ElementInfo> infos) {
        Builder<QName, ElementKey<?, ?>> builder = ImmutableMap.builder();
        for (ElementInfo info : infos) {
            builder.put(info.key.getId(), info.key);
        }
        return builder.build();
    }

    private ImmutableMap<QName, ElementKey<?, ?>> getRenamedElements() {
        Map<QName, ElementKey<?, ?>> renamed = Maps.newLinkedHashMap();
        Iterator i$ = this.elements.values().iterator();
        while (i$.hasNext()) {
            ElementKey key = (ElementKey) i$.next();
            QName childName = this.schema.getTransform(this.sourceKey, key, this.context).getName();
            if (!(childName == null || childName.equals(key.getId()) || renamed.containsKey(childName))) {
                renamed.put(childName, key);
            }
        }
        return ImmutableMap.copyOf(renamed);
    }

    public ElementKey<?, ?> adapt(String kind) {
        return this.adaptations != null ? this.adaptations.getAdaptation(kind) : null;
    }

    public boolean isDeclared(AttributeKey<?> key) {
        return this.attributes.containsKey(key.getId());
    }

    public AttributeKey<?> findAttribute(QName id) {
        AttributeKey<?> attKey;
        if (!this.renamedAttributes.isEmpty()) {
            attKey = (AttributeKey) this.renamedAttributes.get(id);
            if (attKey != null) {
                return attKey;
            }
        }
        if (!this.attributes.isEmpty()) {
            attKey = (AttributeKey) this.attributes.get(id);
            if (attKey != null) {
                return attKey;
            }
            if (id.matchesAnyNamespace()) {
                Iterator i$ = this.attributes.entrySet().iterator();
                while (i$.hasNext()) {
                    Entry<QName, AttributeKey<?>> attrEntry = (Entry) i$.next();
                    if (id.matches((QName) attrEntry.getKey())) {
                        return (AttributeKey) attrEntry.getValue();
                    }
                }
            } else if (!id.matchesAnyLocalName()) {
                attKey = (AttributeKey) this.attributes.get(toWildcardLocalName(id));
                if (attKey != null) {
                    return AttributeKey.of(id, attKey.getDatatype());
                }
            }
        }
        if (this.adaptations != null) {
            attKey = this.adaptations.findAttribute(id);
            if (attKey != null) {
                return attKey;
            }
        }
        return null;
    }

    public boolean isDeclared(ElementKey<?, ?> element) {
        return this.elements.containsKey(element.getId());
    }

    public ElementKey<?, ?> findElement(QName id) {
        ElementKey<?, ?> childKey;
        if (!this.renamedElements.isEmpty()) {
            childKey = (ElementKey) this.renamedElements.get(id);
            if (childKey != null) {
                return childKey;
            }
        }
        if (!this.elements.isEmpty()) {
            childKey = (ElementKey) this.elements.get(id);
            if (childKey != null) {
                return childKey;
            }
            if (id.matchesAnyNamespace()) {
                Iterator i$ = this.elements.entrySet().iterator();
                while (i$.hasNext()) {
                    Entry<QName, ElementKey<?, ?>> elemEntry = (Entry) i$.next();
                    if (id.matches((QName) elemEntry.getKey())) {
                        return (ElementKey) elemEntry.getValue();
                    }
                }
            } else if (!id.matchesAnyLocalName()) {
                childKey = (ElementKey) this.elements.get(toWildcardLocalName(id));
                if (childKey != null) {
                    return ElementKey.of(id, childKey.getDatatype(), childKey.getElementType());
                }
            }
        }
        if (this.adaptations != null) {
            childKey = this.adaptations.findElement(id);
            if (childKey != null) {
                return childKey;
            }
        }
        return null;
    }

    public ElementMetadata<D, E> bind(MetadataContext context) {
        return this.schema.bind(this.parent, this.elemKey, context);
    }

    public ElementKey<D, E> getKey() {
        return this.elemKey;
    }

    public Cardinality getCardinality() {
        return this.cardinality;
    }

    public boolean isContentRequired() {
        return this.isContentRequired;
    }

    public boolean isReferenced() {
        return isVisible();
    }

    public boolean isSelected(Element e) {
        return isVisible();
    }

    public boolean isFlattened() {
        return this.isFlattened;
    }

    public Object getProperties() {
        return this.properties;
    }

    public ElementValidator getValidator() {
        return this.validator;
    }

    public void validate(ValidationContext vc, Element e) {
        if (this.validator != null) {
            this.validator.validate(vc, e, this);
        }
    }

    public Iterator<Attribute> getAttributeIterator(Element element) {
        return element.getAttributeIterator(this);
    }

    public ImmutableCollection<AttributeKey<?>> getAttributes() {
        return this.attributes.values();
    }

    public <K> AttributeMetadata<K> bindAttribute(AttributeKey<K> key) {
        return this.schema.bind(this.sourceKey, (AttributeKey) key, this.context);
    }

    public Iterator<Element> getElementIterator(Element element) {
        return element.getElementIterator(this);
    }

    public ImmutableCollection<ElementKey<?, ?>> getElements() {
        return this.elements.values();
    }

    public <K, L extends Element> ElementMetadata<K, L> bindElement(ElementKey<K, L> key) {
        return this.schema.bind(this.sourceKey, (ElementKey) key, this.context);
    }

    public Object generateValue(Element element, ElementMetadata<?, ?> metadata) {
        Object result = super.generateValue(element, metadata);
        if (result == null) {
            return element.getTextValue(this.elemKey);
        }
        return result;
    }

    public void parseValue(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        if (!super.parse(element, metadata, value)) {
            element.setTextValue(ObjectConverter.getValue(value, this.elemKey.getDatatype()));
        }
    }

    public SingleVirtualElement getSingleVirtualElement() {
        if (this.cardinality == Cardinality.SINGLE && this.virtualElementHolder != null) {
            return this.virtualElementHolder.getSingleVirtualElement();
        }
        return null;
    }

    public MultipleVirtualElement getMultipleVirtualElement() {
        if (this.cardinality == Cardinality.SINGLE || this.virtualElementHolder == null) {
            return null;
        }
        return this.virtualElementHolder.getMultipleVirtualElement();
    }

    public E createElement() throws ContentCreationException {
        return Element.createElement(this.elemKey);
    }

    public XmlNamespace getDefaultNamespace() {
        return getName().getNs();
    }

    public Collection<XmlNamespace> getReferencedNamespaces() {
        if (this.referencedNamespaces == null) {
            ImmutableSet.Builder<XmlNamespace> builder = ImmutableSet.builder();
            addReferencedNamespaces(this, builder, Sets.newHashSet());
            this.referencedNamespaces = builder.build();
        }
        return this.referencedNamespaces;
    }

    private static void addReferencedNamespaces(ElementMetadata<?, ?> metadata, ImmutableSet.Builder<XmlNamespace> builder, Set<ElementKey<?, ?>> added) {
        if (!added.contains(metadata.getKey())) {
            added.add(metadata.getKey());
            Object elemNs = metadata.getName().getNs();
            if (elemNs != null) {
                builder.add(elemNs);
            }
            for (AttributeKey<?> attrKey : metadata.getAttributes()) {
                Object attrNs = metadata.bindAttribute(attrKey).getName().getNs();
                if (attrNs != null) {
                    builder.add(attrNs);
                }
            }
            for (ElementKey<?, ?> elemKey : metadata.getElements()) {
                addReferencedNamespaces(metadata.bindElement(elemKey), builder, added);
            }
        }
    }

    private QName toWildcardLocalName(QName id) {
        return new QName(id.getNs(), QName.ANY_LOCALNAME);
    }
}
