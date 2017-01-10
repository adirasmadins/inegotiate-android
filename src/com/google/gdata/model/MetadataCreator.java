package com.google.gdata.model;

import com.google.gdata.model.Metadata.VirtualValue;

public interface MetadataCreator {
    MetadataCreator setName(QName qName);

    MetadataCreator setRequired(boolean z);

    MetadataCreator setVirtualValue(VirtualValue virtualValue);

    MetadataCreator setVisible(boolean z);
}
