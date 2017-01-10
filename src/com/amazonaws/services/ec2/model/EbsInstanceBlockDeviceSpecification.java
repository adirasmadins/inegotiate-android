package com.amazonaws.services.ec2.model;

public class EbsInstanceBlockDeviceSpecification {
    private Boolean deleteOnTermination;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EbsInstanceBlockDeviceSpecification)) {
            return false;
        }
        EbsInstanceBlockDeviceSpecification ebsInstanceBlockDeviceSpecification = (EbsInstanceBlockDeviceSpecification) obj;
        if (((ebsInstanceBlockDeviceSpecification.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsInstanceBlockDeviceSpecification.getVolumeId() != null && !ebsInstanceBlockDeviceSpecification.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        return ((ebsInstanceBlockDeviceSpecification.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) == 0 ? ebsInstanceBlockDeviceSpecification.isDeleteOnTermination() == null || ebsInstanceBlockDeviceSpecification.isDeleteOnTermination().equals(isDeleteOnTermination()) : false;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31;
        if (isDeleteOnTermination() != null) {
            i = isDeleteOnTermination().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
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
        if (this.deleteOnTermination != null) {
            stringBuilder.append("DeleteOnTermination: " + this.deleteOnTermination + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EbsInstanceBlockDeviceSpecification withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public EbsInstanceBlockDeviceSpecification withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
