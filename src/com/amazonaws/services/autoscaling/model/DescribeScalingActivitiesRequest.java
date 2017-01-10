package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeScalingActivitiesRequest extends AmazonWebServiceRequest {
    private List<String> activityIds;
    private String autoScalingGroupName;
    private Integer maxRecords;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeScalingActivitiesRequest)) {
            return false;
        }
        DescribeScalingActivitiesRequest describeScalingActivitiesRequest = (DescribeScalingActivitiesRequest) obj;
        if (((describeScalingActivitiesRequest.getActivityIds() == null ? 1 : 0) ^ (getActivityIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScalingActivitiesRequest.getActivityIds() != null && !describeScalingActivitiesRequest.getActivityIds().equals(getActivityIds())) {
            return false;
        }
        if (((describeScalingActivitiesRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScalingActivitiesRequest.getAutoScalingGroupName() != null && !describeScalingActivitiesRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((describeScalingActivitiesRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScalingActivitiesRequest.getMaxRecords() != null && !describeScalingActivitiesRequest.getMaxRecords().equals(getMaxRecords())) {
            return false;
        }
        return ((describeScalingActivitiesRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeScalingActivitiesRequest.getNextToken() == null || describeScalingActivitiesRequest.getNextToken().equals(getNextToken()) : false;
    }

    public List<String> getActivityIds() {
        if (this.activityIds == null) {
            this.activityIds = new ArrayList();
        }
        return this.activityIds;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxRecords() == null ? 0 : getMaxRecords().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + (((getActivityIds() == null ? 0 : getActivityIds().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setActivityIds(Collection<String> collection) {
        if (collection == null) {
            this.activityIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.activityIds = arrayList;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
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
        if (this.activityIds != null) {
            stringBuilder.append("ActivityIds: " + this.activityIds + ", ");
        }
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
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

    public DescribeScalingActivitiesRequest withActivityIds(Collection<String> collection) {
        if (collection == null) {
            this.activityIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.activityIds = arrayList;
        }
        return this;
    }

    public DescribeScalingActivitiesRequest withActivityIds(String... strArr) {
        if (getActivityIds() == null) {
            setActivityIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getActivityIds().add(add);
        }
        return this;
    }

    public DescribeScalingActivitiesRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DescribeScalingActivitiesRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeScalingActivitiesRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
