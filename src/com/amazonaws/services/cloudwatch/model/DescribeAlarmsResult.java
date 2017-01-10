package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsResult {
    private List<MetricAlarm> metricAlarms;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmsResult)) {
            return false;
        }
        DescribeAlarmsResult describeAlarmsResult = (DescribeAlarmsResult) obj;
        if (((describeAlarmsResult.getMetricAlarms() == null ? 1 : 0) ^ (getMetricAlarms() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsResult.getMetricAlarms() != null && !describeAlarmsResult.getMetricAlarms().equals(getMetricAlarms())) {
            return false;
        }
        return ((describeAlarmsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAlarmsResult.getNextToken() == null || describeAlarmsResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<MetricAlarm> getMetricAlarms() {
        if (this.metricAlarms == null) {
            this.metricAlarms = new ArrayList();
        }
        return this.metricAlarms;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetricAlarms() == null ? 0 : getMetricAlarms().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
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

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metricAlarms != null) {
            stringBuilder.append("MetricAlarms: " + this.metricAlarms + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmsResult withMetricAlarms(Collection<MetricAlarm> collection) {
        if (collection == null) {
            this.metricAlarms = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metricAlarms = arrayList;
        }
        return this;
    }

    public DescribeAlarmsResult withMetricAlarms(MetricAlarm... metricAlarmArr) {
        if (getMetricAlarms() == null) {
            setMetricAlarms(new ArrayList(metricAlarmArr.length));
        }
        for (Object add : metricAlarmArr) {
            getMetricAlarms().add(add);
        }
        return this;
    }

    public DescribeAlarmsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
