package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeVolumeAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumeAttributeRequest)) {
            return false;
        }
        DescribeVolumeAttributeRequest describeVolumeAttributeRequest = (DescribeVolumeAttributeRequest) obj;
        if (((describeVolumeAttributeRequest.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeAttributeRequest.getVolumeId() != null && !describeVolumeAttributeRequest.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        return ((describeVolumeAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? describeVolumeAttributeRequest.getAttribute() == null || describeVolumeAttributeRequest.getAttribute().equals(getAttribute()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31;
        if (getAttribute() != null) {
            i = getAttribute().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(VolumeAttributeName volumeAttributeName) {
        this.attribute = volumeAttributeName.toString();
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setVolumeId(String str) {
        this.volumeId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumeAttributeRequest withAttribute(VolumeAttributeName volumeAttributeName) {
        this.attribute = volumeAttributeName.toString();
        return this;
    }

    public DescribeVolumeAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public DescribeVolumeAttributeRequest withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
