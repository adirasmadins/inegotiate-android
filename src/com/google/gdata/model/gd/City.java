package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class City extends Element {
    public static final ElementKey<String, City> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "city"), String.class, City.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public City() {
        super(KEY);
    }

    protected City(ElementKey<String, ? extends City> key) {
        super((ElementKey) key);
    }

    protected City(ElementKey<String, ? extends City> key, Element source) {
        super(key, source);
    }

    public City(String value) {
        this();
        setValue(value);
    }

    public City lock() {
        return (City) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public City setValue(String value) {
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
        return Element.eq(getValue(), ((City) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
