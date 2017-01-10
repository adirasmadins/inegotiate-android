package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeReservedInstancesOfferingsRequest extends AmazonWebServiceRequest {
    private String availabilityZone;
    private List<Filter> filters;
    private String instanceTenancy;
    private String instanceType;
    private String offeringType;
    private String productDescription;
    private List<String> reservedInstancesOfferingIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeReservedInstancesOfferingsRequest)) {
            return false;
        }
        DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest = (DescribeReservedInstancesOfferingsRequest) obj;
        if (((describeReservedInstancesOfferingsRequest.getReservedInstancesOfferingIds() == null ? 1 : 0) ^ (getReservedInstancesOfferingIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getReservedInstancesOfferingIds() != null && !describeReservedInstancesOfferingsRequest.getReservedInstancesOfferingIds().equals(getReservedInstancesOfferingIds())) {
            return false;
        }
        if (((describeReservedInstancesOfferingsRequest.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getInstanceType() != null && !describeReservedInstancesOfferingsRequest.getInstanceType().equals(getInstanceType())) {
            return false;
        }
        if (((describeReservedInstancesOfferingsRequest.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getAvailabilityZone() != null && !describeReservedInstancesOfferingsRequest.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((describeReservedInstancesOfferingsRequest.getProductDescription() == null ? 1 : 0) ^ (getProductDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getProductDescription() != null && !describeReservedInstancesOfferingsRequest.getProductDescription().equals(getProductDescription())) {
            return false;
        }
        if (((describeReservedInstancesOfferingsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getFilters() != null && !describeReservedInstancesOfferingsRequest.getFilters().equals(getFilters())) {
            return false;
        }
        if (((describeReservedInstancesOfferingsRequest.getInstanceTenancy() == null ? 1 : 0) ^ (getInstanceTenancy() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesOfferingsRequest.getInstanceTenancy() != null && !describeReservedInstancesOfferingsRequest.getInstanceTenancy().equals(getInstanceTenancy())) {
            return false;
        }
        return ((describeReservedInstancesOfferingsRequest.getOfferingType() == null ? 1 : 0) ^ (getOfferingType() == null ? 1 : 0)) == 0 ? describeReservedInstancesOfferingsRequest.getOfferingType() == null || describeReservedInstancesOfferingsRequest.getOfferingType().equals(getOfferingType()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
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

    public List<String> getReservedInstancesOfferingIds() {
        if (this.reservedInstancesOfferingIds == null) {
            this.reservedInstancesOfferingIds = new ArrayList();
        }
        return this.reservedInstancesOfferingIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceTenancy() == null ? 0 : getInstanceTenancy().hashCode()) + (((getFilters() == null ? 0 : getFilters().hashCode()) + (((getProductDescription() == null ? 0 : getProductDescription().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getInstanceType() == null ? 0 : getInstanceType().hashCode()) + (((getReservedInstancesOfferingIds() == null ? 0 : getReservedInstancesOfferingIds().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getOfferingType() != null) {
            i = getOfferingType().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.filters = arrayList;
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

    public void setReservedInstancesOfferingIds(Collection<String> collection) {
        if (collection == null) {
            this.reservedInstancesOfferingIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reservedInstancesOfferingIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesOfferingIds != null) {
            stringBuilder.append("ReservedInstancesOfferingIds: " + this.reservedInstancesOfferingIds + ", ");
        }
        if (this.instanceType != null) {
            stringBuilder.append("InstanceType: " + this.instanceType + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.productDescription != null) {
            stringBuilder.append("ProductDescription: " + this.productDescription + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        if (this.instanceTenancy != null) {
            stringBuilder.append("InstanceTenancy: " + this.instanceTenancy + ", ");
        }
        if (this.offeringType != null) {
            stringBuilder.append("OfferingType: " + this.offeringType + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeReservedInstancesOfferingsRequest withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withInstanceTenancy(String str) {
        this.instanceTenancy = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withInstanceType(InstanceType instanceType) {
        this.instanceType = instanceType.toString();
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withInstanceType(String str) {
        this.instanceType = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withOfferingType(String str) {
        this.offeringType = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withProductDescription(String str) {
        this.productDescription = str;
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withReservedInstancesOfferingIds(Collection<String> collection) {
        if (collection == null) {
            this.reservedInstancesOfferingIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reservedInstancesOfferingIds = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesOfferingsRequest withReservedInstancesOfferingIds(String... strArr) {
        if (getReservedInstancesOfferingIds() == null) {
            setReservedInstancesOfferingIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getReservedInstancesOfferingIds().add(add);
        }
        return this;
    }
}
