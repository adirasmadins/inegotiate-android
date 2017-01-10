package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteMessageRequest extends AmazonWebServiceRequest {
    private String queueUrl;
    private String receiptHandle;

    public DeleteMessageRequest(String str, String str2) {
        this.queueUrl = str;
        this.receiptHandle = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteMessageRequest)) {
            return false;
        }
        DeleteMessageRequest deleteMessageRequest = (DeleteMessageRequest) obj;
        if (((deleteMessageRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteMessageRequest.getQueueUrl() != null && !deleteMessageRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((deleteMessageRequest.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) == 0 ? deleteMessageRequest.getReceiptHandle() == null || deleteMessageRequest.getReceiptHandle().equals(getReceiptHandle()) : false;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public String getReceiptHandle() {
        return this.receiptHandle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31;
        if (getReceiptHandle() != null) {
            i = getReceiptHandle().hashCode();
        }
        return hashCode + i;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public void setReceiptHandle(String str) {
        this.receiptHandle = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrl != null) {
            stringBuilder.append("QueueUrl: " + this.queueUrl + ", ");
        }
        if (this.receiptHandle != null) {
            stringBuilder.append("ReceiptHandle: " + this.receiptHandle + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteMessageRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }

    public DeleteMessageRequest withReceiptHandle(String str) {
        this.receiptHandle = str;
        return this;
    }
}
