package com.amazonaws.services.dynamodb.model;

import java.util.Map;

public class GetItemResult {
    private Double consumedCapacityUnits;
    private Map<String, AttributeValue> item;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetItemResult)) {
            return false;
        }
        GetItemResult getItemResult = (GetItemResult) obj;
        if (((getItemResult.getItem() == null ? 1 : 0) ^ (getItem() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getItemResult.getItem() != null && !getItemResult.getItem().equals(getItem())) {
            return false;
        }
        return ((getItemResult.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? getItemResult.getConsumedCapacityUnits() == null || getItemResult.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public Map<String, AttributeValue> getItem() {
        return this.item;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getItem() == null ? 0 : getItem().hashCode()) + 31) * 31;
        if (getConsumedCapacityUnits() != null) {
            i = getConsumedCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
    }

    public void setItem(Map<String, AttributeValue> map) {
        this.item = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.item != null) {
            stringBuilder.append("Item: " + this.item + ", ");
        }
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetItemResult withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }

    public GetItemResult withItem(Map<String, AttributeValue> map) {
        setItem(map);
        return this;
    }
}
