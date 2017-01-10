package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;

public interface AttributeCreator extends MetadataCreator {
    AttributeCreator setName(QName qName);

    AttributeCreator setRequired(boolean z);

    AttributeCreator setVirtualValue(VirtualValue virtualValue);

    AttributeCreator setVisible(boolean z);
}
