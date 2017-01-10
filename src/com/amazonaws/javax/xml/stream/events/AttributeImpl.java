package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;

public class AttributeImpl extends DummyEvent implements Attribute {
    private String fAttributeType;
    private boolean fIsSpecified;
    private String fNonNormalizedvalue;
    private QName fQName;
    private String fValue;

    public AttributeImpl() {
        this.fAttributeType = "CDATA";
        init();
    }

    public AttributeImpl(String name, String value) {
        this.fAttributeType = "CDATA";
        init();
        this.fQName = new QName(name);
        this.fValue = value;
    }

    public AttributeImpl(String prefix, String name, String value) {
        this(prefix, null, name, value, null, null, false);
    }

    public AttributeImpl(String prefix, String uri, String localPart, String value, String type) {
        this(prefix, uri, localPart, value, null, type, false);
    }

    public AttributeImpl(String prefix, String uri, String localPart, String value, String nonNormalizedvalue, String type, boolean isSpecified) {
        this(new QName(uri, localPart, prefix), value, nonNormalizedvalue, type, isSpecified);
    }

    public AttributeImpl(QName qname, String value, String nonNormalizedvalue, String type, boolean isSpecified) {
        this.fAttributeType = "CDATA";
        init();
        this.fQName = qname;
        this.fValue = value;
        if (!(type == null || type.equals(StringUtil.EMPTY_STRING))) {
            this.fAttributeType = type;
        }
        this.fNonNormalizedvalue = nonNormalizedvalue;
        this.fIsSpecified = isSpecified;
    }

    public String toString() {
        if (this.fQName.getPrefix() == null || this.fQName.getPrefix().length() <= 0) {
            return new StringBuffer().append(this.fQName.getLocalPart()).append("='").append(this.fValue).append("'").toString();
        }
        return new StringBuffer().append(this.fQName.getPrefix()).append(":").append(this.fQName.getLocalPart()).append("='").append(this.fValue).append("'").toString();
    }

    public void setName(QName name) {
        this.fQName = name;
    }

    public QName getName() {
        return this.fQName;
    }

    public void setValue(String value) {
        this.fValue = value;
    }

    public String getValue() {
        return this.fValue;
    }

    public void setNonNormalizedValue(String nonNormalizedvalue) {
        this.fNonNormalizedvalue = nonNormalizedvalue;
    }

    public String getNonNormalizedValue() {
        return this.fNonNormalizedvalue;
    }

    public void setAttributeType(String attributeType) {
        this.fAttributeType = attributeType;
    }

    public String getDTDType() {
        return this.fAttributeType;
    }

    public void setSpecified(boolean isSpecified) {
        this.fIsSpecified = isSpecified;
    }

    public boolean isSpecified() {
        return this.fIsSpecified;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(toString());
    }

    protected void init() {
        setEventType(10);
    }
}
