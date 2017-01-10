package com.amazonaws.services.ec2.model;

public class PurchaseReservedInstancesOfferingResult {
    private String reservedInstancesId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PurchaseReservedInstancesOfferingResult)) {
            return false;
        }
        PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOfferingResult = (PurchaseReservedInstancesOfferingResult) obj;
        return ((purchaseReservedInstancesOfferingResult.getReservedInstancesId() == null ? 1 : 0) ^ (getReservedInstancesId() == null ? 1 : 0)) == 0 ? purchaseReservedInstancesOfferingResult.getReservedInstancesId() == null || purchaseReservedInstancesOfferingResult.getReservedInstancesId().equals(getReservedInstancesId()) : false;
    }

    public String getReservedInstancesId() {
        return this.reservedInstancesId;
    }

    public int hashCode() {
        return (getReservedInstancesId() == null ? 0 : getReservedInstancesId().hashCode()) + 31;
    }

    public void setReservedInstancesId(String str) {
        this.reservedInstancesId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesId != null) {
            stringBuilder.append("ReservedInstancesId: " + this.reservedInstancesId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PurchaseReservedInstancesOfferingResult withReservedInstancesId(String str) {
        this.reservedInstancesId = str;
        return this;
    }
}
