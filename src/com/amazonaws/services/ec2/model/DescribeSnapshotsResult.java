package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSnapshotsResult {
    private List<Snapshot> snapshots;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSnapshotsResult)) {
            return false;
        }
        DescribeSnapshotsResult describeSnapshotsResult = (DescribeSnapshotsResult) obj;
        return ((describeSnapshotsResult.getSnapshots() == null ? 1 : 0) ^ (getSnapshots() == null ? 1 : 0)) == 0 ? describeSnapshotsResult.getSnapshots() == null || describeSnapshotsResult.getSnapshots().equals(getSnapshots()) : false;
    }

    public List<Snapshot> getSnapshots() {
        if (this.snapshots == null) {
            this.snapshots = new ArrayList();
        }
        return this.snapshots;
    }

    public int hashCode() {
        return (getSnapshots() == null ? 0 : getSnapshots().hashCode()) + 31;
    }

    public void setSnapshots(Collection<Snapshot> collection) {
        if (collection == null) {
            this.snapshots = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.snapshots = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshots != null) {
            stringBuilder.append("Snapshots: " + this.snapshots + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSnapshotsResult withSnapshots(Collection<Snapshot> collection) {
        if (collection == null) {
            this.snapshots = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.snapshots = arrayList;
        }
        return this;
    }

    public DescribeSnapshotsResult withSnapshots(Snapshot... snapshotArr) {
        if (getSnapshots() == null) {
            setSnapshots(new ArrayList(snapshotArr.length));
        }
        for (Object add : snapshotArr) {
            getSnapshots().add(add);
        }
        return this;
    }
}
