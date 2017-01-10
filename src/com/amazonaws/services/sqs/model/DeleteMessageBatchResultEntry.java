package com.amazonaws.services.sqs.model;

public class DeleteMessageBatchResultEntry {
    private String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteMessageBatchResultEntry)) {
            return false;
        }
        DeleteMessageBatchResultEntry deleteMessageBatchResultEntry = (DeleteMessageBatchResultEntry) obj;
        return ((deleteMessageBatchResultEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) == 0 ? deleteMessageBatchResultEntry.getId() == null || deleteMessageBatchResultEntry.getId().equals(getId()) : false;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return (getId() == null ? 0 : getId().hashCode()) + 31;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteMessageBatchResultEntry withId(String str) {
        this.id = str;
        return this;
    }
}
