package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "header", nsAlias = "gs", nsUri = "http://schemas.google.com/spreadsheets/2006")
public class Header extends ExtensionPoint {
    private static final String ROW = "row";
    static final String XML_NAME = "header";
    private Integer row;

    public Header() {
        this.row = null;
    }

    public Header(Integer row) {
        this.row = null;
        setRow(row);
        setImmutable(true);
    }

    public Integer getRow() {
        return this.row;
    }

    public void setRow(Integer row) {
        throwExceptionIfImmutable();
        this.row = row;
    }

    public boolean hasRow() {
        return getRow() != null;
    }

    protected void validate() {
        if (this.row == null) {
            AbstractExtension.throwExceptionForMissingAttribute(ROW);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Header.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(ROW, this.row);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.row = Integer.valueOf(helper.consumeInteger(ROW, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return AbstractExtension.eq(this.row, ((Header) obj).row);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.row != null) {
            return (result * 37) + this.row.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{Header row=" + this.row + "}";
    }
}
