package com.amazonaws.services.ec2.model;

public class VolumeStatusAction {
    private String code;
    private String description;
    private String eventId;
    private String eventType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeStatusAction)) {
            return false;
        }
        VolumeStatusAction volumeStatusAction = (VolumeStatusAction) obj;
        if (((volumeStatusAction.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusAction.getCode() != null && !volumeStatusAction.getCode().equals(getCode())) {
            return false;
        }
        if (((volumeStatusAction.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusAction.getDescription() != null && !volumeStatusAction.getDescription().equals(getDescription())) {
            return false;
        }
        if (((volumeStatusAction.getEventType() == null ? 1 : 0) ^ (getEventType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusAction.getEventType() != null && !volumeStatusAction.getEventType().equals(getEventType())) {
            return false;
        }
        return ((volumeStatusAction.getEventId() == null ? 1 : 0) ^ (getEventId() == null ? 1 : 0)) == 0 ? volumeStatusAction.getEventId() == null || volumeStatusAction.getEventId().equals(getEventId()) : false;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getEventType() == null ? 0 : getEventType().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getCode() == null ? 0 : getCode().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getEventId() != null) {
            i = getEventId().hashCode();
        }
        return hashCode + i;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.code != null) {
            stringBuilder.append("Code: " + this.code + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.eventType != null) {
            stringBuilder.append("EventType: " + this.eventType + ", ");
        }
        if (this.eventId != null) {
            stringBuilder.append("EventId: " + this.eventId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeStatusAction withCode(String str) {
        this.code = str;
        return this;
    }

    public VolumeStatusAction withDescription(String str) {
        this.description = str;
        return this;
    }

    public VolumeStatusAction withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public VolumeStatusAction withEventType(String str) {
        this.eventType = str;
        return this;
    }
}
