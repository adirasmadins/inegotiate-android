package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class NamePrefix extends Element {
    public static final ElementKey<String, NamePrefix> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "namePrefix"), String.class, NamePrefix.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public NamePrefix() {
        super(KEY);
    }

    protected NamePrefix(ElementKey<String, ? extends NamePrefix> key) {
        super((ElementKey) key);
    }

    protected NamePrefix(ElementKey<String, ? extends NamePrefix> key, Element source) {
        super(key, source);
    }

    public NamePrefix(String value) {
        this();
        setValue(value);
    }

    public NamePrefix lock() {
        return (NamePrefix) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public NamePrefix setValue(String value) {
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
        return Element.eq(getValue(), ((NamePrefix) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
