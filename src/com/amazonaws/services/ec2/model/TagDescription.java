package com.amazonaws.services.ec2.model;

public class TagDescription {
    private String key;
    private String resourceId;
    private String resourceType;
    private String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TagDescription)) {
            return false;
        }
        TagDescription tagDescription = (TagDescription) obj;
        if (((tagDescription.getResourceId() == null ? 1 : 0) ^ (getResourceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (tagDescription.getResourceId() != null && !tagDescription.getResourceId().equals(getResourceId())) {
            return false;
        }
        if (((tagDescription.getResourceType() == null ? 1 : 0) ^ (getResourceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (tagDescription.getResourceType() != null && !tagDescription.getResourceType().equals(getResourceType())) {
            return false;
        }
        if (((tagDescription.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (tagDescription.getKey() != null && !tagDescription.getKey().equals(getKey())) {
            return false;
        }
        return ((tagDescription.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) == 0 ? tagDescription.getValue() == null || tagDescription.getValue().equals(getValue()) : false;
    }

    public String getKey() {
        return this.key;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKey() == null ? 0 : getKey().hashCode()) + (((getResourceType() == null ? 0 : getResourceType().hashCode()) + (((getResourceId() == null ? 0 : getResourceId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode + i;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType.toString();
    }

    public void setResourceType(String str) {
        this.resourceType = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.resourceId != null) {
            stringBuilder.append("ResourceId: " + this.resourceId + ", ");
        }
        if (this.resourceType != null) {
            stringBuilder.append("ResourceType: " + this.resourceType + ", ");
        }
        if (this.key != null) {
            stringBuilder.append("Key: " + this.key + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public TagDescription withKey(String str) {
        this.key = str;
        return this;
    }

    public TagDescription withResourceId(String str) {
        this.resourceId = str;
        return this;
    }

    public TagDescription withResourceType(ResourceType resourceType) {
        this.resourceType = resourceType.toString();
        return this;
    }

    public TagDescription withResourceType(String str) {
        this.resourceType = str;
        return this;
    }

    public TagDescription withValue(String str) {
        this.value = str;
        return this;
    }
}
