package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeConversionTasksRequest extends AmazonWebServiceRequest {
    private List<String> conversionTaskIds;
    private List<Filter> filters;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeConversionTasksRequest)) {
            return false;
        }
        DescribeConversionTasksRequest describeConversionTasksRequest = (DescribeConversionTasksRequest) obj;
        if (((describeConversionTasksRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeConversionTasksRequest.getFilters() != null && !describeConversionTasksRequest.getFilters().equals(getFilters())) {
            return false;
        }
        return ((describeConversionTasksRequest.getConversionTaskIds() == null ? 1 : 0) ^ (getConversionTaskIds() == null ? 1 : 0)) == 0 ? describeConversionTasksRequest.getConversionTaskIds() == null || describeConversionTasksRequest.getConversionTaskIds().equals(getConversionTaskIds()) : false;
    }

    public List<String> getConversionTaskIds() {
        if (this.conversionTaskIds == null) {
            this.conversionTaskIds = new ArrayList();
        }
        return this.conversionTaskIds;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFilters() == null ? 0 : getFilters().hashCode()) + 31) * 31;
        if (getConversionTaskIds() != null) {
            i = getConversionTaskIds().hashCode();
        }
        return hashCode + i;
    }

    public void setConversionTaskIds(Collection<String> collection) {
        if (collection == null) {
            this.conversionTaskIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.conversionTaskIds = arrayList;
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
        if (this.conversionTaskIds != null) {
            stringBuilder.append("ConversionTaskIds: " + this.conversionTaskIds + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeConversionTasksRequest withConversionTaskIds(Collection<String> collection) {
        if (collection == null) {
            this.conversionTaskIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.conversionTaskIds = arrayList;
        }
        return this;
    }

    public DescribeConversionTasksRequest withConversionTaskIds(String... strArr) {
        if (getConversionTaskIds() == null) {
            setConversionTaskIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getConversionTaskIds().add(add);
        }
        return this;
    }

    public DescribeConversionTasksRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeConversionTasksRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }
}
