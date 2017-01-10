package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteMessageBatchRequest extends AmazonWebServiceRequest {
    private List<DeleteMessageBatchRequestEntry> entries;
    private String queueUrl;

    public DeleteMessageBatchRequest(String str) {
        this.queueUrl = str;
    }

    public DeleteMessageBatchRequest(String str, List<DeleteMessageBatchRequestEntry> list) {
        this.queueUrl = str;
        this.entries = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteMessageBatchRequest)) {
            return false;
        }
        DeleteMessageBatchRequest deleteMessageBatchRequest = (DeleteMessageBatchRequest) obj;
        if (((deleteMessageBatchRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteMessageBatchRequest.getQueueUrl() != null && !deleteMessageBatchRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((deleteMessageBatchRequest.getEntries() == null ? 1 : 0) ^ (getEntries() == null ? 1 : 0)) == 0 ? deleteMessageBatchRequest.getEntries() == null || deleteMessageBatchRequest.getEntries().equals(getEntries()) : false;
    }

    public List<DeleteMessageBatchRequestEntry> getEntries() {
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

    public void setEntries(Collection<DeleteMessageBatchRequestEntry> collection) {
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

    public DeleteMessageBatchRequest withEntries(Collection<DeleteMessageBatchRequestEntry> collection) {
        if (collection == null) {
            this.entries = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.entries = arrayList;
        }
        return this;
    }

    public DeleteMessageBatchRequest withEntries(DeleteMessageBatchRequestEntry... deleteMessageBatchRequestEntryArr) {
        if (getEntries() == null) {
            setEntries(new ArrayList(deleteMessageBatchRequestEntryArr.length));
        }
        for (Object add : deleteMessageBatchRequestEntryArr) {
            getEntries().add(add);
        }
        return this;
    }

    public DeleteMessageBatchRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
