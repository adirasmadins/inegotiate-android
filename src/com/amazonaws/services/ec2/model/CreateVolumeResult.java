package com.amazonaws.services.ec2.model;

public class CreateVolumeResult {
    private Volume volume;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateVolumeResult)) {
            return false;
        }
        CreateVolumeResult createVolumeResult = (CreateVolumeResult) obj;
        return ((createVolumeResult.getVolume() == null ? 1 : 0) ^ (getVolume() == null ? 1 : 0)) == 0 ? createVolumeResult.getVolume() == null || createVolumeResult.getVolume().equals(getVolume()) : false;
    }

    public Volume getVolume() {
        return this.volume;
    }

    public int hashCode() {
        return (getVolume() == null ? 0 : getVolume().hashCode()) + 31;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volume != null) {
            stringBuilder.append("Volume: " + this.volume + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateVolumeResult withVolume(Volume volume) {
        this.volume = volume;
        return this;
    }
}
