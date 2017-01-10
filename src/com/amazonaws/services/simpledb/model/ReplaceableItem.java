package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplaceableItem {
    private List<ReplaceableAttribute> attributes;
    private String name;

    public ReplaceableItem(String str) {
        this.name = str;
    }

    public ReplaceableItem(String str, List<ReplaceableAttribute> list) {
        this.name = str;
        this.attributes = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplaceableItem)) {
            return false;
        }
        ReplaceableItem replaceableItem = (ReplaceableItem) obj;
        if (((replaceableItem.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (replaceableItem.getName() != null && !replaceableItem.getName().equals(getName())) {
            return false;
        }
        return ((replaceableItem.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? replaceableItem.getAttributes() == null || replaceableItem.getAttributes().equals(getAttributes()) : false;
    }

    public List<ReplaceableAttribute> getAttributes() {
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

    public void setAttributes(Collection<ReplaceableAttribute> collection) {
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

    public ReplaceableItem withAttributes(Collection<ReplaceableAttribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public ReplaceableItem withAttributes(ReplaceableAttribute... replaceableAttributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(replaceableAttributeArr.length));
        }
        for (Object add : replaceableAttributeArr) {
            getAttributes().add(add);
        }
        return this;
    }

    public ReplaceableItem withName(String str) {
        this.name = str;
        return this;
    }
}
