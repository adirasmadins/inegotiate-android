package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteTableRequest extends AmazonWebServiceRequest {
    private String tableName;

    public DeleteTableRequest(String str) {
        this.tableName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteTableRequest)) {
            return false;
        }
        DeleteTableRequest deleteTableRequest = (DeleteTableRequest) obj;
        return ((deleteTableRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) == 0 ? deleteTableRequest.getTableName() == null || deleteTableRequest.getTableName().equals(getTableName()) : false;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        return (getTableName() == null ? 0 : getTableName().hashCode()) + 31;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.tableName != null) {
            stringBuilder.append("TableName: " + this.tableName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
