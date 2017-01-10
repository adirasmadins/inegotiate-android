package com.google.gdata.data;

public class Feed extends BaseFeed<Feed, Entry> {
    public Feed() {
        super(Entry.class);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declareArbitraryXmlExtension(BaseFeed.class);
        super.declareExtensions(extProfile);
    }
}
