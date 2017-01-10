package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeImageAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String imageId;

    public DescribeImageAttributeRequest(String str, String str2) {
        this.imageId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeImageAttributeRequest)) {
            return false;
        }
        DescribeImageAttributeRequest describeImageAttributeRequest = (DescribeImageAttributeRequest) obj;
        if (((describeImageAttributeRequest.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeImageAttributeRequest.getImageId() != null && !describeImageAttributeRequest.getImageId().equals(getImageId())) {
            return false;
        }
        return ((describeImageAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? describeImageAttributeRequest.getAttribute() == null || describeImageAttributeRequest.getAttribute().equals(getAttribute()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getImageId() {
        return this.imageId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31;
        if (getAttribute() != null) {
            i = getAttribute().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(String str) {
        this.attribute = str;
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
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeImageAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public DescribeImageAttributeRequest withImageId(String str) {
        this.imageId = str;
        return this;
    }
}
