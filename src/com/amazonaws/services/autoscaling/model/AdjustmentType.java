package com.amazonaws.services.autoscaling.model;

public class AdjustmentType {
    private String adjustmentType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdjustmentType)) {
            return false;
        }
        AdjustmentType adjustmentType = (AdjustmentType) obj;
        return ((adjustmentType.getAdjustmentType() == null ? 1 : 0) ^ (getAdjustmentType() == null ? 1 : 0)) == 0 ? adjustmentType.getAdjustmentType() == null || adjustmentType.getAdjustmentType().equals(getAdjustmentType()) : false;
    }

    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    public int hashCode() {
        return (getAdjustmentType() == null ? 0 : getAdjustmentType().hashCode()) + 31;
    }

    public void setAdjustmentType(String str) {
        this.adjustmentType = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.adjustmentType != null) {
            stringBuilder.append("AdjustmentType: " + this.adjustmentType + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AdjustmentType withAdjustmentType(String str) {
        this.adjustmentType = str;
        return this;
    }
}
