package com.amazonaws.services.sns.model;

public class SubscribeResult {
    private String subscriptionArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SubscribeResult)) {
            return false;
        }
        SubscribeResult subscribeResult = (SubscribeResult) obj;
        return ((subscribeResult.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) == 0 ? subscribeResult.getSubscriptionArn() == null || subscribeResult.getSubscriptionArn().equals(getSubscriptionArn()) : false;
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

    public SubscribeResult withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }
}
