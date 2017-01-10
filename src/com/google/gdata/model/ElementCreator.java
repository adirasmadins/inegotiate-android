package com.google.gdata.model;

import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import com.google.gdata.model.Metadata.VirtualValue;

public interface ElementCreator extends MetadataCreator {
    ElementCreator adapt(String str, ElementKey<?, ?> elementKey);

    AttributeCreator addAttribute(AttributeKey<?> attributeKey);

    ElementCreator addElement(ElementKey<?, ?> elementKey);

    ElementCreator addUndeclaredAttributeMarker();

    ElementCreator addUndeclaredElementMarker();

    ElementCreator blacklistElements(ElementKey<?, ?>... elementKeyArr);

    ElementCreator flatten();

    AttributeCreator moveAttribute(AttributeKey<?> attributeKey, Path path);

    ElementCreator moveElement(ElementKey<?, ?> elementKey, Path path);

    ElementCreator orderAndWhitelistAttributes(AttributeKey<?>... attributeKeyArr);

    ElementCreator orderAndWhitelistElements(ElementKey<?, ?>... elementKeyArr);

    AttributeCreator replaceAttribute(AttributeKey<?> attributeKey);

    ElementCreator replaceElement(ElementKey<?, ?> elementKey);

    ElementCreator setCardinality(Cardinality cardinality);

    ElementCreator setContentRequired(boolean z);

    ElementCreator setMultipleVirtualElement(MultipleVirtualElement multipleVirtualElement);

    ElementCreator setName(QName qName);

    ElementCreator setProperties(Object obj);

    ElementCreator setRequired(boolean z);

    ElementCreator setSingleVirtualElement(SingleVirtualElement singleVirtualElement);

    ElementCreator setValidator(ElementValidator elementValidator);

    ElementCreator setVirtualValue(VirtualValue virtualValue);

    ElementCreator setVisible(boolean z);

    ElementCreator whitelistAttributes(AttributeKey<?>... attributeKeyArr);

    ElementCreator whitelistElements(ElementKey<?, ?>... elementKeyArr);
}
