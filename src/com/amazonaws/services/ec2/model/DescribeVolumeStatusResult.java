package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumeStatusResult {
    private String nextToken;
    private List<VolumeStatusItem> volumeStatuses;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeVolumeStatusResult)) {
            return false;
        }
        DescribeVolumeStatusResult describeVolumeStatusResult = (DescribeVolumeStatusResult) obj;
        if (((describeVolumeStatusResult.getVolumeStatuses() == null ? 1 : 0) ^ (getVolumeStatuses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeVolumeStatusResult.getVolumeStatuses() != null && !describeVolumeStatusResult.getVolumeStatuses().equals(getVolumeStatuses())) {
            return false;
        }
        return ((describeVolumeStatusResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeVolumeStatusResult.getNextToken() == null || describeVolumeStatusResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<VolumeStatusItem> getVolumeStatuses() {
        if (this.volumeStatuses == null) {
            this.volumeStatuses = new ArrayList();
        }
        return this.volumeStatuses;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVolumeStatuses() == null ? 0 : getVolumeStatuses().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setVolumeStatuses(Collection<VolumeStatusItem> collection) {
        if (collection == null) {
            this.volumeStatuses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.volumeStatuses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeStatuses != null) {
            stringBuilder.append("VolumeStatuses: " + this.volumeStatuses + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeVolumeStatusResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeVolumeStatusResult withVolumeStatuses(Collection<VolumeStatusItem> collection) {
        if (collection == null) {
            this.volumeStatuses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.volumeStatuses = arrayList;
        }
        return this;
    }

    public DescribeVolumeStatusResult withVolumeStatuses(VolumeStatusItem... volumeStatusItemArr) {
        if (getVolumeStatuses() == null) {
            setVolumeStatuses(new ArrayList(volumeStatusItemArr.length));
        }
        for (Object add : volumeStatusItemArr) {
            getVolumeStatuses().add(add);
        }
        return this;
    }
}
