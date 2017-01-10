package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class UpdateTableRequest extends AmazonWebServiceRequest {
    private ProvisionedThroughput provisionedThroughput;
    private String tableName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTableRequest)) {
            return false;
        }
        UpdateTableRequest updateTableRequest = (UpdateTableRequest) obj;
        if (((updateTableRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateTableRequest.getTableName() != null && !updateTableRequest.getTableName().equals(getTableName())) {
            return false;
        }
        return ((updateTableRequest.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) == 0 ? updateTableRequest.getProvisionedThroughput() == null || updateTableRequest.getProvisionedThroughput().equals(getProvisionedThroughput()) : false;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31;
        if (getProvisionedThroughput() != null) {
            i = getProvisionedThroughput().hashCode();
        }
        return hashCode + i;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
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
        if (this.provisionedThroughput != null) {
            stringBuilder.append("ProvisionedThroughput: " + this.provisionedThroughput + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UpdateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    public UpdateTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
