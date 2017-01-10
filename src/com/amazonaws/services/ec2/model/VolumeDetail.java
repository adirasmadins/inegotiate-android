package com.amazonaws.services.ec2.model;

public class VolumeDetail {
    private Long size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeDetail)) {
            return false;
        }
        VolumeDetail volumeDetail = (VolumeDetail) obj;
        return ((volumeDetail.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) == 0 ? volumeDetail.getSize() == null || volumeDetail.getSize().equals(getSize()) : false;
    }

    public Long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (getSize() == null ? 0 : getSize().hashCode()) + 31;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.size != null) {
            stringBuilder.append("Size: " + this.size + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeDetail withSize(Long l) {
        this.size = l;
        return this;
    }
}
