package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Street extends Element {
    public static final ElementKey<String, Street> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "street"), String.class, Street.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Street() {
        super(KEY);
    }

    protected Street(ElementKey<String, ? extends Street> key) {
        super((ElementKey) key);
    }

    protected Street(ElementKey<String, ? extends Street> key, Element source) {
        super(key, source);
    }

    public Street(String value) {
        this();
        setValue(value);
    }

    public Street lock() {
        return (Street) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Street setValue(String value) {
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
        return Element.eq(getValue(), ((Street) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
