package com.amazonaws.services.ec2.model;

public class AssociateAddressResult {
    private String associationId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateAddressResult)) {
            return false;
        }
        AssociateAddressResult associateAddressResult = (AssociateAddressResult) obj;
        return ((associateAddressResult.getAssociationId() == null ? 1 : 0) ^ (getAssociationId() == null ? 1 : 0)) == 0 ? associateAddressResult.getAssociationId() == null || associateAddressResult.getAssociationId().equals(getAssociationId()) : false;
    }

    public String getAssociationId() {
        return this.associationId;
    }

    public int hashCode() {
        return (getAssociationId() == null ? 0 : getAssociationId().hashCode()) + 31;
    }

    public void setAssociationId(String str) {
        this.associationId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.associationId != null) {
            stringBuilder.append("AssociationId: " + this.associationId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AssociateAddressResult withAssociationId(String str) {
        this.associationId = str;
        return this;
    }
}
