package com.amazonaws.services.ec2.model;

public class ImportInstanceVolumeDetailItem {
    private String availabilityZone;
    private Long bytesConverted;
    private String description;
    private DiskImageDescription image;
    private String status;
    private String statusMessage;
    private DiskImageVolumeDescription volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportInstanceVolumeDetailItem)) {
            return false;
        }
        ImportInstanceVolumeDetailItem importInstanceVolumeDetailItem = (ImportInstanceVolumeDetailItem) obj;
        if (((importInstanceVolumeDetailItem.getBytesConverted() == null ? 1 : 0) ^ (getBytesConverted() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getBytesConverted() != null && !importInstanceVolumeDetailItem.getBytesConverted().equals(getBytesConverted())) {
            return false;
        }
        if (((importInstanceVolumeDetailItem.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getAvailabilityZone() != null && !importInstanceVolumeDetailItem.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((importInstanceVolumeDetailItem.getImage() == null ? 1 : 0) ^ (getImage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getImage() != null && !importInstanceVolumeDetailItem.getImage().equals(getImage())) {
            return false;
        }
        if (((importInstanceVolumeDetailItem.getVolume() == null ? 1 : 0) ^ (getVolume() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getVolume() != null && !importInstanceVolumeDetailItem.getVolume().equals(getVolume())) {
            return false;
        }
        if (((importInstanceVolumeDetailItem.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getStatus() != null && !importInstanceVolumeDetailItem.getStatus().equals(getStatus())) {
            return false;
        }
        if (((importInstanceVolumeDetailItem.getStatusMessage() == null ? 1 : 0) ^ (getStatusMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceVolumeDetailItem.getStatusMessage() != null && !importInstanceVolumeDetailItem.getStatusMessage().equals(getStatusMessage())) {
            return false;
        }
        return ((importInstanceVolumeDetailItem.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? importInstanceVolumeDetailItem.getDescription() == null || importInstanceVolumeDetailItem.getDescription().equals(getDescription()) : false;
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

    public String getStatus() {
        return this.status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public DiskImageVolumeDescription getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatusMessage() == null ? 0 : getStatusMessage().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getVolume() == null ? 0 : getVolume().hashCode()) + (((getImage() == null ? 0 : getImage().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getBytesConverted() == null ? 0 : getBytesConverted().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
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

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
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
        if (this.image != null) {
            stringBuilder.append("Image: " + this.image + ", ");
        }
        if (this.volume != null) {
            stringBuilder.append("Volume: " + this.volume + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.statusMessage != null) {
            stringBuilder.append("StatusMessage: " + this.statusMessage + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportInstanceVolumeDetailItem withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public ImportInstanceVolumeDetailItem withBytesConverted(Long l) {
        this.bytesConverted = l;
        return this;
    }

    public ImportInstanceVolumeDetailItem withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImportInstanceVolumeDetailItem withImage(DiskImageDescription diskImageDescription) {
        this.image = diskImageDescription;
        return this;
    }

    public ImportInstanceVolumeDetailItem withStatus(String str) {
        this.status = str;
        return this;
    }

    public ImportInstanceVolumeDetailItem withStatusMessage(String str) {
        this.statusMessage = str;
        return this;
    }

    public ImportInstanceVolumeDetailItem withVolume(DiskImageVolumeDescription diskImageVolumeDescription) {
        this.volume = diskImageVolumeDescription;
        return this;
    }
}
