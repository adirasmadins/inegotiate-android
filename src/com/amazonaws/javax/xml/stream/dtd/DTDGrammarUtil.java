package com.amazonaws.javax.xml.stream.dtd;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.DTDGrammar;
import com.amazonaws.javax.xml.stream.dtd.nonvalidating.XMLAttributeDecl;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.google.gdata.util.common.base.StringUtil;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;

public class DTDGrammarUtil {
    private static final boolean DEBUG_ATTRIBUTES = false;
    private static final boolean DEBUG_ELEMENT_CHILDREN = false;
    protected static final String NAMESPACES = "http://xml.org/sax/features/namespaces";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    private StringBuffer fBuffer;
    private int fCurrentContentSpecType;
    private int fCurrentElementIndex;
    protected DTDGrammar fDTDGrammar;
    private boolean[] fElementContentState;
    private int fElementDepth;
    private boolean fInCDATASection;
    private boolean fInElementContent;
    private NamespaceContext fNamespaceContext;
    protected boolean fNamespaces;
    protected SymbolTable fSymbolTable;
    private XMLAttributeDecl fTempAttDecl;
    private QName fTempQName;

    public DTDGrammarUtil(SymbolTable symbolTable) {
        this.fDTDGrammar = null;
        this.fSymbolTable = null;
        this.fCurrentElementIndex = -1;
        this.fCurrentContentSpecType = -1;
        this.fInCDATASection = DEBUG_ELEMENT_CHILDREN;
        this.fElementContentState = new boolean[8];
        this.fElementDepth = -1;
        this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
        this.fTempAttDecl = new XMLAttributeDecl();
        this.fTempQName = new QName();
        this.fBuffer = new StringBuffer();
        this.fNamespaceContext = null;
        this.fSymbolTable = symbolTable;
    }

    public DTDGrammarUtil(DTDGrammar grammar, SymbolTable symbolTable) {
        this.fDTDGrammar = null;
        this.fSymbolTable = null;
        this.fCurrentElementIndex = -1;
        this.fCurrentContentSpecType = -1;
        this.fInCDATASection = DEBUG_ELEMENT_CHILDREN;
        this.fElementContentState = new boolean[8];
        this.fElementDepth = -1;
        this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
        this.fTempAttDecl = new XMLAttributeDecl();
        this.fTempQName = new QName();
        this.fBuffer = new StringBuffer();
        this.fNamespaceContext = null;
        this.fDTDGrammar = grammar;
        this.fSymbolTable = symbolTable;
    }

    public DTDGrammarUtil(DTDGrammar grammar, SymbolTable symbolTable, NamespaceContext namespaceContext) {
        this.fDTDGrammar = null;
        this.fSymbolTable = null;
        this.fCurrentElementIndex = -1;
        this.fCurrentContentSpecType = -1;
        this.fInCDATASection = DEBUG_ELEMENT_CHILDREN;
        this.fElementContentState = new boolean[8];
        this.fElementDepth = -1;
        this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
        this.fTempAttDecl = new XMLAttributeDecl();
        this.fTempQName = new QName();
        this.fBuffer = new StringBuffer();
        this.fNamespaceContext = null;
        this.fDTDGrammar = grammar;
        this.fSymbolTable = symbolTable;
        this.fNamespaceContext = namespaceContext;
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        this.fDTDGrammar = null;
        this.fInCDATASection = DEBUG_ELEMENT_CHILDREN;
        this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
        this.fCurrentElementIndex = -1;
        this.fCurrentContentSpecType = -1;
        try {
            this.fNamespaces = componentManager.getFeature(NAMESPACES);
        } catch (XMLConfigurationException e) {
            this.fNamespaces = true;
        }
        this.fSymbolTable = (SymbolTable) componentManager.getProperty(SYMBOL_TABLE);
        this.fElementDepth = -1;
    }

    public void startElement(QName element, XMLAttributes attributes) throws XNIException {
        handleStartElement(element, attributes);
    }

    public void endElement(QName element) throws XNIException {
        handleEndElement(element);
    }

    public void startCDATA(Augmentations augs) throws XNIException {
        this.fInCDATASection = true;
    }

    public void endCDATA(Augmentations augs) throws XNIException {
        this.fInCDATASection = DEBUG_ELEMENT_CHILDREN;
    }

    public void addDTDDefaultAttrs(QName elementName, XMLAttributes attributes) throws XNIException {
        int elementIndex = this.fDTDGrammar.getElementDeclIndex(elementName);
        if (elementIndex != -1 && this.fDTDGrammar != null) {
            int attrCount;
            int i;
            int attlistIndex = this.fDTDGrammar.getFirstAttributeDeclIndex(elementIndex);
            while (attlistIndex != -1) {
                this.fDTDGrammar.getAttributeDecl(attlistIndex, this.fTempAttDecl);
                String attPrefix = this.fTempAttDecl.name.prefix;
                String attLocalpart = this.fTempAttDecl.name.localpart;
                String attRawName = this.fTempAttDecl.name.rawname;
                String attType = getAttributeTypeName(this.fTempAttDecl);
                int attDefaultType = this.fTempAttDecl.simpleType.defaultType;
                String attValue = null;
                if (this.fTempAttDecl.simpleType.defaultValue != null) {
                    attValue = this.fTempAttDecl.simpleType.defaultValue;
                }
                boolean specified = DEBUG_ELEMENT_CHILDREN;
                boolean required = attDefaultType == 2 ? true : DEBUG_ELEMENT_CHILDREN;
                if (!((attType == XMLSymbols.fCDATASymbol ? true : DEBUG_ELEMENT_CHILDREN) && !required && attValue == null)) {
                    if (this.fNamespaceContext != null) {
                        if (attRawName.startsWith(XMLConstants.XMLNS_ATTRIBUTE)) {
                            String prefix = StringUtil.EMPTY_STRING;
                            int pos = attRawName.indexOf(58);
                            if (pos != -1) {
                                prefix = attRawName.substring(0, pos);
                            } else {
                                prefix = attRawName;
                            }
                            prefix = this.fSymbolTable.addSymbol(prefix);
                            if (!((NamespaceSupport) this.fNamespaceContext).containsPrefixInCurrentContext(prefix)) {
                                this.fNamespaceContext.declarePrefix(prefix, attValue);
                            }
                            specified = true;
                        }
                    }
                    attrCount = attributes.getLength();
                    for (i = 0; i < attrCount; i++) {
                        if (attributes.getQName(i) == attRawName) {
                            specified = true;
                            break;
                        }
                    }
                }
                if (!(specified || attValue == null)) {
                    if (this.fNamespaces) {
                        int index = attRawName.indexOf(58);
                        if (index != -1) {
                            attPrefix = this.fSymbolTable.addSymbol(attRawName.substring(0, index));
                            attLocalpart = this.fSymbolTable.addSymbol(attRawName.substring(index + 1));
                        }
                    }
                    this.fTempQName.setValues(attPrefix, attLocalpart, attRawName, this.fTempAttDecl.name.uri);
                    attributes.addAttribute(this.fTempQName, attType, attValue);
                }
                attlistIndex = this.fDTDGrammar.getNextAttributeDeclIndex(attlistIndex);
            }
            attrCount = attributes.getLength();
            for (i = 0; i < attrCount; i++) {
                String attrRawName = attributes.getQName(i);
                boolean declared = DEBUG_ELEMENT_CHILDREN;
                int position = this.fDTDGrammar.getFirstAttributeDeclIndex(elementIndex);
                while (position != -1) {
                    this.fDTDGrammar.getAttributeDecl(position, this.fTempAttDecl);
                    String str = this.fTempAttDecl.name.rawname;
                    if (r0 == attrRawName) {
                        int attDefIndex = position;
                        declared = true;
                        break;
                    }
                    position = this.fDTDGrammar.getNextAttributeDeclIndex(position);
                }
                if (declared) {
                    String type = getAttributeTypeName(this.fTempAttDecl);
                    attributes.setType(i, type);
                    String attrValue = attributes.getValue(i);
                    if (attributes.isSpecified(i) && type != XMLSymbols.fCDATASymbol) {
                        boolean changedByNormalization = normalizeAttrValue(attributes, i);
                        attributes.getValue(i);
                    }
                }
            }
        }
    }

    private boolean normalizeAttrValue(XMLAttributes attributes, int index) {
        boolean leadingSpace = true;
        boolean spaceStart = DEBUG_ELEMENT_CHILDREN;
        boolean readingNonSpace = DEBUG_ELEMENT_CHILDREN;
        int count = 0;
        int eaten = 0;
        String attrValue = attributes.getValue(index);
        char[] attValue = new char[attrValue.length()];
        this.fBuffer.setLength(0);
        attrValue.getChars(0, attrValue.length(), attValue, 0);
        for (int i = 0; i < attValue.length; i++) {
            if (attValue[i] == ' ') {
                if (readingNonSpace) {
                    spaceStart = true;
                    readingNonSpace = DEBUG_ELEMENT_CHILDREN;
                }
                if (spaceStart && !leadingSpace) {
                    spaceStart = DEBUG_ELEMENT_CHILDREN;
                    this.fBuffer.append(attValue[i]);
                    count++;
                } else if (leadingSpace || !spaceStart) {
                    eaten++;
                }
            } else {
                readingNonSpace = true;
                spaceStart = DEBUG_ELEMENT_CHILDREN;
                leadingSpace = DEBUG_ELEMENT_CHILDREN;
                this.fBuffer.append(attValue[i]);
                count++;
            }
        }
        if (count > 0 && this.fBuffer.charAt(count - 1) == ' ') {
            this.fBuffer.setLength(count - 1);
        }
        String newValue = this.fBuffer.toString();
        attributes.setValue(index, newValue);
        if (attrValue.equals(newValue)) {
            return DEBUG_ELEMENT_CHILDREN;
        }
        return true;
    }

    private String getAttributeTypeName(XMLAttributeDecl attrDecl) {
        switch (attrDecl.simpleType.type) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return attrDecl.simpleType.list ? XMLSymbols.fENTITIESSymbol : XMLSymbols.fENTITYSymbol;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                StringBuffer buffer = new StringBuffer();
                buffer.append('(');
                for (int i = 0; i < attrDecl.simpleType.enumeration.length; i++) {
                    if (i > 0) {
                        buffer.append("|");
                    }
                    buffer.append(attrDecl.simpleType.enumeration[i]);
                }
                buffer.append(')');
                return this.fSymbolTable.addSymbol(buffer.toString());
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return XMLSymbols.fIDSymbol;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                return attrDecl.simpleType.list ? XMLSymbols.fIDREFSSymbol : XMLSymbols.fIDREFSymbol;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                return attrDecl.simpleType.list ? XMLSymbols.fNMTOKENSSymbol : XMLSymbols.fNMTOKENSymbol;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                return XMLSymbols.fNOTATIONSymbol;
            default:
                return XMLSymbols.fCDATASymbol;
        }
    }

    private void ensureStackCapacity(int newElementDepth) {
        if (newElementDepth == this.fElementContentState.length) {
            boolean[] newStack = new boolean[(newElementDepth * 2)];
            System.arraycopy(this.fElementContentState, 0, newStack, 0, newElementDepth);
            this.fElementContentState = newStack;
        }
    }

    protected void handleStartElement(QName element, XMLAttributes attributes) throws XNIException {
        boolean z = DEBUG_ELEMENT_CHILDREN;
        if (this.fDTDGrammar == null) {
            this.fCurrentElementIndex = -1;
            this.fCurrentContentSpecType = -1;
            this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
            return;
        }
        this.fCurrentElementIndex = this.fDTDGrammar.getElementDeclIndex(element);
        this.fCurrentContentSpecType = this.fDTDGrammar.getContentSpecType(this.fCurrentElementIndex);
        addDTDDefaultAttrs(element, attributes);
        if (this.fCurrentContentSpecType == 3) {
            z = true;
        }
        this.fInElementContent = z;
        this.fElementDepth++;
        ensureStackCapacity(this.fElementDepth);
        this.fElementContentState[this.fElementDepth] = this.fInElementContent;
    }

    protected void handleEndElement(QName element) throws XNIException {
        this.fElementDepth--;
        if (this.fElementDepth < -1) {
            throw new RuntimeException("FWK008 Element stack underflow");
        } else if (this.fElementDepth < 0) {
            this.fCurrentElementIndex = -1;
            this.fCurrentContentSpecType = -1;
            this.fInElementContent = DEBUG_ELEMENT_CHILDREN;
        } else {
            this.fInElementContent = this.fElementContentState[this.fElementDepth];
        }
    }

    public boolean isInElementContent() {
        return this.fInElementContent;
    }

    public boolean isIgnorableWhiteSpace(XMLString text) {
        if (!isInElementContent()) {
            return DEBUG_ELEMENT_CHILDREN;
        }
        for (int i = text.offset; i < text.offset + text.length; i++) {
            if (!XMLChar.isSpace(text.ch[i])) {
                return DEBUG_ELEMENT_CHILDREN;
            }
        }
        return true;
    }
}
