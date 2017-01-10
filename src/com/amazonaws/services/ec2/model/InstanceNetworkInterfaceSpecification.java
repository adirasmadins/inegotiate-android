package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstanceNetworkInterfaceSpecification {
    private Boolean deleteOnTermination;
    private String description;
    private Integer deviceIndex;
    private List<String> groups;
    private String networkInterfaceId;
    private String privateIpAddress;
    private List<PrivateIpAddressSpecification> privateIpAddresses;
    private Integer secondaryPrivateIpAddressCount;
    private String subnetId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterfaceSpecification)) {
            return false;
        }
        InstanceNetworkInterfaceSpecification instanceNetworkInterfaceSpecification = (InstanceNetworkInterfaceSpecification) obj;
        if (((instanceNetworkInterfaceSpecification.getNetworkInterfaceId() == null ? 1 : 0) ^ (getNetworkInterfaceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getNetworkInterfaceId() != null && !instanceNetworkInterfaceSpecification.getNetworkInterfaceId().equals(getNetworkInterfaceId())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getDeviceIndex() == null ? 1 : 0) ^ (getDeviceIndex() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getDeviceIndex() != null && !instanceNetworkInterfaceSpecification.getDeviceIndex().equals(getDeviceIndex())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getSubnetId() != null && !instanceNetworkInterfaceSpecification.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getDescription() != null && !instanceNetworkInterfaceSpecification.getDescription().equals(getDescription())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getPrivateIpAddress() != null && !instanceNetworkInterfaceSpecification.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getGroups() == null ? 1 : 0) ^ (getGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getGroups() != null && !instanceNetworkInterfaceSpecification.getGroups().equals(getGroups())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.isDeleteOnTermination() == null ? 1 : 0) ^ (isDeleteOnTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.isDeleteOnTermination() != null && !instanceNetworkInterfaceSpecification.isDeleteOnTermination().equals(isDeleteOnTermination())) {
            return false;
        }
        if (((instanceNetworkInterfaceSpecification.getPrivateIpAddresses() == null ? 1 : 0) ^ (getPrivateIpAddresses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceNetworkInterfaceSpecification.getPrivateIpAddresses() != null && !instanceNetworkInterfaceSpecification.getPrivateIpAddresses().equals(getPrivateIpAddresses())) {
            return false;
        }
        return ((instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount() == null ? 1 : 0) ^ (getSecondaryPrivateIpAddressCount() == null ? 1 : 0)) == 0 ? instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount() == null || instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount().equals(getSecondaryPrivateIpAddressCount()) : false;
    }

    public Boolean getDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getDeviceIndex() {
        return this.deviceIndex;
    }

    public List<String> getGroups() {
        if (this.groups == null) {
            this.groups = new ArrayList();
        }
        return this.groups;
    }

    public String getNetworkInterfaceId() {
        return this.networkInterfaceId;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public List<PrivateIpAddressSpecification> getPrivateIpAddresses() {
        if (this.privateIpAddresses == null) {
            this.privateIpAddresses = new ArrayList();
        }
        return this.privateIpAddresses;
    }

    public Integer getSecondaryPrivateIpAddressCount() {
        return this.secondaryPrivateIpAddressCount;
    }

    public String getSubnetId() {
        return this.subnetId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPrivateIpAddresses() == null ? 0 : getPrivateIpAddresses().hashCode()) + (((isDeleteOnTermination() == null ? 0 : isDeleteOnTermination().hashCode()) + (((getGroups() == null ? 0 : getGroups().hashCode()) + (((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((getDeviceIndex() == null ? 0 : getDeviceIndex().hashCode()) + (((getNetworkInterfaceId() == null ? 0 : getNetworkInterfaceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getSecondaryPrivateIpAddressCount() != null) {
            i = getSecondaryPrivateIpAddressCount().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDeleteOnTermination() {
        return this.deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDeviceIndex(Integer num) {
        this.deviceIndex = num;
    }

    public void setGroups(Collection<String> collection) {
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

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public void setPrivateIpAddresses(Collection<PrivateIpAddressSpecification> collection) {
        if (collection == null) {
            this.privateIpAddresses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.privateIpAddresses = arrayList;
    }

    public void setSecondaryPrivateIpAddressCount(Integer num) {
        this.secondaryPrivateIpAddressCount = num;
    }

    public void setSubnetId(String str) {
        this.subnetId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.networkInterfaceId != null) {
            stringBuilder.append("NetworkInterfaceId: " + this.networkInterfaceId + ", ");
        }
        if (this.deviceIndex != null) {
            stringBuilder.append("DeviceIndex: " + this.deviceIndex + ", ");
        }
        if (this.subnetId != null) {
            stringBuilder.append("SubnetId: " + this.subnetId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.groups != null) {
            stringBuilder.append("Groups: " + this.groups + ", ");
        }
        if (this.deleteOnTermination != null) {
            stringBuilder.append("DeleteOnTermination: " + this.deleteOnTermination + ", ");
        }
        if (this.privateIpAddresses != null) {
            stringBuilder.append("PrivateIpAddresses: " + this.privateIpAddresses + ", ");
        }
        if (this.secondaryPrivateIpAddressCount != null) {
            stringBuilder.append("SecondaryPrivateIpAddressCount: " + this.secondaryPrivateIpAddressCount + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceNetworkInterfaceSpecification withDeleteOnTermination(Boolean bool) {
        this.deleteOnTermination = bool;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withDescription(String str) {
        this.description = str;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withDeviceIndex(Integer num) {
        this.deviceIndex = num;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withGroups(Collection<String> collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groups = arrayList;
        }
        return this;
    }

    public InstanceNetworkInterfaceSpecification withGroups(String... strArr) {
        if (getGroups() == null) {
            setGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroups().add(add);
        }
        return this;
    }

    public InstanceNetworkInterfaceSpecification withNetworkInterfaceId(String str) {
        this.networkInterfaceId = str;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withPrivateIpAddresses(Collection<PrivateIpAddressSpecification> collection) {
        if (collection == null) {
            this.privateIpAddresses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.privateIpAddresses = arrayList;
        }
        return this;
    }

    public InstanceNetworkInterfaceSpecification withPrivateIpAddresses(PrivateIpAddressSpecification... privateIpAddressSpecificationArr) {
        if (getPrivateIpAddresses() == null) {
            setPrivateIpAddresses(new ArrayList(privateIpAddressSpecificationArr.length));
        }
        for (Object add : privateIpAddressSpecificationArr) {
            getPrivateIpAddresses().add(add);
        }
        return this;
    }

    public InstanceNetworkInterfaceSpecification withSecondaryPrivateIpAddressCount(Integer num) {
        this.secondaryPrivateIpAddressCount = num;
        return this;
    }

    public InstanceNetworkInterfaceSpecification withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }
}
