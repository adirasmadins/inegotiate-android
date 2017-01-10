package com.amazonaws.services.dynamodb.model;

import java.util.Map;

public class PutRequest {
    private Map<String, AttributeValue> item;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutRequest)) {
            return false;
        }
        PutRequest putRequest = (PutRequest) obj;
        return ((putRequest.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) == 0 ? putRequest.getItem() == null || putRequest.getItem().equals(getItem()) : false;
    }

    public Map<String, AttributeValue> getItem() {
        return this.item;
    }

    public int hashCode() {
        return (getItem() == null ? 0 : getItem().hashCode()) + 31;
    }

    public void setItem(Map<String, AttributeValue> map) {
        this.item = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.item != null) {
            stringBuilder.append("Item: " + this.item + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutRequest withItem(Map<String, AttributeValue> map) {
        setItem(map);
        return this;
    }
}
