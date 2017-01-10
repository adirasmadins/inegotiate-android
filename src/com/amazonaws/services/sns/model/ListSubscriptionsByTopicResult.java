package com.amazonaws.services.sns.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListSubscriptionsByTopicResult {
    private String nextToken;
    private List<Subscription> subscriptions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListSubscriptionsByTopicResult)) {
            return false;
        }
        ListSubscriptionsByTopicResult listSubscriptionsByTopicResult = (ListSubscriptionsByTopicResult) obj;
        if (((listSubscriptionsByTopicResult.getSubscriptions() == null ? 1 : 0) ^ (getSubscriptions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listSubscriptionsByTopicResult.getSubscriptions() != null && !listSubscriptionsByTopicResult.getSubscriptions().equals(getSubscriptions())) {
            return false;
        }
        return ((listSubscriptionsByTopicResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listSubscriptionsByTopicResult.getNextToken() == null || listSubscriptionsByTopicResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<Subscription> getSubscriptions() {
        if (this.subscriptions == null) {
            this.subscriptions = new ArrayList();
        }
        return this.subscriptions;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSubscriptions() == null ? 0 : getSubscriptions().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setSubscriptions(Collection<Subscription> collection) {
        if (collection == null) {
            this.subscriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.subscriptions = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subscriptions != null) {
            stringBuilder.append("Subscriptions: " + this.subscriptions + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListSubscriptionsByTopicResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListSubscriptionsByTopicResult withSubscriptions(Collection<Subscription> collection) {
        if (collection == null) {
            this.subscriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.subscriptions = arrayList;
        }
        return this;
    }

    public ListSubscriptionsByTopicResult withSubscriptions(Subscription... subscriptionArr) {
        if (getSubscriptions() == null) {
            setSubscriptions(new ArrayList(subscriptionArr.length));
        }
        for (Object add : subscriptionArr) {
            getSubscriptions().add(add);
        }
        return this;
    }
}
