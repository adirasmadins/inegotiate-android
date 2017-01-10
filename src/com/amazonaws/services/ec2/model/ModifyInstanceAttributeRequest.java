package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModifyInstanceAttributeRequest extends AmazonWebServiceRequest {
    private String attribute;
    private List<InstanceBlockDeviceMappingSpecification> blockDeviceMappings;
    private Boolean disableApiTermination;
    private Boolean ebsOptimized;
    private List<String> groups;
    private String instanceId;
    private String instanceInitiatedShutdownBehavior;
    private String instanceType;
    private String kernel;
    private String ramdisk;
    private Boolean sourceDestCheck;
    private String userData;
    private String value;

    public ModifyInstanceAttributeRequest(String str, InstanceAttributeName instanceAttributeName) {
        this.instanceId = str;
        this.attribute = instanceAttributeName.toString();
    }

    public ModifyInstanceAttributeRequest(String str, String str2) {
        this.instanceId = str;
        this.attribute = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifyInstanceAttributeRequest)) {
            return false;
        }
        ModifyInstanceAttributeRequest modifyInstanceAttributeRequest = (ModifyInstanceAttributeRequest) obj;
        if (((modifyInstanceAttributeRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getInstanceId() != null && !modifyInstanceAttributeRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getAttribute() == null ? 1 : 0) ^ (getAttribute() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getAttribute() != null && !modifyInstanceAttributeRequest.getAttribute().equals(getAttribute())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getValue() != null && !modifyInstanceAttributeRequest.getValue().equals(getValue())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getBlockDeviceMappings() != null && !modifyInstanceAttributeRequest.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.isSourceDestCheck() == null ? 1 : 0) ^ (isSourceDestCheck() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.isSourceDestCheck() != null && !modifyInstanceAttributeRequest.isSourceDestCheck().equals(isSourceDestCheck())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.isDisableApiTermination() == null ? 1 : 0) ^ (isDisableApiTermination() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.isDisableApiTermination() != null && !modifyInstanceAttributeRequest.isDisableApiTermination().equals(isDisableApiTermination())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getInstanceType() != null && !modifyInstanceAttributeRequest.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getKernel() == null ? 1 : 0) ^ (getKernel() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getKernel() != null && !modifyInstanceAttributeRequest.getKernel().equals(getKernel())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getRamdisk() == null ? 1 : 0) ^ (getRamdisk() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getRamdisk() != null && !modifyInstanceAttributeRequest.getRamdisk().equals(getRamdisk())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getUserData() == null ? 1 : 0) ^ (getUserData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getUserData() != null && !modifyInstanceAttributeRequest.getUserData().equals(getUserData())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getInstanceInitiatedShutdownBehavior() == null ? 1 : 0) ^ (getInstanceInitiatedShutdownBehavior() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getInstanceInitiatedShutdownBehavior() != null && !modifyInstanceAttributeRequest.getInstanceInitiatedShutdownBehavior().equals(getInstanceInitiatedShutdownBehavior())) {
            return false;
        }
        if (((modifyInstanceAttributeRequest.getGroups() == null ? 1 : 0) ^ (getGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (modifyInstanceAttributeRequest.getGroups() != null && !modifyInstanceAttributeRequest.getGroups().equals(getGroups())) {
            return false;
        }
        return ((modifyInstanceAttributeRequest.isEbsOptimized() == null ? 1 : 0) ^ (isEbsOptimized() == null ? 1 : 0)) == 0 ? modifyInstanceAttributeRequest.isEbsOptimized() == null || modifyInstanceAttributeRequest.isEbsOptimized().equals(isEbsOptimized()) : false;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public List<InstanceBlockDeviceMappingSpecification> getBlockDeviceMappings() {
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

    public List<String> getGroups() {
        if (this.groups == null) {
            this.groups = new ArrayList();
        }
        return this.groups;
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

    public String getKernel() {
        return this.kernel;
    }

    public String getRamdisk() {
        return this.ramdisk;
    }

    public Boolean getSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public String getUserData() {
        return this.userData;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroups() == null ? 0 : getGroups().hashCode()) + (((getInstanceInitiatedShutdownBehavior() == null ? 0 : getInstanceInitiatedShutdownBehavior().hashCode()) + (((getUserData() == null ? 0 : getUserData().hashCode()) + (((getRamdisk() == null ? 0 : getRamdisk().hashCode()) + (((getKernel() == null ? 0 : getKernel().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((isDisableApiTermination() == null ? 0 : isDisableApiTermination().hashCode()) + (((isSourceDestCheck() == null ? 0 : isSourceDestCheck().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getValue() == null ? 0 : getValue().hashCode()) + (((getAttribute() == null ? 0 : getAttribute().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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

    public Boolean isSourceDestCheck() {
        return this.sourceDestCheck;
    }

    public void setAttribute(InstanceAttributeName instanceAttributeName) {
        this.attribute = instanceAttributeName.toString();
    }

    public void setAttribute(String str) {
        this.attribute = str;
    }

    public void setBlockDeviceMappings(Collection<InstanceBlockDeviceMappingSpecification> collection) {
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

    public void setGroups(Collection<String> collection) {
        if (collection == null) {
            this.groups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groups = arrayList;
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

    public void setKernel(String str) {
        this.kernel = str;
    }

    public void setRamdisk(String str) {
        this.ramdisk = str;
    }

    public void setSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.attribute != null) {
            stringBuilder.append("Attribute: " + this.attribute + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        if (this.sourceDestCheck != null) {
            stringBuilder.append("SourceDestCheck: " + this.sourceDestCheck + ", ");
        }
        if (this.disableApiTermination != null) {
            stringBuilder.append("DisableApiTermination: " + this.disableApiTermination + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.kernel != null) {
            stringBuilder.append("Kernel: " + this.kernel + ", ");
        }
        if (this.ramdisk != null) {
            stringBuilder.append("Ramdisk: " + this.ramdisk + ", ");
        }
        if (this.userData != null) {
            stringBuilder.append("UserData: " + this.userData + ", ");
        }
        if (this.instanceInitiatedShutdownBehavior != null) {
            stringBuilder.append("InstanceInitiatedShutdownBehavior: " + this.instanceInitiatedShutdownBehavior + ", ");
        }
        if (this.groups != null) {
            stringBuilder.append("Groups: " + this.groups + ", ");
        }
        if (this.ebsOptimized != null) {
            stringBuilder.append("EbsOptimized: " + this.ebsOptimized + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ModifyInstanceAttributeRequest withAttribute(InstanceAttributeName instanceAttributeName) {
        this.attribute = instanceAttributeName.toString();
        return this;
    }

    public ModifyInstanceAttributeRequest withAttribute(String str) {
        this.attribute = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withBlockDeviceMappings(Collection<InstanceBlockDeviceMappingSpecification> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public ModifyInstanceAttributeRequest withBlockDeviceMappings(InstanceBlockDeviceMappingSpecification... instanceBlockDeviceMappingSpecificationArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(instanceBlockDeviceMappingSpecificationArr.length));
        }
        for (Object add : instanceBlockDeviceMappingSpecificationArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public ModifyInstanceAttributeRequest withDisableApiTermination(Boolean bool) {
        this.disableApiTermination = bool;
        return this;
    }

    public ModifyInstanceAttributeRequest withEbsOptimized(Boolean bool) {
        this.ebsOptimized = bool;
        return this;
    }

    public ModifyInstanceAttributeRequest withGroups(Collection<String> collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groups = arrayList;
        }
        return this;
    }

    public ModifyInstanceAttributeRequest withGroups(String... strArr) {
        if (getGroups() == null) {
            setGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroups().add(add);
        }
        return this;
    }

    public ModifyInstanceAttributeRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withInstanceInitiatedShutdownBehavior(String str) {
        this.instanceInitiatedShutdownBehavior = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withKernel(String str) {
        this.kernel = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withRamdisk(String str) {
        this.ramdisk = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withSourceDestCheck(Boolean bool) {
        this.sourceDestCheck = bool;
        return this;
    }

    public ModifyInstanceAttributeRequest withUserData(String str) {
        this.userData = str;
        return this;
    }

    public ModifyInstanceAttributeRequest withValue(String str) {
        this.value = str;
        return this;
    }
}
