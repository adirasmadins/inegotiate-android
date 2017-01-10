package com.amazonaws.services.dynamodb.model;

public class KeySchemaElement {
    private String attributeName;
    private String attributeType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeySchemaElement)) {
            return false;
        }
        KeySchemaElement keySchemaElement = (KeySchemaElement) obj;
        if (((keySchemaElement.getAttributeName() == null ? 1 : 0) ^ (getAttributeName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (keySchemaElement.getAttributeName() != null && !keySchemaElement.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        return ((keySchemaElement.getAttributeType() == null ? 1 : 0) ^ (getAttributeType() == null ? 1 : 0)) == 0 ? keySchemaElement.getAttributeType() == null || keySchemaElement.getAttributeType().equals(getAttributeType()) : false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getAttributeType() {
        return this.attributeType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + 31) * 31;
        if (getAttributeType() != null) {
            i = getAttributeType().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setAttributeType(ScalarAttributeType scalarAttributeType) {
        this.attributeType = scalarAttributeType.toString();
    }

    public void setAttributeType(String str) {
        this.attributeType = str;
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public KeySchemaElement withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public KeySchemaElement withAttributeType(ScalarAttributeType scalarAttributeType) {
        this.attributeType = scalarAttributeType.toString();
        return this;
    }

    public KeySchemaElement withAttributeType(String str) {
        this.attributeType = str;
        return this;
    }
}
