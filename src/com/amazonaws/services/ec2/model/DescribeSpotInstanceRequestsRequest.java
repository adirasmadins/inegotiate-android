package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSpotInstanceRequestsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> spotInstanceRequestIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSpotInstanceRequestsRequest)) {
            return false;
        }
        DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest = (DescribeSpotInstanceRequestsRequest) obj;
        if (((describeSpotInstanceRequestsRequest.getSpotInstanceRequestIds() == null ? 1 : 0) ^ (getSpotInstanceRequestIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotInstanceRequestsRequest.getSpotInstanceRequestIds() != null && !describeSpotInstanceRequestsRequest.getSpotInstanceRequestIds().equals(getSpotInstanceRequestIds())) {
            return false;
        }
        return ((describeSpotInstanceRequestsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeSpotInstanceRequestsRequest.getFilters() == null || describeSpotInstanceRequestsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getSpotInstanceRequestIds() {
        if (this.spotInstanceRequestIds == null) {
            this.spotInstanceRequestIds = new ArrayList();
        }
        return this.spotInstanceRequestIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSpotInstanceRequestIds() == null ? 0 : getSpotInstanceRequestIds().hashCode()) + 31) * 31;
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

    public void setSpotInstanceRequestIds(Collection<String> collection) {
        if (collection == null) {
            this.spotInstanceRequestIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.spotInstanceRequestIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotInstanceRequestIds != null) {
            stringBuilder.append("SpotInstanceRequestIds: " + this.spotInstanceRequestIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSpotInstanceRequestsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeSpotInstanceRequestsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeSpotInstanceRequestsRequest withSpotInstanceRequestIds(Collection<String> collection) {
        if (collection == null) {
            this.spotInstanceRequestIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.spotInstanceRequestIds = arrayList;
        }
        return this;
    }

    public DescribeSpotInstanceRequestsRequest withSpotInstanceRequestIds(String... strArr) {
        if (getSpotInstanceRequestIds() == null) {
            setSpotInstanceRequestIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSpotInstanceRequestIds().add(add);
        }
        return this;
    }
}
