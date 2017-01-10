package com.amazonaws.services.dynamodb.model;

import java.util.Map;

public class PutItemResult {
    private Map<String, AttributeValue> attributes;
    private Double consumedCapacityUnits;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutItemResult)) {
            return false;
        }
        PutItemResult putItemResult = (PutItemResult) obj;
        if (((putItemResult.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putItemResult.getAttributes() != null && !putItemResult.getAttributes().equals(getAttributes())) {
            return false;
        }
        return ((putItemResult.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? putItemResult.getConsumedCapacityUnits() == null || putItemResult.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
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

    public PutItemResult withAttributes(Map<String, AttributeValue> map) {
        setAttributes(map);
        return this;
    }

    public PutItemResult withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }
}
