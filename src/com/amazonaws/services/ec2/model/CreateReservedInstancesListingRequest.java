package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateReservedInstancesListingRequest extends AmazonWebServiceRequest {
    private String clientToken;
    private Integer instanceCount;
    private List<PriceScheduleSpecification> priceSchedules;
    private String reservedInstancesId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateReservedInstancesListingRequest)) {
            return false;
        }
        CreateReservedInstancesListingRequest createReservedInstancesListingRequest = (CreateReservedInstancesListingRequest) obj;
        if (((createReservedInstancesListingRequest.getReservedInstancesId() == null ? 1 : 0) ^ (getReservedInstancesId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createReservedInstancesListingRequest.getReservedInstancesId() != null && !createReservedInstancesListingRequest.getReservedInstancesId().equals(getReservedInstancesId())) {
            return false;
        }
        if (((createReservedInstancesListingRequest.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createReservedInstancesListingRequest.getInstanceCount() != null && !createReservedInstancesListingRequest.getInstanceCount().equals(getInstanceCount())) {
            return false;
        }
        if (((createReservedInstancesListingRequest.getPriceSchedules() == null ? 1 : 0) ^ (getPriceSchedules() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createReservedInstancesListingRequest.getPriceSchedules() != null && !createReservedInstancesListingRequest.getPriceSchedules().equals(getPriceSchedules())) {
            return false;
        }
        return ((createReservedInstancesListingRequest.getClientToken() == null ? 1 : 0) ^ (getClientToken() == null ? 1 : 0)) == 0 ? createReservedInstancesListingRequest.getClientToken() == null || createReservedInstancesListingRequest.getClientToken().equals(getClientToken()) : false;
    }

    public String getClientToken() {
        return this.clientToken;
    }

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public List<PriceScheduleSpecification> getPriceSchedules() {
        if (this.priceSchedules == null) {
            this.priceSchedules = new ArrayList();
        }
        return this.priceSchedules;
    }

    public String getReservedInstancesId() {
        return this.reservedInstancesId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPriceSchedules() == null ? 0 : getPriceSchedules().hashCode()) + (((getInstanceCount() == null ? 0 : getInstanceCount().hashCode()) + (((getReservedInstancesId() == null ? 0 : getReservedInstancesId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getClientToken() != null) {
            i = getClientToken().hashCode();
        }
        return hashCode + i;
    }

    public void setClientToken(String str) {
        this.clientToken = str;
    }

    public void setInstanceCount(Integer num) {
        this.instanceCount = num;
    }

    public void setPriceSchedules(Collection<PriceScheduleSpecification> collection) {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesId != null) {
            stringBuilder.append("ReservedInstancesId: " + this.reservedInstancesId + ", ");
        }
        if (this.instanceCount != null) {
            stringBuilder.append("InstanceCount: " + this.instanceCount + ", ");
        }
        if (this.priceSchedules != null) {
            stringBuilder.append("PriceSchedules: " + this.priceSchedules + ", ");
        }
        if (this.clientToken != null) {
            stringBuilder.append("ClientToken: " + this.clientToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateReservedInstancesListingRequest withClientToken(String str) {
        this.clientToken = str;
        return this;
    }

    public CreateReservedInstancesListingRequest withInstanceCount(Integer num) {
        this.instanceCount = num;
        return this;
    }

    public CreateReservedInstancesListingRequest withPriceSchedules(Collection<PriceScheduleSpecification> collection) {
        if (collection == null) {
            this.priceSchedules = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.priceSchedules = arrayList;
        }
        return this;
    }

    public CreateReservedInstancesListingRequest withPriceSchedules(PriceScheduleSpecification... priceScheduleSpecificationArr) {
        if (getPriceSchedules() == null) {
            setPriceSchedules(new ArrayList(priceScheduleSpecificationArr.length));
        }
        for (Object add : priceScheduleSpecificationArr) {
            getPriceSchedules().add(add);
        }
        return this;
    }

    public CreateReservedInstancesListingRequest withReservedInstancesId(String str) {
        this.reservedInstancesId = str;
        return this;
    }
}
