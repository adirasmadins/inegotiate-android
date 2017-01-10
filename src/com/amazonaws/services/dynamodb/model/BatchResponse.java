package com.amazonaws.services.dynamodb.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BatchResponse {
    private Double consumedCapacityUnits;
    private List<Map<String, AttributeValue>> items;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchResponse)) {
            return false;
        }
        BatchResponse batchResponse = (BatchResponse) obj;
        if (((batchResponse.getItems() == null ? 1 : 0) ^ (getItems() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchResponse.getItems() != null && !batchResponse.getItems().equals(getItems())) {
            return false;
        }
        return ((batchResponse.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? batchResponse.getConsumedCapacityUnits() == null || batchResponse.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public List<Map<String, AttributeValue>> getItems() {
        return this.items;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getItems() == null ? 0 : getItems().hashCode()) + 31) * 31;
        if (getConsumedCapacityUnits() != null) {
            i = getConsumedCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.items != null) {
            stringBuilder.append("Items: " + this.items + ", ");
        }
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchResponse withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }

    public BatchResponse withItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.items = arrayList;
        }
        return this;
    }

    public BatchResponse withItems(Map<String, AttributeValue>... mapArr) {
        if (getItems() == null) {
            setItems(new ArrayList(mapArr.length));
        }
        for (Object add : mapArr) {
            getItems().add(add);
        }
        return this;
    }
}
