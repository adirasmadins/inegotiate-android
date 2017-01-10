package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteVolumeRequest extends AmazonWebServiceRequest {
    private String volumeId;

    public DeleteVolumeRequest(String str) {
        this.volumeId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteVolumeRequest)) {
            return false;
        }
        DeleteVolumeRequest deleteVolumeRequest = (DeleteVolumeRequest) obj;
        return ((deleteVolumeRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) == 0 ? deleteVolumeRequest.getVolumeId() == null || deleteVolumeRequest.getVolumeId().equals(getVolumeId()) : false;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        return (getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteVolumeRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
