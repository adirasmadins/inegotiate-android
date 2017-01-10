package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueryRequest extends AmazonWebServiceRequest {
    private List<String> attributesToGet;
    private Boolean consistentRead;
    private Boolean count;
    private Key exclusiveStartKey;
    private AttributeValue hashKeyValue;
    private Integer limit;
    private Condition rangeKeyCondition;
    private Boolean scanIndexForward;
    private String tableName;

    public QueryRequest(String str, AttributeValue attributeValue) {
        this.tableName = str;
        this.hashKeyValue = attributeValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof QueryRequest)) {
            return false;
        }
        QueryRequest queryRequest = (QueryRequest) obj;
        if (((queryRequest.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.getTableName() != null && !queryRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if (((queryRequest.getAttributesToGet() == null ? 1 : 0) ^ (getAttributesToGet() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.getAttributesToGet() != null && !queryRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if (((queryRequest.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.getLimit() != null && !queryRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (((queryRequest.isConsistentRead() == null ? 1 : 0) ^ (isConsistentRead() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.isConsistentRead() != null && !queryRequest.isConsistentRead().equals(isConsistentRead())) {
            return false;
        }
        if (((queryRequest.isCount() == null ? 1 : 0) ^ (isCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.isCount() != null && !queryRequest.isCount().equals(isCount())) {
            return false;
        }
        if (((queryRequest.getHashKeyValue() == null ? 1 : 0) ^ (getHashKeyValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.getHashKeyValue() != null && !queryRequest.getHashKeyValue().equals(getHashKeyValue())) {
            return false;
        }
        if (((queryRequest.getRangeKeyCondition() == null ? 1 : 0) ^ (getRangeKeyCondition() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.getRangeKeyCondition() != null && !queryRequest.getRangeKeyCondition().equals(getRangeKeyCondition())) {
            return false;
        }
        if (((queryRequest.isScanIndexForward() == null ? 1 : 0) ^ (isScanIndexForward() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryRequest.isScanIndexForward() != null && !queryRequest.isScanIndexForward().equals(isScanIndexForward())) {
            return false;
        }
        return ((queryRequest.getExclusiveStartKey() == null ? 1 : 0) ^ (getExclusiveStartKey() == null ? 1 : 0)) == 0 ? queryRequest.getExclusiveStartKey() == null || queryRequest.getExclusiveStartKey().equals(getExclusiveStartKey()) : false;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public Boolean getCount() {
        return this.count;
    }

    public Key getExclusiveStartKey() {
        return this.exclusiveStartKey;
    }

    public AttributeValue getHashKeyValue() {
        return this.hashKeyValue;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Condition getRangeKeyCondition() {
        return this.rangeKeyCondition;
    }

    public Boolean getScanIndexForward() {
        return this.scanIndexForward;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((isScanIndexForward() == null ? 0 : isScanIndexForward().hashCode()) + (((getRangeKeyCondition() == null ? 0 : getRangeKeyCondition().hashCode()) + (((getHashKeyValue() == null ? 0 : getHashKeyValue().hashCode()) + (((isCount() == null ? 0 : isCount().hashCode()) + (((isConsistentRead() == null ? 0 : isConsistentRead().hashCode()) + (((getLimit() == null ? 0 : getLimit().hashCode()) + (((getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode()) + (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getExclusiveStartKey() != null) {
            i = getExclusiveStartKey().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public Boolean isCount() {
        return this.count;
    }

    public Boolean isScanIndexForward() {
        return this.scanIndexForward;
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

    public void setCount(Boolean bool) {
        this.count = bool;
    }

    public void setExclusiveStartKey(Key key) {
        this.exclusiveStartKey = key;
    }

    public void setHashKeyValue(AttributeValue attributeValue) {
        this.hashKeyValue = attributeValue;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setRangeKeyCondition(Condition condition) {
        this.rangeKeyCondition = condition;
    }

    public void setScanIndexForward(Boolean bool) {
        this.scanIndexForward = bool;
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
        if (this.attributesToGet != null) {
            stringBuilder.append("AttributesToGet: " + this.attributesToGet + ", ");
        }
        if (this.limit != null) {
            stringBuilder.append("Limit: " + this.limit + ", ");
        }
        if (this.consistentRead != null) {
            stringBuilder.append("ConsistentRead: " + this.consistentRead + ", ");
        }
        if (this.count != null) {
            stringBuilder.append("Count: " + this.count + ", ");
        }
        if (this.hashKeyValue != null) {
            stringBuilder.append("HashKeyValue: " + this.hashKeyValue + ", ");
        }
        if (this.rangeKeyCondition != null) {
            stringBuilder.append("RangeKeyCondition: " + this.rangeKeyCondition + ", ");
        }
        if (this.scanIndexForward != null) {
            stringBuilder.append("ScanIndexForward: " + this.scanIndexForward + ", ");
        }
        if (this.exclusiveStartKey != null) {
            stringBuilder.append("ExclusiveStartKey: " + this.exclusiveStartKey + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public QueryRequest withAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attributesToGet = arrayList;
        }
        return this;
    }

    public QueryRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            setAttributesToGet(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAttributesToGet().add(add);
        }
        return this;
    }

    public QueryRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public QueryRequest withCount(Boolean bool) {
        this.count = bool;
        return this;
    }

    public QueryRequest withExclusiveStartKey(Key key) {
        this.exclusiveStartKey = key;
        return this;
    }

    public QueryRequest withHashKeyValue(AttributeValue attributeValue) {
        this.hashKeyValue = attributeValue;
        return this;
    }

    public QueryRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public QueryRequest withRangeKeyCondition(Condition condition) {
        this.rangeKeyCondition = condition;
        return this;
    }

    public QueryRequest withScanIndexForward(Boolean bool) {
        this.scanIndexForward = bool;
        return this;
    }

    public QueryRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }
}
