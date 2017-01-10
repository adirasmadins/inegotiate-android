package com.google.gdata.model;

import com.google.gdata.util.ParseException;
import com.google.gdata.wireformats.ObjectConverter;

final class AttributeMetadataImpl<D> extends MetadataImpl<D> implements AttributeMetadata<D> {
    private final AttributeKey<D> attKey;

    AttributeMetadataImpl(Schema schema, AttributeTransform transform, ElementKey<?, ?> parent, AttributeKey<D> key, MetadataContext context) {
        super(schema, transform, parent, key, context);
        this.attKey = key;
    }

    public AttributeMetadata<D> bind(MetadataContext context) {
        return this.schema.bind(this.parent, this.attKey, context);
    }

    public AttributeKey<D> getKey() {
        return this.attKey;
    }

    public Object generateValue(Element element, ElementMetadata<?, ?> metadata) {
        Object result = super.generateValue(element, metadata);
        if (result == null) {
            return element.getAttributeValue(this.attKey);
        }
        return result;
    }

    public void parseValue(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        if (!super.parse(element, metadata, value)) {
            element.setAttributeValue(this.attKey, ObjectConverter.getValue(value, this.attKey.getDatatype()));
        }
    }
}
