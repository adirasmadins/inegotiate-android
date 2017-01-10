package com.amazonaws.services.autoscaling.model;

import java.util.Date;

public class Activity {
    private String activityId;
    private String autoScalingGroupName;
    private String cause;
    private String description;
    private String details;
    private Date endTime;
    private Integer progress;
    private Date startTime;
    private String statusCode;
    private String statusMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        if (((activity.getActivityId() == null ? 1 : 0) ^ (getActivityId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getActivityId() != null && !activity.getActivityId().equals(getActivityId())) {
            return false;
        }
        if (((activity.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getAutoScalingGroupName() != null && !activity.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((activity.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getDescription() != null && !activity.getDescription().equals(getDescription())) {
            return false;
        }
        if (((activity.getCause() == null ? 1 : 0) ^ (getCause() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getCause() != null && !activity.getCause().equals(getCause())) {
            return false;
        }
        if (((activity.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getStartTime() != null && !activity.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((activity.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getEndTime() != null && !activity.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((activity.getStatusCode() == null ? 1 : 0) ^ (getStatusCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getStatusCode() != null && !activity.getStatusCode().equals(getStatusCode())) {
            return false;
        }
        if (((activity.getStatusMessage() == null ? 1 : 0) ^ (getStatusMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getStatusMessage() != null && !activity.getStatusMessage().equals(getStatusMessage())) {
            return false;
        }
        if (((activity.getProgress() == null ? 1 : 0) ^ (getProgress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activity.getProgress() != null && !activity.getProgress().equals(getProgress())) {
            return false;
        }
        return ((activity.getDetails() == null ? 1 : 0) ^ (getDetails() == null ? 1 : 0)) == 0 ? activity.getDetails() == null || activity.getDetails().equals(getDetails()) : false;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getCause() {
        return this.cause;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetails() {
        return this.details;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public Integer getProgress() {
        return this.progress;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProgress() == null ? 0 : getProgress().hashCode()) + (((getStatusMessage() == null ? 0 : getStatusMessage().hashCode()) + (((getStatusCode() == null ? 0 : getStatusCode().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getCause() == null ? 0 : getCause().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + (((getActivityId() == null ? 0 : getActivityId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getDetails() != null) {
            i = getDetails().hashCode();
        }
        return hashCode + i;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setCause(String str) {
        this.cause = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public void setProgress(Integer num) {
        this.progress = num;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setStatusCode(ScalingActivityStatusCode scalingActivityStatusCode) {
        this.statusCode = scalingActivityStatusCode.toString();
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.activityId != null) {
            stringBuilder.append("ActivityId: " + this.activityId + ", ");
        }
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.cause != null) {
            stringBuilder.append("Cause: " + this.cause + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
        }
        if (this.statusCode != null) {
            stringBuilder.append("StatusCode: " + this.statusCode + ", ");
        }
        if (this.statusMessage != null) {
            stringBuilder.append("StatusMessage: " + this.statusMessage + ", ");
        }
        if (this.progress != null) {
            stringBuilder.append("Progress: " + this.progress + ", ");
        }
        if (this.details != null) {
            stringBuilder.append("Details: " + this.details + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Activity withActivityId(String str) {
        this.activityId = str;
        return this;
    }

    public Activity withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public Activity withCause(String str) {
        this.cause = str;
        return this;
    }

    public Activity withDescription(String str) {
        this.description = str;
        return this;
    }

    public Activity withDetails(String str) {
        this.details = str;
        return this;
    }

    public Activity withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public Activity withProgress(Integer num) {
        this.progress = num;
        return this;
    }

    public Activity withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public Activity withStatusCode(ScalingActivityStatusCode scalingActivityStatusCode) {
        this.statusCode = scalingActivityStatusCode.toString();
        return this;
    }

    public Activity withStatusCode(String str) {
        this.statusCode = str;
        return this;
    }

    public Activity withStatusMessage(String str) {
        this.statusMessage = str;
        return this;
    }
}
