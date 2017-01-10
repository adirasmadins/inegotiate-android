package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Transparency extends Element {
    public static final ElementKey<Void, Transparency> KEY;
    public static final AttributeKey<String> VALUE;

    public static final class Value {
        private static final String[] ALL_VALUES;
        public static final String OPAQUE = "http://schemas.google.com/g/2005#event.opaque";
        public static final String TRANSPARENT = "http://schemas.google.com/g/2005#event.transparent";

        static {
            ALL_VALUES = new String[]{OPAQUE, TRANSPARENT};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Value() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "transparency"), Void.class, Transparency.class);
        VALUE = AttributeKey.of(new QName(null, "value"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(VALUE).setRequired(true);
        }
    }

    public Transparency() {
        super(KEY);
    }

    protected Transparency(ElementKey<?, ? extends Transparency> key) {
        super((ElementKey) key);
    }

    protected Transparency(ElementKey<?, ? extends Transparency> key, Element source) {
        super(key, source);
    }

    public Transparency lock() {
        return (Transparency) super.lock();
    }

    public String getValue() {
        return (String) super.getAttributeValue(VALUE);
    }

    public Transparency setValue(String value) {
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
        return Element.eq(getValue(), ((Transparency) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
