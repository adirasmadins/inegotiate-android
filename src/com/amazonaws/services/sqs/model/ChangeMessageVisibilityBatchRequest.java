package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChangeMessageVisibilityBatchRequest extends AmazonWebServiceRequest {
    private List<ChangeMessageVisibilityBatchRequestEntry> entries;
    private String queueUrl;

    public ChangeMessageVisibilityBatchRequest(String str, List<ChangeMessageVisibilityBatchRequestEntry> list) {
        this.queueUrl = str;
        this.entries = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeMessageVisibilityBatchRequest)) {
            return false;
        }
        ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest = (ChangeMessageVisibilityBatchRequest) obj;
        if (((changeMessageVisibilityBatchRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityBatchRequest.getQueueUrl() != null && !changeMessageVisibilityBatchRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((changeMessageVisibilityBatchRequest.getEntries() == null ? 1 : 0) ^ (getEntries() == null ? 1 : 0)) == 0 ? changeMessageVisibilityBatchRequest.getEntries() == null || changeMessageVisibilityBatchRequest.getEntries().equals(getEntries()) : false;
    }

    public List<ChangeMessageVisibilityBatchRequestEntry> getEntries() {
        if (this.entries == null) {
            this.entries = new ArrayList();
        }
        return this.entries;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31;
        if (getEntries() != null) {
            i = getEntries().hashCode();
        }
        return hashCode + i;
    }

    public void setEntries(Collection<ChangeMessageVisibilityBatchRequestEntry> collection) {
        if (collection == null) {
            this.entries = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.entries = arrayList;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrl != null) {
            stringBuilder.append("QueueUrl: " + this.queueUrl + ", ");
        }
        if (this.entries != null) {
            stringBuilder.append("Entries: " + this.entries + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ChangeMessageVisibilityBatchRequest withEntries(Collection<ChangeMessageVisibilityBatchRequestEntry> collection) {
        if (collection == null) {
            this.entries = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.entries = arrayList;
        }
        return this;
    }

    public ChangeMessageVisibilityBatchRequest withEntries(ChangeMessageVisibilityBatchRequestEntry... changeMessageVisibilityBatchRequestEntryArr) {
        if (getEntries() == null) {
            setEntries(new ArrayList(changeMessageVisibilityBatchRequestEntryArr.length));
        }
        for (Object add : changeMessageVisibilityBatchRequestEntryArr) {
            getEntries().add(add);
        }
        return this;
    }

    public ChangeMessageVisibilityBatchRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
