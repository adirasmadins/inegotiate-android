package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(localName = "archiveFailure", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class ArchiveFailure extends AbstractExtension {
    private static final String REASON = "reason";
    static final String XML_NAME = "archiveFailure";
    private String reason;
    private String value;

    public ArchiveFailure() {
        this.reason = null;
        this.value = null;
    }

    public ArchiveFailure(String reason, String value) {
        this.reason = null;
        this.value = null;
        setReason(reason);
        setValue(value);
        setImmutable(true);
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        throwExceptionIfImmutable();
        this.reason = reason;
    }

    public boolean hasReason() {
        return getReason() != null;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        throwExceptionIfImmutable();
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    protected void validate() {
        if (this.value == null) {
            throw new IllegalStateException("Missing text content");
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(ArchiveFailure.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(REASON, this.reason);
        generator.setContent(this.value);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.reason = helper.consume(REASON, false);
        this.value = helper.consume(null, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        ArchiveFailure other = (ArchiveFailure) obj;
        if (AbstractExtension.eq(this.reason, other.reason) && AbstractExtension.eq(this.value, other.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.reason != null) {
            result = (result * 37) + this.reason.hashCode();
        }
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{ArchiveFailure reason=" + this.reason + " value=" + this.value + "}";
    }
}
