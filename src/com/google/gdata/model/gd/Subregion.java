package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Subregion extends Element {
    public static final ElementKey<String, Subregion> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "subregion"), String.class, Subregion.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Subregion() {
        super(KEY);
    }

    protected Subregion(ElementKey<String, ? extends Subregion> key) {
        super((ElementKey) key);
    }

    protected Subregion(ElementKey<String, ? extends Subregion> key, Element source) {
        super(key, source);
    }

    public Subregion(String value) {
        this();
        setValue(value);
    }

    public Subregion lock() {
        return (Subregion) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Subregion setValue(String value) {
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
        return Element.eq(getValue(), ((Subregion) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
