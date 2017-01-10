package com.amazonaws.services.sqs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteMessageBatchResult {
    private List<BatchResultErrorEntry> failed;
    private List<DeleteMessageBatchResultEntry> successful;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteMessageBatchResult)) {
            return false;
        }
        DeleteMessageBatchResult deleteMessageBatchResult = (DeleteMessageBatchResult) obj;
        if (((deleteMessageBatchResult.getSuccessful() == null ? 1 : 0) ^ (getSuccessful() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteMessageBatchResult.getSuccessful() != null && !deleteMessageBatchResult.getSuccessful().equals(getSuccessful())) {
            return false;
        }
        return ((deleteMessageBatchResult.getFailed() == null ? 1 : 0) ^ (getFailed() == null ? 1 : 0)) == 0 ? deleteMessageBatchResult.getFailed() == null || deleteMessageBatchResult.getFailed().equals(getFailed()) : false;
    }

    public List<BatchResultErrorEntry> getFailed() {
        if (this.failed == null) {
            this.failed = new ArrayList();
        }
        return this.failed;
    }

    public List<DeleteMessageBatchResultEntry> getSuccessful() {
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

    public void setSuccessful(Collection<DeleteMessageBatchResultEntry> collection) {
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

    public DeleteMessageBatchResult withFailed(Collection<BatchResultErrorEntry> collection) {
        if (collection == null) {
            this.failed = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.failed = arrayList;
        }
        return this;
    }

    public DeleteMessageBatchResult withFailed(BatchResultErrorEntry... batchResultErrorEntryArr) {
        if (getFailed() == null) {
            setFailed(new ArrayList(batchResultErrorEntryArr.length));
        }
        for (Object add : batchResultErrorEntryArr) {
            getFailed().add(add);
        }
        return this;
    }

    public DeleteMessageBatchResult withSuccessful(Collection<DeleteMessageBatchResultEntry> collection) {
        if (collection == null) {
            this.successful = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.successful = arrayList;
        }
        return this;
    }

    public DeleteMessageBatchResult withSuccessful(DeleteMessageBatchResultEntry... deleteMessageBatchResultEntryArr) {
        if (getSuccessful() == null) {
            setSuccessful(new ArrayList(deleteMessageBatchResultEntryArr.length));
        }
        for (Object add : deleteMessageBatchResultEntryArr) {
            getSuccessful().add(add);
        }
        return this;
    }
}
