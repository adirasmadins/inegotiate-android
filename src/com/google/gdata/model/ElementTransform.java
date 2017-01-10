package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gdata.model.ElementMetadata.Cardinality;
import java.util.Map;
import java.util.Map.Entry;

final class ElementTransform extends Transform {
    static final ElementTransform EMPTY;
    private final Map<String, ElementKey<?, ?>> adaptations;
    private final Map<QName, AttributeInfo> attributes;
    private final Cardinality cardinality;
    private final Boolean contentRequired;
    private final Map<QName, ElementInfo> elements;
    private final boolean flattened;
    private final Object properties;
    private final ElementValidator validator;
    private final VirtualElementHolder virtualElementHolder;

    static {
        EMPTY = new ElementTransform();
    }

    static ElementTransform create(ElementCreatorImpl creator) {
        ElementTransform transform = new ElementTransform(creator);
        if (transform.isEmpty()) {
            return EMPTY;
        }
        return transform;
    }

    static ElementTransform create(ElementKey<?, ?> key, Iterable<ElementTransform> parts) {
        ElementTransform composite = new ElementTransform(key, parts);
        if (composite.isEmpty()) {
            return EMPTY;
        }
        return composite;
    }

    static ElementTransform mergeSource(Schema schema, ElementKey<?, ?> key, ElementTransform transform, MetadataContext context) {
        TransformKey sourceKey = transform.getSource();
        if (sourceKey == null) {
            return transform;
        }
        ElementTransform source = schema.getTransform(sourceKey.getParent(), (ElementKey) sourceKey.getKey(), context);
        if (source != null) {
            return new ElementTransform(key, transform, source);
        }
        return transform;
    }

    private ElementTransform() {
        this.cardinality = null;
        this.contentRequired = null;
        this.validator = null;
        this.properties = null;
        this.virtualElementHolder = null;
        this.flattened = false;
        this.attributes = ImmutableMap.of();
        this.elements = ImmutableMap.of();
        this.adaptations = ImmutableMap.of();
    }

    private ElementTransform(ElementCreatorImpl builder) {
        super((MetadataCreatorImpl) builder);
        this.cardinality = builder.getCardinality();
        this.contentRequired = builder.getContentRequired();
        this.validator = builder.getValidator();
        this.properties = builder.getProperties();
        this.virtualElementHolder = builder.getVirtualElementHolder();
        this.flattened = builder.isFlattened();
        this.attributes = ImmutableMap.copyOf(builder.getAttributes());
        this.elements = ImmutableMap.copyOf(builder.getElements());
        this.adaptations = ImmutableMap.copyOf(builder.getAdaptations());
    }

    private ElementTransform(ElementKey<?, ?> key, Iterable<ElementTransform> parts) {
        super((Iterable) parts);
        Cardinality compositeCardinality = null;
        Boolean compositeContentRequired = null;
        ElementValidator compositeValidator = null;
        Object compositeProperties = null;
        VirtualElementHolder compositeVirtualElementHolder = null;
        boolean compositeFlattened = false;
        Map<QName, AttributeInfo> compositeAttributes = Maps.newLinkedHashMap();
        Map<QName, ElementInfo> compositeElements = Maps.newLinkedHashMap();
        Map<String, ElementKey<?, ?>> compositeAdaptors = Maps.newLinkedHashMap();
        for (ElementTransform part : parts) {
            if (part.cardinality != null) {
                compositeCardinality = part.cardinality;
            }
            if (part.contentRequired != null) {
                compositeContentRequired = part.contentRequired;
            }
            if (part.validator != null) {
                compositeValidator = part.validator;
            }
            if (part.properties != null) {
                compositeProperties = part.properties;
            }
            if (part.virtualElementHolder != null) {
                compositeVirtualElementHolder = part.virtualElementHolder;
            }
            if (part.flattened) {
                compositeFlattened = true;
            }
            for (Entry<QName, AttributeInfo> entry : part.attributes.entrySet()) {
                QName attId = (QName) entry.getKey();
                AttributeInfo attInfo = (AttributeInfo) entry.getValue();
                if (attInfo.action == Action.ADD) {
                    compositeAttributes.remove(attId);
                }
                compositeAttributes.put(attId, attInfo);
            }
            for (Entry<QName, ElementInfo> entry2 : part.elements.entrySet()) {
                QName childId = (QName) entry2.getKey();
                ElementInfo childInfo = (ElementInfo) entry2.getValue();
                if (childInfo.action == Action.ADD) {
                    compositeElements.remove(childId);
                }
                compositeElements.put(childId, childInfo);
            }
            for (Entry<String, ElementKey<?, ?>> entry3 : part.adaptations.entrySet()) {
                ElementKey<?, ?> adaptor = (ElementKey) entry3.getValue();
                if (isValidAdaptation(key, adaptor)) {
                    compositeAdaptors.put(entry3.getKey(), adaptor);
                }
            }
        }
        this.cardinality = compositeCardinality;
        this.contentRequired = compositeContentRequired;
        this.validator = compositeValidator;
        this.properties = compositeProperties;
        this.virtualElementHolder = compositeVirtualElementHolder;
        this.flattened = compositeFlattened;
        this.attributes = ImmutableMap.copyOf(compositeAttributes);
        this.elements = ImmutableMap.copyOf(compositeElements);
        this.adaptations = ImmutableMap.copyOf(compositeAdaptors);
    }

    private ElementTransform(ElementKey<?, ?> key, ElementTransform transform, ElementTransform source) {
        super(transform, source);
        r14 = new Cardinality[2];
        r14[0] = transform.cardinality;
        r14[1] = source.cardinality;
        this.cardinality = (Cardinality) Transform.first(r14);
        this.contentRequired = transform.contentRequired;
        r14 = new ElementValidator[2];
        r14[0] = transform.validator;
        r14[1] = source.validator;
        this.validator = (ElementValidator) Transform.first(r14);
        r14 = new Object[2];
        r14[0] = transform.properties;
        r14[1] = source.properties;
        this.properties = Transform.first(r14);
        r14 = new VirtualElementHolder[2];
        r14[0] = transform.virtualElementHolder;
        r14[1] = source.virtualElementHolder;
        this.virtualElementHolder = (VirtualElementHolder) Transform.first(r14);
        boolean z = transform.isFlattened() || source.isFlattened();
        this.flattened = z;
        Map<QName, AttributeInfo> compositeAttributes = Maps.newLinkedHashMap();
        compositeAttributes.putAll(source.getAttributes());
        for (Entry<QName, AttributeInfo> entry : transform.attributes.entrySet()) {
            if (!compositeAttributes.containsKey((QName) entry.getKey())) {
                compositeAttributes.put(entry.getKey(), entry.getValue());
            }
        }
        this.attributes = ImmutableMap.copyOf(compositeAttributes);
        Map<QName, ElementInfo> compositeElements = Maps.newLinkedHashMap();
        compositeElements.putAll(source.getElements());
        for (Entry<QName, ElementInfo> entry2 : transform.elements.entrySet()) {
            QName childId = (QName) entry2.getKey();
            if (!compositeElements.containsKey(childId)) {
                compositeElements.put(childId, entry2.getValue());
            }
        }
        this.elements = ImmutableMap.copyOf(compositeElements);
        Map<String, ElementKey<?, ?>> compositeAdaptors = Maps.newLinkedHashMap();
        compositeAdaptors.putAll(source.getAdaptations());
        for (Entry<String, ElementKey<?, ?>> entry3 : transform.adaptations.entrySet()) {
            String kind = (String) entry3.getKey();
            ElementKey<?, ?> adaptor = (ElementKey) entry3.getValue();
            if (!compositeAdaptors.containsKey(kind) && isValidAdaptation(key, adaptor)) {
                compositeAdaptors.put(kind, adaptor);
            }
        }
        this.adaptations = ImmutableMap.copyOf(compositeAdaptors);
    }

    private static boolean isValidAdaptation(ElementKey<?, ?> source, ElementKey<?, ?> adaptor) {
        Class<?> sourceType = source.getElementType();
        Class<?> adaptorType = adaptor.getElementType();
        if (sourceType == adaptorType) {
            return false;
        }
        return sourceType.isAssignableFrom(adaptorType);
    }

    <D, E extends Element> ElementMetadata<D, E> toMetadata(Schema schema, ElementKey<?, ?> parent, ElementKey<D, E> key, MetadataContext context) {
        return new ElementMetadataImpl(schema, this, parent, key, context);
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
        return this.attributes;
    }

    Map<QName, ElementInfo> getElements() {
        return this.elements;
    }

    Map<String, ElementKey<?, ?>> getAdaptations() {
        return this.adaptations;
    }

    boolean isEmpty() {
        return super.isEmpty() && this.cardinality == null && this.contentRequired == null && this.validator == null && this.properties == null && this.virtualElementHolder == null && !this.flattened && this.attributes.isEmpty() && this.elements.isEmpty() && this.adaptations.isEmpty();
    }
}
