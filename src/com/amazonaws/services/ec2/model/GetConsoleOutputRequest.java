package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetConsoleOutputRequest extends AmazonWebServiceRequest {
    private String instanceId;

    public GetConsoleOutputRequest(String str) {
        this.instanceId = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetConsoleOutputRequest)) {
            return false;
        }
        GetConsoleOutputRequest getConsoleOutputRequest = (GetConsoleOutputRequest) obj;
        return ((getConsoleOutputRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) == 0 ? getConsoleOutputRequest.getInstanceId() == null || getConsoleOutputRequest.getInstanceId().equals(getInstanceId()) : false;
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

    public GetConsoleOutputRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }
}
