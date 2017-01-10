package com.google.gdata.model;

import com.google.common.collect.Lists;
import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.util.ParseException;
import java.util.List;

public class MetadataValueTransform implements VirtualValue {
    private final List<MetadataKey<?>> sources;

    public MetadataValueTransform(MetadataKey<?>... inputSources) {
        this.sources = Lists.newArrayList((Object[]) inputSources);
    }

    public Object generate(Element element, ElementMetadata<?, ?> metadata) {
        for (MetadataKey<?> source : this.sources) {
            Object value;
            if (source instanceof ElementKey) {
                ElementKey childKey = (ElementKey) source;
                Element child = element.getElement(childKey);
                if (child == null) {
                    continue;
                } else {
                    ElementMetadata<?, ?> childMeta = metadata == null ? null : metadata.bindElement(childKey);
                    value = childMeta == null ? child.getTextValue() : childMeta.generateValue(child, childMeta);
                    if (value != null) {
                        return value;
                    }
                }
            } else {
                AttributeKey attKey = (AttributeKey) source;
                AttributeMetadata<?> attMeta = metadata == null ? null : metadata.bindAttribute(attKey);
                value = attMeta == null ? element.getAttributeValue(attKey) : attMeta.generateValue(element, metadata);
                if (value != null) {
                    return value;
                }
            }
        }
        return null;
    }

    public void parse(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        if (!this.sources.isEmpty()) {
            MetadataKey<?> source = (MetadataKey) this.sources.get(0);
            if (source instanceof ElementKey) {
                ElementKey childKey = (ElementKey) source;
                ElementMetadata<?, ?> childMeta = metadata.bindElement(childKey);
                Element child = element.getElement(childKey);
                if (child == null) {
                    try {
                        child = childMeta.createElement();
                        element.addElement(childKey, child);
                    } catch (Throwable e) {
                        throw new ParseException(e);
                    }
                }
                childMeta.parseValue(child, childMeta, value);
                return;
            }
            metadata.bindAttribute((AttributeKey) source).parseValue(element, metadata, value);
        }
    }
}
