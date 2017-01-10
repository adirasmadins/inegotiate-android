package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeRegionsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> regionNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRegionsRequest)) {
            return false;
        }
        DescribeRegionsRequest describeRegionsRequest = (DescribeRegionsRequest) obj;
        if (((describeRegionsRequest.getRegionNames() == null ? 1 : 0) ^ (getRegionNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeRegionsRequest.getRegionNames() != null && !describeRegionsRequest.getRegionNames().equals(getRegionNames())) {
            return false;
        }
        return ((describeRegionsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeRegionsRequest.getFilters() == null || describeRegionsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getRegionNames() {
        if (this.regionNames == null) {
            this.regionNames = new ArrayList();
        }
        return this.regionNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRegionNames() == null ? 0 : getRegionNames().hashCode()) + 31) * 31;
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

    public void setRegionNames(Collection<String> collection) {
        if (collection == null) {
            this.regionNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.regionNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.regionNames != null) {
            stringBuilder.append("RegionNames: " + this.regionNames + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeRegionsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeRegionsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeRegionsRequest withRegionNames(Collection<String> collection) {
        if (collection == null) {
            this.regionNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.regionNames = arrayList;
        }
        return this;
    }

    public DescribeRegionsRequest withRegionNames(String... strArr) {
        if (getRegionNames() == null) {
            setRegionNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getRegionNames().add(add);
        }
        return this;
    }
}
