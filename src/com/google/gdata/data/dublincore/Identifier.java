package com.google.gdata.data.dublincore;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "identifier", nsAlias = "dc", nsUri = "http://purl.org/dc/terms")
public class Identifier extends ValueConstruct {
    static final String XML_NAME = "identifier";

    public Identifier() {
        this(null);
    }

    public Identifier(String value) {
        super(DublincoreNamespace.DC_NS, XML_NAME, null, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Identifier.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Identifier value=" + getValue() + "}";
    }
}
