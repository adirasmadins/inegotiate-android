package com.amazonaws.services.autoscaling.model;

public class Ebs {
    private String snapshotId;
    private Integer volumeSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Ebs)) {
            return false;
        }
        Ebs ebs = (Ebs) obj;
        if (((ebs.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (ebs.getSnapshotId() != null && !ebs.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        return ((ebs.getVolumeSize() == null ? 1 : 0) ^ (getVolumeSize() == null ? 1 : 0)) == 0 ? ebs.getVolumeSize() == null || ebs.getVolumeSize().equals(getVolumeSize()) : false;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public Integer getVolumeSize() {
        return this.volumeSize;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31;
        if (getVolumeSize() != null) {
            i = getVolumeSize().hashCode();
        }
        return hashCode + i;
    }

    public void setSnapshotId(String str) {
        this.snapshotId = str;
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
        if (this.volumeSize != null) {
            stringBuilder.append("VolumeSize: " + this.volumeSize + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Ebs withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }

    public Ebs withVolumeSize(Integer num) {
        this.volumeSize = num;
        return this;
    }
}
