package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class LaunchConfiguration {
    private List<BlockDeviceMapping> blockDeviceMappings;
    private Date createdTime;
    private String iamInstanceProfile;
    private String imageId;
    private InstanceMonitoring instanceMonitoring;
    private String instanceType;
    private String kernelId;
    private String keyName;
    private String launchConfigurationARN;
    private String launchConfigurationName;
    private String ramdiskId;
    private List<String> securityGroups;
    private String spotPrice;
    private String userData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LaunchConfiguration)) {
            return false;
        }
        LaunchConfiguration launchConfiguration = (LaunchConfiguration) obj;
        if (((launchConfiguration.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getLaunchConfigurationName() != null && !launchConfiguration.getLaunchConfigurationName().equals(getLaunchConfigurationName())) {
            return false;
        }
        if (((launchConfiguration.getLaunchConfigurationARN() == null ? 1 : 0) ^ (getLaunchConfigurationARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getLaunchConfigurationARN() != null && !launchConfiguration.getLaunchConfigurationARN().equals(getLaunchConfigurationARN())) {
            return false;
        }
        if (((launchConfiguration.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getImageId() != null && !launchConfiguration.getImageId().equals(getImageId())) {
            return false;
        }
        if (((launchConfiguration.getKeyName() == null ? 1 : 0) ^ (getKeyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getKeyName() != null && !launchConfiguration.getKeyName().equals(getKeyName())) {
            return false;
        }
        if (((launchConfiguration.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getSecurityGroups() != null && !launchConfiguration.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((launchConfiguration.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getUserData() != null && !launchConfiguration.getUserData().equals(getUserData())) {
            return false;
        }
        if (((launchConfiguration.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getInstanceType() != null && !launchConfiguration.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((launchConfiguration.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getKernelId() != null && !launchConfiguration.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((launchConfiguration.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getRamdiskId() != null && !launchConfiguration.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((launchConfiguration.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getBlockDeviceMappings() != null && !launchConfiguration.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((launchConfiguration.getInstanceMonitoring() == null ? 1 : 0) ^ (getInstanceMonitoring() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getInstanceMonitoring() != null && !launchConfiguration.getInstanceMonitoring().equals(getInstanceMonitoring())) {
            return false;
        }
        if (((launchConfiguration.getSpotPrice() == null ? 1 : 0) ^ (getSpotPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getSpotPrice() != null && !launchConfiguration.getSpotPrice().equals(getSpotPrice())) {
            return false;
        }
        if (((launchConfiguration.getIamInstanceProfile() == null ? 1 : 0) ^ (getIamInstanceProfile() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (launchConfiguration.getIamInstanceProfile() != null && !launchConfiguration.getIamInstanceProfile().equals(getIamInstanceProfile())) {
            return false;
        }
        return ((launchConfiguration.getCreatedTime() == null ? 1 : 0) ^ (getCreatedTime() == null ? 1 : 0)) == 0 ? launchConfiguration.getCreatedTime() == null || launchConfiguration.getCreatedTime().equals(getCreatedTime()) : false;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public String getIamInstanceProfile() {
        return this.iamInstanceProfile;
    }

    public String getImageId() {
        return this.imageId;
    }

    public InstanceMonitoring getInstanceMonitoring() {
        return this.instanceMonitoring;
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

    public String getLaunchConfigurationARN() {
        return this.launchConfigurationARN;
    }

    public String getLaunchConfigurationName() {
        return this.launchConfigurationName;
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

    public String getSpotPrice() {
        return this.spotPrice;
    }

    public String getUserData() {
        return this.userData;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIamInstanceProfile() == null ? 0 : getIamInstanceProfile().hashCode()) + (((getSpotPrice() == null ? 0 : getSpotPrice().hashCode()) + (((getInstanceMonitoring() == null ? 0 : getInstanceMonitoring().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getKeyName() == null ? 0 : getKeyName().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + (((getLaunchConfigurationARN() == null ? 0 : getLaunchConfigurationARN().hashCode()) + (((getLaunchConfigurationName() == null ? 0 : getLaunchConfigurationName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getCreatedTime() != null) {
            i = getCreatedTime().hashCode();
        }
        return hashCode + i;
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

    public void setCreatedTime(Date date) {
        this.createdTime = date;
    }

    public void setIamInstanceProfile(String str) {
        this.iamInstanceProfile = str;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setInstanceMonitoring(InstanceMonitoring instanceMonitoring) {
        this.instanceMonitoring = instanceMonitoring;
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

    public void setLaunchConfigurationARN(String str) {
        this.launchConfigurationARN = str;
    }

    public void setLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
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

    public void setSpotPrice(String str) {
        this.spotPrice = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.launchConfigurationName != null) {
            stringBuilder.append("LaunchConfigurationName: " + this.launchConfigurationName + ", ");
        }
        if (this.launchConfigurationARN != null) {
            stringBuilder.append("LaunchConfigurationARN: " + this.launchConfigurationARN + ", ");
        }
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        if (this.keyName != null) {
            stringBuilder.append("KeyName: " + this.keyName + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.userData != null) {
            stringBuilder.append("UserData: " + this.userData + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
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
        if (this.instanceMonitoring != null) {
            stringBuilder.append("InstanceMonitoring: " + this.instanceMonitoring + ", ");
        }
        if (this.spotPrice != null) {
            stringBuilder.append("SpotPrice: " + this.spotPrice + ", ");
        }
        if (this.iamInstanceProfile != null) {
            stringBuilder.append("IamInstanceProfile: " + this.iamInstanceProfile + ", ");
        }
        if (this.createdTime != null) {
            stringBuilder.append("CreatedTime: " + this.createdTime + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LaunchConfiguration withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public LaunchConfiguration withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public LaunchConfiguration withCreatedTime(Date date) {
        this.createdTime = date;
        return this;
    }

    public LaunchConfiguration withIamInstanceProfile(String str) {
        this.iamInstanceProfile = str;
        return this;
    }

    public LaunchConfiguration withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public LaunchConfiguration withInstanceMonitoring(InstanceMonitoring instanceMonitoring) {
        this.instanceMonitoring = instanceMonitoring;
        return this;
    }

    public LaunchConfiguration withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public LaunchConfiguration withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public LaunchConfiguration withKeyName(String str) {
        this.keyName = str;
        return this;
    }

    public LaunchConfiguration withLaunchConfigurationARN(String str) {
        this.launchConfigurationARN = str;
        return this;
    }

    public LaunchConfiguration withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public LaunchConfiguration withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public LaunchConfiguration withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public LaunchConfiguration withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public LaunchConfiguration withSpotPrice(String str) {
        this.spotPrice = str;
        return this;
    }

    public LaunchConfiguration withUserData(String str) {
        this.userData = str;
        return this;
    }
}
