package com.amazonaws.services.simpledb.model;

public class ReplaceableAttribute {
    private String name;
    private Boolean replace;
    private String value;

    public ReplaceableAttribute(String str, String str2, Boolean bool) {
        this.name = str;
        this.value = str2;
        this.replace = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplaceableAttribute)) {
            return false;
        }
        ReplaceableAttribute replaceableAttribute = (ReplaceableAttribute) obj;
        if (((replaceableAttribute.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (replaceableAttribute.getName() != null && !replaceableAttribute.getName().equals(getName())) {
            return false;
        }
        if (((replaceableAttribute.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (replaceableAttribute.getValue() != null && !replaceableAttribute.getValue().equals(getValue())) {
            return false;
        }
        return ((replaceableAttribute.isReplace() == null ? 1 : 0) ^ (isReplace() == null ? 1 : 0)) == 0 ? replaceableAttribute.isReplace() == null || replaceableAttribute.isReplace().equals(isReplace()) : false;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getReplace() {
        return this.replace;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31;
        if (isReplace() != null) {
            i = isReplace().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isReplace() {
        return this.replace;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReplace(Boolean bool) {
        this.replace = bool;
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
        if (this.replace != null) {
            stringBuilder.append("Replace: " + this.replace + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReplaceableAttribute withName(String str) {
        this.name = str;
        return this;
    }

    public ReplaceableAttribute withReplace(Boolean bool) {
        this.replace = bool;
        return this;
    }

    public ReplaceableAttribute withValue(String str) {
        this.value = str;
        return this;
    }
}
