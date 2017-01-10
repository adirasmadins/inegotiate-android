package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeInstanceAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String instanceId;

    public DescribeInstanceAttributeRequest(String str, InstanceAttributeName instanceAttributeName) {
        this.instanceId = str;
        this.attribute = instanceAttributeName.toString();
    }

    public DescribeInstanceAttributeRequest(String str, String str2) {
        this.instanceId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceAttributeRequest)) {
            return false;
        }
        DescribeInstanceAttributeRequest describeInstanceAttributeRequest = (DescribeInstanceAttributeRequest) obj;
        if (((describeInstanceAttributeRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceAttributeRequest.getInstanceId() != null && !describeInstanceAttributeRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((describeInstanceAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? describeInstanceAttributeRequest.getAttribute() == null || describeInstanceAttributeRequest.getAttribute().equals(getAttribute()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31;
        if (getAttribute() != null) {
            i = getAttribute().hashCode();
        }
        return hashCode + i;
    }

    public void setAttribute(InstanceAttributeName instanceAttributeName) {
        this.attribute = instanceAttributeName.toString();
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceAttributeRequest withAttribute(InstanceAttributeName instanceAttributeName) {
        this.attribute = instanceAttributeName.toString();
        return this;
    }

    public DescribeInstanceAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public DescribeInstanceAttributeRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }
}
