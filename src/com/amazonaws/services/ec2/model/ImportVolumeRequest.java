package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ImportVolumeRequest extends AmazonWebServiceRequest {
    private String availabilityZone;
    private String description;
    private DiskImageDetail image;
    private VolumeDetail volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportVolumeRequest)) {
            return false;
        }
        ImportVolumeRequest importVolumeRequest = (ImportVolumeRequest) obj;
        if (((importVolumeRequest.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeRequest.getAvailabilityZone() != null && !importVolumeRequest.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((importVolumeRequest.getImage() == null ? 1 : 0) ^ (getImage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeRequest.getImage() != null && !importVolumeRequest.getImage().equals(getImage())) {
            return false;
        }
        if (((importVolumeRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importVolumeRequest.getDescription() != null && !importVolumeRequest.getDescription().equals(getDescription())) {
            return false;
        }
        return ((importVolumeRequest.getVolume() == null ? 1 : 0) ^ (getVolume() == null ? 1 : 0)) == 0 ? importVolumeRequest.getVolume() == null || importVolumeRequest.getVolume().equals(getVolume()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
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
        int hashCode = ((getDescription() == null ? 0 : getDescription().hashCode()) + (((getImage() == null ? 0 : getImage().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getVolume() != null) {
            i = getVolume().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
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
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
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

    public ImportVolumeRequest withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public ImportVolumeRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImportVolumeRequest withImage(DiskImageDetail diskImageDetail) {
        this.image = diskImageDetail;
        return this;
    }

    public ImportVolumeRequest withVolume(VolumeDetail volumeDetail) {
        this.volume = volumeDetail;
        return this;
    }
}
