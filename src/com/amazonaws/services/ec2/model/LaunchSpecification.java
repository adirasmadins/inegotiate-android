package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LaunchSpecification {
    private String addressingType;
    private List<GroupIdentifier> allSecurityGroups;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private Boolean ebsOptimized;
    private IamInstanceProfileSpecification iamInstanceProfile;
    private String imageId;
    private String instanceType;
    private String kernelId;
    private String keyName;
    private Boolean monitoringEnabled;
    private List<InstanceNetworkInterfaceSpecification> networkInterfaces;
    private SpotPlacement placement;
    private String ramdiskId;
    private List<String> securityGroups;
    private String subnetId;
    private String userData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchSpecification)) {
            return false;
        }
        LaunchSpecification launchSpecification = (LaunchSpecification) obj;
        if (((launchSpecification.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getImageId() != null && !launchSpecification.getImageId().equals(getImageId())) {
            return false;
        }
        if (((launchSpecification.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getKeyName() != null && !launchSpecification.getKeyName().equals(getKeyName())) {
            return false;
        }
        if (((launchSpecification.getAllSecurityGroups() == null ? 1 : 0) ^ (getAllSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getAllSecurityGroups() != null && !launchSpecification.getAllSecurityGroups().equals(getAllSecurityGroups())) {
            return false;
        }
        if (((launchSpecification.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getSecurityGroups() != null && !launchSpecification.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((launchSpecification.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getUserData() != null && !launchSpecification.getUserData().equals(getUserData())) {
            return false;
        }
        if (((launchSpecification.getAddressingType() == null ? 1 : 0) ^ (getAddressingType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getAddressingType() != null && !launchSpecification.getAddressingType().equals(getAddressingType())) {
            return false;
        }
        if (((launchSpecification.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getInstanceType() != null && !launchSpecification.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((launchSpecification.getPlacement() == null ? 1 : 0) ^ (getPlacement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getPlacement() != null && !launchSpecification.getPlacement().equals(getPlacement())) {
            return false;
        }
        if (((launchSpecification.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getKernelId() != null && !launchSpecification.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((launchSpecification.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getRamdiskId() != null && !launchSpecification.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((launchSpecification.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getBlockDeviceMappings() != null && !launchSpecification.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((launchSpecification.isMonitoringEnabled() == null ? 1 : 0) ^ (isMonitoringEnabled() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.isMonitoringEnabled() != null && !launchSpecification.isMonitoringEnabled().equals(isMonitoringEnabled())) {
            return false;
        }
        if (((launchSpecification.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getSubnetId() != null && !launchSpecification.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((launchSpecification.getNetworkInterfaces() == null ? 1 : 0) ^ (getNetworkInterfaces() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getNetworkInterfaces() != null && !launchSpecification.getNetworkInterfaces().equals(getNetworkInterfaces())) {
            return false;
        }
        if (((launchSpecification.getIamInstanceProfile() == null ? 1 : 0) ^ (getIamInstanceProfile() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchSpecification.getIamInstanceProfile() != null && !launchSpecification.getIamInstanceProfile().equals(getIamInstanceProfile())) {
            return false;
        }
        return ((launchSpecification.isEbsOptimized() == null ? 1 : 0) ^ (isEbsOptimized() == null ? 1 : 0)) == 0 ? launchSpecification.isEbsOptimized() == null || launchSpecification.isEbsOptimized().equals(isEbsOptimized()) : false;
    }

    public String getAddressingType() {
        return this.addressingType;
    }

    public List<GroupIdentifier> getAllSecurityGroups() {
        if (this.allSecurityGroups == null) {
            this.allSecurityGroups = new ArrayList();
        }
        return this.allSecurityGroups;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public Boolean getEbsOptimized() {
        return this.ebsOptimized;
    }

    public IamInstanceProfileSpecification getIamInstanceProfile() {
        return this.iamInstanceProfile;
    }

    public String getImageId() {
        return this.imageId;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public String getKernelId() {
        return this.kernelId;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public Boolean getMonitoringEnabled() {
        return this.monitoringEnabled;
    }

    public List<InstanceNetworkInterfaceSpecification> getNetworkInterfaces() {
        if (this.networkInterfaces == null) {
            this.networkInterfaces = new ArrayList();
        }
        return this.networkInterfaces;
    }

    public SpotPlacement getPlacement() {
        return this.placement;
    }

    public String getRamdiskId() {
        return this.ramdiskId;
    }

    public List<String> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public String getSubnetId() {
        return this.subnetId;
    }

    public String getUserData() {
        return this.userData;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIamInstanceProfile() == null ? 0 : getIamInstanceProfile().hashCode()) + (((getNetworkInterfaces() == null ? 0 : getNetworkInterfaces().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((isMonitoringEnabled() == null ? 0 : isMonitoringEnabled().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getPlacement() == null ? 0 : getPlacement().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getAddressingType() == null ? 0 : getAddressingType().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getAllSecurityGroups() == null ? 0 : getAllSecurityGroups().hashCode()) + (((getKeyName() == null ? 0 : getKeyName().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (isEbsOptimized() != null) {
            i = isEbsOptimized().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isEbsOptimized() {
        return this.ebsOptimized;
    }

    public Boolean isMonitoringEnabled() {
        return this.monitoringEnabled;
    }

    public void setAddressingType(String str) {
        this.addressingType = str;
    }

    public void setAllSecurityGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.allSecurityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.allSecurityGroups = arrayList;
    }

    public void setBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.blockDeviceMappings = arrayList;
    }

    public void setEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
    }

    public void setIamInstanceProfile(IamInstanceProfileSpecification iamInstanceProfileSpecification) {
        this.iamInstanceProfile = iamInstanceProfileSpecification;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
    }

    public void setInstanceType(String str) {
        this.instanceType = str;
    }

    public void setKernelId(String str) {
        this.kernelId = str;
    }

    public void setKeyName(String str) {
        this.keyName = str;
    }

    public void setMonitoringEnabled(Boolean bool) {
        this.monitoringEnabled = bool;
    }

    public void setNetworkInterfaces(Collection<InstanceNetworkInterfaceSpecification> collection) {
        if (collection == null) {
            this.networkInterfaces = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.networkInterfaces = arrayList;
    }

    public void setPlacement(SpotPlacement spotPlacement) {
        this.placement = spotPlacement;
    }

    public void setRamdiskId(String str) {
        this.ramdiskId = str;
    }

    public void setSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public void setSubnetId(String str) {
        this.subnetId = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        if (this.allSecurityGroups != null) {
            stringBuilder.append("AllSecurityGroups: " + this.allSecurityGroups + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.userData != null) {
            stringBuilder.append("UserData: " + this.userData + ", ");
        }
        if (this.addressingType != null) {
            stringBuilder.append("AddressingType: " + this.addressingType + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.placement != null) {
            stringBuilder.append("Placement: " + this.placement + ", ");
        }
        if (this.kernelId != null) {
            stringBuilder.append("KernelId: " + this.kernelId + ", ");
        }
        if (this.ramdiskId != null) {
            stringBuilder.append("RamdiskId: " + this.ramdiskId + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        if (this.monitoringEnabled != null) {
            stringBuilder.append("MonitoringEnabled: " + this.monitoringEnabled + ", ");
        }
        if (this.subnetId != null) {
            stringBuilder.append("SubnetId: " + this.subnetId + ", ");
        }
        if (this.networkInterfaces != null) {
            stringBuilder.append("NetworkInterfaces: " + this.networkInterfaces + ", ");
        }
        if (this.iamInstanceProfile != null) {
            stringBuilder.append("IamInstanceProfile: " + this.iamInstanceProfile + ", ");
        }
        if (this.ebsOptimized != null) {
            stringBuilder.append("EbsOptimized: " + this.ebsOptimized + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LaunchSpecification withAddressingType(String str) {
        this.addressingType = str;
        return this;
    }

    public LaunchSpecification withAllSecurityGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.allSecurityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.allSecurityGroups = arrayList;
        }
        return this;
    }

    public LaunchSpecification withAllSecurityGroups(GroupIdentifier... groupIdentifierArr) {
        if (getAllSecurityGroups() == null) {
            setAllSecurityGroups(new ArrayList(groupIdentifierArr.length));
        }
        for (Object add : groupIdentifierArr) {
            getAllSecurityGroups().add(add);
        }
        return this;
    }

    public LaunchSpecification withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public LaunchSpecification withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public LaunchSpecification withEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
        return this;
    }

    public LaunchSpecification withIamInstanceProfile(IamInstanceProfileSpecification iamInstanceProfileSpecification) {
        this.iamInstanceProfile = iamInstanceProfileSpecification;
        return this;
    }

    public LaunchSpecification withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public LaunchSpecification withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public LaunchSpecification withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public LaunchSpecification withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public LaunchSpecification withKeyName(String str) {
        this.keyName = str;
        return this;
    }

    public LaunchSpecification withMonitoringEnabled(Boolean bool) {
        this.monitoringEnabled = bool;
        return this;
    }

    public LaunchSpecification withNetworkInterfaces(Collection<InstanceNetworkInterfaceSpecification> collection) {
        if (collection == null) {
            this.networkInterfaces = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.networkInterfaces = arrayList;
        }
        return this;
    }

    public LaunchSpecification withNetworkInterfaces(InstanceNetworkInterfaceSpecification... instanceNetworkInterfaceSpecificationArr) {
        if (getNetworkInterfaces() == null) {
            setNetworkInterfaces(new ArrayList(instanceNetworkInterfaceSpecificationArr.length));
        }
        for (Object add : instanceNetworkInterfaceSpecificationArr) {
            getNetworkInterfaces().add(add);
        }
        return this;
    }

    public LaunchSpecification withPlacement(SpotPlacement spotPlacement) {
        this.placement = spotPlacement;
        return this;
    }

    public LaunchSpecification withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public LaunchSpecification withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public LaunchSpecification withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public LaunchSpecification withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }

    public LaunchSpecification withUserData(String str) {
        this.userData = str;
        return this;
    }
}
