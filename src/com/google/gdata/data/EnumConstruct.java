package com.google.gdata.data;

import com.google.gdata.util.common.xml.XmlNamespace;
import java.util.Set;

public abstract class EnumConstruct extends ValueConstruct {
    protected Set<String> values;

    protected EnumConstruct(XmlNamespace namespace, String tagName, String attrName, Set<String> values) {
        this(namespace, tagName, attrName, values, null);
    }

    protected EnumConstruct(XmlNamespace namespace, String tagName, String attrName, Set<String> values, String initialValue) {
        super(namespace, tagName, attrName);
        if (values == null) {
            throw new NullPointerException("Null values set");
        }
        this.values = values;
        if (initialValue != null) {
            setValue(initialValue);
            setImmutable(true);
        }
    }

    public void setValue(String v) throws IllegalArgumentException {
        if (this.values.contains(v)) {
            super.setValue(v);
            return;
        }
        throw new IllegalArgumentException("Invalid " + this.localName + " value:" + v);
    }
}
