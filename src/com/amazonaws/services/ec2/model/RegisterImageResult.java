package com.amazonaws.services.ec2.model;

public class RegisterImageResult {
    private String imageId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RegisterImageResult)) {
            return false;
        }
        RegisterImageResult registerImageResult = (RegisterImageResult) obj;
        return ((registerImageResult.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) == 0 ? registerImageResult.getImageId() == null || registerImageResult.getImageId().equals(getImageId()) : false;
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

    public RegisterImageResult withImageId(String str) {
        this.imageId = str;
        return this;
    }
}
