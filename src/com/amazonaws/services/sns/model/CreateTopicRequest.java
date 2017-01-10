package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CreateTopicRequest extends AmazonWebServiceRequest {
    private String name;

    public CreateTopicRequest(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateTopicRequest)) {
            return false;
        }
        CreateTopicRequest createTopicRequest = (CreateTopicRequest) obj;
        return ((createTopicRequest.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) == 0 ? createTopicRequest.getName() == null || createTopicRequest.getName().equals(getName()) : false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (getName() == null ? 0 : getName().hashCode()) + 31;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateTopicRequest withName(String str) {
        this.name = str;
        return this;
    }
}
