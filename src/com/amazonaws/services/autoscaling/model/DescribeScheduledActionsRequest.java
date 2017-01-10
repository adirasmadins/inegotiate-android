package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DescribeScheduledActionsRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private Date endTime;
    private Integer maxRecords;
    private String nextToken;
    private List<String> scheduledActionNames;
    private Date startTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeScheduledActionsRequest)) {
            return false;
        }
        DescribeScheduledActionsRequest describeScheduledActionsRequest = (DescribeScheduledActionsRequest) obj;
        if (((describeScheduledActionsRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsRequest.getAutoScalingGroupName() != null && !describeScheduledActionsRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((describeScheduledActionsRequest.getScheduledActionNames() == null ? 1 : 0) ^ (getScheduledActionNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsRequest.getScheduledActionNames() != null && !describeScheduledActionsRequest.getScheduledActionNames().equals(getScheduledActionNames())) {
            return false;
        }
        if (((describeScheduledActionsRequest.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsRequest.getStartTime() != null && !describeScheduledActionsRequest.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((describeScheduledActionsRequest.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsRequest.getEndTime() != null && !describeScheduledActionsRequest.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((describeScheduledActionsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsRequest.getNextToken() != null && !describeScheduledActionsRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((describeScheduledActionsRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) == 0 ? describeScheduledActionsRequest.getMaxRecords() == null || describeScheduledActionsRequest.getMaxRecords().equals(getMaxRecords()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<String> getScheduledActionNames() {
        if (this.scheduledActionNames == null) {
            this.scheduledActionNames = new ArrayList();
        }
        return this.scheduledActionNames;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getScheduledActionNames() == null ? 0 : getScheduledActionNames().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getMaxRecords() != null) {
            i = getMaxRecords().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setScheduledActionNames(Collection<String> collection) {
        if (collection == null) {
            this.scheduledActionNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.scheduledActionNames = arrayList;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.scheduledActionNames != null) {
            stringBuilder.append("ScheduledActionNames: " + this.scheduledActionNames + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
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

    public DescribeScheduledActionsRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DescribeScheduledActionsRequest withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public DescribeScheduledActionsRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeScheduledActionsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeScheduledActionsRequest withScheduledActionNames(Collection<String> collection) {
        if (collection == null) {
            this.scheduledActionNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.scheduledActionNames = arrayList;
        }
        return this;
    }

    public DescribeScheduledActionsRequest withScheduledActionNames(String... strArr) {
        if (getScheduledActionNames() == null) {
            setScheduledActionNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getScheduledActionNames().add(add);
        }
        return this;
    }

    public DescribeScheduledActionsRequest withStartTime(Date date) {
        this.startTime = date;
        return this;
    }
}
