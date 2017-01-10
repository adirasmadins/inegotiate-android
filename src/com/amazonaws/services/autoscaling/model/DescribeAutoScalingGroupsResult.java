package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAutoScalingGroupsResult {
    private List<AutoScalingGroup> autoScalingGroups;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAutoScalingGroupsResult)) {
            return false;
        }
        DescribeAutoScalingGroupsResult describeAutoScalingGroupsResult = (DescribeAutoScalingGroupsResult) obj;
        if (((describeAutoScalingGroupsResult.getAutoScalingGroups() == null ? 1 : 0) ^ (getAutoScalingGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAutoScalingGroupsResult.getAutoScalingGroups() != null && !describeAutoScalingGroupsResult.getAutoScalingGroups().equals(getAutoScalingGroups())) {
            return false;
        }
        return ((describeAutoScalingGroupsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAutoScalingGroupsResult.getNextToken() == null || describeAutoScalingGroupsResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<AutoScalingGroup> getAutoScalingGroups() {
        if (this.autoScalingGroups == null) {
            this.autoScalingGroups = new ArrayList();
        }
        return this.autoScalingGroups;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroups() == null ? 0 : getAutoScalingGroups().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroups(Collection<AutoScalingGroup> collection) {
        if (collection == null) {
            this.autoScalingGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.autoScalingGroups = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroups != null) {
            stringBuilder.append("AutoScalingGroups: " + this.autoScalingGroups + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAutoScalingGroupsResult withAutoScalingGroups(Collection<AutoScalingGroup> collection) {
        if (collection == null) {
            this.autoScalingGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.autoScalingGroups = arrayList;
        }
        return this;
    }

    public DescribeAutoScalingGroupsResult withAutoScalingGroups(AutoScalingGroup... autoScalingGroupArr) {
        if (getAutoScalingGroups() == null) {
            setAutoScalingGroups(new ArrayList(autoScalingGroupArr.length));
        }
        for (Object add : autoScalingGroupArr) {
            getAutoScalingGroups().add(add);
        }
        return this;
    }

    public DescribeAutoScalingGroupsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
