package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class AssociateAddressRequest extends AmazonWebServiceRequest {
    private String allocationId;
    private Boolean allowReassociation;
    private String instanceId;
    private String networkInterfaceId;
    private String privateIpAddress;
    private String publicIp;

    public AssociateAddressRequest(String str, String str2) {
        this.instanceId = str;
        this.publicIp = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateAddressRequest)) {
            return false;
        }
        AssociateAddressRequest associateAddressRequest = (AssociateAddressRequest) obj;
        if (((associateAddressRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (associateAddressRequest.getInstanceId() != null && !associateAddressRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((associateAddressRequest.getPublicIp() == null ? 1 : 0) ^ (getPublicIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (associateAddressRequest.getPublicIp() != null && !associateAddressRequest.getPublicIp().equals(getPublicIp())) {
            return false;
        }
        if (((associateAddressRequest.getAllocationId() == null ? 1 : 0) ^ (getAllocationId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (associateAddressRequest.getAllocationId() != null && !associateAddressRequest.getAllocationId().equals(getAllocationId())) {
            return false;
        }
        if (((associateAddressRequest.getNetworkInterfaceId() == null ? 1 : 0) ^ (getNetworkInterfaceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (associateAddressRequest.getNetworkInterfaceId() != null && !associateAddressRequest.getNetworkInterfaceId().equals(getNetworkInterfaceId())) {
            return false;
        }
        if (((associateAddressRequest.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (associateAddressRequest.getPrivateIpAddress() != null && !associateAddressRequest.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        return ((associateAddressRequest.isAllowReassociation() == null ? 1 : 0) ^ (isAllowReassociation() == null ? 1 : 0)) == 0 ? associateAddressRequest.isAllowReassociation() == null || associateAddressRequest.isAllowReassociation().equals(isAllowReassociation()) : false;
    }

    public String getAllocationId() {
        return this.allocationId;
    }

    public Boolean getAllowReassociation() {
        return this.allowReassociation;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getNetworkInterfaceId() {
        return this.networkInterfaceId;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public String getPublicIp() {
        return this.publicIp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + (((getNetworkInterfaceId() == null ? 0 : getNetworkInterfaceId().hashCode()) + (((getAllocationId() == null ? 0 : getAllocationId().hashCode()) + (((getPublicIp() == null ? 0 : getPublicIp().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (isAllowReassociation() != null) {
            i = isAllowReassociation().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isAllowReassociation() {
        return this.allowReassociation;
    }

    public void setAllocationId(String str) {
        this.allocationId = str;
    }

    public void setAllowReassociation(Boolean bool) {
        this.allowReassociation = bool;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
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
        if (this.networkInterfaceId != null) {
            stringBuilder.append("NetworkInterfaceId: " + this.networkInterfaceId + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.allowReassociation != null) {
            stringBuilder.append("AllowReassociation: " + this.allowReassociation + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AssociateAddressRequest withAllocationId(String str) {
        this.allocationId = str;
        return this;
    }

    public AssociateAddressRequest withAllowReassociation(Boolean bool) {
        this.allowReassociation = bool;
        return this;
    }

    public AssociateAddressRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public AssociateAddressRequest withNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
        return this;
    }

    public AssociateAddressRequest withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public AssociateAddressRequest withPublicIp(String str) {
        this.publicIp = str;
        return this;
    }
}
