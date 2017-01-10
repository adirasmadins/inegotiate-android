package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeInstanceStatusRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private Boolean includeAllInstances;
    private List<String> instanceIds;
    private Integer maxResults;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceStatusRequest)) {
            return false;
        }
        DescribeInstanceStatusRequest describeInstanceStatusRequest = (DescribeInstanceStatusRequest) obj;
        if (((describeInstanceStatusRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceStatusRequest.getInstanceIds() != null && !describeInstanceStatusRequest.getInstanceIds().equals(getInstanceIds())) {
            return false;
        }
        if (((describeInstanceStatusRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceStatusRequest.getFilters() != null && !describeInstanceStatusRequest.getFilters().equals(getFilters())) {
            return false;
        }
        if (((describeInstanceStatusRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceStatusRequest.getNextToken() != null && !describeInstanceStatusRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        if (((describeInstanceStatusRequest.getMaxResults() == null ? 1 : 0) ^ (getMaxResults() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceStatusRequest.getMaxResults() != null && !describeInstanceStatusRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        return ((describeInstanceStatusRequest.isIncludeAllInstances() == null ? 1 : 0) ^ (isIncludeAllInstances() == null ? 1 : 0)) == 0 ? describeInstanceStatusRequest.isIncludeAllInstances() == null || describeInstanceStatusRequest.isIncludeAllInstances().equals(isIncludeAllInstances()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public Boolean getIncludeAllInstances() {
        return this.includeAllInstances;
    }

    public List<String> getInstanceIds() {
        if (this.instanceIds == null) {
            this.instanceIds = new ArrayList();
        }
        return this.instanceIds;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxResults() == null ? 0 : getMaxResults().hashCode()) + (((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getFilters() == null ? 0 : getFilters().hashCode()) + (((getInstanceIds() == null ? 0 : getInstanceIds().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (isIncludeAllInstances() != null) {
            i = isIncludeAllInstances().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isIncludeAllInstances() {
        return this.includeAllInstances;
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

    public void setIncludeAllInstances(Boolean bool) {
        this.includeAllInstances = bool;
    }

    public void setInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceIds = arrayList;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceIds != null) {
            stringBuilder.append("InstanceIds: " + this.instanceIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.maxResults != null) {
            stringBuilder.append("MaxResults: " + this.maxResults + ", ");
        }
        if (this.includeAllInstances != null) {
            stringBuilder.append("IncludeAllInstances: " + this.includeAllInstances + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceStatusRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeInstanceStatusRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeInstanceStatusRequest withIncludeAllInstances(Boolean bool) {
        this.includeAllInstances = bool;
        return this;
    }

    public DescribeInstanceStatusRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public DescribeInstanceStatusRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }

    public DescribeInstanceStatusRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public DescribeInstanceStatusRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
