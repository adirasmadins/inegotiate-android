package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class OrgJobDescription extends Element {
    public static final ElementKey<String, OrgJobDescription> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "orgJobDescription"), String.class, OrgJobDescription.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public OrgJobDescription() {
        super(KEY);
    }

    protected OrgJobDescription(ElementKey<String, ? extends OrgJobDescription> key) {
        super((ElementKey) key);
    }

    protected OrgJobDescription(ElementKey<String, ? extends OrgJobDescription> key, Element source) {
        super(key, source);
    }

    public OrgJobDescription(String value) {
        this();
        setValue(value);
    }

    public OrgJobDescription lock() {
        return (OrgJobDescription) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public OrgJobDescription setValue(String value) {
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
        return Element.eq(getValue(), ((OrgJobDescription) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
