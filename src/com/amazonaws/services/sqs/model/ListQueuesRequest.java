package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListQueuesRequest extends AmazonWebServiceRequest {
    private String queueNamePrefix;

    public ListQueuesRequest(String str) {
        this.queueNamePrefix = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListQueuesRequest)) {
            return false;
        }
        ListQueuesRequest listQueuesRequest = (ListQueuesRequest) obj;
        return ((listQueuesRequest.getQueueNamePrefix() == null ? 1 : 0) ^ (getQueueNamePrefix() == null ? 1 : 0)) == 0 ? listQueuesRequest.getQueueNamePrefix() == null || listQueuesRequest.getQueueNamePrefix().equals(getQueueNamePrefix()) : false;
    }

    public String getQueueNamePrefix() {
        return this.queueNamePrefix;
    }

    public int hashCode() {
        return (getQueueNamePrefix() == null ? 0 : getQueueNamePrefix().hashCode()) + 31;
    }

    public void setQueueNamePrefix(String str) {
        this.queueNamePrefix = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueNamePrefix != null) {
            stringBuilder.append("QueueNamePrefix: " + this.queueNamePrefix + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListQueuesRequest withQueueNamePrefix(String str) {
        this.queueNamePrefix = str;
        return this;
    }
}
