package com.google.gdata.data;

import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public abstract class ValueConstruct extends AbstractExtension {
    protected final String attrName;
    private boolean required;
    private String value;

    public final boolean isRequired() {
        return this.required;
    }

    protected final void setRequired(boolean isRequired) {
        this.required = isRequired;
    }

    protected ValueConstruct(String attrName) {
        this.required = true;
        this.attrName = attrName;
    }

    protected ValueConstruct(XmlNamespace namespace, String localName, String attrName) {
        this(namespace, localName, attrName, null);
    }

    protected ValueConstruct(XmlNamespace namespace, String localName, String attrName, String value) {
        super(namespace, localName);
        this.required = true;
        this.attrName = attrName;
        if (value != null) {
            setValue(value);
            setImmutable(true);
        }
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String v) {
        throwExceptionIfImmutable();
        this.value = v;
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public void putAttributes(AttributeGenerator generator) {
        if (this.attrName != null) {
            generator.put(this.attrName, this.value);
        } else {
            generator.setContent(this.value);
        }
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        String actualValue;
        if (this.attrName != null) {
            actualValue = helper.consume(this.attrName, isRequired());
        } else {
            actualValue = helper.consumeContent(isRequired());
        }
        try {
            setValue(actualValue);
        } catch (Throwable iae) {
            throw new ParseException(iae.getMessage(), iae);
        }
    }

    public void generate(XmlWriter w, ExtensionProfile p) throws IOException {
        if (this.value != null) {
            super.generate(w, p);
        }
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) throws ParseException {
        this.value = null;
        return super.getHandler(p, namespace, localName, attrs);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!sameClassAs(o)) {
            return false;
        }
        return AbstractExtension.eq(this.value, ((ValueConstruct) o).value);
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (this.value != null) {
            return (result * 37) + this.value.hashCode();
        }
        return result;
    }
}
