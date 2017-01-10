package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImportInstanceTaskDetails {
    private String description;
    private String instanceId;
    private String platform;
    private List<ImportInstanceVolumeDetailItem> volumes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportInstanceTaskDetails)) {
            return false;
        }
        ImportInstanceTaskDetails importInstanceTaskDetails = (ImportInstanceTaskDetails) obj;
        if (((importInstanceTaskDetails.getVolumes() == null ? 1 : 0) ^ (getVolumes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceTaskDetails.getVolumes() != null && !importInstanceTaskDetails.getVolumes().equals(getVolumes())) {
            return false;
        }
        if (((importInstanceTaskDetails.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceTaskDetails.getInstanceId() != null && !importInstanceTaskDetails.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((importInstanceTaskDetails.getPlatform() == null ? 1 : 0) ^ (getPlatform() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceTaskDetails.getPlatform() != null && !importInstanceTaskDetails.getPlatform().equals(getPlatform())) {
            return false;
        }
        return ((importInstanceTaskDetails.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) == 0 ? importInstanceTaskDetails.getDescription() == null || importInstanceTaskDetails.getDescription().equals(getDescription()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public List<ImportInstanceVolumeDetailItem> getVolumes() {
        if (this.volumes == null) {
            this.volumes = new ArrayList();
        }
        return this.volumes;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPlatform() == null ? 0 : getPlatform().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getVolumes() == null ? 0 : getVolumes().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setVolumes(Collection<ImportInstanceVolumeDetailItem> collection) {
        if (collection == null) {
            this.volumes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.volumes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumes != null) {
            stringBuilder.append("Volumes: " + this.volumes + ", ");
        }
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.platform != null) {
            stringBuilder.append("Platform: " + this.platform + ", ");
        }
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportInstanceTaskDetails withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImportInstanceTaskDetails withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public ImportInstanceTaskDetails withPlatform(String str) {
        this.platform = str;
        return this;
    }

    public ImportInstanceTaskDetails withVolumes(Collection<ImportInstanceVolumeDetailItem> collection) {
        if (collection == null) {
            this.volumes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.volumes = arrayList;
        }
        return this;
    }

    public ImportInstanceTaskDetails withVolumes(ImportInstanceVolumeDetailItem... importInstanceVolumeDetailItemArr) {
        if (getVolumes() == null) {
            setVolumes(new ArrayList(importInstanceVolumeDetailItemArr.length));
        }
        for (Object add : importInstanceVolumeDetailItemArr) {
            getVolumes().add(add);
        }
        return this;
    }
}
