package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListSubscriptionsRequest extends AmazonWebServiceRequest {
    private String nextToken;

    public ListSubscriptionsRequest(String str) {
        this.nextToken = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListSubscriptionsRequest)) {
            return false;
        }
        ListSubscriptionsRequest listSubscriptionsRequest = (ListSubscriptionsRequest) obj;
        return ((listSubscriptionsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listSubscriptionsRequest.getNextToken() == null || listSubscriptionsRequest.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        return (getNextToken() == null ? 0 : getNextToken().hashCode()) + 31;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListSubscriptionsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
