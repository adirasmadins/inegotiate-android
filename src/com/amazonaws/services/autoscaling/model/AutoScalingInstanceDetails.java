package com.amazonaws.services.autoscaling.model;

public class AutoScalingInstanceDetails {
    private String autoScalingGroupName;
    private String availabilityZone;
    private String healthStatus;
    private String instanceId;
    private String launchConfigurationName;
    private String lifecycleState;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingInstanceDetails)) {
            return false;
        }
        AutoScalingInstanceDetails autoScalingInstanceDetails = (AutoScalingInstanceDetails) obj;
        if (((autoScalingInstanceDetails.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingInstanceDetails.getInstanceId() != null && !autoScalingInstanceDetails.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((autoScalingInstanceDetails.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingInstanceDetails.getAutoScalingGroupName() != null && !autoScalingInstanceDetails.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((autoScalingInstanceDetails.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingInstanceDetails.getAvailabilityZone() != null && !autoScalingInstanceDetails.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((autoScalingInstanceDetails.getLifecycleState() == null ? 1 : 0) ^ (getLifecycleState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingInstanceDetails.getLifecycleState() != null && !autoScalingInstanceDetails.getLifecycleState().equals(getLifecycleState())) {
            return false;
        }
        if (((autoScalingInstanceDetails.getHealthStatus() == null ? 1 : 0) ^ (getHealthStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingInstanceDetails.getHealthStatus() != null && !autoScalingInstanceDetails.getHealthStatus().equals(getHealthStatus())) {
            return false;
        }
        return ((autoScalingInstanceDetails.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) == 0 ? autoScalingInstanceDetails.getLaunchConfigurationName() == null || autoScalingInstanceDetails.getLaunchConfigurationName().equals(getLaunchConfigurationName()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
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
        int hashCode = ((getHealthStatus() == null ? 0 : getHealthStatus().hashCode()) + (((getLifecycleState() == null ? 0 : getLifecycleState().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getLaunchConfigurationName() != null) {
            i = getLaunchConfigurationName().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
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

    public void setLifecycleState(String str) {
        this.lifecycleState = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
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

    public AutoScalingInstanceDetails withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public AutoScalingInstanceDetails withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public AutoScalingInstanceDetails withHealthStatus(String str) {
        this.healthStatus = str;
        return this;
    }

    public AutoScalingInstanceDetails withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public AutoScalingInstanceDetails withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public AutoScalingInstanceDetails withLifecycleState(String str) {
        this.lifecycleState = str;
        return this;
    }
}
