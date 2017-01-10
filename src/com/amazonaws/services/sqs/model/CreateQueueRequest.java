package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.HashMap;
import java.util.Map;

public class CreateQueueRequest extends AmazonWebServiceRequest {
    private Map<String, String> attributes;
    private String queueName;

    public CreateQueueRequest(String str) {
        this.queueName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateQueueRequest)) {
            return false;
        }
        CreateQueueRequest createQueueRequest = (CreateQueueRequest) obj;
        if (((createQueueRequest.getQueueName() == null ? 1 : 0) ^ (getQueueName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createQueueRequest.getQueueName() != null && !createQueueRequest.getQueueName().equals(getQueueName())) {
            return false;
        }
        return ((createQueueRequest.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? createQueueRequest.getAttributes() == null || createQueueRequest.getAttributes().equals(getAttributes()) : false;
    }

    public Map<String, String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        return this.attributes;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueName() == null ? 0 : getQueueName().hashCode()) + 31) * 31;
        if (getAttributes() != null) {
            i = getAttributes().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public void setQueueName(String str) {
        this.queueName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueName != null) {
            stringBuilder.append("QueueName: " + this.queueName + ", ");
        }
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateQueueRequest withAttributes(Map<String, String> map) {
        setAttributes(map);
        return this;
    }

    public CreateQueueRequest withQueueName(String str) {
        this.queueName = str;
        return this;
    }
}
