package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAvailabilityZonesRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> zoneNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAvailabilityZonesRequest)) {
            return false;
        }
        DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest = (DescribeAvailabilityZonesRequest) obj;
        if (((describeAvailabilityZonesRequest.getZoneNames() == null ? 1 : 0) ^ (getZoneNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAvailabilityZonesRequest.getZoneNames() != null && !describeAvailabilityZonesRequest.getZoneNames().equals(getZoneNames())) {
            return false;
        }
        return ((describeAvailabilityZonesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeAvailabilityZonesRequest.getFilters() == null || describeAvailabilityZonesRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getZoneNames() {
        if (this.zoneNames == null) {
            this.zoneNames = new ArrayList();
        }
        return this.zoneNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getZoneNames() == null ? 0 : getZoneNames().hashCode()) + 31) * 31;
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

    public void setZoneNames(Collection<String> collection) {
        if (collection == null) {
            this.zoneNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.zoneNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.zoneNames != null) {
            stringBuilder.append("ZoneNames: " + this.zoneNames + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAvailabilityZonesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeAvailabilityZonesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeAvailabilityZonesRequest withZoneNames(Collection<String> collection) {
        if (collection == null) {
            this.zoneNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.zoneNames = arrayList;
        }
        return this;
    }

    public DescribeAvailabilityZonesRequest withZoneNames(String... strArr) {
        if (getZoneNames() == null) {
            setZoneNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getZoneNames().add(add);
        }
        return this;
    }
}
