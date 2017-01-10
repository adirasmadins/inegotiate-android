package com.amazonaws.services.sqs.model;

public class SendMessageBatchRequestEntry {
    private Integer delaySeconds;
    private String id;
    private String messageBody;

    public SendMessageBatchRequestEntry(String str, String str2) {
        this.id = str;
        this.messageBody = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendMessageBatchRequestEntry)) {
            return false;
        }
        SendMessageBatchRequestEntry sendMessageBatchRequestEntry = (SendMessageBatchRequestEntry) obj;
        if (((sendMessageBatchRequestEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageBatchRequestEntry.getId() != null && !sendMessageBatchRequestEntry.getId().equals(getId())) {
            return false;
        }
        if (((sendMessageBatchRequestEntry.getMessageBody() == null ? 1 : 0) ^ (getMessageBody() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageBatchRequestEntry.getMessageBody() != null && !sendMessageBatchRequestEntry.getMessageBody().equals(getMessageBody())) {
            return false;
        }
        return ((sendMessageBatchRequestEntry.getDelaySeconds() == null ? 1 : 0) ^ (getDelaySeconds() == null ? 1 : 0)) == 0 ? sendMessageBatchRequestEntry.getDelaySeconds() == null || sendMessageBatchRequestEntry.getDelaySeconds().equals(getDelaySeconds()) : false;
    }

    public Integer getDelaySeconds() {
        return this.delaySeconds;
    }

    public String getId() {
        return this.id;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMessageBody() == null ? 0 : getMessageBody().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31;
        if (getDelaySeconds() != null) {
            i = getDelaySeconds().hashCode();
        }
        return hashCode + i;
    }

    public void setDelaySeconds(Integer num) {
        this.delaySeconds = num;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessageBody(String str) {
        this.messageBody = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
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

    public SendMessageBatchRequestEntry withDelaySeconds(Integer num) {
        this.delaySeconds = num;
        return this;
    }

    public SendMessageBatchRequestEntry withId(String str) {
        this.id = str;
        return this;
    }

    public SendMessageBatchRequestEntry withMessageBody(String str) {
        this.messageBody = str;
        return this;
    }
}
