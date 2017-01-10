package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MonitorInstancesResult {
    private List<InstanceMonitoring> instanceMonitorings;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MonitorInstancesResult)) {
            return false;
        }
        MonitorInstancesResult monitorInstancesResult = (MonitorInstancesResult) obj;
        return ((monitorInstancesResult.getInstanceMonitorings() == null ? 1 : 0) ^ (getInstanceMonitorings() == null ? 1 : 0)) == 0 ? monitorInstancesResult.getInstanceMonitorings() == null || monitorInstancesResult.getInstanceMonitorings().equals(getInstanceMonitorings()) : false;
    }

    public List<InstanceMonitoring> getInstanceMonitorings() {
        if (this.instanceMonitorings == null) {
            this.instanceMonitorings = new ArrayList();
        }
        return this.instanceMonitorings;
    }

    public int hashCode() {
        return (getInstanceMonitorings() == null ? 0 : getInstanceMonitorings().hashCode()) + 31;
    }

    public void setInstanceMonitorings(Collection<InstanceMonitoring> collection) {
        if (collection == null) {
            this.instanceMonitorings = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instanceMonitorings = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceMonitorings != null) {
            stringBuilder.append("InstanceMonitorings: " + this.instanceMonitorings + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public MonitorInstancesResult withInstanceMonitorings(Collection<InstanceMonitoring> collection) {
        if (collection == null) {
            this.instanceMonitorings = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instanceMonitorings = arrayList;
        }
        return this;
    }

    public MonitorInstancesResult withInstanceMonitorings(InstanceMonitoring... instanceMonitoringArr) {
        if (getInstanceMonitorings() == null) {
            setInstanceMonitorings(new ArrayList(instanceMonitoringArr.length));
        }
        for (Object add : instanceMonitoringArr) {
            getInstanceMonitorings().add(add);
        }
        return this;
    }
}
