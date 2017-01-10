package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeReservedInstancesRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private String offeringType;
    private List<String> reservedInstancesIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeReservedInstancesRequest)) {
            return false;
        }
        DescribeReservedInstancesRequest describeReservedInstancesRequest = (DescribeReservedInstancesRequest) obj;
        if (((describeReservedInstancesRequest.getReservedInstancesIds() == null ? 1 : 0) ^ (getReservedInstancesIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesRequest.getReservedInstancesIds() != null && !describeReservedInstancesRequest.getReservedInstancesIds().equals(getReservedInstancesIds())) {
            return false;
        }
        if (((describeReservedInstancesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesRequest.getFilters() != null && !describeReservedInstancesRequest.getFilters().equals(getFilters())) {
            return false;
        }
        return ((describeReservedInstancesRequest.getOfferingType() == null ? 1 : 0) ^ (getOfferingType() == null ? 1 : 0)) == 0 ? describeReservedInstancesRequest.getOfferingType() == null || describeReservedInstancesRequest.getOfferingType().equals(getOfferingType()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public String getOfferingType() {
        return this.offeringType;
    }

    public List<String> getReservedInstancesIds() {
        if (this.reservedInstancesIds == null) {
            this.reservedInstancesIds = new ArrayList();
        }
        return this.reservedInstancesIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFilters() == null ? 0 : getFilters().hashCode()) + (((getReservedInstancesIds() == null ? 0 : getReservedInstancesIds().hashCode()) + 31) * 31)) * 31;
        if (getOfferingType() != null) {
            i = getOfferingType().hashCode();
        }
        return hashCode + i;
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

    public void setOfferingType(String str) {
        this.offeringType = str;
    }

    public void setReservedInstancesIds(Collection<String> collection) {
        if (collection == null) {
            this.reservedInstancesIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.reservedInstancesIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesIds != null) {
            stringBuilder.append("ReservedInstancesIds: " + this.reservedInstancesIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        if (this.offeringType != null) {
            stringBuilder.append("OfferingType: " + this.offeringType + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeReservedInstancesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeReservedInstancesRequest withOfferingType(String str) {
        this.offeringType = str;
        return this;
    }

    public DescribeReservedInstancesRequest withReservedInstancesIds(Collection<String> collection) {
        if (collection == null) {
            this.reservedInstancesIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.reservedInstancesIds = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesRequest withReservedInstancesIds(String... strArr) {
        if (getReservedInstancesIds() == null) {
            setReservedInstancesIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getReservedInstancesIds().add(add);
        }
        return this;
    }
}
