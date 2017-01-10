package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class EnableVolumeIORequest extends AmazonWebServiceRequest {
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableVolumeIORequest)) {
            return false;
        }
        EnableVolumeIORequest enableVolumeIORequest = (EnableVolumeIORequest) obj;
        return ((enableVolumeIORequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) == 0 ? enableVolumeIORequest.getVolumeId() == null || enableVolumeIORequest.getVolumeId().equals(getVolumeId()) : false;
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

    public EnableVolumeIORequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
