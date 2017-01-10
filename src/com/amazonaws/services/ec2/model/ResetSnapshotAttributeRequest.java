package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ResetSnapshotAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String snapshotId;

    public ResetSnapshotAttributeRequest(String str, SnapshotAttributeName snapshotAttributeName) {
        this.snapshotId = str;
        this.attribute = snapshotAttributeName.toString();
    }

    public ResetSnapshotAttributeRequest(String str, String str2) {
        this.snapshotId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResetSnapshotAttributeRequest)) {
            return false;
        }
        ResetSnapshotAttributeRequest resetSnapshotAttributeRequest = (ResetSnapshotAttributeRequest) obj;
        if (((resetSnapshotAttributeRequest.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (resetSnapshotAttributeRequest.getSnapshotId() != null && !resetSnapshotAttributeRequest.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        return ((resetSnapshotAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? resetSnapshotAttributeRequest.getAttribute() == null || resetSnapshotAttributeRequest.getAttribute().equals(getAttribute()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31;
        if (getAttribute() != null) {
            i = getAttribute().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(SnapshotAttributeName snapshotAttributeName) {
        this.attribute = snapshotAttributeName.toString();
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ResetSnapshotAttributeRequest withAttribute(SnapshotAttributeName snapshotAttributeName) {
        this.attribute = snapshotAttributeName.toString();
        return this;
    }

    public ResetSnapshotAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public ResetSnapshotAttributeRequest withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }
}
