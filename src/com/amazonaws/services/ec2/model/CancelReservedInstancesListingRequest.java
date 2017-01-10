package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class CancelReservedInstancesListingRequest extends AmazonWebServiceRequest {
    private String reservedInstancesListingId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CancelReservedInstancesListingRequest)) {
            return false;
        }
        CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest = (CancelReservedInstancesListingRequest) obj;
        return ((cancelReservedInstancesListingRequest.getReservedInstancesListingId() == null ? 1 : 0) ^ (getReservedInstancesListingId() == null ? 1 : 0)) == 0 ? cancelReservedInstancesListingRequest.getReservedInstancesListingId() == null || cancelReservedInstancesListingRequest.getReservedInstancesListingId().equals(getReservedInstancesListingId()) : false;
    }

    public String getReservedInstancesListingId() {
        return this.reservedInstancesListingId;
    }

    public int hashCode() {
        return (getReservedInstancesListingId() == null ? 0 : getReservedInstancesListingId().hashCode()) + 31;
    }

    public void setReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesListingId != null) {
            stringBuilder.append("ReservedInstancesListingId: " + this.reservedInstancesListingId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CancelReservedInstancesListingRequest withReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
        return this;
    }
}
