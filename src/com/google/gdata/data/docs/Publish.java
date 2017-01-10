package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "publish", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class Publish extends ExtensionPoint {
    private static final String VALUE = "value";
    static final String XML_NAME = "publish";
    private Boolean value;

    public Publish() {
        this.value = null;
    }

    public Publish(Boolean value) {
        this.value = null;
        setValue(value);
        setImmutable(true);
    }

    public Boolean getValue() {
        return this.value;
    }

    public void setValue(Boolean value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(Publish.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(VALUE, this.value);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.value = Boolean.valueOf(helper.consumeBoolean(VALUE, false));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return AbstractExtension.eq(this.value, ((Publish) obj).value);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{Publish value=" + this.value + "}";
    }
}
