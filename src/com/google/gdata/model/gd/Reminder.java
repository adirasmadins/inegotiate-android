package com.google.gdata.model.gd;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.gdata.data.DateTime;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Reminder extends Element {
    public static final AttributeKey<DateTime> ABSOLUTE_TIME;
    public static final AttributeKey<Integer> DAYS;
    public static final AttributeKey<Integer> HOURS;
    public static final ElementKey<Void, Reminder> KEY;
    public static final AttributeKey<String> METHOD;
    public static final AttributeKey<Integer> MINUTES;

    public static final class Method {
        public static final String ALERT = "alert";
        public static final String ALL = "all";
        private static final String[] ALL_VALUES;
        public static final String EMAIL = "email";
        public static final String NONE = "none";
        public static final String SMS = "sms";

        static {
            ALL_VALUES = new String[]{ALERT, ALL, EMAIL, NONE, SMS};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Method() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "reminder"), Void.class, Reminder.class);
        ABSOLUTE_TIME = AttributeKey.of(new QName(null, "absoluteTime"), DateTime.class);
        DAYS = AttributeKey.of(new QName(null, "days"), Integer.class);
        HOURS = AttributeKey.of(new QName(null, "hours"), Integer.class);
        METHOD = AttributeKey.of(new QName(null, OutputKeys.METHOD), String.class);
        MINUTES = AttributeKey.of(new QName(null, "minutes"), Integer.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(ABSOLUTE_TIME);
            builder.addAttribute(DAYS);
            builder.addAttribute(HOURS);
            builder.addAttribute(METHOD);
            builder.addAttribute(MINUTES);
        }
    }

    public Reminder() {
        super(KEY);
    }

    protected Reminder(ElementKey<?, ? extends Reminder> key) {
        super((ElementKey) key);
    }

    protected Reminder(ElementKey<?, ? extends Reminder> key, Element source) {
        super(key, source);
    }

    public Reminder lock() {
        return (Reminder) super.lock();
    }

    public DateTime getAbsoluteTime() {
        return (DateTime) super.getAttributeValue(ABSOLUTE_TIME);
    }

    public Reminder setAbsoluteTime(DateTime absoluteTime) {
        super.setAttributeValue(ABSOLUTE_TIME, (Object) absoluteTime);
        return this;
    }

    public boolean hasAbsoluteTime() {
        return super.hasAttribute(ABSOLUTE_TIME);
    }

    public Integer getDays() {
        return (Integer) super.getAttributeValue(DAYS);
    }

    public Reminder setDays(Integer days) {
        super.setAttributeValue(DAYS, (Object) days);
        return this;
    }

    public boolean hasDays() {
        return super.hasAttribute(DAYS);
    }

    public Integer getHours() {
        return (Integer) super.getAttributeValue(HOURS);
    }

    public Reminder setHours(Integer hours) {
        super.setAttributeValue(HOURS, (Object) hours);
        return this;
    }

    public boolean hasHours() {
        return super.hasAttribute(HOURS);
    }

    public String getMethod() {
        return (String) super.getAttributeValue(METHOD);
    }

    public Reminder setMethod(String method) {
        super.setAttributeValue(METHOD, (Object) method);
        return this;
    }

    public boolean hasMethod() {
        return super.hasAttribute(METHOD);
    }

    public Integer getMinutes() {
        return (Integer) super.getAttributeValue(MINUTES);
    }

    public Reminder setMinutes(Integer minutes) {
        super.setAttributeValue(MINUTES, (Object) minutes);
        return this;
    }

    public boolean hasMinutes() {
        return super.hasAttribute(MINUTES);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Reminder other = (Reminder) obj;
        if (Element.eq(getAbsoluteTime(), other.getAbsoluteTime()) && Element.eq(getDays(), other.getDays()) && Element.eq(getHours(), other.getHours()) && Element.eq(getMethod(), other.getMethod()) && Element.eq(getMinutes(), other.getMinutes())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getAbsoluteTime() != null) {
            result = (result * 37) + getAbsoluteTime().hashCode();
        }
        if (getDays() != null) {
            result = (result * 37) + getDays().hashCode();
        }
        if (getHours() != null) {
            result = (result * 37) + getHours().hashCode();
        }
        if (getMethod() != null) {
            result = (result * 37) + getMethod().hashCode();
        }
        if (getMinutes() != null) {
            return (result * 37) + getMinutes().hashCode();
        }
        return result;
    }
}
