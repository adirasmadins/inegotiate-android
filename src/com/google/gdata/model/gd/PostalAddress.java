package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class PostalAddress extends Element {
    public static final ElementKey<String, PostalAddress> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<Boolean> PRIMARY;
    public static final AttributeKey<String> REL;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String HOME = "http://schemas.google.com/g/2005#home";
        public static final String OTHER = "http://schemas.google.com/g/2005#other";
        public static final String WORK = "http://schemas.google.com/g/2005#work";

        static {
            ALL_VALUES = new String[]{HOME, OTHER, WORK};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "postalAddress"), String.class, PostalAddress.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(LABEL);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(REL);
        }
    }

    public PostalAddress() {
        super(KEY);
    }

    protected PostalAddress(ElementKey<String, ? extends PostalAddress> key) {
        super((ElementKey) key);
    }

    protected PostalAddress(ElementKey<String, ? extends PostalAddress> key, Element source) {
        super(key, source);
    }

    public PostalAddress(String value) {
        this();
        setValue(value);
    }

    public PostalAddress lock() {
        return (PostalAddress) super.lock();
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public PostalAddress setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public PostalAddress setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public PostalAddress setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public PostalAddress setValue(String value) {
        super.setTextValue(value);
        return this;
    }

    public boolean hasValue() {
        return super.hasTextValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        PostalAddress other = (PostalAddress) obj;
        if (Element.eq(getLabel(), other.getLabel()) && Element.eq(getPrimary(), other.getPrimary()) && Element.eq(getRel(), other.getRel()) && Element.eq(getValue(), other.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getLabel() != null) {
            result = (result * 37) + getLabel().hashCode();
        }
        if (getPrimary() != null) {
            result = (result * 37) + getPrimary().hashCode();
        }
        if (getRel() != null) {
            result = (result * 37) + getRel().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
