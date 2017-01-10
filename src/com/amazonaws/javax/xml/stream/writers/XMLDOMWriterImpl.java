package com.amazonaws.javax.xml.stream.writers;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.amazonaws.javax.xml.stream.XMLStreamWriter;
import com.amazonaws.javax.xml.transform.dom.DOMResult;
import com.google.gdata.util.common.base.StringUtil;
import java.lang.reflect.Method;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.helpers.NamespaceSupport;

public class XMLDOMWriterImpl implements XMLStreamWriter {
    static /* synthetic */ Class class$java$lang$String;
    private Node currentNode;
    private int depth;
    private Method mXmlVersion;
    private NamespaceSupport namespaceContext;
    private boolean[] needContextPop;
    private Node node;
    private Document ownerDoc;
    private int resizeValue;
    private StringBuffer stringBuffer;

    public XMLDOMWriterImpl(DOMResult result) {
        this.ownerDoc = null;
        this.currentNode = null;
        this.node = null;
        this.namespaceContext = null;
        this.mXmlVersion = null;
        this.needContextPop = null;
        this.stringBuffer = null;
        this.resizeValue = 20;
        this.depth = 0;
        this.node = result.getNode();
        if (this.node.getNodeType() == (short) 9) {
            this.ownerDoc = (Document) this.node;
            this.currentNode = this.ownerDoc;
        } else {
            this.ownerDoc = this.node.getOwnerDocument();
            this.currentNode = this.node;
        }
        getDLThreeMethods();
        this.stringBuffer = new StringBuffer();
        this.needContextPop = new boolean[this.resizeValue];
        this.namespaceContext = new NamespaceSupport();
    }

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        } catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError().initCause(x1);
        }
    }

    private void getDLThreeMethods() {
        try {
            Class class$;
            Class cls = this.ownerDoc.getClass();
            String str = "setXmlVersion";
            Class[] clsArr = new Class[1];
            if (class$java$lang$String == null) {
                class$ = class$("java.lang.String");
                class$java$lang$String = class$;
            } else {
                class$ = class$java$lang$String;
            }
            clsArr[0] = class$;
            this.mXmlVersion = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            this.mXmlVersion = null;
        } catch (SecurityException e2) {
            this.mXmlVersion = null;
        }
    }

    public void close() throws XMLStreamException {
    }

    public void flush() throws XMLStreamException {
    }

    public NamespaceContext getNamespaceContext() {
        return null;
    }

    public String getPrefix(String namespaceURI) throws XMLStreamException {
        if (this.namespaceContext != null) {
            return this.namespaceContext.getPrefix(namespaceURI);
        }
        return null;
    }

    public Object getProperty(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public void setDefaultNamespace(String uri) throws XMLStreamException {
        this.namespaceContext.declarePrefix(StringUtil.EMPTY_STRING, uri);
        if (!this.needContextPop[this.depth]) {
            this.needContextPop[this.depth] = true;
        }
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    public void setPrefix(String prefix, String uri) throws XMLStreamException {
        if (prefix == null) {
            throw new XMLStreamException2("Prefix cannot be null");
        }
        this.namespaceContext.declarePrefix(prefix, uri);
        if (!this.needContextPop[this.depth]) {
            this.needContextPop[this.depth] = true;
        }
    }

    public void writeAttribute(String localName, String value) throws XMLStreamException {
        if (this.currentNode.getNodeType() == (short) 1) {
            Attr attr = this.ownerDoc.createAttribute(localName);
            attr.setValue(value);
            ((Element) this.currentNode).setAttributeNode(attr);
            return;
        }
        throw new IllegalStateException(new StringBuffer().append("Current DOM Node type  is ").append(this.currentNode.getNodeType()).append("and does not allow attributes to be set ").toString());
    }

    public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
        if (this.currentNode.getNodeType() == (short) 1) {
            String prefix = null;
            if (namespaceURI == null) {
                throw new XMLStreamException2("NamespaceURI cannot be null");
            } else if (localName == null) {
                throw new XMLStreamException2("Local name cannot be null");
            } else {
                if (this.namespaceContext != null) {
                    prefix = this.namespaceContext.getPrefix(namespaceURI);
                }
                if (prefix == null) {
                    throw new XMLStreamException2(new StringBuffer().append("Namespace URI ").append(namespaceURI).append("is not bound to any prefix").toString());
                }
                String qualifiedName;
                if (prefix.equals(StringUtil.EMPTY_STRING)) {
                    qualifiedName = localName;
                } else {
                    qualifiedName = getQName(prefix, localName);
                }
                Attr attr = this.ownerDoc.createAttributeNS(namespaceURI, qualifiedName);
                attr.setValue(value);
                ((Element) this.currentNode).setAttributeNode(attr);
                return;
            }
        }
        throw new IllegalStateException(new StringBuffer().append("Current DOM Node type  is ").append(this.currentNode.getNodeType()).append("and does not allow attributes to be set ").toString());
    }

    public void writeAttribute(String prefix, String namespaceURI, String localName, String value) throws XMLStreamException {
        if (this.currentNode.getNodeType() != (short) 1) {
            throw new IllegalStateException(new StringBuffer().append("Current DOM Node type  is ").append(this.currentNode.getNodeType()).append("and does not allow attributes to be set ").toString());
        } else if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else if (localName == null) {
            throw new XMLStreamException2("Local name cannot be null");
        } else if (prefix == null) {
            throw new XMLStreamException2("prefix cannot be null");
        } else {
            String qualifiedName;
            if (prefix.equals(StringUtil.EMPTY_STRING)) {
                qualifiedName = localName;
            } else {
                qualifiedName = getQName(prefix, localName);
            }
            Attr attr = this.ownerDoc.createAttributeNS(namespaceURI, qualifiedName);
            attr.setValue(value);
            ((Element) this.currentNode).setAttributeNodeNS(attr);
        }
    }

    public void writeCData(String data) throws XMLStreamException {
        if (data == null) {
            throw new XMLStreamException2("CDATA cannot be null");
        }
        getNode().appendChild(this.ownerDoc.createCDATASection(data));
    }

    public void writeCharacters(String charData) throws XMLStreamException {
        this.currentNode.appendChild(this.ownerDoc.createTextNode(charData));
    }

    public void writeCharacters(char[] values, int param, int param2) throws XMLStreamException {
        this.currentNode.appendChild(this.ownerDoc.createTextNode(new String(values, param, param2)));
    }

    public void writeComment(String str) throws XMLStreamException {
        getNode().appendChild(this.ownerDoc.createComment(str));
    }

    public void writeDTD(String str) throws XMLStreamException {
        throw new UnsupportedOperationException();
    }

    public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
        if (this.currentNode.getNodeType() == (short) 1) {
            ((Element) this.currentNode).setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLConstants.XMLNS_ATTRIBUTE, namespaceURI);
            return;
        }
        throw new IllegalStateException(new StringBuffer().append("Current DOM Node type  is ").append(this.currentNode.getNodeType()).append("and does not allow attributes to be set ").toString());
    }

    public void writeEmptyElement(String localName) throws XMLStreamException {
        if (this.ownerDoc != null) {
            Element element = this.ownerDoc.createElement(localName);
            if (this.currentNode != null) {
                this.currentNode.appendChild(element);
            } else {
                this.ownerDoc.appendChild(element);
            }
        }
    }

    public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
        if (this.ownerDoc != null) {
            String prefix = null;
            if (namespaceURI == null) {
                throw new XMLStreamException2("NamespaceURI cannot be null");
            } else if (localName == null) {
                throw new XMLStreamException2("Local name cannot be null");
            } else {
                if (this.namespaceContext != null) {
                    prefix = this.namespaceContext.getPrefix(namespaceURI);
                }
                if (prefix == null) {
                    throw new XMLStreamException2(new StringBuffer().append("Namespace URI ").append(namespaceURI).append("is not bound to any prefix").toString());
                }
                String qualifiedName;
                if (StringUtil.EMPTY_STRING.equals(prefix)) {
                    qualifiedName = localName;
                } else {
                    qualifiedName = getQName(prefix, localName);
                }
                Element element = this.ownerDoc.createElementNS(namespaceURI, qualifiedName);
                if (this.currentNode != null) {
                    this.currentNode.appendChild(element);
                } else {
                    this.ownerDoc.appendChild(element);
                }
            }
        }
    }

    public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
        if (this.ownerDoc == null) {
            return;
        }
        if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else if (localName == null) {
            throw new XMLStreamException2("Local name cannot be null");
        } else if (prefix == null) {
            throw new XMLStreamException2("Prefix cannot be null");
        } else {
            String qualifiedName;
            if (StringUtil.EMPTY_STRING.equals(prefix)) {
                qualifiedName = localName;
            } else {
                qualifiedName = getQName(prefix, localName);
            }
            Element el = this.ownerDoc.createElementNS(namespaceURI, qualifiedName);
            if (this.currentNode != null) {
                this.currentNode.appendChild(el);
            } else {
                this.ownerDoc.appendChild(el);
            }
        }
    }

    public void writeEndDocument() throws XMLStreamException {
        this.currentNode = null;
        for (int i = 0; i < this.depth; i++) {
            if (this.needContextPop[this.depth]) {
                this.needContextPop[this.depth] = false;
                this.namespaceContext.popContext();
            }
            this.depth--;
        }
        this.depth = 0;
    }

    public void writeEndElement() throws XMLStreamException {
        Node node = this.currentNode.getParentNode();
        if (this.currentNode.getNodeType() == (short) 9) {
            this.currentNode = null;
        } else {
            this.currentNode = node;
        }
        if (this.needContextPop[this.depth]) {
            this.needContextPop[this.depth] = false;
            this.namespaceContext.popContext();
        }
        this.depth--;
    }

    public void writeEntityRef(String name) throws XMLStreamException {
        this.currentNode.appendChild(this.ownerDoc.createEntityReference(name));
    }

    public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
        if (prefix == null) {
            throw new XMLStreamException2("prefix cannot be null");
        } else if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else {
            String qname;
            if (prefix.equals(StringUtil.EMPTY_STRING)) {
                qname = XMLConstants.XMLNS_ATTRIBUTE;
            } else {
                qname = getQName(XMLConstants.XMLNS_ATTRIBUTE, prefix);
            }
            ((Element) this.currentNode).setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, qname, namespaceURI);
        }
    }

    public void writeProcessingInstruction(String target) throws XMLStreamException {
        if (target == null) {
            throw new XMLStreamException2("Target cannot be null");
        }
        this.currentNode.appendChild(this.ownerDoc.createProcessingInstruction(target, StringUtil.EMPTY_STRING));
    }

    public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
        if (target == null) {
            throw new XMLStreamException2("Target cannot be null");
        }
        this.currentNode.appendChild(this.ownerDoc.createProcessingInstruction(target, data));
    }

    public void writeStartDocument() throws XMLStreamException {
        try {
            if (this.mXmlVersion != null) {
                this.mXmlVersion.invoke(this.ownerDoc, new Object[]{XMLStreamWriterImpl.DEFAULT_XML_VERSION});
            }
        } catch (Throwable iae) {
            throw new XMLStreamException2(iae);
        } catch (Throwable ite) {
            throw new XMLStreamException2(ite);
        }
    }

    public void writeStartDocument(String version) throws XMLStreamException {
        try {
            if (this.mXmlVersion != null) {
                this.mXmlVersion.invoke(this.ownerDoc, new Object[]{version});
            }
        } catch (Throwable iae) {
            throw new XMLStreamException2(iae);
        } catch (Throwable ite) {
            throw new XMLStreamException2(ite);
        }
    }

    public void writeStartDocument(String encoding, String version) throws XMLStreamException {
        try {
            if (this.mXmlVersion != null) {
                this.mXmlVersion.invoke(this.ownerDoc, new Object[]{version});
            }
        } catch (Throwable iae) {
            throw new XMLStreamException2(iae);
        } catch (Throwable ite) {
            throw new XMLStreamException2(ite);
        }
    }

    public void writeStartElement(String localName) throws XMLStreamException {
        if (this.ownerDoc != null) {
            Element element = this.ownerDoc.createElement(localName);
            if (this.currentNode != null) {
                this.currentNode.appendChild(element);
            } else {
                this.ownerDoc.appendChild(element);
            }
            this.currentNode = element;
        }
        if (this.needContextPop[this.depth]) {
            this.namespaceContext.pushContext();
        }
        this.depth++;
    }

    public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
        if (this.ownerDoc != null) {
            String prefix = null;
            if (namespaceURI == null) {
                throw new XMLStreamException2("NamespaceURI cannot be null");
            } else if (localName == null) {
                throw new XMLStreamException2("Local name cannot be null");
            } else {
                if (this.namespaceContext != null) {
                    prefix = this.namespaceContext.getPrefix(namespaceURI);
                }
                if (prefix == null) {
                    throw new XMLStreamException2(new StringBuffer().append("Namespace URI ").append(namespaceURI).append("is not bound to any prefix").toString());
                }
                String qualifiedName;
                if (StringUtil.EMPTY_STRING.equals(prefix)) {
                    qualifiedName = localName;
                } else {
                    qualifiedName = getQName(prefix, localName);
                }
                Element element = this.ownerDoc.createElementNS(namespaceURI, qualifiedName);
                if (this.currentNode != null) {
                    this.currentNode.appendChild(element);
                } else {
                    this.ownerDoc.appendChild(element);
                }
                this.currentNode = element;
            }
        }
        if (this.needContextPop[this.depth]) {
            this.namespaceContext.pushContext();
        }
        this.depth++;
    }

    public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
        if (this.ownerDoc == null) {
            return;
        }
        if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else if (localName == null) {
            throw new XMLStreamException2("Local name cannot be null");
        } else if (prefix == null) {
            throw new XMLStreamException2("Prefix cannot be null");
        } else {
            String qname;
            if (prefix.equals(StringUtil.EMPTY_STRING)) {
                qname = localName;
            } else {
                qname = getQName(prefix, localName);
            }
            Element el = this.ownerDoc.createElementNS(namespaceURI, qname);
            if (this.currentNode != null) {
                this.currentNode.appendChild(el);
            } else {
                this.ownerDoc.appendChild(el);
            }
            this.currentNode = el;
            if (this.needContextPop[this.depth]) {
                this.namespaceContext.pushContext();
            }
            this.depth++;
        }
    }

    private String getQName(String prefix, String localName) {
        this.stringBuffer.setLength(0);
        this.stringBuffer.append(prefix);
        this.stringBuffer.append(":");
        this.stringBuffer.append(localName);
        return this.stringBuffer.toString();
    }

    private Node getNode() {
        if (this.currentNode == null) {
            return this.ownerDoc;
        }
        return this.currentNode;
    }
}
