package com.amazonaws.services.ec2.model;

public class BundleInstanceResult {
    private BundleTask bundleTask;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BundleInstanceResult)) {
            return false;
        }
        BundleInstanceResult bundleInstanceResult = (BundleInstanceResult) obj;
        return ((bundleInstanceResult.getBundleTask() == null ? 1 : 0) ^ (getBundleTask() == null ? 1 : 0)) == 0 ? bundleInstanceResult.getBundleTask() == null || bundleInstanceResult.getBundleTask().equals(getBundleTask()) : false;
    }

    public BundleTask getBundleTask() {
        return this.bundleTask;
    }

    public int hashCode() {
        return (getBundleTask() == null ? 0 : getBundleTask().hashCode()) + 31;
    }

    public void setBundleTask(BundleTask bundleTask) {
        this.bundleTask = bundleTask;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.bundleTask != null) {
            stringBuilder.append("BundleTask: " + this.bundleTask + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BundleInstanceResult withBundleTask(BundleTask bundleTask) {
        this.bundleTask = bundleTask;
        return this;
    }
}
