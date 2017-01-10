package com.amazonaws.services.autoscaling.model;

public class EnabledMetric {
    private String granularity;
    private String metric;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnabledMetric)) {
            return false;
        }
        EnabledMetric enabledMetric = (EnabledMetric) obj;
        if (((enabledMetric.getMetric() == null ? 1 : 0) ^ (getMetric() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (enabledMetric.getMetric() != null && !enabledMetric.getMetric().equals(getMetric())) {
            return false;
        }
        return ((enabledMetric.getGranularity() == null ? 1 : 0) ^ (getGranularity() == null ? 1 : 0)) == 0 ? enabledMetric.getGranularity() == null || enabledMetric.getGranularity().equals(getGranularity()) : false;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public String getMetric() {
        return this.metric;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetric() == null ? 0 : getMetric().hashCode()) + 31) * 31;
        if (getGranularity() != null) {
            i = getGranularity().hashCode();
        }
        return hashCode + i;
    }

    public void setGranularity(String str) {
        this.granularity = str;
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
        if (this.granularity != null) {
            stringBuilder.append("Granularity: " + this.granularity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public EnabledMetric withGranularity(String str) {
        this.granularity = str;
        return this;
    }

    public EnabledMetric withMetric(String str) {
        this.metric = str;
        return this;
    }
}
