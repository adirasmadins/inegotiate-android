package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ConfirmSubscriptionRequest extends AmazonWebServiceRequest {
    private String authenticateOnUnsubscribe;
    private String token;
    private String topicArn;

    public ConfirmSubscriptionRequest(String str, String str2) {
        this.topicArn = str;
        this.token = str2;
    }

    public ConfirmSubscriptionRequest(String str, String str2, String str3) {
        this.topicArn = str;
        this.token = str2;
        this.authenticateOnUnsubscribe = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmSubscriptionRequest)) {
            return false;
        }
        ConfirmSubscriptionRequest confirmSubscriptionRequest = (ConfirmSubscriptionRequest) obj;
        if (((confirmSubscriptionRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (confirmSubscriptionRequest.getTopicArn() != null && !confirmSubscriptionRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        if (((confirmSubscriptionRequest.getToken() == null ? 1 : 0) ^ (getToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (confirmSubscriptionRequest.getToken() != null && !confirmSubscriptionRequest.getToken().equals(getToken())) {
            return false;
        }
        return ((confirmSubscriptionRequest.getAuthenticateOnUnsubscribe() == null ? 1 : 0) ^ (getAuthenticateOnUnsubscribe() == null ? 1 : 0)) == 0 ? confirmSubscriptionRequest.getAuthenticateOnUnsubscribe() == null || confirmSubscriptionRequest.getAuthenticateOnUnsubscribe().equals(getAuthenticateOnUnsubscribe()) : false;
    }

    public String getAuthenticateOnUnsubscribe() {
        return this.authenticateOnUnsubscribe;
    }

    public String getToken() {
        return this.token;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getToken() == null ? 0 : getToken().hashCode()) + (((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31)) * 31;
        if (getAuthenticateOnUnsubscribe() != null) {
            i = getAuthenticateOnUnsubscribe().hashCode();
        }
        return hashCode + i;
    }

    public void setAuthenticateOnUnsubscribe(String str) {
        this.authenticateOnUnsubscribe = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
        }
        if (this.token != null) {
            stringBuilder.append("Token: " + this.token + ", ");
        }
        if (this.authenticateOnUnsubscribe != null) {
            stringBuilder.append("AuthenticateOnUnsubscribe: " + this.authenticateOnUnsubscribe + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConfirmSubscriptionRequest withAuthenticateOnUnsubscribe(String str) {
        this.authenticateOnUnsubscribe = str;
        return this;
    }

    public ConfirmSubscriptionRequest withToken(String str) {
        this.token = str;
        return this;
    }

    public ConfirmSubscriptionRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
