package com.amazonaws.services.dynamodb.model;

import java.util.List;
import java.util.Map;

public class BatchWriteItemResult {
    private Map<String, BatchWriteResponse> responses;
    private Map<String, List<WriteRequest>> unprocessedItems;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchWriteItemResult)) {
            return false;
        }
        BatchWriteItemResult batchWriteItemResult = (BatchWriteItemResult) obj;
        if (((batchWriteItemResult.getResponses() == null ? 1 : 0) ^ (getResponses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchWriteItemResult.getResponses() != null && !batchWriteItemResult.getResponses().equals(getResponses())) {
            return false;
        }
        return ((batchWriteItemResult.getUnprocessedItems() == null ? 1 : 0) ^ (getUnprocessedItems() == null ? 1 : 0)) == 0 ? batchWriteItemResult.getUnprocessedItems() == null || batchWriteItemResult.getUnprocessedItems().equals(getUnprocessedItems()) : false;
    }

    public Map<String, BatchWriteResponse> getResponses() {
        return this.responses;
    }

    public Map<String, List<WriteRequest>> getUnprocessedItems() {
        return this.unprocessedItems;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getResponses() == null ? 0 : getResponses().hashCode()) + 31) * 31;
        if (getUnprocessedItems() != null) {
            i = getUnprocessedItems().hashCode();
        }
        return hashCode + i;
    }

    public void setResponses(Map<String, BatchWriteResponse> map) {
        this.responses = map;
    }

    public void setUnprocessedItems(Map<String, List<WriteRequest>> map) {
        this.unprocessedItems = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.responses != null) {
            stringBuilder.append("Responses: " + this.responses + ", ");
        }
        if (this.unprocessedItems != null) {
            stringBuilder.append("UnprocessedItems: " + this.unprocessedItems + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchWriteItemResult withResponses(Map<String, BatchWriteResponse> map) {
        setResponses(map);
        return this;
    }

    public BatchWriteItemResult withUnprocessedItems(Map<String, List<WriteRequest>> map) {
        setUnprocessedItems(map);
        return this;
    }
}
