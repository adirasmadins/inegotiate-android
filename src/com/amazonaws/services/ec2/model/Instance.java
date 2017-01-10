package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Instance {
    private Integer amiLaunchIndex;
    private String architecture;
    private List<InstanceBlockDeviceMapping> blockDeviceMappings;
    private String clientToken;
    private Boolean ebsOptimized;
    private String hypervisor;
    private IamInstanceProfile iamInstanceProfile;
    private String imageId;
    private String instanceId;
    private String instanceLifecycle;
    private String instanceType;
    private String kernelId;
    private String keyName;
    private Date launchTime;
    private InstanceLicense license;
    private Monitoring monitoring;
    private List<InstanceNetworkInterface> networkInterfaces;
    private Placement placement;
    private String platform;
    private String privateDnsName;
    private String privateIpAddress;
    private List<ProductCode> productCodes;
    private String publicDnsName;
    private String publicIpAddress;
    private String ramdiskId;
    private String rootDeviceName;
    private String rootDeviceType;
    private List<GroupIdentifier> securityGroups;
    private Boolean sourceDestCheck;
    private String spotInstanceRequestId;
    private InstanceState state;
    private StateReason stateReason;
    private String stateTransitionReason;
    private String subnetId;
    private List<Tag> tags;
    private String virtualizationType;
    private String vpcId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Instance)) {
            return false;
        }
        Instance instance = (Instance) obj;
        if (((instance.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getInstanceId() != null && !instance.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instance.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getImageId() != null && !instance.getImageId().equals(getImageId())) {
            return false;
        }
        if (((instance.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getState() != null && !instance.getState().equals(getState())) {
            return false;
        }
        if (((instance.getPrivateDnsName() == null ? 1 : 0) ^ (getPrivateDnsName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPrivateDnsName() != null && !instance.getPrivateDnsName().equals(getPrivateDnsName())) {
            return false;
        }
        if (((instance.getPublicDnsName() == null ? 1 : 0) ^ (getPublicDnsName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPublicDnsName() != null && !instance.getPublicDnsName().equals(getPublicDnsName())) {
            return false;
        }
        if (((instance.getStateTransitionReason() == null ? 1 : 0) ^ (getStateTransitionReason() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getStateTransitionReason() != null && !instance.getStateTransitionReason().equals(getStateTransitionReason())) {
            return false;
        }
        if (((instance.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getKeyName() != null && !instance.getKeyName().equals(getKeyName())) {
            return false;
        }
        if (((instance.getAmiLaunchIndex() == null ? 1 : 0) ^ (getAmiLaunchIndex() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getAmiLaunchIndex() != null && !instance.getAmiLaunchIndex().equals(getAmiLaunchIndex())) {
            return false;
        }
        if (((instance.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getProductCodes() != null && !instance.getProductCodes().equals(getProductCodes())) {
            return false;
        }
        if (((instance.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getInstanceType() != null && !instance.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((instance.getLaunchTime() == null ? 1 : 0) ^ (getLaunchTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getLaunchTime() != null && !instance.getLaunchTime().equals(getLaunchTime())) {
            return false;
        }
        if (((instance.getPlacement() == null ? 1 : 0) ^ (getPlacement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPlacement() != null && !instance.getPlacement().equals(getPlacement())) {
            return false;
        }
        if (((instance.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getKernelId() != null && !instance.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((instance.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getRamdiskId() != null && !instance.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((instance.getPlatform() == null ? 1 : 0) ^ (getPlatform() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPlatform() != null && !instance.getPlatform().equals(getPlatform())) {
            return false;
        }
        if (((instance.getMonitoring() == null ? 1 : 0) ^ (getMonitoring() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getMonitoring() != null && !instance.getMonitoring().equals(getMonitoring())) {
            return false;
        }
        if (((instance.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getSubnetId() != null && !instance.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((instance.getVpcId() == null ? 1 : 0) ^ (getVpcId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getVpcId() != null && !instance.getVpcId().equals(getVpcId())) {
            return false;
        }
        if (((instance.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPrivateIpAddress() != null && !instance.getPrivateIpAddress().equals(getPrivateIpAddress())) {
            return false;
        }
        if (((instance.getPublicIpAddress() == null ? 1 : 0) ^ (getPublicIpAddress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getPublicIpAddress() != null && !instance.getPublicIpAddress().equals(getPublicIpAddress())) {
            return false;
        }
        if (((instance.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getStateReason() != null && !instance.getStateReason().equals(getStateReason())) {
            return false;
        }
        if (((instance.getArchitecture() == null ? 1 : 0) ^ (getArchitecture() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getArchitecture() != null && !instance.getArchitecture().equals(getArchitecture())) {
            return false;
        }
        if (((instance.getRootDeviceType() == null ? 1 : 0) ^ (getRootDeviceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getRootDeviceType() != null && !instance.getRootDeviceType().equals(getRootDeviceType())) {
            return false;
        }
        if (((instance.getRootDeviceName() == null ? 1 : 0) ^ (getRootDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getRootDeviceName() != null && !instance.getRootDeviceName().equals(getRootDeviceName())) {
            return false;
        }
        if (((instance.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getBlockDeviceMappings() != null && !instance.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((instance.getVirtualizationType() == null ? 1 : 0) ^ (getVirtualizationType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getVirtualizationType() != null && !instance.getVirtualizationType().equals(getVirtualizationType())) {
            return false;
        }
        if (((instance.getInstanceLifecycle() == null ? 1 : 0) ^ (getInstanceLifecycle() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getInstanceLifecycle() != null && !instance.getInstanceLifecycle().equals(getInstanceLifecycle())) {
            return false;
        }
        if (((instance.getSpotInstanceRequestId() == null ? 1 : 0) ^ (getSpotInstanceRequestId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getSpotInstanceRequestId() != null && !instance.getSpotInstanceRequestId().equals(getSpotInstanceRequestId())) {
            return false;
        }
        if (((instance.getLicense() == null ? 1 : 0) ^ (getLicense() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getLicense() != null && !instance.getLicense().equals(getLicense())) {
            return false;
        }
        if (((instance.getClientToken() == null ? 1 : 0) ^ (getClientToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getClientToken() != null && !instance.getClientToken().equals(getClientToken())) {
            return false;
        }
        if (((instance.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getTags() != null && !instance.getTags().equals(getTags())) {
            return false;
        }
        if (((instance.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getSecurityGroups() != null && !instance.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((instance.isSourceDestCheck() == null ? 1 : 0) ^ (isSourceDestCheck() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.isSourceDestCheck() != null && !instance.isSourceDestCheck().equals(isSourceDestCheck())) {
            return false;
        }
        if (((instance.getHypervisor() == null ? 1 : 0) ^ (getHypervisor() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getHypervisor() != null && !instance.getHypervisor().equals(getHypervisor())) {
            return false;
        }
        if (((instance.getNetworkInterfaces() == null ? 1 : 0) ^ (getNetworkInterfaces() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getNetworkInterfaces() != null && !instance.getNetworkInterfaces().equals(getNetworkInterfaces())) {
            return false;
        }
        if (((instance.getIamInstanceProfile() == null ? 1 : 0) ^ (getIamInstanceProfile() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instance.getIamInstanceProfile() != null && !instance.getIamInstanceProfile().equals(getIamInstanceProfile())) {
            return false;
        }
        return ((instance.isEbsOptimized() == null ? 1 : 0) ^ (isEbsOptimized() == null ? 1 : 0)) == 0 ? instance.isEbsOptimized() == null || instance.isEbsOptimized().equals(isEbsOptimized()) : false;
    }

    public Integer getAmiLaunchIndex() {
        return this.amiLaunchIndex;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public List<InstanceBlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public Boolean getEbsOptimized() {
        return this.ebsOptimized;
    }

    public String getHypervisor() {
        return this.hypervisor;
    }

    public IamInstanceProfile getIamInstanceProfile() {
        return this.iamInstanceProfile;
    }

    public String getImageId() {
        return this.imageId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getInstanceLifecycle() {
        return this.instanceLifecycle;
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

    public Date getLaunchTime() {
        return this.launchTime;
    }

    public InstanceLicense getLicense() {
        return this.license;
    }

    public Monitoring getMonitoring() {
        return this.monitoring;
    }

    public List<InstanceNetworkInterface> getNetworkInterfaces() {
        if (this.networkInterfaces == null) {
            this.networkInterfaces = new ArrayList();
        }
        return this.networkInterfaces;
    }

    public Placement getPlacement() {
        return this.placement;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getPrivateDnsName() {
        return this.privateDnsName;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
    }

    public List<ProductCode> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public String getPublicDnsName() {
        return this.publicDnsName;
    }

    public String getPublicIpAddress() {
        return this.publicIpAddress;
    }

    public String getRamdiskId() {
        return this.ramdiskId;
    }

    public String getRootDeviceName() {
        return this.rootDeviceName;
    }

    public String getRootDeviceType() {
        return this.rootDeviceType;
    }

    public List<GroupIdentifier> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public Boolean getSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public String getSpotInstanceRequestId() {
        return this.spotInstanceRequestId;
    }

    public InstanceState getState() {
        return this.state;
    }

    public StateReason getStateReason() {
        return this.stateReason;
    }

    public String getStateTransitionReason() {
        return this.stateTransitionReason;
    }

    public String getSubnetId() {
        return this.subnetId;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public String getVirtualizationType() {
        return this.virtualizationType;
    }

    public String getVpcId() {
        return this.vpcId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIamInstanceProfile() == null ? 0 : getIamInstanceProfile().hashCode()) + (((getNetworkInterfaces() == null ? 0 : getNetworkInterfaces().hashCode()) + (((getHypervisor() == null ? 0 : getHypervisor().hashCode()) + (((isSourceDestCheck() == null ? 0 : isSourceDestCheck().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getTags() == null ? 0 : getTags().hashCode()) + (((getClientToken() == null ? 0 : getClientToken().hashCode()) + (((getLicense() == null ? 0 : getLicense().hashCode()) + (((getSpotInstanceRequestId() == null ? 0 : getSpotInstanceRequestId().hashCode()) + (((getInstanceLifecycle() == null ? 0 : getInstanceLifecycle().hashCode()) + (((getVirtualizationType() == null ? 0 : getVirtualizationType().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRootDeviceName() == null ? 0 : getRootDeviceName().hashCode()) + (((getRootDeviceType() == null ? 0 : getRootDeviceType().hashCode()) + (((getArchitecture() == null ? 0 : getArchitecture().hashCode()) + (((getStateReason() == null ? 0 : getStateReason().hashCode()) + (((getPublicIpAddress() == null ? 0 : getPublicIpAddress().hashCode()) + (((getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode()) + (((getVpcId() == null ? 0 : getVpcId().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((getMonitoring() == null ? 0 : getMonitoring().hashCode()) + (((getPlatform() == null ? 0 : getPlatform().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getPlacement() == null ? 0 : getPlacement().hashCode()) + (((getLaunchTime() == null ? 0 : getLaunchTime().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getProductCodes() == null ? 0 : getProductCodes().hashCode()) + (((getAmiLaunchIndex() == null ? 0 : getAmiLaunchIndex().hashCode()) + (((getKeyName() == null ? 0 : getKeyName().hashCode()) + (((getStateTransitionReason() == null ? 0 : getStateTransitionReason().hashCode()) + (((getPublicDnsName() == null ? 0 : getPublicDnsName().hashCode()) + (((getPrivateDnsName() == null ? 0 : getPrivateDnsName().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (isEbsOptimized() != null) {
            i = isEbsOptimized().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isEbsOptimized() {
        return this.ebsOptimized;
    }

    public Boolean isSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public void setAmiLaunchIndex(Integer num) {
        this.amiLaunchIndex = num;
    }

    public void setArchitecture(String str) {
        this.architecture = str;
    }

    public void setBlockDeviceMappings(Collection<InstanceBlockDeviceMapping> collection) {
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

    public void setEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
    }

    public void setHypervisor(HypervisorType hypervisorType) {
        this.hypervisor = hypervisorType.toString();
    }

    public void setHypervisor(String str) {
        this.hypervisor = str;
    }

    public void setIamInstanceProfile(IamInstanceProfile iamInstanceProfile) {
        this.iamInstanceProfile = iamInstanceProfile;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setInstanceLifecycle(String str) {
        this.instanceLifecycle = str;
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

    public void setLaunchTime(Date date) {
        this.launchTime = date;
    }

    public void setLicense(InstanceLicense instanceLicense) {
        this.license = instanceLicense;
    }

    public void setMonitoring(Monitoring monitoring) {
        this.monitoring = monitoring;
    }

    public void setNetworkInterfaces(Collection<InstanceNetworkInterface> collection) {
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

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPrivateDnsName(String str) {
        this.privateDnsName = str;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
    }

    public void setProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.productCodes = arrayList;
    }

    public void setPublicDnsName(String str) {
        this.publicDnsName = str;
    }

    public void setPublicIpAddress(String str) {
        this.publicIpAddress = str;
    }

    public void setRamdiskId(String str) {
        this.ramdiskId = str;
    }

    public void setRootDeviceName(String str) {
        this.rootDeviceName = str;
    }

    public void setRootDeviceType(String str) {
        this.rootDeviceType = str;
    }

    public void setSecurityGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public void setSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
    }

    public void setSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
    }

    public void setState(InstanceState instanceState) {
        this.state = instanceState;
    }

    public void setStateReason(StateReason stateReason) {
        this.stateReason = stateReason;
    }

    public void setStateTransitionReason(String str) {
        this.stateTransitionReason = str;
    }

    public void setSubnetId(String str) {
        this.subnetId = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
    }

    public void setVirtualizationType(VirtualizationType virtualizationType) {
        this.virtualizationType = virtualizationType.toString();
    }

    public void setVirtualizationType(String str) {
        this.virtualizationType = str;
    }

    public void setVpcId(String str) {
        this.vpcId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.privateDnsName != null) {
            stringBuilder.append("PrivateDnsName: " + this.privateDnsName + ", ");
        }
        if (this.publicDnsName != null) {
            stringBuilder.append("PublicDnsName: " + this.publicDnsName + ", ");
        }
        if (this.stateTransitionReason != null) {
            stringBuilder.append("StateTransitionReason: " + this.stateTransitionReason + ", ");
        }
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        if (this.amiLaunchIndex != null) {
            stringBuilder.append("AmiLaunchIndex: " + this.amiLaunchIndex + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.launchTime != null) {
            stringBuilder.append("LaunchTime: " + this.launchTime + ", ");
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
        if (this.platform != null) {
            stringBuilder.append("Platform: " + this.platform + ", ");
        }
        if (this.monitoring != null) {
            stringBuilder.append("Monitoring: " + this.monitoring + ", ");
        }
        if (this.subnetId != null) {
            stringBuilder.append("SubnetId: " + this.subnetId + ", ");
        }
        if (this.vpcId != null) {
            stringBuilder.append("VpcId: " + this.vpcId + ", ");
        }
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        if (this.publicIpAddress != null) {
            stringBuilder.append("PublicIpAddress: " + this.publicIpAddress + ", ");
        }
        if (this.stateReason != null) {
            stringBuilder.append("StateReason: " + this.stateReason + ", ");
        }
        if (this.architecture != null) {
            stringBuilder.append("Architecture: " + this.architecture + ", ");
        }
        if (this.rootDeviceType != null) {
            stringBuilder.append("RootDeviceType: " + this.rootDeviceType + ", ");
        }
        if (this.rootDeviceName != null) {
            stringBuilder.append("RootDeviceName: " + this.rootDeviceName + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        if (this.virtualizationType != null) {
            stringBuilder.append("VirtualizationType: " + this.virtualizationType + ", ");
        }
        if (this.instanceLifecycle != null) {
            stringBuilder.append("InstanceLifecycle: " + this.instanceLifecycle + ", ");
        }
        if (this.spotInstanceRequestId != null) {
            stringBuilder.append("SpotInstanceRequestId: " + this.spotInstanceRequestId + ", ");
        }
        if (this.license != null) {
            stringBuilder.append("License: " + this.license + ", ");
        }
        if (this.clientToken != null) {
            stringBuilder.append("ClientToken: " + this.clientToken + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.sourceDestCheck != null) {
            stringBuilder.append("SourceDestCheck: " + this.sourceDestCheck + ", ");
        }
        if (this.hypervisor != null) {
            stringBuilder.append("Hypervisor: " + this.hypervisor + ", ");
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

    public Instance withAmiLaunchIndex(Integer num) {
        this.amiLaunchIndex = num;
        return this;
    }

    public Instance withArchitecture(String str) {
        this.architecture = str;
        return this;
    }

    public Instance withBlockDeviceMappings(Collection<InstanceBlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public Instance withBlockDeviceMappings(InstanceBlockDeviceMapping... instanceBlockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(instanceBlockDeviceMappingArr.length));
        }
        for (Object add : instanceBlockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public Instance withClientToken(String str) {
        this.clientToken = str;
        return this;
    }

    public Instance withEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
        return this;
    }

    public Instance withHypervisor(HypervisorType hypervisorType) {
        this.hypervisor = hypervisorType.toString();
        return this;
    }

    public Instance withHypervisor(String str) {
        this.hypervisor = str;
        return this;
    }

    public Instance withIamInstanceProfile(IamInstanceProfile iamInstanceProfile) {
        this.iamInstanceProfile = iamInstanceProfile;
        return this;
    }

    public Instance withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public Instance withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public Instance withInstanceLifecycle(String str) {
        this.instanceLifecycle = str;
        return this;
    }

    public Instance withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public Instance withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public Instance withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public Instance withKeyName(String str) {
        this.keyName = str;
        return this;
    }

    public Instance withLaunchTime(Date date) {
        this.launchTime = date;
        return this;
    }

    public Instance withLicense(InstanceLicense instanceLicense) {
        this.license = instanceLicense;
        return this;
    }

    public Instance withMonitoring(Monitoring monitoring) {
        this.monitoring = monitoring;
        return this;
    }

    public Instance withNetworkInterfaces(Collection<InstanceNetworkInterface> collection) {
        if (collection == null) {
            this.networkInterfaces = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.networkInterfaces = arrayList;
        }
        return this;
    }

    public Instance withNetworkInterfaces(InstanceNetworkInterface... instanceNetworkInterfaceArr) {
        if (getNetworkInterfaces() == null) {
            setNetworkInterfaces(new ArrayList(instanceNetworkInterfaceArr.length));
        }
        for (Object add : instanceNetworkInterfaceArr) {
            getNetworkInterfaces().add(add);
        }
        return this;
    }

    public Instance withPlacement(Placement placement) {
        this.placement = placement;
        return this;
    }

    public Instance withPlatform(String str) {
        this.platform = str;
        return this;
    }

    public Instance withPrivateDnsName(String str) {
        this.privateDnsName = str;
        return this;
    }

    public Instance withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public Instance withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public Instance withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public Instance withPublicDnsName(String str) {
        this.publicDnsName = str;
        return this;
    }

    public Instance withPublicIpAddress(String str) {
        this.publicIpAddress = str;
        return this;
    }

    public Instance withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public Instance withRootDeviceName(String str) {
        this.rootDeviceName = str;
        return this;
    }

    public Instance withRootDeviceType(String str) {
        this.rootDeviceType = str;
        return this;
    }

    public Instance withSecurityGroups(Collection<GroupIdentifier> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public Instance withSecurityGroups(GroupIdentifier... groupIdentifierArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(groupIdentifierArr.length));
        }
        for (Object add : groupIdentifierArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public Instance withSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
        return this;
    }

    public Instance withSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
        return this;
    }

    public Instance withState(InstanceState instanceState) {
        this.state = instanceState;
        return this;
    }

    public Instance withStateReason(StateReason stateReason) {
        this.stateReason = stateReason;
        return this;
    }

    public Instance withStateTransitionReason(String str) {
        this.stateTransitionReason = str;
        return this;
    }

    public Instance withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }

    public Instance withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public Instance withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public Instance withVirtualizationType(VirtualizationType virtualizationType) {
        this.virtualizationType = virtualizationType.toString();
        return this;
    }

    public Instance withVirtualizationType(String str) {
        this.virtualizationType = str;
        return this;
    }

    public Instance withVpcId(String str) {
        this.vpcId = str;
        return this;
    }
}
