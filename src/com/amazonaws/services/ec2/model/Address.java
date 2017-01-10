package com.amazonaws.services.ec2.model;

public class Address {
    private String allocationId;
    private String associationId;
    private String domain;
    private String instanceId;
    private String networkInterfaceId;
    private String networkInterfaceOwnerId;
    private String privateIpAddress;
    private String publicIp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (((address.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getInstanceId() != null && !address.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((address.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getPublicIp() != null && !address.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        if (((address.getAllocationId() == null ? 1 : 0) ^ (getAllocationId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getAllocationId() != null && !address.getAllocationId().equals(getAllocationId())) {
            return false;
        }
        if (((address.getAssociationId() == null ? 1 : 0) ^ (getAssociationId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getAssociationId() != null && !address.getAssociationId().equals(getAssociationId())) {
            return false;
        }
        if (((address.getDomain() == null ? 1 : 0) ^ (getDomain() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getDomain() != null && !address.getDomain().equals(getDomain())) {
            return false;
        }
        if (((address.getNetworkInterfaceId() == null ? 1 : 0) ^ (getNetworkInterfaceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getNetworkInterfaceId() != null && !address.getNetworkInterfaceId().equals(getNetworkInterfaceId())) {
            return false;
        }
        if (((address.getNetworkInterfaceOwnerId() == null ? 1 : 0) ^ (getNetworkInterfaceOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (address.getNetworkInterfaceOwnerId() != null && !address.getNetworkInterfaceOwnerId().equals(getNetworkInterfaceOwnerId())) {
            return false;
        }
        return ((address.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) == 0 ? address.getPrivateIpAddress() == null || address.getPrivateIpAddress().equals(getPrivateIpAddress()) : false;
    }

    public String getAllocationId() {
        return this.allocationId;
    }

    public String getAssociationId() {
        return this.associationId;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getNetworkInterfaceId() {
        return this.networkInterfaceId;
    }

    public String getNetworkInterfaceOwnerId() {
        return this.networkInterfaceOwnerId;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNetworkInterfaceOwnerId() == null ? 0 : getNetworkInterfaceOwnerId().hashCode()) + (((getNetworkInterfaceId() == null ? 0 : getNetworkInterfaceId().hashCode()) + (((getDomain() == null ? 0 : getDomain().hashCode()) + (((getAssociationId() == null ? 0 : getAssociationId().hashCode()) + (((getAllocationId() == null ? 0 : getAllocationId().hashCode()) + (((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getPrivateIpAddress() != null) {
            i = getPrivateIpAddress().hashCode();
        }
        return hashCode + i;
    }

    public void setAllocationId(String str) {
        this.allocationId = str;
    }

    public void setAssociationId(String str) {
        this.associationId = str;
    }

    public void setDomain(DomainType domainType) {
        this.domain = domainType.toString();
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
    }

    public void setNetworkInterfaceOwnerId(String str) {
        this.networkInterfaceOwnerId = str;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public void setPublicIp(String str) {
        this.publicIp = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.publicIp != null) {
            stringBuilder.append("PublicIp: " + this.publicIp + ", ");
        }
        if (this.allocationId != null) {
            stringBuilder.append("AllocationId: " + this.allocationId + ", ");
        }
        if (this.associationId != null) {
            stringBuilder.append("AssociationId: " + this.associationId + ", ");
        }
        if (this.domain != null) {
            stringBuilder.append("Domain: " + this.domain + ", ");
        }
        if (this.networkInterfaceId != null) {
            stringBuilder.append("NetworkInterfaceId: " + this.networkInterfaceId + ", ");
        }
        if (this.networkInterfaceOwnerId != null) {
            stringBuilder.append("NetworkInterfaceOwnerId: " + this.networkInterfaceOwnerId + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Address withAllocationId(String str) {
        this.allocationId = str;
        return this;
    }

    public Address withAssociationId(String str) {
        this.associationId = str;
        return this;
    }

    public Address withDomain(DomainType domainType) {
        this.domain = domainType.toString();
        return this;
    }

    public Address withDomain(String str) {
        this.domain = str;
        return this;
    }

    public Address withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public Address withNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
        return this;
    }

    public Address withNetworkInterfaceOwnerId(String str) {
        this.networkInterfaceOwnerId = str;
        return this;
    }

    public Address withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public Address withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
