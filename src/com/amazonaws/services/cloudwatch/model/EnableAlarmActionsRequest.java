package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnableAlarmActionsRequest extends AmazonWebServiceRequest {
    private List<String> alarmNames;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableAlarmActionsRequest)) {
            return false;
        }
        EnableAlarmActionsRequest enableAlarmActionsRequest = (EnableAlarmActionsRequest) obj;
        return ((enableAlarmActionsRequest.getAlarmNames() == null ? 1 : 0) ^ (getAlarmNames() == null ? 1 : 0)) == 0 ? enableAlarmActionsRequest.getAlarmNames() == null || enableAlarmActionsRequest.getAlarmNames().equals(getAlarmNames()) : false;
    }

    public List<String> getAlarmNames() {
        if (this.alarmNames == null) {
            this.alarmNames = new ArrayList();
        }
        return this.alarmNames;
    }

    public int hashCode() {
        return (getAlarmNames() == null ? 0 : getAlarmNames().hashCode()) + 31;
    }

    public void setAlarmNames(Collection<String> collection) {
        if (collection == null) {
            this.alarmNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.alarmNames = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmNames != null) {
            stringBuilder.append("AlarmNames: " + this.alarmNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EnableAlarmActionsRequest withAlarmNames(Collection<String> collection) {
        if (collection == null) {
            this.alarmNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarmNames = arrayList;
        }
        return this;
    }

    public EnableAlarmActionsRequest withAlarmNames(String... strArr) {
        if (getAlarmNames() == null) {
            setAlarmNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAlarmNames().add(add);
        }
        return this;
    }
}
