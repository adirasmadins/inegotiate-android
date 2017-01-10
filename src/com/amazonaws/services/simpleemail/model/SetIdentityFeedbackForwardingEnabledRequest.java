package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetIdentityFeedbackForwardingEnabledRequest extends AmazonWebServiceRequest {
    private Boolean forwardingEnabled;
    private String identity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetIdentityFeedbackForwardingEnabledRequest)) {
            return false;
        }
        SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest = (SetIdentityFeedbackForwardingEnabledRequest) obj;
        if (((setIdentityFeedbackForwardingEnabledRequest.getIdentity() == null ? 1 : 0) ^ (getIdentity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setIdentityFeedbackForwardingEnabledRequest.getIdentity() != null && !setIdentityFeedbackForwardingEnabledRequest.getIdentity().equals(getIdentity())) {
            return false;
        }
        return ((setIdentityFeedbackForwardingEnabledRequest.isForwardingEnabled() == null ? 1 : 0) ^ (isForwardingEnabled() == null ? 1 : 0)) == 0 ? setIdentityFeedbackForwardingEnabledRequest.isForwardingEnabled() == null || setIdentityFeedbackForwardingEnabledRequest.isForwardingEnabled().equals(isForwardingEnabled()) : false;
    }

    public Boolean getForwardingEnabled() {
        return this.forwardingEnabled;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIdentity() == null ? 0 : getIdentity().hashCode()) + 31) * 31;
        if (isForwardingEnabled() != null) {
            i = isForwardingEnabled().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isForwardingEnabled() {
        return this.forwardingEnabled;
    }

    public void setForwardingEnabled(Boolean bool) {
        this.forwardingEnabled = bool;
    }

    public void setIdentity(String str) {
        this.identity = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.identity != null) {
            stringBuilder.append("Identity: " + this.identity + ", ");
        }
        if (this.forwardingEnabled != null) {
            stringBuilder.append("ForwardingEnabled: " + this.forwardingEnabled + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetIdentityFeedbackForwardingEnabledRequest withForwardingEnabled(Boolean bool) {
        this.forwardingEnabled = bool;
        return this;
    }

    public SetIdentityFeedbackForwardingEnabledRequest withIdentity(String str) {
        this.identity = str;
        return this;
    }
}
