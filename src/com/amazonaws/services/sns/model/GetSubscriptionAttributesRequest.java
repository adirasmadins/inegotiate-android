package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetSubscriptionAttributesRequest extends AmazonWebServiceRequest {
    private String subscriptionArn;

    public GetSubscriptionAttributesRequest(String str) {
        this.subscriptionArn = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSubscriptionAttributesRequest)) {
            return false;
        }
        GetSubscriptionAttributesRequest getSubscriptionAttributesRequest = (GetSubscriptionAttributesRequest) obj;
        return ((getSubscriptionAttributesRequest.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) == 0 ? getSubscriptionAttributesRequest.getSubscriptionArn() == null || getSubscriptionAttributesRequest.getSubscriptionArn().equals(getSubscriptionArn()) : false;
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

    public GetSubscriptionAttributesRequest withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }
}
