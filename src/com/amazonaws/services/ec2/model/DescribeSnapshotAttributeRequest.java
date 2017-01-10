package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeSnapshotAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String snapshotId;

    public DescribeSnapshotAttributeRequest(String str, SnapshotAttributeName snapshotAttributeName) {
        this.snapshotId = str;
        this.attribute = snapshotAttributeName.toString();
    }

    public DescribeSnapshotAttributeRequest(String str, String str2) {
        this.snapshotId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSnapshotAttributeRequest)) {
            return false;
        }
        DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest = (DescribeSnapshotAttributeRequest) obj;
        if (((describeSnapshotAttributeRequest.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotAttributeRequest.getSnapshotId() != null && !describeSnapshotAttributeRequest.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        return ((describeSnapshotAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? describeSnapshotAttributeRequest.getAttribute() == null || describeSnapshotAttributeRequest.getAttribute().equals(getAttribute()) : false;
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

    public DescribeSnapshotAttributeRequest withAttribute(SnapshotAttributeName snapshotAttributeName) {
        this.attribute = snapshotAttributeName.toString();
        return this;
    }

    public DescribeSnapshotAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public DescribeSnapshotAttributeRequest withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }
}
