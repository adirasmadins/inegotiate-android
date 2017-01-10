package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.atom.Entry;
import java.util.List;

public class RecurrenceExceptionEntry extends Entry {
    public static final ElementKey<Void, RecurrenceExceptionEntry> KEY;

    static {
        KEY = ElementKey.of(Entry.KEY.getId(), Void.class, RecurrenceExceptionEntry.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Entry.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addElement(Comments.KEY);
            builder.addElement(EventStatus.KEY);
            builder.addElement(OriginalEvent.KEY);
            builder.addElement(Transparency.KEY);
            builder.addElement(Visibility.KEY);
            builder.addElement(When.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Where.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Who.KEY).setCardinality(Cardinality.MULTIPLE);
        }
    }

    public RecurrenceExceptionEntry() {
        super(KEY);
    }

    public RecurrenceExceptionEntry(Entry sourceEntry) {
        super(KEY, sourceEntry);
    }

    protected RecurrenceExceptionEntry(ElementKey<?, ? extends RecurrenceExceptionEntry> key) {
        super(key);
    }

    protected RecurrenceExceptionEntry(ElementKey<?, ? extends RecurrenceExceptionEntry> key, Entry source) {
        super(key, source);
    }

    public RecurrenceExceptionEntry lock() {
        return (RecurrenceExceptionEntry) super.lock();
    }

    public Comments getComments() {
        return (Comments) super.getElement(Comments.KEY);
    }

    public RecurrenceExceptionEntry setComments(Comments comments) {
        super.setElement(Comments.KEY, (Element) comments);
        return this;
    }

    public boolean hasComments() {
        return super.hasElement(Comments.KEY);
    }

    public EventStatus getEventStatus() {
        return (EventStatus) super.getElement(EventStatus.KEY);
    }

    public RecurrenceExceptionEntry setEventStatus(EventStatus eventStatus) {
        super.setElement(EventStatus.KEY, (Element) eventStatus);
        return this;
    }

    public boolean hasEventStatus() {
        return super.hasElement(EventStatus.KEY);
    }

    public OriginalEvent getOriginalEvent() {
        return (OriginalEvent) super.getElement(OriginalEvent.KEY);
    }

    public RecurrenceExceptionEntry setOriginalEvent(OriginalEvent originalEvent) {
        super.setElement(OriginalEvent.KEY, (Element) originalEvent);
        return this;
    }

    public boolean hasOriginalEvent() {
        return super.hasElement(OriginalEvent.KEY);
    }

    public Transparency getTransparency() {
        return (Transparency) super.getElement(Transparency.KEY);
    }

    public RecurrenceExceptionEntry setTransparency(Transparency transparency) {
        super.setElement(Transparency.KEY, (Element) transparency);
        return this;
    }

    public boolean hasTransparency() {
        return super.hasElement(Transparency.KEY);
    }

    public Visibility getVisibility() {
        return (Visibility) super.getElement(Visibility.KEY);
    }

    public RecurrenceExceptionEntry setVisibility(Visibility visibility) {
        super.setElement(Visibility.KEY, (Element) visibility);
        return this;
    }

    public boolean hasVisibility() {
        return super.hasElement(Visibility.KEY);
    }

    public List<When> getWhen() {
        return super.getElements(When.KEY);
    }

    public RecurrenceExceptionEntry addWhen(When when) {
        super.addElement(When.KEY, (Element) when);
        return this;
    }

    public boolean removeWhen(When when) {
        return super.removeElement((Element) when);
    }

    public void clearWhen() {
        super.removeElement(When.KEY);
    }

    public boolean hasWhen() {
        return super.hasElement(When.KEY);
    }

    public List<Where> getWhere() {
        return super.getElements(Where.KEY);
    }

    public RecurrenceExceptionEntry addWhere(Where where) {
        super.addElement(Where.KEY, (Element) where);
        return this;
    }

    public boolean removeWhere(Where where) {
        return super.removeElement((Element) where);
    }

    public void clearWhere() {
        super.removeElement(Where.KEY);
    }

    public boolean hasWhere() {
        return super.hasElement(Where.KEY);
    }

    public List<Who> getWho() {
        return super.getElements(Who.KEY);
    }

    public RecurrenceExceptionEntry addWho(Who who) {
        super.addElement(Who.KEY, (Element) who);
        return this;
    }

    public boolean removeWho(Who who) {
        return super.removeElement((Element) who);
    }

    public void clearWho() {
        super.removeElement(Who.KEY);
    }

    public boolean hasWho() {
        return super.hasElement(Who.KEY);
    }
}
