package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ChangeMessageVisibilityRequest extends AmazonWebServiceRequest {
    private String queueUrl;
    private String receiptHandle;
    private Integer visibilityTimeout;

    public ChangeMessageVisibilityRequest(String str, String str2, Integer num) {
        this.queueUrl = str;
        this.receiptHandle = str2;
        this.visibilityTimeout = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeMessageVisibilityRequest)) {
            return false;
        }
        ChangeMessageVisibilityRequest changeMessageVisibilityRequest = (ChangeMessageVisibilityRequest) obj;
        if (((changeMessageVisibilityRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityRequest.getQueueUrl() != null && !changeMessageVisibilityRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        if (((changeMessageVisibilityRequest.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityRequest.getReceiptHandle() != null && !changeMessageVisibilityRequest.getReceiptHandle().equals(getReceiptHandle())) {
            return false;
        }
        return ((changeMessageVisibilityRequest.getVisibilityTimeout() == null ? 1 : 0) ^ (getVisibilityTimeout() == null ? 1 : 0)) == 0 ? changeMessageVisibilityRequest.getVisibilityTimeout() == null || changeMessageVisibilityRequest.getVisibilityTimeout().equals(getVisibilityTimeout()) : false;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public String getReceiptHandle() {
        return this.receiptHandle;
    }

    public Integer getVisibilityTimeout() {
        return this.visibilityTimeout;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode()) + (((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31)) * 31;
        if (getVisibilityTimeout() != null) {
            i = getVisibilityTimeout().hashCode();
        }
        return hashCode + i;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public void setReceiptHandle(String str) {
        this.receiptHandle = str;
    }

    public void setVisibilityTimeout(Integer num) {
        this.visibilityTimeout = num;
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
        if (this.visibilityTimeout != null) {
            stringBuilder.append("VisibilityTimeout: " + this.visibilityTimeout + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ChangeMessageVisibilityRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }

    public ChangeMessageVisibilityRequest withReceiptHandle(String str) {
        this.receiptHandle = str;
        return this;
    }

    public ChangeMessageVisibilityRequest withVisibilityTimeout(Integer num) {
        this.visibilityTimeout = num;
        return this;
    }
}
