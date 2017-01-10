package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsForMetricResult {
    private List<MetricAlarm> metricAlarms;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmsForMetricResult)) {
            return false;
        }
        DescribeAlarmsForMetricResult describeAlarmsForMetricResult = (DescribeAlarmsForMetricResult) obj;
        return ((describeAlarmsForMetricResult.getMetricAlarms() == null ? 1 : 0) ^ (getMetricAlarms() == null ? 1 : 0)) == 0 ? describeAlarmsForMetricResult.getMetricAlarms() == null || describeAlarmsForMetricResult.getMetricAlarms().equals(getMetricAlarms()) : false;
    }

    public List<MetricAlarm> getMetricAlarms() {
        if (this.metricAlarms == null) {
            this.metricAlarms = new ArrayList();
        }
        return this.metricAlarms;
    }

    public int hashCode() {
        return (getMetricAlarms() == null ? 0 : getMetricAlarms().hashCode()) + 31;
    }

    public void setMetricAlarms(Collection<MetricAlarm> collection) {
        if (collection == null) {
            this.metricAlarms = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.metricAlarms = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metricAlarms != null) {
            stringBuilder.append("MetricAlarms: " + this.metricAlarms + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmsForMetricResult withMetricAlarms(Collection<MetricAlarm> collection) {
        if (collection == null) {
            this.metricAlarms = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metricAlarms = arrayList;
        }
        return this;
    }

    public DescribeAlarmsForMetricResult withMetricAlarms(MetricAlarm... metricAlarmArr) {
        if (getMetricAlarms() == null) {
            setMetricAlarms(new ArrayList(metricAlarmArr.length));
        }
        for (Object add : metricAlarmArr) {
            getMetricAlarms().add(add);
        }
        return this;
    }
}
