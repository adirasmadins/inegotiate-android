package com.amazonaws.services.autoscaling.model;

public class MetricGranularityType {
    private String granularity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MetricGranularityType)) {
            return false;
        }
        MetricGranularityType metricGranularityType = (MetricGranularityType) obj;
        return ((metricGranularityType.getGranularity() == null ? 1 : 0) ^ (getGranularity() == null ? 1 : 0)) == 0 ? metricGranularityType.getGranularity() == null || metricGranularityType.getGranularity().equals(getGranularity()) : false;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public int hashCode() {
        return (getGranularity() == null ? 0 : getGranularity().hashCode()) + 31;
    }

    public void setGranularity(String str) {
        this.granularity = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.granularity != null) {
            stringBuilder.append("Granularity: " + this.granularity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public MetricGranularityType withGranularity(String str) {
        this.granularity = str;
        return this;
    }
}
