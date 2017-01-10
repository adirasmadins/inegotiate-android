package com.amazonaws.services.ec2.model;

public class DiskImageVolumeDescription {
    private String id;
    private Long size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DiskImageVolumeDescription)) {
            return false;
        }
        DiskImageVolumeDescription diskImageVolumeDescription = (DiskImageVolumeDescription) obj;
        if (((diskImageVolumeDescription.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageVolumeDescription.getSize() != null && !diskImageVolumeDescription.getSize().equals(getSize())) {
            return false;
        }
        return ((diskImageVolumeDescription.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) == 0 ? diskImageVolumeDescription.getId() == null || diskImageVolumeDescription.getId().equals(getId()) : false;
    }

    public String getId() {
        return this.id;
    }

    public Long getSize() {
        return this.size;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSize() == null ? 0 : getSize().hashCode()) + 31) * 31;
        if (getId() != null) {
            i = getId().hashCode();
        }
        return hashCode + i;
    }

    public void setId(String str) {
        this.id = str;
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
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DiskImageVolumeDescription withId(String str) {
        this.id = str;
        return this;
    }

    public DiskImageVolumeDescription withSize(Long l) {
        this.size = l;
        return this;
    }
}
