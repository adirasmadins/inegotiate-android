package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateVolumeRequest extends AmazonWebServiceRequest {
    private String availabilityZone;
    private Integer iops;
    private Integer size;
    private String snapshotId;
    private String volumeType;

    public CreateVolumeRequest(Integer num, String str) {
        this.size = num;
        this.availabilityZone = str;
    }

    public CreateVolumeRequest(String str, String str2) {
        this.snapshotId = str;
        this.availabilityZone = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateVolumeRequest)) {
            return false;
        }
        CreateVolumeRequest createVolumeRequest = (CreateVolumeRequest) obj;
        if (((createVolumeRequest.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createVolumeRequest.getSize() != null && !createVolumeRequest.getSize().equals(getSize())) {
            return false;
        }
        if (((createVolumeRequest.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createVolumeRequest.getSnapshotId() != null && !createVolumeRequest.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((createVolumeRequest.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createVolumeRequest.getAvailabilityZone() != null && !createVolumeRequest.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((createVolumeRequest.getVolumeType() == null ? 1 : 0) ^ (getVolumeType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createVolumeRequest.getVolumeType() != null && !createVolumeRequest.getVolumeType().equals(getVolumeType())) {
            return false;
        }
        return ((createVolumeRequest.getIops() == null ? 1 : 0) ^ (getIops() == null ? 1 : 0)) == 0 ? createVolumeRequest.getIops() == null || createVolumeRequest.getIops().equals(getIops()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public Integer getIops() {
        return this.iops;
    }

    public Integer getSize() {
        return this.size;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public String getVolumeType() {
        return this.volumeType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeType() == null ? 0 : getVolumeType().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + (((getSize() == null ? 0 : getSize().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getIops() != null) {
            i = getIops().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setIops(Integer num) {
        this.iops = num;
    }

    public void setSize(Integer num) {
        this.size = num;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
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
        if (this.size != null) {
            stringBuilder.append("Size: " + this.size + ", ");
        }
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
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

    public CreateVolumeRequest withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public CreateVolumeRequest withIops(Integer num) {
        this.iops = num;
        return this;
    }

    public CreateVolumeRequest withSize(Integer num) {
        this.size = num;
        return this;
    }

    public CreateVolumeRequest withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public CreateVolumeRequest withVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType.toString();
        return this;
    }

    public CreateVolumeRequest withVolumeType(String str) {
        this.volumeType = str;
        return this;
    }
}
