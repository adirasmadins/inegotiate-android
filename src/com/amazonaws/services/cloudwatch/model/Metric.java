package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Metric {
    private List<Dimension> dimensions;
    private String metricName;
    private String namespace;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        if (((metric.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metric.getNamespace() != null && !metric.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((metric.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metric.getMetricName() != null && !metric.getMetricName().equals(getMetricName())) {
            return false;
        }
        return ((metric.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) == 0 ? metric.getDimensions() == null || metric.getDimensions().equals(getDimensions()) : false;
    }

    public List<Dimension> getDimensions() {
        if (this.dimensions == null) {
            this.dimensions = new ArrayList();
        }
        return this.dimensions;
    }

    public String getMetricName() {
        return this.metricName;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetricName() == null ? 0 : getMetricName().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + 31) * 31)) * 31;
        if (getDimensions() != null) {
            i = getDimensions().hashCode();
        }
        return hashCode + i;
    }

    public void setDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.dimensions = arrayList;
    }

    public void setMetricName(String str) {
        this.metricName = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.namespace != null) {
            stringBuilder.append("Namespace: " + this.namespace + ", ");
        }
        if (this.metricName != null) {
            stringBuilder.append("MetricName: " + this.metricName + ", ");
        }
        if (this.dimensions != null) {
            stringBuilder.append("Dimensions: " + this.dimensions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Metric withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public Metric withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public Metric withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public Metric withNamespace(String str) {
        this.namespace = str;
        return this;
    }
}
