package com.amazonaws.services.ec2.model;

import java.util.Date;

public class EbsInstanceBlockDevice {
    private Date attachTime;
    private Boolean deleteOnTermination;
    private String status;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EbsInstanceBlockDevice)) {
            return false;
        }
        EbsInstanceBlockDevice ebsInstanceBlockDevice = (EbsInstanceBlockDevice) obj;
        if (((ebsInstanceBlockDevice.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsInstanceBlockDevice.getVolumeId() != null && !ebsInstanceBlockDevice.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((ebsInstanceBlockDevice.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsInstanceBlockDevice.getStatus() != null && !ebsInstanceBlockDevice.getStatus().equals(getStatus())) {
            return false;
        }
        if (((ebsInstanceBlockDevice.getAttachTime() == null ? 1 : 0) ^ (getAttachTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsInstanceBlockDevice.getAttachTime() != null && !ebsInstanceBlockDevice.getAttachTime().equals(getAttachTime())) {
            return false;
        }
        return ((ebsInstanceBlockDevice.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) == 0 ? ebsInstanceBlockDevice.isDeleteOnTermination() == null || ebsInstanceBlockDevice.isDeleteOnTermination().equals(isDeleteOnTermination()) : false;
    }

    public Date getAttachTime() {
        return this.attachTime;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public String getStatus() {
        return this.status;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttachTime() == null ? 0 : getAttachTime().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31)) * 31;
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

    public void setStatus(String str) {
        this.status = str;
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
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
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

    public EbsInstanceBlockDevice withAttachTime(Date date) {
        this.attachTime = date;
        return this;
    }

    public EbsInstanceBlockDevice withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public EbsInstanceBlockDevice withStatus(String str) {
        this.status = str;
        return this;
    }

    public EbsInstanceBlockDevice withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
