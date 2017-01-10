package com.amazonaws.javax.xml.stream.writers;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.stream.Constants;
import com.amazonaws.javax.xml.stream.PropertyManager;
import com.amazonaws.javax.xml.stream.XMLOutputFactory;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.amazonaws.javax.xml.stream.XMLStreamWriter;
import com.amazonaws.javax.xml.stream.util.ReadOnlyIterator;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.transform.stream.StreamResult;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.base.StringUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

public final class XMLStreamWriterImpl extends AbstractMap implements XMLStreamWriter {
    public static final String CLOSE_EMPTY_ELEMENT = "/>";
    public static final char CLOSE_END_TAG = '>';
    public static final char CLOSE_START_TAG = '>';
    public static final String DEFAULT_ENCODING = " encoding=\"utf-8\"";
    public static final String DEFAULT_XMLDECL = "<?xml version=\"1.0\" ?>";
    public static final String DEFAULT_XML_VERSION = "1.0";
    public static final String END_CDATA = "]]>";
    public static final String END_COMMENT = "-->";
    public static final String OPEN_END_TAG = "</";
    public static final char OPEN_START_TAG = '<';
    public static final String OUTPUTSTREAM_PROPERTY = "sjsxp-outputstream";
    public static final String SPACE = " ";
    public static final String START_CDATA = "<![CDATA[";
    public static final String START_COMMENT = "<!--";
    public static final String UTF_8 = "UTF-8";
    private final String DEFAULT_PREFIX;
    HashMap fAttrNamespace;
    private ArrayList fAttributeCache;
    private ElementStack fElementStack;
    private CharsetEncoder fEncoder;
    boolean fEscapeCharacters;
    private NamespaceSupport fInternalNamespaceContext;
    private boolean fIsRepairingNamespace;
    private NamespaceContextImpl fNamespaceContext;
    private ArrayList fNamespaceDecls;
    private OutputStream fOutputStream;
    private Random fPrefixGen;
    private PropertyManager fPropertyManager;
    private final ReadOnlyIterator fReadOnlyIterator;
    private boolean fReuse;
    private boolean fStartTagOpened;
    private SymbolTable fSymbolTable;
    private Writer fWriter;

    class Attribute extends QName {
        String value;

        Attribute(String value) {
            this.value = value;
        }
    }

    protected class ElementStack {
        protected short fDepth;
        protected ElementState[] fElements;

        public ElementStack() {
            this.fElements = new ElementState[10];
            for (int i = 0; i < this.fElements.length; i++) {
                this.fElements[i] = new ElementState();
            }
        }

        public ElementState push(ElementState element) {
            if (this.fDepth == this.fElements.length) {
                ElementState[] array = new ElementState[(this.fElements.length * 2)];
                System.arraycopy(this.fElements, 0, array, 0, this.fDepth);
                this.fElements = array;
                for (int i = this.fDepth; i < this.fElements.length; i++) {
                    this.fElements[i] = new ElementState();
                }
            }
            this.fElements[this.fDepth].setValues(element);
            ElementState[] elementStateArr = this.fElements;
            short s = this.fDepth;
            this.fDepth = (short) (s + 1);
            return elementStateArr[s];
        }

        public ElementState push(String prefix, String localpart, String rawname, String uri, boolean isEmpty) {
            if (this.fDepth == this.fElements.length) {
                ElementState[] array = new ElementState[(this.fElements.length * 2)];
                System.arraycopy(this.fElements, 0, array, 0, this.fDepth);
                this.fElements = array;
                for (int i = this.fDepth; i < this.fElements.length; i++) {
                    this.fElements[i] = new ElementState();
                }
            }
            this.fElements[this.fDepth].setValues(prefix, localpart, rawname, uri, isEmpty);
            ElementState[] elementStateArr = this.fElements;
            short s = this.fDepth;
            this.fDepth = (short) (s + 1);
            return elementStateArr[s];
        }

        public ElementState pop() {
            ElementState[] elementStateArr = this.fElements;
            short s = (short) (this.fDepth - 1);
            this.fDepth = s;
            return elementStateArr[s];
        }

        public void clear() {
            this.fDepth = (short) 0;
        }

        public ElementState peek() {
            return this.fElements[this.fDepth - 1];
        }

        public boolean empty() {
            return this.fDepth <= (short) 0;
        }
    }

    class ElementState extends QName {
        public boolean isEmpty;

        public ElementState() {
            this.isEmpty = false;
        }

        public ElementState(String prefix, String localpart, String rawname, String uri) {
            super(prefix, localpart, rawname, uri);
            this.isEmpty = false;
        }

        public void setValues(String prefix, String localpart, String rawname, String uri, boolean isEmpty) {
            super.setValues(prefix, localpart, rawname, uri);
            this.isEmpty = isEmpty;
        }
    }

    class NamespaceContextImpl implements NamespaceContext {
        NamespaceSupport internalContext;
        NamespaceContext userContext;

        NamespaceContextImpl() {
            this.userContext = null;
            this.internalContext = null;
        }

        public String getNamespaceURI(String prefix) {
            if (prefix != null) {
                prefix = XMLStreamWriterImpl.this.fSymbolTable.addSymbol(prefix);
            }
            if (this.internalContext != null) {
                String uri = this.internalContext.getURI(prefix);
                if (uri != null) {
                    return uri;
                }
            }
            if (this.userContext != null) {
                return this.userContext.getNamespaceURI(prefix);
            }
            return null;
        }

        public String getPrefix(String uri) {
            if (uri != null) {
                uri = XMLStreamWriterImpl.this.fSymbolTable.addSymbol(uri);
            }
            if (this.internalContext != null) {
                String prefix = this.internalContext.getPrefix(uri);
                if (prefix != null) {
                    return prefix;
                }
            }
            if (this.userContext != null) {
                return this.userContext.getPrefix(uri);
            }
            return null;
        }

        public Iterator getPrefixes(String uri) {
            Vector prefixes = null;
            Iterator itr = null;
            if (uri != null) {
                uri = XMLStreamWriterImpl.this.fSymbolTable.addSymbol(uri);
            }
            if (this.userContext != null) {
                itr = this.userContext.getPrefixes(uri);
            }
            if (this.internalContext != null) {
                prefixes = this.internalContext.getPrefixes(uri);
            }
            if (prefixes == null && itr != null) {
                return itr;
            }
            if (prefixes != null && itr == null) {
                return new ReadOnlyIterator(prefixes.iterator());
            }
            if (prefixes == null || itr == null) {
                return XMLStreamWriterImpl.this.fReadOnlyIterator;
            }
            while (itr.hasNext()) {
                String ob = (String) itr.next();
                if (ob != null) {
                    ob = XMLStreamWriterImpl.this.fSymbolTable.addSymbol(ob);
                }
                if (!prefixes.contains(ob)) {
                    prefixes.add(ob);
                }
            }
            return new ReadOnlyIterator(prefixes.iterator());
        }
    }

    public XMLStreamWriterImpl(OutputStream outputStream, PropertyManager props) throws IOException {
        this(new OutputStreamWriter(outputStream), props);
    }

    public XMLStreamWriterImpl(OutputStream outputStream, String encoding, PropertyManager props) throws IOException {
        this(new StreamResult(outputStream), encoding, props);
    }

    public XMLStreamWriterImpl(Writer writer, PropertyManager props) throws IOException {
        this(new StreamResult(writer), null, props);
    }

    public XMLStreamWriterImpl(StreamResult sr, String encoding, PropertyManager props) throws IOException {
        this.fEscapeCharacters = true;
        this.fIsRepairingNamespace = false;
        this.fOutputStream = null;
        this.fNamespaceContext = null;
        this.fInternalNamespaceContext = null;
        this.fPrefixGen = null;
        this.fPropertyManager = null;
        this.fStartTagOpened = false;
        this.fSymbolTable = new SymbolTable();
        this.fElementStack = new ElementStack();
        this.DEFAULT_PREFIX = this.fSymbolTable.addSymbol(StringUtil.EMPTY_STRING);
        this.fReadOnlyIterator = new ReadOnlyIterator();
        this.fEncoder = null;
        this.fAttrNamespace = null;
        setOutput(sr, encoding);
        this.fPropertyManager = props;
        init();
    }

    private void init() {
        this.fReuse = false;
        this.fNamespaceDecls = new ArrayList();
        this.fPrefixGen = new Random();
        this.fInternalNamespaceContext = new NamespaceSupport();
        this.fNamespaceContext = new NamespaceContextImpl();
        this.fNamespaceContext.internalContext = this.fInternalNamespaceContext;
        this.fIsRepairingNamespace = ((Boolean) this.fPropertyManager.getProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES)).booleanValue();
        if (this.fIsRepairingNamespace) {
            this.fAttributeCache = new ArrayList();
        }
        setEscapeCharacters(((Boolean) this.fPropertyManager.getProperty(Constants.ESCAPE_CHARACTERS)).booleanValue());
    }

    public void reset() {
        reset(false);
    }

    void reset(boolean resetProperties) {
        if (this.fReuse) {
            this.fReuse = false;
            this.fNamespaceDecls.clear();
            if (this.fIsRepairingNamespace) {
                this.fAttributeCache.clear();
            }
            this.fElementStack.clear();
            this.fInternalNamespaceContext.reset();
            this.fStartTagOpened = false;
            this.fNamespaceContext.userContext = null;
            if (resetProperties) {
                this.fIsRepairingNamespace = ((Boolean) this.fPropertyManager.getProperty(XMLOutputFactory.IS_REPAIRING_NAMESPACES)).booleanValue();
                setEscapeCharacters(((Boolean) this.fPropertyManager.getProperty(Constants.ESCAPE_CHARACTERS)).booleanValue());
                return;
            }
            return;
        }
        throw new IllegalStateException("close() Must be called before calling reset()");
    }

    public void setOutput(StreamResult sr, String encoding) throws IOException {
        if (sr.getOutputStream() != null) {
            setOutputUsingStream(sr.getOutputStream(), encoding);
        } else if (sr.getWriter() != null) {
            setOutputUsingWriter(sr.getWriter());
        } else if (sr.getSystemId() != null) {
            setOutputUsingStream(new FileOutputStream(sr.getSystemId()), encoding);
        }
    }

    private void setOutputUsingWriter(Writer writer) throws IOException {
        this.fWriter = writer;
        if (writer instanceof OutputStreamWriter) {
            String charset = ((OutputStreamWriter) writer).getEncoding();
            if (charset != null && !charset.equalsIgnoreCase("utf-8")) {
                this.fEncoder = Charset.forName(charset).newEncoder();
            }
        }
    }

    private void setOutputUsingStream(OutputStream os, String encoding) throws IOException {
        this.fOutputStream = os;
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
            if (encoding == null || !encoding.equalsIgnoreCase("utf-8")) {
                this.fWriter = new XMLWriter(new OutputStreamWriter(os));
            } else {
                this.fWriter = new UTF8OutputStreamWriter(os);
            }
        } else if (encoding.equalsIgnoreCase("utf-8")) {
            this.fWriter = new UTF8OutputStreamWriter(os);
        } else {
            this.fWriter = new XMLWriter(new OutputStreamWriter(os, encoding));
            this.fEncoder = Charset.forName(encoding).newEncoder();
        }
    }

    public boolean canReuse() {
        return this.fReuse;
    }

    public void setEscapeCharacters(boolean escape) {
        this.fEscapeCharacters = escape;
    }

    public boolean getEscapeCharacters() {
        return this.fEscapeCharacters;
    }

    public void close() throws XMLStreamException {
        if (this.fWriter != null) {
            try {
                this.fWriter.flush();
            } catch (Throwable e) {
                throw new XMLStreamException2(e);
            }
        }
        this.fWriter = null;
        this.fOutputStream = null;
        this.fNamespaceDecls.clear();
        if (this.fIsRepairingNamespace) {
            this.fAttributeCache.clear();
        }
        this.fElementStack.clear();
        this.fInternalNamespaceContext.reset();
        this.fReuse = true;
    }

    public void flush() throws XMLStreamException {
        try {
            this.fWriter.flush();
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public NamespaceContext getNamespaceContext() {
        return this.fNamespaceContext;
    }

    public String getPrefix(String uri) throws XMLStreamException {
        return this.fNamespaceContext.getPrefix(uri);
    }

    public Object getProperty(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException();
        } else if (!this.fPropertyManager.containsProperty(str)) {
            throw new IllegalArgumentException(new StringBuffer().append("Property '").append(str).append("' is not supported").toString());
        } else if (str.equals("http://java.sun.com/xml/stream/properties/outputstream")) {
            return this.fOutputStream;
        } else {
            return this.fPropertyManager.getProperty(str);
        }
    }

    public void setDefaultNamespace(String uri) throws XMLStreamException {
        if (uri != null) {
            uri = this.fSymbolTable.addSymbol(uri);
        }
        if (!this.fIsRepairingNamespace) {
            this.fInternalNamespaceContext.declarePrefix(this.DEFAULT_PREFIX, uri);
        } else if (!isDefaultNamespace(uri)) {
            QName qname = new QName();
            qname.setValues(this.DEFAULT_PREFIX, XMLConstants.XMLNS_ATTRIBUTE, null, uri);
            this.fNamespaceDecls.add(qname);
        }
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.fNamespaceContext.userContext = namespaceContext;
    }

    public void setPrefix(String prefix, String uri) throws XMLStreamException {
        if (prefix == null) {
            throw new XMLStreamException2("Prefix cannot be null");
        } else if (uri == null) {
            throw new XMLStreamException2("URI cannot be null");
        } else {
            prefix = this.fSymbolTable.addSymbol(prefix);
            uri = this.fSymbolTable.addSymbol(uri);
            if (this.fIsRepairingNamespace) {
                String tmpURI = this.fInternalNamespaceContext.getURI(prefix);
                if ((tmpURI == null || tmpURI != uri) && !checkUserNamespaceContext(prefix, uri)) {
                    QName qname = new QName();
                    qname.setValues(prefix, XMLConstants.XMLNS_ATTRIBUTE, null, uri);
                    this.fNamespaceDecls.add(qname);
                    return;
                }
                return;
            }
            this.fInternalNamespaceContext.declarePrefix(prefix, uri);
        }
    }

    public void writeAttribute(String localName, String value) throws XMLStreamException {
        try {
            if (!this.fStartTagOpened) {
                throw new XMLStreamException2("Attribute not associated with any element");
            } else if (this.fIsRepairingNamespace) {
                Attribute attr = new Attribute(value);
                attr.setValues(null, localName, null, null);
                this.fAttributeCache.add(attr);
            } else {
                this.fWriter.write(SPACE);
                this.fWriter.write(localName);
                this.fWriter.write("=\"");
                writeXMLContent(value, true, true);
                this.fWriter.write("\"");
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeAttribute(String namespaceURI, String localName, String value) throws XMLStreamException {
        try {
            if (!this.fStartTagOpened) {
                throw new XMLStreamException2("Attribute not associated with any element");
            } else if (namespaceURI == null) {
                throw new XMLStreamException2("NamespaceURI cannot be null");
            } else {
                namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
                String prefix = this.fInternalNamespaceContext.getPrefix(namespaceURI);
                if (this.fIsRepairingNamespace) {
                    Attribute attr = new Attribute(value);
                    attr.setValues(null, localName, null, namespaceURI);
                    this.fAttributeCache.add(attr);
                } else if (prefix == null) {
                    throw new XMLStreamException2("Prefix cannot be null");
                } else {
                    writeAttributeWithPrefix(prefix, localName, value);
                }
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    private void writeAttributeWithPrefix(String prefix, String localName, String value) throws IOException {
        this.fWriter.write(SPACE);
        if (!(prefix == null || prefix == StringUtil.EMPTY_STRING)) {
            this.fWriter.write(prefix);
            this.fWriter.write(":");
        }
        this.fWriter.write(localName);
        this.fWriter.write("=\"");
        writeXMLContent(value, true, true);
        this.fWriter.write("\"");
    }

    public void writeAttribute(String prefix, String namespaceURI, String localName, String value) throws XMLStreamException {
        try {
            if (!this.fStartTagOpened) {
                throw new XMLStreamException2("Attribute not associated with any element");
            } else if (namespaceURI == null) {
                throw new XMLStreamException2("NamespaceURI cannot be null");
            } else if (localName == null) {
                throw new XMLStreamException2("Local name cannot be null");
            } else if (this.fIsRepairingNamespace) {
                if (prefix != null) {
                    prefix = this.fSymbolTable.addSymbol(prefix);
                }
                namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
                Attribute attr = new Attribute(value);
                attr.setValues(prefix, localName, null, namespaceURI);
                this.fAttributeCache.add(attr);
            } else if (prefix != null && !prefix.equals(StringUtil.EMPTY_STRING)) {
                if (!(prefix.equals(XMLConstants.XML_NS_PREFIX) && namespaceURI.equals(Namespaces.xml))) {
                    prefix = this.fSymbolTable.addSymbol(prefix);
                    namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
                    if (this.fInternalNamespaceContext.containsPrefixInCurrentContext(prefix)) {
                        String tmpURI = this.fInternalNamespaceContext.getURI(prefix);
                        if (!(tmpURI == null || tmpURI == namespaceURI)) {
                            throw new XMLStreamException2(new StringBuffer().append("Prefix ").append(prefix).append(" is ").append("already bound to ").append(tmpURI).append(". Trying to rebind it to ").append(namespaceURI).append(" is an error.").toString());
                        }
                    }
                    this.fInternalNamespaceContext.declarePrefix(prefix, namespaceURI);
                }
                writeAttributeWithPrefix(prefix, localName, value);
            } else if (namespaceURI.equals(StringUtil.EMPTY_STRING)) {
                writeAttributeWithPrefix(null, localName, value);
            } else {
                throw new XMLStreamException2("prefix cannot be null or empty");
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeCData(String cdata) throws XMLStreamException {
        if (cdata == null) {
            try {
                throw new XMLStreamException2("cdata cannot be null");
            } catch (Throwable e) {
                throw new XMLStreamException2(e);
            }
        }
        if (this.fStartTagOpened) {
            closeStartTag();
        }
        this.fWriter.write(START_CDATA);
        this.fWriter.write(cdata);
        this.fWriter.write(END_CDATA);
    }

    public void writeCharacters(String data) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            writeXMLContent(data);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeCharacters(char[] data, int start, int len) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            writeXMLContent(data, start, len, this.fEscapeCharacters);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeComment(String comment) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            this.fWriter.write(START_COMMENT);
            if (comment != null) {
                this.fWriter.write(comment);
            }
            this.fWriter.write(END_COMMENT);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeDTD(String dtd) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            this.fWriter.write(dtd);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeDefaultNamespace(String namespaceURI) throws XMLStreamException {
        String namespaceURINormalized;
        if (namespaceURI == null) {
            namespaceURINormalized = StringUtil.EMPTY_STRING;
        } else {
            namespaceURINormalized = namespaceURI;
        }
        try {
            if (!this.fStartTagOpened) {
                throw new IllegalStateException("Namespace Attribute not associated with any element");
            } else if (this.fIsRepairingNamespace) {
                QName qname = new QName();
                qname.setValues(StringUtil.EMPTY_STRING, XMLConstants.XMLNS_ATTRIBUTE, null, namespaceURINormalized);
                this.fNamespaceDecls.add(qname);
            } else {
                namespaceURINormalized = this.fSymbolTable.addSymbol(namespaceURINormalized);
                if (this.fInternalNamespaceContext.containsPrefixInCurrentContext(StringUtil.EMPTY_STRING)) {
                    String tmp = this.fInternalNamespaceContext.getURI(StringUtil.EMPTY_STRING);
                    if (!(tmp == null || tmp == namespaceURINormalized)) {
                        throw new XMLStreamException2(new StringBuffer().append("xmlns has been already bound to ").append(tmp).append(". Rebinding it to ").append(namespaceURINormalized).append(" is an error").toString());
                    }
                }
                this.fInternalNamespaceContext.declarePrefix(StringUtil.EMPTY_STRING, namespaceURINormalized);
                writenamespace(null, namespaceURINormalized);
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeEmptyElement(String localName) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            openStartTag();
            this.fElementStack.push(null, localName, null, null, true);
            this.fInternalNamespaceContext.pushContext();
            if (!this.fIsRepairingNamespace) {
                this.fWriter.write(localName);
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeEmptyElement(String namespaceURI, String localName) throws XMLStreamException {
        if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        }
        namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
        writeEmptyElement(this.fNamespaceContext.getPrefix(namespaceURI), localName, namespaceURI);
    }

    public void writeEmptyElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
        if (localName == null) {
            try {
                throw new XMLStreamException2("Local Name cannot be null");
            } catch (Throwable e) {
                throw new XMLStreamException2(e);
            }
        } else if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else {
            if (prefix != null) {
                prefix = this.fSymbolTable.addSymbol(prefix);
            }
            namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            openStartTag();
            this.fElementStack.push(prefix, localName, null, namespaceURI, true);
            this.fInternalNamespaceContext.pushContext();
            if (!this.fIsRepairingNamespace) {
                if (prefix == null) {
                    throw new XMLStreamException2(new StringBuffer().append("NamespaceURI ").append(namespaceURI).append(" has not been bound to any prefix").toString());
                }
                if (!(prefix == null || prefix == StringUtil.EMPTY_STRING)) {
                    this.fWriter.write(prefix);
                    this.fWriter.write(":");
                }
                this.fWriter.write(localName);
            }
        }
    }

    public void writeEndDocument() throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            while (!this.fElementStack.empty()) {
                ElementState elem = this.fElementStack.pop();
                this.fInternalNamespaceContext.popContext();
                if (!elem.isEmpty) {
                    this.fWriter.write(OPEN_END_TAG);
                    if (!(elem.prefix == null || elem.prefix.equals(StringUtil.EMPTY_STRING))) {
                        this.fWriter.write(elem.prefix);
                        this.fWriter.write(":");
                    }
                    this.fWriter.write(elem.localpart);
                    this.fWriter.write(62);
                }
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new XMLStreamException2("No more elements to write");
        }
    }

    public void writeEndElement() throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            ElementState currentElement = this.fElementStack.pop();
            if (currentElement == null) {
                throw new XMLStreamException2("No element was found to write");
            } else if (!currentElement.isEmpty) {
                this.fWriter.write(OPEN_END_TAG);
                if (!(currentElement.prefix == null || currentElement.prefix.equals(StringUtil.EMPTY_STRING))) {
                    this.fWriter.write(currentElement.prefix);
                    this.fWriter.write(":");
                }
                this.fWriter.write(currentElement.localpart);
                this.fWriter.write(62);
                this.fInternalNamespaceContext.popContext();
            }
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        } catch (Throwable e2) {
            throw new XMLStreamException2(new StringBuffer().append("No element was found to write: ").append(e2.toString()).toString(), e2);
        }
    }

    public void writeEntityRef(String refName) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            this.fWriter.write(38);
            this.fWriter.write(refName);
            this.fWriter.write(59);
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
        String namespaceURINormalized;
        Throwable e;
        if (namespaceURI == null) {
            namespaceURINormalized = StringUtil.EMPTY_STRING;
        } else {
            namespaceURINormalized = namespaceURI;
        }
        try {
            if (this.fStartTagOpened) {
                if (prefix != null) {
                    if (!(prefix.equals(StringUtil.EMPTY_STRING) || prefix.equals(XMLConstants.XMLNS_ATTRIBUTE))) {
                        if (!prefix.equals(XMLConstants.XML_NS_PREFIX) || !namespaceURINormalized.equals(Namespaces.xml)) {
                            prefix = this.fSymbolTable.addSymbol(prefix);
                            namespaceURINormalized = this.fSymbolTable.addSymbol(namespaceURINormalized);
                            if (this.fIsRepairingNamespace) {
                                String tmpURI = this.fInternalNamespaceContext.getURI(prefix);
                                if (tmpURI == null || tmpURI != namespaceURINormalized) {
                                    QName qname = new QName();
                                    QName qName;
                                    try {
                                        qname.setValues(prefix, XMLConstants.XMLNS_ATTRIBUTE, null, namespaceURINormalized);
                                        this.fNamespaceDecls.add(qname);
                                        qName = qname;
                                        return;
                                    } catch (IOException e2) {
                                        e = e2;
                                        qName = qname;
                                        throw new XMLStreamException2(e);
                                    }
                                }
                                return;
                            }
                            if (this.fInternalNamespaceContext.containsPrefixInCurrentContext(prefix)) {
                                String tmp = this.fInternalNamespaceContext.getURI(prefix);
                                if (!(tmp == null || tmp == namespaceURINormalized)) {
                                    throw new XMLStreamException2(new StringBuffer().append("prefix ").append(prefix).append(" has been already bound to ").append(tmp).append(". Rebinding it to ").append(namespaceURINormalized).append(" is an error").toString());
                                }
                            }
                            this.fInternalNamespaceContext.declarePrefix(prefix, namespaceURINormalized);
                            writenamespace(prefix, namespaceURINormalized);
                            return;
                        }
                        return;
                    }
                }
                writeDefaultNamespace(namespaceURINormalized);
                return;
            }
            throw new IllegalStateException(new StringBuffer().append("Invalid state: start tag is not opened at writeNamespace(").append(prefix).append(", ").append(namespaceURINormalized).append(")").toString());
        } catch (IOException e3) {
            e = e3;
            throw new XMLStreamException2(e);
        }
    }

    private void writenamespace(String prefix, String namespaceURI) throws IOException {
        this.fWriter.write(" xmlns");
        if (!(prefix == null || prefix == StringUtil.EMPTY_STRING)) {
            this.fWriter.write(":");
            this.fWriter.write(prefix);
        }
        this.fWriter.write("=\"");
        writeXMLContent(namespaceURI, true, true);
        this.fWriter.write("\"");
    }

    public void writeProcessingInstruction(String target) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            if (target != null) {
                this.fWriter.write("<?");
                this.fWriter.write(target);
                this.fWriter.write("?>");
                return;
            }
            throw new XMLStreamException2("PI target cannot be null");
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
        try {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            if (target == null || data == null) {
                throw new XMLStreamException2("PI target cannot be null");
            }
            this.fWriter.write("<?");
            this.fWriter.write(target);
            this.fWriter.write(SPACE);
            this.fWriter.write(data);
            this.fWriter.write("?>");
        } catch (Throwable e) {
            throw new XMLStreamException2(e);
        }
    }

    public void writeStartDocument() throws XMLStreamException {
        try {
            this.fWriter.write(DEFAULT_XMLDECL);
        } catch (Throwable ex) {
            throw new XMLStreamException2(ex);
        }
    }

    public void writeStartDocument(String version) throws XMLStreamException {
        if (version != null) {
            try {
                if (!version.equals(StringUtil.EMPTY_STRING)) {
                    this.fWriter.write("<?xml version=\"");
                    this.fWriter.write(version);
                    this.fWriter.write("\"");
                    this.fWriter.write("?>");
                    return;
                }
            } catch (Throwable ex) {
                throw new XMLStreamException2(ex);
            }
        }
        writeStartDocument();
    }

    public void writeStartDocument(String encoding, String version) throws XMLStreamException {
        if (encoding == null && version == null) {
            try {
                writeStartDocument();
            } catch (Throwable ex) {
                throw new XMLStreamException2(ex);
            }
        } else if (encoding == null) {
            writeStartDocument(version);
        } else {
            String streamEncoding = null;
            if (this.fWriter instanceof OutputStreamWriter) {
                streamEncoding = ((OutputStreamWriter) this.fWriter).getEncoding();
            } else if (this.fWriter instanceof UTF8OutputStreamWriter) {
                streamEncoding = ((UTF8OutputStreamWriter) this.fWriter).getEncoding();
            } else if (this.fWriter instanceof XMLWriter) {
                streamEncoding = ((OutputStreamWriter) ((XMLWriter) this.fWriter).getWriter()).getEncoding();
            }
            if (!(streamEncoding == null || streamEncoding.equalsIgnoreCase(encoding))) {
                boolean foundAlias = false;
                Iterator it = Charset.forName(encoding).aliases().iterator();
                while (!foundAlias && it.hasNext()) {
                    if (streamEncoding.equalsIgnoreCase((String) it.next())) {
                        foundAlias = true;
                    }
                }
                if (!foundAlias) {
                    throw new XMLStreamException2(new StringBuffer().append("Underlying stream encoding '").append(streamEncoding).append("' and input paramter for writeStartDocument() method '").append(encoding).append("' do not match.").toString());
                }
            }
            this.fWriter.write("<?xml version=\"");
            if (version == null || version.equals(StringUtil.EMPTY_STRING)) {
                this.fWriter.write(DEFAULT_XML_VERSION);
            } else {
                this.fWriter.write(version);
            }
            if (!encoding.equals(StringUtil.EMPTY_STRING)) {
                this.fWriter.write("\" encoding=\"");
                this.fWriter.write(encoding);
            }
            this.fWriter.write("\"?>");
        }
    }

    public void writeStartElement(String localName) throws XMLStreamException {
        if (localName == null) {
            try {
                throw new XMLStreamException2("Local Name cannot be null");
            } catch (Throwable ex) {
                throw new XMLStreamException2(ex);
            }
        }
        if (this.fStartTagOpened) {
            closeStartTag();
        }
        openStartTag();
        this.fElementStack.push(null, localName, null, null, false);
        this.fInternalNamespaceContext.pushContext();
        if (!this.fIsRepairingNamespace) {
            this.fWriter.write(localName);
        }
    }

    public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
        if (localName == null) {
            throw new XMLStreamException2("Local Name cannot be null");
        } else if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else {
            namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
            String prefix = null;
            if (!this.fIsRepairingNamespace) {
                prefix = this.fNamespaceContext.getPrefix(namespaceURI);
                if (prefix != null) {
                    prefix = this.fSymbolTable.addSymbol(prefix);
                }
            }
            writeStartElement(prefix, localName, namespaceURI);
        }
    }

    public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
        if (localName == null) {
            try {
                throw new XMLStreamException2("Local Name cannot be null");
            } catch (Throwable ex) {
                throw new XMLStreamException2(ex);
            }
        } else if (namespaceURI == null) {
            throw new XMLStreamException2("NamespaceURI cannot be null");
        } else if (this.fIsRepairingNamespace || prefix != null) {
            if (this.fStartTagOpened) {
                closeStartTag();
            }
            openStartTag();
            namespaceURI = this.fSymbolTable.addSymbol(namespaceURI);
            if (prefix != null) {
                prefix = this.fSymbolTable.addSymbol(prefix);
            }
            this.fElementStack.push(prefix, localName, null, namespaceURI, false);
            this.fInternalNamespaceContext.pushContext();
            String tmpPrefix = this.fNamespaceContext.getPrefix(namespaceURI);
            if (prefix != null && (tmpPrefix == null || !prefix.equals(tmpPrefix))) {
                this.fInternalNamespaceContext.declarePrefix(prefix, namespaceURI);
            }
            if (!this.fIsRepairingNamespace) {
                if (!(prefix == null || prefix == StringUtil.EMPTY_STRING)) {
                    this.fWriter.write(prefix);
                    this.fWriter.write(":");
                }
                this.fWriter.write(localName);
            } else if (prefix == null) {
            } else {
                if (tmpPrefix == null || !prefix.equals(tmpPrefix)) {
                    QName qname = new QName();
                    qname.setValues(prefix, XMLConstants.XMLNS_ATTRIBUTE, null, namespaceURI);
                    this.fNamespaceDecls.add(qname);
                }
            }
        } else {
            throw new XMLStreamException2("Prefix cannot be null");
        }
    }

    private void writeXMLContent(char[] content, int start, int length, boolean escapeChars) throws IOException {
        if (escapeChars) {
            int startWritePos = start;
            int end = start + length;
            for (int index = start; index < end; index++) {
                char ch = content[index];
                if (this.fEncoder == null || this.fEncoder.canEncode(ch)) {
                    switch (ch) {
                        case '&':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&amp;");
                            startWritePos = index + 1;
                            break;
                        case '<':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&lt;");
                            startWritePos = index + 1;
                            break;
                        case '>':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&gt;");
                            startWritePos = index + 1;
                            break;
                        default:
                            break;
                    }
                }
                this.fWriter.write(content, startWritePos, index - startWritePos);
                this.fWriter.write("&#x");
                this.fWriter.write(Integer.toHexString(ch));
                this.fWriter.write(59);
                startWritePos = index + 1;
            }
            this.fWriter.write(content, startWritePos, end - startWritePos);
            return;
        }
        this.fWriter.write(content, start, length);
    }

    private void writeXMLContent(String content) throws IOException {
        if (content != null && content.length() > 0) {
            writeXMLContent(content, this.fEscapeCharacters, false);
        }
    }

    private void writeXMLContent(String content, boolean escapeChars, boolean escapeDoubleQuotes) throws IOException {
        if (escapeChars) {
            int startWritePos = 0;
            int end = content.length();
            for (int index = 0; index < end; index++) {
                char ch = content.charAt(index);
                if (this.fEncoder == null || this.fEncoder.canEncode(ch)) {
                    switch (ch) {
                        case '\"':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            if (escapeDoubleQuotes) {
                                this.fWriter.write("&quot;");
                            } else {
                                this.fWriter.write(34);
                            }
                            startWritePos = index + 1;
                            break;
                        case '&':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&amp;");
                            startWritePos = index + 1;
                            break;
                        case '<':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&lt;");
                            startWritePos = index + 1;
                            break;
                        case '>':
                            this.fWriter.write(content, startWritePos, index - startWritePos);
                            this.fWriter.write("&gt;");
                            startWritePos = index + 1;
                            break;
                        default:
                            break;
                    }
                }
                this.fWriter.write(content, startWritePos, index - startWritePos);
                this.fWriter.write("&#x");
                this.fWriter.write(Integer.toHexString(ch));
                this.fWriter.write(59);
                startWritePos = index + 1;
            }
            this.fWriter.write(content, startWritePos, end - startWritePos);
            return;
        }
        this.fWriter.write(content);
    }

    private void closeStartTag() throws XMLStreamException {
        try {
            QName currentElement = this.fElementStack.peek();
            if (this.fIsRepairingNamespace) {
                repair();
                correctPrefix(currentElement, 1);
                if (!(currentElement.prefix == null || currentElement.prefix == StringUtil.EMPTY_STRING)) {
                    this.fWriter.write(currentElement.prefix);
                    this.fWriter.write(":");
                }
                this.fWriter.write(currentElement.localpart);
                int len = this.fNamespaceDecls.size();
                for (int i = 0; i < len; i++) {
                    QName qname = (QName) this.fNamespaceDecls.get(i);
                    if (qname != null && this.fInternalNamespaceContext.declarePrefix(qname.prefix, qname.uri)) {
                        writenamespace(qname.prefix, qname.uri);
                    }
                }
                this.fNamespaceDecls.clear();
                for (int j = 0; j < this.fAttributeCache.size(); j++) {
                    Attribute attr = (Attribute) this.fAttributeCache.get(j);
                    if (!(attr.prefix == null || attr.uri == null || attr.prefix.equals(StringUtil.EMPTY_STRING) || attr.uri.equals(StringUtil.EMPTY_STRING))) {
                        String tmp = this.fInternalNamespaceContext.getPrefix(attr.uri);
                        if (tmp == null || tmp != attr.prefix) {
                            if (getAttrPrefix(attr.uri) != null) {
                                writenamespace(attr.prefix, attr.uri);
                            } else if (this.fInternalNamespaceContext.declarePrefix(attr.prefix, attr.uri)) {
                                writenamespace(attr.prefix, attr.uri);
                            }
                        }
                    }
                    writeAttributeWithPrefix(attr.prefix, attr.localpart, attr.value);
                }
                this.fAttrNamespace = null;
                this.fAttributeCache.clear();
            }
            if (currentElement.isEmpty) {
                this.fElementStack.pop();
                this.fInternalNamespaceContext.popContext();
                this.fWriter.write(CLOSE_EMPTY_ELEMENT);
            } else {
                this.fWriter.write(62);
            }
            this.fStartTagOpened = false;
        } catch (Throwable ex) {
            this.fStartTagOpened = false;
            throw new XMLStreamException2(ex);
        }
    }

    private void openStartTag() throws IOException {
        this.fStartTagOpened = true;
        this.fWriter.write(60);
    }

    private void correctPrefix(QName attr, int type) {
        String prefix = attr.prefix;
        String uri = attr.uri;
        boolean isSpecialCaseURI = false;
        if (prefix == null || prefix.equals(StringUtil.EMPTY_STRING)) {
            if (uri != null) {
                if (prefix != StringUtil.EMPTY_STRING || uri != StringUtil.EMPTY_STRING) {
                    uri = this.fSymbolTable.addSymbol(uri);
                    int i = 0;
                    while (i < this.fNamespaceDecls.size()) {
                        QName decl = (QName) this.fNamespaceDecls.get(i);
                        if (decl == null || decl.uri != attr.uri) {
                            i++;
                        } else {
                            attr.prefix = decl.prefix;
                            return;
                        }
                    }
                    String tmpPrefix = this.fNamespaceContext.getPrefix(uri);
                    if (tmpPrefix == StringUtil.EMPTY_STRING) {
                        if (type == 1) {
                            return;
                        }
                        if (type == 10) {
                            tmpPrefix = getAttrPrefix(uri);
                            isSpecialCaseURI = true;
                        }
                    }
                    if (tmpPrefix == null) {
                        StringBuffer genPrefix = new StringBuffer("zdef");
                        for (i = 0; i < 1; i++) {
                            genPrefix.append(this.fPrefixGen.nextInt());
                        }
                        prefix = this.fSymbolTable.addSymbol(genPrefix.toString());
                    } else {
                        prefix = this.fSymbolTable.addSymbol(tmpPrefix);
                    }
                    if (tmpPrefix == null) {
                        if (isSpecialCaseURI) {
                            addAttrNamespace(prefix, uri);
                        } else {
                            QName qname = new QName();
                            qname.setValues(prefix, XMLConstants.XMLNS_ATTRIBUTE, null, uri);
                            this.fNamespaceDecls.add(qname);
                            this.fInternalNamespaceContext.declarePrefix(this.fSymbolTable.addSymbol(prefix), uri);
                        }
                    }
                } else {
                    return;
                }
            }
            return;
        }
        attr.prefix = prefix;
    }

    private String getAttrPrefix(String uri) {
        if (this.fAttrNamespace != null) {
            return (String) this.fAttrNamespace.get(uri);
        }
        return null;
    }

    private void addAttrNamespace(String prefix, String uri) {
        if (this.fAttrNamespace == null) {
            this.fAttrNamespace = new HashMap();
        }
        this.fAttrNamespace.put(prefix, uri);
    }

    private boolean isDefaultNamespace(String uri) {
        if (uri == this.fInternalNamespaceContext.getURI(this.DEFAULT_PREFIX)) {
            return true;
        }
        return false;
    }

    private boolean checkUserNamespaceContext(String prefix, String uri) {
        if (this.fNamespaceContext.userContext != null) {
            String tmpURI = this.fNamespaceContext.userContext.getNamespaceURI(prefix);
            if (tmpURI != null && tmpURI.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    protected void repair() {
        int i;
        QName currentElement = this.fElementStack.peek();
        removeDuplicateDecls();
        for (i = 0; i < this.fAttributeCache.size(); i++) {
            QName attr = (Attribute) this.fAttributeCache.get(i);
            if (!((attr.prefix == null || attr.prefix.equals(StringUtil.EMPTY_STRING)) && (attr.uri == null || attr.uri.equals(StringUtil.EMPTY_STRING)))) {
                correctPrefix(currentElement, attr);
            }
        }
        if (!(isDeclared(currentElement) || currentElement.prefix == null || currentElement.uri == null || currentElement.prefix.equals(StringUtil.EMPTY_STRING) || currentElement.uri.equals(StringUtil.EMPTY_STRING))) {
            this.fNamespaceDecls.add(currentElement);
        }
        for (i = 0; i < this.fAttributeCache.size(); i++) {
            attr = (Attribute) this.fAttributeCache.get(i);
            for (int j = i + 1; j < this.fAttributeCache.size(); j++) {
                QName attr2 = (Attribute) this.fAttributeCache.get(j);
                if (!(StringUtil.EMPTY_STRING.equals(attr.prefix) || StringUtil.EMPTY_STRING.equals(attr2.prefix))) {
                    correctPrefix(attr, attr2);
                }
            }
        }
        repairNamespaceDecl(currentElement);
        for (i = 0; i < this.fAttributeCache.size(); i++) {
            Attribute attr3 = (Attribute) this.fAttributeCache.get(i);
            if (attr3.prefix != null && attr3.prefix.equals(StringUtil.EMPTY_STRING) && attr3.uri != null && attr3.uri.equals(StringUtil.EMPTY_STRING)) {
                repairNamespaceDecl(attr3);
            }
        }
        for (i = 0; i < this.fNamespaceDecls.size(); i++) {
            QName qname = (QName) this.fNamespaceDecls.get(i);
            if (qname != null) {
                this.fInternalNamespaceContext.declarePrefix(qname.prefix, qname.uri);
            }
        }
        for (i = 0; i < this.fAttributeCache.size(); i++) {
            correctPrefix((Attribute) this.fAttributeCache.get(i), 10);
        }
    }

    void correctPrefix(QName attr1, QName attr2) {
        checkForNull(attr1);
        checkForNull(attr2);
        if (attr1.prefix.equals(attr2.prefix) && !attr1.uri.equals(attr2.uri)) {
            String tmpPrefix = this.fNamespaceContext.getPrefix(attr2.uri);
            if (tmpPrefix != null) {
                attr2.prefix = this.fSymbolTable.addSymbol(tmpPrefix);
                return;
            }
            int n = 0;
            while (n < this.fNamespaceDecls.size()) {
                QName decl = (QName) this.fNamespaceDecls.get(n);
                if (decl == null || decl.uri != attr2.uri) {
                    n++;
                } else {
                    attr2.prefix = decl.prefix;
                    return;
                }
            }
            StringBuffer genPrefix = new StringBuffer("zdef");
            for (int k = 0; k < 1; k++) {
                genPrefix.append(this.fPrefixGen.nextInt());
            }
            tmpPrefix = this.fSymbolTable.addSymbol(genPrefix.toString());
            attr2.prefix = tmpPrefix;
            QName qname = new QName();
            qname.setValues(tmpPrefix, XMLConstants.XMLNS_ATTRIBUTE, null, attr2.uri);
            this.fNamespaceDecls.add(qname);
        }
    }

    void checkForNull(QName attr) {
        if (attr.prefix == null) {
            attr.prefix = StringUtil.EMPTY_STRING;
        }
        if (attr.uri == null) {
            attr.uri = StringUtil.EMPTY_STRING;
        }
    }

    void removeDuplicateDecls() {
        for (int i = 0; i < this.fNamespaceDecls.size(); i++) {
            QName decl1 = (QName) this.fNamespaceDecls.get(i);
            if (decl1 != null) {
                for (int j = i + 1; j < this.fNamespaceDecls.size(); j++) {
                    QName decl2 = (QName) this.fNamespaceDecls.get(j);
                    if (decl2 != null && decl1.prefix.equals(decl2.prefix) && decl1.uri.equals(decl2.uri)) {
                        this.fNamespaceDecls.remove(j);
                    }
                }
            }
        }
    }

    void repairNamespaceDecl(QName attr) {
        for (int j = 0; j < this.fNamespaceDecls.size(); j++) {
            QName decl = (QName) this.fNamespaceDecls.get(j);
            if (!(decl == null || attr.prefix == null || !attr.prefix.equals(decl.prefix) || attr.uri.equals(decl.uri))) {
                String tmpURI = this.fNamespaceContext.getNamespaceURI(attr.prefix);
                if (tmpURI != null) {
                    if (tmpURI.equals(attr.uri)) {
                        this.fNamespaceDecls.set(j, null);
                    } else {
                        decl.uri = attr.uri;
                    }
                }
            }
        }
    }

    boolean isDeclared(QName attr) {
        for (int n = 0; n < this.fNamespaceDecls.size(); n++) {
            QName decl = (QName) this.fNamespaceDecls.get(n);
            if (attr.prefix != null && attr.prefix == decl.prefix && decl.uri == attr.uri) {
                return true;
            }
        }
        if (attr.uri == null || this.fNamespaceContext.getPrefix(attr.uri) == null) {
            return false;
        }
        return true;
    }

    public int size() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return key.equals(OUTPUTSTREAM_PROPERTY);
    }

    public Object get(Object key) {
        if (key.equals(OUTPUTSTREAM_PROPERTY)) {
            return this.fOutputStream;
        }
        return null;
    }

    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return new StringBuffer().append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    public int hashCode() {
        return this.fElementStack.hashCode();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}
