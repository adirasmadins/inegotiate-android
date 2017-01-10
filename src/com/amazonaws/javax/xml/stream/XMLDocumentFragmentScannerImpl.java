package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesIteratorImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLDocumentHandler;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponent;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDocumentScanner;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import com.amazonaws.services.s3.internal.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import org.apache.commons.logging.impl.SimpleLog;

public class XMLDocumentFragmentScannerImpl extends XMLScanner implements XMLDocumentScanner, XMLComponent, XMLEntityHandler {
    protected static final boolean DEBUG = false;
    protected static final boolean DEBUG_COALESCE = false;
    protected static final boolean DEBUG_CONTENT_SCANNING = false;
    private static final boolean DEBUG_DISPATCHER = false;
    protected static final boolean DEBUG_NEXT = false;
    private static final boolean DEBUG_SCANNER_STATE = false;
    static final boolean DEBUG_SKIP_ALGORITHM = false;
    static final short ELEMENT_ARRAY_LENGTH = (short) 200;
    private static final Boolean[] FEATURE_DEFAULTS;
    static final short MAX_DEPTH_LIMIT = (short) 5;
    static final short MAX_POINTER_AT_A_DEPTH = (short) 4;
    protected static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    protected static final String NOTIFY_BUILTIN_REFS = "http://apache.org/xml/features/scanner/notify-builtin-refs";
    private static final Object[] PROPERTY_DEFAULTS;
    private static final String[] RECOGNIZED_FEATURES;
    private static final String[] RECOGNIZED_PROPERTIES;
    protected static final int SCANNER_STATE_ATTRIBUTE = 29;
    protected static final int SCANNER_STATE_ATTRIBUTE_VALUE = 30;
    protected static final int SCANNER_STATE_BUILT_IN_REFS = 41;
    protected static final int SCANNER_STATE_CDATA = 35;
    protected static final int SCANNER_STATE_CHARACTER_DATA = 37;
    protected static final int SCANNER_STATE_CHAR_REFERENCE = 40;
    protected static final int SCANNER_STATE_COMMENT = 27;
    protected static final int SCANNER_STATE_CONTENT = 22;
    protected static final int SCANNER_STATE_DOCTYPE = 24;
    protected static final int SCANNER_STATE_END_ELEMENT_TAG = 39;
    protected static final int SCANNER_STATE_END_OF_INPUT = 33;
    protected static final int SCANNER_STATE_PI = 23;
    protected static final int SCANNER_STATE_REFERENCE = 28;
    protected static final int SCANNER_STATE_ROOT_ELEMENT = 26;
    protected static final int SCANNER_STATE_START_ELEMENT_TAG = 38;
    protected static final int SCANNER_STATE_START_OF_MARKUP = 21;
    protected static final int SCANNER_STATE_TERMINATED = 34;
    protected static final int SCANNER_STATE_TEXT_DECL = 36;
    protected static final int SCANNER_STATE_XML_DECL = 25;
    protected static final char[] cdata;
    protected static final char[] endTag;
    protected static final char[] xmlDecl;
    protected DTDGrammarUtil dtdGrammarUtil;
    protected boolean fAdd;
    protected boolean fAddDefaultAttr;
    protected QName fAttributeQName;
    protected XMLAttributesIteratorImpl fAttributes;
    protected XMLStringBuffer fContentBuffer;
    protected Driver fContentDriver;
    protected QName fCurrentElement;
    private String fCurrentEntityName;
    protected String fDeclaredEncoding;
    protected boolean fDisallowDoctype;
    protected XMLDocumentHandler fDocumentHandler;
    protected Driver fDriver;
    String[] fElementArray;
    short fElementPointer;
    protected QName fElementQName;
    protected String fElementRawname;
    protected ElementStack fElementStack;
    protected ElementStack2 fElementStack2;
    protected boolean fEmptyElement;
    protected int[] fEntityStack;
    protected XMLEntityStorage fEntityStore;
    protected boolean fHasExternalDTD;
    protected boolean fInScanContent;
    protected boolean fIsCoalesce;
    short fLastPointerLocation;
    protected boolean fLastSectionWasCData;
    protected boolean fLastSectionWasCharacterData;
    protected boolean fLastSectionWasEntityReference;
    protected int fMarkupDepth;
    protected boolean fNamespaces;
    protected boolean fNotifyBuiltInRefs;
    protected XMLString fPIData;
    protected String fPITarget;
    short[][] fPointerInfo;
    protected boolean fReplaceEntityReferences;
    protected boolean fReportCdataEvent;
    protected boolean fScanToEnd;
    protected int fScannerState;
    protected boolean fShouldSkip;
    private final char[] fSingleChar;
    protected boolean fSkip;
    protected boolean fStandalone;
    protected boolean fStandaloneSet;
    protected XMLStringBuffer fStringBuffer;
    protected XMLStringBuffer fStringBuffer2;
    private String[] fStrings;
    protected boolean fSupportExternalEntities;
    protected XMLString fTempString;
    protected XMLString fTempString2;
    boolean fUsebuffer;
    protected String fVersion;
    protected boolean foundBuiltInRefs;

    protected interface Driver {
        int next() throws IOException, XNIException;
    }

    protected static final class Element {
        public char[] fRawname;
        public Element next;
        public QName qname;

        public Element(QName qname, Element next) {
            this.qname.setValues(qname);
            this.fRawname = qname.rawname.toCharArray();
            this.next = next;
        }
    }

    protected class ElementStack2 {
        protected int fCount;
        protected int fDepth;
        protected int fLastDepth;
        protected int fMark;
        protected int fPosition;
        protected QName[] fQName;

        public ElementStack2() {
            this.fQName = new QName[20];
            for (int i = 0; i < this.fQName.length; i++) {
                this.fQName[i] = new QName();
            }
            this.fPosition = 1;
            this.fMark = 1;
        }

        public void resize() {
            int oldLength = this.fQName.length;
            QName[] tmp = new QName[(oldLength * 2)];
            System.arraycopy(this.fQName, 0, tmp, 0, oldLength);
            this.fQName = tmp;
            for (int i = oldLength; i < this.fQName.length; i++) {
                this.fQName[i] = new QName();
            }
        }

        public boolean matchElement(QName element) {
            boolean match = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
            if (this.fLastDepth > this.fDepth && this.fDepth <= 2) {
                if (element.rawname == this.fQName[this.fDepth].rawname) {
                    XMLDocumentFragmentScannerImpl.this.fAdd = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                    this.fMark = this.fDepth - 1;
                    this.fPosition = this.fMark + 1;
                    match = true;
                    this.fCount--;
                } else {
                    XMLDocumentFragmentScannerImpl.this.fAdd = true;
                }
            }
            int i = this.fDepth;
            this.fDepth = i + 1;
            this.fLastDepth = i;
            return match;
        }

        public QName nextElement() {
            if (this.fCount == this.fQName.length) {
                XMLDocumentFragmentScannerImpl.this.fShouldSkip = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                XMLDocumentFragmentScannerImpl.this.fAdd = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                QName[] qNameArr = this.fQName;
                int i = this.fCount - 1;
                this.fCount = i;
                return qNameArr[i];
            }
            qNameArr = this.fQName;
            i = this.fCount;
            this.fCount = i + 1;
            return qNameArr[i];
        }

        public QName getNext() {
            if (this.fPosition == this.fCount) {
                this.fPosition = this.fMark;
            }
            QName[] qNameArr = this.fQName;
            int i = this.fPosition;
            this.fPosition = i + 1;
            return qNameArr[i];
        }

        public int popElement() {
            int i = this.fDepth;
            this.fDepth = i - 1;
            return i;
        }

        public void clear() {
            this.fLastDepth = 0;
            this.fDepth = 0;
            this.fCount = 0;
            this.fMark = 1;
            this.fPosition = 1;
        }
    }

    protected class ElementStack {
        protected int fCount;
        protected int fDepth;
        protected QName[] fElements;
        protected int[] fInt;
        protected int fLastDepth;
        protected int fMark;
        protected int fPosition;

        public ElementStack() {
            this.fInt = new int[20];
            this.fElements = new QName[20];
            for (int i = 0; i < this.fElements.length; i++) {
                this.fElements[i] = new QName();
            }
        }

        public QName pushElement(QName element) {
            if (this.fDepth == this.fElements.length) {
                QName[] array = new QName[(this.fElements.length * 2)];
                System.arraycopy(this.fElements, 0, array, 0, this.fDepth);
                this.fElements = array;
                for (int i = this.fDepth; i < this.fElements.length; i++) {
                    this.fElements[i] = new QName();
                }
            }
            this.fElements[this.fDepth].setValues(element);
            QName[] qNameArr = this.fElements;
            int i2 = this.fDepth;
            this.fDepth = i2 + 1;
            return qNameArr[i2];
        }

        public QName getNext() {
            if (this.fPosition == this.fCount) {
                this.fPosition = this.fMark;
            }
            return this.fElements[this.fPosition];
        }

        public void push() {
            int[] iArr = this.fInt;
            int i = this.fDepth + 1;
            this.fDepth = i;
            int i2 = this.fPosition;
            this.fPosition = i2 + 1;
            iArr[i] = i2;
        }

        public boolean matchElement(QName element) {
            boolean match = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
            if (this.fLastDepth > this.fDepth && this.fDepth <= 3) {
                if (element.rawname == this.fElements[this.fDepth - 1].rawname) {
                    XMLDocumentFragmentScannerImpl.this.fAdd = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                    this.fMark = this.fDepth - 1;
                    this.fPosition = this.fMark;
                    match = true;
                    this.fCount--;
                } else {
                    XMLDocumentFragmentScannerImpl.this.fAdd = true;
                }
            }
            if (match) {
                int[] iArr = this.fInt;
                int i = this.fDepth;
                int i2 = this.fPosition;
                this.fPosition = i2 + 1;
                iArr[i] = i2;
            } else {
                this.fInt[this.fDepth] = this.fCount - 1;
            }
            if (this.fCount == this.fElements.length) {
                XMLDocumentFragmentScannerImpl.this.fSkip = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                XMLDocumentFragmentScannerImpl.this.fAdd = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                reposition();
                return XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
            }
            this.fLastDepth = this.fDepth;
            return match;
        }

        public QName nextElement() {
            if (XMLDocumentFragmentScannerImpl.this.fSkip) {
                this.fDepth++;
                QName[] qNameArr = this.fElements;
                int i = this.fCount;
                this.fCount = i + 1;
                return qNameArr[i];
            }
            if (this.fDepth == this.fElements.length) {
                QName[] array = new QName[(this.fElements.length * 2)];
                System.arraycopy(this.fElements, 0, array, 0, this.fDepth);
                this.fElements = array;
                for (int i2 = this.fDepth; i2 < this.fElements.length; i2++) {
                    this.fElements[i2] = new QName();
                }
            }
            qNameArr = this.fElements;
            i = this.fDepth;
            this.fDepth = i + 1;
            return qNameArr[i];
        }

        public QName popElement() {
            if (XMLDocumentFragmentScannerImpl.this.fSkip || XMLDocumentFragmentScannerImpl.this.fAdd) {
                QName[] qNameArr = this.fElements;
                int[] iArr = this.fInt;
                int i = this.fDepth;
                this.fDepth = i - 1;
                return qNameArr[iArr[i]];
            }
            qNameArr = this.fElements;
            int i2 = this.fDepth - 1;
            this.fDepth = i2;
            return qNameArr[i2];
        }

        public void reposition() {
            for (int i = 2; i <= this.fDepth; i++) {
                this.fElements[i - 1] = this.fElements[this.fInt[i]];
            }
        }

        public void clear() {
            this.fDepth = 0;
            this.fLastDepth = 0;
            this.fCount = 0;
            this.fMark = 1;
            this.fPosition = 1;
        }

        public QName getLastPoppedElement() {
            return this.fElements[this.fDepth];
        }
    }

    protected class FragmentContentDriver implements Driver {
        private boolean fContinueDispatching;
        private boolean fScanningForMarkup;

        protected FragmentContentDriver() {
            this.fContinueDispatching = true;
            this.fScanningForMarkup = true;
        }

        private void startOfMarkup() throws IOException {
            XMLDocumentFragmentScannerImpl xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
            xMLDocumentFragmentScannerImpl.fMarkupDepth++;
            int ch = XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar();
            switch (ch) {
                case XMLDocumentFragmentScannerImpl.SCANNER_STATE_END_OF_INPUT /*33*/:
                    XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(ch);
                    if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(45)) {
                        if (!XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(45)) {
                            XMLDocumentFragmentScannerImpl.this.reportFatalError("InvalidCommentStart", null);
                        }
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_COMMENT);
                    } else if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipString(XMLDocumentFragmentScannerImpl.cdata)) {
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CDATA);
                    } else if (!scanForDoctypeHook()) {
                        XMLDocumentFragmentScannerImpl.this.reportFatalError("MarkupNotRecognizedInContent", null);
                    }
                case 47:
                    XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_END_ELEMENT_TAG);
                    XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(ch);
                case 63:
                    XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_PI);
                    XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(ch);
                default:
                    if (XMLScanner.isValidNameStartChar(ch)) {
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG);
                    } else {
                        XMLDocumentFragmentScannerImpl.this.reportFatalError("MarkupNotRecognizedInContent", null);
                    }
            }
        }

        private void startOfContent() throws IOException {
            if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(60)) {
                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP);
            } else if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG)) {
                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE);
            } else {
                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHARACTER_DATA);
            }
        }

        public void decideSubState() throws IOException {
            while (true) {
                if (XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP) {
                    switch (XMLDocumentFragmentScannerImpl.this.fScannerState) {
                        case XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP /*21*/:
                            startOfMarkup();
                            break;
                        case XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT /*22*/:
                            startOfContent();
                            break;
                        default:
                            break;
                    }
                }
                return;
            }
        }

        public int next() throws IOException, XNIException {
            boolean z = true;
            try {
                switch (XMLDocumentFragmentScannerImpl.this.fScannerState) {
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP /*21*/:
                        break;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT /*22*/:
                        int ch = XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar();
                        if (ch != 60) {
                            if (ch != XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG) {
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHARACTER_DATA);
                                break;
                            }
                            XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE);
                            break;
                        }
                        XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP);
                        break;
                }
                startOfMarkup();
                if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                    XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                    if (XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData) {
                        if (!(XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_CDATA || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHARACTER_DATA)) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            return 4;
                        }
                    } else if (!((!XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData && !XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference) || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_CDATA || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE || XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHARACTER_DATA)) {
                        XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        return 4;
                    }
                }
                XMLDocumentFragmentScannerImpl xMLDocumentFragmentScannerImpl;
                switch (XMLDocumentFragmentScannerImpl.this.fScannerState) {
                    case SimpleLog.LOG_LEVEL_OFF /*7*/:
                        return 7;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_PI /*23*/:
                        XMLDocumentFragmentScannerImpl.this.fContentBuffer.clear();
                        XMLDocumentFragmentScannerImpl.this.scanPI(XMLDocumentFragmentScannerImpl.this.fContentBuffer);
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        return 3;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_ROOT_ELEMENT /*26*/:
                        if (scanRootElementHook()) {
                            return -1;
                        }
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        return -1;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_COMMENT /*27*/:
                        XMLDocumentFragmentScannerImpl.this.scanComment();
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        return 5;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE /*28*/:
                        xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
                        xMLDocumentFragmentScannerImpl.fMarkupDepth++;
                        XMLDocumentFragmentScannerImpl.this.foundBuiltInRefs = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce && (XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData)) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = true;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        } else {
                            XMLDocumentFragmentScannerImpl.this.fContentBuffer.clear();
                        }
                        XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                        if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CDATA)) {
                            XMLDocumentFragmentScannerImpl.this.scanCharReferenceValue(XMLDocumentFragmentScannerImpl.this.fContentBuffer, null);
                            xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
                            xMLDocumentFragmentScannerImpl.fMarkupDepth--;
                            if (!XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                                return 4;
                            }
                        }
                        XMLDocumentFragmentScannerImpl.this.scanEntityReference(XMLDocumentFragmentScannerImpl.this.fContentBuffer);
                        if (XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_BUILT_IN_REFS && !XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                            return 4;
                        } else if (XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_TEXT_DECL) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = true;
                            return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                        } else {
                            if (XMLDocumentFragmentScannerImpl.this.fScannerState == XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE) {
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                                if (!XMLDocumentFragmentScannerImpl.this.fReplaceEntityReferences) {
                                    return 9;
                                }
                            }
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = true;
                            return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                        }
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_CDATA /*35*/:
                        if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce && (XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData)) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData = true;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        } else {
                            XMLDocumentFragmentScannerImpl.this.fContentBuffer.clear();
                        }
                        XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                        XMLDocumentFragmentScannerImpl.this.scanCDATASection(XMLDocumentFragmentScannerImpl.this.fContentBuffer, true);
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData = true;
                            return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                        } else if (XMLDocumentFragmentScannerImpl.this.fReportCdataEvent) {
                            return 12;
                        } else {
                            return 4;
                        }
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_TEXT_DECL /*36*/:
                        if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipString("<?xml")) {
                            XMLDocumentFragmentScannerImpl xMLDocumentFragmentScannerImpl2 = XMLDocumentFragmentScannerImpl.this;
                            xMLDocumentFragmentScannerImpl2.fMarkupDepth++;
                            if (XMLScanner.isValidNameChar(XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar())) {
                                XMLDocumentFragmentScannerImpl.this.fStringBuffer.clear();
                                XMLDocumentFragmentScannerImpl.this.fStringBuffer.append(XMLConstants.XML_NS_PREFIX);
                                if (XMLDocumentFragmentScannerImpl.this.fNamespaces) {
                                    while (XMLScanner.isValidNCName(XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar())) {
                                        XMLDocumentFragmentScannerImpl.this.fStringBuffer.append((char) XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar());
                                    }
                                } else {
                                    while (XMLScanner.isValidNameChar(XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar())) {
                                        XMLDocumentFragmentScannerImpl.this.fStringBuffer.append((char) XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar());
                                    }
                                }
                                String target = XMLDocumentFragmentScannerImpl.this.fSymbolTable.addSymbol(XMLDocumentFragmentScannerImpl.this.fStringBuffer.ch, XMLDocumentFragmentScannerImpl.this.fStringBuffer.offset, XMLDocumentFragmentScannerImpl.this.fStringBuffer.length);
                                XMLDocumentFragmentScannerImpl.this.fStringBuffer.clear();
                                XMLDocumentFragmentScannerImpl.this.scanPIData(target, XMLDocumentFragmentScannerImpl.this.fStringBuffer);
                            } else {
                                XMLDocumentFragmentScannerImpl.this.scanXMLDeclOrTextDecl(true);
                            }
                        }
                        XMLDocumentFragmentScannerImpl.this.fEntityManager.fCurrentEntity.mayReadChunks = true;
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHARACTER_DATA /*37*/:
                        XMLDocumentFragmentScannerImpl xMLDocumentFragmentScannerImpl3 = XMLDocumentFragmentScannerImpl.this;
                        if (!(XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData)) {
                            z = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        }
                        xMLDocumentFragmentScannerImpl3.fUsebuffer = z;
                        if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce && (XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData || XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData)) {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasEntityReference = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = true;
                            XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                        } else {
                            XMLDocumentFragmentScannerImpl.this.fContentBuffer.clear();
                        }
                        XMLDocumentFragmentScannerImpl.this.fTempString.length = 0;
                        int c = XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanContent(XMLDocumentFragmentScannerImpl.this.fTempString);
                        if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(60)) {
                            if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(47)) {
                                xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
                                xMLDocumentFragmentScannerImpl.fMarkupDepth++;
                                XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_END_ELEMENT_TAG);
                            } else if (XMLChar.isNameStart(XMLDocumentFragmentScannerImpl.this.fEntityScanner.peekChar())) {
                                xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
                                xMLDocumentFragmentScannerImpl.fMarkupDepth++;
                                XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG);
                            } else {
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP);
                                if (XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                                    XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                                    XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = true;
                                    XMLDocumentFragmentScannerImpl.this.fContentBuffer.append(XMLDocumentFragmentScannerImpl.this.fTempString);
                                    XMLDocumentFragmentScannerImpl.this.fTempString.length = 0;
                                    return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                                }
                            }
                            if (XMLDocumentFragmentScannerImpl.this.fUsebuffer) {
                                XMLDocumentFragmentScannerImpl.this.fContentBuffer.append(XMLDocumentFragmentScannerImpl.this.fTempString);
                                XMLDocumentFragmentScannerImpl.this.fTempString.length = 0;
                            }
                            if (XMLDocumentFragmentScannerImpl.this.dtdGrammarUtil == null || !XMLDocumentFragmentScannerImpl.this.dtdGrammarUtil.isIgnorableWhiteSpace(XMLDocumentFragmentScannerImpl.this.fContentBuffer)) {
                                return 4;
                            }
                            return 6;
                        }
                        XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                        XMLDocumentFragmentScannerImpl.this.fContentBuffer.append(XMLDocumentFragmentScannerImpl.this.fTempString);
                        XMLDocumentFragmentScannerImpl.this.fTempString.length = 0;
                        if (c == 13) {
                            XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                            XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                            XMLDocumentFragmentScannerImpl.this.fContentBuffer.append((char) c);
                            c = -1;
                        } else if (c == 93) {
                            XMLDocumentFragmentScannerImpl.this.fUsebuffer = true;
                            XMLDocumentFragmentScannerImpl.this.fContentBuffer.append((char) XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar());
                            XMLDocumentFragmentScannerImpl.this.fInScanContent = true;
                            if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(93)) {
                                XMLDocumentFragmentScannerImpl.this.fContentBuffer.append(']');
                                while (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(93)) {
                                    XMLDocumentFragmentScannerImpl.this.fContentBuffer.append(']');
                                }
                                if (XMLDocumentFragmentScannerImpl.this.fEntityScanner.skipChar(62)) {
                                    XMLDocumentFragmentScannerImpl.this.reportFatalError("CDEndInContent", null);
                                }
                            }
                            c = -1;
                            XMLDocumentFragmentScannerImpl.this.fInScanContent = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                        }
                        while (c != 60) {
                            if (c == XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG) {
                                XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_REFERENCE);
                            } else if (c == -1 || !XMLScanner.isInvalidLiteral(c)) {
                                c = XMLDocumentFragmentScannerImpl.this.scanContent(XMLDocumentFragmentScannerImpl.this.fContentBuffer);
                                if (!XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                                    XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                                }
                            } else if (XMLChar.isHighSurrogate(c)) {
                                XMLDocumentFragmentScannerImpl.this.scanSurrogates(XMLDocumentFragmentScannerImpl.this.fContentBuffer);
                                XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                            } else {
                                XMLDocumentFragmentScannerImpl.this.reportFatalError("InvalidCharInContent", new Object[]{Integer.toString(c, 16)});
                                XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                            }
                            if (!XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                                XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = true;
                                return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                            } else if (XMLDocumentFragmentScannerImpl.this.dtdGrammarUtil == null && XMLDocumentFragmentScannerImpl.this.dtdGrammarUtil.isIgnorableWhiteSpace(XMLDocumentFragmentScannerImpl.this.fContentBuffer)) {
                                return 6;
                            }
                        }
                        XMLDocumentFragmentScannerImpl.this.fEntityScanner.scanChar();
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_OF_MARKUP);
                        if (!XMLDocumentFragmentScannerImpl.this.fIsCoalesce) {
                            return XMLDocumentFragmentScannerImpl.this.dtdGrammarUtil == null ? 4 : 4;
                        } else {
                            XMLDocumentFragmentScannerImpl.this.fLastSectionWasCharacterData = true;
                            return XMLDocumentFragmentScannerImpl.this.fDriver.next();
                        }
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_START_ELEMENT_TAG /*38*/:
                        XMLDocumentFragmentScannerImpl.this.fEmptyElement = XMLDocumentFragmentScannerImpl.this.scanStartElement();
                        if (XMLDocumentFragmentScannerImpl.this.fEmptyElement) {
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_END_ELEMENT_TAG);
                        } else {
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        }
                        return 1;
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_END_ELEMENT_TAG /*39*/:
                        if (XMLDocumentFragmentScannerImpl.this.fEmptyElement) {
                            XMLDocumentFragmentScannerImpl.this.fEmptyElement = XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                            return (XMLDocumentFragmentScannerImpl.this.fMarkupDepth == 0 && elementDepthIsZeroHook()) ? 2 : 2;
                        } else if (XMLDocumentFragmentScannerImpl.this.scanEndElement() == 0 && elementDepthIsZeroHook()) {
                            return 2;
                        } else {
                            XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                            return 2;
                        }
                    case XMLDocumentFragmentScannerImpl.SCANNER_STATE_CHAR_REFERENCE /*40*/:
                        XMLDocumentFragmentScannerImpl.this.fContentBuffer.clear();
                        XMLDocumentFragmentScannerImpl.this.scanCharReferenceValue(XMLDocumentFragmentScannerImpl.this.fContentBuffer, null);
                        xMLDocumentFragmentScannerImpl = XMLDocumentFragmentScannerImpl.this;
                        xMLDocumentFragmentScannerImpl.fMarkupDepth--;
                        XMLDocumentFragmentScannerImpl.this.setScannerState(XMLDocumentFragmentScannerImpl.SCANNER_STATE_CONTENT);
                        return 4;
                    default:
                        throw new XNIException(new StringBuffer().append("Scanner State ").append(XMLDocumentFragmentScannerImpl.this.fScannerState).append(" not Recognized ").toString());
                }
            } catch (EOFException e) {
                endOfFileHook(e);
                return -1;
            }
        }

        protected boolean scanForDoctypeHook() throws IOException, XNIException {
            return XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
        }

        protected boolean elementDepthIsZeroHook() throws IOException, XNIException {
            return XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
        }

        protected boolean scanRootElementHook() throws IOException, XNIException {
            return XMLDocumentFragmentScannerImpl.DEBUG_SKIP_ALGORITHM;
        }

        protected void endOfFileHook(EOFException e) throws IOException, XNIException {
            if (XMLDocumentFragmentScannerImpl.this.fMarkupDepth != 0) {
                XMLDocumentFragmentScannerImpl.this.reportFatalError("PrematureEOF", null);
            }
        }
    }

    static {
        RECOGNIZED_FEATURES = new String[]{NAMESPACES, "http://xml.org/sax/features/validation", NOTIFY_BUILTIN_REFS, "http://apache.org/xml/features/scanner/notify-char-refs"};
        FEATURE_DEFAULTS = new Boolean[]{null, null, Boolean.FALSE, Boolean.FALSE};
        RECOGNIZED_PROPERTIES = new String[]{"http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-manager"};
        PROPERTY_DEFAULTS = new Object[]{null, null, null};
        cdata = new char[]{'[', 'C', 'D', 'A', 'T', 'A', '['};
        xmlDecl = new char[]{XMLStreamWriterImpl.OPEN_START_TAG, '?', 'x', 'm', 'l'};
        endTag = new char[]{XMLStreamWriterImpl.OPEN_START_TAG, '/'};
    }

    public XMLDocumentFragmentScannerImpl() {
        this.fEntityStack = new int[4];
        this.fInScanContent = DEBUG_SKIP_ALGORITHM;
        this.fLastSectionWasCData = DEBUG_SKIP_ALGORITHM;
        this.fLastSectionWasEntityReference = DEBUG_SKIP_ALGORITHM;
        this.fLastSectionWasCharacterData = DEBUG_SKIP_ALGORITHM;
        this.fElementStack = new ElementStack();
        this.fElementStack2 = new ElementStack2();
        this.fPIData = new XMLString();
        this.fNotifyBuiltInRefs = DEBUG_SKIP_ALGORITHM;
        this.fReplaceEntityReferences = true;
        this.fSupportExternalEntities = DEBUG_SKIP_ALGORITHM;
        this.fReportCdataEvent = DEBUG_SKIP_ALGORITHM;
        this.fIsCoalesce = DEBUG_SKIP_ALGORITHM;
        this.fDeclaredEncoding = null;
        this.fDisallowDoctype = DEBUG_SKIP_ALGORITHM;
        this.fContentDriver = createContentDriver();
        this.fElementQName = new QName();
        this.fAttributeQName = new QName();
        this.fAttributes = new XMLAttributesIteratorImpl();
        this.fTempString = new XMLString();
        this.fTempString2 = new XMLString();
        this.fStrings = new String[3];
        this.fStringBuffer = new XMLStringBuffer();
        this.fStringBuffer2 = new XMLStringBuffer();
        this.fContentBuffer = new XMLStringBuffer();
        this.fSingleChar = new char[1];
        this.fCurrentEntityName = null;
        this.fScanToEnd = DEBUG_SKIP_ALGORITHM;
        this.dtdGrammarUtil = null;
        this.fAddDefaultAttr = DEBUG_SKIP_ALGORITHM;
        this.foundBuiltInRefs = DEBUG_SKIP_ALGORITHM;
        this.fElementArray = new String[200];
        this.fLastPointerLocation = (short) 0;
        this.fElementPointer = (short) 0;
        this.fPointerInfo = (short[][]) Array.newInstance(Short.TYPE, new int[]{5, 4});
        this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
        this.fAdd = DEBUG_SKIP_ALGORITHM;
        this.fSkip = DEBUG_SKIP_ALGORITHM;
    }

    public void setInputSource(XMLInputSource inputSource) throws IOException {
        this.fEntityManager.setEntityHandler(this);
        this.fEntityManager.startEntity("$fragment$", inputSource, DEBUG_SKIP_ALGORITHM, true);
    }

    public boolean scanDocument(boolean complete) throws IOException, XNIException {
        this.fEntityManager.setEntityHandler(this);
        return true;
    }

    public int next() throws IOException, XNIException {
        return this.fDriver.next();
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        super.reset(componentManager);
        try {
            this.fNamespaces = componentManager.getFeature(NAMESPACES);
        } catch (XMLConfigurationException e) {
            this.fNamespaces = true;
        }
        try {
            this.fNotifyBuiltInRefs = componentManager.getFeature(NOTIFY_BUILTIN_REFS);
        } catch (XMLConfigurationException e2) {
            this.fNotifyBuiltInRefs = DEBUG_SKIP_ALGORITHM;
        }
        this.fMarkupDepth = 0;
        this.fCurrentElement = null;
        this.fElementStack.clear();
        this.fHasExternalDTD = DEBUG_SKIP_ALGORITHM;
        this.fStandaloneSet = DEBUG_SKIP_ALGORITHM;
        this.fStandalone = DEBUG_SKIP_ALGORITHM;
        setScannerState(SCANNER_STATE_CONTENT);
        setDriver(this.fContentDriver);
        this.fEntityStore = this.fEntityManager.getEntityStore();
    }

    public void reset(PropertyManager propertyManager) {
        boolean z = true;
        boolean z2 = DEBUG_SKIP_ALGORITHM;
        super.reset(propertyManager);
        this.fNamespaces = DEBUG_SKIP_ALGORITHM;
        this.fNotifyBuiltInRefs = DEBUG_SKIP_ALGORITHM;
        this.fMarkupDepth = 0;
        this.fCurrentElement = null;
        this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
        this.fAdd = DEBUG_SKIP_ALGORITHM;
        this.fSkip = DEBUG_SKIP_ALGORITHM;
        this.fElementStack.clear();
        this.fHasExternalDTD = DEBUG_SKIP_ALGORITHM;
        this.fStandaloneSet = DEBUG_SKIP_ALGORITHM;
        this.fStandalone = DEBUG_SKIP_ALGORITHM;
        this.fReplaceEntityReferences = ((Boolean) propertyManager.getProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES)).booleanValue();
        this.fSupportExternalEntities = ((Boolean) propertyManager.getProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES)).booleanValue();
        Boolean cdata = (Boolean) propertyManager.getProperty("http://java.sun.com/xml/stream/properties/report-cdata-event");
        if (cdata != null) {
            this.fReportCdataEvent = cdata.booleanValue();
        }
        Boolean coalesce = (Boolean) propertyManager.getProperty(XMLInputFactory.IS_COALESCING);
        if (coalesce != null) {
            this.fIsCoalesce = coalesce.booleanValue();
        }
        if (!this.fIsCoalesce && this.fReportCdataEvent) {
            z2 = true;
        }
        this.fReportCdataEvent = z2;
        if (!this.fIsCoalesce) {
            z = this.fReplaceEntityReferences;
        }
        this.fReplaceEntityReferences = z;
        this.fEntityStore = this.fEntityManager.getEntityStore();
    }

    public String[] getRecognizedFeatures() {
        return (String[]) RECOGNIZED_FEATURES.clone();
    }

    public void setFeature(String featureId, boolean state) throws XMLConfigurationException {
        super.setFeature(featureId, state);
        if (featureId.startsWith(Constants.XERCES_FEATURE_PREFIX) && featureId.substring(Constants.XERCES_FEATURE_PREFIX.length()).equals(Constants.NOTIFY_BUILTIN_REFS_FEATURE)) {
            this.fNotifyBuiltInRefs = state;
        }
    }

    public String[] getRecognizedProperties() {
        return (String[]) RECOGNIZED_PROPERTIES.clone();
    }

    public void setProperty(String propertyId, Object value) throws XMLConfigurationException {
        super.setProperty(propertyId, value);
        if (propertyId.startsWith(Constants.XERCES_PROPERTY_PREFIX) && propertyId.substring(Constants.XERCES_PROPERTY_PREFIX.length()).equals(Constants.ENTITY_MANAGER_PROPERTY)) {
            this.fEntityManager = (XMLEntityManager) value;
        }
    }

    public Boolean getFeatureDefault(String featureId) {
        for (int i = 0; i < RECOGNIZED_FEATURES.length; i++) {
            if (RECOGNIZED_FEATURES[i].equals(featureId)) {
                return FEATURE_DEFAULTS[i];
            }
        }
        return null;
    }

    public Object getPropertyDefault(String propertyId) {
        for (int i = 0; i < RECOGNIZED_PROPERTIES.length; i++) {
            if (RECOGNIZED_PROPERTIES[i].equals(propertyId)) {
                return PROPERTY_DEFAULTS[i];
            }
        }
        return null;
    }

    public void setDocumentHandler(XMLDocumentHandler documentHandler) {
        this.fDocumentHandler = documentHandler;
    }

    public XMLDocumentHandler getDocumentHandler() {
        return this.fDocumentHandler;
    }

    public void startEntity(String name, XMLResourceIdentifier identifier, String encoding) throws XNIException {
        if (this.fEntityDepth == this.fEntityStack.length) {
            int[] entityarray = new int[(this.fEntityStack.length * 2)];
            System.arraycopy(this.fEntityStack, 0, entityarray, 0, this.fEntityStack.length);
            this.fEntityStack = entityarray;
        }
        this.fEntityStack[this.fEntityDepth] = this.fMarkupDepth;
        super.startEntity(name, identifier, encoding);
        if (this.fStandalone && this.fEntityStore.isEntityDeclInExternalSubset(name)) {
            reportFatalError("MSG_REFERENCE_TO_EXTERNALLY_DECLARED_ENTITY_WHEN_STANDALONE", new Object[]{name});
        }
        if (this.fDocumentHandler != null && !this.fScanningAttribute && !name.equals("[xml]")) {
            this.fDocumentHandler.startGeneralEntity(name, identifier, encoding, null);
        }
    }

    public void endEntity(String name) throws IOException, XNIException {
        super.endEntity(name);
        if (this.fMarkupDepth != this.fEntityStack[this.fEntityDepth]) {
            reportFatalError("MarkupEntityMismatch", null);
        }
        if (this.fDocumentHandler != null && !this.fScanningAttribute && !name.equals("[xml]")) {
            this.fDocumentHandler.endGeneralEntity(name, null);
        }
    }

    protected Driver createContentDriver() {
        return new FragmentContentDriver();
    }

    protected void scanXMLDeclOrTextDecl(boolean scanningTextDecl) throws IOException, XNIException {
        boolean z = true;
        super.scanXMLDeclOrTextDecl(scanningTextDecl, this.fStrings);
        this.fMarkupDepth--;
        String version = this.fStrings[0];
        String encoding = this.fStrings[1];
        String standalone = this.fStrings[2];
        this.fDeclaredEncoding = encoding;
        this.fStandaloneSet = standalone != null ? true : DEBUG_SKIP_ALGORITHM;
        if (!(this.fStandaloneSet && standalone.equals("yes"))) {
            z = DEBUG_SKIP_ALGORITHM;
        }
        this.fStandalone = z;
        this.fEntityManager.setStandalone(this.fStandalone);
        if (this.fDocumentHandler != null) {
            if (scanningTextDecl) {
                this.fDocumentHandler.textDecl(version, encoding, null);
            } else {
                this.fDocumentHandler.xmlDecl(version, encoding, standalone, null);
            }
        }
        if (version != null) {
            this.fEntityScanner.setVersion(version);
        }
        if (encoding != null) {
            this.fEntityScanner.setEncoding(encoding);
        }
    }

    public String getPITarget() {
        return this.fPITarget;
    }

    public XMLStringBuffer getPIData() {
        return this.fContentBuffer;
    }

    public XMLString getCharacterData() {
        if (this.fUsebuffer) {
            return this.fContentBuffer;
        }
        return this.fTempString;
    }

    protected void scanPIData(String target, XMLStringBuffer data) throws IOException, XNIException {
        super.scanPIData(target, data);
        this.fPITarget = target;
        this.fMarkupDepth--;
        if (this.fDocumentHandler != null) {
            this.fDocumentHandler.processingInstruction(target, data, null);
        }
    }

    protected void scanComment() throws IOException, XNIException {
        this.fContentBuffer.clear();
        scanComment(this.fContentBuffer);
        this.fUsebuffer = true;
        this.fMarkupDepth--;
        if (this.fDocumentHandler != null) {
            this.fDocumentHandler.comment(this.fContentBuffer, null);
        }
    }

    public String getComment() {
        return this.fContentBuffer.toString();
    }

    void addElement(String rawname) {
        if (this.fElementPointer < ELEMENT_ARRAY_LENGTH) {
            this.fElementArray[this.fElementPointer] = rawname;
            if (this.fElementStack.fDepth < 5) {
                short column = storePointerForADepth(this.fElementPointer);
                if (column > (short) 0) {
                    short pointer = getElementPointer((short) this.fElementStack.fDepth, (short) (column - 1));
                    if (rawname == this.fElementArray[pointer]) {
                        this.fShouldSkip = true;
                        this.fLastPointerLocation = pointer;
                        resetPointer((short) this.fElementStack.fDepth, column);
                        this.fElementArray[this.fElementPointer] = null;
                        return;
                    }
                    this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
                }
            }
            this.fElementPointer = (short) (this.fElementPointer + 1);
        }
    }

    void resetPointer(short depth, short column) {
        this.fPointerInfo[depth][column] = (short) 0;
    }

    short storePointerForADepth(short elementPointer) {
        short depth = (short) this.fElementStack.fDepth;
        for (short i = (short) 0; i < MAX_POINTER_AT_A_DEPTH; i = (short) (i + 1)) {
            if (canStore(depth, i)) {
                this.fPointerInfo[depth][i] = elementPointer;
                return i;
            }
        }
        return (short) -1;
    }

    boolean canStore(short depth, short column) {
        return this.fPointerInfo[depth][column] == (short) 0 ? true : DEBUG_SKIP_ALGORITHM;
    }

    short getElementPointer(short depth, short column) {
        return this.fPointerInfo[depth][column];
    }

    boolean skipFromTheBuffer(String rawname) throws IOException {
        if (!this.fEntityScanner.skipString(rawname)) {
            return DEBUG_SKIP_ALGORITHM;
        }
        char c = (char) this.fEntityScanner.peekChar();
        if (c != ' ' && c != '/' && c != XMLStreamWriterImpl.CLOSE_START_TAG) {
            return DEBUG_SKIP_ALGORITHM;
        }
        this.fElementRawname = rawname;
        return true;
    }

    boolean skipQElement(QName name) throws IOException {
        if (XMLChar.isName(this.fEntityScanner.getChar(name.characters.length))) {
            return DEBUG_SKIP_ALGORITHM;
        }
        return this.fEntityScanner.skipString(name.characters);
    }

    boolean skipQElement(String rawname) throws IOException {
        if (XMLChar.isName(this.fEntityScanner.getChar(rawname.length()))) {
            return DEBUG_SKIP_ALGORITHM;
        }
        return this.fEntityScanner.skipString(rawname);
    }

    protected boolean skipElement() throws IOException {
        if (!this.fShouldSkip) {
            return DEBUG_SKIP_ALGORITHM;
        }
        if (this.fLastPointerLocation != (short) 0) {
            String rawname = this.fElementArray[this.fLastPointerLocation + 1];
            if (rawname == null || !skipFromTheBuffer(rawname)) {
                this.fLastPointerLocation = (short) 0;
            } else {
                this.fLastPointerLocation = (short) (this.fLastPointerLocation + 1);
                return true;
            }
        }
        if (this.fShouldSkip && skipElement((short) 0)) {
            return true;
        }
        return DEBUG_SKIP_ALGORITHM;
    }

    boolean skipElement(short column) throws IOException {
        short depth = (short) this.fElementStack.fDepth;
        if (depth > MAX_DEPTH_LIMIT) {
            this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
            return DEBUG_SKIP_ALGORITHM;
        }
        short i = column;
        while (i < MAX_POINTER_AT_A_DEPTH) {
            short pointer = getElementPointer(depth, i);
            if (pointer == (short) 0) {
                this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
                return DEBUG_SKIP_ALGORITHM;
            } else if (this.fElementArray[pointer] == null || !skipFromTheBuffer(this.fElementArray[pointer])) {
                i = (short) (i + 1);
            } else {
                this.fLastPointerLocation = pointer;
                this.fShouldSkip = true;
                return true;
            }
        }
        this.fShouldSkip = DEBUG_SKIP_ALGORITHM;
        return DEBUG_SKIP_ALGORITHM;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean scanStartElement() throws java.io.IOException, com.amazonaws.javax.xml.stream.xerces.xni.XNIException {
        /*
        r10 = this;
        r6 = 0;
        r7 = 62;
        r9 = 1;
        r8 = 0;
        r5 = r10.fShouldSkip;
        if (r5 == 0) goto L_0x0019;
    L_0x0009:
        r5 = r10.fAdd;
        if (r5 != 0) goto L_0x0019;
    L_0x000d:
        r5 = r10.fElementStack2;
        r2 = r5.getNext();
        r5 = r10.skipQElement(r2);
        r10.fShouldSkip = r5;
    L_0x0019:
        r5 = r10.fAdd;
        if (r5 == 0) goto L_0x008f;
    L_0x001d:
        r5 = r10.fElementStack2;
        r5 = r5.nextElement();
        r10.fElementQName = r5;
    L_0x0025:
        r5 = r10.fElementQName;
        r10.fCurrentElement = r5;
        r5 = r10.fShouldSkip;
        if (r5 == 0) goto L_0x0031;
    L_0x002d:
        r5 = r10.fAdd;
        if (r5 == 0) goto L_0x003c;
    L_0x0031:
        r5 = r10.fNamespaces;
        if (r5 == 0) goto L_0x0098;
    L_0x0035:
        r5 = r10.fEntityScanner;
        r6 = r10.fElementQName;
        r5.scanQName(r6);
    L_0x003c:
        r5 = r10.fAdd;
        if (r5 == 0) goto L_0x0047;
    L_0x0040:
        r5 = r10.fElementStack2;
        r6 = r10.fElementQName;
        r5.matchElement(r6);
    L_0x0047:
        r5 = r10.fElementQName;
        r3 = r5.rawname;
        r1 = 0;
        r5 = r10.fAttributes;
        r5.removeAllAttributes();
    L_0x0051:
        r5 = r10.fEntityScanner;
        r4 = r5.skipSpaces();
        r5 = r10.fEntityScanner;
        r0 = r5.peekChar();
        if (r0 != r7) goto L_0x00ac;
    L_0x005f:
        r5 = r10.fEntityScanner;
        r5.scanChar();
    L_0x0064:
        if (r1 == 0) goto L_0x00e0;
    L_0x0066:
        r5 = r10.fMarkupDepth;
        r5 = r5 + -1;
        r10.fMarkupDepth = r5;
        r5 = r10.fMarkupDepth;
        r6 = r10.fEntityStack;
        r7 = r10.fEntityDepth;
        r7 = r7 + -1;
        r6 = r6[r7];
        if (r5 >= r6) goto L_0x0085;
    L_0x0078:
        r5 = "ElementEntityMismatch";
        r6 = new java.lang.Object[r9];
        r7 = r10.fCurrentElement;
        r7 = r7.rawname;
        r6[r8] = r7;
        r10.reportFatalError(r5, r6);
    L_0x0085:
        r5 = r10.fDocumentHandler;
        if (r5 == 0) goto L_0x0089;
    L_0x0089:
        r5 = r10.fElementStack;
        r5.popElement();
    L_0x008e:
        return r1;
    L_0x008f:
        r5 = r10.fElementStack;
        r5 = r5.nextElement();
        r10.fElementQName = r5;
        goto L_0x0025;
    L_0x0098:
        r5 = r10.fEntityScanner;
        r2 = r5.scanName();
        r5 = r10.fElementQName;
        r5.setValues(r6, r2, r2, r6);
        r5 = r10.fElementQName;
        r6 = r10.fEntityScanner;
        r6 = r6.scannedName;
        r5.characters = r6;
        goto L_0x003c;
    L_0x00ac:
        r5 = 47;
        if (r0 != r5) goto L_0x00c8;
    L_0x00b0:
        r5 = r10.fEntityScanner;
        r5.scanChar();
        r5 = r10.fEntityScanner;
        r5 = r5.skipChar(r7);
        if (r5 != 0) goto L_0x00c6;
    L_0x00bd:
        r5 = "ElementUnterminated";
        r6 = new java.lang.Object[r9];
        r6[r8] = r3;
        r10.reportFatalError(r5, r6);
    L_0x00c6:
        r1 = 1;
        goto L_0x0064;
    L_0x00c8:
        r5 = com.amazonaws.javax.xml.stream.XMLScanner.isValidNameStartChar(r0);
        if (r5 == 0) goto L_0x00d0;
    L_0x00ce:
        if (r4 != 0) goto L_0x00d9;
    L_0x00d0:
        r5 = "ElementUnterminated";
        r6 = new java.lang.Object[r9];
        r6[r8] = r3;
        r10.reportFatalError(r5, r6);
    L_0x00d9:
        r5 = r10.fAttributes;
        r10.scanAttribute(r5);
        goto L_0x0051;
    L_0x00e0:
        r5 = r10.fDocumentHandler;
        if (r5 == 0) goto L_0x008e;
    L_0x00e4:
        goto L_0x008e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.XMLDocumentFragmentScannerImpl.scanStartElement():boolean");
    }

    public boolean hasAttributes() {
        return this.fAttributes.getLength() > 0 ? true : DEBUG_SKIP_ALGORITHM;
    }

    public XMLAttributesIteratorImpl getAttributeIterator() {
        if (this.dtdGrammarUtil != null && this.fAddDefaultAttr) {
            this.dtdGrammarUtil.addDTDDefaultAttrs(this.fElementQName, this.fAttributes);
            this.fAddDefaultAttr = DEBUG_SKIP_ALGORITHM;
        }
        return this.fAttributes;
    }

    public boolean standaloneSet() {
        return this.fStandaloneSet;
    }

    public boolean isStandAlone() {
        return this.fStandalone;
    }

    protected void scanAttribute(XMLAttributes attributes) throws IOException, XNIException {
        boolean isVC = DEBUG_SKIP_ALGORITHM;
        if (this.fNamespaces) {
            this.fEntityScanner.scanQName(this.fAttributeQName);
        } else {
            String name = this.fEntityScanner.scanName();
            this.fAttributeQName.setValues(null, name, name, null);
        }
        this.fEntityScanner.skipSpaces();
        if (!this.fEntityScanner.skipChar(61)) {
            reportFatalError("EqRequiredInAttribute", new Object[]{this.fAttributeQName.rawname});
        }
        this.fEntityScanner.skipSpaces();
        int oldLen = attributes.getLength();
        attributes.addAttribute(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
        if (oldLen == attributes.getLength()) {
            reportFatalError("AttributeNotUnique", new Object[]{this.fCurrentElement.rawname, this.fAttributeQName.rawname});
        }
        if (this.fHasExternalDTD && !this.fStandalone) {
            isVC = true;
        }
        scanAttributeValue(this.fTempString, this.fTempString2, this.fAttributeQName.rawname, attributes, oldLen, isVC);
        attributes.setValue(oldLen, this.fTempString.toString());
        attributes.setSpecified(oldLen, true);
    }

    protected int scanContent(XMLStringBuffer content) throws IOException, XNIException {
        this.fTempString.length = 0;
        int c = this.fEntityScanner.scanContent(this.fTempString);
        content.append(this.fTempString);
        this.fTempString.length = 0;
        if (c == 13) {
            this.fEntityScanner.scanChar();
            content.append((char) c);
            c = -1;
        } else if (c == 93) {
            content.append((char) this.fEntityScanner.scanChar());
            this.fInScanContent = true;
            if (this.fEntityScanner.skipChar(93)) {
                content.append(']');
                while (this.fEntityScanner.skipChar(93)) {
                    content.append(']');
                }
                if (this.fEntityScanner.skipChar(62)) {
                    reportFatalError("CDEndInContent", null);
                }
            }
            this.fInScanContent = DEBUG_SKIP_ALGORITHM;
            c = -1;
        }
        if (this.fDocumentHandler != null && content.length > 0) {
            this.fDocumentHandler.characters(content, null);
        }
        return c;
    }

    protected boolean scanCDATASection(XMLStringBuffer contentBuffer, boolean complete) throws IOException, XNIException {
        if (this.fDocumentHandler != null) {
            this.fDocumentHandler.startCDATA(null);
        }
        if (this.fEntityScanner.scanData(XMLStreamWriterImpl.END_CDATA, contentBuffer)) {
            int c = this.fEntityScanner.peekChar();
            if (c != -1 && XMLScanner.isInvalidLiteral(c)) {
                if (XMLChar.isHighSurrogate(c)) {
                    scanSurrogates(contentBuffer);
                } else {
                    reportFatalError("InvalidCharInCDSect", new Object[]{Integer.toString(c, 16)});
                    this.fEntityScanner.scanChar();
                }
            }
            if (this.fDocumentHandler != null) {
                this.fDocumentHandler.characters(contentBuffer, null);
            }
        }
        this.fMarkupDepth--;
        if (this.fDocumentHandler != null && contentBuffer.length > 0) {
            this.fDocumentHandler.characters(contentBuffer, null);
        }
        if (this.fDocumentHandler != null) {
            this.fDocumentHandler.endCDATA(null);
        }
        return true;
    }

    protected int scanEndElement() throws IOException, XNIException {
        if (!this.fEntityScanner.skipString(this.fElementStack.popElement().rawname)) {
            reportFatalError("ETagRequired", new Object[]{this.fElementStack.popElement().rawname});
        }
        this.fEntityScanner.skipSpaces();
        if (!this.fEntityScanner.skipChar(62)) {
            reportFatalError("ETagUnterminated", new Object[]{rawname});
        }
        this.fMarkupDepth--;
        this.fMarkupDepth--;
        if (this.fMarkupDepth < this.fEntityStack[this.fEntityDepth - 1]) {
            reportFatalError("ElementEntityMismatch", new Object[]{rawname});
        }
        if (this.fDocumentHandler != null) {
        }
        return this.fMarkupDepth;
    }

    protected void scanCharReference() throws IOException, XNIException {
        this.fStringBuffer2.clear();
        int ch = scanCharReferenceValue(this.fStringBuffer2, null);
        this.fMarkupDepth--;
        if (ch != -1 && this.fDocumentHandler != null) {
            if (this.fNotifyCharRefs) {
                this.fDocumentHandler.startGeneralEntity(this.fCharRefLiteral, null, null, null);
            }
            this.fDocumentHandler.characters(this.fStringBuffer2, null);
            if (this.fNotifyCharRefs) {
                this.fDocumentHandler.endGeneralEntity(this.fCharRefLiteral, null);
            }
        }
    }

    protected void scanEntityReference(XMLStringBuffer content) throws IOException, XNIException {
        String name = this.fEntityScanner.scanName();
        if (name == null) {
            reportFatalError("NameRequiredInReference", null);
        }
        if (!this.fEntityScanner.skipChar(59)) {
            reportFatalError("SemicolonRequiredInReference", new Object[]{name});
        }
        if (this.fEntityStore.isUnparsedEntity(name)) {
            reportFatalError("ReferenceToUnparsedEntity", new Object[]{name});
        }
        this.fMarkupDepth--;
        this.fCurrentEntityName = name;
        if (name == fAmpSymbol) {
            handleCharacter('&', fAmpSymbol, content);
            this.fScannerState = SCANNER_STATE_BUILT_IN_REFS;
        } else if (name == fLtSymbol) {
            handleCharacter(XMLStreamWriterImpl.OPEN_START_TAG, fLtSymbol, content);
            this.fScannerState = SCANNER_STATE_BUILT_IN_REFS;
        } else if (name == fGtSymbol) {
            handleCharacter(XMLStreamWriterImpl.CLOSE_START_TAG, fGtSymbol, content);
            this.fScannerState = SCANNER_STATE_BUILT_IN_REFS;
        } else if (name == fQuotSymbol) {
            handleCharacter('\"', fQuotSymbol, content);
            this.fScannerState = SCANNER_STATE_BUILT_IN_REFS;
        } else if (name == fAposSymbol) {
            handleCharacter('\'', fAposSymbol, content);
            this.fScannerState = SCANNER_STATE_BUILT_IN_REFS;
        } else if ((!this.fEntityStore.isExternalEntity(name) || this.fSupportExternalEntities) && (this.fEntityStore.isExternalEntity(name) || this.fReplaceEntityReferences)) {
            if (!this.fEntityStore.isDeclaredEntity(name)) {
                if (this.fDisallowDoctype && this.fReplaceEntityReferences) {
                    reportFatalError("EntityNotDeclared", new Object[]{name});
                    return;
                } else if (!this.fHasExternalDTD || this.fStandalone) {
                    reportFatalError("EntityNotDeclared", new Object[]{name});
                } else if (this.fValidation) {
                    this.fErrorReporter.reportError(this.fEntityScanner, XMLMessageFormatter.XML_DOMAIN, "EntityNotDeclared", new Object[]{name}, (short) 1);
                }
            }
            this.fEntityManager.startEntity(name, DEBUG_SKIP_ALGORITHM);
        } else {
            this.fScannerState = SCANNER_STATE_REFERENCE;
        }
    }

    private void handleCharacter(char c, String entity, XMLStringBuffer content) throws XNIException {
        this.foundBuiltInRefs = true;
        content.append(c);
        if (this.fDocumentHandler != null) {
            this.fSingleChar[0] = c;
            if (this.fNotifyBuiltInRefs) {
                this.fDocumentHandler.startGeneralEntity(entity, null, null, null);
            }
            this.fTempString.setValues(this.fSingleChar, 0, 1);
            this.fDocumentHandler.characters(this.fTempString, null);
            if (this.fNotifyBuiltInRefs) {
                this.fDocumentHandler.endGeneralEntity(entity, null);
            }
        }
    }

    protected final void setScannerState(int state) {
        this.fScannerState = state;
    }

    protected final void setDriver(Driver driver) {
        this.fDriver = driver;
    }

    protected String getScannerStateName(int state) {
        switch (state) {
            case SCANNER_STATE_START_OF_MARKUP /*21*/:
                return "SCANNER_STATE_START_OF_MARKUP";
            case SCANNER_STATE_CONTENT /*22*/:
                return "SCANNER_STATE_CONTENT";
            case SCANNER_STATE_PI /*23*/:
                return "SCANNER_STATE_PI";
            case SCANNER_STATE_DOCTYPE /*24*/:
                return "SCANNER_STATE_DOCTYPE";
            case SCANNER_STATE_ROOT_ELEMENT /*26*/:
                return "SCANNER_STATE_ROOT_ELEMENT";
            case SCANNER_STATE_COMMENT /*27*/:
                return "SCANNER_STATE_COMMENT";
            case SCANNER_STATE_REFERENCE /*28*/:
                return "SCANNER_STATE_REFERENCE";
            case SCANNER_STATE_ATTRIBUTE /*29*/:
                return "SCANNER_STATE_ATTRIBUTE";
            case SCANNER_STATE_ATTRIBUTE_VALUE /*30*/:
                return "SCANNER_STATE_ATTRIBUTE_VALUE";
            case SCANNER_STATE_END_OF_INPUT /*33*/:
                return "SCANNER_STATE_END_OF_INPUT";
            case SCANNER_STATE_TERMINATED /*34*/:
                return "SCANNER_STATE_TERMINATED";
            case SCANNER_STATE_CDATA /*35*/:
                return "SCANNER_STATE_CDATA";
            case SCANNER_STATE_TEXT_DECL /*36*/:
                return "SCANNER_STATE_TEXT_DECL";
            case SCANNER_STATE_CHARACTER_DATA /*37*/:
                return "SCANNER_STATE_CHARACTER_DATA";
            case SCANNER_STATE_START_ELEMENT_TAG /*38*/:
                return "SCANNER_STATE_START_ELEMENT_TAG";
            case SCANNER_STATE_END_ELEMENT_TAG /*39*/:
                return "SCANNER_STATE_END_ELEMENT_TAG";
            default:
                return new StringBuffer().append("??? (").append(state).append(')').toString();
        }
    }

    public String getEntityName() {
        return this.fCurrentEntityName;
    }

    public String getDriverName(Driver driver) {
        return Constants.NULL_VERSION_ID;
    }

    static void pr(String str) {
        System.out.println(str);
    }
}
