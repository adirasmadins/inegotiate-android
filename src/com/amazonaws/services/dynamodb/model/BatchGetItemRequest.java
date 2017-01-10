package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Map;

public class BatchGetItemRequest extends AmazonWebServiceRequest {
    private Map<String, KeysAndAttributes> requestItems;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchGetItemRequest)) {
            return false;
        }
        BatchGetItemRequest batchGetItemRequest = (BatchGetItemRequest) obj;
        return ((batchGetItemRequest.getRequestItems() == null ? 1 : 0) ^ (getRequestItems() == null ? 1 : 0)) == 0 ? batchGetItemRequest.getRequestItems() == null || batchGetItemRequest.getRequestItems().equals(getRequestItems()) : false;
    }

    public Map<String, KeysAndAttributes> getRequestItems() {
        return this.requestItems;
    }

    public int hashCode() {
        return (getRequestItems() == null ? 0 : getRequestItems().hashCode()) + 31;
    }

    public void setRequestItems(Map<String, KeysAndAttributes> map) {
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

    public BatchGetItemRequest withRequestItems(Map<String, KeysAndAttributes> map) {
        setRequestItems(map);
        return this;
    }
}
