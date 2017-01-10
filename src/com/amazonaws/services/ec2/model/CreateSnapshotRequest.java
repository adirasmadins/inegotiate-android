package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateSnapshotRequest extends AmazonWebServiceRequest {
    private String description;
    private String volumeId;

    public CreateSnapshotRequest(String str, String str2) {
        this.volumeId = str;
        this.description = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSnapshotRequest)) {
            return false;
        }
        CreateSnapshotRequest createSnapshotRequest = (CreateSnapshotRequest) obj;
        if (((createSnapshotRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createSnapshotRequest.getVolumeId() != null && !createSnapshotRequest.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        return ((createSnapshotRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? createSnapshotRequest.getDescription() == null || createSnapshotRequest.getDescription().equals(getDescription()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setVolumeId(String str) {
        this.volumeId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateSnapshotRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateSnapshotRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
