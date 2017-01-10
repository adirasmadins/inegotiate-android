package com.google.gdata.model;

final class AttributeTransform extends Transform {
    static final AttributeTransform EMPTY;

    static {
        EMPTY = new AttributeTransform();
    }

    static AttributeTransform create(AttributeCreatorImpl creator) {
        AttributeTransform transform = new AttributeTransform(creator);
        if (transform.isEmpty()) {
            return EMPTY;
        }
        return transform;
    }

    static AttributeTransform create(Iterable<AttributeTransform> parts) {
        AttributeTransform composite = new AttributeTransform((Iterable) parts);
        if (composite.isEmpty()) {
            return EMPTY;
        }
        return composite;
    }

    static Transform mergeSource(Schema schema, Transform transform, MetadataContext context) {
        TransformKey sourceKey = transform.getSource();
        if (sourceKey == null) {
            return transform;
        }
        Transform source = schema.getTransform(sourceKey.getParent(), sourceKey.getKey(), context);
        if (source != null) {
            return new AttributeTransform(transform, source);
        }
        return transform;
    }

    private AttributeTransform() {
    }

    private AttributeTransform(AttributeCreatorImpl creator) {
        super((MetadataCreatorImpl) creator);
    }

    private AttributeTransform(Iterable<AttributeTransform> parts) {
        super((Iterable) parts);
    }

    private AttributeTransform(Transform transform, Transform source) {
        super(transform, source);
    }

    <D> AttributeMetadata<D> toMetadata(Schema schema, ElementKey<?, ?> parent, AttributeKey<D> key, MetadataContext context) {
        return new AttributeMetadataImpl(schema, this, parent, key, context);
    }
}
