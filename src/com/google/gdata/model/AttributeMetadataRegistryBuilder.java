package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

final class AttributeMetadataRegistryBuilder {
    private final SortedMap<TransformKey, AttributeCreatorImpl> creators;
    private final MetadataRegistry root;

    AttributeMetadataRegistryBuilder(MetadataRegistry root) {
        this.creators = Maps.newTreeMap();
        this.root = root;
    }

    void merge(AttributeMetadataRegistryBuilder other) {
        for (Entry<TransformKey, AttributeCreatorImpl> entry : other.creators.entrySet()) {
            TransformKey key = (TransformKey) entry.getKey();
            AttributeCreatorImpl creator = (AttributeCreatorImpl) this.creators.get(key);
            if (creator == null) {
                creator = new AttributeCreatorImpl(this.root, key);
                this.creators.put(key, creator);
            }
            creator.merge((MetadataCreatorImpl) entry.getValue());
        }
    }

    AttributeMetadataRegistry create(Schema schema) {
        return new AttributeMetadataRegistry(schema, this);
    }

    AttributeCreatorImpl build(ElementKey<?, ?> parent, AttributeKey<?> key, MetadataContext context) {
        AttributeCreatorImpl creator;
        Preconditions.checkNotNull(parent, "parent");
        Preconditions.checkNotNull(key, "key");
        TransformKey transformKey = TransformKey.forTransform(parent, key, context);
        synchronized (this.root) {
            creator = (AttributeCreatorImpl) this.creators.get(transformKey);
            if (creator == null) {
                creator = new AttributeCreatorImpl(this.root, transformKey);
                this.creators.put(transformKey, creator);
                this.root.dirty();
            }
        }
        return creator;
    }

    Map<TransformKey, AttributeCreatorImpl> getCreators() {
        return ImmutableMap.copyOf(this.creators);
    }
}
