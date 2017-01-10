package com.amazonaws.services.ec2.model;

public class CreateImageResult {
    private String imageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateImageResult)) {
            return false;
        }
        CreateImageResult createImageResult = (CreateImageResult) obj;
        return ((createImageResult.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) == 0 ? createImageResult.getImageId() == null || createImageResult.getImageId().equals(getImageId()) : false;
    }

    public String getImageId() {
        return this.imageId;
    }

    public int hashCode() {
        return (getImageId() == null ? 0 : getImageId().hashCode()) + 31;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateImageResult withImageId(String str) {
        this.imageId = str;
        return this;
    }
}
