package com.amazonaws.services.ec2.model;

import java.util.Date;

public class BundleTask {
    private String bundleId;
    private BundleTaskError bundleTaskError;
    private String instanceId;
    private String progress;
    private Date startTime;
    private String state;
    private Storage storage;
    private Date updateTime;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BundleTask)) {
            return false;
        }
        BundleTask bundleTask = (BundleTask) obj;
        if (((bundleTask.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getInstanceId() != null && !bundleTask.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((bundleTask.getBundleId() == null ? 1 : 0) ^ (getBundleId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getBundleId() != null && !bundleTask.getBundleId().equals(getBundleId())) {
            return false;
        }
        if (((bundleTask.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getState() != null && !bundleTask.getState().equals(getState())) {
            return false;
        }
        if (((bundleTask.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getStartTime() != null && !bundleTask.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((bundleTask.getUpdateTime() == null ? 1 : 0) ^ (getUpdateTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getUpdateTime() != null && !bundleTask.getUpdateTime().equals(getUpdateTime())) {
            return false;
        }
        if (((bundleTask.getStorage() == null ? 1 : 0) ^ (getStorage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getStorage() != null && !bundleTask.getStorage().equals(getStorage())) {
            return false;
        }
        if (((bundleTask.getProgress() == null ? 1 : 0) ^ (getProgress() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (bundleTask.getProgress() != null && !bundleTask.getProgress().equals(getProgress())) {
            return false;
        }
        return ((bundleTask.getBundleTaskError() == null ? 1 : 0) ^ (getBundleTaskError() == null ? 1 : 0)) == 0 ? bundleTask.getBundleTaskError() == null || bundleTask.getBundleTaskError().equals(getBundleTaskError()) : false;
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public BundleTaskError getBundleTaskError() {
        return this.bundleTaskError;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getProgress() {
        return this.progress;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public String getState() {
        return this.state;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProgress() == null ? 0 : getProgress().hashCode()) + (((getStorage() == null ? 0 : getStorage().hashCode()) + (((getUpdateTime() == null ? 0 : getUpdateTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getBundleId() == null ? 0 : getBundleId().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getBundleTaskError() != null) {
            i = getBundleTaskError().hashCode();
        }
        return hashCode + i;
    }

    public void setBundleId(String str) {
        this.bundleId = str;
    }

    public void setBundleTaskError(BundleTaskError bundleTaskError) {
        this.bundleTaskError = bundleTaskError;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setProgress(String str) {
        this.progress = str;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setUpdateTime(Date date) {
        this.updateTime = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.bundleId != null) {
            stringBuilder.append("BundleId: " + this.bundleId + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.updateTime != null) {
            stringBuilder.append("UpdateTime: " + this.updateTime + ", ");
        }
        if (this.storage != null) {
            stringBuilder.append("Storage: " + this.storage + ", ");
        }
        if (this.progress != null) {
            stringBuilder.append("Progress: " + this.progress + ", ");
        }
        if (this.bundleTaskError != null) {
            stringBuilder.append("BundleTaskError: " + this.bundleTaskError + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public BundleTask withBundleId(String str) {
        this.bundleId = str;
        return this;
    }

    public BundleTask withBundleTaskError(BundleTaskError bundleTaskError) {
        this.bundleTaskError = bundleTaskError;
        return this;
    }

    public BundleTask withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public BundleTask withProgress(String str) {
        this.progress = str;
        return this;
    }

    public BundleTask withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public BundleTask withState(String str) {
        this.state = str;
        return this;
    }

    public BundleTask withStorage(Storage storage) {
        this.storage = storage;
        return this;
    }

    public BundleTask withUpdateTime(Date date) {
        this.updateTime = date;
        return this;
    }
}
