package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MetricDatum {
    private List<Dimension> dimensions;
    private String metricName;
    private StatisticSet statisticValues;
    private Date timestamp;
    private String unit;
    private Double value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MetricDatum)) {
            return false;
        }
        MetricDatum metricDatum = (MetricDatum) obj;
        if (((metricDatum.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricDatum.getMetricName() != null && !metricDatum.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((metricDatum.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricDatum.getDimensions() != null && !metricDatum.getDimensions().equals(getDimensions())) {
            return false;
        }
        if (((metricDatum.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricDatum.getTimestamp() != null && !metricDatum.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        if (((metricDatum.getValue() == null ? 1 : 0) ^ (getValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricDatum.getValue() != null && !metricDatum.getValue().equals(getValue())) {
            return false;
        }
        if (((metricDatum.getStatisticValues() == null ? 1 : 0) ^ (getStatisticValues() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricDatum.getStatisticValues() != null && !metricDatum.getStatisticValues().equals(getStatisticValues())) {
            return false;
        }
        return ((metricDatum.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) == 0 ? metricDatum.getUnit() == null || metricDatum.getUnit().equals(getUnit()) : false;
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

    public StatisticSet getStatisticValues() {
        return this.statisticValues;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getUnit() {
        return this.unit;
    }

    public Double getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatisticValues() == null ? 0 : getStatisticValues().hashCode()) + (((getValue() == null ? 0 : getValue().hashCode()) + (((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + (((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getUnit() != null) {
            i = getUnit().hashCode();
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

    public void setStatisticValues(StatisticSet statisticSet) {
        this.statisticValues = statisticSet;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public void setUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public void setValue(Double d) {
        this.value = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metricName != null) {
            stringBuilder.append("MetricName: " + this.metricName + ", ");
        }
        if (this.dimensions != null) {
            stringBuilder.append("Dimensions: " + this.dimensions + ", ");
        }
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.value != null) {
            stringBuilder.append("Value: " + this.value + ", ");
        }
        if (this.statisticValues != null) {
            stringBuilder.append("StatisticValues: " + this.statisticValues + ", ");
        }
        if (this.unit != null) {
            stringBuilder.append("Unit: " + this.unit + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public MetricDatum withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public MetricDatum withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public MetricDatum withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public MetricDatum withStatisticValues(StatisticSet statisticSet) {
        this.statisticValues = statisticSet;
        return this;
    }

    public MetricDatum withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }

    public MetricDatum withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public MetricDatum withUnit(String str) {
        this.unit = str;
        return this;
    }

    public MetricDatum withValue(Double d) {
        this.value = d;
        return this;
    }
}
