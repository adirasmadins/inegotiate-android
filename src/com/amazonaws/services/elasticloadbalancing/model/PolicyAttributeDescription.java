package com.amazonaws.services.elasticloadbalancing.model;

public class PolicyAttributeDescription {
    private String attributeName;
    private String attributeValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyAttributeDescription)) {
            return false;
        }
        PolicyAttributeDescription policyAttributeDescription = (PolicyAttributeDescription) obj;
        if (((policyAttributeDescription.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttributeDescription.getAttributeName() != null && !policyAttributeDescription.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        return ((policyAttributeDescription.getAttributeValue() == null ? 1 : 0) ^ (getAttributeValue() == null ? 1 : 0)) == 0 ? policyAttributeDescription.getAttributeValue() == null || policyAttributeDescription.getAttributeValue().equals(getAttributeValue()) : false;
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

    public PolicyAttributeDescription withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public PolicyAttributeDescription withAttributeValue(String str) {
        this.attributeValue = str;
        return this;
    }
}
