package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAddressesRequest extends AmazonWebServiceRequest {
    private List<String> allocationIds;
    private List<Filter> filters;
    private List<String> publicIps;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAddressesRequest)) {
            return false;
        }
        DescribeAddressesRequest describeAddressesRequest = (DescribeAddressesRequest) obj;
        if (((describeAddressesRequest.getPublicIps() == null ? 1 : 0) ^ (getPublicIps() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAddressesRequest.getPublicIps() != null && !describeAddressesRequest.getPublicIps().equals(getPublicIps())) {
            return false;
        }
        if (((describeAddressesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAddressesRequest.getFilters() != null && !describeAddressesRequest.getFilters().equals(getFilters())) {
            return false;
        }
        return ((describeAddressesRequest.getAllocationIds() == null ? 1 : 0) ^ (getAllocationIds() == null ? 1 : 0)) == 0 ? describeAddressesRequest.getAllocationIds() == null || describeAddressesRequest.getAllocationIds().equals(getAllocationIds()) : false;
    }

    public List<String> getAllocationIds() {
        if (this.allocationIds == null) {
            this.allocationIds = new ArrayList();
        }
        return this.allocationIds;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getPublicIps() {
        if (this.publicIps == null) {
            this.publicIps = new ArrayList();
        }
        return this.publicIps;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFilters() == null ? 0 : getFilters().hashCode()) + (((getPublicIps() == null ? 0 : getPublicIps().hashCode()) + 31) * 31)) * 31;
        if (getAllocationIds() != null) {
            i = getAllocationIds().hashCode();
        }
        return hashCode + i;
    }

    public void setAllocationIds(Collection<String> collection) {
        if (collection == null) {
            this.allocationIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.allocationIds = arrayList;
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

    public void setPublicIps(Collection<String> collection) {
        if (collection == null) {
            this.publicIps = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.publicIps = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.publicIps != null) {
            stringBuilder.append("PublicIps: " + this.publicIps + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        if (this.allocationIds != null) {
            stringBuilder.append("AllocationIds: " + this.allocationIds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAddressesRequest withAllocationIds(Collection<String> collection) {
        if (collection == null) {
            this.allocationIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.allocationIds = arrayList;
        }
        return this;
    }

    public DescribeAddressesRequest withAllocationIds(String... strArr) {
        if (getAllocationIds() == null) {
            setAllocationIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAllocationIds().add(add);
        }
        return this;
    }

    public DescribeAddressesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeAddressesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeAddressesRequest withPublicIps(Collection<String> collection) {
        if (collection == null) {
            this.publicIps = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.publicIps = arrayList;
        }
        return this;
    }

    public DescribeAddressesRequest withPublicIps(String... strArr) {
        if (getPublicIps() == null) {
            setPublicIps(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getPublicIps().add(add);
        }
        return this;
    }
}
