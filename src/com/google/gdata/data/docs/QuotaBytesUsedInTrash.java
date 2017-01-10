package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(localName = "quotaBytesUsedInTrash", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class QuotaBytesUsedInTrash extends AbstractExtension {
    static final String XML_NAME = "quotaBytesUsedInTrash";
    private Long value;

    public QuotaBytesUsedInTrash() {
        this.value = null;
    }

    public QuotaBytesUsedInTrash(Long value) {
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
        if (this.value != null && this.value.longValue() < 0) {
            throw new IllegalStateException("Text content must be non-negative: " + this.value);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(QuotaBytesUsedInTrash.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.setContent(this.value.toString());
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.value = Long.valueOf(helper.consumeLong(null, false));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return AbstractExtension.eq(this.value, ((QuotaBytesUsedInTrash) obj).value);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{QuotaBytesUsedInTrash value=" + this.value + "}";
    }
}
