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

@Default(localName = "exportFormat", nsAlias = "docs", nsUri = "http://schemas.google.com/docs/2007")
public class ExportFormat extends ExtensionPoint {
    private static final String SOURCE = "source";
    private static final EnumToAttributeValue<Source> SOURCE_ENUM_TO_ATTRIBUTE_VALUE;
    private static final String TARGET = "target";
    static final String XML_NAME = "exportFormat";
    private Source source;
    private String target;

    public enum Source {
        DOCUMENT,
        DRAWING,
        PRESENTATION,
        SPREADSHEET
    }

    static {
        SOURCE_ENUM_TO_ATTRIBUTE_VALUE = new LowerCaseEnumToAttributeValue();
    }

    public ExportFormat() {
        this.source = null;
        this.target = null;
    }

    public ExportFormat(Source source, String target) {
        this.source = null;
        this.target = null;
        setSource(source);
        setTarget(target);
        setImmutable(true);
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        throwExceptionIfImmutable();
        this.source = source;
    }

    public boolean hasSource() {
        return getSource() != null;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
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
        ExtensionDescription desc = ExtensionDescription.getDefaultDescription(ExportFormat.class);
        desc.setRequired(required);
        desc.setRepeatable(repeatable);
        return desc;
    }

    protected void putAttributes(AttributeGenerator generator) {
        generator.put(SOURCE, this.source, SOURCE_ENUM_TO_ATTRIBUTE_VALUE);
        generator.put(TARGET, this.target);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.source = (Source) helper.consumeEnum(SOURCE, true, Source.class, null, SOURCE_ENUM_TO_ATTRIBUTE_VALUE);
        this.target = helper.consume(TARGET, true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        ExportFormat other = (ExportFormat) obj;
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
        return "{ExportFormat source=" + this.source + " target=" + this.target + "}";
    }
}
