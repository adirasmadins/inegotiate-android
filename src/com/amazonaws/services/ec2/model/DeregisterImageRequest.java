package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeregisterImageRequest extends AmazonWebServiceRequest {
    private String imageId;

    public DeregisterImageRequest(String str) {
        this.imageId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeregisterImageRequest)) {
            return false;
        }
        DeregisterImageRequest deregisterImageRequest = (DeregisterImageRequest) obj;
        return ((deregisterImageRequest.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) == 0 ? deregisterImageRequest.getImageId() == null || deregisterImageRequest.getImageId().equals(getImageId()) : false;
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

    public DeregisterImageRequest withImageId(String str) {
        this.imageId = str;
        return this;
    }
}
