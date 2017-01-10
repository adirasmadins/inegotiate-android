package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "filename", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Filename extends ValueConstruct {
    static final String XML_NAME = "filename";

    public Filename() {
        this(null);
    }

    public Filename(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
        setRequired(false);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Filename.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Filename value=" + getValue() + "}";
    }
}
