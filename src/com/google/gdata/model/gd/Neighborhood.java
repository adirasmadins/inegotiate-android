package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Neighborhood extends Element {
    public static final ElementKey<String, Neighborhood> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "neighborhood"), String.class, Neighborhood.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Neighborhood() {
        super(KEY);
    }

    protected Neighborhood(ElementKey<String, ? extends Neighborhood> key) {
        super((ElementKey) key);
    }

    protected Neighborhood(ElementKey<String, ? extends Neighborhood> key, Element source) {
        super(key, source);
    }

    public Neighborhood(String value) {
        this();
        setValue(value);
    }

    public Neighborhood lock() {
        return (Neighborhood) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Neighborhood setValue(String value) {
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
        return Element.eq(getValue(), ((Neighborhood) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
