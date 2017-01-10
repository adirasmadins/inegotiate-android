package com.google.gdata.model;

public interface ElementValidator {
    void validate(ValidationContext validationContext, Element element, ElementMetadata<?, ?> elementMetadata);
}
