package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.Entity.ScannedEntity;
import com.amazonaws.javax.xml.stream.xerces.impl.io.ASCIIReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UTF8Reader;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.EncodingMap;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Locale;
import java.util.Vector;

public class XMLEntityReaderImpl extends XMLEntityReader {
    protected static final String ALLOW_JAVA_ENCODINGS = "http://apache.org/xml/features/allow-java-encodings";
    private static final boolean DEBUG_BUFFER = false;
    private static final boolean DEBUG_ENCODINGS = false;
    private static final boolean DEBUG_SKIP_STRING = false;
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    public static final boolean[] validContent;
    public static final boolean[] validNames;
    protected boolean fAllowJavaEncodings;
    protected ScannedEntity fCurrentEntity;
    protected XMLEntityManager fEntityManager;
    protected XMLErrorReporter fErrorReporter;
    protected PropertyManager fPropertyManager;
    protected SymbolTable fSymbolTable;
    boolean isExternal;
    private Vector listeners;
    char[] scannedName;
    boolean whiteSpaceInfoNeeded;
    int whiteSpaceLen;
    int[] whiteSpaceLookup;

    static {
        int i;
        validContent = new boolean[Ascii.MAX];
        validNames = new boolean[Ascii.MAX];
        for (char i2 = ' '; i2 < '\u007f'; i2 = (char) (i2 + 1)) {
            validContent[i2] = true;
        }
        validContent[9] = true;
        validContent[38] = DEBUG_SKIP_STRING;
        validContent[60] = DEBUG_SKIP_STRING;
        validContent[93] = DEBUG_SKIP_STRING;
        for (i = 65; i <= 90; i++) {
            validNames[i] = true;
        }
        for (i = 97; i <= 122; i++) {
            validNames[i] = true;
        }
        for (i = 48; i <= 57; i++) {
            validNames[i] = true;
        }
        validNames[45] = true;
        validNames[46] = true;
        validNames[58] = true;
        validNames[95] = true;
    }

    public XMLEntityReaderImpl(XMLEntityManager entityManager) {
        this.fCurrentEntity = null;
        this.listeners = new Vector();
        this.fSymbolTable = null;
        this.fErrorReporter = null;
        this.whiteSpaceLookup = new int[100];
        this.whiteSpaceLen = 0;
        this.whiteSpaceInfoNeeded = true;
        this.scannedName = null;
        this.fPropertyManager = null;
        this.isExternal = DEBUG_SKIP_STRING;
        this.fEntityManager = entityManager;
    }

    public XMLEntityReaderImpl(PropertyManager propertyManager, XMLEntityManager entityManager) {
        this.fCurrentEntity = null;
        this.listeners = new Vector();
        this.fSymbolTable = null;
        this.fErrorReporter = null;
        this.whiteSpaceLookup = new int[100];
        this.whiteSpaceLen = 0;
        this.whiteSpaceInfoNeeded = true;
        this.scannedName = null;
        this.fPropertyManager = null;
        this.isExternal = DEBUG_SKIP_STRING;
        this.fEntityManager = entityManager;
        reset(propertyManager);
    }

    public void reset(PropertyManager propertyManager) {
        this.fSymbolTable = (SymbolTable) propertyManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) propertyManager.getProperty(ERROR_REPORTER);
        this.fCurrentEntity = null;
        this.whiteSpaceLen = 0;
        this.whiteSpaceInfoNeeded = true;
        this.scannedName = null;
        this.listeners.clear();
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        try {
            this.fAllowJavaEncodings = componentManager.getFeature(ALLOW_JAVA_ENCODINGS);
        } catch (XMLConfigurationException e) {
            this.fAllowJavaEncodings = DEBUG_SKIP_STRING;
        }
        this.fSymbolTable = (SymbolTable) componentManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) componentManager.getProperty(ERROR_REPORTER);
    }

    public void setCurrentEntity(ScannedEntity scannedEntity) {
        this.fCurrentEntity = scannedEntity;
        if (this.fCurrentEntity != null) {
            this.isExternal = this.fCurrentEntity.isExternal();
        }
    }

    public ScannedEntity getCurrentEntity() {
        return this.fCurrentEntity;
    }

    public String getBaseSystemId() {
        return (this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null) ? null : this.fCurrentEntity.entityLocation.getExpandedSystemId();
    }

    public int getLineNumber() {
        return this.fCurrentEntity != null ? this.fCurrentEntity.lineNumber : -1;
    }

    public int getColumnNumber() {
        return this.fCurrentEntity != null ? this.fCurrentEntity.columnNumber : -1;
    }

    public int getCharacterOffset() {
        return this.fCurrentEntity != null ? this.fCurrentEntity.fTotalCountTillLastLoad + this.fCurrentEntity.position : -1;
    }

    public String getExpandedSystemId() {
        return (this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null) ? null : this.fCurrentEntity.entityLocation.getExpandedSystemId();
    }

    public String getLiteralSystemId() {
        return (this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null) ? null : this.fCurrentEntity.entityLocation.getLiteralSystemId();
    }

    public String getPublicId() {
        return (this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null) ? null : this.fCurrentEntity.entityLocation.getPublicId();
    }

    public void setVersion(String version) {
        this.fCurrentEntity.version = version;
    }

    public String getVersion() {
        return this.fCurrentEntity.version;
    }

    public String getEncoding() {
        return this.fCurrentEntity.encoding;
    }

    public void setEncoding(String encoding) throws IOException {
        if (this.fCurrentEntity.stream == null) {
            return;
        }
        if (this.fCurrentEntity.encoding == null || !this.fCurrentEntity.encoding.equals(encoding)) {
            if (this.fCurrentEntity.encoding != null && this.fCurrentEntity.encoding.startsWith("UTF-16")) {
                String ENCODING = encoding.toUpperCase(Locale.ENGLISH);
                if (!ENCODING.equals("UTF-16")) {
                    if (ENCODING.equals("ISO-10646-UCS-4")) {
                        if (this.fCurrentEntity.encoding.equals("UTF-16BE")) {
                            this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short) 8);
                            return;
                        }
                        this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short) 4);
                        return;
                    } else if (ENCODING.equals("ISO-10646-UCS-2")) {
                        if (this.fCurrentEntity.encoding.equals("UTF-16BE")) {
                            this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short) 2);
                            return;
                        }
                        this.fCurrentEntity.reader = new UCSReader(this.fCurrentEntity.stream, (short) 1);
                        return;
                    }
                }
                return;
            }
            this.fCurrentEntity.reader = createReader(this.fCurrentEntity.stream, encoding, null);
            this.fCurrentEntity.encoding = encoding;
        }
    }

    public boolean isExternal() {
        return this.fCurrentEntity.isExternal();
    }

    public int getChar(int relative) throws IOException {
        if (arrangeCapacity(relative + 1, DEBUG_SKIP_STRING)) {
            return this.fCurrentEntity.ch[this.fCurrentEntity.position + relative];
        }
        return -1;
    }

    public int peekChar() throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        int c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        if (this.isExternal && c == 13) {
            return 10;
        }
        return c;
    }

    public int scanChar() throws IOException {
        ScannedEntity scannedEntity;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        char[] cArr = this.fCurrentEntity.ch;
        ScannedEntity scannedEntity2 = this.fCurrentEntity;
        int i = scannedEntity2.position;
        scannedEntity2.position = i + 1;
        int c = cArr[i];
        if (c == 10 || (c == 13 && this.isExternal)) {
            scannedEntity = this.fCurrentEntity;
            scannedEntity.lineNumber++;
            this.fCurrentEntity.columnNumber = 1;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                invokeListeners(1);
                this.fCurrentEntity.ch[0] = (char) c;
                load(1, DEBUG_SKIP_STRING);
            }
            if (c == 13 && this.isExternal) {
                cArr = this.fCurrentEntity.ch;
                scannedEntity2 = this.fCurrentEntity;
                i = scannedEntity2.position;
                scannedEntity2.position = i + 1;
                if (cArr[i] != '\n') {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.position--;
                }
                c = 10;
            }
        }
        scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber++;
        return c;
    }

    public String scanNmtoken() throws IOException {
        ScannedEntity scannedEntity;
        int length;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        int offset = this.fCurrentEntity.position;
        while (true) {
            boolean vc;
            char c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
            if (c < '\u007f') {
                vc = validNames[c];
            } else {
                vc = XMLChar.isName(c);
            }
            if (!vc) {
                break;
            }
            scannedEntity = this.fCurrentEntity;
            int i = scannedEntity.position + 1;
            scannedEntity.position = i;
            if (i == this.fCurrentEntity.count) {
                length = this.fCurrentEntity.position - offset;
                invokeListeners(length);
                if (length == this.fCurrentEntity.fBufferSize) {
                    char[] tmp = new char[(this.fCurrentEntity.fBufferSize * 2)];
                    System.arraycopy(this.fCurrentEntity.ch, offset, tmp, 0, length);
                    this.fCurrentEntity.ch = tmp;
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.fBufferSize *= 2;
                } else {
                    System.arraycopy(this.fCurrentEntity.ch, offset, this.fCurrentEntity.ch, 0, length);
                }
                offset = 0;
                if (load(length, DEBUG_SKIP_STRING)) {
                    break;
                }
            }
        }
        length = this.fCurrentEntity.position - offset;
        scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber += length;
        if (length > 0) {
            return this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, offset, length);
        }
        return null;
    }

    public String scanName() throws IOException {
        ScannedEntity scannedEntity;
        int length;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        int offset = this.fCurrentEntity.position;
        if (XMLChar.isNameStart(this.fCurrentEntity.ch[offset])) {
            scannedEntity = this.fCurrentEntity;
            int i = scannedEntity.position + 1;
            scannedEntity.position = i;
            if (i == this.fCurrentEntity.count) {
                invokeListeners(1);
                this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[offset];
                offset = 0;
                if (load(1, DEBUG_SKIP_STRING)) {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.columnNumber++;
                    String symbol = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
                    this.scannedName = this.fSymbolTable.getCharArray();
                    return symbol;
                }
            }
            while (true) {
                boolean vc;
                char c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
                if (c < '\u007f') {
                    vc = validNames[c];
                } else {
                    vc = XMLChar.isName(c);
                }
                if (!vc) {
                    break;
                }
                scannedEntity = this.fCurrentEntity;
                i = scannedEntity.position + 1;
                scannedEntity.position = i;
                if (i == this.fCurrentEntity.count) {
                    length = this.fCurrentEntity.position - offset;
                    invokeListeners(length);
                    if (length == this.fCurrentEntity.fBufferSize) {
                        char[] tmp = new char[(this.fCurrentEntity.fBufferSize * 2)];
                        System.arraycopy(this.fCurrentEntity.ch, offset, tmp, 0, length);
                        this.fCurrentEntity.ch = tmp;
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.fBufferSize *= 2;
                    } else {
                        System.arraycopy(this.fCurrentEntity.ch, offset, this.fCurrentEntity.ch, 0, length);
                    }
                    offset = 0;
                    if (load(length, DEBUG_SKIP_STRING)) {
                        break;
                    }
                }
            }
        }
        length = this.fCurrentEntity.position - offset;
        scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber += length;
        if (length <= 0) {
            return null;
        }
        symbol = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, offset, length);
        this.scannedName = this.fSymbolTable.getCharArray();
        return symbol;
    }

    public boolean scanQName(QName qname) throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        int offset = this.fCurrentEntity.position;
        if (XMLChar.isNameStart(this.fCurrentEntity.ch[offset])) {
            int length;
            ScannedEntity scannedEntity = this.fCurrentEntity;
            int i = scannedEntity.position + 1;
            scannedEntity.position = i;
            if (i == this.fCurrentEntity.count) {
                invokeListeners(1);
                this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[offset];
                offset = 0;
                if (load(1, DEBUG_SKIP_STRING)) {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.columnNumber++;
                    String name = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, 0, 1);
                    qname.setValues(null, name, name, null);
                    qname.characters = this.fSymbolTable.getCharArray();
                    return true;
                }
            }
            int index = -1;
            while (true) {
                boolean vc;
                char c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
                if (c < '\u007f') {
                    vc = validNames[c];
                } else {
                    vc = XMLChar.isName(c);
                }
                if (!vc) {
                    break;
                }
                if (c == ':') {
                    if (index != -1) {
                        break;
                    }
                    index = this.fCurrentEntity.position;
                }
                scannedEntity = this.fCurrentEntity;
                i = scannedEntity.position + 1;
                scannedEntity.position = i;
                if (i == this.fCurrentEntity.count) {
                    length = this.fCurrentEntity.position - offset;
                    invokeListeners(length);
                    if (length == this.fCurrentEntity.fBufferSize) {
                        char[] tmp = new char[(this.fCurrentEntity.fBufferSize * 2)];
                        System.arraycopy(this.fCurrentEntity.ch, offset, tmp, 0, length);
                        this.fCurrentEntity.ch = tmp;
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.fBufferSize *= 2;
                    } else {
                        System.arraycopy(this.fCurrentEntity.ch, offset, this.fCurrentEntity.ch, 0, length);
                    }
                    if (index != -1) {
                        index -= offset;
                    }
                    offset = 0;
                    if (load(length, DEBUG_SKIP_STRING)) {
                        break;
                    }
                }
            }
            length = this.fCurrentEntity.position - offset;
            scannedEntity = this.fCurrentEntity;
            scannedEntity.columnNumber += length;
            if (length > 0) {
                String localpart;
                String prefix = null;
                String rawname = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, offset, length);
                qname.characters = this.fSymbolTable.getCharArray();
                if (index != -1) {
                    int prefixLength = index - offset;
                    prefix = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, offset, prefixLength);
                    localpart = this.fSymbolTable.addSymbol(this.fCurrentEntity.ch, index + 1, (length - prefixLength) - 1);
                } else {
                    localpart = rawname;
                }
                qname.setValues(prefix, localpart, rawname, null);
                return true;
            }
        }
        return DEBUG_SKIP_STRING;
    }

    public int scanContent(XMLString content) throws IOException {
        ScannedEntity scannedEntity;
        int length;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        } else if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
            invokeListeners(0);
            this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[this.fCurrentEntity.count - 1];
            load(1, DEBUG_SKIP_STRING);
            this.fCurrentEntity.position = 0;
        }
        int offset = this.fCurrentEntity.position;
        int c = this.fCurrentEntity.ch[offset];
        int newlines = 0;
        if (c == 10 || (c == 13 && this.isExternal)) {
            do {
                char[] cArr = this.fCurrentEntity.ch;
                ScannedEntity scannedEntity2 = this.fCurrentEntity;
                int i = scannedEntity2.position;
                scannedEntity2.position = i + 1;
                c = cArr[i];
                if (c != 13 || !this.isExternal) {
                    if (c != 10) {
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.position--;
                        break;
                    }
                    newlines++;
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.lineNumber++;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                        offset = 0;
                        invokeListeners(newlines);
                        this.fCurrentEntity.position = newlines;
                        if (load(newlines, DEBUG_SKIP_STRING)) {
                            break;
                        }
                    }
                }
                newlines++;
                scannedEntity = this.fCurrentEntity;
                scannedEntity.lineNumber++;
                this.fCurrentEntity.columnNumber = 1;
                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                    offset = 0;
                    invokeListeners(newlines);
                    this.fCurrentEntity.position = newlines;
                    if (load(newlines, DEBUG_SKIP_STRING)) {
                        break;
                    }
                }
                if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n') {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.position++;
                    offset++;
                } else {
                    newlines++;
                }
            } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
            for (int i2 = offset; i2 < this.fCurrentEntity.position; i2++) {
                this.fCurrentEntity.ch[i2] = '\n';
            }
            length = this.fCurrentEntity.position - offset;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                content.setValues(this.fCurrentEntity.ch, offset, length);
                return -1;
            }
        }
        while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
            boolean vc;
            cArr = this.fCurrentEntity.ch;
            scannedEntity2 = this.fCurrentEntity;
            i = scannedEntity2.position;
            scannedEntity2.position = i + 1;
            c = cArr[i];
            if (c < Ascii.MAX) {
                vc = validContent[c];
                continue;
            } else {
                vc = XMLChar.isContent(c);
                continue;
            }
            if (!vc) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.position--;
                break;
            }
        }
        length = this.fCurrentEntity.position - offset;
        scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber += length - newlines;
        content.setValues(this.fCurrentEntity.ch, offset, length);
        if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
            c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
            if (c == 13 && this.isExternal) {
                c = 10;
            }
        } else {
            c = -1;
        }
        return c;
    }

    public int scanLiteral(int quote, XMLString content) throws IOException {
        ScannedEntity scannedEntity;
        int length;
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        } else if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
            invokeListeners(0);
            this.fCurrentEntity.ch[0] = this.fCurrentEntity.ch[this.fCurrentEntity.count - 1];
            load(1, DEBUG_SKIP_STRING);
            this.fCurrentEntity.position = 0;
        }
        int offset = this.fCurrentEntity.position;
        int c = this.fCurrentEntity.ch[offset];
        int newlines = 0;
        if (this.whiteSpaceInfoNeeded) {
            this.whiteSpaceLen = 0;
        }
        if (c == 10 || (c == 13 && this.isExternal)) {
            do {
                char[] cArr = this.fCurrentEntity.ch;
                ScannedEntity scannedEntity2 = this.fCurrentEntity;
                int i = scannedEntity2.position;
                scannedEntity2.position = i + 1;
                c = cArr[i];
                if (c != 13 || !this.isExternal) {
                    if (c != 10) {
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.position--;
                        break;
                    }
                    newlines++;
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.lineNumber++;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                        offset = 0;
                        invokeListeners(newlines);
                        this.fCurrentEntity.position = newlines;
                        if (load(newlines, DEBUG_SKIP_STRING)) {
                            break;
                        }
                    }
                }
                newlines++;
                scannedEntity = this.fCurrentEntity;
                scannedEntity.lineNumber++;
                this.fCurrentEntity.columnNumber = 1;
                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                    invokeListeners(newlines);
                    offset = 0;
                    this.fCurrentEntity.position = newlines;
                    if (load(newlines, DEBUG_SKIP_STRING)) {
                        break;
                    }
                }
                if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n') {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.position++;
                    offset++;
                } else {
                    newlines++;
                }
            } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
            for (int i2 = offset; i2 < this.fCurrentEntity.position; i2++) {
                this.fCurrentEntity.ch[i2] = '\n';
                int[] iArr = this.whiteSpaceLookup;
                int i3 = this.whiteSpaceLen;
                this.whiteSpaceLen = i3 + 1;
                iArr[i3] = i2;
            }
            length = this.fCurrentEntity.position - offset;
            if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                content.setValues(this.fCurrentEntity.ch, offset, length);
                return -1;
            }
        }
        while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
            cArr = this.fCurrentEntity.ch;
            scannedEntity2 = this.fCurrentEntity;
            i = scannedEntity2.position;
            scannedEntity2.position = i + 1;
            c = cArr[i];
            if ((c == quote && (!this.fCurrentEntity.literal || this.isExternal)) || c == 37) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.position--;
                break;
            }
            boolean vc;
            if (c < Ascii.MAX) {
                vc = validContent[c];
            } else {
                vc = XMLChar.isContent(c);
            }
            if (!vc) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.position--;
                break;
            } else if (this.whiteSpaceInfoNeeded && (c == 32 || c == 9)) {
                if (this.whiteSpaceLen < this.whiteSpaceLookup.length) {
                    iArr = this.whiteSpaceLookup;
                    i3 = this.whiteSpaceLen;
                    this.whiteSpaceLen = i3 + 1;
                    iArr[i3] = this.fCurrentEntity.position - 1;
                } else {
                    int[] tmp = new int[(this.whiteSpaceLookup.length + 20)];
                    System.arraycopy(this.whiteSpaceLookup, 0, tmp, 0, this.whiteSpaceLookup.length);
                    this.whiteSpaceLookup = tmp;
                    iArr = this.whiteSpaceLookup;
                    i3 = this.whiteSpaceLen;
                    this.whiteSpaceLen = i3 + 1;
                    iArr[i3] = this.fCurrentEntity.position - 1;
                }
            }
        }
        length = this.fCurrentEntity.position - offset;
        scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber += length - newlines;
        content.setValues(this.fCurrentEntity.ch, offset, length);
        if (this.fCurrentEntity.position != this.fCurrentEntity.count) {
            c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
            if (c == quote && this.fCurrentEntity.literal) {
                c = -1;
            }
        } else {
            c = -1;
        }
        return c;
    }

    public boolean scanData(String delimiter, XMLStringBuffer buffer) throws IOException {
        boolean done = DEBUG_SKIP_STRING;
        int delimLen = delimiter.length();
        char charAt0 = delimiter.charAt(0);
        do {
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                invokeListeners(0);
                load(0, true);
            } else if (this.fCurrentEntity.position >= this.fCurrentEntity.count - delimLen) {
                invokeListeners(this.fCurrentEntity.count - this.fCurrentEntity.position);
                System.arraycopy(this.fCurrentEntity.ch, this.fCurrentEntity.position, this.fCurrentEntity.ch, 0, this.fCurrentEntity.count - this.fCurrentEntity.position);
                load(this.fCurrentEntity.count - this.fCurrentEntity.position, DEBUG_SKIP_STRING);
                this.fCurrentEntity.position = 0;
            }
            if (this.fCurrentEntity.position >= this.fCurrentEntity.count - delimLen) {
                invokeListeners(0);
                XMLStringBuffer xMLStringBuffer = buffer;
                xMLStringBuffer.append(this.fCurrentEntity.ch, this.fCurrentEntity.position, this.fCurrentEntity.count - this.fCurrentEntity.position);
                ScannedEntity scannedEntity = this.fCurrentEntity;
                scannedEntity.columnNumber += this.fCurrentEntity.count;
                this.fCurrentEntity.position = this.fCurrentEntity.count;
                load(0, true);
                return DEBUG_SKIP_STRING;
            }
            int i;
            int length;
            int offset = this.fCurrentEntity.position;
            int c = this.fCurrentEntity.ch[offset];
            int newlines = 0;
            if (c == 10 || (c == 13 && this.isExternal)) {
                do {
                    char[] cArr = this.fCurrentEntity.ch;
                    ScannedEntity scannedEntity2 = this.fCurrentEntity;
                    int i2 = scannedEntity2.position;
                    scannedEntity2.position = i2 + 1;
                    c = cArr[i2];
                    if (c != 13 || !this.isExternal) {
                        if (c != 10) {
                            scannedEntity = this.fCurrentEntity;
                            scannedEntity.position--;
                            break;
                        }
                        newlines++;
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.lineNumber++;
                        this.fCurrentEntity.columnNumber = 1;
                        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                            offset = 0;
                            invokeListeners(newlines);
                            this.fCurrentEntity.position = newlines;
                            this.fCurrentEntity.count = newlines;
                            if (load(newlines, DEBUG_SKIP_STRING)) {
                                break;
                            }
                        }
                    }
                    newlines++;
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.lineNumber++;
                    this.fCurrentEntity.columnNumber = 1;
                    if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                        offset = 0;
                        invokeListeners(newlines);
                        this.fCurrentEntity.position = newlines;
                        if (load(newlines, DEBUG_SKIP_STRING)) {
                            break;
                        }
                    }
                    if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n') {
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.position++;
                        offset++;
                    } else {
                        newlines++;
                    }
                } while (this.fCurrentEntity.position < this.fCurrentEntity.count - 1);
                for (i = offset; i < this.fCurrentEntity.position; i++) {
                    this.fCurrentEntity.ch[i] = '\n';
                }
                length = this.fCurrentEntity.position - offset;
                if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                    buffer.append(this.fCurrentEntity.ch, offset, length);
                    return true;
                }
            }
            while (this.fCurrentEntity.position < this.fCurrentEntity.count) {
                cArr = this.fCurrentEntity.ch;
                scannedEntity2 = this.fCurrentEntity;
                i2 = scannedEntity2.position;
                scannedEntity2.position = i2 + 1;
                char c2 = cArr[i2];
                if (c2 == charAt0) {
                    int delimOffset = this.fCurrentEntity.position - 1;
                    for (i = 1; i < delimLen; i++) {
                        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                            scannedEntity = this.fCurrentEntity;
                            scannedEntity.position -= i;
                            break;
                        }
                        cArr = this.fCurrentEntity.ch;
                        scannedEntity2 = this.fCurrentEntity;
                        i2 = scannedEntity2.position;
                        scannedEntity2.position = i2 + 1;
                        if (delimiter.charAt(i) != cArr[i2]) {
                            scannedEntity = this.fCurrentEntity;
                            scannedEntity.position -= i;
                            break;
                        }
                    }
                    if (this.fCurrentEntity.position == delimOffset + delimLen) {
                        done = true;
                        break;
                    }
                } else if (c2 == '\n' || (this.isExternal && c2 == '\r')) {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.position--;
                    break;
                } else if (XMLChar.isInvalid(c2)) {
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.position--;
                    length = this.fCurrentEntity.position - offset;
                    scannedEntity = this.fCurrentEntity;
                    scannedEntity.columnNumber += length - newlines;
                    buffer.append(this.fCurrentEntity.ch, offset, length);
                    return true;
                }
            }
            length = this.fCurrentEntity.position - offset;
            scannedEntity = this.fCurrentEntity;
            scannedEntity.columnNumber += length - newlines;
            if (done) {
                length -= delimLen;
            }
            buffer.append(this.fCurrentEntity.ch, offset, length);
        } while (!done);
        if (done) {
            return DEBUG_SKIP_STRING;
        }
        return true;
    }

    public boolean skipChar(int c) throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        int cc = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        ScannedEntity scannedEntity;
        if (cc == c) {
            scannedEntity = this.fCurrentEntity;
            scannedEntity.position++;
            if (c == 10) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.lineNumber++;
                this.fCurrentEntity.columnNumber = 1;
                return true;
            }
            scannedEntity = this.fCurrentEntity;
            scannedEntity.columnNumber++;
            return true;
        } else if (c != 10 || cc != 13 || !this.isExternal) {
            return DEBUG_SKIP_STRING;
        } else {
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                invokeListeners(1);
                this.fCurrentEntity.ch[0] = (char) cc;
                load(1, DEBUG_SKIP_STRING);
            }
            scannedEntity = this.fCurrentEntity;
            scannedEntity.position++;
            if (this.fCurrentEntity.ch[this.fCurrentEntity.position] == '\n') {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.position++;
            }
            scannedEntity = this.fCurrentEntity;
            scannedEntity.lineNumber++;
            this.fCurrentEntity.columnNumber = 1;
            return true;
        }
    }

    public boolean isSpace(char ch) {
        return (ch == ' ' || ch == '\n' || ch == '\t' || ch == '\r') ? true : DEBUG_SKIP_STRING;
    }

    public boolean skipSpaces() throws IOException {
        if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
            invokeListeners(0);
            load(0, true);
        }
        if (this.fCurrentEntity == null) {
            return DEBUG_SKIP_STRING;
        }
        int c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        if (!XMLChar.isSpace(c)) {
            return DEBUG_SKIP_STRING;
        }
        do {
            ScannedEntity scannedEntity;
            boolean entityChanged = DEBUG_SKIP_STRING;
            if (c == 10 || (this.isExternal && c == 13)) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.lineNumber++;
                this.fCurrentEntity.columnNumber = 1;
                if (this.fCurrentEntity.position == this.fCurrentEntity.count - 1) {
                    invokeListeners(0);
                    this.fCurrentEntity.ch[0] = (char) c;
                    entityChanged = load(1, true);
                    if (!entityChanged) {
                        this.fCurrentEntity.position = 0;
                    } else if (this.fCurrentEntity == null) {
                        return true;
                    }
                }
                if (c == 13 && this.isExternal) {
                    char[] cArr = this.fCurrentEntity.ch;
                    ScannedEntity scannedEntity2 = this.fCurrentEntity;
                    int i = scannedEntity2.position + 1;
                    scannedEntity2.position = i;
                    if (cArr[i] != '\n') {
                        scannedEntity = this.fCurrentEntity;
                        scannedEntity.position--;
                    }
                }
            } else {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.columnNumber++;
            }
            if (!entityChanged) {
                scannedEntity = this.fCurrentEntity;
                scannedEntity.position++;
            }
            if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                invokeListeners(0);
                load(0, true);
                if (this.fCurrentEntity == null) {
                    return true;
                }
            }
            c = this.fCurrentEntity.ch[this.fCurrentEntity.position];
        } while (XMLChar.isSpace(c));
        return true;
    }

    public boolean arrangeCapacity(int length) throws IOException {
        return arrangeCapacity(length, DEBUG_SKIP_STRING);
    }

    public boolean arrangeCapacity(int length, boolean changeEntity) throws IOException {
        if (this.fCurrentEntity.count - this.fCurrentEntity.position >= length) {
            return true;
        }
        while (this.fCurrentEntity.count - this.fCurrentEntity.position < length) {
            if (this.fCurrentEntity.ch.length - this.fCurrentEntity.position < length) {
                invokeListeners(0);
                System.arraycopy(this.fCurrentEntity.ch, this.fCurrentEntity.position, this.fCurrentEntity.ch, 0, this.fCurrentEntity.count - this.fCurrentEntity.position);
                ScannedEntity scannedEntity = this.fCurrentEntity;
                scannedEntity.count -= this.fCurrentEntity.position;
                this.fCurrentEntity.position = 0;
            }
            if (this.fCurrentEntity.count - this.fCurrentEntity.position < length) {
                int pos = this.fCurrentEntity.position;
                invokeListeners(pos);
                boolean entityChanged = load(this.fCurrentEntity.count, changeEntity);
                this.fCurrentEntity.position = pos;
                if (entityChanged) {
                    break;
                }
            }
        }
        if (this.fCurrentEntity.count - this.fCurrentEntity.position < length) {
            return DEBUG_SKIP_STRING;
        }
        return true;
    }

    public boolean skipString(String s) throws IOException {
        int length = s.length();
        if (!arrangeCapacity(length, DEBUG_SKIP_STRING)) {
            return DEBUG_SKIP_STRING;
        }
        int beforeSkip = this.fCurrentEntity.position;
        int afterSkip = (this.fCurrentEntity.position + length) - 1;
        int i = length - 1;
        while (true) {
            int i2 = i - 1;
            if (s.charAt(i) != this.fCurrentEntity.ch[afterSkip]) {
                return DEBUG_SKIP_STRING;
            }
            int afterSkip2 = afterSkip - 1;
            if (afterSkip == beforeSkip) {
                this.fCurrentEntity.position += length;
                ScannedEntity scannedEntity = this.fCurrentEntity;
                scannedEntity.columnNumber += length;
                return true;
            }
            i = i2;
            afterSkip = afterSkip2;
        }
    }

    public boolean skipString(char[] s) throws IOException {
        int length = s.length;
        if (!arrangeCapacity(length, DEBUG_SKIP_STRING)) {
            return DEBUG_SKIP_STRING;
        }
        int afterSkip = this.fCurrentEntity.position + length;
        int i = 0;
        int beforeSkip = this.fCurrentEntity.position;
        while (i < length) {
            int beforeSkip2 = beforeSkip + 1;
            if (this.fCurrentEntity.ch[beforeSkip] != s[i]) {
                return DEBUG_SKIP_STRING;
            }
            i++;
            beforeSkip = beforeSkip2;
        }
        this.fCurrentEntity.position += length;
        ScannedEntity scannedEntity = this.fCurrentEntity;
        scannedEntity.columnNumber += length;
        return true;
    }

    final boolean load(int offset, boolean changeEntity) throws IOException {
        int length;
        this.fCurrentEntity.fTotalCountTillLastLoad += this.fCurrentEntity.fLastCount;
        if (this.fCurrentEntity.mayReadChunks) {
            length = this.fCurrentEntity.ch.length - offset;
        } else {
            ScannedEntity scannedEntity = this.fCurrentEntity;
            length = 64;
        }
        int count = this.fCurrentEntity.reader.read(this.fCurrentEntity.ch, offset, length);
        boolean entityChanged = DEBUG_SKIP_STRING;
        if (count == -1) {
            this.fCurrentEntity.count = offset;
            this.fCurrentEntity.position = offset;
            entityChanged = true;
            if (changeEntity) {
                this.fEntityManager.endEntity();
                if (this.fCurrentEntity == null) {
                    return true;
                }
                if (this.fCurrentEntity.position == this.fCurrentEntity.count) {
                    load(0, true);
                }
            }
        } else if (count != 0) {
            this.fCurrentEntity.fLastCount = count;
            this.fCurrentEntity.count = count + offset;
            this.fCurrentEntity.position = offset;
        }
        return entityChanged;
    }

    protected Reader createReader(InputStream inputStream, String encoding, Boolean isBigEndian) throws IOException {
        if (encoding == null) {
            encoding = StringEncodings.UTF8;
        }
        String ENCODING = encoding.toUpperCase(Locale.ENGLISH);
        if (ENCODING.equals(StringEncodings.UTF8)) {
            return new UTF8Reader(inputStream, this.fCurrentEntity.fBufferSize, this.fErrorReporter.getMessageFormatter(XMLMessageFormatter.XML_DOMAIN), this.fErrorReporter.getLocale());
        }
        if (ENCODING.equals(StringEncodings.US_ASCII)) {
            return new ASCIIReader(inputStream, this.fCurrentEntity.fBufferSize, this.fErrorReporter.getMessageFormatter(XMLMessageFormatter.XML_DOMAIN), this.fErrorReporter.getLocale());
        }
        if (ENCODING.equals("ISO-10646-UCS-4")) {
            if (isBigEndian == null) {
                this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "EncodingByteOrderUnsupported", new Object[]{encoding}, (short) 2);
            } else if (isBigEndian.booleanValue()) {
                return new UCSReader(inputStream, (short) 8);
            } else {
                return new UCSReader(inputStream, (short) 4);
            }
        }
        if (ENCODING.equals("ISO-10646-UCS-2")) {
            if (isBigEndian == null) {
                this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "EncodingByteOrderUnsupported", new Object[]{encoding}, (short) 2);
            } else if (isBigEndian.booleanValue()) {
                return new UCSReader(inputStream, (short) 2);
            } else {
                return new UCSReader(inputStream, (short) 1);
            }
        }
        boolean validIANA = XMLChar.isValidIANAEncoding(encoding);
        boolean validJava = XMLChar.isValidJavaEncoding(encoding);
        if (!validIANA || (this.fAllowJavaEncodings && !validJava)) {
            this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "EncodingDeclInvalid", new Object[]{encoding}, (short) 2);
            encoding = "ISO-8859-1";
        }
        String javaEncoding = EncodingMap.getIANA2JavaMapping(ENCODING);
        if (javaEncoding == null) {
            if (this.fAllowJavaEncodings) {
                javaEncoding = encoding;
            } else {
                this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "EncodingDeclInvalid", new Object[]{encoding}, (short) 2);
                javaEncoding = "ISO8859_1";
            }
        }
        return new InputStreamReader(inputStream, javaEncoding);
    }

    protected Object[] getEncodingName(byte[] b4, int count) {
        if (count < 2) {
            return new Object[]{StringEncodings.UTF8, null};
        }
        int b0 = b4[0] & 255;
        int b1 = b4[1] & 255;
        if (b0 == 254 && b1 == 255) {
            return new Object[]{"UTF-16BE", new Boolean(true)};
        } else if (b0 == 255 && b1 == 254) {
            return new Object[]{"UTF-16LE", new Boolean(DEBUG_SKIP_STRING)};
        } else if (count < 3) {
            return new Object[]{StringEncodings.UTF8, null};
        } else {
            int b2 = b4[2] & 255;
            if (b0 == 239 && b1 == 187 && b2 == 191) {
                return new Object[]{StringEncodings.UTF8, null};
            } else if (count < 4) {
                return new Object[]{StringEncodings.UTF8, null};
            } else {
                int b3 = b4[3] & 255;
                if (b0 == 0 && b1 == 0 && b2 == 0 && b3 == 60) {
                    return new Object[]{"ISO-10646-UCS-4", new Boolean(true)};
                } else if (b0 == 60 && b1 == 0 && b2 == 0 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", new Boolean(DEBUG_SKIP_STRING)};
                } else if (b0 == 0 && b1 == 0 && b2 == 60 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", null};
                } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", null};
                } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 63) {
                    return new Object[]{"UTF-16BE", new Boolean(true)};
                } else if (b0 == 60 && b1 == 0 && b2 == 63 && b3 == 0) {
                    return new Object[]{"UTF-16LE", new Boolean(DEBUG_SKIP_STRING)};
                } else if (b0 == 76 && b1 == 111 && b2 == 167 && b3 == 148) {
                    return new Object[]{"CP037", null};
                } else {
                    return new Object[]{StringEncodings.UTF8, null};
                }
            }
        }
    }

    final void print() {
    }

    public void registerListener(XMLBufferListener listener) {
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
    }

    private void invokeListeners(int loadPos) {
        for (int i = 0; i < this.listeners.size(); i++) {
            ((XMLBufferListener) this.listeners.get(i)).refresh(loadPos);
        }
    }
}
