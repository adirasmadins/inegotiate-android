package com.amazonaws.services.sns.model;

public class ConfirmSubscriptionResult {
    private String subscriptionArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmSubscriptionResult)) {
            return false;
        }
        ConfirmSubscriptionResult confirmSubscriptionResult = (ConfirmSubscriptionResult) obj;
        return ((confirmSubscriptionResult.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) == 0 ? confirmSubscriptionResult.getSubscriptionArn() == null || confirmSubscriptionResult.getSubscriptionArn().equals(getSubscriptionArn()) : false;
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

    public ConfirmSubscriptionResult withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }
}
