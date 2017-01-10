package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSecurityGroupsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> groupIds;
    private List<String> groupNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSecurityGroupsRequest)) {
            return false;
        }
        DescribeSecurityGroupsRequest describeSecurityGroupsRequest = (DescribeSecurityGroupsRequest) obj;
        if (((describeSecurityGroupsRequest.getGroupNames() == null ? 1 : 0) ^ (getGroupNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSecurityGroupsRequest.getGroupNames() != null && !describeSecurityGroupsRequest.getGroupNames().equals(getGroupNames())) {
            return false;
        }
        if (((describeSecurityGroupsRequest.getGroupIds() == null ? 1 : 0) ^ (getGroupIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSecurityGroupsRequest.getGroupIds() != null && !describeSecurityGroupsRequest.getGroupIds().equals(getGroupIds())) {
            return false;
        }
        return ((describeSecurityGroupsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeSecurityGroupsRequest.getFilters() == null || describeSecurityGroupsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getGroupIds() {
        if (this.groupIds == null) {
            this.groupIds = new ArrayList();
        }
        return this.groupIds;
    }

    public List<String> getGroupNames() {
        if (this.groupNames == null) {
            this.groupNames = new ArrayList();
        }
        return this.groupNames;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGroupIds() == null ? 0 : getGroupIds().hashCode()) + (((getGroupNames() == null ? 0 : getGroupNames().hashCode()) + 31) * 31)) * 31;
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

    public void setGroupIds(Collection<String> collection) {
        if (collection == null) {
            this.groupIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.groupIds = arrayList;
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
        if (this.groupIds != null) {
            stringBuilder.append("GroupIds: " + this.groupIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSecurityGroupsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeSecurityGroupsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeSecurityGroupsRequest withGroupIds(Collection<String> collection) {
        if (collection == null) {
            this.groupIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groupIds = arrayList;
        }
        return this;
    }

    public DescribeSecurityGroupsRequest withGroupIds(String... strArr) {
        if (getGroupIds() == null) {
            setGroupIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroupIds().add(add);
        }
        return this;
    }

    public DescribeSecurityGroupsRequest withGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.groupNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.groupNames = arrayList;
        }
        return this;
    }

    public DescribeSecurityGroupsRequest withGroupNames(String... strArr) {
        if (getGroupNames() == null) {
            setGroupNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getGroupNames().add(add);
        }
        return this;
    }
}
