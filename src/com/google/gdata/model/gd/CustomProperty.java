package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class CustomProperty extends Element {
    public static final ElementKey<String, CustomProperty> KEY;
    public static final AttributeKey<String> NAME;
    public static final AttributeKey<String> TYPE;
    public static final AttributeKey<String> UNIT;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "customProperty"), String.class, CustomProperty.class);
        NAME = AttributeKey.of(new QName(null, "name"), String.class);
        TYPE = AttributeKey.of(new QName(null, "type"), String.class);
        UNIT = AttributeKey.of(new QName(null, "unit"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(NAME).setRequired(true);
            builder.addAttribute(TYPE);
            builder.addAttribute(UNIT);
        }
    }

    public CustomProperty() {
        super(KEY);
    }

    protected CustomProperty(ElementKey<String, ? extends CustomProperty> key) {
        super((ElementKey) key);
    }

    protected CustomProperty(ElementKey<String, ? extends CustomProperty> key, Element source) {
        super(key, source);
    }

    public CustomProperty(String value) {
        this();
        setValue(value);
    }

    public CustomProperty lock() {
        return (CustomProperty) super.lock();
    }

    public String getName() {
        return (String) super.getAttributeValue(NAME);
    }

    public CustomProperty setName(String name) {
        super.setAttributeValue(NAME, (Object) name);
        return this;
    }

    public boolean hasName() {
        return super.hasAttribute(NAME);
    }

    public String getType() {
        return (String) super.getAttributeValue(TYPE);
    }

    public CustomProperty setType(String type) {
        super.setAttributeValue(TYPE, (Object) type);
        return this;
    }

    public boolean hasType() {
        return super.hasAttribute(TYPE);
    }

    public String getUnit() {
        return (String) super.getAttributeValue(UNIT);
    }

    public CustomProperty setUnit(String unit) {
        super.setAttributeValue(UNIT, (Object) unit);
        return this;
    }

    public boolean hasUnit() {
        return super.hasAttribute(UNIT);
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public CustomProperty setValue(String value) {
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
        CustomProperty other = (CustomProperty) obj;
        if (Element.eq(getName(), other.getName()) && Element.eq(getType(), other.getType()) && Element.eq(getUnit(), other.getUnit()) && Element.eq(getValue(), other.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getName() != null) {
            result = (result * 37) + getName().hashCode();
        }
        if (getType() != null) {
            result = (result * 37) + getType().hashCode();
        }
        if (getUnit() != null) {
            result = (result * 37) + getUnit().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
