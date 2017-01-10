package com.amazonaws.services.cloudwatch.model;

public class DimensionFilter {
    private String name;
    private String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DimensionFilter)) {
            return false;
        }
        DimensionFilter dimensionFilter = (DimensionFilter) obj;
        if (((dimensionFilter.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (dimensionFilter.getName() != null && !dimensionFilter.getName().equals(getName())) {
            return false;
        }
        return ((dimensionFilter.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) == 0 ? dimensionFilter.getValue() == null || dimensionFilter.getValue().equals(getValue()) : false;
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

    public DimensionFilter withName(String str) {
        this.name = str;
        return this;
    }

    public DimensionFilter withValue(String str) {
        this.value = str;
        return this;
    }
}
