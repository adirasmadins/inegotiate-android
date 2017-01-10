package com.amazonaws.services.dynamodb.model;

public class ExpectedAttributeValue {
    private Boolean exists;
    private AttributeValue value;

    public ExpectedAttributeValue(AttributeValue attributeValue) {
        this.value = attributeValue;
    }

    public ExpectedAttributeValue(Boolean bool) {
        this.exists = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExpectedAttributeValue)) {
            return false;
        }
        ExpectedAttributeValue expectedAttributeValue = (ExpectedAttributeValue) obj;
        if (((expectedAttributeValue.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (expectedAttributeValue.getValue() != null && !expectedAttributeValue.getValue().equals(getValue())) {
            return false;
        }
        return ((expectedAttributeValue.isExists() == null ? 1 : 0) ^ (isExists() == null ? 1 : 0)) == 0 ? expectedAttributeValue.isExists() == null || expectedAttributeValue.isExists().equals(isExists()) : false;
    }

    public Boolean getExists() {
        return this.exists;
    }

    public AttributeValue getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + 31) * 31;
        if (isExists() != null) {
            i = isExists().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isExists() {
        return this.exists;
    }

    public void setExists(Boolean bool) {
        this.exists = bool;
    }

    public void setValue(AttributeValue attributeValue) {
        this.value = attributeValue;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        if (this.exists != null) {
            stringBuilder.append("Exists: " + this.exists + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ExpectedAttributeValue withExists(Boolean bool) {
        this.exists = bool;
        return this;
    }

    public ExpectedAttributeValue withValue(AttributeValue attributeValue) {
        this.value = attributeValue;
        return this;
    }
}
