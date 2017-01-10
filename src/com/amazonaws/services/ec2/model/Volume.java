package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Volume {
    private List<VolumeAttachment> attachments;
    private String availabilityZone;
    private Date createTime;
    private Integer iops;
    private Integer size;
    private String snapshotId;
    private String state;
    private List<Tag> tags;
    private String volumeId;
    private String volumeType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Volume)) {
            return false;
        }
        Volume volume = (Volume) obj;
        if (((volume.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getVolumeId() != null && !volume.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((volume.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getSize() != null && !volume.getSize().equals(getSize())) {
            return false;
        }
        if (((volume.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getSnapshotId() != null && !volume.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((volume.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getAvailabilityZone() != null && !volume.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((volume.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getState() != null && !volume.getState().equals(getState())) {
            return false;
        }
        if (((volume.getCreateTime() == null ? 1 : 0) ^ (getCreateTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getCreateTime() != null && !volume.getCreateTime().equals(getCreateTime())) {
            return false;
        }
        if (((volume.getAttachments() == null ? 1 : 0) ^ (getAttachments() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getAttachments() != null && !volume.getAttachments().equals(getAttachments())) {
            return false;
        }
        if (((volume.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getTags() != null && !volume.getTags().equals(getTags())) {
            return false;
        }
        if (((volume.getVolumeType() == null ? 1 : 0) ^ (getVolumeType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volume.getVolumeType() != null && !volume.getVolumeType().equals(getVolumeType())) {
            return false;
        }
        return ((volume.getIops() == null ? 1 : 0) ^ (getIops() == null ? 1 : 0)) == 0 ? volume.getIops() == null || volume.getIops().equals(getIops()) : false;
    }

    public List<VolumeAttachment> getAttachments() {
        if (this.attachments == null) {
            this.attachments = new ArrayList();
        }
        return this.attachments;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public Date getCreateTime() {
        return this.createTime;
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

    public String getState() {
        return this.state;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public String getVolumeType() {
        return this.volumeType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeType() == null ? 0 : getVolumeType().hashCode()) + (((getTags() == null ? 0 : getTags().hashCode()) + (((getAttachments() == null ? 0 : getAttachments().hashCode()) + (((getCreateTime() == null ? 0 : getCreateTime().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + (((getSize() == null ? 0 : getSize().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getIops() != null) {
            i = getIops().hashCode();
        }
        return hashCode + i;
    }

    public void setAttachments(Collection<VolumeAttachment> collection) {
        if (collection == null) {
            this.attachments = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.attachments = arrayList;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setCreateTime(Date date) {
        this.createTime = date;
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

    public void setState(VolumeState volumeState) {
        this.state = volumeState.toString();
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
    }

    public void setVolumeId(String str) {
        this.volumeId = str;
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
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.size != null) {
            stringBuilder.append("Size: " + this.size + ", ");
        }
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.createTime != null) {
            stringBuilder.append("CreateTime: " + this.createTime + ", ");
        }
        if (this.attachments != null) {
            stringBuilder.append("Attachments: " + this.attachments + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
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

    public Volume withAttachments(Collection<VolumeAttachment> collection) {
        if (collection == null) {
            this.attachments = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.attachments = arrayList;
        }
        return this;
    }

    public Volume withAttachments(VolumeAttachment... volumeAttachmentArr) {
        if (getAttachments() == null) {
            setAttachments(new ArrayList(volumeAttachmentArr.length));
        }
        for (Object add : volumeAttachmentArr) {
            getAttachments().add(add);
        }
        return this;
    }

    public Volume withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public Volume withCreateTime(Date date) {
        this.createTime = date;
        return this;
    }

    public Volume withIops(Integer num) {
        this.iops = num;
        return this;
    }

    public Volume withSize(Integer num) {
        this.size = num;
        return this;
    }

    public Volume withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public Volume withState(VolumeState volumeState) {
        this.state = volumeState.toString();
        return this;
    }

    public Volume withState(String str) {
        this.state = str;
        return this;
    }

    public Volume withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public Volume withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public Volume withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }

    public Volume withVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType.toString();
        return this;
    }

    public Volume withVolumeType(String str) {
        this.volumeType = str;
        return this;
    }
}
