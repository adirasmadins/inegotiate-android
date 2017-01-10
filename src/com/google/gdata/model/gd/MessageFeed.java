package com.google.gdata.model.gd;

import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.atom.Category;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.util.Namespaces;
import java.util.List;

public class MessageFeed extends Feed {
    public static final Category CATEGORY;
    public static final ElementKey<Void, MessageFeed> KEY;
    public static final String KIND = "http://schemas.google.com/g/2005#message";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND).lock();
        KEY = ElementKey.of(Feed.KEY.getId(), Void.class, MessageFeed.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Feed.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addUndeclaredElementMarker();
            builder.addElement(MessageEntry.KEY);
            registry.adapt(Feed.KEY, KIND, KEY);
        }
    }

    public MessageFeed() {
        super(KEY);
        addCategory(CATEGORY);
    }

    public MessageFeed(Feed sourceFeed) {
        super(KEY, sourceFeed);
    }

    protected MessageFeed(ElementKey<?, ? extends MessageFeed> key) {
        super(key);
    }

    protected MessageFeed(ElementKey<?, ? extends MessageFeed> key, Feed source) {
        super(key, source);
    }

    public MessageFeed lock() {
        return (MessageFeed) super.lock();
    }

    public List<? extends MessageEntry> getEntries() {
        return getEntries(MessageEntry.KEY);
    }
}
