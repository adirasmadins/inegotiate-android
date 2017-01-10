package com.amazonaws.services.dynamodb.model;

import java.util.Map;

public class DeleteItemResult {
    private Map<String, AttributeValue> attributes;
    private Double consumedCapacityUnits;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteItemResult)) {
            return false;
        }
        DeleteItemResult deleteItemResult = (DeleteItemResult) obj;
        if (((deleteItemResult.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteItemResult.getAttributes() != null && !deleteItemResult.getAttributes().equals(getAttributes())) {
            return false;
        }
        return ((deleteItemResult.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? deleteItemResult.getConsumedCapacityUnits() == null || deleteItemResult.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributes() == null ? 0 : getAttributes().hashCode()) + 31) * 31;
        if (getConsumedCapacityUnits() != null) {
            i = getConsumedCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributes(Map<String, AttributeValue> map) {
        this.attributes = map;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteItemResult withAttributes(Map<String, AttributeValue> map) {
        setAttributes(map);
        return this;
    }

    public DeleteItemResult withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }
}
