package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class AttendeeStatus extends Element {
    public static final ElementKey<Void, AttendeeStatus> KEY;
    public static final AttributeKey<String> VALUE;

    public static final class Value {
        public static final String ACCEPTED = "http://schemas.google.com/g/2005#event.accepted";
        private static final String[] ALL_VALUES;
        public static final String DECLINED = "http://schemas.google.com/g/2005#event.declined";
        public static final String INVITED = "http://schemas.google.com/g/2005#event.invited";
        public static final String TENTATIVE = "http://schemas.google.com/g/2005#event.tentative";

        static {
            ALL_VALUES = new String[]{ACCEPTED, DECLINED, INVITED, TENTATIVE};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Value() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "attendeeStatus"), Void.class, AttendeeStatus.class);
        VALUE = AttributeKey.of(new QName(null, "value"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(VALUE).setRequired(true);
        }
    }

    public AttendeeStatus() {
        super(KEY);
    }

    protected AttendeeStatus(ElementKey<?, ? extends AttendeeStatus> key) {
        super((ElementKey) key);
    }

    protected AttendeeStatus(ElementKey<?, ? extends AttendeeStatus> key, Element source) {
        super(key, source);
    }

    public AttendeeStatus lock() {
        return (AttendeeStatus) super.lock();
    }

    public String getValue() {
        return (String) super.getAttributeValue(VALUE);
    }

    public AttendeeStatus setValue(String value) {
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
        return Element.eq(getValue(), ((AttendeeStatus) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
