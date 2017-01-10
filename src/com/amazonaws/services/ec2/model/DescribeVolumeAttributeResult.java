package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumeAttributeResult {
    private Boolean autoEnableIO;
    private List<ProductCode> productCodes;
    private String volumeId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumeAttributeResult)) {
            return false;
        }
        DescribeVolumeAttributeResult describeVolumeAttributeResult = (DescribeVolumeAttributeResult) obj;
        if (((describeVolumeAttributeResult.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeAttributeResult.getVolumeId() != null && !describeVolumeAttributeResult.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((describeVolumeAttributeResult.isAutoEnableIO() == null ? 1 : 0) ^ (isAutoEnableIO() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeAttributeResult.isAutoEnableIO() != null && !describeVolumeAttributeResult.isAutoEnableIO().equals(isAutoEnableIO())) {
            return false;
        }
        return ((describeVolumeAttributeResult.getProductCodes() == null ? 1 : 0) ^ (getProductCodes() == null ? 1 : 0)) == 0 ? describeVolumeAttributeResult.getProductCodes() == null || describeVolumeAttributeResult.getProductCodes().equals(getProductCodes()) : false;
    }

    public Boolean getAutoEnableIO() {
        return this.autoEnableIO;
    }

    public List<ProductCode> getProductCodes() {
        if (this.productCodes == null) {
            this.productCodes = new ArrayList();
        }
        return this.productCodes;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((isAutoEnableIO() == null ? 0 : isAutoEnableIO().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31;
        if (getProductCodes() != null) {
            i = getProductCodes().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isAutoEnableIO() {
        return this.autoEnableIO;
    }

    public void setAutoEnableIO(Boolean bool) {
        this.autoEnableIO = bool;
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

    public void setVolumeId(String str) {
        this.volumeId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.autoEnableIO != null) {
            stringBuilder.append("AutoEnableIO: " + this.autoEnableIO + ", ");
        }
        if (this.productCodes != null) {
            stringBuilder.append("ProductCodes: " + this.productCodes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumeAttributeResult withAutoEnableIO(Boolean bool) {
        this.autoEnableIO = bool;
        return this;
    }

    public DescribeVolumeAttributeResult withProductCodes(Collection<ProductCode> collection) {
        if (collection == null) {
            this.productCodes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productCodes = arrayList;
        }
        return this;
    }

    public DescribeVolumeAttributeResult withProductCodes(ProductCode... productCodeArr) {
        if (getProductCodes() == null) {
            setProductCodes(new ArrayList(productCodeArr.length));
        }
        for (Object add : productCodeArr) {
            getProductCodes().add(add);
        }
        return this;
    }

    public DescribeVolumeAttributeResult withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }
}
