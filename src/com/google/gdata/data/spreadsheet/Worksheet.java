package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "worksheet", nsAlias = "gs", nsUri = "http://schemas.google.com/spreadsheets/2006")
public class Worksheet extends ValueConstruct {
    private static final String NAME = "name";
    static final String XML_NAME = "worksheet";

    public Worksheet() {
        this(null);
    }

    public Worksheet(String name) {
        super(Namespaces.gSpreadNs, XML_NAME, NAME, name);
    }

    public String getName() {
        return getValue();
    }

    public void setName(String name) {
        setValue(name);
    }

    public boolean hasName() {
        return hasValue();
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Worksheet.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Worksheet name=" + getValue() + "}";
    }
}
