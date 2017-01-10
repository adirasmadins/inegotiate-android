package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLAttributes;
import com.google.gdata.util.common.base.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class STAXAttributesImpl implements XMLAttributes {
    int MAGIC_NUMBER;
    protected ArrayList attrList;
    protected HashMap attrMap;
    int attr_index;
    protected ArrayList dupList;
    protected boolean fNamespaces;
    private boolean init;

    class Attribute {
        public boolean dup;
        public QName name;
        Attribute next;
        public String nonNormalizedValue;
        public boolean schemaId;
        public boolean specified;
        public String type;
        public String value;

        Attribute() {
            this.name = new QName();
            this.dup = false;
        }
    }

    public STAXAttributesImpl() {
        this.attr_index = 0;
        this.MAGIC_NUMBER = 2;
        this.fNamespaces = true;
        this.attrList = null;
        this.dupList = null;
        this.init = false;
        this.attrMap = null;
        this.attrList = new ArrayList(2);
        for (int i = 0; i < 2; i++) {
            Attribute attr = new Attribute();
            attr.name = new QName();
            this.attrList.add(i, attr);
        }
    }

    public STAXAttributesImpl(int tableSize) {
        this.attr_index = 0;
        this.MAGIC_NUMBER = 2;
        this.fNamespaces = true;
        this.attrList = null;
        this.dupList = null;
        this.init = false;
        this.attrMap = null;
        this.attrList = new ArrayList(tableSize);
        this.attrMap = new HashMap();
    }

    public void setNamespaces(boolean namespaces) {
        this.fNamespaces = namespaces;
    }

    public int addAttribute(QName name, String type, String value) {
        Attribute attr;
        if (this.attr_index >= this.attrList.size()) {
            attr = new Attribute();
            attr.name = new QName();
            this.attrList.add(attr);
            attr.next = null;
        } else {
            attr = (Attribute) this.attrList.get(this.attr_index);
            attr.next = null;
        }
        attr.name.setValues(name);
        attr.type = type;
        attr.value = value;
        int i;
        Attribute tmp;
        if (this.attr_index < 5) {
            for (i = 0; i < this.attr_index; i++) {
                tmp = (Attribute) this.attrList.get(i);
                if (tmp.name.rawname == name.rawname) {
                    tmp.value = value;
                    return i;
                }
            }
        } else {
            if (!this.init) {
                if (this.attrMap == null) {
                    this.attrMap = new HashMap(2, 2.0f);
                }
                for (i = 0; i < this.attr_index; i++) {
                    tmp = (Attribute) this.attrList.get(i);
                    this.attrMap.put(tmp.name.rawname, tmp);
                }
                this.init = true;
            }
            if (this.attrMap.containsKey(name.rawname)) {
                return getLength();
            }
            this.attrMap.put(name.rawname, attr);
        }
        this.attr_index++;
        return getLength() - 1;
    }

    public void removeAllAttributes() {
        this.attr_index = 0;
        if (this.attrMap != null) {
            this.attrMap.clear();
        }
        if (this.dupList != null) {
            this.dupList.clear();
        }
        this.init = false;
    }

    public void removeAttributeAt(int attrIndex) {
        Attribute attr = (Attribute) this.attrList.remove(attrIndex);
    }

    public void setName(int attrIndex, QName attrName) {
        ((Attribute) this.attrList.get(attrIndex)).name.setValues(attrName);
    }

    public void getName(int attrIndex, QName attrName) {
        attrName.setValues(((Attribute) this.attrList.get(attrIndex)).name);
    }

    public void setType(int attrIndex, String attrType) {
        ((Attribute) this.attrList.get(attrIndex)).type = attrType;
    }

    public void setValue(int attrIndex, String attrValue) {
        if (attrIndex <= this.attr_index) {
            Attribute attribute = (Attribute) this.attrList.get(attrIndex);
            attribute.value = attrValue;
            attribute.nonNormalizedValue = attrValue;
        }
    }

    public void setNonNormalizedValue(int attrIndex, String attrValue) {
        ((Attribute) this.attrList.get(attrIndex)).nonNormalizedValue = attrValue;
    }

    public String getNonNormalizedValue(int attrIndex) {
        return ((Attribute) this.attrList.get(attrIndex)).nonNormalizedValue;
    }

    public void setSpecified(int attrIndex, boolean specified) {
        ((Attribute) this.attrList.get(attrIndex)).specified = specified;
    }

    public boolean isSpecified(int attrIndex) {
        return ((Attribute) this.attrList.get(attrIndex)).specified;
    }

    public int getLength() {
        return this.attr_index;
    }

    public String getType(int index) {
        if (index < 0 || index >= this.attrList.size()) {
            return null;
        }
        return getReportableType(((Attribute) this.attrList.get(index)).type);
    }

    public String getType(String qname) {
        return null;
    }

    public String getValue(int index) {
        return ((Attribute) this.attrList.get(index)).value;
    }

    public String getValue(String qname) {
        return null;
    }

    public String getName(int index) {
        if (index < 0 || index >= this.attrList.size()) {
            return null;
        }
        return ((Attribute) this.attrList.get(index)).name.rawname;
    }

    public int getIndex(String qName) {
        for (int i = 0; i < this.attr_index; i++) {
            Attribute attribute = (Attribute) this.attrList.get(i);
            if (attribute.name.rawname != null && attribute.name.rawname.equals(qName)) {
                return i;
            }
        }
        return -1;
    }

    public int getIndex(String uri, String localPart) {
        for (int i = 0; i < this.attr_index; i++) {
            Attribute attribute = (Attribute) this.attrList.get(i);
            if (attribute.name.localpart != null && attribute.name.localpart.equals(localPart)) {
                if (uri == attribute.name.uri) {
                    return i;
                }
                if (!(uri == null || attribute.name.uri == null || !attribute.name.uri.equals(uri))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public String getLocalName(int index) {
        if (this.fNamespaces) {
            return ((Attribute) this.attrList.get(index)).name.localpart;
        }
        return StringUtil.EMPTY_STRING;
    }

    public String getQName(int index) {
        return ((Attribute) this.attrList.get(index)).name.rawname;
    }

    public QName getQualifiedName(int index) {
        return ((Attribute) this.attrList.get(index)).name;
    }

    public String getType(String uri, String localName) {
        if (!this.fNamespaces) {
            return null;
        }
        int index = getIndex(uri, localName);
        if (index != -1) {
            return getReportableType(((Attribute) this.attrList.get(index)).type);
        }
        return null;
    }

    public String getPrefix(int index) {
        return ((Attribute) this.attrList.get(index)).name.prefix;
    }

    public String getURI(int index) {
        return ((Attribute) this.attrList.get(index)).name.uri;
    }

    public String getValue(String uri, String localName) {
        int index = getIndex(uri, localName);
        return index != -1 ? getValue(index) : null;
    }

    public Augmentations getAugmentations(String uri, String localName) {
        return null;
    }

    public Augmentations getAugmentations(String qName) {
        return null;
    }

    public Augmentations getAugmentations(int attributeIndex) {
        return null;
    }

    public void setAugmentations(int attrIndex, Augmentations augs) {
    }

    public void setURI(int attrIndex, String uri) {
        ((Attribute) this.attrList.get(attrIndex)).name.uri = uri;
    }

    public void setSchemaId(int attrIndex, boolean schemaId) {
    }

    public boolean getSchemaId(int index) {
        return false;
    }

    public boolean getSchemaId(String qname) {
        return false;
    }

    public boolean getSchemaId(String uri, String localName) {
        return false;
    }

    public void addAttributeNS(QName name, String type, String value) {
        Attribute attr;
        if (this.attr_index >= this.attrList.size()) {
            attr = new Attribute();
            attr.name = new QName();
            this.attrList.add(attr);
            attr.next = null;
        } else {
            attr = (Attribute) this.attrList.get(this.attr_index);
            attr.next = null;
        }
        attr.name.setValues(name);
        attr.type = type;
        attr.value = value;
        if (this.attr_index > this.MAGIC_NUMBER) {
            if (!this.init) {
                if (this.attrMap == null) {
                    this.attrMap = new HashMap(2, 2.0f);
                }
                for (int i = 0; i < this.attr_index; i++) {
                    Attribute tmp = (Attribute) this.attrList.get(i);
                    this.attrMap.put(tmp.name.localpart, tmp);
                }
                this.init = true;
            }
            if (this.attrMap.containsKey(name.localpart)) {
                Attribute obj = (Attribute) this.attrMap.get(name.localpart);
                attr.next = obj.next;
                obj.next = attr;
                this.attr_index++;
                if (!obj.dup) {
                    if (this.dupList == null) {
                        this.dupList = new ArrayList();
                    }
                    this.dupList.add(attr);
                    obj.dup = true;
                    return;
                }
                return;
            }
            this.attrMap.put(name.localpart, attr);
            this.attr_index++;
            return;
        }
        this.attr_index++;
    }

    public QName checkDuplicatesNS() {
        int i;
        Attribute att1;
        Attribute att2;
        if (this.attr_index <= this.MAGIC_NUMBER) {
            for (i = 0; i < this.attr_index - 1; i++) {
                att1 = (Attribute) this.attrList.get(i);
                for (int j = i + 1; j < this.attr_index; j++) {
                    att2 = (Attribute) this.attrList.get(j);
                    if (att1.name.localpart == att2.name.localpart && att1.name.uri == att2.name.uri) {
                        return att2.name;
                    }
                }
            }
            return null;
        } else if (this.dupList == null) {
            return null;
        } else {
            for (i = 0; i < this.dupList.size(); i++) {
                att1 = (Attribute) this.dupList.get(i);
                att2 = att1.next;
                while (att2 != null) {
                    if (att1.name.localpart == att2.name.localpart && att1.name.uri == att2.name.uri) {
                        return att2.name;
                    }
                    att2 = att1.next;
                }
            }
            return null;
        }
    }

    protected String getReportableType(String type) {
        if (type.indexOf(40) == 0 && type.lastIndexOf(41) == type.length() - 1) {
            return "NMTOKEN";
        }
        return type;
    }

    protected Attribute getDuplicate(Attribute attr1, QName qname) {
        Attribute att1 = attr1;
        if (att1.name.prefix == qname.prefix && attr1.next == null) {
            return att1;
        }
        while (att1 != null) {
            if (att1.name.rawname == qname.rawname) {
                return att1;
            }
            att1 = att1.next;
        }
        return null;
    }
}
