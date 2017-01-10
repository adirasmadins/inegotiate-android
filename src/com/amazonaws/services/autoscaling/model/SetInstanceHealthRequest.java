package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetInstanceHealthRequest extends AmazonWebServiceRequest {
    private String healthStatus;
    private String instanceId;
    private Boolean shouldRespectGracePeriod;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetInstanceHealthRequest)) {
            return false;
        }
        SetInstanceHealthRequest setInstanceHealthRequest = (SetInstanceHealthRequest) obj;
        if (((setInstanceHealthRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setInstanceHealthRequest.getInstanceId() != null && !setInstanceHealthRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((setInstanceHealthRequest.getHealthStatus() == null ? 1 : 0) ^ (getHealthStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setInstanceHealthRequest.getHealthStatus() != null && !setInstanceHealthRequest.getHealthStatus().equals(getHealthStatus())) {
            return false;
        }
        return ((setInstanceHealthRequest.isShouldRespectGracePeriod() == null ? 1 : 0) ^ (isShouldRespectGracePeriod() == null ? 1 : 0)) == 0 ? setInstanceHealthRequest.isShouldRespectGracePeriod() == null || setInstanceHealthRequest.isShouldRespectGracePeriod().equals(isShouldRespectGracePeriod()) : false;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public Boolean getShouldRespectGracePeriod() {
        return this.shouldRespectGracePeriod;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getHealthStatus() == null ? 0 : getHealthStatus().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31;
        if (isShouldRespectGracePeriod() != null) {
            i = isShouldRespectGracePeriod().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isShouldRespectGracePeriod() {
        return this.shouldRespectGracePeriod;
    }

    public void setHealthStatus(String str) {
        this.healthStatus = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setShouldRespectGracePeriod(Boolean bool) {
        this.shouldRespectGracePeriod = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.healthStatus != null) {
            stringBuilder.append("HealthStatus: " + this.healthStatus + ", ");
        }
        if (this.shouldRespectGracePeriod != null) {
            stringBuilder.append("ShouldRespectGracePeriod: " + this.shouldRespectGracePeriod + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetInstanceHealthRequest withHealthStatus(String str) {
        this.healthStatus = str;
        return this;
    }

    public SetInstanceHealthRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public SetInstanceHealthRequest withShouldRespectGracePeriod(Boolean bool) {
        this.shouldRespectGracePeriod = bool;
        return this;
    }
}
