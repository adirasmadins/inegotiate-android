package com.amazonaws.services.ec2.model;

public class CancelledSpotInstanceRequest {
    private String spotInstanceRequestId;
    private String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelledSpotInstanceRequest)) {
            return false;
        }
        CancelledSpotInstanceRequest cancelledSpotInstanceRequest = (CancelledSpotInstanceRequest) obj;
        if (((cancelledSpotInstanceRequest.getSpotInstanceRequestId() == null ? 1 : 0) ^ (getSpotInstanceRequestId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (cancelledSpotInstanceRequest.getSpotInstanceRequestId() != null && !cancelledSpotInstanceRequest.getSpotInstanceRequestId().equals(getSpotInstanceRequestId())) {
            return false;
        }
        return ((cancelledSpotInstanceRequest.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) == 0 ? cancelledSpotInstanceRequest.getState() == null || cancelledSpotInstanceRequest.getState().equals(getState()) : false;
    }

    public String getSpotInstanceRequestId() {
        return this.spotInstanceRequestId;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSpotInstanceRequestId() == null ? 0 : getSpotInstanceRequestId().hashCode()) + 31) * 31;
        if (getState() != null) {
            i = getState().hashCode();
        }
        return hashCode + i;
    }

    public void setSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotInstanceRequestId != null) {
            stringBuilder.append("SpotInstanceRequestId: " + this.spotInstanceRequestId + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelledSpotInstanceRequest withSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
        return this;
    }

    public CancelledSpotInstanceRequest withState(String str) {
        this.state = str;
        return this;
    }
}
