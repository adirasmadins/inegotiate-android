package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

final class ElementCreatorImpl extends MetadataCreatorImpl implements ElementCreator {
    static final AttributeKey<Void> ATTRIBUTE_MARKER;
    static final ElementKey<Void, Element> ELEMENT_MARKER;
    private static final QName UNDECLARED;
    private final Map<String, ElementKey<?, ?>> adaptations;
    private Set<AttributeKey<?>> attributeWhitelist;
    private final Map<QName, AttributeInfo> attributes;
    private Cardinality cardinality;
    private Boolean contentRequired;
    private final ElementKey<?, ?> elementKey;
    private Set<ElementKey<?, ?>> elementWhitelist;
    private final Map<QName, ElementInfo> elements;
    private boolean flattened;
    private Object properties;
    private ElementValidator validator;
    private VirtualElementHolder virtualElementHolder;

    enum Action {
        ADD,
        REPLACE
    }

    static final class AttributeInfo {
        final Action action;
        final AttributeKey<?> key;

        AttributeInfo(AttributeKey<?> key) {
            this(key, Action.REPLACE);
        }

        AttributeInfo(AttributeKey<?> key, Action action) {
            this.key = key;
            this.action = action;
        }
    }

    static final class ElementInfo {
        final Action action;
        final ElementKey<?, ?> key;

        ElementInfo(ElementKey<?, ?> key) {
            this(key, Action.REPLACE);
        }

        ElementInfo(ElementKey<?, ?> key, Action action) {
            this.key = key;
            this.action = action;
        }
    }

    static {
        UNDECLARED = new QName("**UNDECLARED**");
        ATTRIBUTE_MARKER = AttributeKey.of(UNDECLARED, Void.class);
        ELEMENT_MARKER = ElementKey.of(UNDECLARED, Void.class, Element.class);
    }

    ElementCreatorImpl(MetadataRegistry registry, TransformKey transformKey) {
        super(registry, transformKey);
        this.attributes = Maps.newLinkedHashMap();
        this.elements = Maps.newLinkedHashMap();
        this.adaptations = Maps.newLinkedHashMap();
        MetadataKey<?> key = transformKey.getKey();
        Preconditions.checkArgument(key instanceof ElementKey, "Key must be to an element.");
        this.elementKey = (ElementKey) key;
    }

    void merge(ElementCreatorImpl other) {
        super.merge(other);
        if (other.cardinality != null) {
            this.cardinality = other.cardinality;
        }
        if (other.contentRequired != null) {
            this.contentRequired = other.contentRequired;
        }
        if (other.validator != null) {
            this.validator = other.validator;
        }
        if (other.properties != null) {
            this.properties = other.properties;
        }
        if (other.virtualElementHolder != null) {
            this.virtualElementHolder = other.virtualElementHolder;
        }
        if (other.flattened) {
            this.flattened = true;
        }
        for (AttributeInfo info : other.attributes.values()) {
            addAttribute(info.key, info.action);
        }
        for (ElementInfo info2 : other.elements.values()) {
            addElement(info2.key, info2.action);
        }
        this.adaptations.putAll(other.adaptations);
        if (other.attributeWhitelist != null) {
            whitelistAttributes(other.attributeWhitelist);
        }
        if (other.elementWhitelist != null) {
            whitelistElements(other.elementWhitelist);
        }
    }

    public ElementCreatorImpl adapt(String kind, ElementKey<?, ?> adaptation) {
        synchronized (this.registry) {
            this.adaptations.put(kind, adaptation);
            this.registry.register(adaptation);
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setCardinality(Cardinality cardinality) {
        synchronized (this.registry) {
            this.cardinality = cardinality;
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setContentRequired(boolean contentRequired) {
        synchronized (this.registry) {
            this.contentRequired = Boolean.valueOf(contentRequired);
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setValidator(ElementValidator validator) {
        synchronized (this.registry) {
            this.validator = validator;
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setProperties(Object properties) {
        synchronized (this.registry) {
            this.properties = properties;
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setSingleVirtualElement(SingleVirtualElement singleVirtualElement) {
        synchronized (this.registry) {
            this.virtualElementHolder = VirtualElementHolder.of(singleVirtualElement);
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl setMultipleVirtualElement(MultipleVirtualElement multipleVirtualElement) {
        synchronized (this.registry) {
            this.virtualElementHolder = VirtualElementHolder.of(multipleVirtualElement);
            this.registry.dirty();
        }
        return this;
    }

    void setSource(Path path, TransformKey key) {
        super.setSource(path, key);
        setElementPath(path);
    }

    private void setElementPath(Path path) {
        synchronized (this.registry) {
            this.virtualElementHolder = VirtualElementHolder.of(path);
            this.registry.dirty();
        }
    }

    public ElementCreatorImpl flatten() {
        synchronized (this.registry) {
            this.flattened = true;
            this.registry.dirty();
        }
        return this;
    }

    public AttributeCreator moveAttribute(AttributeKey<?> attKey, Path path) {
        Preconditions.checkArgument(path.selectsAttribute(), "Path must refer to an attribute.");
        AttributeCreatorImpl dest = replaceAttribute((AttributeKey) attKey);
        AttributeCreatorImpl source = getAttributeCreator(path);
        dest.setSource(path, source.getTransformKey());
        source.moved();
        return dest;
    }

    private AttributeCreatorImpl getAttributeCreator(Path path) {
        Preconditions.checkArgument(path.selectsAttribute(), "Must be an attribute path");
        ElementKey parent = path.getParentKey();
        if (parent == null) {
            parent = this.elementKey;
        }
        return (AttributeCreatorImpl) this.registry.build(parent, path.getSelectedAttributeKey(), this.transformKey.getContext());
    }

    public ElementCreator moveElement(ElementKey<?, ?> childKey, Path path) {
        Preconditions.checkArgument(path.selectsElement(), "Path must refer to an element.");
        ElementCreatorImpl dest = replaceElement((ElementKey) childKey);
        ElementCreatorImpl source = getElementCreator(path);
        dest.setSource(path, source.getTransformKey());
        source.moved();
        return dest;
    }

    private ElementCreatorImpl getElementCreator(Path path) {
        Preconditions.checkArgument(path.selectsElement(), "Must be an element path");
        ElementKey parent = path.getParentKey();
        if (parent == null) {
            parent = this.elementKey;
        }
        return (ElementCreatorImpl) this.registry.build(parent, path.getSelectedElementKey(), this.transformKey.getContext());
    }

    public ElementCreatorImpl addUndeclaredAttributeMarker() {
        addAttribute(ATTRIBUTE_MARKER);
        return this;
    }

    public AttributeCreatorImpl addAttribute(AttributeKey<?> attributeKey) {
        return addAttribute(attributeKey, Action.ADD);
    }

    public AttributeCreatorImpl replaceAttribute(AttributeKey<?> attributeKey) {
        return addAttribute(attributeKey, Action.REPLACE);
    }

    public ElementCreatorImpl orderAndWhitelistAttributes(AttributeKey<?>... attributeKeys) {
        for (AttributeKey attributeKey : attributeKeys) {
            addAttribute(attributeKey);
        }
        return whitelistAttributes((AttributeKey[]) attributeKeys);
    }

    public ElementCreatorImpl whitelistAttributes(AttributeKey<?>... attributeKeys) {
        return whitelistAttributes(Lists.newArrayList((Object[]) attributeKeys));
    }

    private ElementCreatorImpl whitelistAttributes(Collection<AttributeKey<?>> attributeKeys) {
        synchronized (this.registry) {
            if (this.attributeWhitelist == null) {
                this.attributeWhitelist = Sets.newHashSet();
            }
            this.attributeWhitelist.addAll(attributeKeys);
            this.registry.dirty();
        }
        return this;
    }

    private AttributeCreatorImpl addAttribute(AttributeKey<?> attributeKey, Action action) {
        AttributeCreatorImpl attributeCreatorImpl;
        synchronized (this.registry) {
            QName id = attributeKey.getId();
            if (action == Action.ADD) {
                this.attributes.remove(id);
            }
            this.attributes.put(id, new AttributeInfo(attributeKey, action));
            attributeCreatorImpl = (AttributeCreatorImpl) this.registry.build(this.elementKey, (AttributeKey) attributeKey, this.transformKey.getContext());
        }
        return attributeCreatorImpl;
    }

    public ElementCreatorImpl addUndeclaredElementMarker() {
        addElement(ELEMENT_MARKER);
        return this;
    }

    public ElementCreatorImpl addElement(ElementKey<?, ?> elementKey) {
        return addElement(elementKey, Action.ADD);
    }

    public ElementCreatorImpl replaceElement(ElementKey<?, ?> elementKey) {
        return addElement(elementKey, Action.REPLACE);
    }

    public ElementCreatorImpl orderAndWhitelistElements(ElementKey<?, ?>... elementKeys) {
        for (ElementKey elementKey : elementKeys) {
            addElement(elementKey);
        }
        return whitelistElements((ElementKey[]) elementKeys);
    }

    public ElementCreatorImpl whitelistElements(ElementKey<?, ?>... elementKeys) {
        return whitelistElements(Lists.newArrayList((Object[]) elementKeys));
    }

    private ElementCreatorImpl whitelistElements(Collection<ElementKey<?, ?>> elementKeys) {
        synchronized (this.registry) {
            if (this.elementWhitelist == null) {
                this.elementWhitelist = Sets.newHashSet();
            }
            this.elementWhitelist.addAll(elementKeys);
            this.registry.dirty();
        }
        return this;
    }

    public ElementCreatorImpl blacklistElements(ElementKey<?, ?>... elementKeys) {
        synchronized (this.registry) {
            for (ElementKey elementKey : elementKeys) {
                addElement(elementKey).setVisible(false);
            }
        }
        return this;
    }

    private ElementCreatorImpl addElement(ElementKey<?, ?> childKey, Action action) {
        ElementCreatorImpl elementCreatorImpl;
        synchronized (this.registry) {
            QName id = childKey.getId();
            Preconditions.checkNotNull(id);
            if (action == Action.ADD) {
                this.elements.remove(id);
            }
            this.elements.put(id, new ElementInfo(childKey, action));
            elementCreatorImpl = (ElementCreatorImpl) this.registry.build(this.elementKey, (ElementKey) childKey, this.transformKey.getContext());
        }
        return elementCreatorImpl;
    }

    public ElementCreatorImpl setName(QName name) {
        return (ElementCreatorImpl) super.setName(name);
    }

    public ElementCreatorImpl setRequired(boolean required) {
        return (ElementCreatorImpl) super.setRequired(required);
    }

    public ElementCreatorImpl setVisible(boolean visible) {
        return (ElementCreatorImpl) super.setVisible(visible);
    }

    public ElementCreatorImpl setVirtualValue(VirtualValue virtualValue) {
        return (ElementCreatorImpl) super.setVirtualValue(virtualValue);
    }

    Cardinality getCardinality() {
        return this.cardinality;
    }

    Boolean getContentRequired() {
        return this.contentRequired;
    }

    ElementValidator getValidator() {
        return this.validator;
    }

    Object getProperties() {
        return this.properties;
    }

    VirtualElementHolder getVirtualElementHolder() {
        return this.virtualElementHolder;
    }

    boolean isFlattened() {
        return this.flattened;
    }

    Map<QName, AttributeInfo> getAttributes() {
        return ImmutableMap.copyOf(this.attributes);
    }

    ImmutableSet<AttributeKey<?>> getAttributeSet() {
        Collection<AttributeInfo> infos = this.attributes.values();
        Builder<AttributeKey<?>> builder = ImmutableSet.builder();
        for (AttributeInfo info : infos) {
            builder.add(info.key);
        }
        return builder.build();
    }

    Map<QName, ElementInfo> getElements() {
        return ImmutableMap.copyOf(this.elements);
    }

    ImmutableSet<ElementKey<?, ?>> getElementSet() {
        Collection<ElementInfo> infos = this.elements.values();
        Builder<ElementKey<?, ?>> builder = ImmutableSet.builder();
        for (ElementInfo info : infos) {
            builder.add(info.key);
        }
        return builder.build();
    }

    Map<String, ElementKey<?, ?>> getAdaptations() {
        return ImmutableMap.copyOf(this.adaptations);
    }

    Set<AttributeKey<?>> getAttributeWhitelist() {
        return this.attributeWhitelist == null ? null : ImmutableSet.copyOf(this.attributeWhitelist);
    }

    Set<ElementKey<?, ?>> getElementWhitelist() {
        return this.elementWhitelist == null ? null : ImmutableSet.copyOf(this.elementWhitelist);
    }

    ElementTransform toTransform() {
        check();
        return ElementTransform.create(this);
    }

    private void check() {
        if (this.virtualElementHolder != null && this.cardinality != null) {
            if (this.cardinality == Cardinality.SINGLE) {
                if (this.virtualElementHolder.getSingleVirtualElement() == null) {
                    throw new IllegalStateException("Invalid element transform. MultipleVirtualElement set on an element with single cardinality for key " + this.elementKey);
                }
            } else if (this.virtualElementHolder.getMultipleVirtualElement() == null) {
                throw new IllegalStateException("Invalid element transform. SingleVirtualElement set on an element with multiple cardinality for key " + this.elementKey);
            }
        }
    }
}
