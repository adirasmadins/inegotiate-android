package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.atom.Category;
import com.google.gdata.model.atom.Entry;
import com.google.gdata.util.Namespaces;
import java.util.List;

public class MessageEntry extends Entry {
    public static final Category CATEGORY;
    public static final ElementKey<Void, MessageEntry> KEY;
    public static final String KIND = "http://schemas.google.com/g/2005#message";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND).lock();
        KEY = ElementKey.of(Entry.KEY.getId(), Void.class, MessageEntry.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Entry.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addElement(GeoPt.KEY);
            builder.addElement(Rating.KEY);
            builder.addElement(When.KEY);
            builder.addElement(Who.KEY).setCardinality(Cardinality.MULTIPLE);
            registry.adapt(Entry.KEY, KIND, KEY);
        }
    }

    public MessageEntry() {
        super(KEY);
        addCategory(CATEGORY);
    }

    public MessageEntry(Entry sourceEntry) {
        super(KEY, sourceEntry);
    }

    protected MessageEntry(ElementKey<?, ? extends MessageEntry> key) {
        super(key);
    }

    protected MessageEntry(ElementKey<?, ? extends MessageEntry> key, Entry source) {
        super(key, source);
    }

    public MessageEntry lock() {
        return (MessageEntry) super.lock();
    }

    public GeoPt getGeoPt() {
        return (GeoPt) super.getElement(GeoPt.KEY);
    }

    public MessageEntry setGeoPt(GeoPt geoPt) {
        super.setElement(GeoPt.KEY, (Element) geoPt);
        return this;
    }

    public boolean hasGeoPt() {
        return super.hasElement(GeoPt.KEY);
    }

    public Rating getRating() {
        return (Rating) super.getElement(Rating.KEY);
    }

    public MessageEntry setRating(Rating rating) {
        super.setElement(Rating.KEY, (Element) rating);
        return this;
    }

    public boolean hasRating() {
        return super.hasElement(Rating.KEY);
    }

    public When getTime() {
        return (When) super.getElement(When.KEY);
    }

    public MessageEntry setTime(When time) {
        super.setElement(When.KEY, (Element) time);
        return this;
    }

    public boolean hasTime() {
        return super.hasElement(When.KEY);
    }

    public List<Who> getWhoList() {
        return super.getElements(Who.KEY);
    }

    public MessageEntry addWhoList(Who whoList) {
        super.addElement(Who.KEY, (Element) whoList);
        return this;
    }

    public boolean removeWhoList(Who whoList) {
        return super.removeElement((Element) whoList);
    }

    public void clearWhoList() {
        super.removeElement(Who.KEY);
    }

    public boolean hasWhoList() {
        return super.hasElement(Who.KEY);
    }
}
