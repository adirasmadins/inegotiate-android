package com.amazonaws.services.dynamodb.model;

public class BatchWriteResponse {
    private Double consumedCapacityUnits;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchWriteResponse)) {
            return false;
        }
        BatchWriteResponse batchWriteResponse = (BatchWriteResponse) obj;
        return ((batchWriteResponse.getConsumedCapacityUnits() == null ? 1 : 0) ^ (getConsumedCapacityUnits() == null ? 1 : 0)) == 0 ? batchWriteResponse.getConsumedCapacityUnits() == null || batchWriteResponse.getConsumedCapacityUnits().equals(getConsumedCapacityUnits()) : false;
    }

    public Double getConsumedCapacityUnits() {
        return this.consumedCapacityUnits;
    }

    public int hashCode() {
        return (getConsumedCapacityUnits() == null ? 0 : getConsumedCapacityUnits().hashCode()) + 31;
    }

    public void setConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.consumedCapacityUnits != null) {
            stringBuilder.append("ConsumedCapacityUnits: " + this.consumedCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchWriteResponse withConsumedCapacityUnits(Double d) {
        this.consumedCapacityUnits = d;
        return this;
    }
}
