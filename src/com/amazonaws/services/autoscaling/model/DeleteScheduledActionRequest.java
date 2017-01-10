package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteScheduledActionRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private String scheduledActionName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteScheduledActionRequest)) {
            return false;
        }
        DeleteScheduledActionRequest deleteScheduledActionRequest = (DeleteScheduledActionRequest) obj;
        if (((deleteScheduledActionRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteScheduledActionRequest.getAutoScalingGroupName() != null && !deleteScheduledActionRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((deleteScheduledActionRequest.getScheduledActionName() == null ? 1 : 0) ^ (getScheduledActionName() == null ? 1 : 0)) == 0 ? deleteScheduledActionRequest.getScheduledActionName() == null || deleteScheduledActionRequest.getScheduledActionName().equals(getScheduledActionName()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getScheduledActionName() {
        return this.scheduledActionName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (getScheduledActionName() != null) {
            i = getScheduledActionName().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setScheduledActionName(String str) {
        this.scheduledActionName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.scheduledActionName != null) {
            stringBuilder.append("ScheduledActionName: " + this.scheduledActionName + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteScheduledActionRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DeleteScheduledActionRequest withScheduledActionName(String str) {
        this.scheduledActionName = str;
        return this;
    }
}
