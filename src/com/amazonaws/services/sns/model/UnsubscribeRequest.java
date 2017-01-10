package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class UnsubscribeRequest extends AmazonWebServiceRequest {
    private String subscriptionArn;

    public UnsubscribeRequest(String str) {
        this.subscriptionArn = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnsubscribeRequest)) {
            return false;
        }
        UnsubscribeRequest unsubscribeRequest = (UnsubscribeRequest) obj;
        return ((unsubscribeRequest.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) == 0 ? unsubscribeRequest.getSubscriptionArn() == null || unsubscribeRequest.getSubscriptionArn().equals(getSubscriptionArn()) : false;
    }

    public String getSubscriptionArn() {
        return this.subscriptionArn;
    }

    public int hashCode() {
        return (getSubscriptionArn() == null ? 0 : getSubscriptionArn().hashCode()) + 31;
    }

    public void setSubscriptionArn(String str) {
        this.subscriptionArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subscriptionArn != null) {
            stringBuilder.append("SubscriptionArn: " + this.subscriptionArn + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UnsubscribeRequest withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }
}
