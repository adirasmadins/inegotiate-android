package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SendMessageBatchRequest extends AmazonWebServiceRequest {
    private List<SendMessageBatchRequestEntry> entries;
    private String queueUrl;

    public SendMessageBatchRequest(String str) {
        this.queueUrl = str;
    }

    public SendMessageBatchRequest(String str, List<SendMessageBatchRequestEntry> list) {
        this.queueUrl = str;
        this.entries = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendMessageBatchRequest)) {
            return false;
        }
        SendMessageBatchRequest sendMessageBatchRequest = (SendMessageBatchRequest) obj;
        if (((sendMessageBatchRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageBatchRequest.getQueueUrl() != null && !sendMessageBatchRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((sendMessageBatchRequest.getEntries() == null ? 1 : 0) ^ (getEntries() == null ? 1 : 0)) == 0 ? sendMessageBatchRequest.getEntries() == null || sendMessageBatchRequest.getEntries().equals(getEntries()) : false;
    }

    public List<SendMessageBatchRequestEntry> getEntries() {
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

    public void setEntries(Collection<SendMessageBatchRequestEntry> collection) {
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

    public SendMessageBatchRequest withEntries(Collection<SendMessageBatchRequestEntry> collection) {
        if (collection == null) {
            this.entries = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.entries = arrayList;
        }
        return this;
    }

    public SendMessageBatchRequest withEntries(SendMessageBatchRequestEntry... sendMessageBatchRequestEntryArr) {
        if (getEntries() == null) {
            setEntries(new ArrayList(sendMessageBatchRequestEntryArr.length));
        }
        for (Object add : sendMessageBatchRequestEntryArr) {
            getEntries().add(add);
        }
        return this;
    }

    public SendMessageBatchRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
