package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SendMessageRequest extends AmazonWebServiceRequest {
    private Integer delaySeconds;
    private String messageBody;
    private String queueUrl;

    public SendMessageRequest(String str, String str2) {
        this.queueUrl = str;
        this.messageBody = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendMessageRequest)) {
            return false;
        }
        SendMessageRequest sendMessageRequest = (SendMessageRequest) obj;
        if (((sendMessageRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageRequest.getQueueUrl() != null && !sendMessageRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        if (((sendMessageRequest.getMessageBody() == null ? 1 : 0) ^ (getMessageBody() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageRequest.getMessageBody() != null && !sendMessageRequest.getMessageBody().equals(getMessageBody())) {
            return false;
        }
        return ((sendMessageRequest.getDelaySeconds() == null ? 1 : 0) ^ (getDelaySeconds() == null ? 1 : 0)) == 0 ? sendMessageRequest.getDelaySeconds() == null || sendMessageRequest.getDelaySeconds().equals(getDelaySeconds()) : false;
    }

    public Integer getDelaySeconds() {
        return this.delaySeconds;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMessageBody() == null ? 0 : getMessageBody().hashCode()) + (((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31)) * 31;
        if (getDelaySeconds() != null) {
            i = getDelaySeconds().hashCode();
        }
        return hashCode + i;
    }

    public void setDelaySeconds(Integer num) {
        this.delaySeconds = num;
    }

    public void setMessageBody(String str) {
        this.messageBody = str;
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
        if (this.messageBody != null) {
            stringBuilder.append("MessageBody: " + this.messageBody + ", ");
        }
        if (this.delaySeconds != null) {
            stringBuilder.append("DelaySeconds: " + this.delaySeconds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendMessageRequest withDelaySeconds(Integer num) {
        this.delaySeconds = num;
        return this;
    }

    public SendMessageRequest withMessageBody(String str) {
        this.messageBody = str;
        return this;
    }

    public SendMessageRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
