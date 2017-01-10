package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Im extends Element {
    public static final AttributeKey<String> ADDRESS;
    public static final ElementKey<Void, Im> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<Boolean> PRIMARY;
    public static final AttributeKey<String> PROTOCOL;
    public static final AttributeKey<String> REL;

    public static final class Protocol {
        public static final String AIM = "http://schemas.google.com/g/2005#AIM";
        private static final String[] ALL_VALUES;
        public static final String GOOGLE_TALK = "http://schemas.google.com/g/2005#GOOGLE_TALK";
        public static final String ICQ = "http://schemas.google.com/g/2005#ICQ";
        public static final String JABBER = "http://schemas.google.com/g/2005#JABBER";
        public static final String MSN = "http://schemas.google.com/g/2005#MSN";
        public static final String NETMEETING = "http://schemas.google.com/g/2005#NETMEETING";
        public static final String QQ = "http://schemas.google.com/g/2005#QQ";
        public static final String SKYPE = "http://schemas.google.com/g/2005#SKYPE";
        public static final String YAHOO = "http://schemas.google.com/g/2005#YAHOO";

        static {
            ALL_VALUES = new String[]{AIM, GOOGLE_TALK, ICQ, JABBER, MSN, NETMEETING, QQ, SKYPE, YAHOO};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Protocol() {
        }
    }

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
        KEY = ElementKey.of(new QName(Namespaces.gNs, "im"), Void.class, Im.class);
        ADDRESS = AttributeKey.of(new QName(null, "address"), String.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        PROTOCOL = AttributeKey.of(new QName(null, "protocol"), String.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(ADDRESS).setRequired(true);
            builder.addAttribute(LABEL);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(PROTOCOL);
            builder.addAttribute(REL);
        }
    }

    public Im() {
        super(KEY);
    }

    protected Im(ElementKey<?, ? extends Im> key) {
        super((ElementKey) key);
    }

    protected Im(ElementKey<?, ? extends Im> key, Element source) {
        super(key, source);
    }

    public Im lock() {
        return (Im) super.lock();
    }

    public String getAddress() {
        return (String) super.getAttributeValue(ADDRESS);
    }

    public Im setAddress(String address) {
        super.setAttributeValue(ADDRESS, (Object) address);
        return this;
    }

    public boolean hasAddress() {
        return super.hasAttribute(ADDRESS);
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public Im setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public Im setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public String getProtocol() {
        return (String) super.getAttributeValue(PROTOCOL);
    }

    public Im setProtocol(String protocol) {
        super.setAttributeValue(PROTOCOL, (Object) protocol);
        return this;
    }

    public boolean hasProtocol() {
        return super.hasAttribute(PROTOCOL);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Im setRel(String rel) {
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
        Im other = (Im) obj;
        if (Element.eq(getAddress(), other.getAddress()) && Element.eq(getLabel(), other.getLabel()) && Element.eq(getPrimary(), other.getPrimary()) && Element.eq(getProtocol(), other.getProtocol()) && Element.eq(getRel(), other.getRel())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getAddress() != null) {
            result = (result * 37) + getAddress().hashCode();
        }
        if (getLabel() != null) {
            result = (result * 37) + getLabel().hashCode();
        }
        if (getPrimary() != null) {
            result = (result * 37) + getPrimary().hashCode();
        }
        if (getProtocol() != null) {
            result = (result * 37) + getProtocol().hashCode();
        }
        if (getRel() != null) {
            return (result * 37) + getRel().hashCode();
        }
        return result;
    }
}
