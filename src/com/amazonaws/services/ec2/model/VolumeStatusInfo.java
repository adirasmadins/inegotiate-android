package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VolumeStatusInfo {
    private List<VolumeStatusDetails> details;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeStatusInfo)) {
            return false;
        }
        VolumeStatusInfo volumeStatusInfo = (VolumeStatusInfo) obj;
        if (((volumeStatusInfo.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusInfo.getStatus() != null && !volumeStatusInfo.getStatus().equals(getStatus())) {
            return false;
        }
        return ((volumeStatusInfo.getDetails() == null ? 1 : 0) ^ (getDetails() == null ? 1 : 0)) == 0 ? volumeStatusInfo.getDetails() == null || volumeStatusInfo.getDetails().equals(getDetails()) : false;
    }

    public List<VolumeStatusDetails> getDetails() {
        if (this.details == null) {
            this.details = new ArrayList();
        }
        return this.details;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatus() == null ? 0 : getStatus().hashCode()) + 31) * 31;
        if (getDetails() != null) {
            i = getDetails().hashCode();
        }
        return hashCode + i;
    }

    public void setDetails(Collection<VolumeStatusDetails> collection) {
        if (collection == null) {
            this.details = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.details = arrayList;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.details != null) {
            stringBuilder.append("Details: " + this.details + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeStatusInfo withDetails(Collection<VolumeStatusDetails> collection) {
        if (collection == null) {
            this.details = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.details = arrayList;
        }
        return this;
    }

    public VolumeStatusInfo withDetails(VolumeStatusDetails... volumeStatusDetailsArr) {
        if (getDetails() == null) {
            setDetails(new ArrayList(volumeStatusDetailsArr.length));
        }
        for (Object add : volumeStatusDetailsArr) {
            getDetails().add(add);
        }
        return this;
    }

    public VolumeStatusInfo withStatus(String str) {
        this.status = str;
        return this;
    }
}
