package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.Entity.ExternalEntity;
import com.amazonaws.javax.xml.stream.Entity.InternalEntity;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.DTDGrammar;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLNotationDecl;
import com.amazonaws.javax.xml.stream.events.EntityDeclarationImpl;
import com.amazonaws.javax.xml.stream.events.NotationDeclarationImpl;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceContextWrapper;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.xml.sax.InputSource;

public class XMLReaderImpl implements XMLStreamReader {
    static final boolean DEBUG = false;
    protected static final String ENTITY_MANAGER = "http://apache.org/xml/properties/internal/entity-manager";
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    private boolean fBindNamespaces;
    private String fDTDDecl;
    protected XMLEntityManager fEntityManager;
    protected XMLEntityReaderImpl fEntityScanner;
    protected StaxErrorReporter fErrorReporter;
    private int fEventType;
    protected XMLInputSource fInputSource;
    protected NamespaceContextWrapper fNamespaceContextWrapper;
    protected PropertyManager fPropertyManager;
    private boolean fReuse;
    protected XMLNSDocumentScannerImpl fScanner;
    private SymbolTable fSymbolTable;

    /* renamed from: com.amazonaws.javax.xml.stream.XMLReaderImpl.1 */
    class C00071 implements Location {
        int _columnNumber;
        int _lineNumber;
        int _offset;
        String _publicId;
        String _systemId;

        public String getLocationURI() {
            return this._systemId;
        }

        public int getCharacterOffset() {
            return this._offset;
        }

        public int getColumnNumber() {
            return this._columnNumber;
        }

        public int getLineNumber() {
            return this._lineNumber;
        }

        public String getPublicId() {
            return this._publicId;
        }

        public String getSystemId() {
            return this._systemId;
        }

        C00071() {
            this._systemId = XMLReaderImpl.this.fEntityScanner.getExpandedSystemId();
            this._publicId = XMLReaderImpl.this.fEntityScanner.getPublicId();
            this._offset = XMLReaderImpl.this.fEntityScanner.getCharacterOffset();
            this._columnNumber = XMLReaderImpl.this.fEntityScanner.getColumnNumber();
            this._lineNumber = XMLReaderImpl.this.fEntityScanner.getLineNumber();
        }

        public String toString() {
            StringBuffer sbuffer = new StringBuffer();
            sbuffer.append(new StringBuffer().append("Line number = ").append(getLineNumber()).toString());
            sbuffer.append("\n");
            sbuffer.append(new StringBuffer().append("Column number = ").append(getColumnNumber()).toString());
            sbuffer.append("\n");
            sbuffer.append(new StringBuffer().append("System Id = ").append(getSystemId()).toString());
            sbuffer.append("\n");
            sbuffer.append(new StringBuffer().append("Public Id = ").append(getPublicId()).toString());
            sbuffer.append("\n");
            sbuffer.append(new StringBuffer().append("Location Uri= ").append(getLocationURI()).toString());
            sbuffer.append("\n");
            sbuffer.append(new StringBuffer().append("CharacterOffset = ").append(getCharacterOffset()).toString());
            sbuffer.append("\n");
            return sbuffer.toString();
        }
    }

    public XMLReaderImpl(InputStream inputStream, PropertyManager props) throws XMLStreamException {
        this.fSymbolTable = new SymbolTable();
        this.fScanner = new XMLNSDocumentScannerImpl();
        this.fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
        this.fEntityManager = new XMLEntityManager();
        this.fErrorReporter = new StaxErrorReporter();
        this.fEntityScanner = null;
        this.fInputSource = null;
        this.fPropertyManager = null;
        this.fReuse = true;
        this.fBindNamespaces = true;
        this.fDTDDecl = null;
        init(props);
        setInputSource(new XMLInputSource(null, null, null, inputStream, null));
    }

    public XMLReaderImpl(String systemid, PropertyManager props) throws XMLStreamException {
        this.fSymbolTable = new SymbolTable();
        this.fScanner = new XMLNSDocumentScannerImpl();
        this.fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
        this.fEntityManager = new XMLEntityManager();
        this.fErrorReporter = new StaxErrorReporter();
        this.fEntityScanner = null;
        this.fInputSource = null;
        this.fPropertyManager = null;
        this.fReuse = true;
        this.fBindNamespaces = true;
        this.fDTDDecl = null;
        init(props);
        setInputSource(new XMLInputSource(null, systemid, null));
    }

    public XMLReaderImpl(InputStream inputStream, String encoding, PropertyManager props) throws XMLStreamException {
        this.fSymbolTable = new SymbolTable();
        this.fScanner = new XMLNSDocumentScannerImpl();
        this.fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
        this.fEntityManager = new XMLEntityManager();
        this.fErrorReporter = new StaxErrorReporter();
        this.fEntityScanner = null;
        this.fInputSource = null;
        this.fPropertyManager = null;
        this.fReuse = true;
        this.fBindNamespaces = true;
        this.fDTDDecl = null;
        init(props);
        setInputSource(new XMLInputSource(null, null, null, new BufferedInputStream(inputStream), encoding));
    }

    public XMLReaderImpl(Reader reader, PropertyManager props) throws XMLStreamException {
        this.fSymbolTable = new SymbolTable();
        this.fScanner = new XMLNSDocumentScannerImpl();
        this.fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
        this.fEntityManager = new XMLEntityManager();
        this.fErrorReporter = new StaxErrorReporter();
        this.fEntityScanner = null;
        this.fInputSource = null;
        this.fPropertyManager = null;
        this.fReuse = true;
        this.fBindNamespaces = true;
        this.fDTDDecl = null;
        init(props);
        setInputSource(new XMLInputSource(null, null, null, new BufferedReader(reader), null));
    }

    public XMLReaderImpl(XMLInputSource inputSource, PropertyManager props) throws XMLStreamException {
        this.fSymbolTable = new SymbolTable();
        this.fScanner = new XMLNSDocumentScannerImpl();
        this.fNamespaceContextWrapper = new NamespaceContextWrapper(this.fScanner.getNamespaceContext());
        this.fEntityManager = new XMLEntityManager();
        this.fErrorReporter = new StaxErrorReporter();
        this.fEntityScanner = null;
        this.fInputSource = null;
        this.fPropertyManager = null;
        this.fReuse = true;
        this.fBindNamespaces = true;
        this.fDTDDecl = null;
        init(props);
        setInputSource(inputSource);
    }

    public void setInputSource(XMLInputSource inputSource) throws XMLStreamException {
        this.fReuse = DEBUG;
        try {
            this.fScanner.setInputSource(inputSource);
            this.fEventType = this.fScanner.next();
        } catch (Throwable ex) {
            throw new XMLStreamException2(ex);
        } catch (XNIException ex2) {
            throw new XMLStreamException2(ex2.getMessage(), getLocation(), ex2.getException());
        }
    }

    public void setInputSource(InputSource inputSource) throws XMLStreamException {
        setInputSource(convertSAXInputSource2XMLInputSource(inputSource));
    }

    XMLInputSource convertSAXInputSource2XMLInputSource(InputSource inputSource) {
        XMLInputSource xmlInputSource = new XMLInputSource(inputSource.getPublicId(), inputSource.getSystemId(), null);
        InputStream inputStream = inputSource.getByteStream();
        if (!(inputStream == null || (inputStream instanceof ByteArrayInputStream) || (inputStream instanceof BufferedInputStream))) {
            inputStream = new BufferedInputStream(inputStream);
        }
        xmlInputSource.setByteStream(inputStream);
        Reader reader = inputSource.getCharacterStream();
        if (!(reader == null || (reader instanceof BufferedReader) || (reader instanceof CharArrayReader) || (reader instanceof StringReader))) {
            reader = new BufferedReader(reader);
        }
        xmlInputSource.setCharacterStream(reader);
        xmlInputSource.setEncoding(inputSource.getEncoding());
        return xmlInputSource;
    }

    void init(PropertyManager propertyManager) throws XMLStreamException {
        this.fPropertyManager = propertyManager;
        propertyManager.setProperty(SYMBOL_TABLE, this.fSymbolTable);
        propertyManager.setProperty(ERROR_REPORTER, this.fErrorReporter);
        propertyManager.setProperty(ENTITY_MANAGER, this.fEntityManager);
        reset();
    }

    public boolean canReuse() {
        return this.fReuse;
    }

    public void reset() {
        this.fReuse = true;
        this.fEventType = 0;
        this.fEntityManager.reset(this.fPropertyManager);
        this.fScanner.reset(this.fPropertyManager);
        this.fDTDDecl = null;
        this.fEntityScanner = (XMLEntityReaderImpl) this.fEntityManager.getEntityReader();
        this.fBindNamespaces = ((Boolean) this.fPropertyManager.getProperty(XMLInputFactory.IS_NAMESPACE_AWARE)).booleanValue();
    }

    public void close() throws XMLStreamException {
        this.fReuse = true;
    }

    public String getCharacterEncodingScheme() {
        return this.fScanner.getCharacterEncodingScheme();
    }

    public int getColumnNumber() {
        return this.fEntityScanner.getColumnNumber();
    }

    public String getEncoding() {
        return this.fEntityScanner.getEncoding();
    }

    public int getEventType() {
        return this.fEventType;
    }

    public int getLineNumber() {
        return this.fEntityScanner.getLineNumber();
    }

    public String getLocalName() {
        if (this.fEventType == 1 || this.fEventType == 2) {
            return this.fScanner.getElementQName().localpart;
        }
        if (this.fEventType == 9) {
            return this.fScanner.getEntityName();
        }
        throw new IllegalStateException(new StringBuffer().append("Method getLocalName() cannot be called for ").append(getEventTypeString(this.fEventType)).append(" event.").toString());
    }

    public String getNamespaceURI() {
        if (this.fEventType == 1 || this.fEventType == 2) {
            return this.fScanner.getElementQName().uri;
        }
        return null;
    }

    public String getPIData() {
        if (this.fEventType == 3) {
            return this.fScanner.getPIData().toString();
        }
        throw new IllegalStateException(new StringBuffer().append("Current state of the parser is ").append(getEventTypeString(this.fEventType)).append(" But expected state is ").append(getEventTypeString(3)).toString());
    }

    public String getPITarget() {
        if (this.fEventType == 3) {
            return this.fScanner.getPITarget();
        }
        throw new IllegalStateException(new StringBuffer().append("Current state of the parser is ").append(getEventTypeString(this.fEventType)).append(" But expected state is ").append(getEventTypeString(3)).toString());
    }

    public String getPrefix() {
        if (this.fEventType != 1 && this.fEventType != 2) {
            return null;
        }
        String prefix = this.fScanner.getElementQName().prefix;
        if (prefix == null) {
            return StringUtil.EMPTY_STRING;
        }
        return prefix;
    }

    public char[] getTextCharacters() {
        if (this.fEventType == 4 || this.fEventType == 5 || this.fEventType == 12 || this.fEventType == 6) {
            return this.fScanner.getCharacterData().ch;
        }
        throw new IllegalStateException(new StringBuffer().append("Current state = ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(4)).append(" , ").append(getEventTypeString(5)).append(" , ").append(getEventTypeString(12)).append(" , ").append(getEventTypeString(6)).append(" valid for getTextCharacters() ").toString());
    }

    public int getTextLength() {
        if (this.fEventType == 4 || this.fEventType == 5 || this.fEventType == 12 || this.fEventType == 6) {
            return this.fScanner.getCharacterData().length;
        }
        throw new IllegalStateException(new StringBuffer().append("Current state = ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(4)).append(" , ").append(getEventTypeString(5)).append(" , ").append(getEventTypeString(12)).append(" , ").append(getEventTypeString(6)).append(" valid for getTextLength() ").toString());
    }

    public int getTextStart() {
        if (this.fEventType == 4 || this.fEventType == 5 || this.fEventType == 12 || this.fEventType == 6) {
            return this.fScanner.getCharacterData().offset;
        }
        throw new IllegalStateException(new StringBuffer().append("Current state = ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(4)).append(" , ").append(getEventTypeString(5)).append(" , ").append(getEventTypeString(12)).append(" , ").append(getEventTypeString(6)).append(" valid for getTextStart() ").toString());
    }

    public String getValue() {
        if (this.fEventType == 3) {
            return this.fScanner.getPIData().toString();
        }
        if (this.fEventType == 5) {
            return this.fScanner.getComment();
        }
        if (this.fEventType == 1 || this.fEventType == 2) {
            return this.fScanner.getElementQName().localpart;
        }
        if (this.fEventType == 4) {
            return this.fScanner.getCharacterData().toString();
        }
        return null;
    }

    public String getVersion() {
        return this.fEntityScanner.getVersion();
    }

    public boolean hasAttributes() {
        return this.fScanner.getAttributeIterator().getLength() > 0 ? true : DEBUG;
    }

    public boolean hasName() {
        if (this.fEventType == 1 || this.fEventType == 2) {
            return true;
        }
        return DEBUG;
    }

    public boolean hasNext() throws XMLStreamException {
        if (this.fEventType == -1 || this.fEventType == 8) {
            return DEBUG;
        }
        return true;
    }

    public boolean hasValue() {
        if (this.fEventType == 1 || this.fEventType == 2 || this.fEventType == 9 || this.fEventType == 3 || this.fEventType == 5 || this.fEventType == 4) {
            return true;
        }
        return DEBUG;
    }

    public boolean isEndElement() {
        return this.fEventType == 2 ? true : DEBUG;
    }

    public boolean isStandalone() {
        return this.fScanner.isStandAlone();
    }

    public boolean isStartElement() {
        return this.fEventType == 1 ? true : DEBUG;
    }

    public boolean isWhiteSpace() {
        if (!isCharacters() && this.fEventType != 12) {
            return DEBUG;
        }
        char[] ch = getTextCharacters();
        int start = getTextStart();
        int end = start + getTextLength();
        for (int i = start; i < end; i++) {
            if (!XMLChar.isSpace(ch[i])) {
                return DEBUG;
            }
        }
        return true;
    }

    public int next() throws XMLStreamException {
        int next;
        if (hasNext()) {
            try {
                next = this.fScanner.next();
                this.fEventType = next;
                return next;
            } catch (IOException ex) {
                next = this.fScanner.fScannerState;
                XMLNSDocumentScannerImpl xMLNSDocumentScannerImpl = this.fScanner;
                if (next == 46) {
                    Boolean isValidating = (Boolean) this.fPropertyManager.getProperty(XMLInputFactory.IS_VALIDATING);
                    if (!(isValidating == null || isValidating.booleanValue())) {
                        this.fEventType = 11;
                        XMLNSDocumentScannerImpl xMLNSDocumentScannerImpl2 = this.fScanner;
                        xMLNSDocumentScannerImpl = this.fScanner;
                        xMLNSDocumentScannerImpl2.setScannerState(43);
                        this.fScanner.setDriver(this.fScanner.fPrologDriver);
                        if (this.fDTDDecl == null || this.fDTDDecl.length() == 0) {
                            this.fDTDDecl = "<!-- Exception scanning External DTD Subset.  True contents of DTD cannot be determined.  Processing will continue as XMLInputFactory.IS_VALIDATING == false. -->";
                        }
                        return 11;
                    }
                }
                throw new XMLStreamException2(ex.getMessage(), getLocation(), ex);
            } catch (XNIException ex2) {
                throw new XMLStreamException2(ex2.getMessage(), getLocation(), ex2.getException());
            }
        } else if (this.fEventType != -1) {
            throw new NoSuchElementException("END_DOCUMENT reached: no more elements on the stream.");
        } else {
            throw new XMLStreamException("Error processing input source. The input stream is not complete.");
        }
    }

    static final String getEventTypeString(int eventType) {
        switch (eventType) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return "START_ELEMENT";
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return "END_ELEMENT";
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return "PROCESSING_INSTRUCTION";
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return "CHARACTERS";
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return "COMMENT";
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                return "SPACE";
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                return "START_DOCUMENT";
            case PayPalActivity.VIEW_TEST /*8*/:
                return "END_DOCUMENT";
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                return "ENTITY_REFERENCE";
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                return "ATTRIBUTE";
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                return "DTD";
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                return "CDATA";
            default:
                return new StringBuffer().append("UNKNOWN_EVENT_TYPE , ").append(String.valueOf(eventType)).toString();
        }
    }

    public int getAttributeCount() {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getLength();
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeCount()").toString());
    }

    public QName getAttributeName(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return convertXNIQNametoJavaxQName(this.fScanner.getAttributeIterator().getQualifiedName(index));
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeName()").toString());
    }

    public String getAttributeLocalName(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getLocalName(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeLocalName()").toString());
    }

    public String getAttributeNamespace(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getURI(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeNamespace()").toString());
    }

    public String getAttributePrefix(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getPrefix(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributePrefix()").toString());
    }

    public QName getAttributeQName(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return new QName(this.fScanner.getAttributeIterator().getURI(index), this.fScanner.getAttributeIterator().getLocalName(index));
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeQName()").toString());
    }

    public String getAttributeType(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getType(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeType()").toString());
    }

    public String getAttributeValue(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getValue(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeValue()").toString());
    }

    public String getAttributeValue(String namespaceURI, String localName) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().getValue(namespaceURI, localName);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for getAttributeValue()").toString());
    }

    public String getElementText() throws XMLStreamException {
        if (getEventType() != 1) {
            throw new XMLStreamException2("parser must be on START_ELEMENT to read next text", getLocation());
        }
        int eventType = next();
        StringBuffer content = new StringBuffer();
        while (eventType != 2) {
            if (eventType == 4 || eventType == 12 || eventType == 6 || eventType == 9) {
                content.append(getText());
            } else if (!(eventType == 3 || eventType == 5)) {
                if (eventType == 8) {
                    throw new XMLStreamException2("unexpected end of document when reading element text content");
                } else if (eventType == 1) {
                    throw new XMLStreamException2("elementGetText() function expects text only elment but START_ELEMENT was encountered.", getLocation());
                } else {
                    throw new XMLStreamException2(new StringBuffer().append("Unexpected event type ").append(eventType).toString(), getLocation());
                }
            }
            eventType = next();
        }
        return content.toString();
    }

    public Location getLocation() {
        return new C00071();
    }

    public QName getName() {
        if (this.fEventType == 1 || this.fEventType == 2) {
            return convertXNIQNametoJavaxQName(this.fScanner.getElementQName());
        }
        throw new IllegalStateException(new StringBuffer().append("Illegal to call getName() when event type is ").append(getEventTypeString(this.fEventType)).append(".").append(" Valid states are ").append(getEventTypeString(1)).append(", ").append(getEventTypeString(2)).toString());
    }

    public NamespaceContext getNamespaceContext() {
        return this.fNamespaceContextWrapper;
    }

    public int getNamespaceCount() {
        if (this.fEventType == 1 || this.fEventType == 2 || this.fEventType == 13) {
            return this.fScanner.getNamespaceContext().getDeclaredPrefixCount();
        }
        throw new IllegalStateException(new StringBuffer().append("Current state ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(1)).append(", ").append(getEventTypeString(2)).append(", ").append(getEventTypeString(13)).append(" valid for getNamespaceCount().").toString());
    }

    public String getNamespacePrefix(int index) {
        if (this.fEventType == 1 || this.fEventType == 2 || this.fEventType == 13) {
            String prefix = this.fScanner.getNamespaceContext().getDeclaredPrefixAt(index);
            return prefix.equals(StringUtil.EMPTY_STRING) ? null : prefix;
        } else {
            throw new IllegalStateException(new StringBuffer().append("Current state ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(1)).append(", ").append(getEventTypeString(2)).append(", ").append(getEventTypeString(13)).append(" valid for getNamespacePrefix().").toString());
        }
    }

    public String getNamespaceURI(int index) {
        if (this.fEventType == 1 || this.fEventType == 2 || this.fEventType == 13) {
            return this.fScanner.getNamespaceContext().getURI(this.fScanner.getNamespaceContext().getDeclaredPrefixAt(index));
        }
        throw new IllegalStateException(new StringBuffer().append("Current state ").append(getEventTypeString(this.fEventType)).append(" is not among the states ").append(getEventTypeString(1)).append(", ").append(getEventTypeString(2)).append(", ").append(getEventTypeString(13)).append(" valid for getNamespaceURI().").toString());
    }

    public Object getProperty(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException();
        } else if (this.fPropertyManager == null) {
            return null;
        } else {
            PropertyManager propertyManager = this.fPropertyManager;
            if (name.equals(PropertyManager.STAX_NOTATIONS)) {
                return getNotationDecls();
            }
            propertyManager = this.fPropertyManager;
            if (name.equals(PropertyManager.STAX_ENTITIES)) {
                return getEntityDecls();
            }
            return this.fPropertyManager.getProperty(name);
        }
    }

    public String getText() {
        if (this.fEventType == 4 || this.fEventType == 5 || this.fEventType == 12 || this.fEventType == 6) {
            return this.fScanner.getCharacterData().toString();
        }
        if (this.fEventType == 9) {
            String name = this.fScanner.getEntityName();
            if (name == null) {
                return null;
            }
            if (this.fScanner.foundBuiltInRefs) {
                return this.fScanner.getCharacterData().toString();
            }
            Entity en = (Entity) this.fEntityManager.getEntityStore().getDeclaredEntities().get(name);
            if (en == null) {
                return null;
            }
            if (en.isExternal()) {
                return ((ExternalEntity) en).entityLocation.getExpandedSystemId();
            }
            return ((InternalEntity) en).text;
        } else if (this.fEventType != 11) {
            throw new IllegalStateException(new StringBuffer().append("Current state ").append(getEventTypeString(this.fEventType)).append(" is not among the states").append(getEventTypeString(4)).append(", ").append(getEventTypeString(5)).append(", ").append(getEventTypeString(12)).append(", ").append(getEventTypeString(6)).append(", ").append(getEventTypeString(9)).append(", ").append(getEventTypeString(11)).append(" valid for getText() ").toString());
        } else if (this.fDTDDecl != null) {
            return this.fDTDDecl;
        } else {
            this.fDTDDecl = this.fScanner.getDTDDecl().toString();
            return this.fDTDDecl;
        }
    }

    public void require(int type, String namespaceURI, String localName) throws XMLStreamException {
        if (type != this.fEventType) {
            throw new XMLStreamException2(new StringBuffer().append("Event type ").append(getEventTypeString(type)).append(" specified did ").append("not match with current parser event ").append(getEventTypeString(this.fEventType)).toString());
        } else if (namespaceURI != null && !namespaceURI.equals(getNamespaceURI())) {
            throw new XMLStreamException2(new StringBuffer().append("Namespace URI ").append(namespaceURI).append(" specified did not match ").append("with current namespace URI").toString());
        } else if (localName != null && !localName.equals(getLocalName())) {
            throw new XMLStreamException2(new StringBuffer().append("LocalName ").append(localName).append(" specified did not match with ").append("current local name").toString());
        }
    }

    public int getTextCharacters(int sourceStart, char[] target, int targetStart, int length) throws XMLStreamException {
        if (target == null) {
            throw new NullPointerException("target char array can't be null");
        } else if (targetStart < 0 || length < 0 || sourceStart < 0 || targetStart >= target.length || targetStart + length > target.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int available = getTextLength() - sourceStart;
            if (available < 0) {
                throw new IndexOutOfBoundsException("sourceStart is greater thannumber of characters associated with this event");
            }
            int copiedLength;
            if (available < length) {
                copiedLength = available;
            } else {
                copiedLength = length;
            }
            System.arraycopy(getTextCharacters(), getTextStart() + sourceStart, target, targetStart, copiedLength);
            return copiedLength;
        }
    }

    public boolean hasText() {
        if (this.fEventType == 4 || this.fEventType == 5 || this.fEventType == 12) {
            if (this.fScanner.getCharacterData().length > 0) {
                return true;
            }
            return DEBUG;
        } else if (this.fEventType != 9) {
            return this.fEventType == 11 ? this.fScanner.fSeenDoctypeDecl : DEBUG;
        } else {
            String name = this.fScanner.getEntityName();
            if (name == null) {
                return DEBUG;
            }
            if (this.fScanner.foundBuiltInRefs) {
                return true;
            }
            Entity en = (Entity) this.fEntityManager.getEntityStore().getDeclaredEntities().get(name);
            if (en == null) {
                return DEBUG;
            }
            if (en.isExternal()) {
                if (((ExternalEntity) en).entityLocation.getExpandedSystemId() == null) {
                    return DEBUG;
                }
                return true;
            } else if (((InternalEntity) en).text == null) {
                return DEBUG;
            } else {
                return true;
            }
        }
    }

    public boolean isAttributeSpecified(int index) {
        if (this.fEventType == 1 || this.fEventType == 10) {
            return this.fScanner.getAttributeIterator().isSpecified(index);
        }
        throw new IllegalStateException(new StringBuffer().append("Current state is not among the states ").append(getEventTypeString(1)).append(" , ").append(getEventTypeString(10)).append("valid for isAttributeSpecified()").toString());
    }

    public boolean isCharacters() {
        return this.fEventType == 4 ? true : DEBUG;
    }

    public int nextTag() throws XMLStreamException {
        int eventType = next();
        while (true) {
            if ((eventType != 4 || !isWhiteSpace()) && ((eventType != 12 || !isWhiteSpace()) && eventType != 6 && eventType != 3 && eventType != 5)) {
                break;
            }
            eventType = next();
        }
        if (eventType == 1 || eventType == 2) {
            return eventType;
        }
        throw new XMLStreamException2("expected start or end tag", getLocation());
    }

    public boolean standaloneSet() {
        return this.fScanner.standaloneSet();
    }

    public QName convertXNIQNametoJavaxQName(com.amazonaws.javax.xml.stream.xerces.xni.QName qname) {
        if (qname == null) {
            return null;
        }
        if (qname.prefix == null) {
            return new QName(qname.uri, qname.localpart);
        }
        return new QName(qname.uri, qname.localpart, qname.prefix);
    }

    public String getNamespaceURI(String prefix) {
        if (prefix != null) {
            return this.fScanner.getNamespaceContext().getURI(this.fSymbolTable.addSymbol(prefix));
        }
        throw new IllegalArgumentException("getNamespaceURI(String prefix) is called with a null prefix.");
    }

    protected void setPropertyManager(PropertyManager propertyManager) {
        this.fPropertyManager = propertyManager;
        this.fScanner.setProperty(Constants.STAX_PROPERTIES, propertyManager);
        this.fScanner.setPropertyManager(propertyManager);
    }

    protected PropertyManager getPropertyManager() {
        return this.fPropertyManager;
    }

    static void pr(String str) {
        System.out.println(str);
    }

    protected List getEntityDecls() {
        if (this.fEventType != 11) {
            return null;
        }
        Hashtable ht = this.fEntityManager.getEntityStore().getDeclaredEntities();
        if (ht == null) {
            return null;
        }
        List arrayList = new ArrayList(ht.size());
        Enumeration enu = ht.keys();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            Entity en = (Entity) ht.get(key);
            EntityDeclarationImpl decl = new EntityDeclarationImpl();
            decl.setEntityName(key);
            if (en.isExternal()) {
                decl.setXMLResourceIdentifier(((ExternalEntity) en).entityLocation);
                decl.setNotationName(((ExternalEntity) en).notation);
            } else {
                decl.setEntityReplacementText(((InternalEntity) en).text);
            }
            arrayList.add(decl);
        }
        return arrayList;
    }

    protected List getNotationDecls() {
        List list = null;
        if (this.fEventType == 11 && this.fScanner.fDTDScanner != null) {
            DTDGrammar grammar = ((XMLDTDScannerImpl) this.fScanner.fDTDScanner).getGrammar();
            if (grammar != null) {
                list = new ArrayList();
                for (XMLNotationDecl ni : grammar.getNotationDecls()) {
                    if (ni != null) {
                        list.add(new NotationDeclarationImpl(ni));
                    }
                }
            }
        }
        return list;
    }
}
