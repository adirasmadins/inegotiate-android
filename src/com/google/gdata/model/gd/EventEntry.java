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

public class EventEntry extends Entry {
    public static final Category CATEGORY;
    public static final ElementKey<Void, EventEntry> KEY;
    public static final String KIND = "http://schemas.google.com/g/2005#event";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND).lock();
        KEY = ElementKey.of(Entry.KEY.getId(), Void.class, EventEntry.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Entry.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addElement(Comments.KEY);
            builder.addElement(EventStatus.KEY);
            builder.addElement(Where.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(OriginalEvent.KEY);
            builder.addElement(Who.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Recurrence.KEY);
            builder.addElement(RecurrenceException.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Reminder.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(When.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Transparency.KEY);
            builder.addElement(Visibility.KEY);
            registry.adapt(Entry.KEY, KIND, KEY);
        }
    }

    public EventEntry() {
        super(KEY);
        addCategory(CATEGORY);
    }

    public EventEntry(Entry sourceEntry) {
        super(KEY, sourceEntry);
    }

    protected EventEntry(ElementKey<?, ? extends EventEntry> key) {
        super(key);
    }

    protected EventEntry(ElementKey<?, ? extends EventEntry> key, Entry source) {
        super(key, source);
    }

    public EventEntry lock() {
        return (EventEntry) super.lock();
    }

    public Comments getComments() {
        return (Comments) super.getElement(Comments.KEY);
    }

    public EventEntry setComments(Comments comments) {
        super.setElement(Comments.KEY, (Element) comments);
        return this;
    }

    public boolean hasComments() {
        return super.hasElement(Comments.KEY);
    }

    public EventStatus getEventStatus() {
        return (EventStatus) super.getElement(EventStatus.KEY);
    }

    public EventEntry setEventStatus(EventStatus eventStatus) {
        super.setElement(EventStatus.KEY, (Element) eventStatus);
        return this;
    }

    public boolean hasEventStatus() {
        return super.hasElement(EventStatus.KEY);
    }

    public List<Where> getLocations() {
        return super.getElements(Where.KEY);
    }

    public EventEntry addLocation(Where location) {
        super.addElement(Where.KEY, (Element) location);
        return this;
    }

    public boolean removeLocation(Where location) {
        return super.removeElement((Element) location);
    }

    public void clearLocations() {
        super.removeElement(Where.KEY);
    }

    public boolean hasLocations() {
        return super.hasElement(Where.KEY);
    }

    public OriginalEvent getOriginalEvent() {
        return (OriginalEvent) super.getElement(OriginalEvent.KEY);
    }

    public EventEntry setOriginalEvent(OriginalEvent originalEvent) {
        super.setElement(OriginalEvent.KEY, (Element) originalEvent);
        return this;
    }

    public boolean hasOriginalEvent() {
        return super.hasElement(OriginalEvent.KEY);
    }

    public List<Who> getParticipants() {
        return super.getElements(Who.KEY);
    }

    public EventEntry addParticipant(Who participant) {
        super.addElement(Who.KEY, (Element) participant);
        return this;
    }

    public boolean removeParticipant(Who participant) {
        return super.removeElement((Element) participant);
    }

    public void clearParticipants() {
        super.removeElement(Who.KEY);
    }

    public boolean hasParticipants() {
        return super.hasElement(Who.KEY);
    }

    public Recurrence getRecurrence() {
        return (Recurrence) super.getElement(Recurrence.KEY);
    }

    public EventEntry setRecurrence(Recurrence recurrence) {
        super.setElement(Recurrence.KEY, (Element) recurrence);
        return this;
    }

    public boolean hasRecurrence() {
        return super.hasElement(Recurrence.KEY);
    }

    public List<RecurrenceException> getRecurrenceException() {
        return super.getElements(RecurrenceException.KEY);
    }

    public EventEntry addRecurrenceException(RecurrenceException recurrenceException) {
        super.addElement(RecurrenceException.KEY, (Element) recurrenceException);
        return this;
    }

    public boolean removeRecurrenceException(RecurrenceException recurrenceException) {
        return super.removeElement((Element) recurrenceException);
    }

    public void clearRecurrenceException() {
        super.removeElement(RecurrenceException.KEY);
    }

    public boolean hasRecurrenceException() {
        return super.hasElement(RecurrenceException.KEY);
    }

    public List<Reminder> getReminders() {
        return super.getElements(Reminder.KEY);
    }

    public EventEntry addReminder(Reminder reminder) {
        super.addElement(Reminder.KEY, (Element) reminder);
        return this;
    }

    public boolean removeReminder(Reminder reminder) {
        return super.removeElement((Element) reminder);
    }

    public void clearReminders() {
        super.removeElement(Reminder.KEY);
    }

    public boolean hasReminders() {
        return super.hasElement(Reminder.KEY);
    }

    public List<When> getTimes() {
        return super.getElements(When.KEY);
    }

    public EventEntry addTime(When time) {
        super.addElement(When.KEY, (Element) time);
        return this;
    }

    public boolean removeTime(When time) {
        return super.removeElement((Element) time);
    }

    public void clearTimes() {
        super.removeElement(When.KEY);
    }

    public boolean hasTimes() {
        return super.hasElement(When.KEY);
    }

    public Transparency getTransparency() {
        return (Transparency) super.getElement(Transparency.KEY);
    }

    public EventEntry setTransparency(Transparency transparency) {
        super.setElement(Transparency.KEY, (Element) transparency);
        return this;
    }

    public boolean hasTransparency() {
        return super.hasElement(Transparency.KEY);
    }

    public Visibility getVisibility() {
        return (Visibility) super.getElement(Visibility.KEY);
    }

    public EventEntry setVisibility(Visibility visibility) {
        super.setElement(Visibility.KEY, (Element) visibility);
        return this;
    }

    public boolean hasVisibility() {
        return super.hasElement(Visibility.KEY);
    }
}
