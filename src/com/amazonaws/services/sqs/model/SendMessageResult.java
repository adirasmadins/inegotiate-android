package com.amazonaws.services.sqs.model;

public class SendMessageResult {
    private String mD5OfMessageBody;
    private String messageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendMessageResult)) {
            return false;
        }
        SendMessageResult sendMessageResult = (SendMessageResult) obj;
        if (((sendMessageResult.getMD5OfMessageBody() == null ? 1 : 0) ^ (getMD5OfMessageBody() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageResult.getMD5OfMessageBody() != null && !sendMessageResult.getMD5OfMessageBody().equals(getMD5OfMessageBody())) {
            return false;
        }
        return ((sendMessageResult.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) == 0 ? sendMessageResult.getMessageId() == null || sendMessageResult.getMessageId().equals(getMessageId()) : false;
    }

    public String getMD5OfMessageBody() {
        return this.mD5OfMessageBody;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMD5OfMessageBody() == null ? 0 : getMD5OfMessageBody().hashCode()) + 31) * 31;
        if (getMessageId() != null) {
            i = getMessageId().hashCode();
        }
        return hashCode + i;
    }

    public void setMD5OfMessageBody(String str) {
        this.mD5OfMessageBody = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.mD5OfMessageBody != null) {
            stringBuilder.append("MD5OfMessageBody: " + this.mD5OfMessageBody + ", ");
        }
        if (this.messageId != null) {
            stringBuilder.append("MessageId: " + this.messageId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendMessageResult withMD5OfMessageBody(String str) {
        this.mD5OfMessageBody = str;
        return this;
    }

    public SendMessageResult withMessageId(String str) {
        this.messageId = str;
        return this;
    }
}
