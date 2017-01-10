package com.amazonaws.services.ec2.model;

import java.util.Date;

public class InstanceNetworkInterfaceAttachment {
    private Date attachTime;
    private String attachmentId;
    private Boolean deleteOnTermination;
    private Integer deviceIndex;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterfaceAttachment)) {
            return false;
        }
        InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment = (InstanceNetworkInterfaceAttachment) obj;
        if (((instanceNetworkInterfaceAttachment.getAttachmentId() == null ? 1 : 0) ^ (getAttachmentId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.getAttachmentId() != null && !instanceNetworkInterfaceAttachment.getAttachmentId().equals(getAttachmentId())) {
            return false;
        }
        if (((instanceNetworkInterfaceAttachment.getDeviceIndex() == null ? 1 : 0) ^ (getDeviceIndex() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.getDeviceIndex() != null && !instanceNetworkInterfaceAttachment.getDeviceIndex().equals(getDeviceIndex())) {
            return false;
        }
        if (((instanceNetworkInterfaceAttachment.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.getStatus() != null && !instanceNetworkInterfaceAttachment.getStatus().equals(getStatus())) {
            return false;
        }
        if (((instanceNetworkInterfaceAttachment.getAttachTime() == null ? 1 : 0) ^ (getAttachTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.getAttachTime() != null && !instanceNetworkInterfaceAttachment.getAttachTime().equals(getAttachTime())) {
            return false;
        }
        return ((instanceNetworkInterfaceAttachment.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) == 0 ? instanceNetworkInterfaceAttachment.isDeleteOnTermination() == null || instanceNetworkInterfaceAttachment.isDeleteOnTermination().equals(isDeleteOnTermination()) : false;
    }

    public Date getAttachTime() {
        return this.attachTime;
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public Integer getDeviceIndex() {
        return this.deviceIndex;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttachTime() == null ? 0 : getAttachTime().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getDeviceIndex() == null ? 0 : getDeviceIndex().hashCode()) + (((getAttachmentId() == null ? 0 : getAttachmentId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
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

    public void setAttachmentId(String str) {
        this.attachmentId = str;
    }

    public void setDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
    }

    public void setDeviceIndex(Integer num) {
        this.deviceIndex = num;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attachmentId != null) {
            stringBuilder.append("AttachmentId: " + this.attachmentId + ", ");
        }
        if (this.deviceIndex != null) {
            stringBuilder.append("DeviceIndex: " + this.deviceIndex + ", ");
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

    public InstanceNetworkInterfaceAttachment withAttachTime(Date date) {
        this.attachTime = date;
        return this;
    }

    public InstanceNetworkInterfaceAttachment withAttachmentId(String str) {
        this.attachmentId = str;
        return this;
    }

    public InstanceNetworkInterfaceAttachment withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public InstanceNetworkInterfaceAttachment withDeviceIndex(Integer num) {
        this.deviceIndex = num;
        return this;
    }

    public InstanceNetworkInterfaceAttachment withStatus(String str) {
        this.status = str;
        return this;
    }
}
