package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class OrgSymbol extends Element {
    public static final ElementKey<String, OrgSymbol> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "orgSymbol"), String.class, OrgSymbol.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public OrgSymbol() {
        super(KEY);
    }

    protected OrgSymbol(ElementKey<String, ? extends OrgSymbol> key) {
        super((ElementKey) key);
    }

    protected OrgSymbol(ElementKey<String, ? extends OrgSymbol> key, Element source) {
        super(key, source);
    }

    public OrgSymbol(String value) {
        this();
        setValue(value);
    }

    public OrgSymbol lock() {
        return (OrgSymbol) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public OrgSymbol setValue(String value) {
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
        return Element.eq(getValue(), ((OrgSymbol) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
