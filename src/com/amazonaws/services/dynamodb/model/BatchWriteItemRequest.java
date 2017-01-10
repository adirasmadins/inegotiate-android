package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.List;
import java.util.Map;

public class BatchWriteItemRequest extends AmazonWebServiceRequest {
    private Map<String, List<WriteRequest>> requestItems;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchWriteItemRequest)) {
            return false;
        }
        BatchWriteItemRequest batchWriteItemRequest = (BatchWriteItemRequest) obj;
        return ((batchWriteItemRequest.getRequestItems() == null ? 1 : 0) ^ (getRequestItems() == null ? 1 : 0)) == 0 ? batchWriteItemRequest.getRequestItems() == null || batchWriteItemRequest.getRequestItems().equals(getRequestItems()) : false;
    }

    public Map<String, List<WriteRequest>> getRequestItems() {
        return this.requestItems;
    }

    public int hashCode() {
        return (getRequestItems() == null ? 0 : getRequestItems().hashCode()) + 31;
    }

    public void setRequestItems(Map<String, List<WriteRequest>> map) {
        this.requestItems = map;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.requestItems != null) {
            stringBuilder.append("RequestItems: " + this.requestItems + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchWriteItemRequest withRequestItems(Map<String, List<WriteRequest>> map) {
        setRequestItems(map);
        return this;
    }
}
