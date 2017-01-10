package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class CreateId extends Element {
    public static final ElementKey<String, CreateId> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "createId"), String.class, CreateId.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public CreateId() {
        super(KEY);
    }

    protected CreateId(ElementKey<String, ? extends CreateId> key) {
        super((ElementKey) key);
    }

    protected CreateId(ElementKey<String, ? extends CreateId> key, Element source) {
        super(key, source);
    }

    public CreateId(String value) {
        this();
        setValue(value);
    }

    public CreateId lock() {
        return (CreateId) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public CreateId setValue(String value) {
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
        return Element.eq(getValue(), ((CreateId) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
