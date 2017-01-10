package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KeysAndAttributes {
    private List<String> attributesToGet;
    private List<Key> keys;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeysAndAttributes)) {
            return false;
        }
        KeysAndAttributes keysAndAttributes = (KeysAndAttributes) obj;
        if (((keysAndAttributes.getKeys() == null ? 1 : 0) ^ (getKeys() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (keysAndAttributes.getKeys() != null && !keysAndAttributes.getKeys().equals(getKeys())) {
            return false;
        }
        return ((keysAndAttributes.getAttributesToGet() == null ? 1 : 0) ^ (getAttributesToGet() == null ? 1 : 0)) == 0 ? keysAndAttributes.getAttributesToGet() == null || keysAndAttributes.getAttributesToGet().equals(getAttributesToGet()) : false;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public List<Key> getKeys() {
        return this.keys;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeys() == null ? 0 : getKeys().hashCode()) + 31) * 31;
        if (getAttributesToGet() != null) {
            i = getAttributesToGet().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributesToGet = arrayList;
    }

    public void setKeys(Collection<Key> collection) {
        if (collection == null) {
            this.keys = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.keys = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keys != null) {
            stringBuilder.append("Keys: " + this.keys + ", ");
        }
        if (this.attributesToGet != null) {
            stringBuilder.append("AttributesToGet: " + this.attributesToGet + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public KeysAndAttributes withAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributesToGet = arrayList;
        }
        return this;
    }

    public KeysAndAttributes withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            setAttributesToGet(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributesToGet().add(add);
        }
        return this;
    }

    public KeysAndAttributes withKeys(Collection<Key> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.keys = arrayList;
        }
        return this;
    }

    public KeysAndAttributes withKeys(Key... keyArr) {
        if (getKeys() == null) {
            setKeys(new ArrayList(keyArr.length));
        }
        for (Object add : keyArr) {
            getKeys().add(add);
        }
        return this;
    }
}
