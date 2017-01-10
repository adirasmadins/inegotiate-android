package com.amazonaws.services.autoscaling.model;

public class NotificationConfiguration {
    private String autoScalingGroupName;
    private String notificationType;
    private String topicARN;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotificationConfiguration)) {
            return false;
        }
        NotificationConfiguration notificationConfiguration = (NotificationConfiguration) obj;
        if (((notificationConfiguration.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (notificationConfiguration.getAutoScalingGroupName() != null && !notificationConfiguration.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((notificationConfiguration.getTopicARN() == null ? 1 : 0) ^ (getTopicARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (notificationConfiguration.getTopicARN() != null && !notificationConfiguration.getTopicARN().equals(getTopicARN())) {
            return false;
        }
        return ((notificationConfiguration.getNotificationType() == null ? 1 : 0) ^ (getNotificationType() == null ? 1 : 0)) == 0 ? notificationConfiguration.getNotificationType() == null || notificationConfiguration.getNotificationType().equals(getNotificationType()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getNotificationType() {
        return this.notificationType;
    }

    public String getTopicARN() {
        return this.topicARN;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTopicARN() == null ? 0 : getTopicARN().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31;
        if (getNotificationType() != null) {
            i = getNotificationType().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setNotificationType(String str) {
        this.notificationType = str;
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
        if (this.notificationType != null) {
            stringBuilder.append("NotificationType: " + this.notificationType + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public NotificationConfiguration withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public NotificationConfiguration withNotificationType(String str) {
        this.notificationType = str;
        return this;
    }

    public NotificationConfiguration withTopicARN(String str) {
        this.topicARN = str;
        return this;
    }
}
