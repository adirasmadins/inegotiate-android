package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnableMetricsCollectionRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private String granularity;
    private List<String> metrics;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableMetricsCollectionRequest)) {
            return false;
        }
        EnableMetricsCollectionRequest enableMetricsCollectionRequest = (EnableMetricsCollectionRequest) obj;
        if (((enableMetricsCollectionRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (enableMetricsCollectionRequest.getAutoScalingGroupName() != null && !enableMetricsCollectionRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((enableMetricsCollectionRequest.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (enableMetricsCollectionRequest.getMetrics() != null && !enableMetricsCollectionRequest.getMetrics().equals(getMetrics())) {
            return false;
        }
        return ((enableMetricsCollectionRequest.getGranularity() == null ? 1 : 0) ^ (getGranularity() == null ? 1 : 0)) == 0 ? enableMetricsCollectionRequest.getGranularity() == null || enableMetricsCollectionRequest.getGranularity().equals(getGranularity()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public List<String> getMetrics() {
        if (this.metrics == null) {
            this.metrics = new ArrayList();
        }
        return this.metrics;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetrics() == null ? 0 : getMetrics().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31;
        if (getGranularity() != null) {
            i = getGranularity().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setGranularity(String str) {
        this.granularity = str;
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
        if (this.granularity != null) {
            stringBuilder.append("Granularity: " + this.granularity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EnableMetricsCollectionRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public EnableMetricsCollectionRequest withGranularity(String str) {
        this.granularity = str;
        return this;
    }

    public EnableMetricsCollectionRequest withMetrics(Collection<String> collection) {
        if (collection == null) {
            this.metrics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metrics = arrayList;
        }
        return this;
    }

    public EnableMetricsCollectionRequest withMetrics(String... strArr) {
        if (getMetrics() == null) {
            setMetrics(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getMetrics().add(add);
        }
        return this;
    }
}
