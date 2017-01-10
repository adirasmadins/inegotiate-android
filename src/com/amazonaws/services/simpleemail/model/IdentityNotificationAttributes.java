package com.amazonaws.services.simpleemail.model;

public class IdentityNotificationAttributes {
    private String bounceTopic;
    private String complaintTopic;
    private Boolean forwardingEnabled;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityNotificationAttributes)) {
            return false;
        }
        IdentityNotificationAttributes identityNotificationAttributes = (IdentityNotificationAttributes) obj;
        if (((identityNotificationAttributes.getBounceTopic() == null ? 1 : 0) ^ (getBounceTopic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (identityNotificationAttributes.getBounceTopic() != null && !identityNotificationAttributes.getBounceTopic().equals(getBounceTopic())) {
            return false;
        }
        if (((identityNotificationAttributes.getComplaintTopic() == null ? 1 : 0) ^ (getComplaintTopic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (identityNotificationAttributes.getComplaintTopic() != null && !identityNotificationAttributes.getComplaintTopic().equals(getComplaintTopic())) {
            return false;
        }
        return ((identityNotificationAttributes.isForwardingEnabled() == null ? 1 : 0) ^ (isForwardingEnabled() == null ? 1 : 0)) == 0 ? identityNotificationAttributes.isForwardingEnabled() == null || identityNotificationAttributes.isForwardingEnabled().equals(isForwardingEnabled()) : false;
    }

    public String getBounceTopic() {
        return this.bounceTopic;
    }

    public String getComplaintTopic() {
        return this.complaintTopic;
    }

    public Boolean getForwardingEnabled() {
        return this.forwardingEnabled;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getComplaintTopic() == null ? 0 : getComplaintTopic().hashCode()) + (((getBounceTopic() == null ? 0 : getBounceTopic().hashCode()) + 31) * 31)) * 31;
        if (isForwardingEnabled() != null) {
            i = isForwardingEnabled().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isForwardingEnabled() {
        return this.forwardingEnabled;
    }

    public void setBounceTopic(String str) {
        this.bounceTopic = str;
    }

    public void setComplaintTopic(String str) {
        this.complaintTopic = str;
    }

    public void setForwardingEnabled(Boolean bool) {
        this.forwardingEnabled = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bounceTopic != null) {
            stringBuilder.append("BounceTopic: " + this.bounceTopic + ", ");
        }
        if (this.complaintTopic != null) {
            stringBuilder.append("ComplaintTopic: " + this.complaintTopic + ", ");
        }
        if (this.forwardingEnabled != null) {
            stringBuilder.append("ForwardingEnabled: " + this.forwardingEnabled + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IdentityNotificationAttributes withBounceTopic(String str) {
        this.bounceTopic = str;
        return this;
    }

    public IdentityNotificationAttributes withComplaintTopic(String str) {
        this.complaintTopic = str;
        return this;
    }

    public IdentityNotificationAttributes withForwardingEnabled(Boolean bool) {
        this.forwardingEnabled = bool;
        return this;
    }
}
