package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class PhoneNumber extends Element {
    public static final ElementKey<String, PhoneNumber> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<Boolean> PRIMARY;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<String> URI;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String ASSISTANT = "http://schemas.google.com/g/2005#assistant";
        public static final String CALLBACK = "http://schemas.google.com/g/2005#callback";
        public static final String CAR = "http://schemas.google.com/g/2005#car";
        public static final String COMPANY_MAIN = "http://schemas.google.com/g/2005#company_main";
        public static final String FAX = "http://schemas.google.com/g/2005#fax";
        public static final String HOME = "http://schemas.google.com/g/2005#home";
        public static final String HOME_FAX = "http://schemas.google.com/g/2005#home_fax";
        public static final String ISDN = "http://schemas.google.com/g/2005#isdn";
        public static final String MAIN = "http://schemas.google.com/g/2005#main";
        public static final String MOBILE = "http://schemas.google.com/g/2005#mobile";
        public static final String OTHER = "http://schemas.google.com/g/2005#other";
        public static final String OTHER_FAX = "http://schemas.google.com/g/2005#other_fax";
        public static final String PAGER = "http://schemas.google.com/g/2005#pager";
        public static final String RADIO = "http://schemas.google.com/g/2005#radio";
        public static final String TELEX = "http://schemas.google.com/g/2005#telex";
        public static final String TTY_TDD = "http://schemas.google.com/g/2005#tty_tdd";
        public static final String WORK = "http://schemas.google.com/g/2005#work";
        public static final String WORK_FAX = "http://schemas.google.com/g/2005#work_fax";
        public static final String WORK_MOBILE = "http://schemas.google.com/g/2005#work_mobile";
        public static final String WORK_PAGER = "http://schemas.google.com/g/2005#work_pager";

        static {
            ALL_VALUES = new String[]{ASSISTANT, CALLBACK, CAR, COMPANY_MAIN, FAX, HOME, HOME_FAX, ISDN, MAIN, MOBILE, OTHER, OTHER_FAX, PAGER, RADIO, TELEX, TTY_TDD, WORK, WORK_FAX, WORK_MOBILE, WORK_PAGER};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "phoneNumber"), String.class, PhoneNumber.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        PRIMARY = AttributeKey.of(new QName(null, "primary"), Boolean.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        URI = AttributeKey.of(new QName(null, "uri"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(LABEL);
            builder.addAttribute(PRIMARY);
            builder.addAttribute(REL);
            builder.addAttribute(URI);
        }
    }

    public PhoneNumber() {
        super(KEY);
    }

    protected PhoneNumber(ElementKey<String, ? extends PhoneNumber> key) {
        super((ElementKey) key);
    }

    protected PhoneNumber(ElementKey<String, ? extends PhoneNumber> key, Element source) {
        super(key, source);
    }

    public PhoneNumber(String value) {
        this();
        setValue(value);
    }

    public PhoneNumber lock() {
        return (PhoneNumber) super.lock();
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public PhoneNumber setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public Boolean getPrimary() {
        return (Boolean) super.getAttributeValue(PRIMARY);
    }

    public PhoneNumber setPrimary(Boolean primary) {
        super.setAttributeValue(PRIMARY, (Object) primary);
        return this;
    }

    public boolean hasPrimary() {
        return super.hasAttribute(PRIMARY);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public PhoneNumber setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public String getUri() {
        return (String) super.getAttributeValue(URI);
    }

    public PhoneNumber setUri(String uri) {
        super.setAttributeValue(URI, (Object) uri);
        return this;
    }

    public boolean hasUri() {
        return super.hasAttribute(URI);
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public PhoneNumber setValue(String value) {
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
        PhoneNumber other = (PhoneNumber) obj;
        if (Element.eq(getLabel(), other.getLabel()) && Element.eq(getPrimary(), other.getPrimary()) && Element.eq(getRel(), other.getRel()) && Element.eq(getUri(), other.getUri()) && Element.eq(getValue(), other.getValue())) {
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
        if (getUri() != null) {
            result = (result * 37) + getUri().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
