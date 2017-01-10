package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Image {
    private String architecture;
    private List<BlockDeviceMapping> blockDeviceMappings;
    private String description;
    private String hypervisor;
    private String imageId;
    private String imageLocation;
    private String imageOwnerAlias;
    private String imageType;
    private String kernelId;
    private String name;
    private String ownerId;
    private String platform;
    private List<ProductCode> productCodes;
    private Boolean publicValue;
    private String ramdiskId;
    private String rootDeviceName;
    private String rootDeviceType;
    private String state;
    private StateReason stateReason;
    private List<Tag> tags;
    private String virtualizationType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Image)) {
            return false;
        }
        Image image = (Image) obj;
        if (((image.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getImageId() != null && !image.getImageId().equals(getImageId())) {
            return false;
        }
        if (((image.getImageLocation() == null ? 1 : 0) ^ (getImageLocation() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getImageLocation() != null && !image.getImageLocation().equals(getImageLocation())) {
            return false;
        }
        if (((image.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getState() != null && !image.getState().equals(getState())) {
            return false;
        }
        if (((image.getOwnerId() == null ? 1 : 0) ^ (getOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getOwnerId() != null && !image.getOwnerId().equals(getOwnerId())) {
            return false;
        }
        if (((image.isPublic() == null ? 1 : 0) ^ (isPublic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.isPublic() != null && !image.isPublic().equals(isPublic())) {
            return false;
        }
        if (((image.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getProductCodes() != null && !image.getProductCodes().equals(getProductCodes())) {
            return false;
        }
        if (((image.getArchitecture() == null ? 1 : 0) ^ (getArchitecture() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getArchitecture() != null && !image.getArchitecture().equals(getArchitecture())) {
            return false;
        }
        if (((image.getImageType() == null ? 1 : 0) ^ (getImageType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getImageType() != null && !image.getImageType().equals(getImageType())) {
            return false;
        }
        if (((image.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getKernelId() != null && !image.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((image.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getRamdiskId() != null && !image.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((image.getPlatform() == null ? 1 : 0) ^ (getPlatform() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getPlatform() != null && !image.getPlatform().equals(getPlatform())) {
            return false;
        }
        if (((image.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getStateReason() != null && !image.getStateReason().equals(getStateReason())) {
            return false;
        }
        if (((image.getImageOwnerAlias() == null ? 1 : 0) ^ (getImageOwnerAlias() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getImageOwnerAlias() != null && !image.getImageOwnerAlias().equals(getImageOwnerAlias())) {
            return false;
        }
        if (((image.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getName() != null && !image.getName().equals(getName())) {
            return false;
        }
        if (((image.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getDescription() != null && !image.getDescription().equals(getDescription())) {
            return false;
        }
        if (((image.getRootDeviceType() == null ? 1 : 0) ^ (getRootDeviceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getRootDeviceType() != null && !image.getRootDeviceType().equals(getRootDeviceType())) {
            return false;
        }
        if (((image.getRootDeviceName() == null ? 1 : 0) ^ (getRootDeviceName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getRootDeviceName() != null && !image.getRootDeviceName().equals(getRootDeviceName())) {
            return false;
        }
        if (((image.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getBlockDeviceMappings() != null && !image.getBlockDeviceMappings().equals(getBlockDeviceMappings())) {
            return false;
        }
        if (((image.getVirtualizationType() == null ? 1 : 0) ^ (getVirtualizationType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getVirtualizationType() != null && !image.getVirtualizationType().equals(getVirtualizationType())) {
            return false;
        }
        if (((image.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (image.getTags() != null && !image.getTags().equals(getTags())) {
            return false;
        }
        return ((image.getHypervisor() == null ? 1 : 0) ^ (getHypervisor() == null ? 1 : 0)) == 0 ? image.getHypervisor() == null || image.getHypervisor().equals(getHypervisor()) : false;
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

    public String getHypervisor() {
        return this.hypervisor;
    }

    public String getImageId() {
        return this.imageId;
    }

    public String getImageLocation() {
        return this.imageLocation;
    }

    public String getImageOwnerAlias() {
        return this.imageOwnerAlias;
    }

    public String getImageType() {
        return this.imageType;
    }

    public String getKernelId() {
        return this.kernelId;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public List<ProductCode> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public Boolean getPublic() {
        return this.publicValue;
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

    public String getState() {
        return this.state;
    }

    public StateReason getStateReason() {
        return this.stateReason;
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

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + (((getVirtualizationType() == null ? 0 : getVirtualizationType().hashCode()) + (((getBlockDeviceMappings() == null ? 0 : getBlockDeviceMappings().hashCode()) + (((getRootDeviceName() == null ? 0 : getRootDeviceName().hashCode()) + (((getRootDeviceType() == null ? 0 : getRootDeviceType().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + (((getName() == null ? 0 : getName().hashCode()) + (((getImageOwnerAlias() == null ? 0 : getImageOwnerAlias().hashCode()) + (((getStateReason() == null ? 0 : getStateReason().hashCode()) + (((getPlatform() == null ? 0 : getPlatform().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getImageType() == null ? 0 : getImageType().hashCode()) + (((getArchitecture() == null ? 0 : getArchitecture().hashCode()) + (((getProductCodes() == null ? 0 : getProductCodes().hashCode()) + (((isPublic() == null ? 0 : isPublic().hashCode()) + (((getOwnerId() == null ? 0 : getOwnerId().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getImageLocation() == null ? 0 : getImageLocation().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getHypervisor() != null) {
            i = getHypervisor().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isPublic() {
        return this.publicValue;
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

    public void setHypervisor(HypervisorType hypervisorType) {
        this.hypervisor = hypervisorType.toString();
    }

    public void setHypervisor(String str) {
        this.hypervisor = str;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setImageLocation(String str) {
        this.imageLocation = str;
    }

    public void setImageOwnerAlias(String str) {
        this.imageOwnerAlias = str;
    }

    public void setImageType(String str) {
        this.imageType = str;
    }

    public void setKernelId(String str) {
        this.kernelId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
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

    public void setPublic(Boolean bool) {
        this.publicValue = bool;
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

    public void setState(ImageState imageState) {
        this.state = imageState.toString();
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStateReason(StateReason stateReason) {
        this.stateReason = stateReason;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        if (this.imageLocation != null) {
            stringBuilder.append("ImageLocation: " + this.imageLocation + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.ownerId != null) {
            stringBuilder.append("OwnerId: " + this.ownerId + ", ");
        }
        if (this.publicValue != null) {
            stringBuilder.append("Public: " + this.publicValue + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        if (this.architecture != null) {
            stringBuilder.append("Architecture: " + this.architecture + ", ");
        }
        if (this.imageType != null) {
            stringBuilder.append("ImageType: " + this.imageType + ", ");
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
        if (this.stateReason != null) {
            stringBuilder.append("StateReason: " + this.stateReason + ", ");
        }
        if (this.imageOwnerAlias != null) {
            stringBuilder.append("ImageOwnerAlias: " + this.imageOwnerAlias + ", ");
        }
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
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
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        if (this.hypervisor != null) {
            stringBuilder.append("Hypervisor: " + this.hypervisor + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Image withArchitecture(String str) {
        this.architecture = str;
        return this;
    }

    public Image withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public Image withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public Image withDescription(String str) {
        this.description = str;
        return this;
    }

    public Image withHypervisor(HypervisorType hypervisorType) {
        this.hypervisor = hypervisorType.toString();
        return this;
    }

    public Image withHypervisor(String str) {
        this.hypervisor = str;
        return this;
    }

    public Image withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public Image withImageLocation(String str) {
        this.imageLocation = str;
        return this;
    }

    public Image withImageOwnerAlias(String str) {
        this.imageOwnerAlias = str;
        return this;
    }

    public Image withImageType(String str) {
        this.imageType = str;
        return this;
    }

    public Image withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public Image withName(String str) {
        this.name = str;
        return this;
    }

    public Image withOwnerId(String str) {
        this.ownerId = str;
        return this;
    }

    public Image withPlatform(String str) {
        this.platform = str;
        return this;
    }

    public Image withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public Image withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public Image withPublic(Boolean bool) {
        this.publicValue = bool;
        return this;
    }

    public Image withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }

    public Image withRootDeviceName(String str) {
        this.rootDeviceName = str;
        return this;
    }

    public Image withRootDeviceType(String str) {
        this.rootDeviceType = str;
        return this;
    }

    public Image withState(ImageState imageState) {
        this.state = imageState.toString();
        return this;
    }

    public Image withState(String str) {
        this.state = str;
        return this;
    }

    public Image withStateReason(StateReason stateReason) {
        this.stateReason = stateReason;
        return this;
    }

    public Image withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public Image withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public Image withVirtualizationType(VirtualizationType virtualizationType) {
        this.virtualizationType = virtualizationType.toString();
        return this;
    }

    public Image withVirtualizationType(String str) {
        this.virtualizationType = str;
        return this;
    }
}
