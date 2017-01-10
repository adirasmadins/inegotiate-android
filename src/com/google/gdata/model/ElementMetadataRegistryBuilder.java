package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;

final class ElementMetadataRegistryBuilder {
    private final Map<TransformKey, ElementCreatorImpl> creators;
    private final MetadataRegistry root;

    ElementMetadataRegistryBuilder(MetadataRegistry root) {
        this.creators = Maps.newTreeMap();
        this.root = root;
    }

    void merge(ElementMetadataRegistryBuilder other) {
        for (Entry<TransformKey, ElementCreatorImpl> entry : other.creators.entrySet()) {
            TransformKey key = (TransformKey) entry.getKey();
            ElementCreatorImpl creator = (ElementCreatorImpl) this.creators.get(key);
            if (creator == null) {
                creator = new ElementCreatorImpl(this.root, key);
                this.creators.put(key, creator);
            }
            creator.merge((ElementCreatorImpl) entry.getValue());
        }
    }

    ElementMetadataRegistry create(Schema schema) {
        return new ElementMetadataRegistry(schema, this);
    }

    boolean isRegistered(ElementKey<?, ?> parent, ElementKey<?, ?> key, MetadataContext context) {
        Preconditions.checkNotNull(key, "key");
        return this.creators.containsKey(TransformKey.forTransform(parent, key, context));
    }

    ElementCreatorImpl build(ElementKey<?, ?> parent, ElementKey<?, ?> key, MetadataContext context) {
        ElementCreatorImpl creator;
        Preconditions.checkNotNull(key, "key");
        TransformKey transformKey = TransformKey.forTransform(parent, key, context);
        synchronized (this.root) {
            creator = (ElementCreatorImpl) this.creators.get(transformKey);
            if (creator == null) {
                creator = new ElementCreatorImpl(this.root, transformKey);
                this.creators.put(transformKey, creator);
                this.root.dirty();
            }
        }
        return creator;
    }

    Map<TransformKey, ElementCreatorImpl> getCreators() {
        return ImmutableMap.copyOf(this.creators);
    }
}
