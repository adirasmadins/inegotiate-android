package com.google.gdata.wireformats;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import java.io.IOException;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlHandler extends ElementHandler {
    protected final Element element;
    protected final ElementMetadata<?, ?> metadata;
    protected final Element parentElement;
    protected final ValidationContext vc;

    public XmlHandler(ValidationContext vc, Element parent, Element element, ElementMetadata<?, ?> metadata) {
        this.vc = vc;
        this.parentElement = parent;
        this.element = element;
        this.metadata = metadata;
    }

    public Element getElement() {
        return this.element;
    }

    public void processAttribute(QName qn, String value) throws ParseException {
        if (this.element.hasAttribute(qn)) {
            throw new ParseException(CoreErrorDomain.ERR.duplicateAttributeValue.withInternalReason("Duplicate value for attribute " + qn));
        }
        AttributeKey attKey = this.metadata == null ? null : this.metadata.findAttribute(qn);
        if (attKey != null) {
            this.element.setAttributeValue(attKey, ObjectConverter.getValue(value, attKey.getDatatype()));
        } else {
            this.element.setAttributeValue(qn, (Object) value);
        }
    }

    public XmlHandler getChildHandler(QName qName, Attributes attrs, List<XmlNamespace> list) throws ParseException, IOException {
        Element parent;
        ElementMetadata<?, ?> childMeta = findMetadata(qName);
        Element childElement = createChildElement(qName, childMeta);
        if (childMeta == null || childMeta.getCardinality() != Cardinality.SET) {
            this.element.addElement(childElement);
            parent = null;
        } else {
            parent = this.element;
        }
        return createHandler(qName, parent, childElement, childMeta);
    }

    protected XmlHandler createHandler(QName qName, Element parent, Element child, ElementMetadata<?, ?> metadata) {
        return new XmlHandler(this.vc, parent, child, metadata);
    }

    protected ElementMetadata<?, ?> findMetadata(QName qName) {
        if (this.metadata == null) {
            return null;
        }
        ElementKey<?, ?> childKey = this.metadata.findElement(qName);
        if (childKey != null) {
            return this.metadata.bindElement(childKey);
        }
        return null;
    }

    protected Element createChildElement(QName qName, ElementMetadata<?, ?> metadata) throws ParseException {
        if (metadata == null) {
            return new Element(qName);
        }
        try {
            return metadata.createElement();
        } catch (Throwable e) {
            throw new ParseException(e);
        }
    }

    public void processEndElement() throws ParseException {
        if (this.value != null) {
            this.value = this.value.trim();
            if (!this.value.equals(StringUtil.EMPTY_STRING)) {
                this.element.setTextValue(ObjectConverter.getValue(this.value, this.element.getElementKey().getDatatype()));
            }
        }
        if (this.parentElement != null) {
            this.parentElement.addElement(this.element);
        }
    }
}
