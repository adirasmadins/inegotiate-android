package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class GetTopicAttributesRequest extends AmazonWebServiceRequest {
    private String topicArn;

    public GetTopicAttributesRequest(String str) {
        this.topicArn = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetTopicAttributesRequest)) {
            return false;
        }
        GetTopicAttributesRequest getTopicAttributesRequest = (GetTopicAttributesRequest) obj;
        return ((getTopicAttributesRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) == 0 ? getTopicAttributesRequest.getTopicArn() == null || getTopicAttributesRequest.getTopicArn().equals(getTopicArn()) : false;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        return (getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetTopicAttributesRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
