package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "archiveNotify", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class ArchiveNotify extends ValueConstruct {
    static final String XML_NAME = "archiveNotify";

    public ArchiveNotify() {
        this(null);
    }

    public ArchiveNotify(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(ArchiveNotify.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{ArchiveNotify value=" + getValue() + "}";
    }
}
