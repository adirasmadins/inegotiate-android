package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class NameSuffix extends Element {
    public static final ElementKey<String, NameSuffix> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "nameSuffix"), String.class, NameSuffix.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public NameSuffix() {
        super(KEY);
    }

    protected NameSuffix(ElementKey<String, ? extends NameSuffix> key) {
        super((ElementKey) key);
    }

    protected NameSuffix(ElementKey<String, ? extends NameSuffix> key, Element source) {
        super(key, source);
    }

    public NameSuffix(String value) {
        this();
        setValue(value);
    }

    public NameSuffix lock() {
        return (NameSuffix) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public NameSuffix setValue(String value) {
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
        return Element.eq(getValue(), ((NameSuffix) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
