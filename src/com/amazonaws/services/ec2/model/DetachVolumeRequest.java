package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DetachVolumeRequest extends AmazonWebServiceRequest {
    private String device;
    private Boolean force;
    private String instanceId;
    private String volumeId;

    public DetachVolumeRequest(String str) {
        this.volumeId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DetachVolumeRequest)) {
            return false;
        }
        DetachVolumeRequest detachVolumeRequest = (DetachVolumeRequest) obj;
        if (((detachVolumeRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (detachVolumeRequest.getVolumeId() != null && !detachVolumeRequest.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((detachVolumeRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (detachVolumeRequest.getInstanceId() != null && !detachVolumeRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((detachVolumeRequest.getDevice() == null ? 1 : 0) ^ (getDevice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (detachVolumeRequest.getDevice() != null && !detachVolumeRequest.getDevice().equals(getDevice())) {
            return false;
        }
        return ((detachVolumeRequest.isForce() == null ? 1 : 0) ^ (isForce() == null ? 1 : 0)) == 0 ? detachVolumeRequest.isForce() == null || detachVolumeRequest.isForce().equals(isForce()) : false;
    }

    public String getDevice() {
        return this.device;
    }

    public Boolean getForce() {
        return this.force;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDevice() == null ? 0 : getDevice().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (isForce() != null) {
            i = isForce().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isForce() {
        return this.force;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setForce(Boolean bool) {
        this.force = bool;
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
        if (this.force != null) {
            stringBuilder.append("Force: " + this.force + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DetachVolumeRequest withDevice(String str) {
        this.device = str;
        return this;
    }

    public DetachVolumeRequest withForce(Boolean bool) {
        this.force = bool;
        return this;
    }

    public DetachVolumeRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public DetachVolumeRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
