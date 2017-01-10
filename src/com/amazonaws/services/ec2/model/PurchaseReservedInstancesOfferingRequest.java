package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class PurchaseReservedInstancesOfferingRequest extends AmazonWebServiceRequest {
    private Integer instanceCount;
    private ReservedInstanceLimitPrice limitPrice;
    private String reservedInstancesOfferingId;

    public PurchaseReservedInstancesOfferingRequest(String str, Integer num) {
        this.reservedInstancesOfferingId = str;
        this.instanceCount = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PurchaseReservedInstancesOfferingRequest)) {
            return false;
        }
        PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest = (PurchaseReservedInstancesOfferingRequest) obj;
        if (((purchaseReservedInstancesOfferingRequest.getReservedInstancesOfferingId() == null ? 1 : 0) ^ (getReservedInstancesOfferingId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (purchaseReservedInstancesOfferingRequest.getReservedInstancesOfferingId() != null && !purchaseReservedInstancesOfferingRequest.getReservedInstancesOfferingId().equals(getReservedInstancesOfferingId())) {
            return false;
        }
        if (((purchaseReservedInstancesOfferingRequest.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (purchaseReservedInstancesOfferingRequest.getInstanceCount() != null && !purchaseReservedInstancesOfferingRequest.getInstanceCount().equals(getInstanceCount())) {
            return false;
        }
        return ((purchaseReservedInstancesOfferingRequest.getLimitPrice() == null ? 1 : 0) ^ (getLimitPrice() == null ? 1 : 0)) == 0 ? purchaseReservedInstancesOfferingRequest.getLimitPrice() == null || purchaseReservedInstancesOfferingRequest.getLimitPrice().equals(getLimitPrice()) : false;
    }

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public ReservedInstanceLimitPrice getLimitPrice() {
        return this.limitPrice;
    }

    public String getReservedInstancesOfferingId() {
        return this.reservedInstancesOfferingId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceCount() == null ? 0 : getInstanceCount().hashCode()) + (((getReservedInstancesOfferingId() == null ? 0 : getReservedInstancesOfferingId().hashCode()) + 31) * 31)) * 31;
        if (getLimitPrice() != null) {
            i = getLimitPrice().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceCount(Integer num) {
        this.instanceCount = num;
    }

    public void setLimitPrice(ReservedInstanceLimitPrice reservedInstanceLimitPrice) {
        this.limitPrice = reservedInstanceLimitPrice;
    }

    public void setReservedInstancesOfferingId(String str) {
        this.reservedInstancesOfferingId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesOfferingId != null) {
            stringBuilder.append("ReservedInstancesOfferingId: " + this.reservedInstancesOfferingId + ", ");
        }
        if (this.instanceCount != null) {
            stringBuilder.append("InstanceCount: " + this.instanceCount + ", ");
        }
        if (this.limitPrice != null) {
            stringBuilder.append("LimitPrice: " + this.limitPrice + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PurchaseReservedInstancesOfferingRequest withInstanceCount(Integer num) {
        this.instanceCount = num;
        return this;
    }

    public PurchaseReservedInstancesOfferingRequest withLimitPrice(ReservedInstanceLimitPrice reservedInstanceLimitPrice) {
        this.limitPrice = reservedInstanceLimitPrice;
        return this;
    }

    public PurchaseReservedInstancesOfferingRequest withReservedInstancesOfferingId(String str) {
        this.reservedInstancesOfferingId = str;
        return this;
    }
}
