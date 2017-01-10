package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class FormattedAddress extends Element {
    public static final ElementKey<String, FormattedAddress> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "formattedAddress"), String.class, FormattedAddress.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public FormattedAddress() {
        super(KEY);
    }

    protected FormattedAddress(ElementKey<String, ? extends FormattedAddress> key) {
        super((ElementKey) key);
    }

    protected FormattedAddress(ElementKey<String, ? extends FormattedAddress> key, Element source) {
        super(key, source);
    }

    public FormattedAddress(String value) {
        this();
        setValue(value);
    }

    public FormattedAddress lock() {
        return (FormattedAddress) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public FormattedAddress setValue(String value) {
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
        return Element.eq(getValue(), ((FormattedAddress) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
