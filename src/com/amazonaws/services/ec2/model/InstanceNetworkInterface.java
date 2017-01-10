package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstanceNetworkInterface {
    private InstanceNetworkInterfaceAssociation association;
    private InstanceNetworkInterfaceAttachment attachment;
    private String description;
    private List<GroupIdentifier> groups;
    private String networkInterfaceId;
    private String ownerId;
    private String privateDnsName;
    private String privateIpAddress;
    private Boolean sourceDestCheck;
    private String status;
    private String subnetId;
    private String vpcId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterface)) {
            return false;
        }
        InstanceNetworkInterface instanceNetworkInterface = (InstanceNetworkInterface) obj;
        if (((instanceNetworkInterface.getNetworkInterfaceId() == null ? 1 : 0) ^ (getNetworkInterfaceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getNetworkInterfaceId() != null && !instanceNetworkInterface.getNetworkInterfaceId().equals(getNetworkInterfaceId())) {
            return false;
        }
        if (((instanceNetworkInterface.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getSubnetId() != null && !instanceNetworkInterface.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((instanceNetworkInterface.getVpcId() == null ? 1 : 0) ^ (getVpcId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getVpcId() != null && !instanceNetworkInterface.getVpcId().equals(getVpcId())) {
            return false;
        }
        if (((instanceNetworkInterface.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getDescription() != null && !instanceNetworkInterface.getDescription().equals(getDescription())) {
            return false;
        }
        if (((instanceNetworkInterface.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getOwnerId() != null && !instanceNetworkInterface.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((instanceNetworkInterface.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getStatus() != null && !instanceNetworkInterface.getStatus().equals(getStatus())) {
            return false;
        }
        if (((instanceNetworkInterface.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getPrivateIpAddress() != null && !instanceNetworkInterface.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        if (((instanceNetworkInterface.getPrivateDnsName() == null ? 1 : 0) ^ (getPrivateDnsName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getPrivateDnsName() != null && !instanceNetworkInterface.getPrivateDnsName().equals(getPrivateDnsName())) {
            return false;
        }
        if (((instanceNetworkInterface.isSourceDestCheck() == null ? 1 : 0) ^ (isSourceDestCheck() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.isSourceDestCheck() != null && !instanceNetworkInterface.isSourceDestCheck().equals(isSourceDestCheck())) {
            return false;
        }
        if (((instanceNetworkInterface.getGroups() == null ? 1 : 0) ^ (getGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getGroups() != null && !instanceNetworkInterface.getGroups().equals(getGroups())) {
            return false;
        }
        if (((instanceNetworkInterface.getAttachment() == null ? 1 : 0) ^ (getAttachment() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterface.getAttachment() != null && !instanceNetworkInterface.getAttachment().equals(getAttachment())) {
            return false;
        }
        return ((instanceNetworkInterface.getAssociation() == null ? 1 : 0) ^ (getAssociation() == null ? 1 : 0)) == 0 ? instanceNetworkInterface.getAssociation() == null || instanceNetworkInterface.getAssociation().equals(getAssociation()) : false;
    }

    public InstanceNetworkInterfaceAssociation getAssociation() {
        return this.association;
    }

    public InstanceNetworkInterfaceAttachment getAttachment() {
        return this.attachment;
    }

    public String getDescription() {
        return this.description;
    }

    public List<GroupIdentifier> getGroups() {
        if (this.groups == null) {
            this.groups = new ArrayList();
        }
        return this.groups;
    }

    public String getNetworkInterfaceId() {
        return this.networkInterfaceId;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPrivateDnsName() {
        return this.privateDnsName;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public Boolean getSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSubnetId() {
        return this.subnetId;
    }

    public String getVpcId() {
        return this.vpcId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttachment() == null ? 0 : getAttachment().hashCode()) + (((getGroups() == null ? 0 : getGroups().hashCode()) + (((isSourceDestCheck() == null ? 0 : isSourceDestCheck().hashCode()) + (((getPrivateDnsName() == null ? 0 : getPrivateDnsName().hashCode()) + (((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getVpcId() == null ? 0 : getVpcId().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((getNetworkInterfaceId() == null ? 0 : getNetworkInterfaceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getAssociation() != null) {
            i = getAssociation().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public void setAssociation(InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation) {
        this.association = instanceNetworkInterfaceAssociation;
    }

    public void setAttachment(InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment) {
        this.attachment = instanceNetworkInterfaceAttachment;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.groups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groups = arrayList;
    }

    public void setNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPrivateDnsName(String str) {
        this.privateDnsName = str;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public void setSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSubnetId(String str) {
        this.subnetId = str;
    }

    public void setVpcId(String str) {
        this.vpcId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.networkInterfaceId != null) {
            stringBuilder.append("NetworkInterfaceId: " + this.networkInterfaceId + ", ");
        }
        if (this.subnetId != null) {
            stringBuilder.append("SubnetId: " + this.subnetId + ", ");
        }
        if (this.vpcId != null) {
            stringBuilder.append("VpcId: " + this.vpcId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.privateDnsName != null) {
            stringBuilder.append("PrivateDnsName: " + this.privateDnsName + ", ");
        }
        if (this.sourceDestCheck != null) {
            stringBuilder.append("SourceDestCheck: " + this.sourceDestCheck + ", ");
        }
        if (this.groups != null) {
            stringBuilder.append("Groups: " + this.groups + ", ");
        }
        if (this.attachment != null) {
            stringBuilder.append("Attachment: " + this.attachment + ", ");
        }
        if (this.association != null) {
            stringBuilder.append("Association: " + this.association + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceNetworkInterface withAssociation(InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation) {
        this.association = instanceNetworkInterfaceAssociation;
        return this;
    }

    public InstanceNetworkInterface withAttachment(InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment) {
        this.attachment = instanceNetworkInterfaceAttachment;
        return this;
    }

    public InstanceNetworkInterface withDescription(String str) {
        this.description = str;
        return this;
    }

    public InstanceNetworkInterface withGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groups = arrayList;
        }
        return this;
    }

    public InstanceNetworkInterface withGroups(GroupIdentifier... groupIdentifierArr) {
        if (getGroups() == null) {
            setGroups(new ArrayList(groupIdentifierArr.length));
        }
        for (Object add : groupIdentifierArr) {
            getGroups().add(add);
        }
        return this;
    }

    public InstanceNetworkInterface withNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
        return this;
    }

    public InstanceNetworkInterface withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public InstanceNetworkInterface withPrivateDnsName(String str) {
        this.privateDnsName = str;
        return this;
    }

    public InstanceNetworkInterface withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public InstanceNetworkInterface withSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
        return this;
    }

    public InstanceNetworkInterface withStatus(String str) {
        this.status = str;
        return this;
    }

    public InstanceNetworkInterface withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }

    public InstanceNetworkInterface withVpcId(String str) {
        this.vpcId = str;
        return this;
    }
}
