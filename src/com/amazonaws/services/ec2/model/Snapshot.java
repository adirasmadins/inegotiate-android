package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Snapshot {
    private String description;
    private String ownerAlias;
    private String ownerId;
    private String progress;
    private String snapshotId;
    private Date startTime;
    private String state;
    private List<Tag> tags;
    private String volumeId;
    private Integer volumeSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Snapshot)) {
            return false;
        }
        Snapshot snapshot = (Snapshot) obj;
        if (((snapshot.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getSnapshotId() != null && !snapshot.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((snapshot.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getVolumeId() != null && !snapshot.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((snapshot.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getState() != null && !snapshot.getState().equals(getState())) {
            return false;
        }
        if (((snapshot.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getStartTime() != null && !snapshot.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((snapshot.getProgress() == null ? 1 : 0) ^ (getProgress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getProgress() != null && !snapshot.getProgress().equals(getProgress())) {
            return false;
        }
        if (((snapshot.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getOwnerId() != null && !snapshot.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((snapshot.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getDescription() != null && !snapshot.getDescription().equals(getDescription())) {
            return false;
        }
        if (((snapshot.getVolumeSize() == null ? 1 : 0) ^ (getVolumeSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getVolumeSize() != null && !snapshot.getVolumeSize().equals(getVolumeSize())) {
            return false;
        }
        if (((snapshot.getOwnerAlias() == null ? 1 : 0) ^ (getOwnerAlias() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (snapshot.getOwnerAlias() != null && !snapshot.getOwnerAlias().equals(getOwnerAlias())) {
            return false;
        }
        return ((snapshot.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? snapshot.getTags() == null || snapshot.getTags().equals(getTags()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getOwnerAlias() {
        return this.ownerAlias;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getProgress() {
        return this.progress;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public Date getStartTime() {
        return this.startTime;
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

    public Integer getVolumeSize() {
        return this.volumeSize;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getOwnerAlias() == null ? 0 : getOwnerAlias().hashCode()) + (((getVolumeSize() == null ? 0 : getVolumeSize().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + (((getProgress() == null ? 0 : getProgress().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setOwnerAlias(String str) {
        this.ownerAlias = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setProgress(String str) {
        this.progress = str;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setState(SnapshotState snapshotState) {
        this.state = snapshotState.toString();
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

    public void setVolumeSize(Integer num) {
        this.volumeSize = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.progress != null) {
            stringBuilder.append("Progress: " + this.progress + ", ");
        }
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.volumeSize != null) {
            stringBuilder.append("VolumeSize: " + this.volumeSize + ", ");
        }
        if (this.ownerAlias != null) {
            stringBuilder.append("OwnerAlias: " + this.ownerAlias + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Snapshot withDescription(String str) {
        this.description = str;
        return this;
    }

    public Snapshot withOwnerAlias(String str) {
        this.ownerAlias = str;
        return this;
    }

    public Snapshot withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public Snapshot withProgress(String str) {
        this.progress = str;
        return this;
    }

    public Snapshot withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public Snapshot withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public Snapshot withState(SnapshotState snapshotState) {
        this.state = snapshotState.toString();
        return this;
    }

    public Snapshot withState(String str) {
        this.state = str;
        return this;
    }

    public Snapshot withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public Snapshot withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public Snapshot withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }

    public Snapshot withVolumeSize(Integer num) {
        this.volumeSize = num;
        return this;
    }
}
