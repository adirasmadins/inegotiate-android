package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListTablesRequest extends AmazonWebServiceRequest {
    private String exclusiveStartTableName;
    private Integer limit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTablesRequest)) {
            return false;
        }
        ListTablesRequest listTablesRequest = (ListTablesRequest) obj;
        if (((listTablesRequest.getExclusiveStartTableName() == null ? 1 : 0) ^ (getExclusiveStartTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listTablesRequest.getExclusiveStartTableName() != null && !listTablesRequest.getExclusiveStartTableName().equals(getExclusiveStartTableName())) {
            return false;
        }
        return ((listTablesRequest.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) == 0 ? listTablesRequest.getLimit() == null || listTablesRequest.getLimit().equals(getLimit()) : false;
    }

    public String getExclusiveStartTableName() {
        return this.exclusiveStartTableName;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getExclusiveStartTableName() == null ? 0 : getExclusiveStartTableName().hashCode()) + 31) * 31;
        if (getLimit() != null) {
            i = getLimit().hashCode();
        }
        return hashCode + i;
    }

    public void setExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.exclusiveStartTableName != null) {
            stringBuilder.append("ExclusiveStartTableName: " + this.exclusiveStartTableName + ", ");
        }
        if (this.limit != null) {
            stringBuilder.append("Limit: " + this.limit + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListTablesRequest withExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
        return this;
    }

    public ListTablesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }
}
