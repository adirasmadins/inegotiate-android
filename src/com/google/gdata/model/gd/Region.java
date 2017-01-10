package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Region extends Element {
    public static final ElementKey<String, Region> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "region"), String.class, Region.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Region() {
        super(KEY);
    }

    protected Region(ElementKey<String, ? extends Region> key) {
        super((ElementKey) key);
    }

    protected Region(ElementKey<String, ? extends Region> key, Element source) {
        super(key, source);
    }

    public Region(String value) {
        this();
        setValue(value);
    }

    public Region lock() {
        return (Region) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Region setValue(String value) {
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
        return Element.eq(getValue(), ((Region) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
