package com.google.gdata.data;

public class Entry extends BaseEntry<Entry> {
    public Entry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declareArbitraryXmlExtension(BaseEntry.class);
    }
}
