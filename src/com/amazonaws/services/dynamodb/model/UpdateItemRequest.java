package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Map;

public class UpdateItemRequest extends AmazonWebServiceRequest {
    private Map<String, AttributeValueUpdate> attributeUpdates;
    private Map<String, ExpectedAttributeValue> expected;
    private Key key;
    private String returnValues;
    private String tableName;

    public UpdateItemRequest(String str, Key key, Map<String, AttributeValueUpdate> map) {
        this.tableName = str;
        this.key = key;
        this.attributeUpdates = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateItemRequest)) {
            return false;
        }
        UpdateItemRequest updateItemRequest = (UpdateItemRequest) obj;
        if (((updateItemRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateItemRequest.getTableName() != null && !updateItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if (((updateItemRequest.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateItemRequest.getKey() != null && !updateItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if (((updateItemRequest.getAttributeUpdates() == null ? 1 : 0) ^ (getAttributeUpdates() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateItemRequest.getAttributeUpdates() != null && !updateItemRequest.getAttributeUpdates().equals(getAttributeUpdates())) {
            return false;
        }
        if (((updateItemRequest.getExpected() == null ? 1 : 0) ^ (getExpected() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateItemRequest.getExpected() != null && !updateItemRequest.getExpected().equals(getExpected())) {
            return false;
        }
        return ((updateItemRequest.getReturnValues() == null ? 1 : 0) ^ (getReturnValues() == null ? 1 : 0)) == 0 ? updateItemRequest.getReturnValues() == null || updateItemRequest.getReturnValues().equals(getReturnValues()) : false;
    }

    public Map<String, AttributeValueUpdate> getAttributeUpdates() {
        return this.attributeUpdates;
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
        int hashCode = ((getExpected() == null ? 0 : getExpected().hashCode()) + (((getAttributeUpdates() == null ? 0 : getAttributeUpdates().hashCode()) + (((getKey() == null ? 0 : getKey().hashCode()) + (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getReturnValues() != null) {
            i = getReturnValues().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeUpdates(Map<String, AttributeValueUpdate> map) {
        this.attributeUpdates = map;
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
        if (this.attributeUpdates != null) {
            stringBuilder.append("AttributeUpdates: " + this.attributeUpdates + ", ");
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

    public UpdateItemRequest withAttributeUpdates(Map<String, AttributeValueUpdate> map) {
        setAttributeUpdates(map);
        return this;
    }

    public UpdateItemRequest withExpected(Map<String, ExpectedAttributeValue> map) {
        setExpected(map);
        return this;
    }

    public UpdateItemRequest withKey(Key key) {
        this.key = key;
        return this;
    }

    public UpdateItemRequest withReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
        return this;
    }

    public UpdateItemRequest withReturnValues(String str) {
        this.returnValues = str;
        return this;
    }

    public UpdateItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
