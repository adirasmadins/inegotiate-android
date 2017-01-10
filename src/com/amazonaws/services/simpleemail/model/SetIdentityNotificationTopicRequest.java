package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetIdentityNotificationTopicRequest extends AmazonWebServiceRequest {
    private String identity;
    private String notificationType;
    private String snsTopic;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetIdentityNotificationTopicRequest)) {
            return false;
        }
        SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest = (SetIdentityNotificationTopicRequest) obj;
        if (((setIdentityNotificationTopicRequest.getIdentity() == null ? 1 : 0) ^ (getIdentity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setIdentityNotificationTopicRequest.getIdentity() != null && !setIdentityNotificationTopicRequest.getIdentity().equals(getIdentity())) {
            return false;
        }
        if (((setIdentityNotificationTopicRequest.getNotificationType() == null ? 1 : 0) ^ (getNotificationType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setIdentityNotificationTopicRequest.getNotificationType() != null && !setIdentityNotificationTopicRequest.getNotificationType().equals(getNotificationType())) {
            return false;
        }
        return ((setIdentityNotificationTopicRequest.getSnsTopic() == null ? 1 : 0) ^ (getSnsTopic() == null ? 1 : 0)) == 0 ? setIdentityNotificationTopicRequest.getSnsTopic() == null || setIdentityNotificationTopicRequest.getSnsTopic().equals(getSnsTopic()) : false;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getNotificationType() {
        return this.notificationType;
    }

    public String getSnsTopic() {
        return this.snsTopic;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNotificationType() == null ? 0 : getNotificationType().hashCode()) + (((getIdentity() == null ? 0 : getIdentity().hashCode()) + 31) * 31)) * 31;
        if (getSnsTopic() != null) {
            i = getSnsTopic().hashCode();
        }
        return hashCode + i;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType.toString();
    }

    public void setNotificationType(String str) {
        this.notificationType = str;
    }

    public void setSnsTopic(String str) {
        this.snsTopic = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identity != null) {
            stringBuilder.append("Identity: " + this.identity + ", ");
        }
        if (this.notificationType != null) {
            stringBuilder.append("NotificationType: " + this.notificationType + ", ");
        }
        if (this.snsTopic != null) {
            stringBuilder.append("SnsTopic: " + this.snsTopic + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetIdentityNotificationTopicRequest withIdentity(String str) {
        this.identity = str;
        return this;
    }

    public SetIdentityNotificationTopicRequest withNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType.toString();
        return this;
    }

    public SetIdentityNotificationTopicRequest withNotificationType(String str) {
        this.notificationType = str;
        return this;
    }

    public SetIdentityNotificationTopicRequest withSnsTopic(String str) {
        this.snsTopic = str;
        return this;
    }
}
