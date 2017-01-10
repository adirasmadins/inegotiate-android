package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponent;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public abstract class XMLScanner implements XMLComponent {
    protected static final boolean DEBUG_ATTR_NORMALIZATION = false;
    protected static final String ENTITY_MANAGER = "http://apache.org/xml/properties/internal/entity-manager";
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    protected static final String NOTIFY_CHAR_REFS = "http://apache.org/xml/features/scanner/notify-char-refs";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    protected static final String VALIDATION = "http://xml.org/sax/features/validation";
    protected static final String fAmpSymbol;
    protected static final String fAposSymbol;
    protected static final String fEncodingSymbol;
    protected static final String fGtSymbol;
    protected static final String fLtSymbol;
    protected static final String fQuotSymbol;
    protected static final String fStandaloneSymbol;
    protected static final String fVersionSymbol;
    protected ArrayList attributeValueCache;
    protected boolean fAttributeCacheInitDone;
    protected int fAttributeCacheUsedCount;
    protected String fCharRefLiteral;
    protected int fEntityDepth;
    protected XMLEntityManager fEntityManager;
    protected XMLEntityReaderImpl fEntityScanner;
    protected XMLEntityStorage fEntityStore;
    protected XMLErrorReporter fErrorReporter;
    protected XMLEvent fEvent;
    private boolean fNeedNonNormalizedValue;
    protected boolean fNotifyCharRefs;
    protected PropertyManager fPropertyManager;
    protected boolean fReportEntity;
    protected XMLResourceIdentifierImpl fResourceIdentifier;
    protected boolean fScanningAttribute;
    private XMLString fString;
    private XMLStringBuffer fStringBuffer;
    private XMLStringBuffer fStringBuffer2;
    private XMLStringBuffer fStringBuffer3;
    protected int fStringBufferIndex;
    protected SymbolTable fSymbolTable;
    protected boolean fValidation;
    int initialCacheCount;
    protected ArrayList stringBufferCache;

    public XMLScanner() {
        this.fNeedNonNormalizedValue = DEBUG_ATTR_NORMALIZATION;
        this.attributeValueCache = new ArrayList();
        this.stringBufferCache = new ArrayList();
        this.fStringBufferIndex = 0;
        this.fAttributeCacheInitDone = DEBUG_ATTR_NORMALIZATION;
        this.fAttributeCacheUsedCount = 0;
        this.fValidation = DEBUG_ATTR_NORMALIZATION;
        this.fNotifyCharRefs = DEBUG_ATTR_NORMALIZATION;
        this.fPropertyManager = null;
        this.fEntityManager = null;
        this.fEntityStore = null;
        this.fEntityScanner = null;
        this.fCharRefLiteral = null;
        this.fString = new XMLString();
        this.fStringBuffer = new XMLStringBuffer();
        this.fStringBuffer2 = new XMLStringBuffer();
        this.fStringBuffer3 = new XMLStringBuffer();
        this.fResourceIdentifier = new XMLResourceIdentifierImpl();
        this.initialCacheCount = 6;
    }

    static {
        fVersionSymbol = OutputKeys.VERSION.intern();
        fEncodingSymbol = OutputKeys.ENCODING.intern();
        fStandaloneSymbol = OutputKeys.STANDALONE.intern();
        fAmpSymbol = "amp".intern();
        fLtSymbol = "lt".intern();
        fGtSymbol = "gt".intern();
        fQuotSymbol = "quot".intern();
        fAposSymbol = "apos".intern();
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        this.fSymbolTable = (SymbolTable) componentManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) componentManager.getProperty(ERROR_REPORTER);
        this.fEntityManager = (XMLEntityManager) componentManager.getProperty(ENTITY_MANAGER);
        init();
        try {
            this.fValidation = componentManager.getFeature(VALIDATION);
        } catch (XMLConfigurationException e) {
            this.fValidation = DEBUG_ATTR_NORMALIZATION;
        }
        try {
            this.fNotifyCharRefs = componentManager.getFeature(NOTIFY_CHAR_REFS);
        } catch (XMLConfigurationException e2) {
            this.fNotifyCharRefs = DEBUG_ATTR_NORMALIZATION;
        }
    }

    protected void setPropertyManager(PropertyManager propertyManager) {
        this.fPropertyManager = propertyManager;
    }

    public void setProperty(String propertyId, Object value) throws XMLConfigurationException {
        if (propertyId.startsWith(Constants.XERCES_PROPERTY_PREFIX)) {
            String property = propertyId.substring(Constants.XERCES_PROPERTY_PREFIX.length());
            if (property.equals(Constants.SYMBOL_TABLE_PROPERTY)) {
                this.fSymbolTable = (SymbolTable) value;
            } else if (property.equals(Constants.ERROR_REPORTER_PROPERTY)) {
                this.fErrorReporter = (XMLErrorReporter) value;
            } else if (property.equals(Constants.ENTITY_MANAGER_PROPERTY)) {
                this.fEntityManager = (XMLEntityManager) value;
            }
        }
    }

    public void setFeature(String featureId, boolean value) throws XMLConfigurationException {
        if (VALIDATION.equals(featureId)) {
            this.fValidation = value;
        } else if (NOTIFY_CHAR_REFS.equals(featureId)) {
            this.fNotifyCharRefs = value;
        }
    }

    public boolean getFeature(String featureId) throws XMLConfigurationException {
        if (VALIDATION.equals(featureId)) {
            return this.fValidation;
        }
        if (NOTIFY_CHAR_REFS.equals(featureId)) {
            return this.fNotifyCharRefs;
        }
        throw new XMLConfigurationException((short) 0, featureId);
    }

    public void reset(PropertyManager propertyManager) {
        init();
        this.fSymbolTable = (SymbolTable) propertyManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) propertyManager.getProperty(ERROR_REPORTER);
        this.fEntityManager = (XMLEntityManager) propertyManager.getProperty(ENTITY_MANAGER);
        this.fEntityStore = this.fEntityManager.getEntityStore();
        this.fEntityScanner = (XMLEntityReaderImpl) this.fEntityManager.getEntityReader();
        this.fValidation = DEBUG_ATTR_NORMALIZATION;
        this.fNotifyCharRefs = DEBUG_ATTR_NORMALIZATION;
    }

    protected void scanXMLDeclOrTextDecl(boolean scanningTextDecl, String[] pseudoAttributeValues) throws IOException, XNIException {
        String version = null;
        String encoding = null;
        String standalone = null;
        int state = 0;
        boolean dataFoundForTarget = DEBUG_ATTR_NORMALIZATION;
        boolean sawSpace = this.fEntityScanner.skipSpaces();
        while (this.fEntityScanner.peekChar() != 63) {
            dataFoundForTarget = true;
            String name = scanPseudoAttribute(scanningTextDecl, this.fString);
            switch (state) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    if (!name.equals(fVersionSymbol)) {
                        if (!name.equals(fEncodingSymbol)) {
                            if (!scanningTextDecl) {
                                reportFatalError("VersionInfoRequired", null);
                                break;
                            } else {
                                reportFatalError("EncodingDeclRequired", null);
                                break;
                            }
                        }
                        if (!scanningTextDecl) {
                            reportFatalError("VersionInfoRequired", null);
                        }
                        if (!sawSpace) {
                            reportFatalError(scanningTextDecl ? "SpaceRequiredBeforeEncodingInTextDecl" : "SpaceRequiredBeforeEncodingInXMLDecl", null);
                        }
                        encoding = this.fString.toString();
                        state = scanningTextDecl ? 3 : 2;
                        break;
                    }
                    if (!sawSpace) {
                        reportFatalError(scanningTextDecl ? "SpaceRequiredBeforeVersionInTextDecl" : "SpaceRequiredBeforeVersionInXMLDecl", null);
                    }
                    version = this.fString.toString();
                    state = 1;
                    if (!versionSupported(version)) {
                        reportFatalError("VersionNotSupported", new Object[]{version});
                        break;
                    }
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    if (!name.equals(fEncodingSymbol)) {
                        if (!scanningTextDecl && name.equals(fStandaloneSymbol)) {
                            if (!sawSpace) {
                                reportFatalError("SpaceRequiredBeforeStandalone", null);
                            }
                            standalone = this.fString.toString();
                            state = 3;
                            if (!(standalone.equals("yes") || standalone.equals("no"))) {
                                reportFatalError("SDDeclInvalid", null);
                                break;
                            }
                        }
                        reportFatalError("EncodingDeclRequired", null);
                        break;
                    }
                    if (!sawSpace) {
                        reportFatalError(scanningTextDecl ? "SpaceRequiredBeforeEncodingInTextDecl" : "SpaceRequiredBeforeEncodingInXMLDecl", null);
                    }
                    encoding = this.fString.toString();
                    state = scanningTextDecl ? 3 : 2;
                    break;
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    if (!name.equals(fStandaloneSymbol)) {
                        reportFatalError("EncodingDeclRequired", null);
                        break;
                    }
                    if (!sawSpace) {
                        reportFatalError("SpaceRequiredBeforeStandalone", null);
                    }
                    standalone = this.fString.toString();
                    state = 3;
                    if (!(standalone.equals("yes") || standalone.equals("no"))) {
                        reportFatalError("SDDeclInvalid", null);
                        break;
                    }
                default:
                    reportFatalError("NoMorePseudoAttributes", null);
                    break;
            }
            sawSpace = this.fEntityScanner.skipSpaces();
        }
        if (scanningTextDecl && state != 3) {
            reportFatalError("MorePseudoAttributes", null);
        }
        if (scanningTextDecl) {
            if (!dataFoundForTarget && encoding == null) {
                reportFatalError("EncodingDeclRequired", null);
            }
        } else if (!dataFoundForTarget && version == null) {
            reportFatalError("VersionInfoRequired", null);
        }
        if (!this.fEntityScanner.skipChar(63)) {
            reportFatalError("XMLDeclUnterminated", null);
        }
        if (!this.fEntityScanner.skipChar(62)) {
            reportFatalError("XMLDeclUnterminated", null);
        }
        pseudoAttributeValues[0] = version;
        pseudoAttributeValues[1] = encoding;
        pseudoAttributeValues[2] = standalone;
    }

    public String scanPseudoAttribute(boolean scanningTextDecl, XMLString value) throws IOException, XNIException {
        String name = this.fEntityScanner.scanName();
        if (name == null) {
            reportFatalError("PseudoAttrNameExpected", null);
        }
        this.fEntityScanner.skipSpaces();
        if (!this.fEntityScanner.skipChar(61)) {
            reportFatalError(scanningTextDecl ? "EqRequiredInTextDecl" : "EqRequiredInXMLDecl", new Object[]{name});
        }
        this.fEntityScanner.skipSpaces();
        int quote = this.fEntityScanner.peekChar();
        if (!(quote == 39 || quote == 34)) {
            reportFatalError(scanningTextDecl ? "QuoteRequiredInTextDecl" : "QuoteRequiredInXMLDecl", new Object[]{name});
        }
        this.fEntityScanner.scanChar();
        int c = this.fEntityScanner.scanLiteral(quote, value);
        if (c != quote) {
            this.fStringBuffer2.clear();
            do {
                this.fStringBuffer2.append(value);
                if (c != -1) {
                    if (c == 38 || c == 37 || c == 60 || c == 93) {
                        this.fStringBuffer2.append((char) this.fEntityScanner.scanChar());
                    } else if (XMLChar.isHighSurrogate(c)) {
                        scanSurrogates(this.fStringBuffer2);
                    } else if (isInvalidLiteral(c)) {
                        reportFatalError(scanningTextDecl ? "InvalidCharInTextDecl" : "InvalidCharInXMLDecl", new Object[]{Integer.toString(c, 16)});
                        this.fEntityScanner.scanChar();
                    }
                }
                c = this.fEntityScanner.scanLiteral(quote, value);
            } while (c != quote);
            this.fStringBuffer2.append(value);
            value.setValues(this.fStringBuffer2);
        }
        if (!this.fEntityScanner.skipChar(quote)) {
            reportFatalError(scanningTextDecl ? "CloseQuoteMissingInTextDecl" : "CloseQuoteMissingInXMLDecl", new Object[]{name});
        }
        return name;
    }

    protected void scanPI(XMLStringBuffer data) throws IOException, XNIException {
        this.fReportEntity = DEBUG_ATTR_NORMALIZATION;
        String target = this.fEntityScanner.scanName();
        if (target == null) {
            reportFatalError("PITargetRequired", null);
        }
        scanPIData(target, data);
        this.fReportEntity = true;
    }

    protected void scanPIData(String target, XMLStringBuffer data) throws IOException, XNIException {
        if (target.length() == 3) {
            char c0 = Character.toLowerCase(target.charAt(0));
            char c1 = Character.toLowerCase(target.charAt(1));
            char c2 = Character.toLowerCase(target.charAt(2));
            if (c0 == 'x' && c1 == 'm' && c2 == 'l') {
                reportFatalError("ReservedPITarget", null);
            }
        }
        if (!this.fEntityScanner.skipSpaces()) {
            if (!this.fEntityScanner.skipString("?>")) {
                reportFatalError("SpaceRequiredInPI", null);
            } else {
                return;
            }
        }
        if (this.fEntityScanner.scanData("?>", data)) {
            do {
                int c = this.fEntityScanner.peekChar();
                if (c != -1) {
                    if (XMLChar.isHighSurrogate(c)) {
                        scanSurrogates(data);
                    } else if (isInvalidLiteral(c)) {
                        reportFatalError("InvalidCharInPI", new Object[]{Integer.toHexString(c)});
                        this.fEntityScanner.scanChar();
                    }
                }
            } while (this.fEntityScanner.scanData("?>", data));
        }
    }

    protected void scanComment(XMLStringBuffer text) throws IOException, XNIException {
        text.clear();
        while (this.fEntityScanner.scanData("--", text)) {
            int c = this.fEntityScanner.peekChar();
            if (c != -1) {
                if (XMLChar.isHighSurrogate(c)) {
                    scanSurrogates(text);
                }
                if (isInvalidLiteral(c)) {
                    reportFatalError("InvalidCharInComment", new Object[]{Integer.toHexString(c)});
                    this.fEntityScanner.scanChar();
                }
            }
        }
        if (!this.fEntityScanner.skipChar(62)) {
            reportFatalError("DashDashInComment", null);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void scanAttributeValue(com.amazonaws.javax.xml.stream.xerces.xni.XMLString r14, com.amazonaws.javax.xml.stream.xerces.xni.XMLString r15, java.lang.String r16, com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes r17, int r18, boolean r19) throws java.io.IOException, com.amazonaws.javax.xml.stream.xerces.xni.XNIException {
        /*
        r13 = this;
        r12 = 0;
        r0 = r13.fEntityScanner;
        r11 = r0.peekChar();
        r0 = 39;
        if (r11 == r0) goto L_0x001a;
    L_0x000b:
        r0 = 34;
        if (r11 == r0) goto L_0x001a;
    L_0x000f:
        r0 = "OpenQuoteExpected";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r16;
        r13.reportFatalError(r0, r1);
    L_0x001a:
        r0 = r13.fEntityScanner;
        r0.scanChar();
        r9 = r13.fEntityDepth;
        r0 = r13.fEntityScanner;
        r6 = r0.scanLiteral(r11, r14);
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x0035;
    L_0x002b:
        r0 = r13.fStringBuffer2;
        r0.clear();
        r0 = r13.fStringBuffer2;
        r0.append(r14);
    L_0x0035:
        r0 = r13.fEntityScanner;
        r0 = r0.whiteSpaceLen;
        if (r0 <= 0) goto L_0x003e;
    L_0x003b:
        r13.normalizeWhitespace(r14);
    L_0x003e:
        if (r6 == r11) goto L_0x00b8;
    L_0x0040:
        r0 = 1;
        r13.fScanningAttribute = r0;
        r12 = r13.getStringBuffer();
        r12.clear();
    L_0x004a:
        r12.append(r14);
        r0 = 38;
        if (r6 != r0) goto L_0x019b;
    L_0x0051:
        r0 = r13.fEntityScanner;
        r1 = 38;
        r0.skipChar(r1);
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x0067;
    L_0x005c:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x0067;
    L_0x0060:
        r0 = r13.fStringBuffer2;
        r1 = 38;
        r0.append(r1);
    L_0x0067:
        r0 = r13.fEntityScanner;
        r1 = 35;
        r0 = r0.skipChar(r1);
        if (r0 == 0) goto L_0x00db;
    L_0x0071:
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x0080;
    L_0x0075:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x0080;
    L_0x0079:
        r0 = r13.fStringBuffer2;
        r1 = 35;
        r0.append(r1);
    L_0x0080:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x00d5;
    L_0x0084:
        r0 = r13.fStringBuffer2;
        r7 = r13.scanCharReferenceValue(r12, r0);
    L_0x008a:
        r0 = -1;
        if (r7 == r0) goto L_0x008d;
    L_0x008d:
        r0 = r13.fEntityScanner;
        r6 = r0.scanLiteral(r11, r14);
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x00a0;
    L_0x0097:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x00a0;
    L_0x009b:
        r0 = r13.fStringBuffer2;
        r0.append(r14);
    L_0x00a0:
        r0 = r13.fEntityScanner;
        r0 = r0.whiteSpaceLen;
        if (r0 <= 0) goto L_0x00a9;
    L_0x00a6:
        r13.normalizeWhitespace(r14);
    L_0x00a9:
        if (r6 != r11) goto L_0x004a;
    L_0x00ab:
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x004a;
    L_0x00af:
        r12.append(r14);
        r14.setValues(r12);
        r0 = 0;
        r13.fScanningAttribute = r0;
    L_0x00b8:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x00c1;
    L_0x00bc:
        r0 = r13.fStringBuffer2;
        r15.setValues(r0);
    L_0x00c1:
        r0 = r13.fEntityScanner;
        r8 = r0.scanChar();
        if (r8 == r11) goto L_0x00d4;
    L_0x00c9:
        r0 = "CloseQuoteExpected";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r16;
        r13.reportFatalError(r0, r1);
    L_0x00d4:
        return;
    L_0x00d5:
        r0 = 0;
        r7 = r13.scanCharReferenceValue(r12, r0);
        goto L_0x008a;
    L_0x00db:
        r0 = r13.fEntityScanner;
        r10 = r0.scanName();
        if (r10 != 0) goto L_0x0108;
    L_0x00e3:
        r0 = "NameRequiredInReference";
        r1 = 0;
        r13.reportFatalError(r0, r1);
    L_0x00e9:
        r0 = r13.fEntityScanner;
        r1 = 59;
        r0 = r0.skipChar(r1);
        if (r0 != 0) goto L_0x0116;
    L_0x00f3:
        r0 = "SemicolonRequiredInReference";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r10;
        r13.reportFatalError(r0, r1);
    L_0x00fe:
        r0 = fAmpSymbol;
        if (r10 != r0) goto L_0x0126;
    L_0x0102:
        r0 = 38;
        r12.append(r0);
        goto L_0x008d;
    L_0x0108:
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x00e9;
    L_0x010c:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x00e9;
    L_0x0110:
        r0 = r13.fStringBuffer2;
        r0.append(r10);
        goto L_0x00e9;
    L_0x0116:
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x00fe;
    L_0x011a:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x00fe;
    L_0x011e:
        r0 = r13.fStringBuffer2;
        r1 = 59;
        r0.append(r1);
        goto L_0x00fe;
    L_0x0126:
        r0 = fAposSymbol;
        if (r10 != r0) goto L_0x0131;
    L_0x012a:
        r0 = 39;
        r12.append(r0);
        goto L_0x008d;
    L_0x0131:
        r0 = fLtSymbol;
        if (r10 != r0) goto L_0x013c;
    L_0x0135:
        r0 = 60;
        r12.append(r0);
        goto L_0x008d;
    L_0x013c:
        r0 = fGtSymbol;
        if (r10 != r0) goto L_0x0147;
    L_0x0140:
        r0 = 62;
        r12.append(r0);
        goto L_0x008d;
    L_0x0147:
        r0 = fQuotSymbol;
        if (r10 != r0) goto L_0x0152;
    L_0x014b:
        r0 = 34;
        r12.append(r0);
        goto L_0x008d;
    L_0x0152:
        r0 = r13.fEntityStore;
        r0 = r0.isExternalEntity(r10);
        if (r0 == 0) goto L_0x0167;
    L_0x015a:
        r0 = "ReferenceToExternalEntity";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r10;
        r13.reportFatalError(r0, r1);
        goto L_0x008d;
    L_0x0167:
        r0 = r13.fEntityStore;
        r0 = r0.isDeclaredEntity(r10);
        if (r0 != 0) goto L_0x0187;
    L_0x016f:
        if (r19 == 0) goto L_0x018f;
    L_0x0171:
        r0 = r13.fValidation;
        if (r0 == 0) goto L_0x0187;
    L_0x0175:
        r0 = r13.fErrorReporter;
        r1 = r13.fEntityScanner;
        r2 = "http://www.w3.org/TR/1998/REC-xml-19980210";
        r3 = "EntityNotDeclared";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r10;
        r5 = 1;
        r0.reportError(r1, r2, r3, r4, r5);
    L_0x0187:
        r0 = r13.fEntityManager;
        r1 = 1;
        r0.startEntity(r10, r1);
        goto L_0x008d;
    L_0x018f:
        r0 = "EntityNotDeclared";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r10;
        r13.reportFatalError(r0, r1);
        goto L_0x0187;
    L_0x019b:
        r0 = 60;
        if (r6 != r0) goto L_0x01c3;
    L_0x019f:
        r0 = "LessthanInAttValue";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = 0;
        r1[r2] = r3;
        r2 = 1;
        r1[r2] = r16;
        r13.reportFatalError(r0, r1);
        r0 = r13.fEntityScanner;
        r0.scanChar();
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x008d;
    L_0x01b7:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x008d;
    L_0x01bb:
        r0 = r13.fStringBuffer2;
        r1 = (char) r6;
        r0.append(r1);
        goto L_0x008d;
    L_0x01c3:
        r0 = 37;
        if (r6 == r0) goto L_0x01cb;
    L_0x01c7:
        r0 = 93;
        if (r6 != r0) goto L_0x01e4;
    L_0x01cb:
        r0 = r13.fEntityScanner;
        r0.scanChar();
        r0 = (char) r6;
        r12.append(r0);
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x008d;
    L_0x01d8:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x008d;
    L_0x01dc:
        r0 = r13.fStringBuffer2;
        r1 = (char) r6;
        r0.append(r1);
        goto L_0x008d;
    L_0x01e4:
        r0 = 10;
        if (r6 == r0) goto L_0x01ec;
    L_0x01e8:
        r0 = 13;
        if (r6 != r0) goto L_0x0207;
    L_0x01ec:
        r0 = r13.fEntityScanner;
        r0.scanChar();
        r0 = 32;
        r12.append(r0);
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x008d;
    L_0x01fa:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x008d;
    L_0x01fe:
        r0 = r13.fStringBuffer2;
        r1 = 10;
        r0.append(r1);
        goto L_0x008d;
    L_0x0207:
        r0 = -1;
        if (r6 == r0) goto L_0x022e;
    L_0x020a:
        r0 = com.amazonaws.javax.xml.stream.xerces.util.XMLChar.isHighSurrogate(r6);
        if (r0 == 0) goto L_0x022e;
    L_0x0210:
        r0 = r13.fStringBuffer3;
        r0 = r13.scanSurrogates(r0);
        if (r0 == 0) goto L_0x008d;
    L_0x0218:
        r0 = r13.fStringBuffer3;
        r12.append(r0);
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x008d;
    L_0x0221:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x008d;
    L_0x0225:
        r0 = r13.fStringBuffer2;
        r1 = r13.fStringBuffer3;
        r0.append(r1);
        goto L_0x008d;
    L_0x022e:
        r0 = -1;
        if (r6 == r0) goto L_0x008d;
    L_0x0231:
        r0 = isInvalidLiteral(r6);
        if (r0 == 0) goto L_0x008d;
    L_0x0237:
        r0 = "InvalidCharInAttValue";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = 16;
        r3 = java.lang.Integer.toString(r6, r3);
        r1[r2] = r3;
        r13.reportFatalError(r0, r1);
        r0 = r13.fEntityScanner;
        r0.scanChar();
        r0 = r13.fEntityDepth;
        if (r9 != r0) goto L_0x008d;
    L_0x0251:
        r0 = r13.fNeedNonNormalizedValue;
        if (r0 == 0) goto L_0x008d;
    L_0x0255:
        r0 = r13.fStringBuffer2;
        r1 = (char) r6;
        r0.append(r1);
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.XMLScanner.scanAttributeValue(com.amazonaws.javax.xml.stream.xerces.xni.XMLString, com.amazonaws.javax.xml.stream.xerces.xni.XMLString, java.lang.String, com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes, int, boolean):void");
    }

    protected void scanExternalID(String[] identifiers, boolean optionalSystemId) throws IOException, XNIException {
        String systemId = null;
        String publicId = null;
        if (this.fEntityScanner.skipString("PUBLIC")) {
            if (!this.fEntityScanner.skipSpaces()) {
                reportFatalError("SpaceRequiredAfterPUBLIC", null);
            }
            scanPubidLiteral(this.fString);
            publicId = this.fString.toString();
            if (!(this.fEntityScanner.skipSpaces() || optionalSystemId)) {
                reportFatalError("SpaceRequiredBetweenPublicAndSystem", null);
            }
        }
        if (publicId != null || this.fEntityScanner.skipString("SYSTEM")) {
            if (publicId == null && !this.fEntityScanner.skipSpaces()) {
                reportFatalError("SpaceRequiredAfterSYSTEM", null);
            }
            int quote = this.fEntityScanner.peekChar();
            if (!(quote == 39 || quote == 34)) {
                if (publicId == null || !optionalSystemId) {
                    reportFatalError("QuoteRequiredInSystemID", null);
                } else {
                    identifiers[0] = null;
                    identifiers[1] = publicId;
                    return;
                }
            }
            this.fEntityScanner.scanChar();
            XMLString ident = this.fString;
            if (this.fEntityScanner.scanLiteral(quote, ident) != quote) {
                this.fStringBuffer.clear();
                do {
                    this.fStringBuffer.append(ident);
                    int c = this.fEntityScanner.peekChar();
                    if (XMLChar.isMarkup(c) || c == 93) {
                        this.fStringBuffer.append((char) this.fEntityScanner.scanChar());
                    }
                } while (this.fEntityScanner.scanLiteral(quote, ident) != quote);
                this.fStringBuffer.append(ident);
                ident = this.fStringBuffer;
            }
            systemId = ident.toString();
            if (!this.fEntityScanner.skipChar(quote)) {
                reportFatalError("SystemIDUnterminated", null);
            }
        }
        identifiers[0] = systemId;
        identifiers[1] = publicId;
    }

    protected boolean scanPubidLiteral(XMLString literal) throws IOException, XNIException {
        int quote = this.fEntityScanner.scanChar();
        if (quote == 39 || quote == 34) {
            this.fStringBuffer.clear();
            boolean skipSpace = true;
            boolean dataok = true;
            while (true) {
                int c = this.fEntityScanner.scanChar();
                if (c == 32 || c == 10 || c == 13) {
                    if (!skipSpace) {
                        this.fStringBuffer.append(' ');
                        skipSpace = true;
                    }
                } else if (c == quote) {
                    break;
                } else if (XMLChar.isPubid(c)) {
                    this.fStringBuffer.append((char) c);
                    skipSpace = DEBUG_ATTR_NORMALIZATION;
                } else if (c == -1) {
                    reportFatalError("PublicIDUnterminated", null);
                    return DEBUG_ATTR_NORMALIZATION;
                } else {
                    dataok = DEBUG_ATTR_NORMALIZATION;
                    reportFatalError("InvalidCharInPublicID", new Object[]{Integer.toHexString(c)});
                }
            }
            if (skipSpace) {
                XMLStringBuffer xMLStringBuffer = this.fStringBuffer;
                xMLStringBuffer.length--;
            }
            literal.setValues(this.fStringBuffer);
            return dataok;
        }
        reportFatalError("QuoteRequiredInPublicID", null);
        return DEBUG_ATTR_NORMALIZATION;
    }

    protected void normalizeWhitespace(XMLString value) {
        int[] buff = this.fEntityScanner.whiteSpaceLookup;
        int buffLen = this.fEntityScanner.whiteSpaceLen;
        int end = value.offset + value.length;
        for (int i = 0; i < buffLen; i++) {
            int j = buff[i];
            if (j < end) {
                value.ch[j] = ' ';
            }
        }
    }

    public void startEntity(String name, XMLResourceIdentifier identifier, String encoding) throws XNIException {
        this.fEntityDepth++;
    }

    public void endEntity(String name) throws IOException, XNIException {
        this.fEntityDepth--;
    }

    protected int scanCharReferenceValue(XMLStringBuffer buf, XMLStringBuffer buf2) throws IOException, XNIException {
        StringBuffer errorBuf;
        boolean hex = DEBUG_ATTR_NORMALIZATION;
        int c;
        boolean digit;
        if (this.fEntityScanner.skipChar(120)) {
            if (buf2 != null) {
                buf2.append('x');
            }
            hex = true;
            this.fStringBuffer3.clear();
            c = this.fEntityScanner.peekChar();
            digit = ((c < 48 || c > 57) && ((c < 97 || c > 102) && (c < 65 || c > 70))) ? DEBUG_ATTR_NORMALIZATION : true;
            if (digit) {
                if (buf2 != null) {
                    buf2.append((char) c);
                }
                this.fEntityScanner.scanChar();
                this.fStringBuffer3.append((char) c);
                do {
                    c = this.fEntityScanner.peekChar();
                    digit = ((c < 48 || c > 57) && ((c < 97 || c > 102) && (c < 65 || c > 70))) ? DEBUG_ATTR_NORMALIZATION : true;
                    if (digit) {
                        if (buf2 != null) {
                            buf2.append((char) c);
                        }
                        this.fEntityScanner.scanChar();
                        this.fStringBuffer3.append((char) c);
                        continue;
                    }
                } while (digit);
            } else {
                reportFatalError("HexdigitRequiredInCharRef", null);
            }
        } else {
            this.fStringBuffer3.clear();
            c = this.fEntityScanner.peekChar();
            digit = (c < 48 || c > 57) ? DEBUG_ATTR_NORMALIZATION : true;
            if (digit) {
                if (buf2 != null) {
                    buf2.append((char) c);
                }
                this.fEntityScanner.scanChar();
                this.fStringBuffer3.append((char) c);
                do {
                    c = this.fEntityScanner.peekChar();
                    digit = (c < 48 || c > 57) ? DEBUG_ATTR_NORMALIZATION : true;
                    if (digit) {
                        if (buf2 != null) {
                            buf2.append((char) c);
                        }
                        this.fEntityScanner.scanChar();
                        this.fStringBuffer3.append((char) c);
                        continue;
                    }
                } while (digit);
            } else {
                reportFatalError("DigitRequiredInCharRef", null);
            }
        }
        if (!this.fEntityScanner.skipChar(59)) {
            reportFatalError("SemicolonRequiredInCharRef", null);
        }
        if (buf2 != null) {
            buf2.append(';');
        }
        int value = -1;
        try {
            value = Integer.parseInt(this.fStringBuffer3.toString(), hex ? 16 : 10);
            if (isInvalid(value)) {
                errorBuf = new StringBuffer(this.fStringBuffer3.length + 1);
                if (hex) {
                    errorBuf.append('x');
                }
                errorBuf.append(this.fStringBuffer3.ch, this.fStringBuffer3.offset, this.fStringBuffer3.length);
                reportFatalError("InvalidCharRef", new Object[]{errorBuf.toString()});
            }
        } catch (NumberFormatException e) {
            errorBuf = new StringBuffer(this.fStringBuffer3.length + 1);
            if (hex) {
                errorBuf.append('x');
            }
            errorBuf.append(this.fStringBuffer3.ch, this.fStringBuffer3.offset, this.fStringBuffer3.length);
            reportFatalError("InvalidCharRef", new Object[]{errorBuf.toString()});
        }
        if (XMLChar.isSupplemental(value)) {
            buf.append(XMLChar.highSurrogate(value));
            buf.append(XMLChar.lowSurrogate(value));
        } else {
            buf.append((char) value);
        }
        if (this.fNotifyCharRefs && value != -1) {
            String literal = new StringBuffer().append("#").append(hex ? "x" : StringUtil.EMPTY_STRING).append(this.fStringBuffer3.toString()).toString();
            if (!this.fScanningAttribute) {
                this.fCharRefLiteral = literal;
            }
        }
        return value;
    }

    protected static boolean isInvalid(int value) {
        return XMLChar.isInvalid(value);
    }

    protected static boolean isInvalidLiteral(int value) {
        return XMLChar.isInvalid(value);
    }

    protected static boolean isValidNameChar(int value) {
        return XMLChar.isName(value);
    }

    protected static boolean isValidNCName(int value) {
        return XMLChar.isNCName(value);
    }

    protected static boolean isValidNameStartChar(int value) {
        return XMLChar.isNameStart(value);
    }

    protected boolean versionSupported(String version) {
        return version.equals(XMLStreamWriterImpl.DEFAULT_XML_VERSION);
    }

    protected boolean scanSurrogates(XMLStringBuffer buf) throws IOException, XNIException {
        int high = this.fEntityScanner.scanChar();
        int low = this.fEntityScanner.peekChar();
        if (XMLChar.isLowSurrogate(low)) {
            this.fEntityScanner.scanChar();
            if (isInvalid(XMLChar.supplemental((char) high, (char) low))) {
                reportFatalError("InvalidCharInContent", new Object[]{Integer.toString(XMLChar.supplemental((char) high, (char) low), 16)});
                return DEBUG_ATTR_NORMALIZATION;
            }
            buf.append((char) high);
            buf.append((char) low);
            return true;
        }
        reportFatalError("InvalidCharInContent", new Object[]{Integer.toString(high, 16)});
        return DEBUG_ATTR_NORMALIZATION;
    }

    protected void reportFatalError(String msgId, Object[] args) throws XNIException {
        this.fErrorReporter.reportError(this.fEntityScanner, XMLMessageFormatter.XML_DOMAIN, msgId, args, (short) 2);
    }

    private void init() {
        this.fEntityDepth = 0;
        this.fReportEntity = true;
        this.fResourceIdentifier.clear();
    }

    XMLStringBuffer getStringBuffer() {
        if (this.fStringBufferIndex < this.initialCacheCount || this.fStringBufferIndex < this.stringBufferCache.size()) {
            ArrayList arrayList = this.stringBufferCache;
            int i = this.fStringBufferIndex;
            this.fStringBufferIndex = i + 1;
            return (XMLStringBuffer) arrayList.get(i);
        }
        XMLStringBuffer tmpObj = new XMLStringBuffer();
        this.stringBufferCache.add(this.fStringBufferIndex, tmpObj);
        return tmpObj;
    }
}
