package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "albumArt", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class AlbumArt extends ValueConstruct {
    static final String XML_NAME = "albumArt";

    public AlbumArt() {
        this(null);
    }

    public AlbumArt(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
        setRequired(false);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(AlbumArt.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{AlbumArt value=" + getValue() + "}";
    }
}
