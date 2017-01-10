package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DisableMetricsCollectionRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private List<String> metrics;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DisableMetricsCollectionRequest)) {
            return false;
        }
        DisableMetricsCollectionRequest disableMetricsCollectionRequest = (DisableMetricsCollectionRequest) obj;
        if (((disableMetricsCollectionRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (disableMetricsCollectionRequest.getAutoScalingGroupName() != null && !disableMetricsCollectionRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        return ((disableMetricsCollectionRequest.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) == 0 ? disableMetricsCollectionRequest.getMetrics() == null || disableMetricsCollectionRequest.getMetrics().equals(getMetrics()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public List<String> getMetrics() {
        if (this.metrics == null) {
            this.metrics = new ArrayList();
        }
        return this.metrics;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31;
        if (getMetrics() != null) {
            i = getMetrics().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setMetrics(Collection<String> collection) {
        if (collection == null) {
            this.metrics = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.metrics = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.metrics != null) {
            stringBuilder.append("Metrics: " + this.metrics + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DisableMetricsCollectionRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public DisableMetricsCollectionRequest withMetrics(Collection<String> collection) {
        if (collection == null) {
            this.metrics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metrics = arrayList;
        }
        return this;
    }

    public DisableMetricsCollectionRequest withMetrics(String... strArr) {
        if (getMetrics() == null) {
            setMetrics(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getMetrics().add(add);
        }
        return this;
    }
}
