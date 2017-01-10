package com.amazonaws.services.ec2.model;

public class ProductCode {
    private String productCodeId;
    private String productCodeType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProductCode)) {
            return false;
        }
        ProductCode productCode = (ProductCode) obj;
        if (((productCode.getProductCodeId() == null ? 1 : 0) ^ (getProductCodeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (productCode.getProductCodeId() != null && !productCode.getProductCodeId().equals(getProductCodeId())) {
            return false;
        }
        return ((productCode.getProductCodeType() == null ? 1 : 0) ^ (getProductCodeType() == null ? 1 : 0)) == 0 ? productCode.getProductCodeType() == null || productCode.getProductCodeType().equals(getProductCodeType()) : false;
    }

    public String getProductCodeId() {
        return this.productCodeId;
    }

    public String getProductCodeType() {
        return this.productCodeType;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProductCodeId() == null ? 0 : getProductCodeId().hashCode()) + 31) * 31;
        if (getProductCodeType() != null) {
            i = getProductCodeType().hashCode();
        }
        return hashCode + i;
    }

    public void setProductCodeId(String str) {
        this.productCodeId = str;
    }

    public void setProductCodeType(String str) {
        this.productCodeType = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.productCodeId != null) {
            stringBuilder.append("ProductCodeId: " + this.productCodeId + ", ");
        }
        if (this.productCodeType != null) {
            stringBuilder.append("ProductCodeType: " + this.productCodeType + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ProductCode withProductCodeId(String str) {
        this.productCodeId = str;
        return this;
    }

    public ProductCode withProductCodeType(String str) {
        this.productCodeType = str;
        return this;
    }
}
