package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImageAttribute {
    private List<BlockDeviceMapping> blockDeviceMappings;
    private String description;
    private String imageId;
    private String kernelId;
    private List<LaunchPermission> launchPermissions;
    private List<ProductCode> productCodes;
    private String ramdiskId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImageAttribute)) {
            return false;
        }
        ImageAttribute imageAttribute = (ImageAttribute) obj;
        if (((imageAttribute.getImageId() == null ? 1 : 0) ^ (getImageId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getImageId() != null && !imageAttribute.getImageId().equals(getImageId())) {
            return false;
        }
        if (((imageAttribute.getLaunchPermissions() == null ? 1 : 0) ^ (getLaunchPermissions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getLaunchPermissions() != null && !imageAttribute.getLaunchPermissions().equals(getLaunchPermissions())) {
            return false;
        }
        if (((imageAttribute.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getProductCodes() != null && !imageAttribute.getProductCodes().equals(getProductCodes())) {
            return false;
        }
        if (((imageAttribute.getKernelId() == null ? 1 : 0) ^ (getKernelId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getKernelId() != null && !imageAttribute.getKernelId().equals(getKernelId())) {
            return false;
        }
        if (((imageAttribute.getRamdiskId() == null ? 1 : 0) ^ (getRamdiskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getRamdiskId() != null && !imageAttribute.getRamdiskId().equals(getRamdiskId())) {
            return false;
        }
        if (((imageAttribute.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (imageAttribute.getDescription() != null && !imageAttribute.getDescription().equals(getDescription())) {
            return false;
        }
        return ((imageAttribute.getBlockDeviceMappings() == null ? 1 : 0) ^ (getBlockDeviceMappings() == null ? 1 : 0)) == 0 ? imageAttribute.getBlockDeviceMappings() == null || imageAttribute.getBlockDeviceMappings().equals(getBlockDeviceMappings()) : false;
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

    public String getImageId() {
        return this.imageId;
    }

    public String getKernelId() {
        return this.kernelId;
    }

    public List<LaunchPermission> getLaunchPermissions() {
        if (this.launchPermissions == null) {
            this.launchPermissions = new ArrayList();
        }
        return this.launchPermissions;
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

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDescription() == null ? 0 : getDescription().hashCode()) + (((getRamdiskId() == null ? 0 : getRamdiskId().hashCode()) + (((getKernelId() == null ? 0 : getKernelId().hashCode()) + (((getProductCodes() == null ? 0 : getProductCodes().hashCode()) + (((getLaunchPermissions() == null ? 0 : getLaunchPermissions().hashCode()) + (((getImageId() == null ? 0 : getImageId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getBlockDeviceMappings() != null) {
            i = getBlockDeviceMappings().hashCode();
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

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageId(String str) {
        this.imageId = str;
    }

    public void setKernelId(String str) {
        this.kernelId = str;
    }

    public void setLaunchPermissions(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.launchPermissions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.launchPermissions = arrayList;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageId != null) {
            stringBuilder.append("ImageId: " + this.imageId + ", ");
        }
        if (this.launchPermissions != null) {
            stringBuilder.append("LaunchPermissions: " + this.launchPermissions + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        if (this.kernelId != null) {
            stringBuilder.append("KernelId: " + this.kernelId + ", ");
        }
        if (this.ramdiskId != null) {
            stringBuilder.append("RamdiskId: " + this.ramdiskId + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.blockDeviceMappings != null) {
            stringBuilder.append("BlockDeviceMappings: " + this.blockDeviceMappings + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImageAttribute withBlockDeviceMappings(Collection<BlockDeviceMapping> collection) {
        if (collection == null) {
            this.blockDeviceMappings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.blockDeviceMappings = arrayList;
        }
        return this;
    }

    public ImageAttribute withBlockDeviceMappings(BlockDeviceMapping... blockDeviceMappingArr) {
        if (getBlockDeviceMappings() == null) {
            setBlockDeviceMappings(new ArrayList(blockDeviceMappingArr.length));
        }
        for (Object add : blockDeviceMappingArr) {
            getBlockDeviceMappings().add(add);
        }
        return this;
    }

    public ImageAttribute withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImageAttribute withImageId(String str) {
        this.imageId = str;
        return this;
    }

    public ImageAttribute withKernelId(String str) {
        this.kernelId = str;
        return this;
    }

    public ImageAttribute withLaunchPermissions(Collection<LaunchPermission> collection) {
        if (collection == null) {
            this.launchPermissions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.launchPermissions = arrayList;
        }
        return this;
    }

    public ImageAttribute withLaunchPermissions(LaunchPermission... launchPermissionArr) {
        if (getLaunchPermissions() == null) {
            setLaunchPermissions(new ArrayList(launchPermissionArr.length));
        }
        for (Object add : launchPermissionArr) {
            getLaunchPermissions().add(add);
        }
        return this;
    }

    public ImageAttribute withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public ImageAttribute withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public ImageAttribute withRamdiskId(String str) {
        this.ramdiskId = str;
        return this;
    }
}
