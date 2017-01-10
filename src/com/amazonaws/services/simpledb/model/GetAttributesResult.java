package com.amazonaws.services.simpledb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetAttributesResult {
    private List<Attribute> attributes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAttributesResult)) {
            return false;
        }
        GetAttributesResult getAttributesResult = (GetAttributesResult) obj;
        return ((getAttributesResult.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? getAttributesResult.getAttributes() == null || getAttributesResult.getAttributes().equals(getAttributes()) : false;
    }

    public List<Attribute> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new ArrayList();
        }
        return this.attributes;
    }

    public int hashCode() {
        return (getAttributes() == null ? 0 : getAttributes().hashCode()) + 31;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetAttributesResult withAttributes(Collection<Attribute> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributes = arrayList;
        }
        return this;
    }

    public GetAttributesResult withAttributes(Attribute... attributeArr) {
        if (getAttributes() == null) {
            setAttributes(new ArrayList(attributeArr.length));
        }
        for (Object add : attributeArr) {
            getAttributes().add(add);
        }
        return this;
    }
}
