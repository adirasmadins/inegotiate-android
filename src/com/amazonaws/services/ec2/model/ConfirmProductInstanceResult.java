package com.amazonaws.services.ec2.model;

public class ConfirmProductInstanceResult {
    private String ownerId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmProductInstanceResult)) {
            return false;
        }
        ConfirmProductInstanceResult confirmProductInstanceResult = (ConfirmProductInstanceResult) obj;
        return ((confirmProductInstanceResult.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) == 0 ? confirmProductInstanceResult.getOwnerId() == null || confirmProductInstanceResult.getOwnerId().equals(getOwnerId()) : false;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public int hashCode() {
        return (getOwnerId() == null ? 0 : getOwnerId().hashCode()) + 31;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConfirmProductInstanceResult withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }
}
