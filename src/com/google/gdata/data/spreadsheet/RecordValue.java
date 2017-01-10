package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "*", nsAlias = "gsx", nsUri = "http://schemas.google.com/spreadsheets/2006/extended")
public class RecordValue extends ValueConstruct {
    static final String XML_NAME = "*";

    public RecordValue() {
        this(null);
    }

    public RecordValue(String value) {
        super(Namespaces.gSpreadCustomNs, XML_NAME, null, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(RecordValue.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{RecordValue value=" + getValue() + "}";
    }
}
