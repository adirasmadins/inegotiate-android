package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImportInstanceLaunchSpecification {
    private String additionalInfo;
    private String architecture;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private Boolean disableApiTermination;
    private String instanceInitiatedShutdownBehavior;
    private String instanceType;
    private Boolean monitoring;
    private Placement placement;
    private String privateIpAddress;
    private List<String> securityGroups;
    private String subnetId;
    private String userData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportInstanceLaunchSpecification)) {
            return false;
        }
        ImportInstanceLaunchSpecification importInstanceLaunchSpecification = (ImportInstanceLaunchSpecification) obj;
        if (((importInstanceLaunchSpecification.getArchitecture() == null ? 1 : 0) ^ (getArchitecture() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getArchitecture() != null && !importInstanceLaunchSpecification.getArchitecture().equals(getArchitecture())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getSecurityGroups() != null && !importInstanceLaunchSpecification.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getAdditionalInfo() == null ? 1 : 0) ^ (getAdditionalInfo() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getAdditionalInfo() != null && !importInstanceLaunchSpecification.getAdditionalInfo().equals(getAdditionalInfo())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getUserData() != null && !importInstanceLaunchSpecification.getUserData().equals(getUserData())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getInstanceType() != null && !importInstanceLaunchSpecification.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getPlacement() == null ? 1 : 0) ^ (getPlacement() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getPlacement() != null && !importInstanceLaunchSpecification.getPlacement().equals(getPlacement())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getBlockDeviceMappings() != null && !importInstanceLaunchSpecification.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.isMonitoring() == null ? 1 : 0) ^ (isMonitoring() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.isMonitoring() != null && !importInstanceLaunchSpecification.isMonitoring().equals(isMonitoring())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getSubnetId() == null ? 1 : 0) ^ (getSubnetId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getSubnetId() != null && !importInstanceLaunchSpecification.getSubnetId().equals(getSubnetId())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.isDisableApiTermination() == null ? 1 : 0) ^ (isDisableApiTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.isDisableApiTermination() != null && !importInstanceLaunchSpecification.isDisableApiTermination().equals(isDisableApiTermination())) {
            return false;
        }
        if (((importInstanceLaunchSpecification.getInstanceInitiatedShutdownBehavior() == null ? 1 : 0) ^ (getInstanceInitiatedShutdownBehavior() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceLaunchSpecification.getInstanceInitiatedShutdownBehavior() != null && !importInstanceLaunchSpecification.getInstanceInitiatedShutdownBehavior().equals(getInstanceInitiatedShutdownBehavior())) {
            return false;
        }
        return ((importInstanceLaunchSpecification.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) == 0 ? importInstanceLaunchSpecification.getPrivateIpAddress() == null || importInstanceLaunchSpecification.getPrivateIpAddress().equals(getPrivateIpAddress()) : false;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public Boolean getDisableApiTermination() {
        return this.disableApiTermination;
    }

    public String getInstanceInitiatedShutdownBehavior() {
        return this.instanceInitiatedShutdownBehavior;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public Boolean getMonitoring() {
        return this.monitoring;
    }

    public Placement getPlacement() {
        return this.placement;
    }

    public String getPrivateIpAddress() {
        return this.privateIpAddress;
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
        int hashCode = ((getInstanceInitiatedShutdownBehavior() == null ? 0 : getInstanceInitiatedShutdownBehavior().hashCode()) + (((isDisableApiTermination() == null ? 0 : isDisableApiTermination().hashCode()) + (((getSubnetId() == null ? 0 : getSubnetId().hashCode()) + (((isMonitoring() == null ? 0 : isMonitoring().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getPlacement() == null ? 0 : getPlacement().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getAdditionalInfo() == null ? 0 : getAdditionalInfo().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getArchitecture() == null ? 0 : getArchitecture().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getPrivateIpAddress() != null) {
            i = getPrivateIpAddress().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isDisableApiTermination() {
        return this.disableApiTermination;
    }

    public Boolean isMonitoring() {
        return this.monitoring;
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public void setArchitecture(String str) {
        this.architecture = str;
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

    public void setDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
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

    public void setMonitoring(Boolean bool) {
        this.monitoring = bool;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public void setPrivateIpAddress(String str) {
        this.privateIpAddress = str;
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
        if (this.architecture != null) {
            stringBuilder.append("Architecture: " + this.architecture + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.additionalInfo != null) {
            stringBuilder.append("AdditionalInfo: " + this.additionalInfo + ", ");
        }
        if (this.userData != null) {
            stringBuilder.append("UserData: " + this.userData + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.placement != null) {
            stringBuilder.append("Placement: " + this.placement + ", ");
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
        if (this.privateIpAddress != null) {
            stringBuilder.append("PrivateIpAddress: " + this.privateIpAddress + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportInstanceLaunchSpecification withAdditionalInfo(String str) {
        this.additionalInfo = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withArchitecture(String str) {
        this.architecture = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public ImportInstanceLaunchSpecification withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public ImportInstanceLaunchSpecification withDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
        return this;
    }

    public ImportInstanceLaunchSpecification withInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public ImportInstanceLaunchSpecification withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withMonitoring(Boolean bool) {
        this.monitoring = bool;
        return this;
    }

    public ImportInstanceLaunchSpecification withPlacement(Placement placement) {
        this.placement = placement;
        return this;
    }

    public ImportInstanceLaunchSpecification withPrivateIpAddress(String str) {
        this.privateIpAddress = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public ImportInstanceLaunchSpecification withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public ImportInstanceLaunchSpecification withSubnetId(String str) {
        this.subnetId = str;
        return this;
    }

    public ImportInstanceLaunchSpecification withUserData(String str) {
        this.userData = str;
        return this;
    }
}
