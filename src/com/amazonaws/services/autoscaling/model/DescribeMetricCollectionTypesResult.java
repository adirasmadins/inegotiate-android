package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeMetricCollectionTypesResult {
    private List<MetricGranularityType> granularities;
    private List<MetricCollectionType> metrics;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeMetricCollectionTypesResult)) {
            return false;
        }
        DescribeMetricCollectionTypesResult describeMetricCollectionTypesResult = (DescribeMetricCollectionTypesResult) obj;
        if (((describeMetricCollectionTypesResult.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeMetricCollectionTypesResult.getMetrics() != null && !describeMetricCollectionTypesResult.getMetrics().equals(getMetrics())) {
            return false;
        }
        return ((describeMetricCollectionTypesResult.getGranularities() == null ? 1 : 0) ^ (getGranularities() == null ? 1 : 0)) == 0 ? describeMetricCollectionTypesResult.getGranularities() == null || describeMetricCollectionTypesResult.getGranularities().equals(getGranularities()) : false;
    }

    public List<MetricGranularityType> getGranularities() {
        if (this.granularities == null) {
            this.granularities = new ArrayList();
        }
        return this.granularities;
    }

    public List<MetricCollectionType> getMetrics() {
        if (this.metrics == null) {
            this.metrics = new ArrayList();
        }
        return this.metrics;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetrics() == null ? 0 : getMetrics().hashCode()) + 31) * 31;
        if (getGranularities() != null) {
            i = getGranularities().hashCode();
        }
        return hashCode + i;
    }

    public void setGranularities(Collection<MetricGranularityType> collection) {
        if (collection == null) {
            this.granularities = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.granularities = arrayList;
    }

    public void setMetrics(Collection<MetricCollectionType> collection) {
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
        if (this.metrics != null) {
            stringBuilder.append("Metrics: " + this.metrics + ", ");
        }
        if (this.granularities != null) {
            stringBuilder.append("Granularities: " + this.granularities + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeMetricCollectionTypesResult withGranularities(Collection<MetricGranularityType> collection) {
        if (collection == null) {
            this.granularities = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.granularities = arrayList;
        }
        return this;
    }

    public DescribeMetricCollectionTypesResult withGranularities(MetricGranularityType... metricGranularityTypeArr) {
        if (getGranularities() == null) {
            setGranularities(new ArrayList(metricGranularityTypeArr.length));
        }
        for (Object add : metricGranularityTypeArr) {
            getGranularities().add(add);
        }
        return this;
    }

    public DescribeMetricCollectionTypesResult withMetrics(Collection<MetricCollectionType> collection) {
        if (collection == null) {
            this.metrics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metrics = arrayList;
        }
        return this;
    }

    public DescribeMetricCollectionTypesResult withMetrics(MetricCollectionType... metricCollectionTypeArr) {
        if (getMetrics() == null) {
            setMetrics(new ArrayList(metricCollectionTypeArr.length));
        }
        for (Object add : metricCollectionTypeArr) {
            getMetrics().add(add);
        }
        return this;
    }
}
