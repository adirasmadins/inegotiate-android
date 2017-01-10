package com.amazonaws.services.sns.model;

public class Subscription {
    private String endpoint;
    private String owner;
    private String protocol;
    private String subscriptionArn;
    private String topicArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (((subscription.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscription.getSubscriptionArn() != null && !subscription.getSubscriptionArn().equals(getSubscriptionArn())) {
            return false;
        }
        if (((subscription.getOwner() == null ? 1 : 0) ^ (getOwner() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscription.getOwner() != null && !subscription.getOwner().equals(getOwner())) {
            return false;
        }
        if (((subscription.getProtocol() == null ? 1 : 0) ^ (getProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscription.getProtocol() != null && !subscription.getProtocol().equals(getProtocol())) {
            return false;
        }
        if (((subscription.getEndpoint() == null ? 1 : 0) ^ (getEndpoint() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscription.getEndpoint() != null && !subscription.getEndpoint().equals(getEndpoint())) {
            return false;
        }
        return ((subscription.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) == 0 ? subscription.getTopicArn() == null || subscription.getTopicArn().equals(getTopicArn()) : false;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSubscriptionArn() {
        return this.subscriptionArn;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getEndpoint() == null ? 0 : getEndpoint().hashCode()) + (((getProtocol() == null ? 0 : getProtocol().hashCode()) + (((getOwner() == null ? 0 : getOwner().hashCode()) + (((getSubscriptionArn() == null ? 0 : getSubscriptionArn().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getTopicArn() != null) {
            i = getTopicArn().hashCode();
        }
        return hashCode + i;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSubscriptionArn(String str) {
        this.subscriptionArn = str;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subscriptionArn != null) {
            stringBuilder.append("SubscriptionArn: " + this.subscriptionArn + ", ");
        }
        if (this.owner != null) {
            stringBuilder.append("Owner: " + this.owner + ", ");
        }
        if (this.protocol != null) {
            stringBuilder.append("Protocol: " + this.protocol + ", ");
        }
        if (this.endpoint != null) {
            stringBuilder.append("Endpoint: " + this.endpoint + ", ");
        }
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Subscription withEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public Subscription withOwner(String str) {
        this.owner = str;
        return this;
    }

    public Subscription withProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public Subscription withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }

    public Subscription withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
