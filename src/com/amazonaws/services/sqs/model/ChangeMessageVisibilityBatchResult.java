package com.amazonaws.services.sqs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChangeMessageVisibilityBatchResult {
    private List<BatchResultErrorEntry> failed;
    private List<ChangeMessageVisibilityBatchResultEntry> successful;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangeMessageVisibilityBatchResult)) {
            return false;
        }
        ChangeMessageVisibilityBatchResult changeMessageVisibilityBatchResult = (ChangeMessageVisibilityBatchResult) obj;
        if (((changeMessageVisibilityBatchResult.getSuccessful() == null ? 1 : 0) ^ (getSuccessful() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (changeMessageVisibilityBatchResult.getSuccessful() != null && !changeMessageVisibilityBatchResult.getSuccessful().equals(getSuccessful())) {
            return false;
        }
        return ((changeMessageVisibilityBatchResult.getFailed() == null ? 1 : 0) ^ (getFailed() == null ? 1 : 0)) == 0 ? changeMessageVisibilityBatchResult.getFailed() == null || changeMessageVisibilityBatchResult.getFailed().equals(getFailed()) : false;
    }

    public List<BatchResultErrorEntry> getFailed() {
        if (this.failed == null) {
            this.failed = new ArrayList();
        }
        return this.failed;
    }

    public List<ChangeMessageVisibilityBatchResultEntry> getSuccessful() {
        if (this.successful == null) {
            this.successful = new ArrayList();
        }
        return this.successful;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSuccessful() == null ? 0 : getSuccessful().hashCode()) + 31) * 31;
        if (getFailed() != null) {
            i = getFailed().hashCode();
        }
        return hashCode + i;
    }

    public void setFailed(Collection<BatchResultErrorEntry> collection) {
        if (collection == null) {
            this.failed = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.failed = arrayList;
    }

    public void setSuccessful(Collection<ChangeMessageVisibilityBatchResultEntry> collection) {
        if (collection == null) {
            this.successful = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.successful = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.successful != null) {
            stringBuilder.append("Successful: " + this.successful + ", ");
        }
        if (this.failed != null) {
            stringBuilder.append("Failed: " + this.failed + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ChangeMessageVisibilityBatchResult withFailed(Collection<BatchResultErrorEntry> collection) {
        if (collection == null) {
            this.failed = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.failed = arrayList;
        }
        return this;
    }

    public ChangeMessageVisibilityBatchResult withFailed(BatchResultErrorEntry... batchResultErrorEntryArr) {
        if (getFailed() == null) {
            setFailed(new ArrayList(batchResultErrorEntryArr.length));
        }
        for (Object add : batchResultErrorEntryArr) {
            getFailed().add(add);
        }
        return this;
    }

    public ChangeMessageVisibilityBatchResult withSuccessful(Collection<ChangeMessageVisibilityBatchResultEntry> collection) {
        if (collection == null) {
            this.successful = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.successful = arrayList;
        }
        return this;
    }

    public ChangeMessageVisibilityBatchResult withSuccessful(ChangeMessageVisibilityBatchResultEntry... changeMessageVisibilityBatchResultEntryArr) {
        if (getSuccessful() == null) {
            setSuccessful(new ArrayList(changeMessageVisibilityBatchResultEntryArr.length));
        }
        for (Object add : changeMessageVisibilityBatchResultEntryArr) {
            getSuccessful().add(add);
        }
        return this;
    }
}
