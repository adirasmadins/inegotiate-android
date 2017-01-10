package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.Entity.ExternalEntity;
import com.amazonaws.javax.xml.stream.Entity.InternalEntity;
import com.amazonaws.javax.xml.stream.Entity.ScannedEntity;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.stream.xerces.impl.io.ASCIIReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UTF8Reader;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.EncodingMap;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.URI;
import com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponent;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLEntityResolver;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import com.google.common.base.Ascii;
import com.google.gdata.data.Category;
import com.google.gdata.data.docs.FileEntry;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Stack;
import java.util.Vector;

public class XMLEntityManager implements XMLComponent, XMLEntityResolver {
    protected static final String ALLOW_JAVA_ENCODINGS = "http://apache.org/xml/features/allow-java-encodings";
    protected static final String BUFFER_SIZE = "http://apache.org/xml/properties/input-buffer-size";
    private static final boolean DEBUG_BUFFER = false;
    private static final boolean DEBUG_ENCODINGS = false;
    private static final boolean DEBUG_ENTITIES = false;
    private static final boolean DEBUG_RESOLVER = false;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int DEFAULT_INTERNAL_BUFFER_SIZE = 1024;
    public static final int DEFAULT_XMLDECL_BUFFER_SIZE = 64;
    private static final String DTDEntity;
    protected static final String ENTITY_RESOLVER = "http://apache.org/xml/properties/internal/entity-resolver";
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    protected static final String EXTERNAL_GENERAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";
    protected static final String EXTERNAL_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
    private static final Boolean[] FEATURE_DEFAULTS;
    private static final Object[] PROPERTY_DEFAULTS;
    private static final String[] RECOGNIZED_FEATURES;
    private static final String[] RECOGNIZED_PROPERTIES;
    protected static final String STAX_ENTITY_RESOLVER = "http://apache.org/xml/properties/internal/stax-entity-resolver";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    protected static final String VALIDATION = "http://xml.org/sax/features/validation";
    protected static final String VALIDATION_MANAGER = "http://apache.org/xml/properties/internal/validation-manager";
    protected static final String WARN_ON_DUPLICATE_ENTITYDEF = "http://apache.org/xml/features/warn-on-duplicate-entitydef";
    private static final String XMLEntity;
    private static char[] gAfterEscaping1;
    private static char[] gAfterEscaping2;
    private static String gEscapedUserDir;
    private static char[] gHexChs;
    private static boolean[] gNeedEscaping;
    private static String gUserDir;
    protected final Object[] defaultEncoding;
    protected boolean fAllowJavaEncodings;
    protected int fBufferSize;
    protected ScannedEntity fCurrentEntity;
    protected Hashtable fDeclaredEntities;
    protected Hashtable fEntities;
    protected XMLEntityHandler fEntityHandler;
    protected XMLEntityReaderImpl fEntityReader;
    protected XMLEntityResolver fEntityResolver;
    protected Stack fEntityStack;
    protected XMLEntityStorage fEntityStorage;
    protected XMLErrorReporter fErrorReporter;
    protected boolean fExternalGeneralEntities;
    protected boolean fExternalParameterEntities;
    protected boolean fInExternalSubset;
    protected Vector fOwnReaders;
    protected PropertyManager fPropertyManager;
    private final XMLResourceIdentifierImpl fResourceIdentifier;
    protected boolean fStandalone;
    protected StaxEntityResolverWrapper fStaxEntityResolver;
    protected SymbolTable fSymbolTable;
    protected boolean fValidation;

    protected final class RewindableInputStream extends InputStream {
        private byte[] fData;
        private int fEndOffset;
        private InputStream fInputStream;
        private int fLength;
        private int fMark;
        private int fOffset;
        private int fStartOffset;

        public RewindableInputStream(InputStream is) {
            this.fData = new byte[XMLEntityManager.DEFAULT_XMLDECL_BUFFER_SIZE];
            this.fInputStream = is;
            this.fStartOffset = 0;
            this.fEndOffset = -1;
            this.fOffset = 0;
            this.fLength = 0;
            this.fMark = 0;
        }

        public void setStartOffset(int offset) {
            this.fStartOffset = offset;
        }

        public void rewind() {
            this.fOffset = this.fStartOffset;
        }

        public int read() throws IOException {
            byte[] bArr;
            int i;
            if (this.fOffset < this.fLength) {
                bArr = this.fData;
                i = this.fOffset;
                this.fOffset = i + 1;
                return bArr[i] & 255;
            } else if (this.fOffset == this.fEndOffset) {
                return -1;
            } else {
                if (this.fOffset == this.fData.length) {
                    byte[] newData = new byte[(this.fOffset << 1)];
                    System.arraycopy(this.fData, 0, newData, 0, this.fOffset);
                    this.fData = newData;
                }
                int b = this.fInputStream.read();
                if (b == -1) {
                    this.fEndOffset = this.fOffset;
                    return -1;
                }
                bArr = this.fData;
                i = this.fLength;
                this.fLength = i + 1;
                bArr[i] = (byte) b;
                this.fOffset++;
                return b & 255;
            }
        }

        public int read(byte[] b, int off, int len) throws IOException {
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft != 0) {
                if (len >= bytesLeft) {
                    len = bytesLeft;
                } else if (len <= 0) {
                    return 0;
                }
                if (b != null) {
                    System.arraycopy(this.fData, this.fOffset, b, off, len);
                }
                this.fOffset += len;
                return len;
            } else if (this.fOffset == this.fEndOffset) {
                return -1;
            } else {
                return this.fInputStream.read(b, off, len);
            }
        }

        public long skip(long n) throws IOException {
            if (n <= 0) {
                return 0;
            }
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft == 0) {
                if (this.fOffset != this.fEndOffset) {
                    return this.fInputStream.skip(n);
                }
                return 0;
            } else if (n <= ((long) bytesLeft)) {
                this.fOffset = (int) (((long) this.fOffset) + n);
                return n;
            } else {
                this.fOffset += bytesLeft;
                if (this.fOffset == this.fEndOffset) {
                    return (long) bytesLeft;
                }
                return this.fInputStream.skip(n - ((long) bytesLeft)) + ((long) bytesLeft);
            }
        }

        public int available() throws IOException {
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft != 0) {
                return bytesLeft;
            }
            if (this.fOffset == this.fEndOffset) {
                return -1;
            }
            return XMLEntityManager.this.fCurrentEntity.mayReadChunks ? this.fInputStream.available() : 0;
        }

        public void mark(int howMuch) {
            this.fMark = this.fOffset;
        }

        public void reset() {
            this.fOffset = this.fMark;
        }

        public boolean markSupported() {
            return true;
        }

        public void close() throws IOException {
            if (this.fInputStream != null) {
                this.fInputStream.close();
                this.fInputStream = null;
            }
        }
    }

    static {
        RECOGNIZED_FEATURES = new String[]{VALIDATION, EXTERNAL_GENERAL_ENTITIES, EXTERNAL_PARAMETER_ENTITIES, ALLOW_JAVA_ENCODINGS, WARN_ON_DUPLICATE_ENTITYDEF};
        FEATURE_DEFAULTS = new Boolean[]{null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE};
        RECOGNIZED_PROPERTIES = new String[]{SYMBOL_TABLE, ERROR_REPORTER, ENTITY_RESOLVER, VALIDATION_MANAGER, BUFFER_SIZE};
        PROPERTY_DEFAULTS = new Object[]{null, null, null, null, new Integer(DEFAULT_BUFFER_SIZE)};
        XMLEntity = "[xml]".intern();
        DTDEntity = "[dtd]".intern();
        gNeedEscaping = new boolean[XMLChar.MASK_NCNAME];
        gAfterEscaping1 = new char[XMLChar.MASK_NCNAME];
        gAfterEscaping2 = new char[XMLChar.MASK_NCNAME];
        gHexChs = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i <= 31; i++) {
            gNeedEscaping[i] = true;
            gAfterEscaping1[i] = gHexChs[i >> 4];
            gAfterEscaping2[i] = gHexChs[i & 15];
        }
        gNeedEscaping[Ascii.MAX] = true;
        gAfterEscaping1[Ascii.MAX] = '7';
        gAfterEscaping2[Ascii.MAX] = 'F';
        for (char ch : new char[]{' ', XMLStreamWriterImpl.OPEN_START_TAG, XMLStreamWriterImpl.CLOSE_START_TAG, '#', '%', '\"', Category.SCHEME_PREFIX, Category.SCHEME_SUFFIX, '|', '\\', '^', '~', '[', ']', '`'}) {
            gNeedEscaping[ch] = true;
            gAfterEscaping1[ch] = gHexChs[ch >> 4];
            gAfterEscaping2[ch] = gHexChs[ch & 15];
        }
    }

    public XMLEntityManager() {
        this.fAllowJavaEncodings = true;
        this.fBufferSize = DEFAULT_BUFFER_SIZE;
        this.fInExternalSubset = DEBUG_RESOLVER;
        this.fEntities = new Hashtable();
        this.fEntityStack = new Stack();
        this.fCurrentEntity = null;
        this.defaultEncoding = new Object[]{StringEncodings.UTF8, null};
        this.fResourceIdentifier = new XMLResourceIdentifierImpl();
        this.fOwnReaders = new Vector();
        this.fEntityStorage = new XMLEntityStorage(this);
        this.fEntityReader = new XMLEntityReaderImpl(this);
    }

    public XMLEntityManager(PropertyManager propertyManager) {
        this.fAllowJavaEncodings = true;
        this.fBufferSize = DEFAULT_BUFFER_SIZE;
        this.fInExternalSubset = DEBUG_RESOLVER;
        this.fEntities = new Hashtable();
        this.fEntityStack = new Stack();
        this.fCurrentEntity = null;
        this.defaultEncoding = new Object[]{StringEncodings.UTF8, null};
        this.fResourceIdentifier = new XMLResourceIdentifierImpl();
        this.fOwnReaders = new Vector();
        this.fPropertyManager = propertyManager;
        this.fEntityStorage = new XMLEntityStorage(this);
        this.fEntityReader = new XMLEntityReaderImpl(propertyManager, this);
        reset(propertyManager);
    }

    public XMLEntityStorage getEntityStore() {
        return this.fEntityStorage;
    }

    public XMLEntityReader getEntityReader() {
        return this.fEntityReader;
    }

    public void setStandalone(boolean standalone) {
        this.fStandalone = standalone;
    }

    public boolean isStandalone() {
        return this.fStandalone;
    }

    public void setEntityHandler(XMLEntityHandler entityHandler) {
        this.fEntityHandler = entityHandler;
    }

    public StaxXMLInputSource resolveEntityAsPerStax(XMLResourceIdentifier resourceIdentifier) throws IOException {
        if (resourceIdentifier == null) {
            return null;
        }
        String publicId = resourceIdentifier.getPublicId();
        String literalSystemId = resourceIdentifier.getLiteralSystemId();
        String baseSystemId = resourceIdentifier.getBaseSystemId();
        String expandedSystemId = resourceIdentifier.getExpandedSystemId();
        boolean needExpand = expandedSystemId == null ? true : DEBUG_RESOLVER;
        if (!(baseSystemId != null || this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null)) {
            baseSystemId = this.fCurrentEntity.entityLocation.getExpandedSystemId();
            if (baseSystemId != null) {
                needExpand = true;
            }
        }
        if (needExpand) {
            expandedSystemId = expandSystemId(literalSystemId, baseSystemId);
        }
        StaxXMLInputSource xmlInputSource = null;
        if (this.fStaxEntityResolver != null) {
            XMLResourceIdentifierImpl ri;
            if (resourceIdentifier instanceof XMLResourceIdentifierImpl) {
                ri = (XMLResourceIdentifierImpl) resourceIdentifier;
            } else {
                this.fResourceIdentifier.clear();
                ri = this.fResourceIdentifier;
            }
            ri.setValues(publicId, literalSystemId, baseSystemId, expandedSystemId);
            xmlInputSource = this.fStaxEntityResolver.resolveEntity(ri);
        }
        if (xmlInputSource == null) {
            return new StaxXMLInputSource(new XMLInputSource(publicId, literalSystemId, baseSystemId));
        }
        return xmlInputSource.hasXMLStreamOrXMLEventReader() ? xmlInputSource : xmlInputSource;
    }

    public XMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier) throws IOException, XNIException {
        if (resourceIdentifier == null) {
            return null;
        }
        String publicId = resourceIdentifier.getPublicId();
        String literalSystemId = resourceIdentifier.getLiteralSystemId();
        String baseSystemId = resourceIdentifier.getBaseSystemId();
        String expandedSystemId = resourceIdentifier.getExpandedSystemId();
        boolean needExpand = expandedSystemId == null ? true : DEBUG_RESOLVER;
        if (!(baseSystemId != null || this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null)) {
            baseSystemId = this.fCurrentEntity.entityLocation.getExpandedSystemId();
            if (baseSystemId != null) {
                needExpand = true;
            }
        }
        if (needExpand) {
            expandedSystemId = expandSystemId(literalSystemId, baseSystemId);
        }
        XMLInputSource xmlInputSource = null;
        if (this.fEntityResolver != null) {
            XMLResourceIdentifierImpl ri;
            if (resourceIdentifier instanceof XMLResourceIdentifierImpl) {
                ri = (XMLResourceIdentifierImpl) resourceIdentifier;
            } else {
                this.fResourceIdentifier.clear();
                ri = this.fResourceIdentifier;
            }
            ri.setValues(publicId, literalSystemId, baseSystemId, expandedSystemId);
            xmlInputSource = this.fEntityResolver.resolveEntity(ri);
        }
        if (xmlInputSource == null) {
            return new XMLInputSource(publicId, literalSystemId, baseSystemId);
        }
        return xmlInputSource;
    }

    public void startEntity(String entityName, boolean literal) throws IOException, XNIException {
        Entity entity = (Entity) this.fEntityStorage.getDeclaredEntities().get(entityName);
        if (entity != null) {
            ExternalEntity externalEntity;
            String extLitSysId;
            String extBaseSysId;
            XMLInputSource xmlInputSource;
            boolean external = entity.isExternal();
            if (external) {
                boolean unparsed = entity.isUnparsed();
                boolean parameter = entityName.startsWith("%");
                boolean general = !parameter ? true : DEBUG_RESOLVER;
                if (unparsed || ((general && !this.fExternalGeneralEntities) || (parameter && !this.fExternalParameterEntities))) {
                    if (this.fEntityHandler != null) {
                        this.fResourceIdentifier.clear();
                        externalEntity = (ExternalEntity) entity;
                        extLitSysId = externalEntity.entityLocation != null ? externalEntity.entityLocation.getLiteralSystemId() : null;
                        extBaseSysId = externalEntity.entityLocation != null ? externalEntity.entityLocation.getBaseSystemId() : null;
                        this.fResourceIdentifier.setValues(externalEntity.entityLocation != null ? externalEntity.entityLocation.getPublicId() : null, extLitSysId, extBaseSysId, expandSystemId(extLitSysId, extBaseSysId));
                        this.fEntityHandler.startEntity(entityName, this.fResourceIdentifier, null);
                        this.fEntityHandler.endEntity(entityName);
                        return;
                    }
                    return;
                }
            }
            int size = this.fEntityStack.size();
            int i = size;
            while (i >= 0) {
                if ((i == size ? this.fCurrentEntity : (Entity) this.fEntityStack.elementAt(i)).name == entityName) {
                    String path = entityName;
                    for (int j = i + 1; j < size; j++) {
                        path = new StringBuffer().append(path).append(" -> ").append(((Entity) this.fEntityStack.elementAt(j)).name).toString();
                    }
                    path = new StringBuffer().append(new StringBuffer().append(path).append(" -> ").append(this.fCurrentEntity.name).toString()).append(" -> ").append(entityName).toString();
                    this.fErrorReporter.reportError(getEntityReader(), XMLMessageFormatter.XML_DOMAIN, "RecursiveReference", new Object[]{entityName, path}, (short) 2);
                    if (this.fEntityHandler != null) {
                        this.fResourceIdentifier.clear();
                        if (external) {
                            externalEntity = (ExternalEntity) entity;
                            extLitSysId = externalEntity.entityLocation != null ? externalEntity.entityLocation.getLiteralSystemId() : null;
                            extBaseSysId = externalEntity.entityLocation != null ? externalEntity.entityLocation.getBaseSystemId() : null;
                            this.fResourceIdentifier.setValues(externalEntity.entityLocation != null ? externalEntity.entityLocation.getPublicId() : null, extLitSysId, extBaseSysId, expandSystemId(extLitSysId, extBaseSysId));
                        }
                        this.fEntityHandler.startEntity(entityName, this.fResourceIdentifier, null);
                        this.fEntityHandler.endEntity(entityName);
                        return;
                    }
                    return;
                }
                i--;
            }
            if (external) {
                xmlInputSource = resolveEntityAsPerStax(((ExternalEntity) entity).entityLocation).getXMLInputSource();
            } else {
                xmlInputSource = new XMLInputSource(null, null, null, new StringReader(((InternalEntity) entity).text), null);
            }
            startEntity(entityName, xmlInputSource, literal, external);
        } else if (this.fEntityHandler != null) {
            this.fResourceIdentifier.clear();
            this.fEntityHandler.startEntity(entityName, this.fResourceIdentifier, null);
            this.fEntityHandler.endEntity(entityName);
        }
    }

    public void startDocumentEntity(XMLInputSource xmlInputSource) throws IOException, XNIException {
        startEntity(XMLEntity, xmlInputSource, DEBUG_RESOLVER, true);
    }

    public void startDTDEntity(XMLInputSource xmlInputSource) throws IOException, XNIException {
        startEntity(DTDEntity, xmlInputSource, DEBUG_RESOLVER, true);
    }

    public void startExternalSubset() {
        this.fInExternalSubset = true;
    }

    public void endExternalSubset() {
        this.fInExternalSubset = DEBUG_RESOLVER;
    }

    public void startEntity(String name, XMLInputSource xmlInputSource, boolean literal, boolean isExternal) throws IOException, XNIException {
        String publicId = xmlInputSource.getPublicId();
        String literalSystemId = xmlInputSource.getSystemId();
        String baseSystemId = xmlInputSource.getBaseSystemId();
        String encoding = xmlInputSource.getEncoding();
        InputStream stream = null;
        Reader reader = xmlInputSource.getCharacterStream();
        String expandedSystemId = expandSystemId(literalSystemId, baseSystemId);
        if (baseSystemId == null) {
            baseSystemId = expandedSystemId;
        }
        if (reader == null) {
            stream = xmlInputSource.getByteStream();
            if (stream == null) {
                stream = new BufferedInputStream(new URL(expandedSystemId).openStream());
            }
            InputStream rewindableInputStream = new RewindableInputStream(stream);
            if (encoding == null) {
                byte[] b4 = new byte[4];
                int count = 0;
                while (count < 4) {
                    b4[count] = (byte) rewindableInputStream.read();
                    count++;
                }
                if (count == 4) {
                    Object[] encodingDesc = getEncodingName(b4, count);
                    encoding = (String) encodingDesc[0];
                    Boolean isBigEndian = (Boolean) encodingDesc[1];
                    rewindableInputStream.reset();
                    if (count > 2 && encoding.equals(StringEncodings.UTF8)) {
                        int b1 = b4[1] & 255;
                        int b2 = b4[2] & 255;
                        if ((b4[0] & 255) == 239 && b1 == 187 && b2 == 191) {
                            rewindableInputStream.skip(3);
                        }
                    }
                    reader = createReader(rewindableInputStream, encoding, isBigEndian);
                } else {
                    reader = createReader(rewindableInputStream, encoding, null);
                }
                stream = rewindableInputStream;
            } else {
                reader = createReader(rewindableInputStream, encoding, null);
                stream = rewindableInputStream;
            }
        }
        if (this.fCurrentEntity != null) {
            this.fEntityStack.push(this.fCurrentEntity);
        }
        this.fCurrentEntity = new ScannedEntity(name, new XMLResourceIdentifierImpl(publicId, literalSystemId, baseSystemId, expandedSystemId), stream, reader, encoding, literal, DEBUG_RESOLVER, isExternal);
        this.fEntityReader.setCurrentEntity(this.fCurrentEntity);
        this.fResourceIdentifier.setValues(publicId, literalSystemId, baseSystemId, expandedSystemId);
        if (this.fEntityHandler != null) {
            this.fEntityHandler.startEntity(name, this.fResourceIdentifier, encoding);
        }
    }

    public ScannedEntity getCurrentEntity() {
        return this.fCurrentEntity;
    }

    public void closeReaders() {
        for (int i = this.fOwnReaders.size() - 1; i >= 0; i--) {
            try {
                ((Reader) this.fOwnReaders.elementAt(i)).close();
            } catch (IOException e) {
            }
        }
        this.fOwnReaders.removeAllElements();
    }

    public void endEntity() throws IOException, XNIException {
        if (this.fEntityHandler != null) {
            this.fEntityHandler.endEntity(this.fCurrentEntity.name);
        }
        if (this.fCurrentEntity != null) {
            try {
                this.fCurrentEntity.close();
            } catch (Exception ex) {
                throw new XNIException(ex);
            }
        }
        this.fCurrentEntity = this.fEntityStack.size() > 0 ? (ScannedEntity) this.fEntityStack.pop() : null;
        this.fEntityReader.setCurrentEntity(this.fCurrentEntity);
    }

    public void reset(PropertyManager propertyManager) {
        this.fEntityStorage.reset(propertyManager);
        this.fEntityReader.reset(propertyManager);
        this.fSymbolTable = (SymbolTable) propertyManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) propertyManager.getProperty(ERROR_REPORTER);
        try {
            this.fStaxEntityResolver = (StaxEntityResolverWrapper) propertyManager.getProperty(STAX_ENTITY_RESOLVER);
        } catch (XMLConfigurationException e) {
            this.fStaxEntityResolver = null;
        }
        this.fEntities.clear();
        this.fEntityStack.removeAllElements();
        this.fCurrentEntity = null;
        this.fValidation = DEBUG_RESOLVER;
        this.fExternalGeneralEntities = true;
        this.fExternalParameterEntities = true;
        this.fAllowJavaEncodings = true;
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        try {
            this.fValidation = componentManager.getFeature(VALIDATION);
        } catch (XMLConfigurationException e) {
            this.fValidation = DEBUG_RESOLVER;
        }
        try {
            this.fExternalGeneralEntities = componentManager.getFeature(EXTERNAL_GENERAL_ENTITIES);
        } catch (XMLConfigurationException e2) {
            this.fExternalGeneralEntities = true;
        }
        try {
            this.fExternalParameterEntities = componentManager.getFeature(EXTERNAL_PARAMETER_ENTITIES);
        } catch (XMLConfigurationException e3) {
            this.fExternalParameterEntities = true;
        }
        try {
            this.fAllowJavaEncodings = componentManager.getFeature(ALLOW_JAVA_ENCODINGS);
        } catch (XMLConfigurationException e4) {
            this.fAllowJavaEncodings = DEBUG_RESOLVER;
        }
        this.fSymbolTable = (SymbolTable) componentManager.getProperty(SYMBOL_TABLE);
        this.fErrorReporter = (XMLErrorReporter) componentManager.getProperty(ERROR_REPORTER);
        try {
            this.fEntityResolver = (XMLEntityResolver) componentManager.getProperty(ENTITY_RESOLVER);
        } catch (XMLConfigurationException e5) {
            this.fEntityResolver = null;
        }
        try {
            this.fStaxEntityResolver = (StaxEntityResolverWrapper) componentManager.getProperty(STAX_ENTITY_RESOLVER);
        } catch (XMLConfigurationException e6) {
            this.fStaxEntityResolver = null;
        }
        this.fStandalone = DEBUG_RESOLVER;
        this.fEntities.clear();
        this.fEntityStack.removeAllElements();
        this.fCurrentEntity = null;
        if (this.fDeclaredEntities != null) {
            Enumeration keys = this.fDeclaredEntities.keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                this.fEntities.put(key, this.fDeclaredEntities.get(key));
            }
        }
    }

    public String[] getRecognizedFeatures() {
        return (String[]) RECOGNIZED_FEATURES.clone();
    }

    public void setFeature(String featureId, boolean state) throws XMLConfigurationException {
        if (featureId.startsWith(Constants.XERCES_FEATURE_PREFIX) && featureId.substring(Constants.XERCES_FEATURE_PREFIX.length()).equals(Constants.ALLOW_JAVA_ENCODINGS_FEATURE)) {
            this.fAllowJavaEncodings = state;
        }
    }

    public void setProperty(String name, Object value) {
    }

    public String[] getRecognizedProperties() {
        return (String[]) RECOGNIZED_PROPERTIES.clone();
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

    public static String expandSystemId(String systemId) {
        return expandSystemId(systemId, null);
    }

    private static synchronized String getUserDir() {
        String userDir;
        synchronized (XMLEntityManager.class) {
            userDir = StringUtil.EMPTY_STRING;
            try {
                userDir = System.getProperty("user.dir");
            } catch (SecurityException e) {
            }
            if (userDir.length() == 0) {
                userDir = StringUtil.EMPTY_STRING;
            } else if (userDir.equals(gUserDir)) {
                userDir = gEscapedUserDir;
            } else {
                int ch;
                gUserDir = userDir;
                userDir = userDir.replace(File.separatorChar, '/');
                int len = userDir.length();
                StringBuffer buffer = new StringBuffer(len * 3);
                if (len >= 2 && userDir.charAt(1) == ':') {
                    ch = Character.toUpperCase(userDir.charAt(0));
                    if (ch >= 65 && ch <= 90) {
                        buffer.append('/');
                    }
                }
                int i = 0;
                while (i < len) {
                    ch = userDir.charAt(i);
                    if (ch >= XMLChar.MASK_NCNAME) {
                        break;
                    }
                    if (gNeedEscaping[ch]) {
                        buffer.append('%');
                        buffer.append(gAfterEscaping1[ch]);
                        buffer.append(gAfterEscaping2[ch]);
                    } else {
                        buffer.append((char) ch);
                    }
                    i++;
                }
                if (i < len) {
                    try {
                        for (byte b : userDir.substring(i).getBytes(StringEncodings.UTF8)) {
                            if (b < null) {
                                ch = b + 256;
                                buffer.append('%');
                                buffer.append(gHexChs[ch >> 4]);
                                buffer.append(gHexChs[ch & 15]);
                            } else if (gNeedEscaping[b]) {
                                buffer.append('%');
                                buffer.append(gAfterEscaping1[b]);
                                buffer.append(gAfterEscaping2[b]);
                            } else {
                                buffer.append((char) b);
                            }
                        }
                    } catch (UnsupportedEncodingException e2) {
                    }
                }
                if (!userDir.endsWith("/")) {
                    buffer.append('/');
                }
                gEscapedUserDir = buffer.toString();
                userDir = gEscapedUserDir;
            }
        }
        return userDir;
    }

    public static String expandSystemId(String systemId, String baseSystemId) {
        if (systemId == null || systemId.length() == 0) {
            return systemId;
        }
        URI base;
        try {
            if (new URI(systemId) != null) {
                return systemId;
            }
        } catch (MalformedURIException e) {
        }
        String id = fixURI(systemId);
        URI uri = null;
        if (baseSystemId != null) {
            try {
                if (!(baseSystemId.length() == 0 || baseSystemId.equals(systemId))) {
                    try {
                        base = new URI(fixURI(baseSystemId));
                    } catch (MalformedURIException e2) {
                        if (baseSystemId.indexOf(58) != -1) {
                            URI uri2 = new URI(FileEntry.LABEL, StringUtil.EMPTY_STRING, fixURI(baseSystemId), null, null);
                        } else {
                            base = new URI(FileEntry.LABEL, StringUtil.EMPTY_STRING, new StringBuffer().append(getUserDir()).append(fixURI(baseSystemId)).toString(), null, null);
                        }
                    }
                    uri = new URI(base, id);
                    return uri == null ? uri.toString() : systemId;
                }
            } catch (Exception e3) {
                base = null;
            }
        }
        base = new URI(FileEntry.LABEL, StringUtil.EMPTY_STRING, getUserDir(), null, null);
        try {
            uri = new URI(base, id);
        } catch (Exception e4) {
        }
        if (uri == null) {
        }
    }

    protected Object[] getEncodingName(byte[] b4, int count) {
        if (count < 2) {
            return this.defaultEncoding;
        }
        int b0 = b4[0] & 255;
        int b1 = b4[1] & 255;
        if (b0 == 254 && b1 == 255) {
            return new Object[]{"UTF-16BE", new Boolean(true)};
        } else if (b0 == 255 && b1 == 254) {
            return new Object[]{"UTF-16LE", new Boolean(DEBUG_RESOLVER)};
        } else if (count < 3) {
            return this.defaultEncoding;
        } else {
            int b2 = b4[2] & 255;
            if (b0 == 239 && b1 == 187 && b2 == 191) {
                return this.defaultEncoding;
            }
            if (count < 4) {
                return this.defaultEncoding;
            }
            int b3 = b4[3] & 255;
            if (b0 == 0 && b1 == 0 && b2 == 0 && b3 == 60) {
                return new Object[]{"ISO-10646-UCS-4", new Boolean(true)};
            } else if (b0 == 60 && b1 == 0 && b2 == 0 && b3 == 0) {
                return new Object[]{"ISO-10646-UCS-4", new Boolean(DEBUG_RESOLVER)};
            } else if (b0 == 0 && b1 == 0 && b2 == 60 && b3 == 0) {
                return new Object[]{"ISO-10646-UCS-4", null};
            } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 0) {
                return new Object[]{"ISO-10646-UCS-4", null};
            } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 63) {
                return new Object[]{"UTF-16BE", new Boolean(true)};
            } else if (b0 == 60 && b1 == 0 && b2 == 63 && b3 == 0) {
                return new Object[]{"UTF-16LE", new Boolean(DEBUG_RESOLVER)};
            } else if (b0 != 76 || b1 != 111 || b2 != 167 || b3 != 148) {
                return this.defaultEncoding;
            } else {
                return new Object[]{"CP037", null};
            }
        }
    }

    protected Reader createReader(InputStream inputStream, String encoding, Boolean isBigEndian) throws IOException {
        if (encoding == null) {
            encoding = StringEncodings.UTF8;
        }
        String ENCODING = encoding.toUpperCase(Locale.ENGLISH);
        if (ENCODING.equals(StringEncodings.UTF8)) {
            return new UTF8Reader(inputStream, this.fBufferSize, this.fErrorReporter.getMessageFormatter(XMLMessageFormatter.XML_DOMAIN), this.fErrorReporter.getLocale());
        }
        if (ENCODING.equals(StringEncodings.US_ASCII)) {
            return new ASCIIReader(inputStream, this.fBufferSize, this.fErrorReporter.getMessageFormatter(XMLMessageFormatter.XML_DOMAIN), this.fErrorReporter.getLocale());
        }
        if (ENCODING.equals("ISO-10646-UCS-4")) {
            if (isBigEndian == null) {
                this.fErrorReporter.reportError(getEntityReader(), XMLMessageFormatter.XML_DOMAIN, "EncodingByteOrderUnsupported", new Object[]{encoding}, (short) 2);
            } else if (isBigEndian.booleanValue()) {
                return new UCSReader(inputStream, (short) 8);
            } else {
                return new UCSReader(inputStream, (short) 4);
            }
        }
        if (ENCODING.equals("ISO-10646-UCS-2")) {
            if (isBigEndian == null) {
                this.fErrorReporter.reportError(getEntityReader(), XMLMessageFormatter.XML_DOMAIN, "EncodingByteOrderUnsupported", new Object[]{encoding}, (short) 2);
            } else if (isBigEndian.booleanValue()) {
                return new UCSReader(inputStream, (short) 2);
            } else {
                return new UCSReader(inputStream, (short) 1);
            }
        }
        boolean validIANA = XMLChar.isValidIANAEncoding(encoding);
        boolean validJava = XMLChar.isValidJavaEncoding(encoding);
        if (!validIANA || (this.fAllowJavaEncodings && !validJava)) {
            this.fErrorReporter.reportError(getEntityReader(), XMLMessageFormatter.XML_DOMAIN, "EncodingDeclInvalid", new Object[]{encoding}, (short) 2);
            encoding = "ISO-8859-1";
        }
        String javaEncoding = EncodingMap.getIANA2JavaMapping(ENCODING);
        if (javaEncoding == null) {
            if (this.fAllowJavaEncodings) {
                javaEncoding = encoding;
            } else {
                this.fErrorReporter.reportError(getEntityReader(), XMLMessageFormatter.XML_DOMAIN, "EncodingDeclInvalid", new Object[]{encoding}, (short) 2);
                javaEncoding = "ISO8859_1";
            }
        }
        return new BufferedReader(new InputStreamReader(inputStream, javaEncoding));
    }

    public String getPublicId() {
        return (this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null) ? null : this.fCurrentEntity.entityLocation.getPublicId();
    }

    public String getExpandedSystemId() {
        if (this.fCurrentEntity != null) {
            if (this.fCurrentEntity.entityLocation != null && this.fCurrentEntity.entityLocation.getExpandedSystemId() != null) {
                return this.fCurrentEntity.entityLocation.getExpandedSystemId();
            }
            for (int i = this.fEntityStack.size() - 1; i >= 0; i--) {
                ScannedEntity externalEntity = (ScannedEntity) this.fEntityStack.elementAt(i);
                if (externalEntity.entityLocation != null && externalEntity.entityLocation.getExpandedSystemId() != null) {
                    return externalEntity.entityLocation.getExpandedSystemId();
                }
            }
        }
        return null;
    }

    public String getLiteralSystemId() {
        if (this.fCurrentEntity != null) {
            if (this.fCurrentEntity.entityLocation != null && this.fCurrentEntity.entityLocation.getLiteralSystemId() != null) {
                return this.fCurrentEntity.entityLocation.getLiteralSystemId();
            }
            for (int i = this.fEntityStack.size() - 1; i >= 0; i--) {
                ScannedEntity externalEntity = (ScannedEntity) this.fEntityStack.elementAt(i);
                if (externalEntity.entityLocation != null && externalEntity.entityLocation.getLiteralSystemId() != null) {
                    return externalEntity.entityLocation.getLiteralSystemId();
                }
            }
        }
        return null;
    }

    public int getLineNumber() {
        if (this.fCurrentEntity != null) {
            if (this.fCurrentEntity.isExternal()) {
                return this.fCurrentEntity.lineNumber;
            }
            for (int i = this.fEntityStack.size() - 1; i > 0; i--) {
                ScannedEntity firstExternalEntity = (ScannedEntity) this.fEntityStack.elementAt(i);
                if (firstExternalEntity.isExternal()) {
                    return firstExternalEntity.lineNumber;
                }
            }
        }
        return -1;
    }

    public int getColumnNumber() {
        if (this.fCurrentEntity != null) {
            if (this.fCurrentEntity.isExternal()) {
                return this.fCurrentEntity.columnNumber;
            }
            for (int i = this.fEntityStack.size() - 1; i > 0; i--) {
                ScannedEntity firstExternalEntity = (ScannedEntity) this.fEntityStack.elementAt(i);
                if (firstExternalEntity.isExternal()) {
                    return firstExternalEntity.columnNumber;
                }
            }
        }
        return -1;
    }

    protected static String fixURI(String str) {
        str = str.replace(File.separatorChar, '/');
        if (str.length() < 2) {
            return str;
        }
        char ch1 = str.charAt(1);
        if (ch1 == ':') {
            char ch0 = Character.toUpperCase(str.charAt(0));
            if (ch0 < 'A' || ch0 > 'Z') {
                return str;
            }
            return new StringBuffer().append("/").append(str).toString();
        } else if (ch1 == '/' && str.charAt(0) == '/') {
            return new StringBuffer().append("file:").append(str).toString();
        } else {
            return str;
        }
    }

    final void print() {
    }

    public void test() {
        this.fEntityStorage.addExternalEntity("entityUsecase1", null, "/space/home/stax/sun/6thJan2004/zephyr/data/test.txt", "/space/home/stax/sun/6thJan2004/zephyr/data/entity.xml");
        this.fEntityStorage.addInternalEntity("entityUsecase2", "<Test>value</Test>");
        this.fEntityStorage.addInternalEntity("entityUsecase3", "value3");
        this.fEntityStorage.addInternalEntity(TextContent.KIND, "Hello World.");
        this.fEntityStorage.addInternalEntity("empty-element", "<foo/>");
        this.fEntityStorage.addInternalEntity("balanced-element", "<foo></foo>");
        this.fEntityStorage.addInternalEntity("balanced-element-with-text", "<foo>Hello, World</foo>");
        this.fEntityStorage.addInternalEntity("balanced-element-with-entity", "<foo>&text;</foo>");
        this.fEntityStorage.addInternalEntity("unbalanced-entity", "<foo>");
        this.fEntityStorage.addInternalEntity("recursive-entity", "<foo>&recursive-entity2;</foo>");
        this.fEntityStorage.addInternalEntity("recursive-entity2", "<bar>&recursive-entity3;</bar>");
        this.fEntityStorage.addInternalEntity("recursive-entity3", "<baz>&recursive-entity;</baz>");
        this.fEntityStorage.addInternalEntity("ch", "&#x00A9;");
        this.fEntityStorage.addInternalEntity("ch1", "&#84;");
        this.fEntityStorage.addInternalEntity("% ch2", "param");
    }
}
