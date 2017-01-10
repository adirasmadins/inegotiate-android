package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReservedInstances {
    private String availabilityZone;
    private String currencyCode;
    private Long duration;
    private Float fixedPrice;
    private Integer instanceCount;
    private String instanceTenancy;
    private String instanceType;
    private String offeringType;
    private String productDescription;
    private List<RecurringCharge> recurringCharges;
    private String reservedInstancesId;
    private Date start;
    private String state;
    private List<Tag> tags;
    private Float usagePrice;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReservedInstances)) {
            return false;
        }
        ReservedInstances reservedInstances = (ReservedInstances) obj;
        if (((reservedInstances.getReservedInstancesId() == null ? 1 : 0) ^ (getReservedInstancesId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getReservedInstancesId() != null && !reservedInstances.getReservedInstancesId().equals(getReservedInstancesId())) {
            return false;
        }
        if (((reservedInstances.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getInstanceType() != null && !reservedInstances.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((reservedInstances.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getAvailabilityZone() != null && !reservedInstances.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((reservedInstances.getStart() == null ? 1 : 0) ^ (getStart() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getStart() != null && !reservedInstances.getStart().equals(getStart())) {
            return false;
        }
        if (((reservedInstances.getDuration() == null ? 1 : 0) ^ (getDuration() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getDuration() != null && !reservedInstances.getDuration().equals(getDuration())) {
            return false;
        }
        if (((reservedInstances.getUsagePrice() == null ? 1 : 0) ^ (getUsagePrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getUsagePrice() != null && !reservedInstances.getUsagePrice().equals(getUsagePrice())) {
            return false;
        }
        if (((reservedInstances.getFixedPrice() == null ? 1 : 0) ^ (getFixedPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getFixedPrice() != null && !reservedInstances.getFixedPrice().equals(getFixedPrice())) {
            return false;
        }
        if (((reservedInstances.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getInstanceCount() != null && !reservedInstances.getInstanceCount().equals(getInstanceCount())) {
            return false;
        }
        if (((reservedInstances.getProductDescription() == null ? 1 : 0) ^ (getProductDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getProductDescription() != null && !reservedInstances.getProductDescription().equals(getProductDescription())) {
            return false;
        }
        if (((reservedInstances.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getState() != null && !reservedInstances.getState().equals(getState())) {
            return false;
        }
        if (((reservedInstances.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getTags() != null && !reservedInstances.getTags().equals(getTags())) {
            return false;
        }
        if (((reservedInstances.getInstanceTenancy() == null ? 1 : 0) ^ (getInstanceTenancy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getInstanceTenancy() != null && !reservedInstances.getInstanceTenancy().equals(getInstanceTenancy())) {
            return false;
        }
        if (((reservedInstances.getCurrencyCode() == null ? 1 : 0) ^ (getCurrencyCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getCurrencyCode() != null && !reservedInstances.getCurrencyCode().equals(getCurrencyCode())) {
            return false;
        }
        if (((reservedInstances.getOfferingType() == null ? 1 : 0) ^ (getOfferingType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstances.getOfferingType() != null && !reservedInstances.getOfferingType().equals(getOfferingType())) {
            return false;
        }
        return ((reservedInstances.getRecurringCharges() == null ? 1 : 0) ^ (getRecurringCharges() == null ? 1 : 0)) == 0 ? reservedInstances.getRecurringCharges() == null || reservedInstances.getRecurringCharges().equals(getRecurringCharges()) : false;
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

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public String getInstanceTenancy() {
        return this.instanceTenancy;
    }

    public String getInstanceType() {
        return this.instanceType;
    }

    public String getOfferingType() {
        return this.offeringType;
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

    public String getReservedInstancesId() {
        return this.reservedInstancesId;
    }

    public Date getStart() {
        return this.start;
    }

    public String getState() {
        return this.state;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public Float getUsagePrice() {
        return this.usagePrice;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getOfferingType() == null ? 0 : getOfferingType().hashCode()) + (((getCurrencyCode() == null ? 0 : getCurrencyCode().hashCode()) + (((getInstanceTenancy() == null ? 0 : getInstanceTenancy().hashCode()) + (((getTags() == null ? 0 : getTags().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getProductDescription() == null ? 0 : getProductDescription().hashCode()) + (((getInstanceCount() == null ? 0 : getInstanceCount().hashCode()) + (((getFixedPrice() == null ? 0 : getFixedPrice().hashCode()) + (((getUsagePrice() == null ? 0 : getUsagePrice().hashCode()) + (((getDuration() == null ? 0 : getDuration().hashCode()) + (((getStart() == null ? 0 : getStart().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getReservedInstancesId() == null ? 0 : getReservedInstancesId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getRecurringCharges() != null) {
            i = getRecurringCharges().hashCode();
        }
        return hashCode + i;
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

    public void setInstanceCount(Integer num) {
        this.instanceCount = num;
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

    public void setOfferingType(String str) {
        this.offeringType = str;
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

    public void setReservedInstancesId(String str) {
        this.reservedInstancesId = str;
    }

    public void setStart(Date date) {
        this.start = date;
    }

    public void setState(String str) {
        this.state = str;
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

    public void setUsagePrice(Float f) {
        this.usagePrice = f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesId != null) {
            stringBuilder.append("ReservedInstancesId: " + this.reservedInstancesId + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.start != null) {
            stringBuilder.append("Start: " + this.start + ", ");
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
        if (this.instanceCount != null) {
            stringBuilder.append("InstanceCount: " + this.instanceCount + ", ");
        }
        if (this.productDescription != null) {
            stringBuilder.append("ProductDescription: " + this.productDescription + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReservedInstances withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public ReservedInstances withCurrencyCode(String str) {
        this.currencyCode = str;
        return this;
    }

    public ReservedInstances withDuration(Long l) {
        this.duration = l;
        return this;
    }

    public ReservedInstances withFixedPrice(Float f) {
        this.fixedPrice = f;
        return this;
    }

    public ReservedInstances withInstanceCount(Integer num) {
        this.instanceCount = num;
        return this;
    }

    public ReservedInstances withInstanceTenancy(String str) {
        this.instanceTenancy = str;
        return this;
    }

    public ReservedInstances withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public ReservedInstances withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public ReservedInstances withOfferingType(String str) {
        this.offeringType = str;
        return this;
    }

    public ReservedInstances withProductDescription(String str) {
        this.productDescription = str;
        return this;
    }

    public ReservedInstances withRecurringCharges(Collection<RecurringCharge> collection) {
        if (collection == null) {
            this.recurringCharges = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.recurringCharges = arrayList;
        }
        return this;
    }

    public ReservedInstances withRecurringCharges(RecurringCharge... recurringChargeArr) {
        if (getRecurringCharges() == null) {
            setRecurringCharges(new ArrayList(recurringChargeArr.length));
        }
        for (Object add : recurringChargeArr) {
            getRecurringCharges().add(add);
        }
        return this;
    }

    public ReservedInstances withReservedInstancesId(String str) {
        this.reservedInstancesId = str;
        return this;
    }

    public ReservedInstances withStart(Date date) {
        this.start = date;
        return this;
    }

    public ReservedInstances withState(String str) {
        this.state = str;
        return this;
    }

    public ReservedInstances withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public ReservedInstances withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public ReservedInstances withUsagePrice(Float f) {
        this.usagePrice = f;
        return this;
    }
}
