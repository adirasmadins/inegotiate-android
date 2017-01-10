package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VolumeStatusItem {
    private List<VolumeStatusAction> actions;
    private String availabilityZone;
    private List<VolumeStatusEvent> events;
    private String volumeId;
    private VolumeStatusInfo volumeStatus;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VolumeStatusItem)) {
            return false;
        }
        VolumeStatusItem volumeStatusItem = (VolumeStatusItem) obj;
        if (((volumeStatusItem.getVolumeId() == null ? 1 : 0) ^ (getVolumeId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusItem.getVolumeId() != null && !volumeStatusItem.getVolumeId().equals(getVolumeId())) {
            return false;
        }
        if (((volumeStatusItem.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusItem.getAvailabilityZone() != null && !volumeStatusItem.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((volumeStatusItem.getVolumeStatus() == null ? 1 : 0) ^ (getVolumeStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusItem.getVolumeStatus() != null && !volumeStatusItem.getVolumeStatus().equals(getVolumeStatus())) {
            return false;
        }
        if (((volumeStatusItem.getEvents() == null ? 1 : 0) ^ (getEvents() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (volumeStatusItem.getEvents() != null && !volumeStatusItem.getEvents().equals(getEvents())) {
            return false;
        }
        return ((volumeStatusItem.getActions() == null ? 1 : 0) ^ (getActions() == null ? 1 : 0)) == 0 ? volumeStatusItem.getActions() == null || volumeStatusItem.getActions().equals(getActions()) : false;
    }

    public List<VolumeStatusAction> getActions() {
        if (this.actions == null) {
            this.actions = new ArrayList();
        }
        return this.actions;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public List<VolumeStatusEvent> getEvents() {
        if (this.events == null) {
            this.events = new ArrayList();
        }
        return this.events;
    }

    public String getVolumeId() {
        return this.volumeId;
    }

    public VolumeStatusInfo getVolumeStatus() {
        return this.volumeStatus;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getEvents() == null ? 0 : getEvents().hashCode()) + (((getVolumeStatus() == null ? 0 : getVolumeStatus().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getVolumeId() == null ? 0 : getVolumeId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getActions() != null) {
            i = getActions().hashCode();
        }
        return hashCode + i;
    }

    public void setActions(Collection<VolumeStatusAction> collection) {
        if (collection == null) {
            this.actions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.actions = arrayList;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setEvents(Collection<VolumeStatusEvent> collection) {
        if (collection == null) {
            this.events = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.events = arrayList;
    }

    public void setVolumeId(String str) {
        this.volumeId = str;
    }

    public void setVolumeStatus(VolumeStatusInfo volumeStatusInfo) {
        this.volumeStatus = volumeStatusInfo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.volumeId != null) {
            stringBuilder.append("VolumeId: " + this.volumeId + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.volumeStatus != null) {
            stringBuilder.append("VolumeStatus: " + this.volumeStatus + ", ");
        }
        if (this.events != null) {
            stringBuilder.append("Events: " + this.events + ", ");
        }
        if (this.actions != null) {
            stringBuilder.append("Actions: " + this.actions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public VolumeStatusItem withActions(Collection<VolumeStatusAction> collection) {
        if (collection == null) {
            this.actions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.actions = arrayList;
        }
        return this;
    }

    public VolumeStatusItem withActions(VolumeStatusAction... volumeStatusActionArr) {
        if (getActions() == null) {
            setActions(new ArrayList(volumeStatusActionArr.length));
        }
        for (Object add : volumeStatusActionArr) {
            getActions().add(add);
        }
        return this;
    }

    public VolumeStatusItem withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public VolumeStatusItem withEvents(Collection<VolumeStatusEvent> collection) {
        if (collection == null) {
            this.events = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.events = arrayList;
        }
        return this;
    }

    public VolumeStatusItem withEvents(VolumeStatusEvent... volumeStatusEventArr) {
        if (getEvents() == null) {
            setEvents(new ArrayList(volumeStatusEventArr.length));
        }
        for (Object add : volumeStatusEventArr) {
            getEvents().add(add);
        }
        return this;
    }

    public VolumeStatusItem withVolumeId(String str) {
        this.volumeId = str;
        return this;
    }

    public VolumeStatusItem withVolumeStatus(VolumeStatusInfo volumeStatusInfo) {
        this.volumeStatus = volumeStatusInfo;
        return this;
    }
}
