package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReservedInstancesListing {
    private String clientToken;
    private Date createDate;
    private List<InstanceCount> instanceCounts;
    private List<PriceSchedule> priceSchedules;
    private String reservedInstancesId;
    private String reservedInstancesListingId;
    private String status;
    private String statusMessage;
    private List<Tag> tags;
    private Date updateDate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReservedInstancesListing)) {
            return false;
        }
        ReservedInstancesListing reservedInstancesListing = (ReservedInstancesListing) obj;
        if (((reservedInstancesListing.getReservedInstancesListingId() == null ? 1 : 0) ^ (getReservedInstancesListingId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getReservedInstancesListingId() != null && !reservedInstancesListing.getReservedInstancesListingId().equals(getReservedInstancesListingId())) {
            return false;
        }
        if (((reservedInstancesListing.getReservedInstancesId() == null ? 1 : 0) ^ (getReservedInstancesId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getReservedInstancesId() != null && !reservedInstancesListing.getReservedInstancesId().equals(getReservedInstancesId())) {
            return false;
        }
        if (((reservedInstancesListing.getCreateDate() == null ? 1 : 0) ^ (getCreateDate() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getCreateDate() != null && !reservedInstancesListing.getCreateDate().equals(getCreateDate())) {
            return false;
        }
        if (((reservedInstancesListing.getUpdateDate() == null ? 1 : 0) ^ (getUpdateDate() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getUpdateDate() != null && !reservedInstancesListing.getUpdateDate().equals(getUpdateDate())) {
            return false;
        }
        if (((reservedInstancesListing.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getStatus() != null && !reservedInstancesListing.getStatus().equals(getStatus())) {
            return false;
        }
        if (((reservedInstancesListing.getStatusMessage() == null ? 1 : 0) ^ (getStatusMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getStatusMessage() != null && !reservedInstancesListing.getStatusMessage().equals(getStatusMessage())) {
            return false;
        }
        if (((reservedInstancesListing.getInstanceCounts() == null ? 1 : 0) ^ (getInstanceCounts() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getInstanceCounts() != null && !reservedInstancesListing.getInstanceCounts().equals(getInstanceCounts())) {
            return false;
        }
        if (((reservedInstancesListing.getPriceSchedules() == null ? 1 : 0) ^ (getPriceSchedules() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getPriceSchedules() != null && !reservedInstancesListing.getPriceSchedules().equals(getPriceSchedules())) {
            return false;
        }
        if (((reservedInstancesListing.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstancesListing.getTags() != null && !reservedInstancesListing.getTags().equals(getTags())) {
            return false;
        }
        return ((reservedInstancesListing.getClientToken() == null ? 1 : 0) ^ (getClientToken() == null ? 1 : 0)) == 0 ? reservedInstancesListing.getClientToken() == null || reservedInstancesListing.getClientToken().equals(getClientToken()) : false;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public List<InstanceCount> getInstanceCounts() {
        if (this.instanceCounts == null) {
            this.instanceCounts = new ArrayList();
        }
        return this.instanceCounts;
    }

    public List<PriceSchedule> getPriceSchedules() {
        if (this.priceSchedules == null) {
            this.priceSchedules = new ArrayList();
        }
        return this.priceSchedules;
    }

    public String getReservedInstancesId() {
        return this.reservedInstancesId;
    }

    public String getReservedInstancesListingId() {
        return this.reservedInstancesListingId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + (((getPriceSchedules() == null ? 0 : getPriceSchedules().hashCode()) + (((getInstanceCounts() == null ? 0 : getInstanceCounts().hashCode()) + (((getStatusMessage() == null ? 0 : getStatusMessage().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getUpdateDate() == null ? 0 : getUpdateDate().hashCode()) + (((getCreateDate() == null ? 0 : getCreateDate().hashCode()) + (((getReservedInstancesId() == null ? 0 : getReservedInstancesId().hashCode()) + (((getReservedInstancesListingId() == null ? 0 : getReservedInstancesListingId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getClientToken() != null) {
            i = getClientToken().hashCode();
        }
        return hashCode + i;
    }

    public void setClientToken(String str) {
        this.clientToken = str;
    }

    public void setCreateDate(Date date) {
        this.createDate = date;
    }

    public void setInstanceCounts(Collection<InstanceCount> collection) {
        if (collection == null) {
            this.instanceCounts = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceCounts = arrayList;
    }

    public void setPriceSchedules(Collection<PriceSchedule> collection) {
        if (collection == null) {
            this.priceSchedules = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.priceSchedules = arrayList;
    }

    public void setReservedInstancesId(String str) {
        this.reservedInstancesId = str;
    }

    public void setReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
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

    public void setUpdateDate(Date date) {
        this.updateDate = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesListingId != null) {
            stringBuilder.append("ReservedInstancesListingId: " + this.reservedInstancesListingId + ", ");
        }
        if (this.reservedInstancesId != null) {
            stringBuilder.append("ReservedInstancesId: " + this.reservedInstancesId + ", ");
        }
        if (this.createDate != null) {
            stringBuilder.append("CreateDate: " + this.createDate + ", ");
        }
        if (this.updateDate != null) {
            stringBuilder.append("UpdateDate: " + this.updateDate + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.statusMessage != null) {
            stringBuilder.append("StatusMessage: " + this.statusMessage + ", ");
        }
        if (this.instanceCounts != null) {
            stringBuilder.append("InstanceCounts: " + this.instanceCounts + ", ");
        }
        if (this.priceSchedules != null) {
            stringBuilder.append("PriceSchedules: " + this.priceSchedules + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        if (this.clientToken != null) {
            stringBuilder.append("ClientToken: " + this.clientToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReservedInstancesListing withClientToken(String str) {
        this.clientToken = str;
        return this;
    }

    public ReservedInstancesListing withCreateDate(Date date) {
        this.createDate = date;
        return this;
    }

    public ReservedInstancesListing withInstanceCounts(Collection<InstanceCount> collection) {
        if (collection == null) {
            this.instanceCounts = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceCounts = arrayList;
        }
        return this;
    }

    public ReservedInstancesListing withInstanceCounts(InstanceCount... instanceCountArr) {
        if (getInstanceCounts() == null) {
            setInstanceCounts(new ArrayList(instanceCountArr.length));
        }
        for (Object add : instanceCountArr) {
            getInstanceCounts().add(add);
        }
        return this;
    }

    public ReservedInstancesListing withPriceSchedules(Collection<PriceSchedule> collection) {
        if (collection == null) {
            this.priceSchedules = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.priceSchedules = arrayList;
        }
        return this;
    }

    public ReservedInstancesListing withPriceSchedules(PriceSchedule... priceScheduleArr) {
        if (getPriceSchedules() == null) {
            setPriceSchedules(new ArrayList(priceScheduleArr.length));
        }
        for (Object add : priceScheduleArr) {
            getPriceSchedules().add(add);
        }
        return this;
    }

    public ReservedInstancesListing withReservedInstancesId(String str) {
        this.reservedInstancesId = str;
        return this;
    }

    public ReservedInstancesListing withReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
        return this;
    }

    public ReservedInstancesListing withStatus(String str) {
        this.status = str;
        return this;
    }

    public ReservedInstancesListing withStatusMessage(String str) {
        this.statusMessage = str;
        return this;
    }

    public ReservedInstancesListing withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public ReservedInstancesListing withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public ReservedInstancesListing withUpdateDate(Date date) {
        this.updateDate = date;
        return this;
    }
}
