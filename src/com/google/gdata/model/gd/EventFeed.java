package com.google.gdata.model.gd;

import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.atom.Category;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.util.Namespaces;
import java.util.List;

public class EventFeed extends Feed {
    public static final Category CATEGORY;
    public static final ElementKey<Void, EventFeed> KEY;
    public static final String KIND = "http://schemas.google.com/g/2005#event";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND).lock();
        KEY = ElementKey.of(Feed.KEY.getId(), Void.class, EventFeed.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Feed.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addUndeclaredElementMarker();
            builder.addElement(EventEntry.KEY);
            registry.adapt(Feed.KEY, KIND, KEY);
        }
    }

    public EventFeed() {
        super(KEY);
        addCategory(CATEGORY);
    }

    public EventFeed(Feed sourceFeed) {
        super(KEY, sourceFeed);
    }

    protected EventFeed(ElementKey<?, ? extends EventFeed> key) {
        super(key);
    }

    protected EventFeed(ElementKey<?, ? extends EventFeed> key, Feed source) {
        super(key, source);
    }

    public EventFeed lock() {
        return (EventFeed) super.lock();
    }

    public List<? extends EventEntry> getEntries() {
        return getEntries(EventEntry.KEY);
    }
}
