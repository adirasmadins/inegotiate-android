package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSnapshotAttributeResult {
    private List<CreateVolumePermission> createVolumePermissions;
    private List<ProductCode> productCodes;
    private String snapshotId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSnapshotAttributeResult)) {
            return false;
        }
        DescribeSnapshotAttributeResult describeSnapshotAttributeResult = (DescribeSnapshotAttributeResult) obj;
        if (((describeSnapshotAttributeResult.getSnapshotId() == null ? 1 : 0) ^ (getSnapshotId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotAttributeResult.getSnapshotId() != null && !describeSnapshotAttributeResult.getSnapshotId().equals(getSnapshotId())) {
            return false;
        }
        if (((describeSnapshotAttributeResult.getCreateVolumePermissions() == null ? 1 : 0) ^ (getCreateVolumePermissions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotAttributeResult.getCreateVolumePermissions() != null && !describeSnapshotAttributeResult.getCreateVolumePermissions().equals(getCreateVolumePermissions())) {
            return false;
        }
        return ((describeSnapshotAttributeResult.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) == 0 ? describeSnapshotAttributeResult.getProductCodes() == null || describeSnapshotAttributeResult.getProductCodes().equals(getProductCodes()) : false;
    }

    public List<CreateVolumePermission> getCreateVolumePermissions() {
        if (this.createVolumePermissions == null) {
            this.createVolumePermissions = new ArrayList();
        }
        return this.createVolumePermissions;
    }

    public List<ProductCode> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public String getSnapshotId() {
        return this.snapshotId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCreateVolumePermissions() == null ? 0 : getCreateVolumePermissions().hashCode()) + (((getSnapshotId() == null ? 0 : getSnapshotId().hashCode()) + 31) * 31)) * 31;
        if (getProductCodes() != null) {
            i = getProductCodes().hashCode();
        }
        return hashCode + i;
    }

    public void setCreateVolumePermissions(Collection<CreateVolumePermission> collection) {
        if (collection == null) {
            this.createVolumePermissions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.createVolumePermissions = arrayList;
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

    public void setSnapshotId(String str) {
        this.snapshotId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotId != null) {
            stringBuilder.append("SnapshotId: " + this.snapshotId + ", ");
        }
        if (this.createVolumePermissions != null) {
            stringBuilder.append("CreateVolumePermissions: " + this.createVolumePermissions + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSnapshotAttributeResult withCreateVolumePermissions(Collection<CreateVolumePermission> collection) {
        if (collection == null) {
            this.createVolumePermissions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.createVolumePermissions = arrayList;
        }
        return this;
    }

    public DescribeSnapshotAttributeResult withCreateVolumePermissions(CreateVolumePermission... createVolumePermissionArr) {
        if (getCreateVolumePermissions() == null) {
            setCreateVolumePermissions(new ArrayList(createVolumePermissionArr.length));
        }
        for (Object add : createVolumePermissionArr) {
            getCreateVolumePermissions().add(add);
        }
        return this;
    }

    public DescribeSnapshotAttributeResult withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public DescribeSnapshotAttributeResult withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public DescribeSnapshotAttributeResult withSnapshotId(String str) {
        this.snapshotId = str;
        return this;
    }
}
