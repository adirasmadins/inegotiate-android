package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumeStatusRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private Integer maxResults;
    private String nextToken;
    private List<String> volumeIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumeStatusRequest)) {
            return false;
        }
        DescribeVolumeStatusRequest describeVolumeStatusRequest = (DescribeVolumeStatusRequest) obj;
        if (((describeVolumeStatusRequest.getVolumeIds() == null ? 1 : 0) ^ (getVolumeIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeStatusRequest.getVolumeIds() != null && !describeVolumeStatusRequest.getVolumeIds().equals(getVolumeIds())) {
            return false;
        }
        if (((describeVolumeStatusRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeStatusRequest.getFilters() != null && !describeVolumeStatusRequest.getFilters().equals(getFilters())) {
            return false;
        }
        if (((describeVolumeStatusRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeStatusRequest.getNextToken() != null && !describeVolumeStatusRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((describeVolumeStatusRequest.getMaxResults() == null ? 1 : 0) ^ (getMaxResults() == null ? 1 : 0)) == 0 ? describeVolumeStatusRequest.getMaxResults() == null || describeVolumeStatusRequest.getMaxResults().equals(getMaxResults()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<String> getVolumeIds() {
        if (this.volumeIds == null) {
            this.volumeIds = new ArrayList();
        }
        return this.volumeIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getFilters() == null ? 0 : getFilters().hashCode()) + (((getVolumeIds() == null ? 0 : getVolumeIds().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMaxResults() != null) {
            i = getMaxResults().hashCode();
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

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setVolumeIds(Collection<String> collection) {
        if (collection == null) {
            this.volumeIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.volumeIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeIds != null) {
            stringBuilder.append("VolumeIds: " + this.volumeIds + ", ");
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
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumeStatusRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeVolumeStatusRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeVolumeStatusRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public DescribeVolumeStatusRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeVolumeStatusRequest withVolumeIds(Collection<String> collection) {
        if (collection == null) {
            this.volumeIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.volumeIds = arrayList;
        }
        return this;
    }

    public DescribeVolumeStatusRequest withVolumeIds(String... strArr) {
        if (getVolumeIds() == null) {
            setVolumeIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getVolumeIds().add(add);
        }
        return this;
    }
}
