package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ReleaseAddressRequest extends AmazonWebServiceRequest {
    private String allocationId;
    private String publicIp;

    public ReleaseAddressRequest(String str) {
        this.publicIp = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReleaseAddressRequest)) {
            return false;
        }
        ReleaseAddressRequest releaseAddressRequest = (ReleaseAddressRequest) obj;
        if (((releaseAddressRequest.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (releaseAddressRequest.getPublicIp() != null && !releaseAddressRequest.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        return ((releaseAddressRequest.getAllocationId() == null ? 1 : 0) ^ (getAllocationId() == null ? 1 : 0)) == 0 ? releaseAddressRequest.getAllocationId() == null || releaseAddressRequest.getAllocationId().equals(getAllocationId()) : false;
    }

    public String getAllocationId() {
        return this.allocationId;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + 31) * 31;
        if (getAllocationId() != null) {
            i = getAllocationId().hashCode();
        }
        return hashCode + i;
    }

    public void setAllocationId(String str) {
        this.allocationId = str;
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
        if (this.allocationId != null) {
            stringBuilder.append("AllocationId: " + this.allocationId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReleaseAddressRequest withAllocationId(String str) {
        this.allocationId = str;
        return this;
    }

    public ReleaseAddressRequest withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
