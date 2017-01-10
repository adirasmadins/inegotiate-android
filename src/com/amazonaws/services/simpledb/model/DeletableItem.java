package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeletableItem {
    private List<Attribute> attributes;
    private String name;

    public DeletableItem(String str, List<Attribute> list) {
        this.name = str;
        this.attributes = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeletableItem)) {
            return false;
        }
        DeletableItem deletableItem = (DeletableItem) obj;
        if (((deletableItem.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deletableItem.getName() != null && !deletableItem.getName().equals(getName())) {
            return false;
        }
        return ((deletableItem.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? deletableItem.getAttributes() == null || deletableItem.getAttributes().equals(getAttributes()) : false;
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
        int hashCode = ((getName() == null ? 0 : getName().hashCode()) + 31) * 31;
        if (getAttributes() != null) {
            i = getAttributes().hashCode();
        }
        return hashCode + i;
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
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeletableItem withAttributes(Collection<Attribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public DeletableItem withAttributes(Attribute... attributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(attributeArr.length));
        }
        for (Object add : attributeArr) {
            getAttributes().add(add);
        }
        return this;
    }

    public DeletableItem withName(String str) {
        this.name = str;
        return this;
    }
}
