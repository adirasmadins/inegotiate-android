package com.amazonaws.services.ec2.model;

public class SpotDatafeedSubscription {
    private String bucket;
    private SpotInstanceStateFault fault;
    private String ownerId;
    private String prefix;
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SpotDatafeedSubscription)) {
            return false;
        }
        SpotDatafeedSubscription spotDatafeedSubscription = (SpotDatafeedSubscription) obj;
        if (((spotDatafeedSubscription.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotDatafeedSubscription.getOwnerId() != null && !spotDatafeedSubscription.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((spotDatafeedSubscription.getBucket() == null ? 1 : 0) ^ (getBucket() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotDatafeedSubscription.getBucket() != null && !spotDatafeedSubscription.getBucket().equals(getBucket())) {
            return false;
        }
        if (((spotDatafeedSubscription.getPrefix() == null ? 1 : 0) ^ (getPrefix() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotDatafeedSubscription.getPrefix() != null && !spotDatafeedSubscription.getPrefix().equals(getPrefix())) {
            return false;
        }
        if (((spotDatafeedSubscription.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotDatafeedSubscription.getState() != null && !spotDatafeedSubscription.getState().equals(getState())) {
            return false;
        }
        return ((spotDatafeedSubscription.getFault() == null ? 1 : 0) ^ (getFault() == null ? 1 : 0)) == 0 ? spotDatafeedSubscription.getFault() == null || spotDatafeedSubscription.getFault().equals(getFault()) : false;
    }

    public String getBucket() {
        return this.bucket;
    }

    public SpotInstanceStateFault getFault() {
        return this.fault;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getState() == null ? 0 : getState().hashCode()) + (((getPrefix() == null ? 0 : getPrefix().hashCode()) + (((getBucket() == null ? 0 : getBucket().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getFault() != null) {
            i = getFault().hashCode();
        }
        return hashCode + i;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setFault(SpotInstanceStateFault spotInstanceStateFault) {
        this.fault = spotInstanceStateFault;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.bucket != null) {
            stringBuilder.append("Bucket: " + this.bucket + ", ");
        }
        if (this.prefix != null) {
            stringBuilder.append("Prefix: " + this.prefix + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.fault != null) {
            stringBuilder.append("Fault: " + this.fault + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SpotDatafeedSubscription withBucket(String str) {
        this.bucket = str;
        return this;
    }

    public SpotDatafeedSubscription withFault(SpotInstanceStateFault spotInstanceStateFault) {
        this.fault = spotInstanceStateFault;
        return this;
    }

    public SpotDatafeedSubscription withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public SpotDatafeedSubscription withPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public SpotDatafeedSubscription withState(String str) {
        this.state = str;
        return this;
    }
}
