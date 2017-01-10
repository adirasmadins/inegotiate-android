package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.Namespaces;

public class Email extends Element {
    public static final AttributeKey<String> ADDRESS;
    public static final AttributeKey<String> DISPLAY_NAME;
    public static final ElementKey<Void, Email> KEY;
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
        KEY = ElementKey.of(new QName(Namespaces.gNs, Method.EMAIL), Void.class, Email.class);
        ADDRESS = AttributeKey.of(new QName(null, "address"), String.class);
        DISPLAY_NAME = AttributeKey.of(new QName(null, "displayName"), String.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(ADDRESS).setRequired(true);
            builder.addAttribute(DISPLAY_NAME);
            builder.addAttribute(LABEL);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(REL);
        }
    }

    public Email() {
        super(KEY);
    }

    protected Email(ElementKey<?, ? extends Email> key) {
        super((ElementKey) key);
    }

    protected Email(ElementKey<?, ? extends Email> key, Element source) {
        super(key, source);
    }

    public Email lock() {
        return (Email) super.lock();
    }

    public String getAddress() {
        return (String) super.getAttributeValue(ADDRESS);
    }

    public Email setAddress(String address) {
        super.setAttributeValue(ADDRESS, (Object) address);
        return this;
    }

    public boolean hasAddress() {
        return super.hasAttribute(ADDRESS);
    }

    public String getDisplayName() {
        return (String) super.getAttributeValue(DISPLAY_NAME);
    }

    public Email setDisplayName(String displayName) {
        super.setAttributeValue(DISPLAY_NAME, (Object) displayName);
        return this;
    }

    public boolean hasDisplayName() {
        return super.hasAttribute(DISPLAY_NAME);
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public Email setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public Email setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Email setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Email other = (Email) obj;
        if (Element.eq(getAddress(), other.getAddress()) && Element.eq(getDisplayName(), other.getDisplayName()) && Element.eq(getLabel(), other.getLabel()) && Element.eq(getPrimary(), other.getPrimary()) && Element.eq(getRel(), other.getRel())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getAddress() != null) {
            result = (result * 37) + getAddress().hashCode();
        }
        if (getDisplayName() != null) {
            result = (result * 37) + getDisplayName().hashCode();
        }
        if (getLabel() != null) {
            result = (result * 37) + getLabel().hashCode();
        }
        if (getPrimary() != null) {
            result = (result * 37) + getPrimary().hashCode();
        }
        if (getRel() != null) {
            return (result * 37) + getRel().hashCode();
        }
        return result;
    }
}
