package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "column", nsAlias = "gs", nsUri = "http://schemas.google.com/spreadsheets/2006")
public class Column extends ExtensionPoint {
    private static final String INDEX = "index";
    private static final String NAME = "name";
    static final String XML_NAME = "column";
    private String index;
    private String name;

    public Column() {
        this.index = null;
        this.name = null;
    }

    public Column(String index, String name) {
        this.index = null;
        this.name = null;
        setIndex(index);
        setName(name);
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

    protected void validate() {
        if (this.index == null) {
            AbstractExtension.throwExceptionForMissingAttribute(INDEX);
        }
        if (this.name == null) {
            AbstractExtension.throwExceptionForMissingAttribute(NAME);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Column.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(INDEX, this.index);
        generator.put(NAME, this.name);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.index = helper.consume(INDEX, true);
        this.name = helper.consume(NAME, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Column other = (Column) obj;
        if (AbstractExtension.eq(this.index, other.index) && AbstractExtension.eq(this.name, other.name)) {
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
            return (result * 37) + this.name.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{Column index=" + this.index + " name=" + this.name + "}";
    }
}
