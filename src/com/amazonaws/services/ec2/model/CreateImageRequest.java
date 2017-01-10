package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateImageRequest extends AmazonWebServiceRequest {
    private List<BlockDeviceMapping> blockDeviceMappings;
    private String description;
    private String instanceId;
    private String name;
    private Boolean noReboot;

    public CreateImageRequest(String str, String str2) {
        this.instanceId = str;
        this.name = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateImageRequest)) {
            return false;
        }
        CreateImageRequest createImageRequest = (CreateImageRequest) obj;
        if (((createImageRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createImageRequest.getInstanceId() != null && !createImageRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((createImageRequest.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createImageRequest.getName() != null && !createImageRequest.getName().equals(getName())) {
            return false;
        }
        if (((createImageRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createImageRequest.getDescription() != null && !createImageRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (((createImageRequest.isNoReboot() == null ? 1 : 0) ^ (isNoReboot() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createImageRequest.isNoReboot() != null && !createImageRequest.isNoReboot().equals(isNoReboot())) {
            return false;
        }
        return ((createImageRequest.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) == 0 ? createImageRequest.getBlockDeviceMappings() == null || createImageRequest.getBlockDeviceMappings().equals(getBlockDeviceMappings()) : false;
    }

    public List<BlockDeviceMapping> getBlockDeviceMappings() {
        if (this.blockDeviceMappings == null) {
            this.blockDeviceMappings = new ArrayList();
        }
        return this.blockDeviceMappings;
    }

    public String getDescription() {
        return this.description;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getNoReboot() {
        return this.noReboot;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((isNoReboot() == null ? 0 : isNoReboot().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getBlockDeviceMappings() != null) {
            i = getBlockDeviceMappings().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isNoReboot() {
        return this.noReboot;
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNoReboot(Boolean bool) {
        this.noReboot = bool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.noReboot != null) {
            stringBuilder.append("NoReboot: " + this.noReboot + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateImageRequest withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public CreateImageRequest withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public CreateImageRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateImageRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public CreateImageRequest withName(String str) {
        this.name = str;
        return this;
    }

    public CreateImageRequest withNoReboot(Boolean bool) {
        this.noReboot = bool;
        return this;
    }
}
