package com.amazonaws.services.ec2.model;

public class DetachVolumeResult {
    private VolumeAttachment attachment;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DetachVolumeResult)) {
            return false;
        }
        DetachVolumeResult detachVolumeResult = (DetachVolumeResult) obj;
        return ((detachVolumeResult.getAttachment() == null ? 1 : 0) ^ (getAttachment() == null ? 1 : 0)) == 0 ? detachVolumeResult.getAttachment() == null || detachVolumeResult.getAttachment().equals(getAttachment()) : false;
    }

    public VolumeAttachment getAttachment() {
        return this.attachment;
    }

    public int hashCode() {
        return (getAttachment() == null ? 0 : getAttachment().hashCode()) + 31;
    }

    public void setAttachment(VolumeAttachment volumeAttachment) {
        this.attachment = volumeAttachment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attachment != null) {
            stringBuilder.append("Attachment: " + this.attachment + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DetachVolumeResult withAttachment(VolumeAttachment volumeAttachment) {
        this.attachment = volumeAttachment;
        return this;
    }
}
