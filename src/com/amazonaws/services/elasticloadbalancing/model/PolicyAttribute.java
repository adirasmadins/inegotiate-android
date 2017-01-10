package com.amazonaws.services.elasticloadbalancing.model;

public class PolicyAttribute {
    private String attributeName;
    private String attributeValue;

    public PolicyAttribute(String str, String str2) {
        this.attributeName = str;
        this.attributeValue = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyAttribute)) {
            return false;
        }
        PolicyAttribute policyAttribute = (PolicyAttribute) obj;
        if (((policyAttribute.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttribute.getAttributeName() != null && !policyAttribute.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        return ((policyAttribute.getAttributeValue() == null ? 1 : 0) ^ (getAttributeValue() == null ? 1 : 0)) == 0 ? policyAttribute.getAttributeValue() == null || policyAttribute.getAttributeValue().equals(getAttributeValue()) : false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + 31) * 31;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributeName != null) {
            stringBuilder.append("AttributeName: " + this.attributeName + ", ");
        }
        if (this.attributeValue != null) {
            stringBuilder.append("AttributeValue: " + this.attributeValue + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PolicyAttribute withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public PolicyAttribute withAttributeValue(String str) {
        this.attributeValue = str;
        return this;
    }
}
