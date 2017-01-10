package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;

public class SetSubscriptionAttributesRequest extends AmazonWebServiceRequest {
    private String attributeName;
    private String attributeValue;
    private String subscriptionArn;

    public SetSubscriptionAttributesRequest(String str, String str2, String str3) {
        this.subscriptionArn = str;
        this.attributeName = str2;
        this.attributeValue = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetSubscriptionAttributesRequest)) {
            return false;
        }
        SetSubscriptionAttributesRequest setSubscriptionAttributesRequest = (SetSubscriptionAttributesRequest) obj;
        if (((setSubscriptionAttributesRequest.getSubscriptionArn() == null ? 1 : 0) ^ (getSubscriptionArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setSubscriptionAttributesRequest.getSubscriptionArn() != null && !setSubscriptionAttributesRequest.getSubscriptionArn().equals(getSubscriptionArn())) {
            return false;
        }
        if (((setSubscriptionAttributesRequest.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (setSubscriptionAttributesRequest.getAttributeName() != null && !setSubscriptionAttributesRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        return ((setSubscriptionAttributesRequest.getAttributeValue() == null ? 1 : 0) ^ (getAttributeValue() == null ? 1 : 0)) == 0 ? setSubscriptionAttributesRequest.getAttributeValue() == null || setSubscriptionAttributesRequest.getAttributeValue().equals(getAttributeValue()) : false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    public String getSubscriptionArn() {
        return this.subscriptionArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + (((getSubscriptionArn() == null ? 0 : getSubscriptionArn().hashCode()) + 31) * 31)) * 31;
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

    public void setSubscriptionArn(String str) {
        this.subscriptionArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.subscriptionArn != null) {
            stringBuilder.append("SubscriptionArn: " + this.subscriptionArn + ", ");
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

    public SetSubscriptionAttributesRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public SetSubscriptionAttributesRequest withAttributeValue(String str) {
        this.attributeValue = str;
        return this;
    }

    public SetSubscriptionAttributesRequest withSubscriptionArn(String str) {
        this.subscriptionArn = str;
        return this;
    }
}
