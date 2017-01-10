package com.amazonaws.services.dynamodb.model;

public class DeleteRequest {
    private Key key;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteRequest)) {
            return false;
        }
        DeleteRequest deleteRequest = (DeleteRequest) obj;
        return ((deleteRequest.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) == 0 ? deleteRequest.getKey() == null || deleteRequest.getKey().equals(getKey()) : false;
    }

    public Key getKey() {
        return this.key;
    }

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) + 31;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.key != null) {
            stringBuilder.append("Key: " + this.key + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteRequest withKey(Key key) {
        this.key = key;
        return this;
    }
}
