package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeBundleTasksResult {
    private List<BundleTask> bundleTasks;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeBundleTasksResult)) {
            return false;
        }
        DescribeBundleTasksResult describeBundleTasksResult = (DescribeBundleTasksResult) obj;
        return ((describeBundleTasksResult.getBundleTasks() == null ? 1 : 0) ^ (getBundleTasks() == null ? 1 : 0)) == 0 ? describeBundleTasksResult.getBundleTasks() == null || describeBundleTasksResult.getBundleTasks().equals(getBundleTasks()) : false;
    }

    public List<BundleTask> getBundleTasks() {
        if (this.bundleTasks == null) {
            this.bundleTasks = new ArrayList();
        }
        return this.bundleTasks;
    }

    public int hashCode() {
        return (getBundleTasks() == null ? 0 : getBundleTasks().hashCode()) + 31;
    }

    public void setBundleTasks(Collection<BundleTask> collection) {
        if (collection == null) {
            this.bundleTasks = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.bundleTasks = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bundleTasks != null) {
            stringBuilder.append("BundleTasks: " + this.bundleTasks + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeBundleTasksResult withBundleTasks(Collection<BundleTask> collection) {
        if (collection == null) {
            this.bundleTasks = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.bundleTasks = arrayList;
        }
        return this;
    }

    public DescribeBundleTasksResult withBundleTasks(BundleTask... bundleTaskArr) {
        if (getBundleTasks() == null) {
            setBundleTasks(new ArrayList(bundleTaskArr.length));
        }
        for (Object add : bundleTaskArr) {
            getBundleTasks().add(add);
        }
        return this;
    }
}
