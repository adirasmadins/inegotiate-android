package com.amazonaws.services.sqs.model;

public class CreateQueueResult {
    private String queueUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateQueueResult)) {
            return false;
        }
        CreateQueueResult createQueueResult = (CreateQueueResult) obj;
        return ((createQueueResult.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) == 0 ? createQueueResult.getQueueUrl() == null || createQueueResult.getQueueUrl().equals(getQueueUrl()) : false;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        return (getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrl != null) {
            stringBuilder.append("QueueUrl: " + this.queueUrl + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateQueueResult withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
