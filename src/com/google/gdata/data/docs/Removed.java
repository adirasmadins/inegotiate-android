package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;

@Default(localName = "removed", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Removed extends ExtensionPoint {
    static final String XML_NAME = "removed";

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Removed.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{Removed}";
    }
}
