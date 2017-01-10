package com.amazonaws.services.ec2.model;

public class EbsBlockDevice {
    private Boolean deleteOnTermination;
    private Integer iops;
    private String snapshotId;
    private Integer volumeSize;
    private String volumeType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EbsBlockDevice)) {
            return false;
        }
        EbsBlockDevice ebsBlockDevice = (EbsBlockDevice) obj;
        if (((ebsBlockDevice.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsBlockDevice.getSnapshotId() != null && !ebsBlockDevice.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((ebsBlockDevice.getVolumeSize() == null ? 1 : 0) ^ (getVolumeSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsBlockDevice.getVolumeSize() != null && !ebsBlockDevice.getVolumeSize().equals(getVolumeSize())) {
            return false;
        }
        if (((ebsBlockDevice.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsBlockDevice.isDeleteOnTermination() != null && !ebsBlockDevice.isDeleteOnTermination().equals(isDeleteOnTermination())) {
            return false;
        }
        if (((ebsBlockDevice.getVolumeType() == null ? 1 : 0) ^ (getVolumeType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebsBlockDevice.getVolumeType() != null && !ebsBlockDevice.getVolumeType().equals(getVolumeType())) {
            return false;
        }
        return ((ebsBlockDevice.getIops() == null ? 1 : 0) ^ (getIops() == null ? 1 : 0)) == 0 ? ebsBlockDevice.getIops() == null || ebsBlockDevice.getIops().equals(getIops()) : false;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public Integer getIops() {
        return this.iops;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public Integer getVolumeSize() {
        return this.volumeSize;
    }

    public String getVolumeType() {
        return this.volumeType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeType() == null ? 0 : getVolumeType().hashCode()) + (((isDeleteOnTermination() == null ? 0 : isDeleteOnTermination().hashCode()) + (((getVolumeSize() == null ? 0 : getVolumeSize().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getIops() != null) {
            i = getIops().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
    }

    public void setIops(Integer num) {
        this.iops = num;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
    }

    public void setVolumeSize(Integer num) {
        this.volumeSize = num;
    }

    public void setVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType.toString();
    }

    public void setVolumeType(String str) {
        this.volumeType = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.volumeSize != null) {
            stringBuilder.append("VolumeSize: " + this.volumeSize + ", ");
        }
        if (this.deleteOnTermination != null) {
            stringBuilder.append("DeleteOnTermination: " + this.deleteOnTermination + ", ");
        }
        if (this.volumeType != null) {
            stringBuilder.append("VolumeType: " + this.volumeType + ", ");
        }
        if (this.iops != null) {
            stringBuilder.append("Iops: " + this.iops + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EbsBlockDevice withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public EbsBlockDevice withIops(Integer num) {
        this.iops = num;
        return this;
    }

    public EbsBlockDevice withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public EbsBlockDevice withVolumeSize(Integer num) {
        this.volumeSize = num;
        return this;
    }

    public EbsBlockDevice withVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType.toString();
        return this;
    }

    public EbsBlockDevice withVolumeType(String str) {
        this.volumeType = str;
        return this;
    }
}
