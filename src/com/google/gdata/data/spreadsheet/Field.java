package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(localName = "field", nsAlias = "gs", nsUri = "http://schemas.google.com/spreadsheets/2006")
public class Field extends AbstractExtension {
    private static final String INDEX = "index";
    private static final String NAME = "name";
    static final String XML_NAME = "field";
    private String index;
    private String name;
    private String value;

    public Field() {
        this.index = null;
        this.name = null;
        this.value = null;
    }

    public Field(String index, String name, String value) {
        this.index = null;
        this.name = null;
        this.value = null;
        setIndex(index);
        setName(name);
        setValue(value);
        setImmutable(true);
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        throwExceptionIfImmutable();
        this.index = index;
    }

    public boolean hasIndex() {
        return getIndex() != null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        throwExceptionIfImmutable();
        this.name = name;
    }

    public boolean hasName() {
        return getName() != null;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
        if (this.name == null) {
            AbstractExtension.throwExceptionForMissingAttribute(NAME);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Field.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(INDEX, this.index);
        generator.put(NAME, this.name);
        generator.setContent(this.value);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.index = helper.consume(INDEX, false);
        this.name = helper.consume(NAME, true);
        this.value = helper.consume(null, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Field other = (Field) obj;
        if (AbstractExtension.eq(this.index, other.index) && AbstractExtension.eq(this.name, other.name) && AbstractExtension.eq(this.value, other.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.index != null) {
            result = (result * 37) + this.index.hashCode();
        }
        if (this.name != null) {
            result = (result * 37) + this.name.hashCode();
        }
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{Field index=" + this.index + " name=" + this.name + " value=" + this.value + "}";
    }
}
