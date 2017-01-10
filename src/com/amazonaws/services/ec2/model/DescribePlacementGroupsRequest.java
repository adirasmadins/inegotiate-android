package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribePlacementGroupsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> groupNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribePlacementGroupsRequest)) {
            return false;
        }
        DescribePlacementGroupsRequest describePlacementGroupsRequest = (DescribePlacementGroupsRequest) obj;
        if (((describePlacementGroupsRequest.getGroupNames() == null ? 1 : 0) ^ (getGroupNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describePlacementGroupsRequest.getGroupNames() != null && !describePlacementGroupsRequest.getGroupNames().equals(getGroupNames())) {
            return false;
        }
        return ((describePlacementGroupsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describePlacementGroupsRequest.getFilters() == null || describePlacementGroupsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getGroupNames() {
        if (this.groupNames == null) {
            this.groupNames = new ArrayList();
        }
        return this.groupNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupNames() == null ? 0 : getGroupNames().hashCode()) + 31) * 31;
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

    public void setGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groupNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupNames != null) {
            stringBuilder.append("GroupNames: " + this.groupNames + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribePlacementGroupsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribePlacementGroupsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribePlacementGroupsRequest withGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groupNames = arrayList;
        }
        return this;
    }

    public DescribePlacementGroupsRequest withGroupNames(String... strArr) {
        if (getGroupNames() == null) {
            setGroupNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroupNames().add(add);
        }
        return this;
    }
}
