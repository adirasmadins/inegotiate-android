package com.google.gdata.model;

public interface AttributeMetadata<D> extends Metadata<D> {
    AttributeMetadata<D> bind(MetadataContext metadataContext);

    AttributeKey<D> getKey();
}
