package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class PoBox extends Element {
    public static final ElementKey<String, PoBox> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "pobox"), String.class, PoBox.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public PoBox() {
        super(KEY);
    }

    protected PoBox(ElementKey<String, ? extends PoBox> key) {
        super((ElementKey) key);
    }

    protected PoBox(ElementKey<String, ? extends PoBox> key, Element source) {
        super(key, source);
    }

    public PoBox(String value) {
        this();
        setValue(value);
    }

    public PoBox lock() {
        return (PoBox) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public PoBox setValue(String value) {
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
        return Element.eq(getValue(), ((PoBox) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
