package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConversionTask {
    private String conversionTaskId;
    private String expirationTime;
    private ImportInstanceTaskDetails importInstance;
    private ImportVolumeTaskDetails importVolume;
    private String state;
    private String statusMessage;
    private List<Tag> tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConversionTask)) {
            return false;
        }
        ConversionTask conversionTask = (ConversionTask) obj;
        if (((conversionTask.getConversionTaskId() == null ? 1 : 0) ^ (getConversionTaskId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getConversionTaskId() != null && !conversionTask.getConversionTaskId().equals(getConversionTaskId())) {
            return false;
        }
        if (((conversionTask.getExpirationTime() == null ? 1 : 0) ^ (getExpirationTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getExpirationTime() != null && !conversionTask.getExpirationTime().equals(getExpirationTime())) {
            return false;
        }
        if (((conversionTask.getImportInstance() == null ? 1 : 0) ^ (getImportInstance() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getImportInstance() != null && !conversionTask.getImportInstance().equals(getImportInstance())) {
            return false;
        }
        if (((conversionTask.getImportVolume() == null ? 1 : 0) ^ (getImportVolume() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getImportVolume() != null && !conversionTask.getImportVolume().equals(getImportVolume())) {
            return false;
        }
        if (((conversionTask.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getState() != null && !conversionTask.getState().equals(getState())) {
            return false;
        }
        if (((conversionTask.getStatusMessage() == null ? 1 : 0) ^ (getStatusMessage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (conversionTask.getStatusMessage() != null && !conversionTask.getStatusMessage().equals(getStatusMessage())) {
            return false;
        }
        return ((conversionTask.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? conversionTask.getTags() == null || conversionTask.getTags().equals(getTags()) : false;
    }

    public String getConversionTaskId() {
        return this.conversionTaskId;
    }

    public String getExpirationTime() {
        return this.expirationTime;
    }

    public ImportInstanceTaskDetails getImportInstance() {
        return this.importInstance;
    }

    public ImportVolumeTaskDetails getImportVolume() {
        return this.importVolume;
    }

    public String getState() {
        return this.state;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatusMessage() == null ? 0 : getStatusMessage().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getImportVolume() == null ? 0 : getImportVolume().hashCode()) + (((getImportInstance() == null ? 0 : getImportInstance().hashCode()) + (((getExpirationTime() == null ? 0 : getExpirationTime().hashCode()) + (((getConversionTaskId() == null ? 0 : getConversionTaskId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
        }
        return hashCode + i;
    }

    public void setConversionTaskId(String str) {
        this.conversionTaskId = str;
    }

    public void setExpirationTime(String str) {
        this.expirationTime = str;
    }

    public void setImportInstance(ImportInstanceTaskDetails importInstanceTaskDetails) {
        this.importInstance = importInstanceTaskDetails;
    }

    public void setImportVolume(ImportVolumeTaskDetails importVolumeTaskDetails) {
        this.importVolume = importVolumeTaskDetails;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.conversionTaskId != null) {
            stringBuilder.append("ConversionTaskId: " + this.conversionTaskId + ", ");
        }
        if (this.expirationTime != null) {
            stringBuilder.append("ExpirationTime: " + this.expirationTime + ", ");
        }
        if (this.importInstance != null) {
            stringBuilder.append("ImportInstance: " + this.importInstance + ", ");
        }
        if (this.importVolume != null) {
            stringBuilder.append("ImportVolume: " + this.importVolume + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.statusMessage != null) {
            stringBuilder.append("StatusMessage: " + this.statusMessage + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConversionTask withConversionTaskId(String str) {
        this.conversionTaskId = str;
        return this;
    }

    public ConversionTask withExpirationTime(String str) {
        this.expirationTime = str;
        return this;
    }

    public ConversionTask withImportInstance(ImportInstanceTaskDetails importInstanceTaskDetails) {
        this.importInstance = importInstanceTaskDetails;
        return this;
    }

    public ConversionTask withImportVolume(ImportVolumeTaskDetails importVolumeTaskDetails) {
        this.importVolume = importVolumeTaskDetails;
        return this;
    }

    public ConversionTask withState(String str) {
        this.state = str;
        return this;
    }

    public ConversionTask withStatusMessage(String str) {
        this.statusMessage = str;
        return this;
    }

    public ConversionTask withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public ConversionTask withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }
}
