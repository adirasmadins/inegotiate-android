package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;

public class RecurrenceExceptionEntryLink extends EntryLink {
    public static final ElementKey<Void, RecurrenceExceptionEntryLink> KEY;

    static {
        KEY = ElementKey.of(EntryLink.KEY.getId(), Void.class, RecurrenceExceptionEntryLink.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            EntryLink.registerMetadata(registry);
            registry.build(KEY).replaceElement(RecurrenceExceptionEntry.KEY);
        }
    }

    public RecurrenceExceptionEntryLink() {
        super(KEY);
    }

    protected RecurrenceExceptionEntryLink(ElementKey<?, ? extends RecurrenceExceptionEntryLink> key) {
        super(key);
    }

    protected RecurrenceExceptionEntryLink(ElementKey<?, ? extends RecurrenceExceptionEntryLink> key, Element source) {
        super(key, source);
    }

    public RecurrenceExceptionEntryLink lock() {
        return (RecurrenceExceptionEntryLink) super.lock();
    }

    public RecurrenceExceptionEntry getEntry() {
        return (RecurrenceExceptionEntry) super.getElement(RecurrenceExceptionEntry.KEY);
    }

    public RecurrenceExceptionEntryLink setEntry(RecurrenceExceptionEntry entry) {
        super.setElement(RecurrenceExceptionEntry.KEY, (Element) entry);
        return this;
    }

    public boolean hasEntry() {
        return super.hasElement(RecurrenceExceptionEntry.KEY);
    }
}
