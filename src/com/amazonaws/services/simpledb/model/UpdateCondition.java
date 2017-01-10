package com.amazonaws.services.simpledb.model;

public class UpdateCondition {
    private Boolean exists;
    private String name;
    private String value;

    public UpdateCondition(String str, String str2, Boolean bool) {
        this.name = str;
        this.value = str2;
        this.exists = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateCondition)) {
            return false;
        }
        UpdateCondition updateCondition = (UpdateCondition) obj;
        if (((updateCondition.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateCondition.getName() != null && !updateCondition.getName().equals(getName())) {
            return false;
        }
        if (((updateCondition.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateCondition.getValue() != null && !updateCondition.getValue().equals(getValue())) {
            return false;
        }
        return ((updateCondition.isExists() == null ? 1 : 0) ^ (isExists() == null ? 1 : 0)) == 0 ? updateCondition.isExists() == null || updateCondition.isExists().equals(isExists()) : false;
    }

    public Boolean getExists() {
        return this.exists;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31;
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
        if (this.exists != null) {
            stringBuilder.append("Exists: " + this.exists + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UpdateCondition withExists(Boolean bool) {
        this.exists = bool;
        return this;
    }

    public UpdateCondition withName(String str) {
        this.name = str;
        return this;
    }

    public UpdateCondition withValue(String str) {
        this.value = str;
        return this;
    }
}
