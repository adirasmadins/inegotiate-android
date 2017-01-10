package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.gdata.util.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;

public final class Schema {
    private final Map<RootKey, AttributeMetadataRegistry> attributes;
    private final Map<RootKey, ElementMetadataRegistry> elements;

    static class RootKey {
        private final QName id;
        private final Class<?> type;

        private static RootKey get(ElementKey<?, ?> key) {
            QName id = key.getId();
            Class elementType = key.getElementType();
            if (elementType == Element.class) {
                return new RootKey(getRootId(id));
            }
            Class<? extends Element> superClass = getSuper(elementType);
            while (superClass != Element.class) {
                Class<? extends Element> elementType2 = superClass;
                superClass = getSuper(elementType2);
            }
            return new RootKey(elementType);
        }

        private static RootKey get(AttributeKey<?> key) {
            return new RootKey(getRootId(key.getId()));
        }

        private static QName getRootId(QName id) {
            if (id.getNs() == null || QName.ANY_LOCALNAME.equals(id.getLocalName())) {
                return id;
            }
            return new QName(id.getNs(), QName.ANY_LOCALNAME);
        }

        private static Class<? extends Element> getSuper(Class<? extends Element> type) {
            return type.getSuperclass().asSubclass(Element.class);
        }

        private RootKey(QName id) {
            Preconditions.checkNotNull(id);
            this.id = id;
            this.type = null;
        }

        private RootKey(Class<?> type) {
            Preconditions.checkNotNull(type);
            this.id = null;
            this.type = type;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RootKey)) {
                return false;
            }
            RootKey other = (RootKey) obj;
            if (this.type == null) {
                return this.id.equals(other.id);
            }
            if (this.type != other.type) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (this.type != null) {
                return this.type.hashCode();
            }
            return this.id.hashCode();
        }

        public String toString() {
            return this.type == null ? "{Root (" + this.id + ")}" : "{Root (" + this.type + ")}";
        }
    }

    public static MetadataRegistry builder() {
        return new MetadataRegistry();
    }

    static RootKey getRootKey(ElementKey<?, ?> key) {
        return RootKey.get((ElementKey) key);
    }

    static RootKey getRootKey(AttributeKey<?> key) {
        return RootKey.get((AttributeKey) key);
    }

    Schema(MetadataRegistry registry) {
        this.elements = buildElements(registry, this);
        this.attributes = buildAttributes(registry, this);
    }

    private static ImmutableMap<RootKey, AttributeMetadataRegistry> buildAttributes(MetadataRegistry registry, Schema schema) {
        Builder<RootKey, AttributeMetadataRegistry> attributeBuilder = ImmutableMap.builder();
        for (Entry<RootKey, AttributeMetadataRegistryBuilder> entry : registry.getAttributes().entrySet()) {
            attributeBuilder.put(entry.getKey(), ((AttributeMetadataRegistryBuilder) entry.getValue()).create(schema));
        }
        return attributeBuilder.build();
    }

    private static ImmutableMap<RootKey, ElementMetadataRegistry> buildElements(MetadataRegistry registry, Schema schema) {
        Builder<RootKey, ElementMetadataRegistry> elementBuilder = ImmutableMap.builder();
        for (Entry<RootKey, ElementMetadataRegistryBuilder> entry : registry.getElements().entrySet()) {
            elementBuilder.put(entry.getKey(), ((ElementMetadataRegistryBuilder) entry.getValue()).create(schema));
        }
        return elementBuilder.build();
    }

    public <D, E extends Element> ElementMetadata<D, E> bind(ElementKey<D, E> key) {
        return bind(null, (ElementKey) key, null);
    }

    public <D, E extends Element> ElementMetadata<D, E> bind(ElementKey<D, E> key, MetadataContext context) {
        return bind(null, (ElementKey) key, context);
    }

    public <D, E extends Element> ElementMetadata<D, E> bind(ElementKey<?, ?> parent, ElementKey<D, E> child) {
        return bind((ElementKey) parent, (ElementKey) child, null);
    }

    public <D, E extends Element> ElementMetadata<D, E> bind(ElementKey<?, ?> parent, ElementKey<D, E> child, MetadataContext context) {
        ElementMetadataRegistry childRegistry = getElement(child);
        return childRegistry == null ? null : childRegistry.bind(parent, child, context);
    }

    Transform getTransform(ElementKey<?, ?> parent, MetadataKey<?> key, MetadataContext context) {
        if (key instanceof AttributeKey) {
            return getTransform((ElementKey) parent, (AttributeKey) key, context);
        }
        return getTransform((ElementKey) parent, (ElementKey) key, context);
    }

    AttributeTransform getTransform(ElementKey<?, ?> parent, AttributeKey<?> attribute, MetadataContext context) {
        AttributeMetadataRegistry attributeRegistry = getAttribute(attribute);
        return attributeRegistry == null ? null : attributeRegistry.getTransform(parent, attribute, context);
    }

    ElementTransform getTransform(ElementKey<?, ?> parent, ElementKey<?, ?> child, MetadataContext context) {
        ElementMetadataRegistry childRegistry = getElement(child);
        return childRegistry == null ? null : childRegistry.getTransform(parent, child, context);
    }

    private ElementMetadataRegistry getElement(ElementKey<?, ?> key) {
        return (ElementMetadataRegistry) this.elements.get(getRootKey((ElementKey) key));
    }

    public <D> AttributeMetadata<D> bind(ElementKey<?, ?> parent, AttributeKey<D> attribute) {
        return bind((ElementKey) parent, (AttributeKey) attribute, null);
    }

    public <D> AttributeMetadata<D> bind(ElementKey<?, ?> parent, AttributeKey<D> attribute, MetadataContext context) {
        AttributeMetadataRegistry attRegistry = getAttribute(attribute);
        return attRegistry == null ? null : attRegistry.bind(parent, attribute, context);
    }

    private AttributeMetadataRegistry getAttribute(AttributeKey<?> key) {
        return (AttributeMetadataRegistry) this.attributes.get(getRootKey((AttributeKey) key));
    }
}
