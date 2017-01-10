package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

final class AttributeMetadataRegistry {
    private final ConcurrentMap<TransformKey, AttributeMetadata<?>> cache;
    private final Schema schema;
    private final Map<TransformKey, AttributeTransform> transforms;

    AttributeMetadataRegistry(Schema schema, AttributeMetadataRegistryBuilder builder) {
        this.cache = new MapMaker().makeMap();
        this.schema = schema;
        this.transforms = getTransforms(builder.getCreators());
    }

    private Map<TransformKey, AttributeTransform> getTransforms(Map<TransformKey, AttributeCreatorImpl> map) {
        Builder<TransformKey, AttributeTransform> builder = ImmutableMap.builder();
        for (Entry<TransformKey, AttributeCreatorImpl> entry : map.entrySet()) {
            builder.put(entry.getKey(), ((AttributeCreatorImpl) entry.getValue()).toTransform());
        }
        return builder.build();
    }

    <D> AttributeMetadata<D> bind(ElementKey<?, ?> parent, AttributeKey<D> key, MetadataContext context) {
        Preconditions.checkNotNull(parent, "parent");
        Preconditions.checkNotNull(key, "key");
        TransformKey transformKey = TransformKey.forTransform(parent, key, context);
        AttributeMetadata<D> transformed = (AttributeMetadata) this.cache.get(transformKey);
        if (transformed != null) {
            return transformed;
        }
        transformed = getTransform(transformKey, key).toMetadata(this.schema, parent, key, context);
        AttributeMetadata<D> previous = (AttributeMetadata) this.cache.putIfAbsent(transformKey, transformed);
        if (previous != null) {
            return previous;
        }
        return transformed;
    }

    AttributeTransform getTransform(ElementKey<?, ?> parent, AttributeKey<?> key, MetadataContext context) {
        return getTransform(TransformKey.forTransform(parent, key, context), key);
    }

    private AttributeTransform getTransform(TransformKey transformKey, AttributeKey<?> attributeKey) {
        Iterable matched = Lists.newArrayList();
        for (Entry<TransformKey, AttributeTransform> entry : this.transforms.entrySet()) {
            if (((TransformKey) entry.getKey()).matches(transformKey)) {
                matched.add(entry.getValue());
            }
        }
        switch (matched.size()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                return AttributeTransform.EMPTY;
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return (AttributeTransform) matched.get(0);
            default:
                return AttributeTransform.create(matched);
        }
    }
}
