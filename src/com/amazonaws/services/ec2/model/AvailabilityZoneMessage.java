package com.amazonaws.services.ec2.model;

public class AvailabilityZoneMessage {
    private String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AvailabilityZoneMessage)) {
            return false;
        }
        AvailabilityZoneMessage availabilityZoneMessage = (AvailabilityZoneMessage) obj;
        return ((availabilityZoneMessage.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) == 0 ? availabilityZoneMessage.getMessage() == null || availabilityZoneMessage.getMessage().equals(getMessage()) : false;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (getMessage() == null ? 0 : getMessage().hashCode()) + 31;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.message != null) {
            stringBuilder.append("Message: " + this.message + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AvailabilityZoneMessage withMessage(String str) {
        this.message = str;
        return this;
    }
}
