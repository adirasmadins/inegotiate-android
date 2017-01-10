package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GetMetricStatisticsRequest extends AmazonWebServiceRequest {
    private List<Dimension> dimensions;
    private Date endTime;
    private String metricName;
    private String namespace;
    private Integer period;
    private Date startTime;
    private List<String> statistics;
    private String unit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetMetricStatisticsRequest)) {
            return false;
        }
        GetMetricStatisticsRequest getMetricStatisticsRequest = (GetMetricStatisticsRequest) obj;
        if (((getMetricStatisticsRequest.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getNamespace() != null && !getMetricStatisticsRequest.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getMetricName() != null && !getMetricStatisticsRequest.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getDimensions() != null && !getMetricStatisticsRequest.getDimensions().equals(getDimensions())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getStartTime() != null && !getMetricStatisticsRequest.getStartTime().equals(getStartTime())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getEndTime() != null && !getMetricStatisticsRequest.getEndTime().equals(getEndTime())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getPeriod() != null && !getMetricStatisticsRequest.getPeriod().equals(getPeriod())) {
            return false;
        }
        if (((getMetricStatisticsRequest.getStatistics() == null ? 1 : 0) ^ (getStatistics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsRequest.getStatistics() != null && !getMetricStatisticsRequest.getStatistics().equals(getStatistics())) {
            return false;
        }
        return ((getMetricStatisticsRequest.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) == 0 ? getMetricStatisticsRequest.getUnit() == null || getMetricStatisticsRequest.getUnit().equals(getUnit()) : false;
    }

    public List<Dimension> getDimensions() {
        if (this.dimensions == null) {
            this.dimensions = new ArrayList();
        }
        return this.dimensions;
    }

    public Date getEndTime() {
        return this.endTime;
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

    public Date getStartTime() {
        return this.startTime;
    }

    public List<String> getStatistics() {
        if (this.statistics == null) {
            this.statistics = new ArrayList();
        }
        return this.statistics;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getStatistics() == null ? 0 : getStatistics().hashCode()) + (((getPeriod() == null ? 0 : getPeriod().hashCode()) + (((getEndTime() == null ? 0 : getEndTime().hashCode()) + (((getStartTime() == null ? 0 : getStartTime().hashCode()) + (((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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

    public void setEndTime(Date date) {
        this.endTime = date;
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

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public void setStatistics(Collection<String> collection) {
        if (collection == null) {
            this.statistics = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.statistics = arrayList;
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
        if (this.namespace != null) {
            stringBuilder.append("Namespace: " + this.namespace + ", ");
        }
        if (this.metricName != null) {
            stringBuilder.append("MetricName: " + this.metricName + ", ");
        }
        if (this.dimensions != null) {
            stringBuilder.append("Dimensions: " + this.dimensions + ", ");
        }
        if (this.startTime != null) {
            stringBuilder.append("StartTime: " + this.startTime + ", ");
        }
        if (this.endTime != null) {
            stringBuilder.append("EndTime: " + this.endTime + ", ");
        }
        if (this.period != null) {
            stringBuilder.append("Period: " + this.period + ", ");
        }
        if (this.statistics != null) {
            stringBuilder.append("Statistics: " + this.statistics + ", ");
        }
        if (this.unit != null) {
            stringBuilder.append("Unit: " + this.unit + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetMetricStatisticsRequest withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public GetMetricStatisticsRequest withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public GetMetricStatisticsRequest withEndTime(Date date) {
        this.endTime = date;
        return this;
    }

    public GetMetricStatisticsRequest withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public GetMetricStatisticsRequest withNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public GetMetricStatisticsRequest withPeriod(Integer num) {
        this.period = num;
        return this;
    }

    public GetMetricStatisticsRequest withStartTime(Date date) {
        this.startTime = date;
        return this;
    }

    public GetMetricStatisticsRequest withStatistics(Collection<String> collection) {
        if (collection == null) {
            this.statistics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.statistics = arrayList;
        }
        return this;
    }

    public GetMetricStatisticsRequest withStatistics(String... strArr) {
        if (getStatistics() == null) {
            setStatistics(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getStatistics().add(add);
        }
        return this;
    }

    public GetMetricStatisticsRequest withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public GetMetricStatisticsRequest withUnit(String str) {
        this.unit = str;
        return this;
    }
}
