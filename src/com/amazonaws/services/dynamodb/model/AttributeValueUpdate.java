package com.amazonaws.services.dynamodb.model;

public class AttributeValueUpdate {
    private String action;
    private AttributeValue value;

    public AttributeValueUpdate(AttributeValue attributeValue, AttributeAction attributeAction) {
        this.value = attributeValue;
        this.action = attributeAction.toString();
    }

    public AttributeValueUpdate(AttributeValue attributeValue, String str) {
        this.value = attributeValue;
        this.action = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeValueUpdate)) {
            return false;
        }
        AttributeValueUpdate attributeValueUpdate = (AttributeValueUpdate) obj;
        if (((attributeValueUpdate.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attributeValueUpdate.getValue() != null && !attributeValueUpdate.getValue().equals(getValue())) {
            return false;
        }
        return ((attributeValueUpdate.getAction() == null ? 1 : 0) ^ (getAction() == null ? 1 : 0)) == 0 ? attributeValueUpdate.getAction() == null || attributeValueUpdate.getAction().equals(getAction()) : false;
    }

    public String getAction() {
        return this.action;
    }

    public AttributeValue getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + 31) * 31;
        if (getAction() != null) {
            i = getAction().hashCode();
        }
        return hashCode + i;
    }

    public void setAction(AttributeAction attributeAction) {
        this.action = attributeAction.toString();
    }

    public void setAction(String str) {
        this.action = str;
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
        if (this.action != null) {
            stringBuilder.append("Action: " + this.action + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AttributeValueUpdate withAction(AttributeAction attributeAction) {
        this.action = attributeAction.toString();
        return this;
    }

    public AttributeValueUpdate withAction(String str) {
        this.action = str;
        return this;
    }

    public AttributeValueUpdate withValue(AttributeValue attributeValue) {
        this.value = attributeValue;
        return this;
    }
}
