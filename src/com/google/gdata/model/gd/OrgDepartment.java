package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class OrgDepartment extends Element {
    public static final ElementKey<String, OrgDepartment> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "orgDepartment"), String.class, OrgDepartment.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public OrgDepartment() {
        super(KEY);
    }

    protected OrgDepartment(ElementKey<String, ? extends OrgDepartment> key) {
        super((ElementKey) key);
    }

    protected OrgDepartment(ElementKey<String, ? extends OrgDepartment> key, Element source) {
        super(key, source);
    }

    public OrgDepartment(String value) {
        this();
        setValue(value);
    }

    public OrgDepartment lock() {
        return (OrgDepartment) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public OrgDepartment setValue(String value) {
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
        return Element.eq(getValue(), ((OrgDepartment) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
