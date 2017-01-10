package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DeleteNotificationConfigurationRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private String topicARN;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteNotificationConfigurationRequest)) {
            return false;
        }
        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = (DeleteNotificationConfigurationRequest) obj;
        if (((deleteNotificationConfigurationRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteNotificationConfigurationRequest.getAutoScalingGroupName() != null && !deleteNotificationConfigurationRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((deleteNotificationConfigurationRequest.getTopicARN() == null ? 1 : 0) ^ (getTopicARN() == null ? 1 : 0)) == 0 ? deleteNotificationConfigurationRequest.getTopicARN() == null || deleteNotificationConfigurationRequest.getTopicARN().equals(getTopicARN()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getTopicARN() {
        return this.topicARN;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (getTopicARN() != null) {
            i = getTopicARN().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setTopicARN(String str) {
        this.topicARN = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.topicARN != null) {
            stringBuilder.append("TopicARN: " + this.topicARN + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteNotificationConfigurationRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DeleteNotificationConfigurationRequest withTopicARN(String str) {
        this.topicARN = str;
        return this;
    }
}
