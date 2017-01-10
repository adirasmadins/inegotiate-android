package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;

public class RemovePermissionRequest extends AmazonWebServiceRequest {
    private String label;
    private String queueUrl;

    public RemovePermissionRequest(String str, String str2) {
        this.queueUrl = str;
        this.label = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RemovePermissionRequest)) {
            return false;
        }
        RemovePermissionRequest removePermissionRequest = (RemovePermissionRequest) obj;
        if (((removePermissionRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (removePermissionRequest.getQueueUrl() != null && !removePermissionRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((removePermissionRequest.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) == 0 ? removePermissionRequest.getLabel() == null || removePermissionRequest.getLabel().equals(getLabel()) : false;
    }

    public String getLabel() {
        return this.label;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31;
        if (getLabel() != null) {
            i = getLabel().hashCode();
        }
        return hashCode + i;
    }

    public void setLabel(String str) {
        this.label = str;
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
        if (this.label != null) {
            stringBuilder.append("Label: " + this.label + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RemovePermissionRequest withLabel(String str) {
        this.label = str;
        return this;
    }

    public RemovePermissionRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
