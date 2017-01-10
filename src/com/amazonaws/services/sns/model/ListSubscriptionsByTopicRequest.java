package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListSubscriptionsByTopicRequest extends AmazonWebServiceRequest {
    private String nextToken;
    private String topicArn;

    public ListSubscriptionsByTopicRequest(String str) {
        this.topicArn = str;
    }

    public ListSubscriptionsByTopicRequest(String str, String str2) {
        this.topicArn = str;
        this.nextToken = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListSubscriptionsByTopicRequest)) {
            return false;
        }
        ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest = (ListSubscriptionsByTopicRequest) obj;
        if (((listSubscriptionsByTopicRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listSubscriptionsByTopicRequest.getTopicArn() != null && !listSubscriptionsByTopicRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        return ((listSubscriptionsByTopicRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listSubscriptionsByTopicRequest.getNextToken() == null || listSubscriptionsByTopicRequest.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
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
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListSubscriptionsByTopicRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListSubscriptionsByTopicRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
