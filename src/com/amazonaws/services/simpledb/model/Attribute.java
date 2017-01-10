package com.amazonaws.services.simpledb.model;

public class Attribute {
    private String alternateNameEncoding;
    private String alternateValueEncoding;
    private String name;
    private String value;

    public Attribute(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (((attribute.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attribute.getName() != null && !attribute.getName().equals(getName())) {
            return false;
        }
        if (((attribute.getAlternateNameEncoding() == null ? 1 : 0) ^ (getAlternateNameEncoding() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attribute.getAlternateNameEncoding() != null && !attribute.getAlternateNameEncoding().equals(getAlternateNameEncoding())) {
            return false;
        }
        if (((attribute.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (attribute.getValue() != null && !attribute.getValue().equals(getValue())) {
            return false;
        }
        return ((attribute.getAlternateValueEncoding() == null ? 1 : 0) ^ (getAlternateValueEncoding() == null ? 1 : 0)) == 0 ? attribute.getAlternateValueEncoding() == null || attribute.getAlternateValueEncoding().equals(getAlternateValueEncoding()) : false;
    }

    public String getAlternateNameEncoding() {
        return this.alternateNameEncoding;
    }

    public String getAlternateValueEncoding() {
        return this.alternateValueEncoding;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + (((getAlternateNameEncoding() == null ? 0 : getAlternateNameEncoding().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getAlternateValueEncoding() != null) {
            i = getAlternateValueEncoding().hashCode();
        }
        return hashCode + i;
    }

    public void setAlternateNameEncoding(String str) {
        this.alternateNameEncoding = str;
    }

    public void setAlternateValueEncoding(String str) {
        this.alternateValueEncoding = str;
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
        if (this.alternateNameEncoding != null) {
            stringBuilder.append("AlternateNameEncoding: " + this.alternateNameEncoding + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        if (this.alternateValueEncoding != null) {
            stringBuilder.append("AlternateValueEncoding: " + this.alternateValueEncoding + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Attribute withAlternateNameEncoding(String str) {
        this.alternateNameEncoding = str;
        return this;
    }

    public Attribute withAlternateValueEncoding(String str) {
        this.alternateValueEncoding = str;
        return this;
    }

    public Attribute withName(String str) {
        this.name = str;
        return this;
    }

    public Attribute withValue(String str) {
        this.value = str;
        return this;
    }
}
