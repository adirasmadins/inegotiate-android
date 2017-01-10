package com.amazonaws.javax.xml.stream.dtd.nonvalidating;

import com.amazonaws.javax.xml.stream.xerces.util.SymbolTable;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDContentModelSource;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDSource;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class DTDGrammar {
    private static final int CHUNK_MASK = 255;
    private static final int CHUNK_SHIFT = 8;
    private static final int CHUNK_SIZE = 256;
    private static final boolean DEBUG = false;
    private static final int INITIAL_CHUNK_COUNT = 4;
    private static final short LIST_FLAG = (short) 128;
    private static final short LIST_MASK = (short) -129;
    public static final int TOP_LEVEL_SCOPE = -1;
    protected XMLAttributeDecl fAttributeDecl;
    private int fAttributeDeclCount;
    private short[][] fAttributeDeclDefaultType;
    private String[][] fAttributeDeclDefaultValue;
    private String[][][] fAttributeDeclEnumeration;
    private QName[][] fAttributeDeclName;
    private int[][] fAttributeDeclNextAttributeDeclIndex;
    private String[][] fAttributeDeclNonNormalizedDefaultValue;
    private short[][] fAttributeDeclType;
    protected int fCurrentAttributeIndex;
    protected int fCurrentElementIndex;
    protected XMLDTDContentModelSource fDTDContentModelSource;
    protected XMLDTDSource fDTDSource;
    private int fDepth;
    private XMLElementDecl fElementDecl;
    private int fElementDeclCount;
    private int[][] fElementDeclFirstAttributeDeclIndex;
    private int[][] fElementDeclLastAttributeDeclIndex;
    private QName[][] fElementDeclName;
    Hashtable fElementDeclTab;
    private short[][] fElementDeclType;
    private QNameHashtable fElementIndexMap;
    private int fEpsilonIndex;
    private boolean fIsImmutable;
    private int fLeafCount;
    private int[] fNodeIndexStack;
    private short[] fOpStack;
    private int[] fPrevNodeIndexStack;
    private QName fQName;
    private QName fQName2;
    protected boolean fReadingExternalDTD;
    private XMLSimpleType fSimpleType;
    private SymbolTable fSymbolTable;
    int nodeIndex;
    private ArrayList notationDecls;
    int prevNodeIndex;
    int valueIndex;

    protected static final class QNameHashtable {
        private static final int HASHTABLE_SIZE = 101;
        private static final int INITIAL_BUCKET_SIZE = 4;
        public static final boolean UNIQUE_STRINGS = true;
        private Object[][] fHashTable;

        protected QNameHashtable() {
            this.fHashTable = new Object[HASHTABLE_SIZE][];
        }

        public void put(String key, int value) {
            int hash = (hash(key) + 2) % HASHTABLE_SIZE;
            Object[] bucket = this.fHashTable[hash];
            if (bucket == null) {
                bucket = new Object[9];
                bucket[0] = new int[]{1};
                bucket[1] = key;
                bucket[2] = new int[]{value};
                this.fHashTable[hash] = bucket;
                return;
            }
            int count = ((int[]) bucket[0])[0];
            int offset = (count * 2) + 1;
            if (offset == bucket.length) {
                Object[] newBucket = new Object[(((count + INITIAL_BUCKET_SIZE) * 2) + 1)];
                System.arraycopy(bucket, 0, newBucket, 0, offset);
                bucket = newBucket;
                this.fHashTable[hash] = bucket;
            }
            boolean found = DTDGrammar.DEBUG;
            int j = 1;
            for (int i = 0; i < count; i++) {
                if (((String) bucket[j]) == key) {
                    ((int[]) bucket[j + 1])[0] = value;
                    found = UNIQUE_STRINGS;
                    break;
                }
                j += 2;
            }
            if (!found) {
                int offset2 = offset + 1;
                bucket[offset] = key;
                bucket[offset2] = new int[]{value};
                ((int[]) bucket[0])[0] = count + 1;
            }
        }

        public int get(String key) {
            Object[] bucket = this.fHashTable[(hash(key) + 2) % HASHTABLE_SIZE];
            if (bucket == null) {
                return DTDGrammar.TOP_LEVEL_SCOPE;
            }
            int count = ((int[]) bucket[0])[0];
            int j = 1;
            for (int i = 0; i < count; i++) {
                if (((String) bucket[j]) == key) {
                    return ((int[]) bucket[j + 1])[0];
                }
                j += 2;
            }
            return DTDGrammar.TOP_LEVEL_SCOPE;
        }

        protected int hash(String symbol) {
            if (symbol == null) {
                return 0;
            }
            int code = 0;
            for (int i = 0; i < symbol.length(); i++) {
                code = (code * 37) + symbol.charAt(i);
            }
            return 134217727 & code;
        }
    }

    public DTDGrammar(SymbolTable symbolTable) {
        this.fDTDSource = null;
        this.fDTDContentModelSource = null;
        this.fReadingExternalDTD = DEBUG;
        this.notationDecls = new ArrayList();
        this.fElementDeclCount = 0;
        this.fElementDeclName = new QName[INITIAL_CHUNK_COUNT][];
        this.fElementDeclType = new short[INITIAL_CHUNK_COUNT][];
        this.fElementDeclFirstAttributeDeclIndex = new int[INITIAL_CHUNK_COUNT][];
        this.fElementDeclLastAttributeDeclIndex = new int[INITIAL_CHUNK_COUNT][];
        this.fAttributeDeclCount = 0;
        this.fAttributeDeclName = new QName[INITIAL_CHUNK_COUNT][];
        this.fIsImmutable = DEBUG;
        this.fAttributeDeclType = new short[INITIAL_CHUNK_COUNT][];
        this.fAttributeDeclEnumeration = new String[INITIAL_CHUNK_COUNT][][];
        this.fAttributeDeclDefaultType = new short[INITIAL_CHUNK_COUNT][];
        this.fAttributeDeclDefaultValue = new String[INITIAL_CHUNK_COUNT][];
        this.fAttributeDeclNonNormalizedDefaultValue = new String[INITIAL_CHUNK_COUNT][];
        this.fAttributeDeclNextAttributeDeclIndex = new int[INITIAL_CHUNK_COUNT][];
        this.fElementIndexMap = new QNameHashtable();
        this.fQName = new QName();
        this.fQName2 = new QName();
        this.fAttributeDecl = new XMLAttributeDecl();
        this.fLeafCount = 0;
        this.fEpsilonIndex = TOP_LEVEL_SCOPE;
        this.fElementDecl = new XMLElementDecl();
        this.fSimpleType = new XMLSimpleType();
        this.fElementDeclTab = new Hashtable();
        this.fOpStack = null;
        this.fNodeIndexStack = null;
        this.fPrevNodeIndexStack = null;
        this.fDepth = 0;
        this.valueIndex = TOP_LEVEL_SCOPE;
        this.prevNodeIndex = TOP_LEVEL_SCOPE;
        this.nodeIndex = TOP_LEVEL_SCOPE;
        this.fSymbolTable = symbolTable;
    }

    public int getAttributeDeclIndex(int elementDeclIndex, String attributeDeclName) {
        if (elementDeclIndex == TOP_LEVEL_SCOPE) {
            return TOP_LEVEL_SCOPE;
        }
        int attDefIndex = getFirstAttributeDeclIndex(elementDeclIndex);
        while (attDefIndex != TOP_LEVEL_SCOPE) {
            getAttributeDecl(attDefIndex, this.fAttributeDecl);
            if (this.fAttributeDecl.name.rawname == attributeDeclName || attributeDeclName.equals(this.fAttributeDecl.name.rawname)) {
                return attDefIndex;
            }
            attDefIndex = getNextAttributeDeclIndex(attDefIndex);
        }
        return TOP_LEVEL_SCOPE;
    }

    public void startDTD(XMLLocator locator, Augmentations augs) throws XNIException {
        this.fOpStack = null;
        this.fNodeIndexStack = null;
        this.fPrevNodeIndexStack = null;
    }

    public void elementDecl(String name, String contentModel, Augmentations augs) throws XNIException {
        XMLElementDecl tmpElementDecl = (XMLElementDecl) this.fElementDeclTab.get(name);
        if (tmpElementDecl == null) {
            this.fCurrentElementIndex = createElementDecl();
        } else if (tmpElementDecl.type == (short) -1) {
            this.fCurrentElementIndex = getElementDeclIndex(name);
        } else {
            return;
        }
        XMLElementDecl elementDecl = new XMLElementDecl();
        elementDecl.name.setValues(new QName(null, name, name, null));
        elementDecl.scope = TOP_LEVEL_SCOPE;
        if (contentModel.equals("EMPTY")) {
            elementDecl.type = (short) 1;
        } else if (contentModel.equals("ANY")) {
            elementDecl.type = (short) 0;
        } else if (contentModel.startsWith("(")) {
            if (contentModel.indexOf("#PCDATA") > 0) {
                elementDecl.type = (short) 2;
            } else {
                elementDecl.type = (short) 3;
            }
        }
        this.fElementDeclTab.put(name, elementDecl);
        this.fElementDecl = elementDecl;
        setElementDecl(this.fCurrentElementIndex, this.fElementDecl);
        int index = this.fCurrentElementIndex & CHUNK_MASK;
        ensureElementDeclCapacity(this.fCurrentElementIndex >> CHUNK_SHIFT);
    }

    public void attributeDecl(String elementName, String attributeName, String type, String[] enumeration, String defaultType, XMLString defaultValue, XMLString nonNormalizedDefaultValue, Augmentations augs) throws XNIException {
        if (!(type == XMLSymbols.fCDATASymbol || defaultValue == null)) {
            normalizeDefaultAttrValue(defaultValue);
        }
        if (!this.fElementDeclTab.containsKey(elementName)) {
            this.fCurrentElementIndex = createElementDecl();
            XMLElementDecl elementDecl = new XMLElementDecl();
            elementDecl.name.setValues(null, elementName, elementName, null);
            elementDecl.scope = TOP_LEVEL_SCOPE;
            this.fElementDeclTab.put(elementName, elementDecl);
            setElementDecl(this.fCurrentElementIndex, elementDecl);
        }
        int elementIndex = getElementDeclIndex(elementName);
        if (getAttributeDeclIndex(elementIndex, attributeName) == TOP_LEVEL_SCOPE) {
            this.fCurrentAttributeIndex = createAttributeDecl();
            this.fSimpleType.clear();
            if (defaultType != null) {
                XMLSimpleType xMLSimpleType;
                XMLSimpleType xMLSimpleType2;
                if (defaultType.equals("#FIXED")) {
                    xMLSimpleType = this.fSimpleType;
                    xMLSimpleType2 = this.fSimpleType;
                    xMLSimpleType.defaultType = (short) 1;
                } else if (defaultType.equals("#IMPLIED")) {
                    xMLSimpleType = this.fSimpleType;
                    xMLSimpleType2 = this.fSimpleType;
                    xMLSimpleType.defaultType = (short) 0;
                } else if (defaultType.equals("#REQUIRED")) {
                    xMLSimpleType = this.fSimpleType;
                    xMLSimpleType2 = this.fSimpleType;
                    xMLSimpleType.defaultType = (short) 2;
                }
            }
            this.fSimpleType.defaultValue = defaultValue != null ? defaultValue.toString() : null;
            this.fSimpleType.nonNormalizedDefaultValue = nonNormalizedDefaultValue != null ? nonNormalizedDefaultValue.toString() : null;
            this.fSimpleType.enumeration = enumeration;
            if (type.equals("CDATA")) {
                this.fSimpleType.type = (short) 0;
            } else if (type.equals("ID")) {
                this.fSimpleType.type = (short) 3;
            } else if (type.startsWith("IDREF")) {
                this.fSimpleType.type = (short) 4;
                if (type.indexOf("S") > 0) {
                    this.fSimpleType.list = true;
                }
            } else if (type.equals("ENTITIES")) {
                this.fSimpleType.type = (short) 1;
                this.fSimpleType.list = true;
            } else if (type.equals("ENTITY")) {
                this.fSimpleType.type = (short) 1;
            } else if (type.equals("NMTOKENS")) {
                this.fSimpleType.type = (short) 5;
                this.fSimpleType.list = true;
            } else if (type.equals("NMTOKEN")) {
                this.fSimpleType.type = (short) 5;
            } else if (type.startsWith("NOTATION")) {
                this.fSimpleType.type = (short) 6;
            } else if (type.startsWith("ENUMERATION")) {
                this.fSimpleType.type = (short) 2;
            } else {
                System.err.println(new StringBuffer().append("!!! unknown attribute type ").append(type).toString());
            }
            this.fQName.setValues(null, attributeName, attributeName, null);
            this.fAttributeDecl.setValues(this.fQName, this.fSimpleType, DEBUG);
            setAttributeDecl(elementIndex, this.fCurrentAttributeIndex, this.fAttributeDecl);
            int index = this.fCurrentAttributeIndex & CHUNK_MASK;
            ensureAttributeDeclCapacity(this.fCurrentAttributeIndex >> CHUNK_SHIFT);
        }
    }

    public SymbolTable getSymbolTable() {
        return this.fSymbolTable;
    }

    public int getFirstElementDeclIndex() {
        return this.fElementDeclCount >= 0 ? 0 : TOP_LEVEL_SCOPE;
    }

    public int getNextElementDeclIndex(int elementDeclIndex) {
        return elementDeclIndex < this.fElementDeclCount + TOP_LEVEL_SCOPE ? elementDeclIndex + 1 : TOP_LEVEL_SCOPE;
    }

    public int getElementDeclIndex(String elementDeclName) {
        return this.fElementIndexMap.get(elementDeclName);
    }

    public int getElementDeclIndex(QName elementDeclQName) {
        return getElementDeclIndex(elementDeclQName.rawname);
    }

    public short getContentSpecType(int elementIndex) {
        if (elementIndex < 0 || elementIndex >= this.fElementDeclCount) {
            return (short) -1;
        }
        int chunk = elementIndex >> CHUNK_SHIFT;
        int index = elementIndex & CHUNK_MASK;
        if (this.fElementDeclType[chunk][index] != (short) -1) {
            return (short) (this.fElementDeclType[chunk][index] & -129);
        }
        return (short) -1;
    }

    public boolean getElementDecl(int elementDeclIndex, XMLElementDecl elementDecl) {
        boolean z = DEBUG;
        if (elementDeclIndex < 0 || elementDeclIndex >= this.fElementDeclCount) {
            return DEBUG;
        }
        int chunk = elementDeclIndex >> CHUNK_SHIFT;
        int index = elementDeclIndex & CHUNK_MASK;
        elementDecl.name.setValues(this.fElementDeclName[chunk][index]);
        if (this.fElementDeclType[chunk][index] == (short) -1) {
            elementDecl.type = (short) -1;
            elementDecl.simpleType.list = DEBUG;
        } else {
            elementDecl.type = (short) (this.fElementDeclType[chunk][index] & -129);
            XMLSimpleType xMLSimpleType = elementDecl.simpleType;
            if ((this.fElementDeclType[chunk][index] & XMLChar.MASK_NCNAME) != 0) {
                z = true;
            }
            xMLSimpleType.list = z;
        }
        elementDecl.simpleType.defaultType = (short) -1;
        elementDecl.simpleType.defaultValue = null;
        return true;
    }

    public int getFirstAttributeDeclIndex(int elementDeclIndex) {
        return this.fElementDeclFirstAttributeDeclIndex[elementDeclIndex >> CHUNK_SHIFT][elementDeclIndex & CHUNK_MASK];
    }

    public int getNextAttributeDeclIndex(int attributeDeclIndex) {
        return this.fAttributeDeclNextAttributeDeclIndex[attributeDeclIndex >> CHUNK_SHIFT][attributeDeclIndex & CHUNK_MASK];
    }

    public boolean getAttributeDecl(int attributeDeclIndex, XMLAttributeDecl attributeDecl) {
        boolean isList = DEBUG;
        if (attributeDeclIndex < 0 || attributeDeclIndex >= this.fAttributeDeclCount) {
            return DEBUG;
        }
        short attributeType;
        int chunk = attributeDeclIndex >> CHUNK_SHIFT;
        int index = attributeDeclIndex & CHUNK_MASK;
        attributeDecl.name.setValues(this.fAttributeDeclName[chunk][index]);
        if (this.fAttributeDeclType[chunk][index] == (short) -1) {
            attributeType = (short) -1;
            isList = DEBUG;
        } else {
            attributeType = (short) (this.fAttributeDeclType[chunk][index] & -129);
            if ((this.fAttributeDeclType[chunk][index] & XMLChar.MASK_NCNAME) != 0) {
                isList = true;
            }
        }
        attributeDecl.simpleType.setValues(attributeType, this.fAttributeDeclName[chunk][index].localpart, this.fAttributeDeclEnumeration[chunk][index], isList, this.fAttributeDeclDefaultType[chunk][index], this.fAttributeDeclDefaultValue[chunk][index], this.fAttributeDeclNonNormalizedDefaultValue[chunk][index]);
        return true;
    }

    public boolean isCDATAAttribute(QName elName, QName atName) {
        int elDeclIdx = getElementDeclIndex(elName);
        int atDeclIdx = getAttributeDeclIndex(elDeclIdx, atName.rawname);
        if (!getAttributeDecl(elDeclIdx, this.fAttributeDecl) || this.fAttributeDecl.simpleType.type == (short) 0) {
            return true;
        }
        return DEBUG;
    }

    public void printElements() {
        int elementDeclIndex = 0;
        XMLElementDecl elementDecl = new XMLElementDecl();
        while (true) {
            int elementDeclIndex2 = elementDeclIndex + 1;
            if (getElementDecl(elementDeclIndex, elementDecl)) {
                System.out.println(new StringBuffer().append("element decl: ").append(elementDecl.name).append(", ").append(elementDecl.name.rawname).toString());
                elementDeclIndex = elementDeclIndex2;
            } else {
                return;
            }
        }
    }

    public void printAttributes(int elementDeclIndex) {
        int attributeDeclIndex = getFirstAttributeDeclIndex(elementDeclIndex);
        System.out.print(elementDeclIndex);
        System.out.print(" [");
        while (attributeDeclIndex != TOP_LEVEL_SCOPE) {
            System.out.print(' ');
            System.out.print(attributeDeclIndex);
            printAttribute(attributeDeclIndex);
            attributeDeclIndex = getNextAttributeDeclIndex(attributeDeclIndex);
            if (attributeDeclIndex != TOP_LEVEL_SCOPE) {
                System.out.print(",");
            }
        }
        System.out.println(" ]");
    }

    protected int createElementDecl() {
        int chunk = this.fElementDeclCount >> CHUNK_SHIFT;
        int index = this.fElementDeclCount & CHUNK_MASK;
        ensureElementDeclCapacity(chunk);
        this.fElementDeclName[chunk][index] = new QName();
        this.fElementDeclType[chunk][index] = TOP_LEVEL_SCOPE;
        this.fElementDeclFirstAttributeDeclIndex[chunk][index] = TOP_LEVEL_SCOPE;
        this.fElementDeclLastAttributeDeclIndex[chunk][index] = TOP_LEVEL_SCOPE;
        int i = this.fElementDeclCount;
        this.fElementDeclCount = i + 1;
        return i;
    }

    protected void setElementDecl(int elementDeclIndex, XMLElementDecl elementDecl) {
        if (elementDeclIndex >= 0 && elementDeclIndex < this.fElementDeclCount) {
            int chunk = elementDeclIndex >> CHUNK_SHIFT;
            int index = elementDeclIndex & CHUNK_MASK;
            int scope = elementDecl.scope;
            this.fElementDeclName[chunk][index].setValues(elementDecl.name);
            this.fElementDeclType[chunk][index] = elementDecl.type;
            if (elementDecl.simpleType.list) {
                short[] sArr = this.fElementDeclType[chunk];
                sArr[index] = (short) (sArr[index] | XMLChar.MASK_NCNAME);
            }
            this.fElementIndexMap.put(elementDecl.name.rawname, elementDeclIndex);
        }
    }

    protected void setFirstAttributeDeclIndex(int elementDeclIndex, int newFirstAttrIndex) {
        if (elementDeclIndex >= 0 && elementDeclIndex < this.fElementDeclCount) {
            int index = elementDeclIndex & CHUNK_MASK;
            this.fElementDeclFirstAttributeDeclIndex[elementDeclIndex >> CHUNK_SHIFT][index] = newFirstAttrIndex;
        }
    }

    protected int createAttributeDecl() {
        int chunk = this.fAttributeDeclCount >> CHUNK_SHIFT;
        int index = this.fAttributeDeclCount & CHUNK_MASK;
        ensureAttributeDeclCapacity(chunk);
        this.fAttributeDeclName[chunk][index] = new QName();
        this.fAttributeDeclType[chunk][index] = TOP_LEVEL_SCOPE;
        this.fAttributeDeclEnumeration[chunk][index] = null;
        this.fAttributeDeclDefaultType[chunk][index] = (short) 0;
        this.fAttributeDeclDefaultValue[chunk][index] = null;
        this.fAttributeDeclNonNormalizedDefaultValue[chunk][index] = null;
        this.fAttributeDeclNextAttributeDeclIndex[chunk][index] = TOP_LEVEL_SCOPE;
        int i = this.fAttributeDeclCount;
        this.fAttributeDeclCount = i + 1;
        return i;
    }

    protected void setAttributeDecl(int elementDeclIndex, int attributeDeclIndex, XMLAttributeDecl attributeDecl) {
        int attrChunk = attributeDeclIndex >> CHUNK_SHIFT;
        int attrIndex = attributeDeclIndex & CHUNK_MASK;
        this.fAttributeDeclName[attrChunk][attrIndex].setValues(attributeDecl.name);
        this.fAttributeDeclType[attrChunk][attrIndex] = attributeDecl.simpleType.type;
        if (attributeDecl.simpleType.list) {
            short[] sArr = this.fAttributeDeclType[attrChunk];
            sArr[attrIndex] = (short) (sArr[attrIndex] | XMLChar.MASK_NCNAME);
        }
        this.fAttributeDeclEnumeration[attrChunk][attrIndex] = attributeDecl.simpleType.enumeration;
        this.fAttributeDeclDefaultType[attrChunk][attrIndex] = attributeDecl.simpleType.defaultType;
        this.fAttributeDeclDefaultValue[attrChunk][attrIndex] = attributeDecl.simpleType.defaultValue;
        this.fAttributeDeclNonNormalizedDefaultValue[attrChunk][attrIndex] = attributeDecl.simpleType.nonNormalizedDefaultValue;
        int elemChunk = elementDeclIndex >> CHUNK_SHIFT;
        int elemIndex = elementDeclIndex & CHUNK_MASK;
        int index = this.fElementDeclFirstAttributeDeclIndex[elemChunk][elemIndex];
        while (index != TOP_LEVEL_SCOPE && index != attributeDeclIndex) {
            attrIndex = index & CHUNK_MASK;
            index = this.fAttributeDeclNextAttributeDeclIndex[index >> CHUNK_SHIFT][attrIndex];
        }
        if (index == TOP_LEVEL_SCOPE) {
            if (this.fElementDeclFirstAttributeDeclIndex[elemChunk][elemIndex] == TOP_LEVEL_SCOPE) {
                this.fElementDeclFirstAttributeDeclIndex[elemChunk][elemIndex] = attributeDeclIndex;
            } else {
                index = this.fElementDeclLastAttributeDeclIndex[elemChunk][elemIndex];
                attrIndex = index & CHUNK_MASK;
                this.fAttributeDeclNextAttributeDeclIndex[index >> CHUNK_SHIFT][attrIndex] = attributeDeclIndex;
            }
            this.fElementDeclLastAttributeDeclIndex[elemChunk][elemIndex] = attributeDeclIndex;
        }
    }

    public void notationDecl(String name, XMLResourceIdentifier identifier, Augmentations augs) throws XNIException {
        XMLNotationDecl notationDecl = new XMLNotationDecl();
        notationDecl.setValues(name, identifier.getPublicId(), identifier.getLiteralSystemId(), identifier.getBaseSystemId());
        this.notationDecls.add(notationDecl);
    }

    public List getNotationDecls() {
        return this.notationDecls;
    }

    private void printAttribute(int attributeDeclIndex) {
        XMLAttributeDecl attributeDecl = new XMLAttributeDecl();
        if (getAttributeDecl(attributeDeclIndex, attributeDecl)) {
            System.out.print(" { ");
            System.out.print(attributeDecl.name.localpart);
            System.out.print(" }");
        }
    }

    private void ensureElementDeclCapacity(int chunk) {
        if (chunk >= this.fElementDeclName.length) {
            this.fElementDeclName = resize(this.fElementDeclName, this.fElementDeclName.length * 2);
            this.fElementDeclType = resize(this.fElementDeclType, this.fElementDeclType.length * 2);
            this.fElementDeclFirstAttributeDeclIndex = resize(this.fElementDeclFirstAttributeDeclIndex, this.fElementDeclFirstAttributeDeclIndex.length * 2);
            this.fElementDeclLastAttributeDeclIndex = resize(this.fElementDeclLastAttributeDeclIndex, this.fElementDeclLastAttributeDeclIndex.length * 2);
        } else if (this.fElementDeclName[chunk] != null) {
            return;
        }
        this.fElementDeclName[chunk] = new QName[CHUNK_SIZE];
        this.fElementDeclType[chunk] = new short[CHUNK_SIZE];
        this.fElementDeclFirstAttributeDeclIndex[chunk] = new int[CHUNK_SIZE];
        this.fElementDeclLastAttributeDeclIndex[chunk] = new int[CHUNK_SIZE];
    }

    private void ensureAttributeDeclCapacity(int chunk) {
        if (chunk >= this.fAttributeDeclName.length) {
            this.fAttributeDeclName = resize(this.fAttributeDeclName, this.fAttributeDeclName.length * 2);
            this.fAttributeDeclType = resize(this.fAttributeDeclType, this.fAttributeDeclType.length * 2);
            this.fAttributeDeclEnumeration = resize(this.fAttributeDeclEnumeration, this.fAttributeDeclEnumeration.length * 2);
            this.fAttributeDeclDefaultType = resize(this.fAttributeDeclDefaultType, this.fAttributeDeclDefaultType.length * 2);
            this.fAttributeDeclDefaultValue = resize(this.fAttributeDeclDefaultValue, this.fAttributeDeclDefaultValue.length * 2);
            this.fAttributeDeclNonNormalizedDefaultValue = resize(this.fAttributeDeclNonNormalizedDefaultValue, this.fAttributeDeclNonNormalizedDefaultValue.length * 2);
            this.fAttributeDeclNextAttributeDeclIndex = resize(this.fAttributeDeclNextAttributeDeclIndex, this.fAttributeDeclNextAttributeDeclIndex.length * 2);
        } else if (this.fAttributeDeclName[chunk] != null) {
            return;
        }
        this.fAttributeDeclName[chunk] = new QName[CHUNK_SIZE];
        this.fAttributeDeclType[chunk] = new short[CHUNK_SIZE];
        this.fAttributeDeclEnumeration[chunk] = new String[CHUNK_SIZE][];
        this.fAttributeDeclDefaultType[chunk] = new short[CHUNK_SIZE];
        this.fAttributeDeclDefaultValue[chunk] = new String[CHUNK_SIZE];
        this.fAttributeDeclNonNormalizedDefaultValue[chunk] = new String[CHUNK_SIZE];
        this.fAttributeDeclNextAttributeDeclIndex[chunk] = new int[CHUNK_SIZE];
    }

    private static byte[][] resize(byte[][] array, int newsize) {
        byte[][] newarray = new byte[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static short[][] resize(short[][] array, int newsize) {
        short[][] newarray = new short[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static int[][] resize(int[][] array, int newsize) {
        int[][] newarray = new int[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static Object[][] resize(Object[][] array, int newsize) {
        Object[][] newarray = new Object[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static QName[][] resize(QName[][] array, int newsize) {
        QName[][] newarray = new QName[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static String[][] resize(String[][] array, int newsize) {
        String[][] newarray = new String[newsize][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private static String[][][] resize(String[][][] array, int newsize) {
        String[][][] newarray = new String[newsize][][];
        System.arraycopy(array, 0, newarray, 0, array.length);
        return newarray;
    }

    private boolean normalizeDefaultAttrValue(XMLString value) {
        int oldLength = value.length;
        boolean skipSpace = true;
        int current = value.offset;
        int end = value.offset + value.length;
        int i = value.offset;
        int current2 = current;
        while (i < end) {
            if (value.ch[i] != ' ') {
                if (current2 != i) {
                    value.ch[current2] = value.ch[i];
                }
                current = current2 + 1;
                skipSpace = DEBUG;
            } else if (skipSpace) {
                current = current2;
            } else {
                current = current2 + 1;
                value.ch[current2] = ' ';
                skipSpace = true;
            }
            i++;
            current2 = current;
        }
        if (current2 != end) {
            if (skipSpace) {
                current = current2 + TOP_LEVEL_SCOPE;
            } else {
                current = current2;
            }
            value.length = current - value.offset;
            return true;
        }
        current = current2;
        return DEBUG;
    }

    public void endDTD(Augmentations augs) throws XNIException {
    }
}
