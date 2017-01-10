package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeReservedInstancesListingsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private String reservedInstancesId;
    private String reservedInstancesListingId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeReservedInstancesListingsRequest)) {
            return false;
        }
        DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest = (DescribeReservedInstancesListingsRequest) obj;
        if (((describeReservedInstancesListingsRequest.getReservedInstancesId() == null ? 1 : 0) ^ (getReservedInstancesId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesListingsRequest.getReservedInstancesId() != null && !describeReservedInstancesListingsRequest.getReservedInstancesId().equals(getReservedInstancesId())) {
            return false;
        }
        if (((describeReservedInstancesListingsRequest.getReservedInstancesListingId() == null ? 1 : 0) ^ (getReservedInstancesListingId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeReservedInstancesListingsRequest.getReservedInstancesListingId() != null && !describeReservedInstancesListingsRequest.getReservedInstancesListingId().equals(getReservedInstancesListingId())) {
            return false;
        }
        return ((describeReservedInstancesListingsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeReservedInstancesListingsRequest.getFilters() == null || describeReservedInstancesListingsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public String getReservedInstancesId() {
        return this.reservedInstancesId;
    }

    public String getReservedInstancesListingId() {
        return this.reservedInstancesListingId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReservedInstancesListingId() == null ? 0 : getReservedInstancesListingId().hashCode()) + (((getReservedInstancesId() == null ? 0 : getReservedInstancesId().hashCode()) + 31) * 31)) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
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

    public void setReservedInstancesId(String str) {
        this.reservedInstancesId = str;
    }

    public void setReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.reservedInstancesId != null) {
            stringBuilder.append("ReservedInstancesId: " + this.reservedInstancesId + ", ");
        }
        if (this.reservedInstancesListingId != null) {
            stringBuilder.append("ReservedInstancesListingId: " + this.reservedInstancesListingId + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeReservedInstancesListingsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeReservedInstancesListingsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeReservedInstancesListingsRequest withReservedInstancesId(String str) {
        this.reservedInstancesId = str;
        return this;
    }

    public DescribeReservedInstancesListingsRequest withReservedInstancesListingId(String str) {
        this.reservedInstancesListingId = str;
        return this;
    }
}
