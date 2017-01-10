package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "md5Checksum", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Md5Checksum extends ValueConstruct {
    static final String XML_NAME = "md5Checksum";

    public Md5Checksum() {
        this(null);
    }

    public Md5Checksum(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Md5Checksum.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Md5Checksum value=" + getValue() + "}";
    }
}
