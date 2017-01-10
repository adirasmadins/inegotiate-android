package com.amazonaws.services.dynamodb.model;

public class WriteRequest {
    private DeleteRequest deleteRequest;
    private PutRequest putRequest;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WriteRequest)) {
            return false;
        }
        WriteRequest writeRequest = (WriteRequest) obj;
        if (((writeRequest.getPutRequest() == null ? 1 : 0) ^ (getPutRequest() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (writeRequest.getPutRequest() != null && !writeRequest.getPutRequest().equals(getPutRequest())) {
            return false;
        }
        return ((writeRequest.getDeleteRequest() == null ? 1 : 0) ^ (getDeleteRequest() == null ? 1 : 0)) == 0 ? writeRequest.getDeleteRequest() == null || writeRequest.getDeleteRequest().equals(getDeleteRequest()) : false;
    }

    public DeleteRequest getDeleteRequest() {
        return this.deleteRequest;
    }

    public PutRequest getPutRequest() {
        return this.putRequest;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPutRequest() == null ? 0 : getPutRequest().hashCode()) + 31) * 31;
        if (getDeleteRequest() != null) {
            i = getDeleteRequest().hashCode();
        }
        return hashCode + i;
    }

    public void setDeleteRequest(DeleteRequest deleteRequest) {
        this.deleteRequest = deleteRequest;
    }

    public void setPutRequest(PutRequest putRequest) {
        this.putRequest = putRequest;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.putRequest != null) {
            stringBuilder.append("PutRequest: " + this.putRequest + ", ");
        }
        if (this.deleteRequest != null) {
            stringBuilder.append("DeleteRequest: " + this.deleteRequest + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public WriteRequest withDeleteRequest(DeleteRequest deleteRequest) {
        this.deleteRequest = deleteRequest;
        return this;
    }

    public WriteRequest withPutRequest(PutRequest putRequest) {
        this.putRequest = putRequest;
        return this;
    }
}
