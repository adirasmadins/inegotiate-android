package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.Entity.ExternalEntity;
import com.amazonaws.javax.xml.stream.Entity.InternalEntity;
import com.amazonaws.javax.xml.stream.Entity.ScannedEntity;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.URI;
import com.amazonaws.javax.xml.stream.xerces.util.URI.MalformedURIException;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.google.common.base.Ascii;
import com.google.gdata.data.Category;
import com.google.gdata.data.docs.FileEntry;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

public class XMLEntityStorage {
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    protected static final String WARN_ON_DUPLICATE_ENTITYDEF = "http://apache.org/xml/features/warn-on-duplicate-entitydef";
    private static char[] gAfterEscaping1;
    private static char[] gAfterEscaping2;
    private static String gEscapedUserDir;
    private static char[] gHexChs;
    private static boolean[] gNeedEscaping;
    private static String gUserDir;
    protected ScannedEntity fCurrentEntity;
    protected Hashtable fEntities;
    private XMLEntityManager fEntityManager;
    protected XMLErrorReporter fErrorReporter;
    protected PropertyManager fPropertyManager;
    protected boolean fWarnDuplicateEntityDef;

    public XMLEntityStorage(PropertyManager propertyManager) {
        this.fEntities = new Hashtable();
        this.fPropertyManager = propertyManager;
    }

    public XMLEntityStorage(XMLEntityManager entityManager) {
        this.fEntities = new Hashtable();
        this.fEntityManager = entityManager;
    }

    public void reset(PropertyManager propertyManager) {
        this.fErrorReporter = (XMLErrorReporter) propertyManager.getProperty(ERROR_REPORTER);
        this.fEntities.clear();
        this.fCurrentEntity = null;
    }

    public void reset() {
        this.fEntities.clear();
        this.fCurrentEntity = null;
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        try {
            this.fWarnDuplicateEntityDef = componentManager.getFeature(WARN_ON_DUPLICATE_ENTITYDEF);
        } catch (XMLConfigurationException e) {
            this.fWarnDuplicateEntityDef = false;
        }
        this.fErrorReporter = (XMLErrorReporter) componentManager.getProperty(ERROR_REPORTER);
        this.fEntities.clear();
        this.fCurrentEntity = null;
    }

    public Hashtable getDeclaredEntities() {
        return this.fEntities;
    }

    public void addInternalEntity(String name, String text) {
        if (!this.fEntities.containsKey(name)) {
            this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
            this.fEntities.put(name, new InternalEntity(name, text, false));
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{name}, (short) 0);
        }
    }

    public void addExternalEntity(String name, String publicId, String literalSystemId, String baseSystemId) {
        if (!this.fEntities.containsKey(name)) {
            if (!(baseSystemId != null || this.fCurrentEntity == null || this.fCurrentEntity.entityLocation == null)) {
                baseSystemId = this.fCurrentEntity.entityLocation.getExpandedSystemId();
            }
            this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
            this.fEntities.put(name, new ExternalEntity(name, new XMLResourceIdentifierImpl(publicId, literalSystemId, baseSystemId, expandSystemId(literalSystemId, baseSystemId)), null, true));
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{name}, (short) 0);
        }
    }

    public boolean isExternalEntity(String entityName) {
        Entity entity = (Entity) this.fEntities.get(entityName);
        if (entity == null) {
            return false;
        }
        return entity.isExternal();
    }

    public boolean isEntityDeclInExternalSubset(String entityName) {
        Entity entity = (Entity) this.fEntities.get(entityName);
        if (entity == null) {
            return false;
        }
        return entity.isEntityDeclInExternalSubset();
    }

    public void addUnparsedEntity(String name, String publicId, String systemId, String baseSystemId, String notation) {
        this.fCurrentEntity = this.fEntityManager.getCurrentEntity();
        if (!this.fEntities.containsKey(name)) {
            this.fEntities.put(name, new ExternalEntity(name, new XMLResourceIdentifierImpl(publicId, systemId, baseSystemId, null), notation, false));
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{name}, (short) 0);
        }
    }

    public boolean isUnparsedEntity(String entityName) {
        Entity entity = (Entity) this.fEntities.get(entityName);
        if (entity == null) {
            return false;
        }
        return entity.isUnparsed();
    }

    public boolean isDeclaredEntity(String entityName) {
        return ((Entity) this.fEntities.get(entityName)) != null;
    }

    public static String expandSystemId(String systemId) {
        return expandSystemId(systemId, null);
    }

    static {
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

    private static synchronized String getUserDir() {
        String userDir;
        synchronized (XMLEntityStorage.class) {
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
}
