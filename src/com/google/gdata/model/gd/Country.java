package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Country extends Element {
    public static final AttributeKey<String> CODE;
    public static final ElementKey<String, Country> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "country"), String.class, Country.class);
        CODE = AttributeKey.of(new QName(null, "code"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).setContentRequired(false).addAttribute(CODE);
        }
    }

    public Country() {
        super(KEY);
    }

    protected Country(ElementKey<String, ? extends Country> key) {
        super((ElementKey) key);
    }

    protected Country(ElementKey<String, ? extends Country> key, Element source) {
        super(key, source);
    }

    public Country(String value) {
        this();
        setValue(value);
    }

    public Country lock() {
        return (Country) super.lock();
    }

    public String getCode() {
        return (String) super.getAttributeValue(CODE);
    }

    public Country setCode(String code) {
        super.setAttributeValue(CODE, (Object) code);
        return this;
    }

    public boolean hasCode() {
        return super.hasAttribute(CODE);
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Country setValue(String value) {
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
        Country other = (Country) obj;
        if (Element.eq(getCode(), other.getCode()) && Element.eq(getValue(), other.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getCode() != null) {
            result = (result * 37) + getCode().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
