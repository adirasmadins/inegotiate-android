package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteQueueRequest extends AmazonWebServiceRequest {
    private String queueUrl;

    public DeleteQueueRequest(String str) {
        this.queueUrl = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteQueueRequest)) {
            return false;
        }
        DeleteQueueRequest deleteQueueRequest = (DeleteQueueRequest) obj;
        return ((deleteQueueRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) == 0 ? deleteQueueRequest.getQueueUrl() == null || deleteQueueRequest.getQueueUrl().equals(getQueueUrl()) : false;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        return (getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteQueueRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
