package com.amazonaws.services.sqs.model;

public class ChangeMessageVisibilityBatchRequestEntry {
    private String id;
    private String receiptHandle;
    private Integer visibilityTimeout;

    public ChangeMessageVisibilityBatchRequestEntry(String str, String str2) {
        this.id = str;
        this.receiptHandle = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeMessageVisibilityBatchRequestEntry)) {
            return false;
        }
        ChangeMessageVisibilityBatchRequestEntry changeMessageVisibilityBatchRequestEntry = (ChangeMessageVisibilityBatchRequestEntry) obj;
        if (((changeMessageVisibilityBatchRequestEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityBatchRequestEntry.getId() != null && !changeMessageVisibilityBatchRequestEntry.getId().equals(getId())) {
            return false;
        }
        if (((changeMessageVisibilityBatchRequestEntry.getReceiptHandle() == null ? 1 : 0) ^ (getReceiptHandle() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityBatchRequestEntry.getReceiptHandle() != null && !changeMessageVisibilityBatchRequestEntry.getReceiptHandle().equals(getReceiptHandle())) {
            return false;
        }
        return ((changeMessageVisibilityBatchRequestEntry.getVisibilityTimeout() == null ? 1 : 0) ^ (getVisibilityTimeout() == null ? 1 : 0)) == 0 ? changeMessageVisibilityBatchRequestEntry.getVisibilityTimeout() == null || changeMessageVisibilityBatchRequestEntry.getVisibilityTimeout().equals(getVisibilityTimeout()) : false;
    }

    public String getId() {
        return this.id;
    }

    public String getReceiptHandle() {
        return this.receiptHandle;
    }

    public Integer getVisibilityTimeout() {
        return this.visibilityTimeout;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReceiptHandle() == null ? 0 : getReceiptHandle().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31;
        if (getVisibilityTimeout() != null) {
            i = getVisibilityTimeout().hashCode();
        }
        return hashCode + i;
    }

    public void setId(String str) {
        this.id = str;
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
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
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

    public ChangeMessageVisibilityBatchRequestEntry withId(String str) {
        this.id = str;
        return this;
    }

    public ChangeMessageVisibilityBatchRequestEntry withReceiptHandle(String str) {
        this.receiptHandle = str;
        return this;
    }

    public ChangeMessageVisibilityBatchRequestEntry withVisibilityTimeout(Integer num) {
        this.visibilityTimeout = num;
        return this;
    }
}
