package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ModifyVolumeAttributeRequest extends AmazonWebServiceRequest {
    private Boolean autoEnableIO;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifyVolumeAttributeRequest)) {
            return false;
        }
        ModifyVolumeAttributeRequest modifyVolumeAttributeRequest = (ModifyVolumeAttributeRequest) obj;
        if (((modifyVolumeAttributeRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyVolumeAttributeRequest.getVolumeId() != null && !modifyVolumeAttributeRequest.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        return ((modifyVolumeAttributeRequest.isAutoEnableIO() == null ? 1 : 0) ^ (isAutoEnableIO() == null ? 1 : 0)) == 0 ? modifyVolumeAttributeRequest.isAutoEnableIO() == null || modifyVolumeAttributeRequest.isAutoEnableIO().equals(isAutoEnableIO()) : false;
    }

    public Boolean getAutoEnableIO() {
        return this.autoEnableIO;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31;
        if (isAutoEnableIO() != null) {
            i = isAutoEnableIO().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isAutoEnableIO() {
        return this.autoEnableIO;
    }

    public void setAutoEnableIO(Boolean bool) {
        this.autoEnableIO = bool;
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
        if (this.autoEnableIO != null) {
            stringBuilder.append("AutoEnableIO: " + this.autoEnableIO + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ModifyVolumeAttributeRequest withAutoEnableIO(Boolean bool) {
        this.autoEnableIO = bool;
        return this;
    }

    public ModifyVolumeAttributeRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
