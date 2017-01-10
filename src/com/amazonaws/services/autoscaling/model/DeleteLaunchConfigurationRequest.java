package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteLaunchConfigurationRequest extends AmazonWebServiceRequest {
    private String launchConfigurationName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteLaunchConfigurationRequest)) {
            return false;
        }
        DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest = (DeleteLaunchConfigurationRequest) obj;
        return ((deleteLaunchConfigurationRequest.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) == 0 ? deleteLaunchConfigurationRequest.getLaunchConfigurationName() == null || deleteLaunchConfigurationRequest.getLaunchConfigurationName().equals(getLaunchConfigurationName()) : false;
    }

    public String getLaunchConfigurationName() {
        return this.launchConfigurationName;
    }

    public int hashCode() {
        return (getLaunchConfigurationName() == null ? 0 : getLaunchConfigurationName().hashCode()) + 31;
    }

    public void setLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.launchConfigurationName != null) {
            stringBuilder.append("LaunchConfigurationName: " + this.launchConfigurationName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteLaunchConfigurationRequest withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }
}
