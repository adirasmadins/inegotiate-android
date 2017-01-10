package com.google.gdata.model;

import java.util.Map;

class AdaptationRegistry {
    private final Map<String, ElementKey<?, ?>> adaptations;
    private final Map<QName, AttributeKey<?>> attributes;
    private final Map<QName, ElementKey<?, ?>> elements;

    AdaptationRegistry(Map<String, ElementKey<?, ?>> adaptations, Map<QName, AttributeKey<?>> attributes, Map<QName, ElementKey<?, ?>> elements) {
        this.adaptations = adaptations;
        this.attributes = attributes;
        this.elements = elements;
    }

    ElementKey<?, ?> getAdaptation(String kind) {
        return (ElementKey) this.adaptations.get(kind);
    }

    AttributeKey<?> findAttribute(QName id) {
        return (AttributeKey) this.attributes.get(id);
    }

    ElementKey<?, ?> findElement(QName id) {
        return (ElementKey) this.elements.get(id);
    }
}
