package com.amazonaws.services.sqs.model;

public class ChangeMessageVisibilityBatchResultEntry {
    private String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeMessageVisibilityBatchResultEntry)) {
            return false;
        }
        ChangeMessageVisibilityBatchResultEntry changeMessageVisibilityBatchResultEntry = (ChangeMessageVisibilityBatchResultEntry) obj;
        return ((changeMessageVisibilityBatchResultEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) == 0 ? changeMessageVisibilityBatchResultEntry.getId() == null || changeMessageVisibilityBatchResultEntry.getId().equals(getId()) : false;
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

    public ChangeMessageVisibilityBatchResultEntry withId(String str) {
        this.id = str;
        return this;
    }
}
