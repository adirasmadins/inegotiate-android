package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class QueryResult {
    private Double consumedCapacityUnits;
    private Integer count;
    private List<Map<String, AttributeValue>> items;
    private Key lastEvaluatedKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof QueryResult)) {
            return false;
        }
        QueryResult queryResult = (QueryResult) obj;
        if (((queryResult.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryResult.getItems() != null && !queryResult.getItems().equals(getItems())) {
            return false;
        }
        if (((queryResult.getCount() == null ? 1 : 0) ^ (getCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryResult.getCount() != null && !queryResult.getCount().equals(getCount())) {
            return false;
        }
        if (((queryResult.getLastEvaluatedKey() == null ? 1 : 0) ^ (getLastEvaluatedKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (queryResult.getLastEvaluatedKey() != null && !queryResult.getLastEvaluatedKey().equals(getLastEvaluatedKey())) {
            return false;
        }
        return ((queryResult.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? queryResult.getConsumedCapacityUnits() == null || queryResult.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public Integer getCount() {
        return this.count;
    }

    public List<Map<String, AttributeValue>> getItems() {
        return this.items;
    }

    public Key getLastEvaluatedKey() {
        return this.lastEvaluatedKey;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLastEvaluatedKey() == null ? 0 : getLastEvaluatedKey().hashCode()) + (((getCount() == null ? 0 : getCount().hashCode()) + (((getItems() == null ? 0 : getItems().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getConsumedCapacityUnits() != null) {
            i = getConsumedCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.items = arrayList;
    }

    public void setLastEvaluatedKey(Key key) {
        this.lastEvaluatedKey = key;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.items != null) {
            stringBuilder.append("Items: " + this.items + ", ");
        }
        if (this.count != null) {
            stringBuilder.append("Count: " + this.count + ", ");
        }
        if (this.lastEvaluatedKey != null) {
            stringBuilder.append("LastEvaluatedKey: " + this.lastEvaluatedKey + ", ");
        }
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public QueryResult withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }

    public QueryResult withCount(Integer num) {
        this.count = num;
        return this;
    }

    public QueryResult withItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public QueryResult withItems(Map<String, AttributeValue>... mapArr) {
        if (getItems() == null) {
            setItems(new ArrayList(mapArr.length));
        }
        for (Object add : mapArr) {
            getItems().add(add);
        }
        return this;
    }

    public QueryResult withLastEvaluatedKey(Key key) {
        this.lastEvaluatedKey = key;
        return this;
    }
}
