package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class AttachVolumeRequest extends AmazonWebServiceRequest {
    private String device;
    private String instanceId;
    private String volumeId;

    public AttachVolumeRequest(String str, String str2, String str3) {
        this.volumeId = str;
        this.instanceId = str2;
        this.device = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttachVolumeRequest)) {
            return false;
        }
        AttachVolumeRequest attachVolumeRequest = (AttachVolumeRequest) obj;
        if (((attachVolumeRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attachVolumeRequest.getVolumeId() != null && !attachVolumeRequest.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((attachVolumeRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attachVolumeRequest.getInstanceId() != null && !attachVolumeRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((attachVolumeRequest.getDevice() == null ? 1 : 0) ^ (getDevice() == null ? 1 : 0)) == 0 ? attachVolumeRequest.getDevice() == null || attachVolumeRequest.getDevice().equals(getDevice()) : false;
    }

    public String getDevice() {
        return this.device;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31;
        if (getDevice() != null) {
            i = getDevice().hashCode();
        }
        return hashCode + i;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
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
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.device != null) {
            stringBuilder.append("Device: " + this.device + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AttachVolumeRequest withDevice(String str) {
        this.device = str;
        return this;
    }

    public AttachVolumeRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public AttachVolumeRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
