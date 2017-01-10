package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetPasswordDataRequest extends AmazonWebServiceRequest {
    private String instanceId;

    public GetPasswordDataRequest(String str) {
        this.instanceId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPasswordDataRequest)) {
            return false;
        }
        GetPasswordDataRequest getPasswordDataRequest = (GetPasswordDataRequest) obj;
        return ((getPasswordDataRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) == 0 ? getPasswordDataRequest.getInstanceId() == null || getPasswordDataRequest.getInstanceId().equals(getInstanceId()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public int hashCode() {
        return (getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetPasswordDataRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }
}
