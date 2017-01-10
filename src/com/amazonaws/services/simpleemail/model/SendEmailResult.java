package com.amazonaws.services.simpleemail.model;

public class SendEmailResult {
    private String messageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendEmailResult)) {
            return false;
        }
        SendEmailResult sendEmailResult = (SendEmailResult) obj;
        return ((sendEmailResult.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) == 0 ? sendEmailResult.getMessageId() == null || sendEmailResult.getMessageId().equals(getMessageId()) : false;
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

    public SendEmailResult withMessageId(String str) {
        this.messageId = str;
        return this;
    }
}
