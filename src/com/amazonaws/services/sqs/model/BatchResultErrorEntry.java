package com.amazonaws.services.sqs.model;

public class BatchResultErrorEntry {
    private String code;
    private String id;
    private String message;
    private Boolean senderFault;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BatchResultErrorEntry)) {
            return false;
        }
        BatchResultErrorEntry batchResultErrorEntry = (BatchResultErrorEntry) obj;
        if (((batchResultErrorEntry.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchResultErrorEntry.getId() != null && !batchResultErrorEntry.getId().equals(getId())) {
            return false;
        }
        if (((batchResultErrorEntry.isSenderFault() == null ? 1 : 0) ^ (isSenderFault() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchResultErrorEntry.isSenderFault() != null && !batchResultErrorEntry.isSenderFault().equals(isSenderFault())) {
            return false;
        }
        if (((batchResultErrorEntry.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (batchResultErrorEntry.getCode() != null && !batchResultErrorEntry.getCode().equals(getCode())) {
            return false;
        }
        return ((batchResultErrorEntry.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) == 0 ? batchResultErrorEntry.getMessage() == null || batchResultErrorEntry.getMessage().equals(getMessage()) : false;
    }

    public String getCode() {
        return this.code;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getSenderFault() {
        return this.senderFault;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCode() == null ? 0 : getCode().hashCode()) + (((isSenderFault() == null ? 0 : isSenderFault().hashCode()) + (((getId() == null ? 0 : getId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMessage() != null) {
            i = getMessage().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isSenderFault() {
        return this.senderFault;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSenderFault(Boolean bool) {
        this.senderFault = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        if (this.senderFault != null) {
            stringBuilder.append("SenderFault: " + this.senderFault + ", ");
        }
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BatchResultErrorEntry withCode(String str) {
        this.code = str;
        return this;
    }

    public BatchResultErrorEntry withId(String str) {
        this.id = str;
        return this;
    }

    public BatchResultErrorEntry withMessage(String str) {
        this.message = str;
        return this;
    }

    public BatchResultErrorEntry withSenderFault(Boolean bool) {
        this.senderFault = bool;
        return this;
    }
}
