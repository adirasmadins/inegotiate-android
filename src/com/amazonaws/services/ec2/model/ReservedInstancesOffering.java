package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReservedInstancesOffering {
    private String availabilityZone;
    private String currencyCode;
    private Long duration;
    private Float fixedPrice;
    private String instanceTenancy;
    private String instanceType;
    private Boolean marketplace;
    private String offeringType;
    private List<PricingDetail> pricingDetails;
    private String productDescription;
    private List<RecurringCharge> recurringCharges;
    private String reservedInstancesOfferingId;
    private Float usagePrice;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReservedInstancesOffering)) {
            return false;
        }
        ReservedInstancesOffering reservedInstancesOffering = (ReservedInstancesOffering) obj;
        if (((reservedInstancesOffering.getReservedInstancesOfferingId() == null ? 1 : 0) ^ (getReservedInstancesOfferingId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getReservedInstancesOfferingId() != null && !reservedInstancesOffering.getReservedInstancesOfferingId().equals(getReservedInstancesOfferingId())) {
            return false;
        }
        if (((reservedInstancesOffering.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getInstanceType() != null && !reservedInstancesOffering.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((reservedInstancesOffering.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getAvailabilityZone() != null && !reservedInstancesOffering.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((reservedInstancesOffering.getDuration() == null ? 1 : 0) ^ (getDuration() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getDuration() != null && !reservedInstancesOffering.getDuration().equals(getDuration())) {
            return false;
        }
        if (((reservedInstancesOffering.getUsagePrice() == null ? 1 : 0) ^ (getUsagePrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getUsagePrice() != null && !reservedInstancesOffering.getUsagePrice().equals(getUsagePrice())) {
            return false;
        }
        if (((reservedInstancesOffering.getFixedPrice() == null ? 1 : 0) ^ (getFixedPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getFixedPrice() != null && !reservedInstancesOffering.getFixedPrice().equals(getFixedPrice())) {
            return false;
        }
        if (((reservedInstancesOffering.getProductDescription() == null ? 1 : 0) ^ (getProductDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getProductDescription() != null && !reservedInstancesOffering.getProductDescription().equals(getProductDescription())) {
            return false;
        }
        if (((reservedInstancesOffering.getInstanceTenancy() == null ? 1 : 0) ^ (getInstanceTenancy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getInstanceTenancy() != null && !reservedInstancesOffering.getInstanceTenancy().equals(getInstanceTenancy())) {
            return false;
        }
        if (((reservedInstancesOffering.getCurrencyCode() == null ? 1 : 0) ^ (getCurrencyCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getCurrencyCode() != null && !reservedInstancesOffering.getCurrencyCode().equals(getCurrencyCode())) {
            return false;
        }
        if (((reservedInstancesOffering.getOfferingType() == null ? 1 : 0) ^ (getOfferingType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getOfferingType() != null && !reservedInstancesOffering.getOfferingType().equals(getOfferingType())) {
            return false;
        }
        if (((reservedInstancesOffering.getRecurringCharges() == null ? 1 : 0) ^ (getRecurringCharges() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.getRecurringCharges() != null && !reservedInstancesOffering.getRecurringCharges().equals(getRecurringCharges())) {
            return false;
        }
        if (((reservedInstancesOffering.isMarketplace() == null ? 1 : 0) ^ (isMarketplace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesOffering.isMarketplace() != null && !reservedInstancesOffering.isMarketplace().equals(isMarketplace())) {
            return false;
        }
        return ((reservedInstancesOffering.getPricingDetails() == null ? 1 : 0) ^ (getPricingDetails() == null ? 1 : 0)) == 0 ? reservedInstancesOffering.getPricingDetails() == null || reservedInstancesOffering.getPricingDetails().equals(getPricingDetails()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Long getDuration() {
        return this.duration;
    }

    public Float getFixedPrice() {
        return this.fixedPrice;
    }

    public String getInstanceTenancy() {
        return this.instanceTenancy;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public Boolean getMarketplace() {
        return this.marketplace;
    }

    public String getOfferingType() {
        return this.offeringType;
    }

    public List<PricingDetail> getPricingDetails() {
        if (this.pricingDetails == null) {
            this.pricingDetails = new ArrayList();
        }
        return this.pricingDetails;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public List<RecurringCharge> getRecurringCharges() {
        if (this.recurringCharges == null) {
            this.recurringCharges = new ArrayList();
        }
        return this.recurringCharges;
    }

    public String getReservedInstancesOfferingId() {
        return this.reservedInstancesOfferingId;
    }

    public Float getUsagePrice() {
        return this.usagePrice;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((isMarketplace() == null ? 0 : isMarketplace().hashCode()) + (((getRecurringCharges() == null ? 0 : getRecurringCharges().hashCode()) + (((getOfferingType() == null ? 0 : getOfferingType().hashCode()) + (((getCurrencyCode() == null ? 0 : getCurrencyCode().hashCode()) + (((getInstanceTenancy() == null ? 0 : getInstanceTenancy().hashCode()) + (((getProductDescription() == null ? 0 : getProductDescription().hashCode()) + (((getFixedPrice() == null ? 0 : getFixedPrice().hashCode()) + (((getUsagePrice() == null ? 0 : getUsagePrice().hashCode()) + (((getDuration() == null ? 0 : getDuration().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getReservedInstancesOfferingId() == null ? 0 : getReservedInstancesOfferingId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getPricingDetails() != null) {
            i = getPricingDetails().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isMarketplace() {
        return this.marketplace;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public void setDuration(Long l) {
        this.duration = l;
    }

    public void setFixedPrice(Float f) {
        this.fixedPrice = f;
    }

    public void setInstanceTenancy(String str) {
        this.instanceTenancy = str;
    }

    public void setInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
    }

    public void setInstanceType(String str) {
        this.instanceType = str;
    }

    public void setMarketplace(Boolean bool) {
        this.marketplace = bool;
    }

    public void setOfferingType(String str) {
        this.offeringType = str;
    }

    public void setPricingDetails(Collection<PricingDetail> collection) {
        if (collection == null) {
            this.pricingDetails = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.pricingDetails = arrayList;
    }

    public void setProductDescription(String str) {
        this.productDescription = str;
    }

    public void setRecurringCharges(Collection<RecurringCharge> collection) {
        if (collection == null) {
            this.recurringCharges = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.recurringCharges = arrayList;
    }

    public void setReservedInstancesOfferingId(String str) {
        this.reservedInstancesOfferingId = str;
    }

    public void setUsagePrice(Float f) {
        this.usagePrice = f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesOfferingId != null) {
            stringBuilder.append("ReservedInstancesOfferingId: " + this.reservedInstancesOfferingId + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.duration != null) {
            stringBuilder.append("Duration: " + this.duration + ", ");
        }
        if (this.usagePrice != null) {
            stringBuilder.append("UsagePrice: " + this.usagePrice + ", ");
        }
        if (this.fixedPrice != null) {
            stringBuilder.append("FixedPrice: " + this.fixedPrice + ", ");
        }
        if (this.productDescription != null) {
            stringBuilder.append("ProductDescription: " + this.productDescription + ", ");
        }
        if (this.instanceTenancy != null) {
            stringBuilder.append("InstanceTenancy: " + this.instanceTenancy + ", ");
        }
        if (this.currencyCode != null) {
            stringBuilder.append("CurrencyCode: " + this.currencyCode + ", ");
        }
        if (this.offeringType != null) {
            stringBuilder.append("OfferingType: " + this.offeringType + ", ");
        }
        if (this.recurringCharges != null) {
            stringBuilder.append("RecurringCharges: " + this.recurringCharges + ", ");
        }
        if (this.marketplace != null) {
            stringBuilder.append("Marketplace: " + this.marketplace + ", ");
        }
        if (this.pricingDetails != null) {
            stringBuilder.append("PricingDetails: " + this.pricingDetails + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReservedInstancesOffering withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public ReservedInstancesOffering withCurrencyCode(String str) {
        this.currencyCode = str;
        return this;
    }

    public ReservedInstancesOffering withDuration(Long l) {
        this.duration = l;
        return this;
    }

    public ReservedInstancesOffering withFixedPrice(Float f) {
        this.fixedPrice = f;
        return this;
    }

    public ReservedInstancesOffering withInstanceTenancy(String str) {
        this.instanceTenancy = str;
        return this;
    }

    public ReservedInstancesOffering withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public ReservedInstancesOffering withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public ReservedInstancesOffering withMarketplace(Boolean bool) {
        this.marketplace = bool;
        return this;
    }

    public ReservedInstancesOffering withOfferingType(String str) {
        this.offeringType = str;
        return this;
    }

    public ReservedInstancesOffering withPricingDetails(Collection<PricingDetail> collection) {
        if (collection == null) {
            this.pricingDetails = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.pricingDetails = arrayList;
        }
        return this;
    }

    public ReservedInstancesOffering withPricingDetails(PricingDetail... pricingDetailArr) {
        if (getPricingDetails() == null) {
            setPricingDetails(new ArrayList(pricingDetailArr.length));
        }
        for (Object add : pricingDetailArr) {
            getPricingDetails().add(add);
        }
        return this;
    }

    public ReservedInstancesOffering withProductDescription(String str) {
        this.productDescription = str;
        return this;
    }

    public ReservedInstancesOffering withRecurringCharges(Collection<RecurringCharge> collection) {
        if (collection == null) {
            this.recurringCharges = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.recurringCharges = arrayList;
        }
        return this;
    }

    public ReservedInstancesOffering withRecurringCharges(RecurringCharge... recurringChargeArr) {
        if (getRecurringCharges() == null) {
            setRecurringCharges(new ArrayList(recurringChargeArr.length));
        }
        for (Object add : recurringChargeArr) {
            getRecurringCharges().add(add);
        }
        return this;
    }

    public ReservedInstancesOffering withReservedInstancesOfferingId(String str) {
        this.reservedInstancesOfferingId = str;
        return this;
    }

    public ReservedInstancesOffering withUsagePrice(Float f) {
        this.usagePrice = f;
        return this;
    }
}
