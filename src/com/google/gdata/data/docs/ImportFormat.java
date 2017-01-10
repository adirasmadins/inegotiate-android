package com.google.gdata.data.docs;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.AttributeHelper.EnumToAttributeValue;
import com.google.gdata.data.AttributeHelper.LowerCaseEnumToAttributeValue;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionDescription.Default;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.util.ParseException;

@Default(localName = "importFormat", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class ImportFormat extends ExtensionPoint {
    private static final String SOURCE = "source";
    private static final String TARGET = "target";
    private static final EnumToAttributeValue<Target> TARGET_ENUM_TO_ATTRIBUTE_VALUE;
    static final String XML_NAME = "importFormat";
    private String source;
    private Target target;

    public enum Target {
        DOCUMENT,
        DRAWING,
        PRESENTATION,
        SPREADSHEET
    }

    static {
        TARGET_ENUM_TO_ATTRIBUTE_VALUE = new LowerCaseEnumToAttributeValue();
    }

    public ImportFormat() {
        this.source = null;
        this.target = null;
    }

    public ImportFormat(String source, Target target) {
        this.source = null;
        this.target = null;
        setSource(source);
        setTarget(target);
        setImmutable(true);
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        throwExceptionIfImmutable();
        this.source = source;
    }

    public boolean hasSource() {
        return getSource() != null;
    }

    public Target getTarget() {
        return this.target;
    }

    public void setTarget(Target target) {
        throwExceptionIfImmutable();
        this.target = target;
    }

    public boolean hasTarget() {
        return getTarget() != null;
    }

    protected void validate() {
        if (this.source == null) {
            AbstractExtension.throwExceptionForMissingAttribute(SOURCE);
        }
        if (this.target == null) {
            AbstractExtension.throwExceptionForMissingAttribute(TARGET);
        }
    }

    public static ExtensionDescription getDefaultDescription(boolean required, boolean repeatable) {
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(ImportFormat.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(SOURCE, this.source);
        generator.put(TARGET, this.target, TARGET_ENUM_TO_ATTRIBUTE_VALUE);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.source = helper.consume(SOURCE, true);
        this.target = (Target) helper.consumeEnum(TARGET, true, Target.class, null, TARGET_ENUM_TO_ATTRIBUTE_VALUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        ImportFormat other = (ImportFormat) obj;
        if (AbstractExtension.eq(this.source, other.source) && AbstractExtension.eq(this.target, other.target)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.source != null) {
            result = (result * 37) + this.source.hashCode();
        }
        if (this.target != null) {
            return (result * 37) + this.target.hashCode();
        }
        return result;
    }

    public String toString() {
        return "{ImportFormat source=" + this.source + " target=" + this.target + "}";
    }
}
