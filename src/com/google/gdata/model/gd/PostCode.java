package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class PostCode extends Element {
    public static final ElementKey<String, PostCode> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "postcode"), String.class, PostCode.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public PostCode() {
        super(KEY);
    }

    protected PostCode(ElementKey<String, ? extends PostCode> key) {
        super((ElementKey) key);
    }

    protected PostCode(ElementKey<String, ? extends PostCode> key, Element source) {
        super(key, source);
    }

    public PostCode(String value) {
        this();
        setValue(value);
    }

    public PostCode lock() {
        return (PostCode) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public PostCode setValue(String value) {
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
        return Element.eq(getValue(), ((PostCode) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
