package com.amazonaws.services.dynamodb.model;

public class KeySchema {
    private KeySchemaElement hashKeyElement;
    private KeySchemaElement rangeKeyElement;

    public KeySchema(KeySchemaElement keySchemaElement) {
        this.hashKeyElement = keySchemaElement;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeySchema)) {
            return false;
        }
        KeySchema keySchema = (KeySchema) obj;
        if (((keySchema.getHashKeyElement() == null ? 1 : 0) ^ (getHashKeyElement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (keySchema.getHashKeyElement() != null && !keySchema.getHashKeyElement().equals(getHashKeyElement())) {
            return false;
        }
        return ((keySchema.getRangeKeyElement() == null ? 1 : 0) ^ (getRangeKeyElement() == null ? 1 : 0)) == 0 ? keySchema.getRangeKeyElement() == null || keySchema.getRangeKeyElement().equals(getRangeKeyElement()) : false;
    }

    public KeySchemaElement getHashKeyElement() {
        return this.hashKeyElement;
    }

    public KeySchemaElement getRangeKeyElement() {
        return this.rangeKeyElement;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getHashKeyElement() == null ? 0 : getHashKeyElement().hashCode()) + 31) * 31;
        if (getRangeKeyElement() != null) {
            i = getRangeKeyElement().hashCode();
        }
        return hashCode + i;
    }

    public void setHashKeyElement(KeySchemaElement keySchemaElement) {
        this.hashKeyElement = keySchemaElement;
    }

    public void setRangeKeyElement(KeySchemaElement keySchemaElement) {
        this.rangeKeyElement = keySchemaElement;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.hashKeyElement != null) {
            stringBuilder.append("HashKeyElement: " + this.hashKeyElement + ", ");
        }
        if (this.rangeKeyElement != null) {
            stringBuilder.append("RangeKeyElement: " + this.rangeKeyElement + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public KeySchema withHashKeyElement(KeySchemaElement keySchemaElement) {
        this.hashKeyElement = keySchemaElement;
        return this;
    }

    public KeySchema withRangeKeyElement(KeySchemaElement keySchemaElement) {
        this.rangeKeyElement = keySchemaElement;
        return this;
    }
}
