package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PutNotificationConfigurationRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private List<String> notificationTypes;
    private String topicARN;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutNotificationConfigurationRequest)) {
            return false;
        }
        PutNotificationConfigurationRequest putNotificationConfigurationRequest = (PutNotificationConfigurationRequest) obj;
        if (((putNotificationConfigurationRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putNotificationConfigurationRequest.getAutoScalingGroupName() != null && !putNotificationConfigurationRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((putNotificationConfigurationRequest.getTopicARN() == null ? 1 : 0) ^ (getTopicARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putNotificationConfigurationRequest.getTopicARN() != null && !putNotificationConfigurationRequest.getTopicARN().equals(getTopicARN())) {
            return false;
        }
        return ((putNotificationConfigurationRequest.getNotificationTypes() == null ? 1 : 0) ^ (getNotificationTypes() == null ? 1 : 0)) == 0 ? putNotificationConfigurationRequest.getNotificationTypes() == null || putNotificationConfigurationRequest.getNotificationTypes().equals(getNotificationTypes()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public List<String> getNotificationTypes() {
        if (this.notificationTypes == null) {
            this.notificationTypes = new ArrayList();
        }
        return this.notificationTypes;
    }

    public String getTopicARN() {
        return this.topicARN;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTopicARN() == null ? 0 : getTopicARN().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31;
        if (getNotificationTypes() != null) {
            i = getNotificationTypes().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setNotificationTypes(Collection<String> collection) {
        if (collection == null) {
            this.notificationTypes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.notificationTypes = arrayList;
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
        if (this.notificationTypes != null) {
            stringBuilder.append("NotificationTypes: " + this.notificationTypes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutNotificationConfigurationRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public PutNotificationConfigurationRequest withNotificationTypes(Collection<String> collection) {
        if (collection == null) {
            this.notificationTypes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.notificationTypes = arrayList;
        }
        return this;
    }

    public PutNotificationConfigurationRequest withNotificationTypes(String... strArr) {
        if (getNotificationTypes() == null) {
            setNotificationTypes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getNotificationTypes().add(add);
        }
        return this;
    }

    public PutNotificationConfigurationRequest withTopicARN(String str) {
        this.topicARN = str;
        return this;
    }
}
