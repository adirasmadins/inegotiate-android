package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class EventStatus extends Element {
    public static final ElementKey<Void, EventStatus> KEY;
    public static final AttributeKey<String> VALUE;

    public static final class Value {
        private static final String[] ALL_VALUES;
        public static final String CANCELED = "http://schemas.google.com/g/2005#event.canceled";
        public static final String CONFIRMED = "http://schemas.google.com/g/2005#event.confirmed";
        public static final String TENTATIVE = "http://schemas.google.com/g/2005#event.tentative";

        static {
            ALL_VALUES = new String[]{CANCELED, CONFIRMED, TENTATIVE};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Value() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "eventStatus"), Void.class, EventStatus.class);
        VALUE = AttributeKey.of(new QName(null, "value"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(VALUE).setRequired(true);
        }
    }

    public EventStatus() {
        super(KEY);
    }

    protected EventStatus(ElementKey<?, ? extends EventStatus> key) {
        super((ElementKey) key);
    }

    protected EventStatus(ElementKey<?, ? extends EventStatus> key, Element source) {
        super(key, source);
    }

    public EventStatus lock() {
        return (EventStatus) super.lock();
    }

    public String getValue() {
        return (String) super.getAttributeValue(VALUE);
    }

    public EventStatus setValue(String value) {
        super.setAttributeValue(VALUE, (Object) value);
        return this;
    }

    public boolean hasValue() {
        return super.hasAttribute(VALUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return Element.eq(getValue(), ((EventStatus) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
