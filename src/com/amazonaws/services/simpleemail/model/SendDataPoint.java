package com.amazonaws.services.simpleemail.model;

import java.util.Date;

public class SendDataPoint {
    private Long bounces;
    private Long complaints;
    private Long deliveryAttempts;
    private Long rejects;
    private Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SendDataPoint)) {
            return false;
        }
        SendDataPoint sendDataPoint = (SendDataPoint) obj;
        if (((sendDataPoint.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendDataPoint.getTimestamp() != null && !sendDataPoint.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        if (((sendDataPoint.getDeliveryAttempts() == null ? 1 : 0) ^ (getDeliveryAttempts() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendDataPoint.getDeliveryAttempts() != null && !sendDataPoint.getDeliveryAttempts().equals(getDeliveryAttempts())) {
            return false;
        }
        if (((sendDataPoint.getBounces() == null ? 1 : 0) ^ (getBounces() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendDataPoint.getBounces() != null && !sendDataPoint.getBounces().equals(getBounces())) {
            return false;
        }
        if (((sendDataPoint.getComplaints() == null ? 1 : 0) ^ (getComplaints() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (sendDataPoint.getComplaints() != null && !sendDataPoint.getComplaints().equals(getComplaints())) {
            return false;
        }
        return ((sendDataPoint.getRejects() == null ? 1 : 0) ^ (getRejects() == null ? 1 : 0)) == 0 ? sendDataPoint.getRejects() == null || sendDataPoint.getRejects().equals(getRejects()) : false;
    }

    public Long getBounces() {
        return this.bounces;
    }

    public Long getComplaints() {
        return this.complaints;
    }

    public Long getDeliveryAttempts() {
        return this.deliveryAttempts;
    }

    public Long getRejects() {
        return this.rejects;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getComplaints() == null ? 0 : getComplaints().hashCode()) + (((getBounces() == null ? 0 : getBounces().hashCode()) + (((getDeliveryAttempts() == null ? 0 : getDeliveryAttempts().hashCode()) + (((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getRejects() != null) {
            i = getRejects().hashCode();
        }
        return hashCode + i;
    }

    public void setBounces(Long l) {
        this.bounces = l;
    }

    public void setComplaints(Long l) {
        this.complaints = l;
    }

    public void setDeliveryAttempts(Long l) {
        this.deliveryAttempts = l;
    }

    public void setRejects(Long l) {
        this.rejects = l;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.deliveryAttempts != null) {
            stringBuilder.append("DeliveryAttempts: " + this.deliveryAttempts + ", ");
        }
        if (this.bounces != null) {
            stringBuilder.append("Bounces: " + this.bounces + ", ");
        }
        if (this.complaints != null) {
            stringBuilder.append("Complaints: " + this.complaints + ", ");
        }
        if (this.rejects != null) {
            stringBuilder.append("Rejects: " + this.rejects + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SendDataPoint withBounces(Long l) {
        this.bounces = l;
        return this;
    }

    public SendDataPoint withComplaints(Long l) {
        this.complaints = l;
        return this;
    }

    public SendDataPoint withDeliveryAttempts(Long l) {
        this.deliveryAttempts = l;
        return this;
    }

    public SendDataPoint withRejects(Long l) {
        this.rejects = l;
        return this;
    }

    public SendDataPoint withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }
}
