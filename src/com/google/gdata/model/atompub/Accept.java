package com.google.gdata.model.atompub;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Accept extends Element {
    public static final ElementKey<String, Accept> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "accept"), String.class, Accept.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
        }
    }

    public Accept() {
        super(KEY);
    }

    protected Accept(ElementKey<String, ? extends Accept> key) {
        super((ElementKey) key);
    }

    protected Accept(ElementKey<String, ? extends Accept> key, Element source) {
        super(key, source);
    }

    public Accept(String value) {
        this();
        setValue(value);
    }

    public Accept lock() {
        return (Accept) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Accept setValue(String value) {
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
        return Element.eq(getValue(), ((Accept) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
