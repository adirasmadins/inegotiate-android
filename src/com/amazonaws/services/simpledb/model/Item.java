package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Item {
    private String alternateNameEncoding;
    private List<Attribute> attributes;
    private String name;

    public Item(String str, List<Attribute> list) {
        this.name = str;
        this.attributes = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        if (((item.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (item.getName() != null && !item.getName().equals(getName())) {
            return false;
        }
        if (((item.getAlternateNameEncoding() == null ? 1 : 0) ^ (getAlternateNameEncoding() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (item.getAlternateNameEncoding() != null && !item.getAlternateNameEncoding().equals(getAlternateNameEncoding())) {
            return false;
        }
        return ((item.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? item.getAttributes() == null || item.getAttributes().equals(getAttributes()) : false;
    }

    public String getAlternateNameEncoding() {
        return this.alternateNameEncoding;
    }

    public List<Attribute> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
        }
        return this.attributes;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAlternateNameEncoding() == null ? 0 : getAlternateNameEncoding().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31;
        if (getAttributes() != null) {
            i = getAttributes().hashCode();
        }
        return hashCode + i;
    }

    public void setAlternateNameEncoding(String str) {
        this.alternateNameEncoding = str;
    }

    public void setAttributes(Collection<Attribute> collection) {
        if (collection == null) {
            this.attributes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributes = arrayList;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.alternateNameEncoding != null) {
            stringBuilder.append("AlternateNameEncoding: " + this.alternateNameEncoding + ", ");
        }
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Item withAlternateNameEncoding(String str) {
        this.alternateNameEncoding = str;
        return this;
    }

    public Item withAttributes(Collection<Attribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public Item withAttributes(Attribute... attributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(attributeArr.length));
        }
        for (Object add : attributeArr) {
            getAttributes().add(add);
        }
        return this;
    }

    public Item withName(String str) {
        this.name = str;
        return this;
    }
}
