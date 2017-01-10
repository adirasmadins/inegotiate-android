package com.amazonaws.services.autoscaling.model;

public class Instance {
    private String availabilityZone;
    private String healthStatus;
    private String instanceId;
    private String launchConfigurationName;
    private String lifecycleState;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Instance)) {
            return false;
        }
        Instance instance = (Instance) obj;
        if (((instance.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getInstanceId() != null && !instance.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instance.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getAvailabilityZone() != null && !instance.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((instance.getLifecycleState() == null ? 1 : 0) ^ (getLifecycleState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getLifecycleState() != null && !instance.getLifecycleState().equals(getLifecycleState())) {
            return false;
        }
        if (((instance.getHealthStatus() == null ? 1 : 0) ^ (getHealthStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getHealthStatus() != null && !instance.getHealthStatus().equals(getHealthStatus())) {
            return false;
        }
        return ((instance.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) == 0 ? instance.getLaunchConfigurationName() == null || instance.getLaunchConfigurationName().equals(getLaunchConfigurationName()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getLaunchConfigurationName() {
        return this.launchConfigurationName;
    }

    public String getLifecycleState() {
        return this.lifecycleState;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getHealthStatus() == null ? 0 : getHealthStatus().hashCode()) + (((getLifecycleState() == null ? 0 : getLifecycleState().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getLaunchConfigurationName() != null) {
            i = getLaunchConfigurationName().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setHealthStatus(String str) {
        this.healthStatus = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
    }

    public void setLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState.toString();
    }

    public void setLifecycleState(String str) {
        this.lifecycleState = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.lifecycleState != null) {
            stringBuilder.append("LifecycleState: " + this.lifecycleState + ", ");
        }
        if (this.healthStatus != null) {
            stringBuilder.append("HealthStatus: " + this.healthStatus + ", ");
        }
        if (this.launchConfigurationName != null) {
            stringBuilder.append("LaunchConfigurationName: " + this.launchConfigurationName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Instance withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public Instance withHealthStatus(String str) {
        this.healthStatus = str;
        return this;
    }

    public Instance withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public Instance withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public Instance withLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState.toString();
        return this;
    }

    public Instance withLifecycleState(String str) {
        this.lifecycleState = str;
        return this;
    }
}
