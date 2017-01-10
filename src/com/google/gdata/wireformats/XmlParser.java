package com.google.gdata.wireformats;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.common.collect.Maps;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.XmlEventSource;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.LogUtils;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParser extends DefaultHandler implements WireFormatParser {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Logger logger;
    ElementHandler curHandler;
    ArrayList<XmlNamespace> elementNamespaces;
    private final XmlEventSource eventSource;
    Locator locator;
    protected Map<String, Stack<NamespaceDecl>> namespaceMap;
    protected final StreamProperties props;
    protected String rootElementName;
    protected ElementHandler rootHandler;
    protected String rootNamespace;
    int unrecognizedElements;

    static class ElementHandler {
        static final /* synthetic */ boolean $assertionsDisabled;
        Set<String> blobNamespaces;
        private StringBuffer buffer;
        boolean fullTextIndex;
        StringWriter fullTextIndexWriter;
        XmlWriter innerXml;
        StringWriter innerXmlStringWriter;
        boolean mixedContent;
        boolean okToInitializeXmlBlob;
        ElementHandler parent;
        public String qName;
        public String value;
        public String xmlBase;
        XmlBlob xmlBlob;
        public String xmlLang;

        static {
            $assertionsDisabled = !XmlParser.class.desiredAssertionStatus();
        }

        ElementHandler() {
            this.xmlBlob = null;
            this.okToInitializeXmlBlob = true;
            this.mixedContent = false;
            this.fullTextIndex = false;
            this.blobNamespaces = new HashSet();
        }

        public ElementHandler getChildHandler(QName qn, Attributes attrs, List<XmlNamespace> list) throws ParseException, IOException {
            if (this.xmlBlob == null) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.unrecognizedElement);
                pe.setInternalReason("Unrecognized element '" + qn.getLocalName() + "'.");
                throw pe;
            }
            XmlParser.logger.fine("No child handler for " + qn.getLocalName() + ". Treating as arbitrary foreign XML.");
            return null;
        }

        public void processAttribute(QName qn, String attrValue) throws ParseException {
        }

        public void processEndElement() throws ParseException {
            if (this.value != null && !this.value.trim().equals(StringUtil.EMPTY_STRING) && !this.mixedContent) {
                throw new ParseException(CoreErrorDomain.ERR.textNotAllowed);
            }
        }

        public void initializeXmlBlob(XmlBlob xmlBlob, boolean mixedContent, boolean fullTextIndex) throws IOException {
            if ($assertionsDisabled || this.okToInitializeXmlBlob) {
                this.xmlBlob = xmlBlob;
                this.mixedContent = mixedContent;
                this.innerXmlStringWriter = new StringWriter();
                this.innerXml = new XmlWriter(this.innerXmlStringWriter);
                this.fullTextIndex = fullTextIndex;
                if (fullTextIndex) {
                    this.fullTextIndexWriter = new StringWriter();
                    return;
                }
                return;
            }
            throw new AssertionError();
        }

        public String getAbsoluteUri(String uriValue) throws ParseException {
            try {
                return XmlParser.getCumulativeXmlBase(this.xmlBase, uriValue);
            } catch (URISyntaxException e) {
                throw new ParseException(e.getMessage());
            }
        }

        public Boolean getBooleanAttribute(Attributes attrs, String attrName) throws ParseException {
            String attrValue = attrs.getValue(StringUtil.EMPTY_STRING, attrName);
            try {
                return parseBooleanValue(attrValue);
            } catch (ParseException e) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidAttributeValue);
                pe.setInternalReason("Invalid value for " + attrName + " attribute: " + attrValue);
                throw pe;
            }
        }

        protected Boolean parseBooleanValue(String booleanValue) throws ParseException {
            if (booleanValue == null) {
                return null;
            }
            if (booleanValue.equalsIgnoreCase("false") || booleanValue.equals("0")) {
                return Boolean.FALSE;
            }
            if (booleanValue.equalsIgnoreCase("true") || booleanValue.equals("1")) {
                return Boolean.TRUE;
            }
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidBooleanAttribute);
            pe.setInternalReason("Invalid value for boolean attribute: " + booleanValue);
            throw pe;
        }
    }

    private static class NamespaceDecl {
        boolean inBlob;
        XmlNamespace ns;

        private NamespaceDecl(XmlNamespace ns) {
            this.ns = ns;
        }
    }

    static {
        $assertionsDisabled = !XmlParser.class.desiredAssertionStatus();
        logger = Logger.getLogger(XmlParser.class.getName());
    }

    public XmlParser(StreamProperties props, Reader r, Charset cs) {
        this(props, new SaxEventSource(r));
        Preconditions.checkNotNull(cs, "cs");
    }

    public XmlParser(StreamProperties props, XmlEventSource eventSource) {
        this.unrecognizedElements = 0;
        this.namespaceMap = Maps.newHashMap();
        this.elementNamespaces = new ArrayList();
        Preconditions.checkNotNull(props, "stream properties");
        Preconditions.checkNotNull(eventSource, "eventSource");
        this.props = props;
        this.eventSource = eventSource;
    }

    public Element parse(Element element) throws IOException, ParseException, ContentValidationException {
        ValidationContext vc = new ValidationContext();
        ElementMetadata<?, ?> metadata = this.props.getRootMetadata();
        this.rootHandler = createRootHandler(vc, element, metadata);
        QName elementName = metadata == null ? element.getElementId() : metadata.getName();
        XmlNamespace elementNs = elementName.getNs();
        this.rootNamespace = elementNs == null ? null : elementNs.getUri();
        this.rootElementName = elementName.getLocalName();
        try {
            this.eventSource.parse(this);
        } catch (Throwable e) {
            Exception rootException = e.getException();
            if (rootException instanceof ParseException) {
                throwParseException((ParseException) rootException);
            } else if (rootException instanceof IOException) {
                LogUtils.logException(logger, Level.WARNING, null, e);
                throw ((IOException) rootException);
            } else {
                LogUtils.logException(logger, Level.FINE, null, e);
                throw new ParseException(e);
            }
        }
        return element.resolve(metadata);
    }

    protected XmlHandler createRootHandler(ValidationContext vc, Element element, ElementMetadata<?, ?> metadata) {
        return new XmlHandler(vc, null, element, metadata);
    }

    protected void throwParseException(ParseException e) throws ParseException {
        if (this.locator != null) {
            String elementLocation = StringUtil.EMPTY_STRING;
            if (this.curHandler != null) {
                elementLocation = elementLocation + ", element " + this.curHandler.qName;
            }
            String location = "[Line " + String.valueOf(this.locator.getLineNumber()) + ", Column " + String.valueOf(this.locator.getColumnNumber()) + elementLocation + "] ";
            LogUtils.logException(logger, Level.FINE, location, e);
            throw new ParseException(location + e.getMessage(), (Throwable) e);
        }
        LogUtils.logException(logger, Level.FINE, null, e);
        throw e;
    }

    static String getCumulativeXmlBase(String curBase, String newBase) throws URISyntaxException {
        URI newBaseUri = new URI(newBase);
        if (curBase != null && !curBase.equals(StringUtil.EMPTY_STRING)) {
            URI resultUri = new URI(curBase).resolve(newBaseUri);
            if ($assertionsDisabled || resultUri.isAbsolute()) {
                return resultUri.toString();
            }
            throw new AssertionError();
        } else if (newBaseUri.isAbsolute()) {
            return newBase;
        } else {
            throw new URISyntaxException(newBase, "No xml:base established--need an absolute URI.");
        }
    }

    public void startElement(String namespace, String localName, String qName, Attributes attrs) throws SAXException {
        logger.fine("Start element " + qName);
        ElementHandler parentHandler = this.curHandler;
        if (this.curHandler == null) {
            if (namespace.equals(this.rootNamespace)) {
                if (localName.equals(this.rootElementName)) {
                    this.curHandler = this.rootHandler;
                }
            }
            if (this.rootElementName != null) {
                String str = this.rootNamespace;
                throw new SAXException(new ParseException("Invalid root element, expected (namespace uri:local name) of (" + r0 + ":" + this.rootElementName + ")" + ", found (" + namespace + ":" + localName));
            }
        } else if (this.curHandler != null && this.unrecognizedElements == 0) {
            try {
                this.curHandler = this.curHandler.getChildHandler(createQName(qName, namespace, localName), attrs, this.elementNamespaces);
            } catch (ParseException e) {
                throw new SAXException(e);
            } catch (IOException e2) {
                throw new SAXException(e2);
            }
        }
        int i;
        if (this.curHandler == null || this.unrecognizedElements != 0) {
            this.unrecognizedElements++;
            Iterator i$ = this.elementNamespaces.iterator();
            while (i$.hasNext()) {
                XmlNamespace ns = (XmlNamespace) i$.next();
                Stack<NamespaceDecl> nsDecls = (Stack) this.namespaceMap.get(ns.getAlias());
                if (nsDecls != null && nsDecls.size() > 0) {
                    ((NamespaceDecl) nsDecls.peek()).inBlob = true;
                }
            }
            if (this.curHandler == null) {
                this.curHandler = parentHandler;
            }
            if (this.curHandler != null) {
                if (this.curHandler.innerXml != null) {
                    ArrayList<Attribute> attrList = new ArrayList(attrs.getLength());
                    for (i = attrs.getLength() - 1; i >= 0; i--) {
                        String qNameAttr = attrs.getQName(i);
                        ensureBlobNamespace(this.curHandler, qNameAttr);
                        String value = attrs.getValue(i);
                        attrList.add(new Attribute(qNameAttr, value));
                        if (this.curHandler.fullTextIndex) {
                            this.curHandler.fullTextIndexWriter.write(value);
                            this.curHandler.fullTextIndexWriter.write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                    }
                    try {
                        ensureBlobNamespace(this.curHandler, qName);
                        this.curHandler.innerXml.startElement(null, qName, attrList, this.elementNamespaces);
                    } catch (IOException e22) {
                        throw new SAXException(e22);
                    }
                }
            }
        }
        String attrNamespace;
        this.curHandler.parent = parentHandler;
        this.curHandler.qName = qName;
        if (parentHandler != null) {
            ElementHandler elementHandler = this.curHandler;
            elementHandler.xmlLang = parentHandler.xmlLang;
            elementHandler = this.curHandler;
            elementHandler.xmlBase = parentHandler.xmlBase;
        }
        i = 0;
        while (i < attrs.getLength()) {
            String attrLocalName;
            String attrValue;
            try {
                attrNamespace = attrs.getURI(i);
                attrLocalName = attrs.getLocalName(i);
                attrValue = attrs.getValue(i);
                if (attrNamespace.equals(Namespaces.xml)) {
                    if (attrLocalName.equals("lang")) {
                        this.curHandler.xmlLang = attrValue;
                        logger.finer("xml:lang=" + attrValue);
                    } else {
                        if (attrLocalName.equals("base")) {
                            elementHandler = this.curHandler;
                            elementHandler.xmlBase = getCumulativeXmlBase(this.curHandler.xmlBase, attrValue);
                            logger.finer("xml:base=" + this.curHandler.xmlBase);
                        }
                    }
                }
                i++;
            } catch (ParseException e3) {
                throw new SAXException(e3);
            } catch (URISyntaxException e4) {
                throw new SAXException(new ParseException(e4.getMessage()));
            } catch (NumberFormatException e5) {
                throw new SAXException(new ParseException("Invalid integer format. " + e5.getMessage()));
            }
        }
        for (i = 0; i < attrs.getLength(); i++) {
            attrNamespace = attrs.getURI(i);
            String attrQName = attrs.getQName(i);
            attrLocalName = attrs.getLocalName(i);
            attrValue = attrs.getValue(i);
            logger.finer("Attribute " + attrLocalName + "='" + attrValue + "'");
            this.curHandler.processAttribute(createQName(attrQName, attrNamespace, attrLocalName), attrValue);
        }
        this.curHandler.okToInitializeXmlBlob = false;
        if (this.curHandler.xmlBlob != null) {
            if (this.curHandler.xmlLang != null) {
                this.curHandler.xmlBlob.setLang(this.curHandler.xmlLang);
            }
            if (this.curHandler.xmlBase != null) {
                this.curHandler.xmlBlob.setBase(this.curHandler.xmlBase);
            }
        }
        this.elementNamespaces.clear();
    }

    public void endElement(String namespace, String localName, String qName) throws SAXException {
        logger.fine("End element " + qName);
        if (this.unrecognizedElements > 0) {
            this.unrecognizedElements--;
            if (this.curHandler != null && this.curHandler.innerXml != null) {
                try {
                    this.curHandler.innerXml.endElement();
                } catch (IOException e) {
                    throw new SAXException(e);
                }
            }
        } else if (this.curHandler != null) {
            if (this.curHandler.xmlBlob != null) {
                StringBuffer blob = this.curHandler.innerXmlStringWriter.getBuffer();
                if (blob.length() != 0) {
                    this.curHandler.xmlBlob.setBlob(blob.toString());
                    if (this.curHandler.fullTextIndex) {
                        this.curHandler.xmlBlob.setFullText(this.curHandler.fullTextIndexWriter.toString());
                    }
                }
            }
            try {
                if (this.curHandler.buffer != null) {
                    this.curHandler.value = this.curHandler.buffer.toString();
                    this.curHandler.buffer = null;
                }
                this.curHandler.processEndElement();
                this.curHandler = this.curHandler.parent;
            } catch (ParseException e2) {
                throw new SAXException(e2);
            }
        }
    }

    public void characters(char[] text, int start, int len) throws SAXException {
        if (this.curHandler != null) {
            if (this.unrecognizedElements == 0) {
                if (this.curHandler.buffer == null) {
                    this.curHandler.buffer = new StringBuffer();
                }
                this.curHandler.buffer.append(text, start, len);
            }
            if (this.curHandler.innerXml == null) {
                return;
            }
            if (this.curHandler.mixedContent || this.unrecognizedElements > 0) {
                if (this.curHandler.fullTextIndex) {
                    this.curHandler.fullTextIndexWriter.write(text, start, len);
                    this.curHandler.fullTextIndexWriter.write("\n");
                }
                try {
                    this.curHandler.innerXml.characters(new String(text, start, len));
                } catch (IOException e) {
                    throw new SAXException(e);
                }
            }
        }
    }

    public void ignorableWhitespace(char[] text, int start, int len) throws SAXException {
        if (this.curHandler != null && this.curHandler.innerXml != null) {
            if (this.curHandler.mixedContent || this.unrecognizedElements > 0) {
                try {
                    this.curHandler.innerXml.writeUnescaped(new String(text, start, len));
                } catch (IOException e) {
                    throw new SAXException(e);
                }
            }
        }
    }

    public void setDocumentLocator(Locator newLocator) {
        this.locator = newLocator;
    }

    public void startPrefixMapping(String alias, String uri) {
        Stack<NamespaceDecl> mapping = (Stack) this.namespaceMap.get(alias);
        if (mapping == null) {
            mapping = new Stack();
            this.namespaceMap.put(alias, mapping);
        }
        XmlNamespace ns = new XmlNamespace(alias, uri);
        mapping.push(new NamespaceDecl(null));
        this.elementNamespaces.add(ns);
    }

    public void endPrefixMapping(String alias) {
        ((Stack) this.namespaceMap.get(alias)).pop();
    }

    private void ensureBlobNamespace(ElementHandler handler, String qName) {
        NamespaceDecl nsDecl = null;
        String alias = qName.substring(0, Math.max(0, qName.indexOf(":")));
        if (!alias.equals(XMLConstants.XML_NS_PREFIX)) {
            Stack<NamespaceDecl> mapping = (Stack) this.namespaceMap.get(alias);
            if (mapping != null) {
                nsDecl = (NamespaceDecl) mapping.peek();
            }
            if (!$assertionsDisabled && alias.length() != 0 && nsDecl == null) {
                throw new AssertionError("Namespace alias '" + alias + "' should be mapped in 'namespaceMap'.");
            } else if (nsDecl != null && !nsDecl.inBlob && nsDecl.ns != null && !handler.blobNamespaces.contains(alias)) {
                handler.blobNamespaces.add(alias);
                handler.xmlBlob.getNamespaces().add(new XmlNamespace(alias, nsDecl.ns.getUri()));
            }
        }
    }

    private static QName createQName(String qName, String nsUri, String localName) {
        XmlNamespace ns = null;
        if (!StringUtil.isEmpty(nsUri)) {
            String[] parts = qName.split(":");
            if (parts.length == 2) {
                ns = new XmlNamespace(parts[0], nsUri);
            } else {
                ns = new XmlNamespace(null, nsUri);
            }
        }
        return new QName(ns, localName);
    }
}
