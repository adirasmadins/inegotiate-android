package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSnapshotsRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> ownerIds;
    private List<String> restorableByUserIds;
    private List<String> snapshotIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSnapshotsRequest)) {
            return false;
        }
        DescribeSnapshotsRequest describeSnapshotsRequest = (DescribeSnapshotsRequest) obj;
        if (((describeSnapshotsRequest.getSnapshotIds() == null ? 1 : 0) ^ (getSnapshotIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotsRequest.getSnapshotIds() != null && !describeSnapshotsRequest.getSnapshotIds().equals(getSnapshotIds())) {
            return false;
        }
        if (((describeSnapshotsRequest.getOwnerIds() == null ? 1 : 0) ^ (getOwnerIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotsRequest.getOwnerIds() != null && !describeSnapshotsRequest.getOwnerIds().equals(getOwnerIds())) {
            return false;
        }
        if (((describeSnapshotsRequest.getRestorableByUserIds() == null ? 1 : 0) ^ (getRestorableByUserIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeSnapshotsRequest.getRestorableByUserIds() != null && !describeSnapshotsRequest.getRestorableByUserIds().equals(getRestorableByUserIds())) {
            return false;
        }
        return ((describeSnapshotsRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeSnapshotsRequest.getFilters() == null || describeSnapshotsRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getOwnerIds() {
        if (this.ownerIds == null) {
            this.ownerIds = new ArrayList();
        }
        return this.ownerIds;
    }

    public List<String> getRestorableByUserIds() {
        if (this.restorableByUserIds == null) {
            this.restorableByUserIds = new ArrayList();
        }
        return this.restorableByUserIds;
    }

    public List<String> getSnapshotIds() {
        if (this.snapshotIds == null) {
            this.snapshotIds = new ArrayList();
        }
        return this.snapshotIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRestorableByUserIds() == null ? 0 : getRestorableByUserIds().hashCode()) + (((getOwnerIds() == null ? 0 : getOwnerIds().hashCode()) + (((getSnapshotIds() == null ? 0 : getSnapshotIds().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
        }
        return hashCode + i;
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

    public void setOwnerIds(Collection<String> collection) {
        if (collection == null) {
            this.ownerIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ownerIds = arrayList;
    }

    public void setRestorableByUserIds(Collection<String> collection) {
        if (collection == null) {
            this.restorableByUserIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.restorableByUserIds = arrayList;
    }

    public void setSnapshotIds(Collection<String> collection) {
        if (collection == null) {
            this.snapshotIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.snapshotIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshotIds != null) {
            stringBuilder.append("SnapshotIds: " + this.snapshotIds + ", ");
        }
        if (this.ownerIds != null) {
            stringBuilder.append("OwnerIds: " + this.ownerIds + ", ");
        }
        if (this.restorableByUserIds != null) {
            stringBuilder.append("RestorableByUserIds: " + this.restorableByUserIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSnapshotsRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeSnapshotsRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeSnapshotsRequest withOwnerIds(Collection<String> collection) {
        if (collection == null) {
            this.ownerIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ownerIds = arrayList;
        }
        return this;
    }

    public DescribeSnapshotsRequest withOwnerIds(String... strArr) {
        if (getOwnerIds() == null) {
            setOwnerIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getOwnerIds().add(add);
        }
        return this;
    }

    public DescribeSnapshotsRequest withRestorableByUserIds(Collection<String> collection) {
        if (collection == null) {
            this.restorableByUserIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.restorableByUserIds = arrayList;
        }
        return this;
    }

    public DescribeSnapshotsRequest withRestorableByUserIds(String... strArr) {
        if (getRestorableByUserIds() == null) {
            setRestorableByUserIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getRestorableByUserIds().add(add);
        }
        return this;
    }

    public DescribeSnapshotsRequest withSnapshotIds(Collection<String> collection) {
        if (collection == null) {
            this.snapshotIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.snapshotIds = arrayList;
        }
        return this;
    }

    public DescribeSnapshotsRequest withSnapshotIds(String... strArr) {
        if (getSnapshotIds() == null) {
            setSnapshotIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSnapshotIds().add(add);
        }
        return this;
    }
}
