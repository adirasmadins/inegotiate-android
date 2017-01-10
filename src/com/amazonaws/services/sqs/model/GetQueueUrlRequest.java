package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetQueueUrlRequest extends AmazonWebServiceRequest {
    private String queueName;
    private String queueOwnerAWSAccountId;

    public GetQueueUrlRequest(String str) {
        this.queueName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetQueueUrlRequest)) {
            return false;
        }
        GetQueueUrlRequest getQueueUrlRequest = (GetQueueUrlRequest) obj;
        if (((getQueueUrlRequest.getQueueName() == null ? 1 : 0) ^ (getQueueName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getQueueUrlRequest.getQueueName() != null && !getQueueUrlRequest.getQueueName().equals(getQueueName())) {
            return false;
        }
        return ((getQueueUrlRequest.getQueueOwnerAWSAccountId() == null ? 1 : 0) ^ (getQueueOwnerAWSAccountId() == null ? 1 : 0)) == 0 ? getQueueUrlRequest.getQueueOwnerAWSAccountId() == null || getQueueUrlRequest.getQueueOwnerAWSAccountId().equals(getQueueOwnerAWSAccountId()) : false;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public String getQueueOwnerAWSAccountId() {
        return this.queueOwnerAWSAccountId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueName() == null ? 0 : getQueueName().hashCode()) + 31) * 31;
        if (getQueueOwnerAWSAccountId() != null) {
            i = getQueueOwnerAWSAccountId().hashCode();
        }
        return hashCode + i;
    }

    public void setQueueName(String str) {
        this.queueName = str;
    }

    public void setQueueOwnerAWSAccountId(String str) {
        this.queueOwnerAWSAccountId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueName != null) {
            stringBuilder.append("QueueName: " + this.queueName + ", ");
        }
        if (this.queueOwnerAWSAccountId != null) {
            stringBuilder.append("QueueOwnerAWSAccountId: " + this.queueOwnerAWSAccountId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetQueueUrlRequest withQueueName(String str) {
        this.queueName = str;
        return this;
    }

    public GetQueueUrlRequest withQueueOwnerAWSAccountId(String str) {
        this.queueOwnerAWSAccountId = str;
        return this;
    }
}
