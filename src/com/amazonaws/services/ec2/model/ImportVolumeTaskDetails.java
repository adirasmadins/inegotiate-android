package com.amazonaws.services.ec2.model;

public class ImportVolumeTaskDetails {
    private String availabilityZone;
    private Long bytesConverted;
    private String description;
    private DiskImageDescription image;
    private DiskImageVolumeDescription volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportVolumeTaskDetails)) {
            return false;
        }
        ImportVolumeTaskDetails importVolumeTaskDetails = (ImportVolumeTaskDetails) obj;
        if (((importVolumeTaskDetails.getBytesConverted() == null ? 1 : 0) ^ (getBytesConverted() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeTaskDetails.getBytesConverted() != null && !importVolumeTaskDetails.getBytesConverted().equals(getBytesConverted())) {
            return false;
        }
        if (((importVolumeTaskDetails.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeTaskDetails.getAvailabilityZone() != null && !importVolumeTaskDetails.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((importVolumeTaskDetails.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeTaskDetails.getDescription() != null && !importVolumeTaskDetails.getDescription().equals(getDescription())) {
            return false;
        }
        if (((importVolumeTaskDetails.getImage() == null ? 1 : 0) ^ (getImage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeTaskDetails.getImage() != null && !importVolumeTaskDetails.getImage().equals(getImage())) {
            return false;
        }
        return ((importVolumeTaskDetails.getVolume() == null ? 1 : 0) ^ (getVolume() == null ? 1 : 0)) == 0 ? importVolumeTaskDetails.getVolume() == null || importVolumeTaskDetails.getVolume().equals(getVolume()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public Long getBytesConverted() {
        return this.bytesConverted;
    }

    public String getDescription() {
        return this.description;
    }

    public DiskImageDescription getImage() {
        return this.image;
    }

    public DiskImageVolumeDescription getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getImage() == null ? 0 : getImage().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getBytesConverted() == null ? 0 : getBytesConverted().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getVolume() != null) {
            i = getVolume().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setBytesConverted(Long l) {
        this.bytesConverted = l;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImage(DiskImageDescription diskImageDescription) {
        this.image = diskImageDescription;
    }

    public void setVolume(DiskImageVolumeDescription diskImageVolumeDescription) {
        this.volume = diskImageVolumeDescription;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bytesConverted != null) {
            stringBuilder.append("BytesConverted: " + this.bytesConverted + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.image != null) {
            stringBuilder.append("Image: " + this.image + ", ");
        }
        if (this.volume != null) {
            stringBuilder.append("Volume: " + this.volume + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportVolumeTaskDetails withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public ImportVolumeTaskDetails withBytesConverted(Long l) {
        this.bytesConverted = l;
        return this;
    }

    public ImportVolumeTaskDetails withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImportVolumeTaskDetails withImage(DiskImageDescription diskImageDescription) {
        this.image = diskImageDescription;
        return this;
    }

    public ImportVolumeTaskDetails withVolume(DiskImageVolumeDescription diskImageVolumeDescription) {
        this.volume = diskImageVolumeDescription;
        return this;
    }
}
