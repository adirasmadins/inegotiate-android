package com.google.gdata.data.acl;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.AttributeHelper.LowerCaseEnumToAttributeValue;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(isRequired = true, localName = "scope", nsAlias = "gAcl", nsUri = "http://schemas.google.com/acl/2007")
public class AclScope extends AbstractExtension {
    private static final String NAME = "name";
    static final String SCOPE = "scope";
    private static final String TYPE = "type";
    private static final LowerCaseEnumToAttributeValue<Type> TYPE_ENUM_TO_ATTRIBUTE_VALUE;
    private static final String VALUE = "value";
    private String name;
    private Type type;
    private String value;

    public enum Type {
        INVITE,
        USER,
        DOMAIN,
        GROUP,
        DEFAULT
    }

    static {
        TYPE_ENUM_TO_ATTRIBUTE_VALUE = new LowerCaseEnumToAttributeValue();
    }

    public AclScope() {
        this.type = null;
        this.value = null;
        this.name = null;
    }

    public AclScope(Type type, String value) {
        this.type = null;
        this.value = null;
        this.name = null;
        setType(type);
        setValue(value);
        setImmutable(true);
    }

    public AclScope(Type type, String value, String name) {
        this.type = null;
        this.value = null;
        this.name = null;
        setType(type);
        setValue(value);
        setName(name);
        setImmutable(true);
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        throwExceptionIfImmutable();
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        throwExceptionIfImmutable();
        this.name = name;
    }

    public String toExternalForm() {
        if (this.type == Type.DEFAULT) {
            return getTypeIdentifier(this.type);
        }
        return getTypeIdentifier(this.type) + ":" + this.value;
    }

    public static AclScope fromExternalForm(String externalForm) {
        if (externalForm == null) {
            return null;
        }
        if (externalForm.equals(getTypeIdentifier(Type.DEFAULT))) {
            return new AclScope(Type.DEFAULT, null);
        }
        String[] components = externalForm.split(":");
        if (components.length != 2) {
            return null;
        }
        Type type = getType(components[0]);
        if (type == null || type == Type.DEFAULT) {
            return null;
        }
        return new AclScope(type, components[1]);
    }

    protected void validate() {
        if (this.type == null) {
            AbstractExtension.throwExceptionForMissingAttribute(TYPE);
        }
        if (this.type == Type.DEFAULT) {
            if (this.value != null) {
                throw new IllegalStateException("attribute value should not be set for default type");
            }
        } else if (this.value == null) {
            AbstractExtension.throwExceptionForMissingAttribute(VALUE);
        }
    }

    public void putAttributes(AttributeGenerator generator) {
        generator.put(TYPE, this.type, TYPE_ENUM_TO_ATTRIBUTE_VALUE);
        generator.put(VALUE, this.value);
        generator.put(NAME, this.name);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.type = (Type) helper.consumeEnum(TYPE, true, Type.class, null, TYPE_ENUM_TO_ATTRIBUTE_VALUE);
        this.value = helper.consume(VALUE, false);
        this.name = helper.consume(NAME, false);
    }

    private static String getTypeIdentifier(Type type) {
        return TYPE_ENUM_TO_ATTRIBUTE_VALUE.getAttributeValue(type);
    }

    private static Type getType(String identifier) {
        for (Type type : Type.values()) {
            if (TYPE_ENUM_TO_ATTRIBUTE_VALUE.getAttributeValue(type).equals(identifier)) {
                return type;
            }
        }
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!sameClassAs(o)) {
            return false;
        }
        AclScope vc = (AclScope) o;
        if (AbstractExtension.eq(this.value, vc.value) && AbstractExtension.eq(this.type, vc.type) && AbstractExtension.eq(this.name, vc.name)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            result = (result * 37) + this.value.hashCode();
        }
        if (this.type != null) {
            result = (result * 37) + this.type.hashCode();
        }
        if (this.name != null) {
            return (result * 37) + this.name.hashCode();
        }
        return result;
    }

    public String toString() {
        return "[AclScope type=" + this.type + " value=" + this.value + " name=" + this.name + "]";
    }
}
