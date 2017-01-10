package com.amazonaws.services.ec2.model;

public class DiskImage {
    private String description;
    private DiskImageDetail image;
    private VolumeDetail volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DiskImage)) {
            return false;
        }
        DiskImage diskImage = (DiskImage) obj;
        if (((diskImage.getImage() == null ? 1 : 0) ^ (getImage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImage.getImage() != null && !diskImage.getImage().equals(getImage())) {
            return false;
        }
        if (((diskImage.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImage.getDescription() != null && !diskImage.getDescription().equals(getDescription())) {
            return false;
        }
        return ((diskImage.getVolume() == null ? 1 : 0) ^ (getVolume() == null ? 1 : 0)) == 0 ? diskImage.getVolume() == null || diskImage.getVolume().equals(getVolume()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public DiskImageDetail getImage() {
        return this.image;
    }

    public VolumeDetail getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDescription() == null ? 0 : getDescription().hashCode()) + (((getImage() == null ? 0 : getImage().hashCode()) + 31) * 31)) * 31;
        if (getVolume() != null) {
            i = getVolume().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImage(DiskImageDetail diskImageDetail) {
        this.image = diskImageDetail;
    }

    public void setVolume(VolumeDetail volumeDetail) {
        this.volume = volumeDetail;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.image != null) {
            stringBuilder.append("Image: " + this.image + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.volume != null) {
            stringBuilder.append("Volume: " + this.volume + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DiskImage withDescription(String str) {
        this.description = str;
        return this;
    }

    public DiskImage withImage(DiskImageDetail diskImageDetail) {
        this.image = diskImageDetail;
        return this;
    }

    public DiskImage withVolume(VolumeDetail volumeDetail) {
        this.volume = volumeDetail;
        return this;
    }
}
