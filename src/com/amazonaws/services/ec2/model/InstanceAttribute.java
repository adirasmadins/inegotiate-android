package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstanceAttribute {
    private List<InstanceBlockDeviceMapping> blockDeviceMappings;
    private Boolean disableApiTermination;
    private Boolean ebsOptimized;
    private String instanceId;
    private String instanceInitiatedShutdownBehavior;
    private String instanceType;
    private String kernelId;
    private List<ProductCode> productCodes;
    private String ramdiskId;
    private String rootDeviceName;
    private String userData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceAttribute)) {
            return false;
        }
        InstanceAttribute instanceAttribute = (InstanceAttribute) obj;
        if (((instanceAttribute.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getInstanceId() != null && !instanceAttribute.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instanceAttribute.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getInstanceType() != null && !instanceAttribute.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((instanceAttribute.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getKernelId() != null && !instanceAttribute.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((instanceAttribute.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getRamdiskId() != null && !instanceAttribute.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((instanceAttribute.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getUserData() != null && !instanceAttribute.getUserData().equals(getUserData())) {
            return false;
        }
        if (((instanceAttribute.isDisableApiTermination() == null ? 1 : 0) ^ (isDisableApiTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.isDisableApiTermination() != null && !instanceAttribute.isDisableApiTermination().equals(isDisableApiTermination())) {
            return false;
        }
        if (((instanceAttribute.getInstanceInitiatedShutdownBehavior() == null ? 1 : 0) ^ (getInstanceInitiatedShutdownBehavior() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getInstanceInitiatedShutdownBehavior() != null && !instanceAttribute.getInstanceInitiatedShutdownBehavior().equals(getInstanceInitiatedShutdownBehavior())) {
            return false;
        }
        if (((instanceAttribute.getRootDeviceName() == null ? 1 : 0) ^ (getRootDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getRootDeviceName() != null && !instanceAttribute.getRootDeviceName().equals(getRootDeviceName())) {
            return false;
        }
        if (((instanceAttribute.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getBlockDeviceMappings() != null && !instanceAttribute.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((instanceAttribute.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceAttribute.getProductCodes() != null && !instanceAttribute.getProductCodes().equals(getProductCodes())) {
            return false;
        }
        return ((instanceAttribute.isEbsOptimized() == null ? 1 : 0) ^ (isEbsOptimized() == null ? 1 : 0)) == 0 ? instanceAttribute.isEbsOptimized() == null || instanceAttribute.isEbsOptimized().equals(isEbsOptimized()) : false;
    }

    public List<InstanceBlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public Boolean getDisableApiTermination() {
        return this.disableApiTermination;
    }

    public Boolean getEbsOptimized() {
        return this.ebsOptimized;
    }

    public String getInstanceId() {
        return this.instanceId;
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

    public List<ProductCode> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public String getRamdiskId() {
        return this.ramdiskId;
    }

    public String getRootDeviceName() {
        return this.rootDeviceName;
    }

    public String getUserData() {
        return this.userData;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProductCodes() == null ? 0 : getProductCodes().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRootDeviceName() == null ? 0 : getRootDeviceName().hashCode()) + (((getInstanceInitiatedShutdownBehavior() == null ? 0 : getInstanceInitiatedShutdownBehavior().hashCode()) + (((isDisableApiTermination() == null ? 0 : isDisableApiTermination().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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

    public void setBlockDeviceMappings(Collection<InstanceBlockDeviceMapping> collection) {
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

    public void setEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
    }

    public void setInstanceType(String str) {
        this.instanceType = str;
    }

    public void setKernelId(String str) {
        this.kernelId = str;
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

    public void setRamdiskId(String str) {
        this.ramdiskId = str;
    }

    public void setRootDeviceName(String str) {
        this.rootDeviceName = str;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
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
        if (this.userData != null) {
            stringBuilder.append("UserData: " + this.userData + ", ");
        }
        if (this.disableApiTermination != null) {
            stringBuilder.append("DisableApiTermination: " + this.disableApiTermination + ", ");
        }
        if (this.instanceInitiatedShutdownBehavior != null) {
            stringBuilder.append("InstanceInitiatedShutdownBehavior: " + this.instanceInitiatedShutdownBehavior + ", ");
        }
        if (this.rootDeviceName != null) {
            stringBuilder.append("RootDeviceName: " + this.rootDeviceName + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        if (this.ebsOptimized != null) {
            stringBuilder.append("EbsOptimized: " + this.ebsOptimized + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceAttribute withBlockDeviceMappings(Collection<InstanceBlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public InstanceAttribute withBlockDeviceMappings(InstanceBlockDeviceMapping... instanceBlockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(instanceBlockDeviceMappingArr.length));
        }
        for (Object add : instanceBlockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public InstanceAttribute withDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
        return this;
    }

    public InstanceAttribute withEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
        return this;
    }

    public InstanceAttribute withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceAttribute withInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
        return this;
    }

    public InstanceAttribute withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public InstanceAttribute withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public InstanceAttribute withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public InstanceAttribute withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public InstanceAttribute withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public InstanceAttribute withRootDeviceName(String str) {
        this.rootDeviceName = str;
        return this;
    }

    public InstanceAttribute withUserData(String str) {
        this.userData = str;
        return this;
    }
}
