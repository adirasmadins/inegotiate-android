package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Map;

public class DeleteItemRequest extends AmazonWebServiceRequest {
    private Map<String, ExpectedAttributeValue> expected;
    private Key key;
    private String returnValues;
    private String tableName;

    public DeleteItemRequest(String str, Key key) {
        this.tableName = str;
        this.key = key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteItemRequest)) {
            return false;
        }
        DeleteItemRequest deleteItemRequest = (DeleteItemRequest) obj;
        if (((deleteItemRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteItemRequest.getTableName() != null && !deleteItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if (((deleteItemRequest.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteItemRequest.getKey() != null && !deleteItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if (((deleteItemRequest.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteItemRequest.getExpected() != null && !deleteItemRequest.getExpected().equals(getExpected())) {
            return false;
        }
        return ((deleteItemRequest.getReturnValues() == null ? 1 : 0) ^ (getReturnValues() == null ? 1 : 0)) == 0 ? deleteItemRequest.getReturnValues() == null || deleteItemRequest.getReturnValues().equals(getReturnValues()) : false;
    }

    public Map<String, ExpectedAttributeValue> getExpected() {
        return this.expected;
    }

    public Key getKey() {
        return this.key;
    }

    public String getReturnValues() {
        return this.returnValues;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getExpected() == null ? 0 : getExpected().hashCode()) + (((getKey() == null ? 0 : getKey().hashCode()) + (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getReturnValues() != null) {
            i = getReturnValues().hashCode();
        }
        return hashCode + i;
    }

    public void setExpected(Map<String, ExpectedAttributeValue> map) {
        this.expected = map;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
    }

    public void setReturnValues(String str) {
        this.returnValues = str;
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
        if (this.key != null) {
            stringBuilder.append("Key: " + this.key + ", ");
        }
        if (this.expected != null) {
            stringBuilder.append("Expected: " + this.expected + ", ");
        }
        if (this.returnValues != null) {
            stringBuilder.append("ReturnValues: " + this.returnValues + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteItemRequest withExpected(Map<String, ExpectedAttributeValue> map) {
        setExpected(map);
        return this;
    }

    public DeleteItemRequest withKey(Key key) {
        this.key = key;
        return this;
    }

    public DeleteItemRequest withReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
        return this;
    }

    public DeleteItemRequest withReturnValues(String str) {
        this.returnValues = str;
        return this;
    }

    public DeleteItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
