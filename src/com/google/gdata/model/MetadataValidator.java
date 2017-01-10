package com.google.gdata.model;

import com.google.gdata.client.CoreErrorDomain;

public class MetadataValidator implements ElementValidator {
    public void validate(ValidationContext vc, Element e, ElementMetadata<?, ?> metadata) {
        ElementKey<?, ?> key = metadata.getKey();
        if (e.hasTextValue()) {
            if (key.getDatatype() == Void.class) {
                vc.addError(e, CoreErrorDomain.ERR.invalidTextContent.withInternalReason("Element " + key.getId() + " must not contain text content."));
            }
        } else if (key.getDatatype() != Void.class && metadata.isContentRequired()) {
            vc.addError(e, CoreErrorDomain.ERR.missingTextContent.withInternalReason("Element " + key.getId() + " must contain a text content value."));
        }
        for (AttributeKey attributeKey : metadata.getAttributes()) {
            if (metadata.bindAttribute(attributeKey).isRequired() && e.getAttributeValue(attributeKey) == null) {
                vc.addError(e, CoreErrorDomain.ERR.missingAttribute.withInternalReason("Element must contain value for attribute " + attributeKey.getId()));
            }
        }
        for (ElementKey childKey : metadata.getElements()) {
            if (metadata.bindElement(childKey).isRequired() && !e.hasElement(childKey)) {
                vc.addError(e, CoreErrorDomain.ERR.missingExtensionElement.withInternalReason("Element must contain a child named " + childKey.getId()));
            }
        }
    }
}
