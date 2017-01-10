package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class OrgTitle extends Element {
    public static final ElementKey<String, OrgTitle> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "orgTitle"), String.class, OrgTitle.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
        }
    }

    public OrgTitle() {
        super(KEY);
    }

    protected OrgTitle(ElementKey<String, ? extends OrgTitle> key) {
        super((ElementKey) key);
    }

    protected OrgTitle(ElementKey<String, ? extends OrgTitle> key, Element source) {
        super(key, source);
    }

    public OrgTitle(String value) {
        this();
        setValue(value);
    }

    public OrgTitle lock() {
        return (OrgTitle) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public OrgTitle setValue(String value) {
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
        return Element.eq(getValue(), ((OrgTitle) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
