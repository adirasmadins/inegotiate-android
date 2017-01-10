package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegisterImageRequest extends AmazonWebServiceRequest {
    private String architecture;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private String description;
    private String imageLocation;
    private String kernelId;
    private String name;
    private String ramdiskId;
    private String rootDeviceName;

    public RegisterImageRequest(String str) {
        this.imageLocation = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RegisterImageRequest)) {
            return false;
        }
        RegisterImageRequest registerImageRequest = (RegisterImageRequest) obj;
        if (((registerImageRequest.getImageLocation() == null ? 1 : 0) ^ (getImageLocation() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getImageLocation() != null && !registerImageRequest.getImageLocation().equals(getImageLocation())) {
            return false;
        }
        if (((registerImageRequest.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getName() != null && !registerImageRequest.getName().equals(getName())) {
            return false;
        }
        if (((registerImageRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getDescription() != null && !registerImageRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (((registerImageRequest.getArchitecture() == null ? 1 : 0) ^ (getArchitecture() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getArchitecture() != null && !registerImageRequest.getArchitecture().equals(getArchitecture())) {
            return false;
        }
        if (((registerImageRequest.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getKernelId() != null && !registerImageRequest.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((registerImageRequest.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getRamdiskId() != null && !registerImageRequest.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((registerImageRequest.getRootDeviceName() == null ? 1 : 0) ^ (getRootDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (registerImageRequest.getRootDeviceName() != null && !registerImageRequest.getRootDeviceName().equals(getRootDeviceName())) {
            return false;
        }
        return ((registerImageRequest.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) == 0 ? registerImageRequest.getBlockDeviceMappings() == null || registerImageRequest.getBlockDeviceMappings().equals(getBlockDeviceMappings()) : false;
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

    public String getDescription() {
        return this.description;
    }

    public String getImageLocation() {
        return this.imageLocation;
    }

    public String getKernelId() {
        return this.kernelId;
    }

    public String getName() {
        return this.name;
    }

    public String getRamdiskId() {
        return this.ramdiskId;
    }

    public String getRootDeviceName() {
        return this.rootDeviceName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRootDeviceName() == null ? 0 : getRootDeviceName().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getArchitecture() == null ? 0 : getArchitecture().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + (((getImageLocation() == null ? 0 : getImageLocation().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getBlockDeviceMappings() != null) {
            i = getBlockDeviceMappings().hashCode();
        }
        return hashCode + i;
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageLocation(String str) {
        this.imageLocation = str;
    }

    public void setKernelId(String str) {
        this.kernelId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRamdiskId(String str) {
        this.ramdiskId = str;
    }

    public void setRootDeviceName(String str) {
        this.rootDeviceName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageLocation != null) {
            stringBuilder.append("ImageLocation: " + this.imageLocation + ", ");
        }
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.architecture != null) {
            stringBuilder.append("Architecture: " + this.architecture + ", ");
        }
        if (this.kernelId != null) {
            stringBuilder.append("KernelId: " + this.kernelId + ", ");
        }
        if (this.ramdiskId != null) {
            stringBuilder.append("RamdiskId: " + this.ramdiskId + ", ");
        }
        if (this.rootDeviceName != null) {
            stringBuilder.append("RootDeviceName: " + this.rootDeviceName + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RegisterImageRequest withArchitecture(String str) {
        this.architecture = str;
        return this;
    }

    public RegisterImageRequest withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public RegisterImageRequest withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public RegisterImageRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public RegisterImageRequest withImageLocation(String str) {
        this.imageLocation = str;
        return this;
    }

    public RegisterImageRequest withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public RegisterImageRequest withName(String str) {
        this.name = str;
        return this;
    }

    public RegisterImageRequest withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public RegisterImageRequest withRootDeviceName(String str) {
        this.rootDeviceName = str;
        return this;
    }
}
