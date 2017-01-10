package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAutoScalingInstancesRequest extends AmazonWebServiceRequest {
    private List<String> instanceIds;
    private Integer maxRecords;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAutoScalingInstancesRequest)) {
            return false;
        }
        DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest = (DescribeAutoScalingInstancesRequest) obj;
        if (((describeAutoScalingInstancesRequest.getInstanceIds() == null ? 1 : 0) ^ (getInstanceIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAutoScalingInstancesRequest.getInstanceIds() != null && !describeAutoScalingInstancesRequest.getInstanceIds().equals(getInstanceIds())) {
            return false;
        }
        if (((describeAutoScalingInstancesRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAutoScalingInstancesRequest.getMaxRecords() != null && !describeAutoScalingInstancesRequest.getMaxRecords().equals(getMaxRecords())) {
            return false;
        }
        return ((describeAutoScalingInstancesRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAutoScalingInstancesRequest.getNextToken() == null || describeAutoScalingInstancesRequest.getNextToken().equals(getNextToken()) : false;
    }

    public List<String> getInstanceIds() {
        if (this.instanceIds == null) {
            this.instanceIds = new ArrayList();
        }
        return this.instanceIds;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxRecords() == null ? 0 : getMaxRecords().hashCode()) + (((getInstanceIds() == null ? 0 : getInstanceIds().hashCode()) + 31) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
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

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
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
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAutoScalingInstancesRequest withInstanceIds(Collection<String> collection) {
        if (collection == null) {
            this.instanceIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceIds = arrayList;
        }
        return this;
    }

    public DescribeAutoScalingInstancesRequest withInstanceIds(String... strArr) {
        if (getInstanceIds() == null) {
            setInstanceIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInstanceIds().add(add);
        }
        return this;
    }

    public DescribeAutoScalingInstancesRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeAutoScalingInstancesRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
