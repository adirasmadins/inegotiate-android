package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetTopicAttributesRequest extends AmazonWebServiceRequest {
    private String attributeName;
    private String attributeValue;
    private String topicArn;

    public SetTopicAttributesRequest(String str, String str2, String str3) {
        this.topicArn = str;
        this.attributeName = str2;
        this.attributeValue = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetTopicAttributesRequest)) {
            return false;
        }
        SetTopicAttributesRequest setTopicAttributesRequest = (SetTopicAttributesRequest) obj;
        if (((setTopicAttributesRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setTopicAttributesRequest.getTopicArn() != null && !setTopicAttributesRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        if (((setTopicAttributesRequest.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setTopicAttributesRequest.getAttributeName() != null && !setTopicAttributesRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        return ((setTopicAttributesRequest.getAttributeValue() == null ? 1 : 0) ^ (getAttributeValue() == null ? 1 : 0)) == 0 ? setTopicAttributesRequest.getAttributeValue() == null || setTopicAttributesRequest.getAttributeValue().equals(getAttributeValue()) : false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + (((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31)) * 31;
        if (getAttributeValue() != null) {
            i = getAttributeValue().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setAttributeValue(String str) {
        this.attributeValue = str;
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
        if (this.attributeName != null) {
            stringBuilder.append("AttributeName: " + this.attributeName + ", ");
        }
        if (this.attributeValue != null) {
            stringBuilder.append("AttributeValue: " + this.attributeValue + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SetTopicAttributesRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public SetTopicAttributesRequest withAttributeValue(String str) {
        this.attributeValue = str;
        return this;
    }

    public SetTopicAttributesRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
