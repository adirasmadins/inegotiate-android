package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ResetInstanceAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private String instanceId;

    public ResetInstanceAttributeRequest(String str, InstanceAttributeName instanceAttributeName) {
        this.instanceId = str;
        this.attribute = instanceAttributeName.toString();
    }

    public ResetInstanceAttributeRequest(String str, String str2) {
        this.instanceId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResetInstanceAttributeRequest)) {
            return false;
        }
        ResetInstanceAttributeRequest resetInstanceAttributeRequest = (ResetInstanceAttributeRequest) obj;
        if (((resetInstanceAttributeRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (resetInstanceAttributeRequest.getInstanceId() != null && !resetInstanceAttributeRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        return ((resetInstanceAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) == 0 ? resetInstanceAttributeRequest.getAttribute() == null || resetInstanceAttributeRequest.getAttribute().equals(getAttribute()) : false;
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

    public ResetInstanceAttributeRequest withAttribute(InstanceAttributeName instanceAttributeName) {
        this.attribute = instanceAttributeName.toString();
        return this;
    }

    public ResetInstanceAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public ResetInstanceAttributeRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }
}
