package com.google.gdata.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

class AdaptationRegistryFactory {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(AdaptationRegistryFactory.class.getName());
    }

    static AdaptationRegistry create(Schema schema, ElementTransform transform) {
        return new AdaptationRegistry(transform.getAdaptations(), unionAttributes(schema, transform), unionElements(schema, transform));
    }

    private static Map<QName, AttributeKey<?>> unionAttributes(Schema schema, ElementTransform transform) {
        Map<QName, AttributeKey<?>> union = Maps.newLinkedHashMap();
        Set<QName> base = getAttributeNames(transform);
        Set<QName> invalid = Sets.newHashSet();
        for (ElementKey adaptorKey : transform.getAdaptations().values()) {
            ElementTransform adaptor = schema.getTransform(null, adaptorKey, null);
            if (adaptor == null) {
                throw new IllegalStateException("Invalid adaptor key " + adaptorKey);
            }
            for (AttributeInfo info : adaptor.getAttributes().values()) {
                AttributeKey<?> key = info.key;
                QName id = key.getId();
                if (!(base.contains(id) || invalid.contains(id))) {
                    AttributeKey<?> existing = (AttributeKey) union.get(id);
                    if (existing == null) {
                        union.put(id, key);
                    } else if (!checkCompatible(existing, key)) {
                        union.remove(id);
                        invalid.add(id);
                    }
                }
            }
        }
        return ImmutableMap.copyOf(union);
    }

    private static Set<QName> getAttributeNames(ElementTransform transform) {
        Set<QName> result = Sets.newHashSet();
        for (AttributeInfo info : transform.getAttributes().values()) {
            result.add(info.key.getId());
        }
        return result;
    }

    private static Map<QName, ElementKey<?, ?>> unionElements(Schema schema, ElementTransform transform) {
        Map<QName, ElementKey<?, ?>> union = Maps.newLinkedHashMap();
        Set<QName> invalid = Sets.newHashSet();
        Set<QName> base = getElementNames(transform);
        for (ElementKey adaptorKey : transform.getAdaptations().values()) {
            for (ElementInfo info : schema.getTransform(null, adaptorKey, null).getElements().values()) {
                ElementKey<?, ?> key = info.key;
                QName id = key.getId();
                if (!(base.contains(id) || invalid.contains(id))) {
                    ElementKey<?, ?> existing = (ElementKey) union.get(id);
                    ElementKey<?, ?> compatible = key;
                    if (existing != null) {
                        compatible = checkCompatibleElements(existing, key);
                    }
                    if (compatible == null) {
                        union.remove(id);
                        invalid.add(id);
                    } else if (compatible == key) {
                        union.put(id, key);
                    }
                }
            }
        }
        return ImmutableMap.copyOf(union);
    }

    private static Set<QName> getElementNames(ElementTransform transform) {
        Set<QName> result = Sets.newHashSet();
        for (ElementInfo info : transform.getElements().values()) {
            result.add(info.key.getId());
        }
        return result;
    }

    private static boolean checkCompatible(MetadataKey<?> first, MetadataKey<?> second) {
        Class<?> firstType = first.getDatatype();
        Class<?> secondType = second.getDatatype();
        if (firstType == secondType) {
            return true;
        }
        logger.warning("Incompatible datatypes.  First(" + first + "): " + firstType + " but Second(" + second + "): " + secondType);
        return false;
    }

    private static ElementKey<?, ?> checkCompatibleElements(ElementKey<?, ?> first, ElementKey<?, ?> second) {
        ElementKey<?, ?> match = first;
        boolean compatible = true;
        if (!checkCompatible(first, second)) {
            compatible = false;
        }
        Class<? extends Element> firstType = first.getElementType();
        Class<? extends Element> secondType = second.getElementType();
        if (!(firstType == secondType || firstType.isAssignableFrom(secondType))) {
            if (secondType.isAssignableFrom(firstType)) {
                match = second;
            } else {
                logger.warning("Incompatible element types. First(" + first + "): " + firstType + " but Second(" + second + "): " + secondType);
                compatible = false;
            }
        }
        return compatible ? match : null;
    }

    private AdaptationRegistryFactory() {
    }
}
