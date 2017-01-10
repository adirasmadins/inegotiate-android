package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeBundleTasksRequest extends AmazonWebServiceRequest {
    private List<String> bundleIds;
    private List<Filter> filters;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeBundleTasksRequest)) {
            return false;
        }
        DescribeBundleTasksRequest describeBundleTasksRequest = (DescribeBundleTasksRequest) obj;
        if (((describeBundleTasksRequest.getBundleIds() == null ? 1 : 0) ^ (getBundleIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeBundleTasksRequest.getBundleIds() != null && !describeBundleTasksRequest.getBundleIds().equals(getBundleIds())) {
            return false;
        }
        return ((describeBundleTasksRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeBundleTasksRequest.getFilters() == null || describeBundleTasksRequest.getFilters().equals(getFilters()) : false;
    }

    public List<String> getBundleIds() {
        if (this.bundleIds == null) {
            this.bundleIds = new ArrayList();
        }
        return this.bundleIds;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getBundleIds() == null ? 0 : getBundleIds().hashCode()) + 31) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
        }
        return hashCode + i;
    }

    public void setBundleIds(Collection<String> collection) {
        if (collection == null) {
            this.bundleIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.bundleIds = arrayList;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bundleIds != null) {
            stringBuilder.append("BundleIds: " + this.bundleIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeBundleTasksRequest withBundleIds(Collection<String> collection) {
        if (collection == null) {
            this.bundleIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.bundleIds = arrayList;
        }
        return this;
    }

    public DescribeBundleTasksRequest withBundleIds(String... strArr) {
        if (getBundleIds() == null) {
            setBundleIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getBundleIds().add(add);
        }
        return this;
    }

    public DescribeBundleTasksRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeBundleTasksRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }
}
