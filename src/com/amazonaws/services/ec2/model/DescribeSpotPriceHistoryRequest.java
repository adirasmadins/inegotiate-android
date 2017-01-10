package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DescribeSpotPriceHistoryRequest extends AmazonWebServiceRequest {
    private String availabilityZone;
    private Date endTime;
    private List<Filter> filters;
    private List<String> instanceTypes;
    private Integer maxResults;
    private String nextToken;
    private List<String> productDescriptions;
    private Date startTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSpotPriceHistoryRequest)) {
            return false;
        }
        DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest = (DescribeSpotPriceHistoryRequest) obj;
        if (((describeSpotPriceHistoryRequest.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getStartTime() != null && !describeSpotPriceHistoryRequest.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getEndTime() != null && !describeSpotPriceHistoryRequest.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getInstanceTypes() == null ? 1 : 0) ^ (getInstanceTypes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getInstanceTypes() != null && !describeSpotPriceHistoryRequest.getInstanceTypes().equals(getInstanceTypes())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getProductDescriptions() == null ? 1 : 0) ^ (getProductDescriptions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getProductDescriptions() != null && !describeSpotPriceHistoryRequest.getProductDescriptions().equals(getProductDescriptions())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getFilters() != null && !describeSpotPriceHistoryRequest.getFilters().equals(getFilters())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getAvailabilityZone() != null && !describeSpotPriceHistoryRequest.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((describeSpotPriceHistoryRequest.getMaxResults() == null ? 1 : 0) ^ (getMaxResults() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSpotPriceHistoryRequest.getMaxResults() != null && !describeSpotPriceHistoryRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        return ((describeSpotPriceHistoryRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeSpotPriceHistoryRequest.getNextToken() == null || describeSpotPriceHistoryRequest.getNextToken().equals(getNextToken()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getInstanceTypes() {
        if (this.instanceTypes == null) {
            this.instanceTypes = new ArrayList();
        }
        return this.instanceTypes;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<String> getProductDescriptions() {
        if (this.productDescriptions == null) {
            this.productDescriptions = new ArrayList();
        }
        return this.productDescriptions;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxResults() == null ? 0 : getMaxResults().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getFilters() == null ? 0 : getFilters().hashCode()) + (((getProductDescriptions() == null ? 0 : getProductDescriptions().hashCode()) + (((getInstanceTypes() == null ? 0 : getInstanceTypes().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
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

    public void setInstanceTypes(Collection<String> collection) {
        if (collection == null) {
            this.instanceTypes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceTypes = arrayList;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setProductDescriptions(Collection<String> collection) {
        if (collection == null) {
            this.productDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.productDescriptions = arrayList;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
        }
        if (this.instanceTypes != null) {
            stringBuilder.append("InstanceTypes: " + this.instanceTypes + ", ");
        }
        if (this.productDescriptions != null) {
            stringBuilder.append("ProductDescriptions: " + this.productDescriptions + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.maxResults != null) {
            stringBuilder.append("MaxResults: " + this.maxResults + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSpotPriceHistoryRequest withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public DescribeSpotPriceHistoryRequest withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public DescribeSpotPriceHistoryRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withInstanceTypes(Collection<String> collection) {
        if (collection == null) {
            this.instanceTypes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceTypes = arrayList;
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withInstanceTypes(String... strArr) {
        if (getInstanceTypes() == null) {
            setInstanceTypes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceTypes().add(add);
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public DescribeSpotPriceHistoryRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeSpotPriceHistoryRequest withProductDescriptions(Collection<String> collection) {
        if (collection == null) {
            this.productDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.productDescriptions = arrayList;
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withProductDescriptions(String... strArr) {
        if (getProductDescriptions() == null) {
            setProductDescriptions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getProductDescriptions().add(add);
        }
        return this;
    }

    public DescribeSpotPriceHistoryRequest withStartTime(Date date) {
        this.startTime = date;
        return this;
    }
}
