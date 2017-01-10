package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.util.ParseException;

@Default(localName = "maxUploadSize", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class MaxUploadSize extends AbstractExtension {
    private static final String KIND = "kind";
    static final String XML_NAME = "maxUploadSize";
    private String kind;
    private Long value;

    public MaxUploadSize() {
        this.kind = null;
        this.value = null;
    }

    public MaxUploadSize(String kind, Long value) {
        this.kind = null;
        this.value = null;
        setKind(kind);
        setValue(value);
        setImmutable(true);
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(String kind) {
        throwExceptionIfImmutable();
        this.kind = kind;
    }

    public boolean hasKind() {
        return getKind() != null;
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
        if (this.kind == null) {
            AbstractExtension.throwExceptionForMissingAttribute(KIND);
        }
        if (this.value == null) {
            throw new IllegalStateException("Missing text content");
        } else if (this.value.longValue() < 0) {
            throw new IllegalStateException("Text content must be non-negative: " + this.value);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(MaxUploadSize.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(KIND, this.kind);
        generator.setContent(this.value.toString());
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.kind = helper.consume(KIND, true);
        this.value = Long.valueOf(helper.consumeLong(null, true));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        MaxUploadSize other = (MaxUploadSize) obj;
        if (AbstractExtension.eq(this.kind, other.kind) && AbstractExtension.eq(this.value, other.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.kind != null) {
            result = (result * 37) + this.kind.hashCode();
        }
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{MaxUploadSize kind=" + this.kind + " value=" + this.value + "}";
    }
}
