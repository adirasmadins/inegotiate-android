package com.google.gdata.model;

import com.google.gdata.util.ParseException;

public interface Metadata<D> {

    public interface VirtualValue {
        Object generate(Element element, ElementMetadata<?, ?> elementMetadata);

        void parse(Element element, ElementMetadata<?, ?> elementMetadata, Object obj) throws ParseException;
    }

    Object generateValue(Element element, ElementMetadata<?, ?> elementMetadata);

    MetadataContext getContext();

    MetadataKey<D> getKey();

    QName getName();

    ElementKey<?, ?> getParent();

    Schema getSchema();

    boolean isRequired();

    boolean isVisible();

    void parseValue(Element element, ElementMetadata<?, ?> elementMetadata, Object obj) throws ParseException;
}
