package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SubscribeRequest extends AmazonWebServiceRequest {
    private String endpoint;
    private String protocol;
    private String topicArn;

    public SubscribeRequest(String str, String str2, String str3) {
        this.topicArn = str;
        this.protocol = str2;
        this.endpoint = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SubscribeRequest)) {
            return false;
        }
        SubscribeRequest subscribeRequest = (SubscribeRequest) obj;
        if (((subscribeRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscribeRequest.getTopicArn() != null && !subscribeRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        if (((subscribeRequest.getProtocol() == null ? 1 : 0) ^ (getProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (subscribeRequest.getProtocol() != null && !subscribeRequest.getProtocol().equals(getProtocol())) {
            return false;
        }
        return ((subscribeRequest.getEndpoint() == null ? 1 : 0) ^ (getEndpoint() == null ? 1 : 0)) == 0 ? subscribeRequest.getEndpoint() == null || subscribeRequest.getEndpoint().equals(getEndpoint()) : false;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProtocol() == null ? 0 : getProtocol().hashCode()) + (((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31)) * 31;
        if (getEndpoint() != null) {
            i = getEndpoint().hashCode();
        }
        return hashCode + i;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
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
        if (this.protocol != null) {
            stringBuilder.append("Protocol: " + this.protocol + ", ");
        }
        if (this.endpoint != null) {
            stringBuilder.append("Endpoint: " + this.endpoint + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SubscribeRequest withEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public SubscribeRequest withProtocol(String str) {
        this.protocol = str;
        return this;
    }

    public SubscribeRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
