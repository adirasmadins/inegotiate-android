package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MetricAlarm {
    private Boolean actionsEnabled;
    private List<String> alarmActions;
    private String alarmArn;
    private Date alarmConfigurationUpdatedTimestamp;
    private String alarmDescription;
    private String alarmName;
    private String comparisonOperator;
    private List<Dimension> dimensions;
    private Integer evaluationPeriods;
    private List<String> insufficientDataActions;
    private String metricName;
    private String namespace;
    private List<String> oKActions;
    private Integer period;
    private String stateReason;
    private String stateReasonData;
    private Date stateUpdatedTimestamp;
    private String stateValue;
    private String statistic;
    private Double threshold;
    private String unit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MetricAlarm)) {
            return false;
        }
        MetricAlarm metricAlarm = (MetricAlarm) obj;
        if (((metricAlarm.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getAlarmName() != null && !metricAlarm.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        if (((metricAlarm.getAlarmArn() == null ? 1 : 0) ^ (getAlarmArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getAlarmArn() != null && !metricAlarm.getAlarmArn().equals(getAlarmArn())) {
            return false;
        }
        if (((metricAlarm.getAlarmDescription() == null ? 1 : 0) ^ (getAlarmDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getAlarmDescription() != null && !metricAlarm.getAlarmDescription().equals(getAlarmDescription())) {
            return false;
        }
        if (((metricAlarm.getAlarmConfigurationUpdatedTimestamp() == null ? 1 : 0) ^ (getAlarmConfigurationUpdatedTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getAlarmConfigurationUpdatedTimestamp() != null && !metricAlarm.getAlarmConfigurationUpdatedTimestamp().equals(getAlarmConfigurationUpdatedTimestamp())) {
            return false;
        }
        if (((metricAlarm.isActionsEnabled() == null ? 1 : 0) ^ (isActionsEnabled() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.isActionsEnabled() != null && !metricAlarm.isActionsEnabled().equals(isActionsEnabled())) {
            return false;
        }
        if (((metricAlarm.getOKActions() == null ? 1 : 0) ^ (getOKActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getOKActions() != null && !metricAlarm.getOKActions().equals(getOKActions())) {
            return false;
        }
        if (((metricAlarm.getAlarmActions() == null ? 1 : 0) ^ (getAlarmActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getAlarmActions() != null && !metricAlarm.getAlarmActions().equals(getAlarmActions())) {
            return false;
        }
        if (((metricAlarm.getInsufficientDataActions() == null ? 1 : 0) ^ (getInsufficientDataActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getInsufficientDataActions() != null && !metricAlarm.getInsufficientDataActions().equals(getInsufficientDataActions())) {
            return false;
        }
        if (((metricAlarm.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getStateValue() != null && !metricAlarm.getStateValue().equals(getStateValue())) {
            return false;
        }
        if (((metricAlarm.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getStateReason() != null && !metricAlarm.getStateReason().equals(getStateReason())) {
            return false;
        }
        if (((metricAlarm.getStateReasonData() == null ? 1 : 0) ^ (getStateReasonData() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getStateReasonData() != null && !metricAlarm.getStateReasonData().equals(getStateReasonData())) {
            return false;
        }
        if (((metricAlarm.getStateUpdatedTimestamp() == null ? 1 : 0) ^ (getStateUpdatedTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getStateUpdatedTimestamp() != null && !metricAlarm.getStateUpdatedTimestamp().equals(getStateUpdatedTimestamp())) {
            return false;
        }
        if (((metricAlarm.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getMetricName() != null && !metricAlarm.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((metricAlarm.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getNamespace() != null && !metricAlarm.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((metricAlarm.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getStatistic() != null && !metricAlarm.getStatistic().equals(getStatistic())) {
            return false;
        }
        if (((metricAlarm.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getDimensions() != null && !metricAlarm.getDimensions().equals(getDimensions())) {
            return false;
        }
        if (((metricAlarm.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getPeriod() != null && !metricAlarm.getPeriod().equals(getPeriod())) {
            return false;
        }
        if (((metricAlarm.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getUnit() != null && !metricAlarm.getUnit().equals(getUnit())) {
            return false;
        }
        if (((metricAlarm.getEvaluationPeriods() == null ? 1 : 0) ^ (getEvaluationPeriods() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getEvaluationPeriods() != null && !metricAlarm.getEvaluationPeriods().equals(getEvaluationPeriods())) {
            return false;
        }
        if (((metricAlarm.getThreshold() == null ? 1 : 0) ^ (getThreshold() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (metricAlarm.getThreshold() != null && !metricAlarm.getThreshold().equals(getThreshold())) {
            return false;
        }
        return ((metricAlarm.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) == 0 ? metricAlarm.getComparisonOperator() == null || metricAlarm.getComparisonOperator().equals(getComparisonOperator()) : false;
    }

    public Boolean getActionsEnabled() {
        return this.actionsEnabled;
    }

    public List<String> getAlarmActions() {
        if (this.alarmActions == null) {
            this.alarmActions = new ArrayList();
        }
        return this.alarmActions;
    }

    public String getAlarmArn() {
        return this.alarmArn;
    }

    public Date getAlarmConfigurationUpdatedTimestamp() {
        return this.alarmConfigurationUpdatedTimestamp;
    }

    public String getAlarmDescription() {
        return this.alarmDescription;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public String getComparisonOperator() {
        return this.comparisonOperator;
    }

    public List<Dimension> getDimensions() {
        if (this.dimensions == null) {
            this.dimensions = new ArrayList();
        }
        return this.dimensions;
    }

    public Integer getEvaluationPeriods() {
        return this.evaluationPeriods;
    }

    public List<String> getInsufficientDataActions() {
        if (this.insufficientDataActions == null) {
            this.insufficientDataActions = new ArrayList();
        }
        return this.insufficientDataActions;
    }

    public String getMetricName() {
        return this.metricName;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public List<String> getOKActions() {
        if (this.oKActions == null) {
            this.oKActions = new ArrayList();
        }
        return this.oKActions;
    }

    public Integer getPeriod() {
        return this.period;
    }

    public String getStateReason() {
        return this.stateReason;
    }

    public String getStateReasonData() {
        return this.stateReasonData;
    }

    public Date getStateUpdatedTimestamp() {
        return this.stateUpdatedTimestamp;
    }

    public String getStateValue() {
        return this.stateValue;
    }

    public String getStatistic() {
        return this.statistic;
    }

    public Double getThreshold() {
        return this.threshold;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getThreshold() == null ? 0 : getThreshold().hashCode()) + (((getEvaluationPeriods() == null ? 0 : getEvaluationPeriods().hashCode()) + (((getUnit() == null ? 0 : getUnit().hashCode()) + (((getPeriod() == null ? 0 : getPeriod().hashCode()) + (((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getStatistic() == null ? 0 : getStatistic().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + (((getStateUpdatedTimestamp() == null ? 0 : getStateUpdatedTimestamp().hashCode()) + (((getStateReasonData() == null ? 0 : getStateReasonData().hashCode()) + (((getStateReason() == null ? 0 : getStateReason().hashCode()) + (((getStateValue() == null ? 0 : getStateValue().hashCode()) + (((getInsufficientDataActions() == null ? 0 : getInsufficientDataActions().hashCode()) + (((getAlarmActions() == null ? 0 : getAlarmActions().hashCode()) + (((getOKActions() == null ? 0 : getOKActions().hashCode()) + (((isActionsEnabled() == null ? 0 : isActionsEnabled().hashCode()) + (((getAlarmConfigurationUpdatedTimestamp() == null ? 0 : getAlarmConfigurationUpdatedTimestamp().hashCode()) + (((getAlarmDescription() == null ? 0 : getAlarmDescription().hashCode()) + (((getAlarmArn() == null ? 0 : getAlarmArn().hashCode()) + (((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getComparisonOperator() != null) {
            i = getComparisonOperator().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isActionsEnabled() {
        return this.actionsEnabled;
    }

    public void setActionsEnabled(Boolean bool) {
        this.actionsEnabled = bool;
    }

    public void setAlarmActions(Collection<String> collection) {
        if (collection == null) {
            this.alarmActions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.alarmActions = arrayList;
    }

    public void setAlarmArn(String str) {
        this.alarmArn = str;
    }

    public void setAlarmConfigurationUpdatedTimestamp(Date date) {
        this.alarmConfigurationUpdatedTimestamp = date;
    }

    public void setAlarmDescription(String str) {
        this.alarmDescription = str;
    }

    public void setAlarmName(String str) {
        this.alarmName = str;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
    }

    public void setComparisonOperator(String str) {
        this.comparisonOperator = str;
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

    public void setEvaluationPeriods(Integer num) {
        this.evaluationPeriods = num;
    }

    public void setInsufficientDataActions(Collection<String> collection) {
        if (collection == null) {
            this.insufficientDataActions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.insufficientDataActions = arrayList;
    }

    public void setMetricName(String str) {
        this.metricName = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setOKActions(Collection<String> collection) {
        if (collection == null) {
            this.oKActions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.oKActions = arrayList;
    }

    public void setPeriod(Integer num) {
        this.period = num;
    }

    public void setStateReason(String str) {
        this.stateReason = str;
    }

    public void setStateReasonData(String str) {
        this.stateReasonData = str;
    }

    public void setStateUpdatedTimestamp(Date date) {
        this.stateUpdatedTimestamp = date;
    }

    public void setStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
    }

    public void setStateValue(String str) {
        this.stateValue = str;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic.toString();
    }

    public void setStatistic(String str) {
        this.statistic = str;
    }

    public void setThreshold(Double d) {
        this.threshold = d;
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
        if (this.alarmName != null) {
            stringBuilder.append("AlarmName: " + this.alarmName + ", ");
        }
        if (this.alarmArn != null) {
            stringBuilder.append("AlarmArn: " + this.alarmArn + ", ");
        }
        if (this.alarmDescription != null) {
            stringBuilder.append("AlarmDescription: " + this.alarmDescription + ", ");
        }
        if (this.alarmConfigurationUpdatedTimestamp != null) {
            stringBuilder.append("AlarmConfigurationUpdatedTimestamp: " + this.alarmConfigurationUpdatedTimestamp + ", ");
        }
        if (this.actionsEnabled != null) {
            stringBuilder.append("ActionsEnabled: " + this.actionsEnabled + ", ");
        }
        if (this.oKActions != null) {
            stringBuilder.append("OKActions: " + this.oKActions + ", ");
        }
        if (this.alarmActions != null) {
            stringBuilder.append("AlarmActions: " + this.alarmActions + ", ");
        }
        if (this.insufficientDataActions != null) {
            stringBuilder.append("InsufficientDataActions: " + this.insufficientDataActions + ", ");
        }
        if (this.stateValue != null) {
            stringBuilder.append("StateValue: " + this.stateValue + ", ");
        }
        if (this.stateReason != null) {
            stringBuilder.append("StateReason: " + this.stateReason + ", ");
        }
        if (this.stateReasonData != null) {
            stringBuilder.append("StateReasonData: " + this.stateReasonData + ", ");
        }
        if (this.stateUpdatedTimestamp != null) {
            stringBuilder.append("StateUpdatedTimestamp: " + this.stateUpdatedTimestamp + ", ");
        }
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
        if (this.evaluationPeriods != null) {
            stringBuilder.append("EvaluationPeriods: " + this.evaluationPeriods + ", ");
        }
        if (this.threshold != null) {
            stringBuilder.append("Threshold: " + this.threshold + ", ");
        }
        if (this.comparisonOperator != null) {
            stringBuilder.append("ComparisonOperator: " + this.comparisonOperator + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public MetricAlarm withActionsEnabled(Boolean bool) {
        this.actionsEnabled = bool;
        return this;
    }

    public MetricAlarm withAlarmActions(Collection<String> collection) {
        if (collection == null) {
            this.alarmActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarmActions = arrayList;
        }
        return this;
    }

    public MetricAlarm withAlarmActions(String... strArr) {
        if (getAlarmActions() == null) {
            setAlarmActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAlarmActions().add(add);
        }
        return this;
    }

    public MetricAlarm withAlarmArn(String str) {
        this.alarmArn = str;
        return this;
    }

    public MetricAlarm withAlarmConfigurationUpdatedTimestamp(Date date) {
        this.alarmConfigurationUpdatedTimestamp = date;
        return this;
    }

    public MetricAlarm withAlarmDescription(String str) {
        this.alarmDescription = str;
        return this;
    }

    public MetricAlarm withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }

    public MetricAlarm withComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
        return this;
    }

    public MetricAlarm withComparisonOperator(String str) {
        this.comparisonOperator = str;
        return this;
    }

    public MetricAlarm withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public MetricAlarm withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public MetricAlarm withEvaluationPeriods(Integer num) {
        this.evaluationPeriods = num;
        return this;
    }

    public MetricAlarm withInsufficientDataActions(Collection<String> collection) {
        if (collection == null) {
            this.insufficientDataActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.insufficientDataActions = arrayList;
        }
        return this;
    }

    public MetricAlarm withInsufficientDataActions(String... strArr) {
        if (getInsufficientDataActions() == null) {
            setInsufficientDataActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInsufficientDataActions().add(add);
        }
        return this;
    }

    public MetricAlarm withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public MetricAlarm withNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public MetricAlarm withOKActions(Collection<String> collection) {
        if (collection == null) {
            this.oKActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.oKActions = arrayList;
        }
        return this;
    }

    public MetricAlarm withOKActions(String... strArr) {
        if (getOKActions() == null) {
            setOKActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getOKActions().add(add);
        }
        return this;
    }

    public MetricAlarm withPeriod(Integer num) {
        this.period = num;
        return this;
    }

    public MetricAlarm withStateReason(String str) {
        this.stateReason = str;
        return this;
    }

    public MetricAlarm withStateReasonData(String str) {
        this.stateReasonData = str;
        return this;
    }

    public MetricAlarm withStateUpdatedTimestamp(Date date) {
        this.stateUpdatedTimestamp = date;
        return this;
    }

    public MetricAlarm withStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
        return this;
    }

    public MetricAlarm withStateValue(String str) {
        this.stateValue = str;
        return this;
    }

    public MetricAlarm withStatistic(Statistic statistic) {
        this.statistic = statistic.toString();
        return this;
    }

    public MetricAlarm withStatistic(String str) {
        this.statistic = str;
        return this;
    }

    public MetricAlarm withThreshold(Double d) {
        this.threshold = d;
        return this;
    }

    public MetricAlarm withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public MetricAlarm withUnit(String str) {
        this.unit = str;
        return this;
    }
}
