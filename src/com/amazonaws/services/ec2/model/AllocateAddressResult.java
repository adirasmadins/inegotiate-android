package com.amazonaws.services.ec2.model;

public class AllocateAddressResult {
    private String allocationId;
    private String domain;
    private String publicIp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AllocateAddressResult)) {
            return false;
        }
        AllocateAddressResult allocateAddressResult = (AllocateAddressResult) obj;
        if (((allocateAddressResult.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (allocateAddressResult.getPublicIp() != null && !allocateAddressResult.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        if (((allocateAddressResult.getDomain() == null ? 1 : 0) ^ (getDomain() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (allocateAddressResult.getDomain() != null && !allocateAddressResult.getDomain().equals(getDomain())) {
            return false;
        }
        return ((allocateAddressResult.getAllocationId() == null ? 1 : 0) ^ (getAllocationId() == null ? 1 : 0)) == 0 ? allocateAddressResult.getAllocationId() == null || allocateAddressResult.getAllocationId().equals(getAllocationId()) : false;
    }

    public String getAllocationId() {
        return this.allocationId;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDomain() == null ? 0 : getDomain().hashCode()) + (((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + 31) * 31)) * 31;
        if (getAllocationId() != null) {
            i = getAllocationId().hashCode();
        }
        return hashCode + i;
    }

    public void setAllocationId(String str) {
        this.allocationId = str;
    }

    public void setDomain(DomainType domainType) {
        this.domain = domainType.toString();
    }

    public void setDomain(String str) {
        this.domain = str;
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
        if (this.domain != null) {
            stringBuilder.append("Domain: " + this.domain + ", ");
        }
        if (this.allocationId != null) {
            stringBuilder.append("AllocationId: " + this.allocationId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AllocateAddressResult withAllocationId(String str) {
        this.allocationId = str;
        return this;
    }

    public AllocateAddressResult withDomain(DomainType domainType) {
        this.domain = domainType.toString();
        return this;
    }

    public AllocateAddressResult withDomain(String str) {
        this.domain = str;
        return this;
    }

    public AllocateAddressResult withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
