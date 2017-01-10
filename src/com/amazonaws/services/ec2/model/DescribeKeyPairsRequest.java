package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeKeyPairsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> keyNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeKeyPairsRequest)) {
            return false;
        }
        DescribeKeyPairsRequest describeKeyPairsRequest = (DescribeKeyPairsRequest) obj;
        if (((describeKeyPairsRequest.getKeyNames() == null ? 1 : 0) ^ (getKeyNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeKeyPairsRequest.getKeyNames() != null && !describeKeyPairsRequest.getKeyNames().equals(getKeyNames())) {
            return false;
        }
        return ((describeKeyPairsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeKeyPairsRequest.getFilters() == null || describeKeyPairsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getKeyNames() {
        if (this.keyNames == null) {
            this.keyNames = new ArrayList();
        }
        return this.keyNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyNames() == null ? 0 : getKeyNames().hashCode()) + 31) * 31;
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

    public void setKeyNames(Collection<String> collection) {
        if (collection == null) {
            this.keyNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.keyNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.keyNames != null) {
            stringBuilder.append("KeyNames: " + this.keyNames + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeKeyPairsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeKeyPairsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeKeyPairsRequest withKeyNames(Collection<String> collection) {
        if (collection == null) {
            this.keyNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.keyNames = arrayList;
        }
        return this;
    }

    public DescribeKeyPairsRequest withKeyNames(String... strArr) {
        if (getKeyNames() == null) {
            setKeyNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getKeyNames().add(add);
        }
        return this;
    }
}
