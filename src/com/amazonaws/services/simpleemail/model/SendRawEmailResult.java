package com.amazonaws.services.simpleemail.model;

public class SendRawEmailResult {
    private String messageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendRawEmailResult)) {
            return false;
        }
        SendRawEmailResult sendRawEmailResult = (SendRawEmailResult) obj;
        return ((sendRawEmailResult.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) == 0 ? sendRawEmailResult.getMessageId() == null || sendRawEmailResult.getMessageId().equals(getMessageId()) : false;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        return (getMessageId() == null ? 0 : getMessageId().hashCode()) + 31;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.messageId != null) {
            stringBuilder.append("MessageId: " + this.messageId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendRawEmailResult withMessageId(String str) {
        this.messageId = str;
        return this;
    }
}
