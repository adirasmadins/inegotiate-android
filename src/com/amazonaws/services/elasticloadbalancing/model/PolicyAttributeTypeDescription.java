package com.amazonaws.services.elasticloadbalancing.model;

public class PolicyAttributeTypeDescription {
    private String attributeName;
    private String attributeType;
    private String cardinality;
    private String defaultValue;
    private String description;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyAttributeTypeDescription)) {
            return false;
        }
        PolicyAttributeTypeDescription policyAttributeTypeDescription = (PolicyAttributeTypeDescription) obj;
        if (((policyAttributeTypeDescription.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttributeTypeDescription.getAttributeName() != null && !policyAttributeTypeDescription.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if (((policyAttributeTypeDescription.getAttributeType() == null ? 1 : 0) ^ (getAttributeType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttributeTypeDescription.getAttributeType() != null && !policyAttributeTypeDescription.getAttributeType().equals(getAttributeType())) {
            return false;
        }
        if (((policyAttributeTypeDescription.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttributeTypeDescription.getDescription() != null && !policyAttributeTypeDescription.getDescription().equals(getDescription())) {
            return false;
        }
        if (((policyAttributeTypeDescription.getDefaultValue() == null ? 1 : 0) ^ (getDefaultValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (policyAttributeTypeDescription.getDefaultValue() != null && !policyAttributeTypeDescription.getDefaultValue().equals(getDefaultValue())) {
            return false;
        }
        return ((policyAttributeTypeDescription.getCardinality() == null ? 1 : 0) ^ (getCardinality() == null ? 1 : 0)) == 0 ? policyAttributeTypeDescription.getCardinality() == null || policyAttributeTypeDescription.getCardinality().equals(getCardinality()) : false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeType() {
        return this.attributeType;
    }

    public String getCardinality() {
        return this.cardinality;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDefaultValue() == null ? 0 : getDefaultValue().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getAttributeType() == null ? 0 : getAttributeType().hashCode()) + (((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getCardinality() != null) {
            i = getCardinality().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setAttributeType(String str) {
        this.attributeType = str;
    }

    public void setCardinality(String str) {
        this.cardinality = str;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.attributeName != null) {
            stringBuilder.append("AttributeName: " + this.attributeName + ", ");
        }
        if (this.attributeType != null) {
            stringBuilder.append("AttributeType: " + this.attributeType + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.defaultValue != null) {
            stringBuilder.append("DefaultValue: " + this.defaultValue + ", ");
        }
        if (this.cardinality != null) {
            stringBuilder.append("Cardinality: " + this.cardinality + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PolicyAttributeTypeDescription withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public PolicyAttributeTypeDescription withAttributeType(String str) {
        this.attributeType = str;
        return this;
    }

    public PolicyAttributeTypeDescription withCardinality(String str) {
        this.cardinality = str;
        return this;
    }

    public PolicyAttributeTypeDescription withDefaultValue(String str) {
        this.defaultValue = str;
        return this;
    }

    public PolicyAttributeTypeDescription withDescription(String str) {
        this.description = str;
        return this;
    }
}
