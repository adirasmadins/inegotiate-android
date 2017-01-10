package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Date;

public class PutScheduledUpdateGroupActionRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Integer desiredCapacity;
    private Date endTime;
    private Integer maxSize;
    private Integer minSize;
    private String recurrence;
    private String scheduledActionName;
    private Date startTime;
    private Date time;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutScheduledUpdateGroupActionRequest)) {
            return false;
        }
        PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest = (PutScheduledUpdateGroupActionRequest) obj;
        if (((putScheduledUpdateGroupActionRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getAutoScalingGroupName() != null && !putScheduledUpdateGroupActionRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getScheduledActionName() == null ? 1 : 0) ^ (getScheduledActionName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getScheduledActionName() != null && !putScheduledUpdateGroupActionRequest.getScheduledActionName().equals(getScheduledActionName())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getTime() == null ? 1 : 0) ^ (getTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getTime() != null && !putScheduledUpdateGroupActionRequest.getTime().equals(getTime())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getStartTime() != null && !putScheduledUpdateGroupActionRequest.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getEndTime() != null && !putScheduledUpdateGroupActionRequest.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getRecurrence() == null ? 1 : 0) ^ (getRecurrence() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getRecurrence() != null && !putScheduledUpdateGroupActionRequest.getRecurrence().equals(getRecurrence())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getMinSize() == null ? 1 : 0) ^ (getMinSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getMinSize() != null && !putScheduledUpdateGroupActionRequest.getMinSize().equals(getMinSize())) {
            return false;
        }
        if (((putScheduledUpdateGroupActionRequest.getMaxSize() == null ? 1 : 0) ^ (getMaxSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putScheduledUpdateGroupActionRequest.getMaxSize() != null && !putScheduledUpdateGroupActionRequest.getMaxSize().equals(getMaxSize())) {
            return false;
        }
        return ((putScheduledUpdateGroupActionRequest.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) == 0 ? putScheduledUpdateGroupActionRequest.getDesiredCapacity() == null || putScheduledUpdateGroupActionRequest.getDesiredCapacity().equals(getDesiredCapacity()) : false;
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
        int hashCode = ((getMaxSize() == null ? 0 : getMaxSize().hashCode()) + (((getMinSize() == null ? 0 : getMinSize().hashCode()) + (((getRecurrence() == null ? 0 : getRecurrence().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getTime() == null ? 0 : getTime().hashCode()) + (((getScheduledActionName() == null ? 0 : getScheduledActionName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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

    public PutScheduledUpdateGroupActionRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withMaxSize(Integer num) {
        this.maxSize = num;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withMinSize(Integer num) {
        this.minSize = num;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withRecurrence(String str) {
        this.recurrence = str;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withScheduledActionName(String str) {
        this.scheduledActionName = str;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public PutScheduledUpdateGroupActionRequest withTime(Date date) {
        this.time = date;
        return this;
    }
}
