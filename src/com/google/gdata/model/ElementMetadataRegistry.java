package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

final class ElementMetadataRegistry {
    private final ConcurrentMap<TransformKey, ElementMetadata<?, ?>> cache;
    private final Schema schema;
    private final Map<TransformKey, ElementTransform> transforms;

    ElementMetadataRegistry(Schema schema, ElementMetadataRegistryBuilder elementBuilder) {
        this.cache = new MapMaker().makeMap();
        this.schema = schema;
        this.transforms = getTransforms(elementBuilder);
    }

    private Map<TransformKey, ElementTransform> getTransforms(ElementMetadataRegistryBuilder elementBuilder) {
        Builder<TransformKey, ElementTransform> builder = ImmutableMap.builder();
        for (Entry<TransformKey, ElementCreatorImpl> entry : elementBuilder.getCreators().entrySet()) {
            builder.put(entry.getKey(), ((ElementCreatorImpl) entry.getValue()).toTransform());
        }
        return builder.build();
    }

    <D, E extends Element> ElementMetadata<D, E> bind(ElementKey<?, ?> parent, ElementKey<D, E> key, MetadataContext context) {
        TransformKey transformKey = TransformKey.forTransform(parent, key, context);
        ElementMetadata<D, E> transformed = (ElementMetadata) this.cache.get(transformKey);
        if (transformed != null) {
            return transformed;
        }
        transformed = getTransform(transformKey, key).toMetadata(this.schema, parent, key, context);
        ElementMetadata<D, E> previous = (ElementMetadata) this.cache.putIfAbsent(transformKey, transformed);
        if (previous != null) {
            return previous;
        }
        return transformed;
    }

    ElementTransform getTransform(ElementKey<?, ?> parent, ElementKey<?, ?> key, MetadataContext context) {
        return getTransform(TransformKey.forTransform(parent, key, context), key);
    }

    private ElementTransform getTransform(TransformKey transformKey, ElementKey<?, ?> key) {
        List<ElementTransform> matched = Lists.newArrayList();
        for (Entry<TransformKey, ElementTransform> entry : this.transforms.entrySet()) {
            if (((TransformKey) entry.getKey()).matches(transformKey)) {
                matched.add(entry.getValue());
            }
        }
        switch (matched.size()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return ElementTransform.EMPTY;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return (ElementTransform) matched.get(0);
            default:
                return ElementTransform.create(key, matched);
        }
    }
}
