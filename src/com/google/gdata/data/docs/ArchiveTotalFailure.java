package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(localName = "archiveTotalFailure", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class ArchiveTotalFailure extends AbstractExtension {
    static final String XML_NAME = "archiveTotalFailure";
    private Integer value;

    public ArchiveTotalFailure() {
        this.value = null;
    }

    public ArchiveTotalFailure(Integer value) {
        this.value = null;
        setValue(value);
        setImmutable(true);
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
        if (this.value == null) {
            throw new IllegalStateException("Missing text content");
        } else if (this.value.intValue() < 0) {
            throw new IllegalStateException("Text content must be non-negative: " + this.value);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(ArchiveTotalFailure.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.setContent(this.value.toString());
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.value = Integer.valueOf(helper.consumeInteger(null, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return AbstractExtension.eq(this.value, ((ArchiveTotalFailure) obj).value);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{ArchiveTotalFailure value=" + this.value + "}";
    }
}
