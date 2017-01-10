package com.amazonaws.services.ec2.model;

import java.util.Date;

public class VolumeAttachment {
    private Date attachTime;
    private Boolean deleteOnTermination;
    private String device;
    private String instanceId;
    private String state;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeAttachment)) {
            return false;
        }
        VolumeAttachment volumeAttachment = (VolumeAttachment) obj;
        if (((volumeAttachment.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeAttachment.getVolumeId() != null && !volumeAttachment.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((volumeAttachment.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeAttachment.getInstanceId() != null && !volumeAttachment.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((volumeAttachment.getDevice() == null ? 1 : 0) ^ (getDevice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeAttachment.getDevice() != null && !volumeAttachment.getDevice().equals(getDevice())) {
            return false;
        }
        if (((volumeAttachment.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeAttachment.getState() != null && !volumeAttachment.getState().equals(getState())) {
            return false;
        }
        if (((volumeAttachment.getAttachTime() == null ? 1 : 0) ^ (getAttachTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeAttachment.getAttachTime() != null && !volumeAttachment.getAttachTime().equals(getAttachTime())) {
            return false;
        }
        return ((volumeAttachment.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) == 0 ? volumeAttachment.isDeleteOnTermination() == null || volumeAttachment.isDeleteOnTermination().equals(isDeleteOnTermination()) : false;
    }

    public Date getAttachTime() {
        return this.attachTime;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public String getDevice() {
        return this.device;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getState() {
        return this.state;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttachTime() == null ? 0 : getAttachTime().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getDevice() == null ? 0 : getDevice().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (isDeleteOnTermination() != null) {
            i = isDeleteOnTermination().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public void setAttachTime(Date date) {
        this.attachTime = date;
    }

    public void setDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setState(VolumeAttachmentState volumeAttachmentState) {
        this.state = volumeAttachmentState.toString();
    }

    public void setState(String str) {
        this.state = str;
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
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.attachTime != null) {
            stringBuilder.append("AttachTime: " + this.attachTime + ", ");
        }
        if (this.deleteOnTermination != null) {
            stringBuilder.append("DeleteOnTermination: " + this.deleteOnTermination + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeAttachment withAttachTime(Date date) {
        this.attachTime = date;
        return this;
    }

    public VolumeAttachment withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public VolumeAttachment withDevice(String str) {
        this.device = str;
        return this;
    }

    public VolumeAttachment withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public VolumeAttachment withState(VolumeAttachmentState volumeAttachmentState) {
        this.state = volumeAttachmentState.toString();
        return this;
    }

    public VolumeAttachment withState(String str) {
        this.state = str;
        return this;
    }

    public VolumeAttachment withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
