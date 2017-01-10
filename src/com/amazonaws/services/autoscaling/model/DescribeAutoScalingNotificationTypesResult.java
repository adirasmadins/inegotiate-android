package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAutoScalingNotificationTypesResult {
    private List<String> autoScalingNotificationTypes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAutoScalingNotificationTypesResult)) {
            return false;
        }
        DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypesResult = (DescribeAutoScalingNotificationTypesResult) obj;
        return ((describeAutoScalingNotificationTypesResult.getAutoScalingNotificationTypes() == null ? 1 : 0) ^ (getAutoScalingNotificationTypes() == null ? 1 : 0)) == 0 ? describeAutoScalingNotificationTypesResult.getAutoScalingNotificationTypes() == null || describeAutoScalingNotificationTypesResult.getAutoScalingNotificationTypes().equals(getAutoScalingNotificationTypes()) : false;
    }

    public List<String> getAutoScalingNotificationTypes() {
        if (this.autoScalingNotificationTypes == null) {
            this.autoScalingNotificationTypes = new ArrayList();
        }
        return this.autoScalingNotificationTypes;
    }

    public int hashCode() {
        return (getAutoScalingNotificationTypes() == null ? 0 : getAutoScalingNotificationTypes().hashCode()) + 31;
    }

    public void setAutoScalingNotificationTypes(Collection<String> collection) {
        if (collection == null) {
            this.autoScalingNotificationTypes = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.autoScalingNotificationTypes = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingNotificationTypes != null) {
            stringBuilder.append("AutoScalingNotificationTypes: " + this.autoScalingNotificationTypes + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAutoScalingNotificationTypesResult withAutoScalingNotificationTypes(Collection<String> collection) {
        if (collection == null) {
            this.autoScalingNotificationTypes = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.autoScalingNotificationTypes = arrayList;
        }
        return this;
    }

    public DescribeAutoScalingNotificationTypesResult withAutoScalingNotificationTypes(String... strArr) {
        if (getAutoScalingNotificationTypes() == null) {
            setAutoScalingNotificationTypes(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAutoScalingNotificationTypes().add(add);
        }
        return this;
    }
}
