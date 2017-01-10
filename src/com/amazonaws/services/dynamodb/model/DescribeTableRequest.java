package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeTableRequest extends AmazonWebServiceRequest {
    private String tableName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTableRequest)) {
            return false;
        }
        DescribeTableRequest describeTableRequest = (DescribeTableRequest) obj;
        return ((describeTableRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) == 0 ? describeTableRequest.getTableName() == null || describeTableRequest.getTableName().equals(getTableName()) : false;
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

    public DescribeTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
