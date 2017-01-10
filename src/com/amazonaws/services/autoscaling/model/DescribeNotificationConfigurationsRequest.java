package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeNotificationConfigurationsRequest extends AmazonWebServiceRequest {
    private List<String> autoScalingGroupNames;
    private Integer maxRecords;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeNotificationConfigurationsRequest)) {
            return false;
        }
        DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest = (DescribeNotificationConfigurationsRequest) obj;
        if (((describeNotificationConfigurationsRequest.getAutoScalingGroupNames() == null ? 1 : 0) ^ (getAutoScalingGroupNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeNotificationConfigurationsRequest.getAutoScalingGroupNames() != null && !describeNotificationConfigurationsRequest.getAutoScalingGroupNames().equals(getAutoScalingGroupNames())) {
            return false;
        }
        if (((describeNotificationConfigurationsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeNotificationConfigurationsRequest.getNextToken() != null && !describeNotificationConfigurationsRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((describeNotificationConfigurationsRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) == 0 ? describeNotificationConfigurationsRequest.getMaxRecords() == null || describeNotificationConfigurationsRequest.getMaxRecords().equals(getMaxRecords()) : false;
    }

    public List<String> getAutoScalingGroupNames() {
        if (this.autoScalingGroupNames == null) {
            this.autoScalingGroupNames = new ArrayList();
        }
        return this.autoScalingGroupNames;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getAutoScalingGroupNames() == null ? 0 : getAutoScalingGroupNames().hashCode()) + 31) * 31)) * 31;
        if (getMaxRecords() != null) {
            i = getMaxRecords().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.autoScalingGroupNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.autoScalingGroupNames = arrayList;
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
        if (this.autoScalingGroupNames != null) {
            stringBuilder.append("AutoScalingGroupNames: " + this.autoScalingGroupNames + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeNotificationConfigurationsRequest withAutoScalingGroupNames(Collection<String> collection) {
        if (collection == null) {
            this.autoScalingGroupNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.autoScalingGroupNames = arrayList;
        }
        return this;
    }

    public DescribeNotificationConfigurationsRequest withAutoScalingGroupNames(String... strArr) {
        if (getAutoScalingGroupNames() == null) {
            setAutoScalingGroupNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAutoScalingGroupNames().add(add);
        }
        return this;
    }

    public DescribeNotificationConfigurationsRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeNotificationConfigurationsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
