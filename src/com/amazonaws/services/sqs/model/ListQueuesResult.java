package com.amazonaws.services.sqs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListQueuesResult {
    private List<String> queueUrls;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListQueuesResult)) {
            return false;
        }
        ListQueuesResult listQueuesResult = (ListQueuesResult) obj;
        return ((listQueuesResult.getQueueUrls() == null ? 1 : 0) ^ (getQueueUrls() == null ? 1 : 0)) == 0 ? listQueuesResult.getQueueUrls() == null || listQueuesResult.getQueueUrls().equals(getQueueUrls()) : false;
    }

    public List<String> getQueueUrls() {
        if (this.queueUrls == null) {
            this.queueUrls = new ArrayList();
        }
        return this.queueUrls;
    }

    public int hashCode() {
        return (getQueueUrls() == null ? 0 : getQueueUrls().hashCode()) + 31;
    }

    public void setQueueUrls(Collection<String> collection) {
        if (collection == null) {
            this.queueUrls = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.queueUrls = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrls != null) {
            stringBuilder.append("QueueUrls: " + this.queueUrls + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListQueuesResult withQueueUrls(Collection<String> collection) {
        if (collection == null) {
            this.queueUrls = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.queueUrls = arrayList;
        }
        return this;
    }

    public ListQueuesResult withQueueUrls(String... strArr) {
        if (getQueueUrls() == null) {
            setQueueUrls(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getQueueUrls().add(add);
        }
        return this;
    }
}
