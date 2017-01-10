package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class HouseName extends Element {
    public static final ElementKey<String, HouseName> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "housename"), String.class, HouseName.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public HouseName() {
        super(KEY);
    }

    protected HouseName(ElementKey<String, ? extends HouseName> key) {
        super((ElementKey) key);
    }

    protected HouseName(ElementKey<String, ? extends HouseName> key, Element source) {
        super(key, source);
    }

    public HouseName(String value) {
        this();
        setValue(value);
    }

    public HouseName lock() {
        return (HouseName) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public HouseName setValue(String value) {
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
        return Element.eq(getValue(), ((HouseName) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
