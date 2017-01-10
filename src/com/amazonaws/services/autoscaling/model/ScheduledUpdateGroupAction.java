package com.amazonaws.services.autoscaling.model;

import java.util.Date;

public class ScheduledUpdateGroupAction {
    private String autoScalingGroupName;
    private Integer desiredCapacity;
    private Date endTime;
    private Integer maxSize;
    private Integer minSize;
    private String recurrence;
    private String scheduledActionARN;
    private String scheduledActionName;
    private Date startTime;
    private Date time;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduledUpdateGroupAction)) {
            return false;
        }
        ScheduledUpdateGroupAction scheduledUpdateGroupAction = (ScheduledUpdateGroupAction) obj;
        if (((scheduledUpdateGroupAction.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getAutoScalingGroupName() != null && !scheduledUpdateGroupAction.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getScheduledActionName() == null ? 1 : 0) ^ (getScheduledActionName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getScheduledActionName() != null && !scheduledUpdateGroupAction.getScheduledActionName().equals(getScheduledActionName())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getScheduledActionARN() == null ? 1 : 0) ^ (getScheduledActionARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getScheduledActionARN() != null && !scheduledUpdateGroupAction.getScheduledActionARN().equals(getScheduledActionARN())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getTime() == null ? 1 : 0) ^ (getTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getTime() != null && !scheduledUpdateGroupAction.getTime().equals(getTime())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getStartTime() != null && !scheduledUpdateGroupAction.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getEndTime() != null && !scheduledUpdateGroupAction.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getRecurrence() == null ? 1 : 0) ^ (getRecurrence() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getRecurrence() != null && !scheduledUpdateGroupAction.getRecurrence().equals(getRecurrence())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getMinSize() == null ? 1 : 0) ^ (getMinSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getMinSize() != null && !scheduledUpdateGroupAction.getMinSize().equals(getMinSize())) {
            return false;
        }
        if (((scheduledUpdateGroupAction.getMaxSize() == null ? 1 : 0) ^ (getMaxSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scheduledUpdateGroupAction.getMaxSize() != null && !scheduledUpdateGroupAction.getMaxSize().equals(getMaxSize())) {
            return false;
        }
        return ((scheduledUpdateGroupAction.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) == 0 ? scheduledUpdateGroupAction.getDesiredCapacity() == null || scheduledUpdateGroupAction.getDesiredCapacity().equals(getDesiredCapacity()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getDesiredCapacity() {
        return this.desiredCapacity;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public Integer getMaxSize() {
        return this.maxSize;
    }

    public Integer getMinSize() {
        return this.minSize;
    }

    public String getRecurrence() {
        return this.recurrence;
    }

    public String getScheduledActionARN() {
        return this.scheduledActionARN;
    }

    public String getScheduledActionName() {
        return this.scheduledActionName;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public Date getTime() {
        return this.time;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxSize() == null ? 0 : getMaxSize().hashCode()) + (((getMinSize() == null ? 0 : getMinSize().hashCode()) + (((getRecurrence() == null ? 0 : getRecurrence().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getTime() == null ? 0 : getTime().hashCode()) + (((getScheduledActionARN() == null ? 0 : getScheduledActionARN().hashCode()) + (((getScheduledActionName() == null ? 0 : getScheduledActionName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getDesiredCapacity() != null) {
            i = getDesiredCapacity().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public void setMaxSize(Integer num) {
        this.maxSize = num;
    }

    public void setMinSize(Integer num) {
        this.minSize = num;
    }

    public void setRecurrence(String str) {
        this.recurrence = str;
    }

    public void setScheduledActionARN(String str) {
        this.scheduledActionARN = str;
    }

    public void setScheduledActionName(String str) {
        this.scheduledActionName = str;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setTime(Date date) {
        this.time = date;
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
        if (this.scheduledActionARN != null) {
            stringBuilder.append("ScheduledActionARN: " + this.scheduledActionARN + ", ");
        }
        if (this.time != null) {
            stringBuilder.append("Time: " + this.time + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
        }
        if (this.recurrence != null) {
            stringBuilder.append("Recurrence: " + this.recurrence + ", ");
        }
        if (this.minSize != null) {
            stringBuilder.append("MinSize: " + this.minSize + ", ");
        }
        if (this.maxSize != null) {
            stringBuilder.append("MaxSize: " + this.maxSize + ", ");
        }
        if (this.desiredCapacity != null) {
            stringBuilder.append("DesiredCapacity: " + this.desiredCapacity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ScheduledUpdateGroupAction withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public ScheduledUpdateGroupAction withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public ScheduledUpdateGroupAction withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public ScheduledUpdateGroupAction withMaxSize(Integer num) {
        this.maxSize = num;
        return this;
    }

    public ScheduledUpdateGroupAction withMinSize(Integer num) {
        this.minSize = num;
        return this;
    }

    public ScheduledUpdateGroupAction withRecurrence(String str) {
        this.recurrence = str;
        return this;
    }

    public ScheduledUpdateGroupAction withScheduledActionARN(String str) {
        this.scheduledActionARN = str;
        return this;
    }

    public ScheduledUpdateGroupAction withScheduledActionName(String str) {
        this.scheduledActionName = str;
        return this;
    }

    public ScheduledUpdateGroupAction withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public ScheduledUpdateGroupAction withTime(Date date) {
        this.time = date;
        return this;
    }
}
