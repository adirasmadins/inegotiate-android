package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateTableRequest extends AmazonWebServiceRequest {
    private KeySchema keySchema;
    private ProvisionedThroughput provisionedThroughput;
    private String tableName;

    public CreateTableRequest(String str, KeySchema keySchema) {
        this.tableName = str;
        this.keySchema = keySchema;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateTableRequest)) {
            return false;
        }
        CreateTableRequest createTableRequest = (CreateTableRequest) obj;
        if (((createTableRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createTableRequest.getTableName() != null && !createTableRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if (((createTableRequest.getKeySchema() == null ? 1 : 0) ^ (getKeySchema() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createTableRequest.getKeySchema() != null && !createTableRequest.getKeySchema().equals(getKeySchema())) {
            return false;
        }
        return ((createTableRequest.getProvisionedThroughput() == null ? 1 : 0) ^ (getProvisionedThroughput() == null ? 1 : 0)) == 0 ? createTableRequest.getProvisionedThroughput() == null || createTableRequest.getProvisionedThroughput().equals(getProvisionedThroughput()) : false;
    }

    public KeySchema getKeySchema() {
        return this.keySchema;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeySchema() == null ? 0 : getKeySchema().hashCode()) + (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31)) * 31;
        if (getProvisionedThroughput() != null) {
            i = getProvisionedThroughput().hashCode();
        }
        return hashCode + i;
    }

    public void setKeySchema(KeySchema keySchema) {
        this.keySchema = keySchema;
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
        if (this.keySchema != null) {
            stringBuilder.append("KeySchema: " + this.keySchema + ", ");
        }
        if (this.provisionedThroughput != null) {
            stringBuilder.append("ProvisionedThroughput: " + this.provisionedThroughput + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateTableRequest withKeySchema(KeySchema keySchema) {
        this.keySchema = keySchema;
        return this;
    }

    public CreateTableRequest withProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    public CreateTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
