package com.amazonaws.services.sqs.model;

public class SendMessageBatchResultEntry {
    private String id;
    private String mD5OfMessageBody;
    private String messageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendMessageBatchResultEntry)) {
            return false;
        }
        SendMessageBatchResultEntry sendMessageBatchResultEntry = (SendMessageBatchResultEntry) obj;
        if (((sendMessageBatchResultEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageBatchResultEntry.getId() != null && !sendMessageBatchResultEntry.getId().equals(getId())) {
            return false;
        }
        if (((sendMessageBatchResultEntry.getMessageId() == null ? 1 : 0) ^ (getMessageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendMessageBatchResultEntry.getMessageId() != null && !sendMessageBatchResultEntry.getMessageId().equals(getMessageId())) {
            return false;
        }
        return ((sendMessageBatchResultEntry.getMD5OfMessageBody() == null ? 1 : 0) ^ (getMD5OfMessageBody() == null ? 1 : 0)) == 0 ? sendMessageBatchResultEntry.getMD5OfMessageBody() == null || sendMessageBatchResultEntry.getMD5OfMessageBody().equals(getMD5OfMessageBody()) : false;
    }

    public String getId() {
        return this.id;
    }

    public String getMD5OfMessageBody() {
        return this.mD5OfMessageBody;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMessageId() == null ? 0 : getMessageId().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31;
        if (getMD5OfMessageBody() != null) {
            i = getMD5OfMessageBody().hashCode();
        }
        return hashCode + i;
    }

    public void setId(String str) {
        this.id = str;
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
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        if (this.messageId != null) {
            stringBuilder.append("MessageId: " + this.messageId + ", ");
        }
        if (this.mD5OfMessageBody != null) {
            stringBuilder.append("MD5OfMessageBody: " + this.mD5OfMessageBody + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendMessageBatchResultEntry withId(String str) {
        this.id = str;
        return this;
    }

    public SendMessageBatchResultEntry withMD5OfMessageBody(String str) {
        this.mD5OfMessageBody = str;
        return this;
    }

    public SendMessageBatchResultEntry withMessageId(String str) {
        this.messageId = str;
        return this;
    }
}
