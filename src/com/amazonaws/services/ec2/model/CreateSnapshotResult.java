package com.amazonaws.services.ec2.model;

public class CreateSnapshotResult {
    private Snapshot snapshot;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateSnapshotResult)) {
            return false;
        }
        CreateSnapshotResult createSnapshotResult = (CreateSnapshotResult) obj;
        return ((createSnapshotResult.getSnapshot() == null ? 1 : 0) ^ (getSnapshot() == null ? 1 : 0)) == 0 ? createSnapshotResult.getSnapshot() == null || createSnapshotResult.getSnapshot().equals(getSnapshot()) : false;
    }

    public Snapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        return (getSnapshot() == null ? 0 : getSnapshot().hashCode()) + 31;
    }

    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.snapshot != null) {
            stringBuilder.append("Snapshot: " + this.snapshot + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateSnapshotResult withSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
        return this;
    }
}
