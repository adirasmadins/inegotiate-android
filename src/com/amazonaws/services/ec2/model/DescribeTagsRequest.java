package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeTagsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;

    public DescribeTagsRequest(List<Filter> list) {
        this.filters = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTagsRequest)) {
            return false;
        }
        DescribeTagsRequest describeTagsRequest = (DescribeTagsRequest) obj;
        return ((describeTagsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeTagsRequest.getFilters() == null || describeTagsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public int hashCode() {
        return (getFilters() == null ? 0 : getFilters().hashCode()) + 31;
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
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeTagsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeTagsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }
}
