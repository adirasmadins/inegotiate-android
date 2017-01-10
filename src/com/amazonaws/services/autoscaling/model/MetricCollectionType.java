package com.amazonaws.services.autoscaling.model;

public class MetricCollectionType {
    private String metric;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MetricCollectionType)) {
            return false;
        }
        MetricCollectionType metricCollectionType = (MetricCollectionType) obj;
        return ((metricCollectionType.getMetric() == null ? 1 : 0) ^ (getMetric() == null ? 1 : 0)) == 0 ? metricCollectionType.getMetric() == null || metricCollectionType.getMetric().equals(getMetric()) : false;
    }

    public String getMetric() {
        return this.metric;
    }

    public int hashCode() {
        return (getMetric() == null ? 0 : getMetric().hashCode()) + 31;
    }

    public void setMetric(String str) {
        this.metric = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metric != null) {
            stringBuilder.append("Metric: " + this.metric + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public MetricCollectionType withMetric(String str) {
        this.metric = str;
        return this;
    }
}
