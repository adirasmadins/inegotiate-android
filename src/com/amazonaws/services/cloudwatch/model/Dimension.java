package com.amazonaws.services.cloudwatch.model;

public class Dimension {
    private String name;
    private String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (((dimension.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (dimension.getName() != null && !dimension.getName().equals(getName())) {
            return false;
        }
        return ((dimension.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) == 0 ? dimension.getValue() == null || dimension.getValue().equals(getValue()) : false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getName() == null ? 0 : getName().hashCode()) + 31) * 31;
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode + i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Dimension withName(String str) {
        this.name = str;
        return this;
    }

    public Dimension withValue(String str) {
        this.value = str;
        return this;
    }
}
