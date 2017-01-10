package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class RemovePermissionRequest extends AmazonWebServiceRequest {
    private String label;
    private String topicArn;

    public RemovePermissionRequest(String str, String str2) {
        this.topicArn = str;
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
        if (((removePermissionRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (removePermissionRequest.getTopicArn() != null && !removePermissionRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        return ((removePermissionRequest.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) == 0 ? removePermissionRequest.getLabel() == null || removePermissionRequest.getLabel().equals(getLabel()) : false;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31;
        if (getLabel() != null) {
            i = getLabel().hashCode();
        }
        return hashCode + i;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
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

    public RemovePermissionRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
