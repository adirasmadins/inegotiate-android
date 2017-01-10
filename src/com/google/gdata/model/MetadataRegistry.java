package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gdata.util.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MetadataRegistry {
    private final Map<RootKey, AttributeMetadataRegistryBuilder> attributes;
    private volatile Schema cachedSchema;
    private final Map<RootKey, ElementMetadataRegistryBuilder> elements;

    public MetadataRegistry() {
        this.attributes = Maps.newHashMap();
        this.elements = Maps.newHashMap();
    }

    public MetadataRegistry(MetadataRegistry source) {
        this();
        merge(source);
    }

    public synchronized MetadataRegistry merge(MetadataRegistry other) {
        synchronized (other) {
            for (Entry<RootKey, AttributeMetadataRegistryBuilder> entry : other.attributes.entrySet()) {
                RootKey key = (RootKey) entry.getKey();
                AttributeMetadataRegistryBuilder builder = (AttributeMetadataRegistryBuilder) this.attributes.get(key);
                if (builder == null) {
                    builder = new AttributeMetadataRegistryBuilder(this);
                    this.attributes.put(key, builder);
                }
                builder.merge((AttributeMetadataRegistryBuilder) entry.getValue());
            }
            for (Entry<RootKey, ElementMetadataRegistryBuilder> entry2 : other.elements.entrySet()) {
                key = (RootKey) entry2.getKey();
                ElementMetadataRegistryBuilder builder2 = (ElementMetadataRegistryBuilder) this.elements.get(key);
                if (builder2 == null) {
                    builder2 = new ElementMetadataRegistryBuilder(this);
                    this.elements.put(key, builder2);
                }
                builder2.merge((ElementMetadataRegistryBuilder) entry2.getValue());
            }
        }
        return this;
    }

    public MetadataRegistry register(ElementKey<?, ?> key) {
        if (key != null) {
            Class<? extends Element> elementType = key.getElementType();
            if (Element.class == elementType) {
                build(key);
            } else {
                registerClass(elementType);
            }
        }
        return this;
    }

    public synchronized MetadataRegistry registerClass(Class<? extends Element> clazz) {
        MetadataRegistry this;
        if (Element.class == clazz) {
            this = this;
        } else {
            try {
                Method registerMethod = clazz.getDeclaredMethod("registerMetadata", new Class[]{MetadataRegistry.class});
                if (Modifier.isStatic(registerMethod.getModifiers())) {
                    registerMethod.invoke(null, new Object[]{this});
                    this = this;
                } else {
                    throw new IllegalArgumentException("Class " + clazz + " had a non-static registerMetadata(MetadataRegistry) method.");
                }
            } catch (SecurityException e) {
                throw new IllegalArgumentException(e);
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class " + clazz + " doesn't support metadata registration.", e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalArgumentException(e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalArgumentException(e4.getCause());
            }
        }
        return this;
    }

    public Schema createSchema() {
        Schema instance = this.cachedSchema;
        return instance != null ? instance : buildSchema();
    }

    private synchronized Schema buildSchema() {
        Schema instance;
        instance = this.cachedSchema;
        if (instance == null) {
            whitelistAttributes();
            whitelistElements();
            instance = new Schema(this);
            this.cachedSchema = instance;
        }
        return instance;
    }

    void dirty() {
        Preconditions.checkState(Thread.holdsLock(this), "Cannot call dirty() without holding the lock on the registry.");
        this.cachedSchema = null;
    }

    private void whitelistAttributes() {
        for (ElementMetadataRegistryBuilder builder : this.elements.values()) {
            Map<TransformKey, Set<AttributeKey<?>>> whitelistMap = Maps.newLinkedHashMap();
            Map<TransformKey, ElementCreatorImpl> creators = builder.getCreators();
            for (Entry<TransformKey, ElementCreatorImpl> entry : creators.entrySet()) {
                TransformKey key = (TransformKey) entry.getKey();
                ElementCreatorImpl element = (ElementCreatorImpl) entry.getValue();
                if (element.getAttributeWhitelist() != null) {
                    whitelistMap.put(key, element.getAttributeWhitelist());
                }
            }
            for (Entry<TransformKey, Set<AttributeKey<?>>> whitelistEntry : whitelistMap.entrySet()) {
                key = (TransformKey) whitelistEntry.getKey();
                Iterable<AttributeKey<?>> whitelist = (Set) whitelistEntry.getValue();
                Set<QName> whitelistNames = Sets.newHashSet();
                for (AttributeKey<?> whitelistKey : whitelist) {
                    whitelistNames.add(whitelistKey.getId());
                }
                Set<AttributeKey<?>> allAttributes = Sets.newHashSet();
                for (Entry<TransformKey, ElementCreatorImpl> entry2 : creators.entrySet()) {
                    if (((TransformKey) entry2.getKey()).matches(key)) {
                        allAttributes.addAll(((ElementCreatorImpl) entry2.getValue()).getAttributeSet());
                    }
                }
                if (allAttributes.containsAll(whitelist)) {
                    for (AttributeKey attribute : allAttributes) {
                        if (!whitelistNames.contains(attribute.getId())) {
                            build((ElementKey) key.getKey(), attribute, key.getContext()).setVisible(false);
                        }
                    }
                } else {
                    Set<AttributeKey<?>> missing = Sets.newHashSet((Iterable) whitelist);
                    missing.removeAll(allAttributes);
                    throw new IllegalStateException("Missing attributes!  Whitelist specified " + missing + " but did not find those attributes.");
                }
            }
        }
    }

    private void whitelistElements() {
        for (Entry<RootKey, ElementMetadataRegistryBuilder> rootEntry : this.elements.entrySet()) {
            ElementMetadataRegistryBuilder builder = (ElementMetadataRegistryBuilder) rootEntry.getValue();
            Map<TransformKey, Set<ElementKey<?, ?>>> whitelistMap = Maps.newLinkedHashMap();
            Map<TransformKey, ElementCreatorImpl> creators = builder.getCreators();
            for (Entry<TransformKey, ElementCreatorImpl> entry : creators.entrySet()) {
                TransformKey key = (TransformKey) entry.getKey();
                ElementCreatorImpl element = (ElementCreatorImpl) entry.getValue();
                if (element.getElementWhitelist() != null) {
                    whitelistMap.put(key, element.getElementWhitelist());
                }
            }
            for (Entry<TransformKey, Set<ElementKey<?, ?>>> whitelistEntry : whitelistMap.entrySet()) {
                key = (TransformKey) whitelistEntry.getKey();
                Iterable<ElementKey<?, ?>> whitelist = (Set) whitelistEntry.getValue();
                Set<QName> whitelistNames = Sets.newHashSet();
                for (ElementKey<?, ?> whitelistKey : whitelist) {
                    whitelistNames.add(whitelistKey.getId());
                }
                Set<ElementKey<?, ?>> allChildren = Sets.newHashSet();
                for (Entry<TransformKey, ElementCreatorImpl> entry2 : creators.entrySet()) {
                    if (((TransformKey) entry2.getKey()).matches(key)) {
                        allChildren.addAll(((ElementCreatorImpl) entry2.getValue()).getElementSet());
                    }
                }
                if (allChildren.containsAll(whitelist)) {
                    for (ElementKey child : allChildren) {
                        if (!whitelistNames.contains(child.getId())) {
                            build((ElementKey) key.getKey(), child, key.getContext()).setVisible(false);
                        }
                    }
                } else {
                    Set<ElementKey<?, ?>> missing = Sets.newHashSet((Iterable) whitelist);
                    missing.removeAll(allChildren);
                    throw new IllegalStateException("Missing children!  Whitelist specified " + missing + " but did not find those child elements.");
                }
            }
        }
    }

    public boolean isRegistered(ElementKey<?, ?> key) {
        ElementMetadataRegistryBuilder elementRegistry = (ElementMetadataRegistryBuilder) this.elements.get(Schema.getRootKey((ElementKey) key));
        if (elementRegistry != null) {
            return elementRegistry.isRegistered(null, key, null);
        }
        return false;
    }

    public ElementCreator build(ElementKey<?, ?> element) {
        return build(null, (ElementKey) element, null);
    }

    public ElementCreator build(ElementKey<?, ?> parent, ElementKey<?, ?> element) {
        return build((ElementKey) parent, (ElementKey) element, null);
    }

    public ElementCreator build(ElementKey<?, ?> element, MetadataContext context) {
        return build(null, (ElementKey) element, context);
    }

    public ElementCreator build(ElementKey<?, ?> parent, ElementKey<?, ?> element, MetadataContext context) {
        ElementCreatorImpl creator = getOrCreateElement(element).build(parent, element, context);
        if (!(parent == null && context == null)) {
            register(element);
        }
        return creator;
    }

    private synchronized ElementMetadataRegistryBuilder getOrCreateElement(ElementKey<?, ?> key) {
        ElementMetadataRegistryBuilder elementRegistry;
        RootKey rootKey = Schema.getRootKey((ElementKey) key);
        elementRegistry = (ElementMetadataRegistryBuilder) this.elements.get(rootKey);
        if (elementRegistry == null) {
            elementRegistry = new ElementMetadataRegistryBuilder(this);
            this.elements.put(rootKey, elementRegistry);
        }
        dirty();
        return elementRegistry;
    }

    public AttributeCreator build(ElementKey<?, ?> parent, AttributeKey<?> attribute) {
        return build((ElementKey) parent, (AttributeKey) attribute, null);
    }

    public AttributeCreator build(ElementKey<?, ?> parent, AttributeKey<?> attribute, MetadataContext context) {
        return getOrCreateAttribute(attribute).build(parent, attribute, context);
    }

    private synchronized AttributeMetadataRegistryBuilder getOrCreateAttribute(AttributeKey<?> key) {
        AttributeMetadataRegistryBuilder attRegistry;
        RootKey rootKey = Schema.getRootKey((AttributeKey) key);
        attRegistry = (AttributeMetadataRegistryBuilder) this.attributes.get(rootKey);
        if (attRegistry == null) {
            attRegistry = new AttributeMetadataRegistryBuilder(this);
            this.attributes.put(rootKey, attRegistry);
        }
        dirty();
        return attRegistry;
    }

    public <D, E extends Element> void adapt(ElementKey<D, E> source, String kind, ElementKey<? extends D, ? extends E> adaptation) {
        build(source).adapt(kind, adaptation);
    }

    Map<RootKey, AttributeMetadataRegistryBuilder> getAttributes() {
        return ImmutableMap.copyOf(this.attributes);
    }

    Map<RootKey, ElementMetadataRegistryBuilder> getElements() {
        return ImmutableMap.copyOf(this.elements);
    }
}
