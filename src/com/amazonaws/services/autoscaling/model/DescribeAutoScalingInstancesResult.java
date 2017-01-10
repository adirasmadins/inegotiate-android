package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAutoScalingInstancesResult {
    private List<AutoScalingInstanceDetails> autoScalingInstances;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAutoScalingInstancesResult)) {
            return false;
        }
        DescribeAutoScalingInstancesResult describeAutoScalingInstancesResult = (DescribeAutoScalingInstancesResult) obj;
        if (((describeAutoScalingInstancesResult.getAutoScalingInstances() == null ? 1 : 0) ^ (getAutoScalingInstances() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAutoScalingInstancesResult.getAutoScalingInstances() != null && !describeAutoScalingInstancesResult.getAutoScalingInstances().equals(getAutoScalingInstances())) {
            return false;
        }
        return ((describeAutoScalingInstancesResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAutoScalingInstancesResult.getNextToken() == null || describeAutoScalingInstancesResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<AutoScalingInstanceDetails> getAutoScalingInstances() {
        if (this.autoScalingInstances == null) {
            this.autoScalingInstances = new ArrayList();
        }
        return this.autoScalingInstances;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingInstances() == null ? 0 : getAutoScalingInstances().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingInstances(Collection<AutoScalingInstanceDetails> collection) {
        if (collection == null) {
            this.autoScalingInstances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.autoScalingInstances = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingInstances != null) {
            stringBuilder.append("AutoScalingInstances: " + this.autoScalingInstances + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAutoScalingInstancesResult withAutoScalingInstances(Collection<AutoScalingInstanceDetails> collection) {
        if (collection == null) {
            this.autoScalingInstances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.autoScalingInstances = arrayList;
        }
        return this;
    }

    public DescribeAutoScalingInstancesResult withAutoScalingInstances(AutoScalingInstanceDetails... autoScalingInstanceDetailsArr) {
        if (getAutoScalingInstances() == null) {
            setAutoScalingInstances(new ArrayList(autoScalingInstanceDetailsArr.length));
        }
        for (Object add : autoScalingInstanceDetailsArr) {
            getAutoScalingInstances().add(add);
        }
        return this;
    }

    public DescribeAutoScalingInstancesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
