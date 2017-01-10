package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class ResourceId extends Element {
    public static final ElementKey<String, ResourceId> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "resourceId"), String.class, ResourceId.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public ResourceId() {
        super(KEY);
    }

    protected ResourceId(ElementKey<String, ? extends ResourceId> key) {
        super((ElementKey) key);
    }

    protected ResourceId(ElementKey<String, ? extends ResourceId> key, Element source) {
        super(key, source);
    }

    public ResourceId(String value) {
        this();
        setValue(value);
    }

    public ResourceId lock() {
        return (ResourceId) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public ResourceId setValue(String value) {
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
        return Element.eq(getValue(), ((ResourceId) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
