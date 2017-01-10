package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeInstanceStatusResult {
    private List<InstanceStatus> instanceStatuses;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceStatusResult)) {
            return false;
        }
        DescribeInstanceStatusResult describeInstanceStatusResult = (DescribeInstanceStatusResult) obj;
        if (((describeInstanceStatusResult.getInstanceStatuses() == null ? 1 : 0) ^ (getInstanceStatuses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeInstanceStatusResult.getInstanceStatuses() != null && !describeInstanceStatusResult.getInstanceStatuses().equals(getInstanceStatuses())) {
            return false;
        }
        return ((describeInstanceStatusResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeInstanceStatusResult.getNextToken() == null || describeInstanceStatusResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<InstanceStatus> getInstanceStatuses() {
        if (this.instanceStatuses == null) {
            this.instanceStatuses = new ArrayList();
        }
        return this.instanceStatuses;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getInstanceStatuses() == null ? 0 : getInstanceStatuses().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setInstanceStatuses(Collection<InstanceStatus> collection) {
        if (collection == null) {
            this.instanceStatuses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceStatuses = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceStatuses != null) {
            stringBuilder.append("InstanceStatuses: " + this.instanceStatuses + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceStatusResult withInstanceStatuses(Collection<InstanceStatus> collection) {
        if (collection == null) {
            this.instanceStatuses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceStatuses = arrayList;
        }
        return this;
    }

    public DescribeInstanceStatusResult withInstanceStatuses(InstanceStatus... instanceStatusArr) {
        if (getInstanceStatuses() == null) {
            setInstanceStatuses(new ArrayList(instanceStatusArr.length));
        }
        for (Object add : instanceStatusArr) {
            getInstanceStatuses().add(add);
        }
        return this;
    }

    public DescribeInstanceStatusResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
