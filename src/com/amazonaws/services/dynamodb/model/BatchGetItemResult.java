package com.amazonaws.services.dynamodb.model;

import java.util.Map;

public class BatchGetItemResult {
    private Map<String, BatchResponse> responses;
    private Map<String, KeysAndAttributes> unprocessedKeys;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchGetItemResult)) {
            return false;
        }
        BatchGetItemResult batchGetItemResult = (BatchGetItemResult) obj;
        if (((batchGetItemResult.getResponses() == null ? 1 : 0) ^ (getResponses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchGetItemResult.getResponses() != null && !batchGetItemResult.getResponses().equals(getResponses())) {
            return false;
        }
        return ((batchGetItemResult.getUnprocessedKeys() == null ? 1 : 0) ^ (getUnprocessedKeys() == null ? 1 : 0)) == 0 ? batchGetItemResult.getUnprocessedKeys() == null || batchGetItemResult.getUnprocessedKeys().equals(getUnprocessedKeys()) : false;
    }

    public Map<String, BatchResponse> getResponses() {
        return this.responses;
    }

    public Map<String, KeysAndAttributes> getUnprocessedKeys() {
        return this.unprocessedKeys;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getResponses() == null ? 0 : getResponses().hashCode()) + 31) * 31;
        if (getUnprocessedKeys() != null) {
            i = getUnprocessedKeys().hashCode();
        }
        return hashCode + i;
    }

    public void setResponses(Map<String, BatchResponse> map) {
        this.responses = map;
    }

    public void setUnprocessedKeys(Map<String, KeysAndAttributes> map) {
        this.unprocessedKeys = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.responses != null) {
            stringBuilder.append("Responses: " + this.responses + ", ");
        }
        if (this.unprocessedKeys != null) {
            stringBuilder.append("UnprocessedKeys: " + this.unprocessedKeys + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchGetItemResult withResponses(Map<String, BatchResponse> map) {
        setResponses(map);
        return this;
    }

    public BatchGetItemResult withUnprocessedKeys(Map<String, KeysAndAttributes> map) {
        setUnprocessedKeys(map);
        return this;
    }
}
