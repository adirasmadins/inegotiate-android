package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "changestamp", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Changestamp extends ExtensionPoint {
    private static final String VALUE = "value";
    static final String XML_NAME = "changestamp";
    private Long value;

    public Changestamp() {
        this.value = null;
    }

    public Changestamp(Long value) {
        this.value = null;
        setValue(value);
        setImmutable(true);
    }

    public Long getValue() {
        return this.value;
    }

    public void setValue(Long value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Changestamp.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(VALUE, this.value);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.value = Long.valueOf(helper.consumeLong(VALUE, false));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return AbstractExtension.eq(this.value, ((Changestamp) obj).value);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{Changestamp value=" + this.value + "}";
    }
}
