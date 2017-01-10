package com.amazonaws.services.ec2.model;

public class PricingDetail {
    private Integer count;
    private Double price;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PricingDetail)) {
            return false;
        }
        PricingDetail pricingDetail = (PricingDetail) obj;
        if (((pricingDetail.getPrice() == null ? 1 : 0) ^ (getPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (pricingDetail.getPrice() != null && !pricingDetail.getPrice().equals(getPrice())) {
            return false;
        }
        return ((pricingDetail.getCount() == null ? 1 : 0) ^ (getCount() == null ? 1 : 0)) == 0 ? pricingDetail.getCount() == null || pricingDetail.getCount().equals(getCount()) : false;
    }

    public Integer getCount() {
        return this.count;
    }

    public Double getPrice() {
        return this.price;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPrice() == null ? 0 : getPrice().hashCode()) + 31) * 31;
        if (getCount() != null) {
            i = getCount().hashCode();
        }
        return hashCode + i;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public void setPrice(Double d) {
        this.price = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.price != null) {
            stringBuilder.append("Price: " + this.price + ", ");
        }
        if (this.count != null) {
            stringBuilder.append("Count: " + this.count + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PricingDetail withCount(Integer num) {
        this.count = num;
        return this;
    }

    public PricingDetail withPrice(Double d) {
        this.price = d;
        return this;
    }
}
