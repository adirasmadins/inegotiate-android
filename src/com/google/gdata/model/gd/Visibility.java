package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Visibility extends Element {
    public static final ElementKey<Void, Visibility> KEY;
    public static final AttributeKey<String> VALUE;

    public static final class Value {
        private static final String[] ALL_VALUES;
        public static final String CONFIDENTIAL = "http://schemas.google.com/g/2005#event.confidential";
        public static final String DEFAULT = "http://schemas.google.com/g/2005#event.default";
        public static final String PRIVATE = "http://schemas.google.com/g/2005#event.private";
        public static final String PUBLIC = "http://schemas.google.com/g/2005#event.public";

        static {
            ALL_VALUES = new String[]{CONFIDENTIAL, DEFAULT, PRIVATE, PUBLIC};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Value() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "visibility"), Void.class, Visibility.class);
        VALUE = AttributeKey.of(new QName(null, "value"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(VALUE).setRequired(true);
        }
    }

    public Visibility() {
        super(KEY);
    }

    protected Visibility(ElementKey<?, ? extends Visibility> key) {
        super((ElementKey) key);
    }

    protected Visibility(ElementKey<?, ? extends Visibility> key, Element source) {
        super(key, source);
    }

    public Visibility lock() {
        return (Visibility) super.lock();
    }

    public String getValue() {
        return (String) super.getAttributeValue(VALUE);
    }

    public Visibility setValue(String value) {
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
        return Element.eq(getValue(), ((Visibility) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
