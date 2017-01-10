package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsForMetricRequest extends AmazonWebServiceRequest {
    private List<Dimension> dimensions;
    private String metricName;
    private String namespace;
    private Integer period;
    private String statistic;
    private String unit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmsForMetricRequest)) {
            return false;
        }
        DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest = (DescribeAlarmsForMetricRequest) obj;
        if (((describeAlarmsForMetricRequest.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsForMetricRequest.getMetricName() != null && !describeAlarmsForMetricRequest.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((describeAlarmsForMetricRequest.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsForMetricRequest.getNamespace() != null && !describeAlarmsForMetricRequest.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((describeAlarmsForMetricRequest.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsForMetricRequest.getStatistic() != null && !describeAlarmsForMetricRequest.getStatistic().equals(getStatistic())) {
            return false;
        }
        if (((describeAlarmsForMetricRequest.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsForMetricRequest.getDimensions() != null && !describeAlarmsForMetricRequest.getDimensions().equals(getDimensions())) {
            return false;
        }
        if (((describeAlarmsForMetricRequest.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsForMetricRequest.getPeriod() != null && !describeAlarmsForMetricRequest.getPeriod().equals(getPeriod())) {
            return false;
        }
        return ((describeAlarmsForMetricRequest.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) == 0 ? describeAlarmsForMetricRequest.getUnit() == null || describeAlarmsForMetricRequest.getUnit().equals(getUnit()) : false;
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

    public Integer getPeriod() {
        return this.period;
    }

    public String getStatistic() {
        return this.statistic;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPeriod() == null ? 0 : getPeriod().hashCode()) + (((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getStatistic() == null ? 0 : getStatistic().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
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

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setPeriod(Integer num) {
        this.period = num;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic.toString();
    }

    public void setStatistic(String str) {
        this.statistic = str;
    }

    public void setUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metricName != null) {
            stringBuilder.append("MetricName: " + this.metricName + ", ");
        }
        if (this.namespace != null) {
            stringBuilder.append("Namespace: " + this.namespace + ", ");
        }
        if (this.statistic != null) {
            stringBuilder.append("Statistic: " + this.statistic + ", ");
        }
        if (this.dimensions != null) {
            stringBuilder.append("Dimensions: " + this.dimensions + ", ");
        }
        if (this.period != null) {
            stringBuilder.append("Period: " + this.period + ", ");
        }
        if (this.unit != null) {
            stringBuilder.append("Unit: " + this.unit + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmsForMetricRequest withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public DescribeAlarmsForMetricRequest withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public DescribeAlarmsForMetricRequest withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public DescribeAlarmsForMetricRequest withNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public DescribeAlarmsForMetricRequest withPeriod(Integer num) {
        this.period = num;
        return this;
    }

    public DescribeAlarmsForMetricRequest withStatistic(Statistic statistic) {
        this.statistic = statistic.toString();
        return this;
    }

    public DescribeAlarmsForMetricRequest withStatistic(String str) {
        this.statistic = str;
        return this;
    }

    public DescribeAlarmsForMetricRequest withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public DescribeAlarmsForMetricRequest withUnit(String str) {
        this.unit = str;
        return this;
    }
}
