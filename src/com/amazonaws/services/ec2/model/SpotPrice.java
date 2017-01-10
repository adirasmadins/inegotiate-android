package com.amazonaws.services.ec2.model;

import java.util.Date;

public class SpotPrice {
    private String availabilityZone;
    private String instanceType;
    private String productDescription;
    private String spotPrice;
    private Date timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SpotPrice)) {
            return false;
        }
        SpotPrice spotPrice = (SpotPrice) obj;
        if (((spotPrice.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotPrice.getInstanceType() != null && !spotPrice.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((spotPrice.getProductDescription() == null ? 1 : 0) ^ (getProductDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotPrice.getProductDescription() != null && !spotPrice.getProductDescription().equals(getProductDescription())) {
            return false;
        }
        if (((spotPrice.getSpotPrice() == null ? 1 : 0) ^ (getSpotPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotPrice.getSpotPrice() != null && !spotPrice.getSpotPrice().equals(getSpotPrice())) {
            return false;
        }
        if (((spotPrice.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotPrice.getTimestamp() != null && !spotPrice.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        return ((spotPrice.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) == 0 ? spotPrice.getAvailabilityZone() == null || spotPrice.getAvailabilityZone().equals(getAvailabilityZone()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public String getSpotPrice() {
        return this.spotPrice;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + (((getSpotPrice() == null ? 0 : getSpotPrice().hashCode()) + (((getProductDescription() == null ? 0 : getProductDescription().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getAvailabilityZone() != null) {
            i = getAvailabilityZone().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
    }

    public void setInstanceType(String str) {
        this.instanceType = str;
    }

    public void setProductDescription(String str) {
        this.productDescription = str;
    }

    public void setSpotPrice(String str) {
        this.spotPrice = str;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.productDescription != null) {
            stringBuilder.append("ProductDescription: " + this.productDescription + ", ");
        }
        if (this.spotPrice != null) {
            stringBuilder.append("SpotPrice: " + this.spotPrice + ", ");
        }
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SpotPrice withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public SpotPrice withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public SpotPrice withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public SpotPrice withProductDescription(String str) {
        this.productDescription = str;
        return this;
    }

    public SpotPrice withSpotPrice(String str) {
        this.spotPrice = str;
        return this;
    }

    public SpotPrice withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }
}
