package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DisassociateAddressRequest extends AmazonWebServiceRequest {
    private String associationId;
    private String publicIp;

    public DisassociateAddressRequest(String str) {
        this.publicIp = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DisassociateAddressRequest)) {
            return false;
        }
        DisassociateAddressRequest disassociateAddressRequest = (DisassociateAddressRequest) obj;
        if (((disassociateAddressRequest.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (disassociateAddressRequest.getPublicIp() != null && !disassociateAddressRequest.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        return ((disassociateAddressRequest.getAssociationId() == null ? 1 : 0) ^ (getAssociationId() == null ? 1 : 0)) == 0 ? disassociateAddressRequest.getAssociationId() == null || disassociateAddressRequest.getAssociationId().equals(getAssociationId()) : false;
    }

    public String getAssociationId() {
        return this.associationId;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + 31) * 31;
        if (getAssociationId() != null) {
            i = getAssociationId().hashCode();
        }
        return hashCode + i;
    }

    public void setAssociationId(String str) {
        this.associationId = str;
    }

    public void setPublicIp(String str) {
        this.publicIp = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.publicIp != null) {
            stringBuilder.append("PublicIp: " + this.publicIp + ", ");
        }
        if (this.associationId != null) {
            stringBuilder.append("AssociationId: " + this.associationId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DisassociateAddressRequest withAssociationId(String str) {
        this.associationId = str;
        return this;
    }

    public DisassociateAddressRequest withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
