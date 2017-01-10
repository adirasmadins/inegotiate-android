package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RunInstancesRequest extends AmazonWebServiceRequest {
    private String additionalInfo;
    private String addressingType;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private String clientToken;
    private Boolean disableApiTermination;
    private Boolean ebsOptimized;
    private IamInstanceProfileSpecification iamInstanceProfile;
    private String imageId;
    private String instanceInitiatedShutdownBehavior;
    private String instanceType;
    private String kernelId;
    private String keyName;
    private InstanceLicenseSpecification license;
    private Integer maxCount;
    private Integer minCount;
    private Boolean monitoring;
    private List<InstanceNetworkInterfaceSpecification> networkInterfaces;
    private Placement placement;
    private String privateIpAddress;
    private String ramdiskId;
    private List<String> securityGroupIds;
    private List<String> securityGroups;
    private String subnetId;
    private String userData;

    public RunInstancesRequest(String str, Integer num, Integer num2) {
        this.imageId = str;
        this.minCount = num;
        this.maxCount = num2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RunInstancesRequest)) {
            return false;
        }
        RunInstancesRequest runInstancesRequest = (RunInstancesRequest) obj;
        if (((runInstancesRequest.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getImageId() != null && !runInstancesRequest.getImageId().equals(getImageId())) {
            return false;
        }
        if (((runInstancesRequest.getMinCount() == null ? 1 : 0) ^ (getMinCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getMinCount() != null && !runInstancesRequest.getMinCount().equals(getMinCount())) {
            return false;
        }
        if (((runInstancesRequest.getMaxCount() == null ? 1 : 0) ^ (getMaxCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getMaxCount() != null && !runInstancesRequest.getMaxCount().equals(getMaxCount())) {
            return false;
        }
        if (((runInstancesRequest.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getKeyName() != null && !runInstancesRequest.getKeyName().equals(getKeyName())) {
            return false;
        }
        if (((runInstancesRequest.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getSecurityGroups() != null && !runInstancesRequest.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((runInstancesRequest.getSecurityGroupIds() == null ? 1 : 0) ^ (getSecurityGroupIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getSecurityGroupIds() != null && !runInstancesRequest.getSecurityGroupIds().equals(getSecurityGroupIds())) {
            return false;
        }
        if (((runInstancesRequest.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getUserData() != null && !runInstancesRequest.getUserData().equals(getUserData())) {
            return false;
        }
        if (((runInstancesRequest.getAddressingType() == null ? 1 : 0) ^ (getAddressingType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getAddressingType() != null && !runInstancesRequest.getAddressingType().equals(getAddressingType())) {
            return false;
        }
        if (((runInstancesRequest.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getInstanceType() != null && !runInstancesRequest.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((runInstancesRequest.getPlacement() == null ? 1 : 0) ^ (getPlacement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getPlacement() != null && !runInstancesRequest.getPlacement().equals(getPlacement())) {
            return false;
        }
        if (((runInstancesRequest.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getKernelId() != null && !runInstancesRequest.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((runInstancesRequest.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getRamdiskId() != null && !runInstancesRequest.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((runInstancesRequest.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getBlockDeviceMappings() != null && !runInstancesRequest.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((runInstancesRequest.isMonitoring() == null ? 1 : 0) ^ (isMonitoring() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.isMonitoring() != null && !runInstancesRequest.isMonitoring().equals(isMonitoring())) {
            return false;
        }
        if (((runInstancesRequest.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getSubnetId() != null && !runInstancesRequest.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((runInstancesRequest.isDisableApiTermination() == null ? 1 : 0) ^ (isDisableApiTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.isDisableApiTermination() != null && !runInstancesRequest.isDisableApiTermination().equals(isDisableApiTermination())) {
            return false;
        }
        if (((runInstancesRequest.getInstanceInitiatedShutdownBehavior() == null ? 1 : 0) ^ (getInstanceInitiatedShutdownBehavior() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getInstanceInitiatedShutdownBehavior() != null && !runInstancesRequest.getInstanceInitiatedShutdownBehavior().equals(getInstanceInitiatedShutdownBehavior())) {
            return false;
        }
        if (((runInstancesRequest.getLicense() == null ? 1 : 0) ^ (getLicense() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getLicense() != null && !runInstancesRequest.getLicense().equals(getLicense())) {
            return false;
        }
        if (((runInstancesRequest.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getPrivateIpAddress() != null && !runInstancesRequest.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        if (((runInstancesRequest.getClientToken() == null ? 1 : 0) ^ (getClientToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getClientToken() != null && !runInstancesRequest.getClientToken().equals(getClientToken())) {
            return false;
        }
        if (((runInstancesRequest.getAdditionalInfo() == null ? 1 : 0) ^ (getAdditionalInfo() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getAdditionalInfo() != null && !runInstancesRequest.getAdditionalInfo().equals(getAdditionalInfo())) {
            return false;
        }
        if (((runInstancesRequest.getNetworkInterfaces() == null ? 1 : 0) ^ (getNetworkInterfaces() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getNetworkInterfaces() != null && !runInstancesRequest.getNetworkInterfaces().equals(getNetworkInterfaces())) {
            return false;
        }
        if (((runInstancesRequest.getIamInstanceProfile() == null ? 1 : 0) ^ (getIamInstanceProfile() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (runInstancesRequest.getIamInstanceProfile() != null && !runInstancesRequest.getIamInstanceProfile().equals(getIamInstanceProfile())) {
            return false;
        }
        return ((runInstancesRequest.isEbsOptimized() == null ? 1 : 0) ^ (isEbsOptimized() == null ? 1 : 0)) == 0 ? runInstancesRequest.isEbsOptimized() == null || runInstancesRequest.isEbsOptimized().equals(isEbsOptimized()) : false;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getAddressingType() {
        return this.addressingType;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public Boolean getDisableApiTermination() {
        return this.disableApiTermination;
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

    public String getInstanceInitiatedShutdownBehavior() {
        return this.instanceInitiatedShutdownBehavior;
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

    public InstanceLicenseSpecification getLicense() {
        return this.license;
    }

    public Integer getMaxCount() {
        return this.maxCount;
    }

    public Integer getMinCount() {
        return this.minCount;
    }

    public Boolean getMonitoring() {
        return this.monitoring;
    }

    public List<InstanceNetworkInterfaceSpecification> getNetworkInterfaces() {
        if (this.networkInterfaces == null) {
            this.networkInterfaces = new ArrayList();
        }
        return this.networkInterfaces;
    }

    public Placement getPlacement() {
        return this.placement;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public String getRamdiskId() {
        return this.ramdiskId;
    }

    public List<String> getSecurityGroupIds() {
        if (this.securityGroupIds == null) {
            this.securityGroupIds = new ArrayList();
        }
        return this.securityGroupIds;
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
        int hashCode = ((getIamInstanceProfile() == null ? 0 : getIamInstanceProfile().hashCode()) + (((getNetworkInterfaces() == null ? 0 : getNetworkInterfaces().hashCode()) + (((getAdditionalInfo() == null ? 0 : getAdditionalInfo().hashCode()) + (((getClientToken() == null ? 0 : getClientToken().hashCode()) + (((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + (((getLicense() == null ? 0 : getLicense().hashCode()) + (((getInstanceInitiatedShutdownBehavior() == null ? 0 : getInstanceInitiatedShutdownBehavior().hashCode()) + (((isDisableApiTermination() == null ? 0 : isDisableApiTermination().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((isMonitoring() == null ? 0 : isMonitoring().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getPlacement() == null ? 0 : getPlacement().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getAddressingType() == null ? 0 : getAddressingType().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getSecurityGroupIds() == null ? 0 : getSecurityGroupIds().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getKeyName() == null ? 0 : getKeyName().hashCode()) + (((getMaxCount() == null ? 0 : getMaxCount().hashCode()) + (((getMinCount() == null ? 0 : getMinCount().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (isEbsOptimized() != null) {
            i = isEbsOptimized().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDisableApiTermination() {
        return this.disableApiTermination;
    }

    public Boolean isEbsOptimized() {
        return this.ebsOptimized;
    }

    public Boolean isMonitoring() {
        return this.monitoring;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public void setAddressingType(String str) {
        this.addressingType = str;
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

    public void setClientToken(String str) {
        this.clientToken = str;
    }

    public void setDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
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

    public void setInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
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

    public void setLicense(InstanceLicenseSpecification instanceLicenseSpecification) {
        this.license = instanceLicenseSpecification;
    }

    public void setMaxCount(Integer num) {
        this.maxCount = num;
    }

    public void setMinCount(Integer num) {
        this.minCount = num;
    }

    public void setMonitoring(Boolean bool) {
        this.monitoring = bool;
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

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public void setRamdiskId(String str) {
        this.ramdiskId = str;
    }

    public void setSecurityGroupIds(Collection<String> collection) {
        if (collection == null) {
            this.securityGroupIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroupIds = arrayList;
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
        if (this.minCount != null) {
            stringBuilder.append("MinCount: " + this.minCount + ", ");
        }
        if (this.maxCount != null) {
            stringBuilder.append("MaxCount: " + this.maxCount + ", ");
        }
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.securityGroupIds != null) {
            stringBuilder.append("SecurityGroupIds: " + this.securityGroupIds + ", ");
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
        if (this.monitoring != null) {
            stringBuilder.append("Monitoring: " + this.monitoring + ", ");
        }
        if (this.subnetId != null) {
            stringBuilder.append("SubnetId: " + this.subnetId + ", ");
        }
        if (this.disableApiTermination != null) {
            stringBuilder.append("DisableApiTermination: " + this.disableApiTermination + ", ");
        }
        if (this.instanceInitiatedShutdownBehavior != null) {
            stringBuilder.append("InstanceInitiatedShutdownBehavior: " + this.instanceInitiatedShutdownBehavior + ", ");
        }
        if (this.license != null) {
            stringBuilder.append("License: " + this.license + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.clientToken != null) {
            stringBuilder.append("ClientToken: " + this.clientToken + ", ");
        }
        if (this.additionalInfo != null) {
            stringBuilder.append("AdditionalInfo: " + this.additionalInfo + ", ");
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

    public RunInstancesRequest withAdditionalInfo(String str) {
        this.additionalInfo = str;
        return this;
    }

    public RunInstancesRequest withAddressingType(String str) {
        this.addressingType = str;
        return this;
    }

    public RunInstancesRequest withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public RunInstancesRequest withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public RunInstancesRequest withClientToken(String str) {
        this.clientToken = str;
        return this;
    }

    public RunInstancesRequest withDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
        return this;
    }

    public RunInstancesRequest withEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
        return this;
    }

    public RunInstancesRequest withIamInstanceProfile(IamInstanceProfileSpecification iamInstanceProfileSpecification) {
        this.iamInstanceProfile = iamInstanceProfileSpecification;
        return this;
    }

    public RunInstancesRequest withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public RunInstancesRequest withInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
        return this;
    }

    public RunInstancesRequest withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public RunInstancesRequest withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public RunInstancesRequest withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public RunInstancesRequest withKeyName(String str) {
        this.keyName = str;
        return this;
    }

    public RunInstancesRequest withLicense(InstanceLicenseSpecification instanceLicenseSpecification) {
        this.license = instanceLicenseSpecification;
        return this;
    }

    public RunInstancesRequest withMaxCount(Integer num) {
        this.maxCount = num;
        return this;
    }

    public RunInstancesRequest withMinCount(Integer num) {
        this.minCount = num;
        return this;
    }

    public RunInstancesRequest withMonitoring(Boolean bool) {
        this.monitoring = bool;
        return this;
    }

    public RunInstancesRequest withNetworkInterfaces(Collection<InstanceNetworkInterfaceSpecification> collection) {
        if (collection == null) {
            this.networkInterfaces = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.networkInterfaces = arrayList;
        }
        return this;
    }

    public RunInstancesRequest withNetworkInterfaces(InstanceNetworkInterfaceSpecification... instanceNetworkInterfaceSpecificationArr) {
        if (getNetworkInterfaces() == null) {
            setNetworkInterfaces(new ArrayList(instanceNetworkInterfaceSpecificationArr.length));
        }
        for (Object add : instanceNetworkInterfaceSpecificationArr) {
            getNetworkInterfaces().add(add);
        }
        return this;
    }

    public RunInstancesRequest withPlacement(Placement placement) {
        this.placement = placement;
        return this;
    }

    public RunInstancesRequest withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public RunInstancesRequest withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public RunInstancesRequest withSecurityGroupIds(Collection<String> collection) {
        if (collection == null) {
            this.securityGroupIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroupIds = arrayList;
        }
        return this;
    }

    public RunInstancesRequest withSecurityGroupIds(String... strArr) {
        if (getSecurityGroupIds() == null) {
            setSecurityGroupIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroupIds().add(add);
        }
        return this;
    }

    public RunInstancesRequest withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public RunInstancesRequest withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public RunInstancesRequest withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }

    public RunInstancesRequest withUserData(String str) {
        this.userData = str;
        return this;
    }
}
