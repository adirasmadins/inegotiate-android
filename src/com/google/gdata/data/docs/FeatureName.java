package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ValueConstruct;

@Default(localName = "featureName", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class FeatureName extends ValueConstruct {
    static final String XML_NAME = "featureName";

    public FeatureName() {
        this(null);
    }

    public FeatureName(String value) {
        super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(FeatureName.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    public String toString() {
        return "{FeatureName value=" + getValue() + "}";
    }
}
