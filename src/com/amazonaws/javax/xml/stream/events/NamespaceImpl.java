package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.namespace.QName;
import com.google.gdata.util.common.base.StringUtil;

public class NamespaceImpl extends AttributeImpl implements Namespace {
    public NamespaceImpl() {
        init();
    }

    public NamespaceImpl(String namespaceURI) {
        super(XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XMLNS_ATTRIBUTE_NS_URI, StringUtil.EMPTY_STRING, namespaceURI, null);
        init();
    }

    public NamespaceImpl(String prefix, String namespaceURI) {
        super(XMLConstants.XMLNS_ATTRIBUTE, XMLConstants.XMLNS_ATTRIBUTE_NS_URI, prefix, namespaceURI, null);
        init();
    }

    public boolean isDefaultNamespaceDeclaration() {
        QName name = getName();
        if (name == null || !name.getLocalPart().equals(StringUtil.EMPTY_STRING)) {
            return false;
        }
        return true;
    }

    void setPrefix(String prefix) {
        if (prefix == null) {
            setName(new QName(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, StringUtil.EMPTY_STRING, XMLConstants.XMLNS_ATTRIBUTE));
        } else {
            setName(new QName(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, prefix, XMLConstants.XMLNS_ATTRIBUTE));
        }
    }

    public String getPrefix() {
        QName name = getName();
        if (name != null) {
            return name.getLocalPart();
        }
        return null;
    }

    public String getNamespaceURI() {
        return getValue();
    }

    void setNamespaceURI(String uri) {
        setValue(uri);
    }

    protected void init() {
        setEventType(13);
    }

    public int getEventType() {
        return 13;
    }

    public boolean isNamespace() {
        return true;
    }
}
