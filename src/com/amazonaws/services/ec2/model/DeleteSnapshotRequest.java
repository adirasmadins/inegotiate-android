package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteSnapshotRequest extends AmazonWebServiceRequest {
    private String snapshotId;

    public DeleteSnapshotRequest(String str) {
        this.snapshotId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteSnapshotRequest)) {
            return false;
        }
        DeleteSnapshotRequest deleteSnapshotRequest = (DeleteSnapshotRequest) obj;
        return ((deleteSnapshotRequest.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) == 0 ? deleteSnapshotRequest.getSnapshotId() == null || deleteSnapshotRequest.getSnapshotId().equals(getSnapshotId()) : false;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public int hashCode() {
        return (getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteSnapshotRequest withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }
}
