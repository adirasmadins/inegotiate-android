package com.amazonaws.services.sqs.model;

public class DeleteMessageBatchRequestEntry {
    private String id;
    private String receiptHandle;

    public DeleteMessageBatchRequestEntry(String str, String str2) {
        this.id = str;
        this.receiptHandle = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteMessageBatchRequestEntry)) {
            return false;
        }
        DeleteMessageBatchRequestEntry deleteMessageBatchRequestEntry = (DeleteMessageBatchRequestEntry) obj;
        if (((deleteMessageBatchRequestEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteMessageBatchRequestEntry.getId() != null && !deleteMessageBatchRequestEntry.getId().equals(getId())) {
            return false;
        }
        return ((deleteMessageBatchRequestEntry.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) == 0 ? deleteMessageBatchRequestEntry.getReceiptHandle() == null || deleteMessageBatchRequestEntry.getReceiptHandle().equals(getReceiptHandle()) : false;
    }

    public String getId() {
        return this.id;
    }

    public String getReceiptHandle() {
        return this.receiptHandle;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getId() == null ? 0 : getId().hashCode()) + 31) * 31;
        if (getReceiptHandle() != null) {
            i = getReceiptHandle().hashCode();
        }
        return hashCode + i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setReceiptHandle(String str) {
        this.receiptHandle = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        if (this.receiptHandle != null) {
            stringBuilder.append("ReceiptHandle: " + this.receiptHandle + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteMessageBatchRequestEntry withId(String str) {
        this.id = str;
        return this;
    }

    public DeleteMessageBatchRequestEntry withReceiptHandle(String str) {
        this.receiptHandle = str;
        return this;
    }
}
