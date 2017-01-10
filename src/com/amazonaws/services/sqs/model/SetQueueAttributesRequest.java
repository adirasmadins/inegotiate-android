package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.HashMap;
import java.util.Map;

public class SetQueueAttributesRequest extends AmazonWebServiceRequest {
    private Map<String, String> attributes;
    private String queueUrl;

    public SetQueueAttributesRequest(String str, Map<String, String> map) {
        this.queueUrl = str;
        this.attributes = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetQueueAttributesRequest)) {
            return false;
        }
        SetQueueAttributesRequest setQueueAttributesRequest = (SetQueueAttributesRequest) obj;
        if (((setQueueAttributesRequest.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setQueueAttributesRequest.getQueueUrl() != null && !setQueueAttributesRequest.getQueueUrl().equals(getQueueUrl())) {
            return false;
        }
        return ((setQueueAttributesRequest.getAttributes() == null ? 1 : 0) ^ (getAttributes() == null ? 1 : 0)) == 0 ? setQueueAttributesRequest.getAttributes() == null || setQueueAttributesRequest.getAttributes().equals(getAttributes()) : false;
    }

    public Map<String, String> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        return this.attributes;
    }

    public String getQueueUrl() {
        return this.queueUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getQueueUrl() == null ? 0 : getQueueUrl().hashCode()) + 31) * 31;
        if (getAttributes() != null) {
            i = getAttributes().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public void setQueueUrl(String str) {
        this.queueUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.queueUrl != null) {
            stringBuilder.append("QueueUrl: " + this.queueUrl + ", ");
        }
        if (this.attributes != null) {
            stringBuilder.append("Attributes: " + this.attributes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetQueueAttributesRequest withAttributes(Map<String, String> map) {
        setAttributes(map);
        return this;
    }

    public SetQueueAttributesRequest withQueueUrl(String str) {
        this.queueUrl = str;
        return this;
    }
}
