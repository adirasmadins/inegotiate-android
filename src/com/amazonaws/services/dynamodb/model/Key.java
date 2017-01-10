package com.amazonaws.services.dynamodb.model;

public class Key {
    private AttributeValue hashKeyElement;
    private AttributeValue rangeKeyElement;

    public Key(AttributeValue attributeValue) {
        this.hashKeyElement = attributeValue;
    }

    public Key(AttributeValue attributeValue, AttributeValue attributeValue2) {
        this.hashKeyElement = attributeValue;
        this.rangeKeyElement = attributeValue2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Key)) {
            return false;
        }
        Key key = (Key) obj;
        if (((key.getHashKeyElement() == null ? 1 : 0) ^ (getHashKeyElement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (key.getHashKeyElement() != null && !key.getHashKeyElement().equals(getHashKeyElement())) {
            return false;
        }
        return ((key.getRangeKeyElement() == null ? 1 : 0) ^ (getRangeKeyElement() == null ? 1 : 0)) == 0 ? key.getRangeKeyElement() == null || key.getRangeKeyElement().equals(getRangeKeyElement()) : false;
    }

    public AttributeValue getHashKeyElement() {
        return this.hashKeyElement;
    }

    public AttributeValue getRangeKeyElement() {
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

    public void setHashKeyElement(AttributeValue attributeValue) {
        this.hashKeyElement = attributeValue;
    }

    public void setRangeKeyElement(AttributeValue attributeValue) {
        this.rangeKeyElement = attributeValue;
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

    public Key withHashKeyElement(AttributeValue attributeValue) {
        this.hashKeyElement = attributeValue;
        return this;
    }

    public Key withRangeKeyElement(AttributeValue attributeValue) {
        this.rangeKeyElement = attributeValue;
        return this;
    }
}
