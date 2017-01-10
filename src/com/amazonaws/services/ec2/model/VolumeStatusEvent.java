package com.amazonaws.services.ec2.model;

import java.util.Date;

public class VolumeStatusEvent {
    private String description;
    private String eventId;
    private String eventType;
    private Date notAfter;
    private Date notBefore;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeStatusEvent)) {
            return false;
        }
        VolumeStatusEvent volumeStatusEvent = (VolumeStatusEvent) obj;
        if (((volumeStatusEvent.getEventType() == null ? 1 : 0) ^ (getEventType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusEvent.getEventType() != null && !volumeStatusEvent.getEventType().equals(getEventType())) {
            return false;
        }
        if (((volumeStatusEvent.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusEvent.getDescription() != null && !volumeStatusEvent.getDescription().equals(getDescription())) {
            return false;
        }
        if (((volumeStatusEvent.getNotBefore() == null ? 1 : 0) ^ (getNotBefore() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusEvent.getNotBefore() != null && !volumeStatusEvent.getNotBefore().equals(getNotBefore())) {
            return false;
        }
        if (((volumeStatusEvent.getNotAfter() == null ? 1 : 0) ^ (getNotAfter() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusEvent.getNotAfter() != null && !volumeStatusEvent.getNotAfter().equals(getNotAfter())) {
            return false;
        }
        return ((volumeStatusEvent.getEventId() == null ? 1 : 0) ^ (getEventId() == null ? 1 : 0)) == 0 ? volumeStatusEvent.getEventId() == null || volumeStatusEvent.getEventId().equals(getEventId()) : false;
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

    public Date getNotAfter() {
        return this.notAfter;
    }

    public Date getNotBefore() {
        return this.notBefore;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNotAfter() == null ? 0 : getNotAfter().hashCode()) + (((getNotBefore() == null ? 0 : getNotBefore().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getEventType() == null ? 0 : getEventType().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getEventId() != null) {
            i = getEventId().hashCode();
        }
        return hashCode + i;
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

    public void setNotAfter(Date date) {
        this.notAfter = date;
    }

    public void setNotBefore(Date date) {
        this.notBefore = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.eventType != null) {
            stringBuilder.append("EventType: " + this.eventType + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.notBefore != null) {
            stringBuilder.append("NotBefore: " + this.notBefore + ", ");
        }
        if (this.notAfter != null) {
            stringBuilder.append("NotAfter: " + this.notAfter + ", ");
        }
        if (this.eventId != null) {
            stringBuilder.append("EventId: " + this.eventId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeStatusEvent withDescription(String str) {
        this.description = str;
        return this;
    }

    public VolumeStatusEvent withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public VolumeStatusEvent withEventType(String str) {
        this.eventType = str;
        return this;
    }

    public VolumeStatusEvent withNotAfter(Date date) {
        this.notAfter = date;
        return this;
    }

    public VolumeStatusEvent withNotBefore(Date date) {
        this.notBefore = date;
        return this;
    }
}
