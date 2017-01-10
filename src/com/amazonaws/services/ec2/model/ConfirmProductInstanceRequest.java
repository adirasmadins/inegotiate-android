package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ConfirmProductInstanceRequest extends AmazonWebServiceRequest {
    private String instanceId;
    private String productCode;

    public ConfirmProductInstanceRequest(String str, String str2) {
        this.productCode = str;
        this.instanceId = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmProductInstanceRequest)) {
            return false;
        }
        ConfirmProductInstanceRequest confirmProductInstanceRequest = (ConfirmProductInstanceRequest) obj;
        if (((confirmProductInstanceRequest.getProductCode() == null ? 1 : 0) ^ (getProductCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (confirmProductInstanceRequest.getProductCode() != null && !confirmProductInstanceRequest.getProductCode().equals(getProductCode())) {
            return false;
        }
        return ((confirmProductInstanceRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) == 0 ? confirmProductInstanceRequest.getInstanceId() == null || confirmProductInstanceRequest.getInstanceId().equals(getInstanceId()) : false;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProductCode() == null ? 0 : getProductCode().hashCode()) + 31) * 31;
        if (getInstanceId() != null) {
            i = getInstanceId().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.productCode != null) {
            stringBuilder.append("ProductCode: " + this.productCode + ", ");
        }
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConfirmProductInstanceRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public ConfirmProductInstanceRequest withProductCode(String str) {
        this.productCode = str;
        return this;
    }
}
