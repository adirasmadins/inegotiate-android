package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "artist", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Artist extends ValueConstruct {
    static final String XML_NAME = "artist";

    public Artist() {
        this(null);
    }

    public Artist(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
        setRequired(false);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Artist.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Artist value=" + getValue() + "}";
    }
}
