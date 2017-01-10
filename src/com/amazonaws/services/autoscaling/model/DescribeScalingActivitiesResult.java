package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeScalingActivitiesResult {
    private List<Activity> activities;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeScalingActivitiesResult)) {
            return false;
        }
        DescribeScalingActivitiesResult describeScalingActivitiesResult = (DescribeScalingActivitiesResult) obj;
        if (((describeScalingActivitiesResult.getActivities() == null ? 1 : 0) ^ (getActivities() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScalingActivitiesResult.getActivities() != null && !describeScalingActivitiesResult.getActivities().equals(getActivities())) {
            return false;
        }
        return ((describeScalingActivitiesResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeScalingActivitiesResult.getNextToken() == null || describeScalingActivitiesResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<Activity> getActivities() {
        if (this.activities == null) {
            this.activities = new ArrayList();
        }
        return this.activities;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getActivities() == null ? 0 : getActivities().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setActivities(Collection<Activity> collection) {
        if (collection == null) {
            this.activities = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.activities = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.activities != null) {
            stringBuilder.append("Activities: " + this.activities + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeScalingActivitiesResult withActivities(Collection<Activity> collection) {
        if (collection == null) {
            this.activities = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.activities = arrayList;
        }
        return this;
    }

    public DescribeScalingActivitiesResult withActivities(Activity... activityArr) {
        if (getActivities() == null) {
            setActivities(new ArrayList(activityArr.length));
        }
        for (Object add : activityArr) {
            getActivities().add(add);
        }
        return this;
    }

    public DescribeScalingActivitiesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
