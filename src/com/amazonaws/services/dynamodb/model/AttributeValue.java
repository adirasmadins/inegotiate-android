package com.amazonaws.services.dynamodb.model;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AttributeValue {
    private ByteBuffer f0b;
    private List<ByteBuffer> bS;
    private String f1n;
    private List<String> nS;
    private String f2s;
    private List<String> sS;

    public AttributeValue(String str) {
        this.f2s = str;
    }

    public AttributeValue(List<String> list) {
        this.sS = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeValue)) {
            return false;
        }
        AttributeValue attributeValue = (AttributeValue) obj;
        if (((attributeValue.getS() == null ? 1 : 0) ^ (getS() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValue.getS() != null && !attributeValue.getS().equals(getS())) {
            return false;
        }
        if (((attributeValue.getN() == null ? 1 : 0) ^ (getN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValue.getN() != null && !attributeValue.getN().equals(getN())) {
            return false;
        }
        if (((attributeValue.getB() == null ? 1 : 0) ^ (getB() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValue.getB() != null && !attributeValue.getB().equals(getB())) {
            return false;
        }
        if (((attributeValue.getSS() == null ? 1 : 0) ^ (getSS() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValue.getSS() != null && !attributeValue.getSS().equals(getSS())) {
            return false;
        }
        if (((attributeValue.getNS() == null ? 1 : 0) ^ (getNS() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValue.getNS() != null && !attributeValue.getNS().equals(getNS())) {
            return false;
        }
        return ((attributeValue.getBS() == null ? 1 : 0) ^ (getBS() == null ? 1 : 0)) == 0 ? attributeValue.getBS() == null || attributeValue.getBS().equals(getBS()) : false;
    }

    public ByteBuffer getB() {
        return this.f0b;
    }

    public List<ByteBuffer> getBS() {
        return this.bS;
    }

    public String getN() {
        return this.f1n;
    }

    public List<String> getNS() {
        return this.nS;
    }

    public String getS() {
        return this.f2s;
    }

    public List<String> getSS() {
        return this.sS;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNS() == null ? 0 : getNS().hashCode()) + (((getSS() == null ? 0 : getSS().hashCode()) + (((getB() == null ? 0 : getB().hashCode()) + (((getN() == null ? 0 : getN().hashCode()) + (((getS() == null ? 0 : getS().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getBS() != null) {
            i = getBS().hashCode();
        }
        return hashCode + i;
    }

    public void setB(ByteBuffer byteBuffer) {
        this.f0b = byteBuffer;
    }

    public void setBS(Collection<ByteBuffer> collection) {
        if (collection == null) {
            this.bS = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.bS = arrayList;
    }

    public void setN(String str) {
        this.f1n = str;
    }

    public void setNS(Collection<String> collection) {
        if (collection == null) {
            this.nS = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.nS = arrayList;
    }

    public void setS(String str) {
        this.f2s = str;
    }

    public void setSS(Collection<String> collection) {
        if (collection == null) {
            this.sS = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.sS = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.f2s != null) {
            stringBuilder.append("S: " + this.f2s + ", ");
        }
        if (this.f1n != null) {
            stringBuilder.append("N: " + this.f1n + ", ");
        }
        if (this.f0b != null) {
            stringBuilder.append("B: " + this.f0b + ", ");
        }
        if (this.sS != null) {
            stringBuilder.append("SS: " + this.sS + ", ");
        }
        if (this.nS != null) {
            stringBuilder.append("NS: " + this.nS + ", ");
        }
        if (this.bS != null) {
            stringBuilder.append("BS: " + this.bS + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AttributeValue withB(ByteBuffer byteBuffer) {
        this.f0b = byteBuffer;
        return this;
    }

    public AttributeValue withBS(Collection<ByteBuffer> collection) {
        if (collection == null) {
            this.bS = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.bS = arrayList;
        }
        return this;
    }

    public AttributeValue withBS(ByteBuffer... byteBufferArr) {
        if (getBS() == null) {
            setBS(new ArrayList(byteBufferArr.length));
        }
        for (Object add : byteBufferArr) {
            getBS().add(add);
        }
        return this;
    }

    public AttributeValue withN(String str) {
        this.f1n = str;
        return this;
    }

    public AttributeValue withNS(Collection<String> collection) {
        if (collection == null) {
            this.nS = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.nS = arrayList;
        }
        return this;
    }

    public AttributeValue withNS(String... strArr) {
        if (getNS() == null) {
            setNS(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getNS().add(add);
        }
        return this;
    }

    public AttributeValue withS(String str) {
        this.f2s = str;
        return this;
    }

    public AttributeValue withSS(Collection<String> collection) {
        if (collection == null) {
            this.sS = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.sS = arrayList;
        }
        return this;
    }

    public AttributeValue withSS(String... strArr) {
        if (getSS() == null) {
            setSS(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSS().add(add);
        }
        return this;
    }
}
