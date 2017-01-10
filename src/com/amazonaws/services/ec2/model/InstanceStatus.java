package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InstanceStatus {
    private String availabilityZone;
    private List<InstanceStatusEvent> events;
    private String instanceId;
    private InstanceState instanceState;
    private InstanceStatusSummary instanceStatus;
    private InstanceStatusSummary systemStatus;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceStatus)) {
            return false;
        }
        InstanceStatus instanceStatus = (InstanceStatus) obj;
        if (((instanceStatus.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatus.getInstanceId() != null && !instanceStatus.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((instanceStatus.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatus.getAvailabilityZone() != null && !instanceStatus.getAvailabilityZone().equals(getAvailabilityZone())) {
            return false;
        }
        if (((instanceStatus.getEvents() == null ? 1 : 0) ^ (getEvents() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatus.getEvents() != null && !instanceStatus.getEvents().equals(getEvents())) {
            return false;
        }
        if (((instanceStatus.getInstanceState() == null ? 1 : 0) ^ (getInstanceState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatus.getInstanceState() != null && !instanceStatus.getInstanceState().equals(getInstanceState())) {
            return false;
        }
        if (((instanceStatus.getSystemStatus() == null ? 1 : 0) ^ (getSystemStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (instanceStatus.getSystemStatus() != null && !instanceStatus.getSystemStatus().equals(getSystemStatus())) {
            return false;
        }
        return ((instanceStatus.getInstanceStatus() == null ? 1 : 0) ^ (getInstanceStatus() == null ? 1 : 0)) == 0 ? instanceStatus.getInstanceStatus() == null || instanceStatus.getInstanceStatus().equals(getInstanceStatus()) : false;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public List<InstanceStatusEvent> getEvents() {
        if (this.events == null) {
            this.events = new ArrayList();
        }
        return this.events;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public InstanceState getInstanceState() {
        return this.instanceState;
    }

    public InstanceStatusSummary getInstanceStatus() {
        return this.instanceStatus;
    }

    public InstanceStatusSummary getSystemStatus() {
        return this.systemStatus;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSystemStatus() == null ? 0 : getSystemStatus().hashCode()) + (((getInstanceState() == null ? 0 : getInstanceState().hashCode()) + (((getEvents() == null ? 0 : getEvents().hashCode()) + (((getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getInstanceStatus() != null) {
            i = getInstanceStatus().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZone(String str) {
        this.availabilityZone = str;
    }

    public void setEvents(Collection<InstanceStatusEvent> collection) {
        if (collection == null) {
            this.events = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.events = arrayList;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setInstanceState(InstanceState instanceState) {
        this.instanceState = instanceState;
    }

    public void setInstanceStatus(InstanceStatusSummary instanceStatusSummary) {
        this.instanceStatus = instanceStatusSummary;
    }

    public void setSystemStatus(InstanceStatusSummary instanceStatusSummary) {
        this.systemStatus = instanceStatusSummary;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.availabilityZone != null) {
            stringBuilder.append("AvailabilityZone: " + this.availabilityZone + ", ");
        }
        if (this.events != null) {
            stringBuilder.append("Events: " + this.events + ", ");
        }
        if (this.instanceState != null) {
            stringBuilder.append("InstanceState: " + this.instanceState + ", ");
        }
        if (this.systemStatus != null) {
            stringBuilder.append("SystemStatus: " + this.systemStatus + ", ");
        }
        if (this.instanceStatus != null) {
            stringBuilder.append("InstanceStatus: " + this.instanceStatus + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public InstanceStatus withAvailabilityZone(String str) {
        this.availabilityZone = str;
        return this;
    }

    public InstanceStatus withEvents(Collection<InstanceStatusEvent> collection) {
        if (collection == null) {
            this.events = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.events = arrayList;
        }
        return this;
    }

    public InstanceStatus withEvents(InstanceStatusEvent... instanceStatusEventArr) {
        if (getEvents() == null) {
            setEvents(new ArrayList(instanceStatusEventArr.length));
        }
        for (Object add : instanceStatusEventArr) {
            getEvents().add(add);
        }
        return this;
    }

    public InstanceStatus withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public InstanceStatus withInstanceState(InstanceState instanceState) {
        this.instanceState = instanceState;
        return this;
    }

    public InstanceStatus withInstanceStatus(InstanceStatusSummary instanceStatusSummary) {
        this.instanceStatus = instanceStatusSummary;
        return this;
    }

    public InstanceStatus withSystemStatus(InstanceStatusSummary instanceStatusSummary) {
        this.systemStatus = instanceStatusSummary;
        return this;
    }
}
