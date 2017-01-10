package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.Namespaces;

public class Who extends Element {
    public static final AttributeKey<String> EMAIL;
    public static final ElementKey<Void, Who> KEY;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<String> VALUE_STRING;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String EVENT_ATTENDEE = "http://schemas.google.com/g/2005#event.attendee";
        public static final String EVENT_ORGANIZER = "http://schemas.google.com/g/2005#event.organizer";
        public static final String EVENT_PERFORMER = "http://schemas.google.com/g/2005#event.performer";
        public static final String EVENT_SPEAKER = "http://schemas.google.com/g/2005#event.speaker";
        public static final String MESSAGE_BCC = "http://schemas.google.com/g/2005#message.bcc";
        public static final String MESSAGE_CC = "http://schemas.google.com/g/2005#message.cc";
        public static final String MESSAGE_FROM = "http://schemas.google.com/g/2005#message.from";
        public static final String MESSAGE_REPLY_TO = "http://schemas.google.com/g/2005#message.reply-to";
        public static final String MESSAGE_TO = "http://schemas.google.com/g/2005#message.to";
        public static final String TASK_ASSIGNED_TO = "http://schemas.google.com/g/2005#task.assigned-to";

        static {
            ALL_VALUES = new String[]{EVENT_ATTENDEE, EVENT_ORGANIZER, EVENT_PERFORMER, EVENT_SPEAKER, MESSAGE_BCC, MESSAGE_CC, MESSAGE_FROM, MESSAGE_REPLY_TO, MESSAGE_TO, TASK_ASSIGNED_TO};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "who"), Void.class, Who.class);
        EMAIL = AttributeKey.of(new QName(null, Method.EMAIL), String.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        VALUE_STRING = AttributeKey.of(new QName(null, "valueString"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(EMAIL);
            builder.addAttribute(REL);
            builder.addAttribute(VALUE_STRING);
            builder.addElement(AttendeeStatus.KEY);
            builder.addElement(AttendeeType.KEY);
            builder.addElement(EntryLink.KEY);
        }
    }

    public Who() {
        super(KEY);
    }

    protected Who(ElementKey<?, ? extends Who> key) {
        super((ElementKey) key);
    }

    protected Who(ElementKey<?, ? extends Who> key, Element source) {
        super(key, source);
    }

    public Who lock() {
        return (Who) super.lock();
    }

    public AttendeeStatus getAttendeeStatus() {
        return (AttendeeStatus) super.getElement(AttendeeStatus.KEY);
    }

    public Who setAttendeeStatus(AttendeeStatus attendeeStatus) {
        super.setElement(AttendeeStatus.KEY, (Element) attendeeStatus);
        return this;
    }

    public boolean hasAttendeeStatus() {
        return super.hasElement(AttendeeStatus.KEY);
    }

    public AttendeeType getAttendeeType() {
        return (AttendeeType) super.getElement(AttendeeType.KEY);
    }

    public Who setAttendeeType(AttendeeType attendeeType) {
        super.setElement(AttendeeType.KEY, (Element) attendeeType);
        return this;
    }

    public boolean hasAttendeeType() {
        return super.hasElement(AttendeeType.KEY);
    }

    public String getEmail() {
        return (String) super.getAttributeValue(EMAIL);
    }

    public Who setEmail(String email) {
        super.setAttributeValue(EMAIL, (Object) email);
        return this;
    }

    public boolean hasEmail() {
        return super.hasAttribute(EMAIL);
    }

    public EntryLink getEntryLink() {
        return (EntryLink) super.getElement(EntryLink.KEY);
    }

    public Who setEntryLink(EntryLink entryLink) {
        super.setElement(EntryLink.KEY, (Element) entryLink);
        return this;
    }

    public boolean hasEntryLink() {
        return super.hasElement(EntryLink.KEY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Who setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public String getValueString() {
        return (String) super.getAttributeValue(VALUE_STRING);
    }

    public Who setValueString(String valueString) {
        super.setAttributeValue(VALUE_STRING, (Object) valueString);
        return this;
    }

    public boolean hasValueString() {
        return super.hasAttribute(VALUE_STRING);
    }
}
