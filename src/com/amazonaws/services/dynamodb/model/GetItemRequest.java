package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetItemRequest extends AmazonWebServiceRequest {
    private List<String> attributesToGet;
    private Boolean consistentRead;
    private Key key;
    private String tableName;

    public GetItemRequest(String str, Key key) {
        this.tableName = str;
        this.key = key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetItemRequest)) {
            return false;
        }
        GetItemRequest getItemRequest = (GetItemRequest) obj;
        if (((getItemRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getItemRequest.getTableName() != null && !getItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if (((getItemRequest.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getItemRequest.getKey() != null && !getItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if (((getItemRequest.getAttributesToGet() == null ? 1 : 0) ^ (getAttributesToGet() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getItemRequest.getAttributesToGet() != null && !getItemRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        return ((getItemRequest.isConsistentRead() == null ? 1 : 0) ^ (isConsistentRead() == null ? 1 : 0)) == 0 ? getItemRequest.isConsistentRead() == null || getItemRequest.isConsistentRead().equals(isConsistentRead()) : false;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public Key getKey() {
        return this.key;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode()) + (((getKey() == null ? 0 : getKey().hashCode()) + (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (isConsistentRead() != null) {
            i = isConsistentRead().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attributesToGet = arrayList;
    }

    public void setConsistentRead(Boolean bool) {
        this.consistentRead = bool;
    }

    public void setKey(Key key) {
        this.key = key;
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
        if (this.attributesToGet != null) {
            stringBuilder.append("AttributesToGet: " + this.attributesToGet + ", ");
        }
        if (this.consistentRead != null) {
            stringBuilder.append("ConsistentRead: " + this.consistentRead + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetItemRequest withAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributesToGet = arrayList;
        }
        return this;
    }

    public GetItemRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            setAttributesToGet(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributesToGet().add(add);
        }
        return this;
    }

    public GetItemRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public GetItemRequest withKey(Key key) {
        this.key = key;
        return this;
    }

    public GetItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
