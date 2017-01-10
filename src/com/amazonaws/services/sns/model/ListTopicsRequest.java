package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ListTopicsRequest extends AmazonWebServiceRequest {
    private String nextToken;

    public ListTopicsRequest(String str) {
        this.nextToken = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTopicsRequest)) {
            return false;
        }
        ListTopicsRequest listTopicsRequest = (ListTopicsRequest) obj;
        return ((listTopicsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listTopicsRequest.getNextToken() == null || listTopicsRequest.getNextToken().equals(getNextToken()) : false;
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

    public ListTopicsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
