package com.google.gdata.model.gd;

import com.google.gdata.data.DateTime;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;
import java.util.List;

public class When extends Element {
    public static final AttributeKey<DateTime> END_TIME;
    public static final ElementKey<Void, When> KEY;
    public static final AttributeKey<DateTime> START_TIME;
    public static final AttributeKey<String> VALUE_STRING;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "when"), Void.class, When.class);
        END_TIME = AttributeKey.of(new QName(null, "endTime"), DateTime.class);
        START_TIME = AttributeKey.of(new QName(null, "startTime"), DateTime.class);
        VALUE_STRING = AttributeKey.of(new QName(null, "valueString"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(END_TIME);
            builder.addAttribute(START_TIME).setRequired(true);
            builder.addAttribute(VALUE_STRING);
            builder.addElement(Reminder.KEY).setCardinality(Cardinality.MULTIPLE);
        }
    }

    public When() {
        super(KEY);
    }

    protected When(ElementKey<?, ? extends When> key) {
        super((ElementKey) key);
    }

    protected When(ElementKey<?, ? extends When> key, Element source) {
        super(key, source);
    }

    public When lock() {
        return (When) super.lock();
    }

    public DateTime getEndTime() {
        return (DateTime) super.getAttributeValue(END_TIME);
    }

    public When setEndTime(DateTime endTime) {
        super.setAttributeValue(END_TIME, (Object) endTime);
        return this;
    }

    public boolean hasEndTime() {
        return super.hasAttribute(END_TIME);
    }

    public List<Reminder> getReminder() {
        return super.getElements(Reminder.KEY);
    }

    public When addReminder(Reminder reminder) {
        super.addElement(Reminder.KEY, (Element) reminder);
        return this;
    }

    public boolean removeReminder(Reminder reminder) {
        return super.removeElement((Element) reminder);
    }

    public void clearReminder() {
        super.removeElement(Reminder.KEY);
    }

    public boolean hasReminder() {
        return super.hasElement(Reminder.KEY);
    }

    public DateTime getStartTime() {
        return (DateTime) super.getAttributeValue(START_TIME);
    }

    public When setStartTime(DateTime startTime) {
        super.setAttributeValue(START_TIME, (Object) startTime);
        return this;
    }

    public boolean hasStartTime() {
        return super.hasAttribute(START_TIME);
    }

    public String getValueString() {
        return (String) super.getAttributeValue(VALUE_STRING);
    }

    public When setValueString(String valueString) {
        super.setAttributeValue(VALUE_STRING, (Object) valueString);
        return this;
    }

    public boolean hasValueString() {
        return super.hasAttribute(VALUE_STRING);
    }
}
