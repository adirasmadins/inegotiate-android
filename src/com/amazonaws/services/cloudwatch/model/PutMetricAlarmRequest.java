package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PutMetricAlarmRequest extends AmazonWebServiceRequest {
    private Boolean actionsEnabled;
    private List<String> alarmActions;
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
    private String statistic;
    private Double threshold;
    private String unit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutMetricAlarmRequest)) {
            return false;
        }
        PutMetricAlarmRequest putMetricAlarmRequest = (PutMetricAlarmRequest) obj;
        if (((putMetricAlarmRequest.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getAlarmName() != null && !putMetricAlarmRequest.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        if (((putMetricAlarmRequest.getAlarmDescription() == null ? 1 : 0) ^ (getAlarmDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getAlarmDescription() != null && !putMetricAlarmRequest.getAlarmDescription().equals(getAlarmDescription())) {
            return false;
        }
        if (((putMetricAlarmRequest.isActionsEnabled() == null ? 1 : 0) ^ (isActionsEnabled() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.isActionsEnabled() != null && !putMetricAlarmRequest.isActionsEnabled().equals(isActionsEnabled())) {
            return false;
        }
        if (((putMetricAlarmRequest.getOKActions() == null ? 1 : 0) ^ (getOKActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getOKActions() != null && !putMetricAlarmRequest.getOKActions().equals(getOKActions())) {
            return false;
        }
        if (((putMetricAlarmRequest.getAlarmActions() == null ? 1 : 0) ^ (getAlarmActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getAlarmActions() != null && !putMetricAlarmRequest.getAlarmActions().equals(getAlarmActions())) {
            return false;
        }
        if (((putMetricAlarmRequest.getInsufficientDataActions() == null ? 1 : 0) ^ (getInsufficientDataActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getInsufficientDataActions() != null && !putMetricAlarmRequest.getInsufficientDataActions().equals(getInsufficientDataActions())) {
            return false;
        }
        if (((putMetricAlarmRequest.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getMetricName() != null && !putMetricAlarmRequest.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((putMetricAlarmRequest.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getNamespace() != null && !putMetricAlarmRequest.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((putMetricAlarmRequest.getStatistic() == null ? 1 : 0) ^ (getStatistic() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getStatistic() != null && !putMetricAlarmRequest.getStatistic().equals(getStatistic())) {
            return false;
        }
        if (((putMetricAlarmRequest.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getDimensions() != null && !putMetricAlarmRequest.getDimensions().equals(getDimensions())) {
            return false;
        }
        if (((putMetricAlarmRequest.getPeriod() == null ? 1 : 0) ^ (getPeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getPeriod() != null && !putMetricAlarmRequest.getPeriod().equals(getPeriod())) {
            return false;
        }
        if (((putMetricAlarmRequest.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getUnit() != null && !putMetricAlarmRequest.getUnit().equals(getUnit())) {
            return false;
        }
        if (((putMetricAlarmRequest.getEvaluationPeriods() == null ? 1 : 0) ^ (getEvaluationPeriods() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getEvaluationPeriods() != null && !putMetricAlarmRequest.getEvaluationPeriods().equals(getEvaluationPeriods())) {
            return false;
        }
        if (((putMetricAlarmRequest.getThreshold() == null ? 1 : 0) ^ (getThreshold() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricAlarmRequest.getThreshold() != null && !putMetricAlarmRequest.getThreshold().equals(getThreshold())) {
            return false;
        }
        return ((putMetricAlarmRequest.getComparisonOperator() == null ? 1 : 0) ^ (getComparisonOperator() == null ? 1 : 0)) == 0 ? putMetricAlarmRequest.getComparisonOperator() == null || putMetricAlarmRequest.getComparisonOperator().equals(getComparisonOperator()) : false;
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
        int hashCode = ((getThreshold() == null ? 0 : getThreshold().hashCode()) + (((getEvaluationPeriods() == null ? 0 : getEvaluationPeriods().hashCode()) + (((getUnit() == null ? 0 : getUnit().hashCode()) + (((getPeriod() == null ? 0 : getPeriod().hashCode()) + (((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getStatistic() == null ? 0 : getStatistic().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + (((getInsufficientDataActions() == null ? 0 : getInsufficientDataActions().hashCode()) + (((getAlarmActions() == null ? 0 : getAlarmActions().hashCode()) + (((getOKActions() == null ? 0 : getOKActions().hashCode()) + (((isActionsEnabled() == null ? 0 : isActionsEnabled().hashCode()) + (((getAlarmDescription() == null ? 0 : getAlarmDescription().hashCode()) + (((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
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
        if (this.alarmDescription != null) {
            stringBuilder.append("AlarmDescription: " + this.alarmDescription + ", ");
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

    public PutMetricAlarmRequest withActionsEnabled(Boolean bool) {
        this.actionsEnabled = bool;
        return this;
    }

    public PutMetricAlarmRequest withAlarmActions(Collection<String> collection) {
        if (collection == null) {
            this.alarmActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarmActions = arrayList;
        }
        return this;
    }

    public PutMetricAlarmRequest withAlarmActions(String... strArr) {
        if (getAlarmActions() == null) {
            setAlarmActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAlarmActions().add(add);
        }
        return this;
    }

    public PutMetricAlarmRequest withAlarmDescription(String str) {
        this.alarmDescription = str;
        return this;
    }

    public PutMetricAlarmRequest withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }

    public PutMetricAlarmRequest withComparisonOperator(ComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator.toString();
        return this;
    }

    public PutMetricAlarmRequest withComparisonOperator(String str) {
        this.comparisonOperator = str;
        return this;
    }

    public PutMetricAlarmRequest withDimensions(Collection<Dimension> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public PutMetricAlarmRequest withDimensions(Dimension... dimensionArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionArr.length));
        }
        for (Object add : dimensionArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public PutMetricAlarmRequest withEvaluationPeriods(Integer num) {
        this.evaluationPeriods = num;
        return this;
    }

    public PutMetricAlarmRequest withInsufficientDataActions(Collection<String> collection) {
        if (collection == null) {
            this.insufficientDataActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.insufficientDataActions = arrayList;
        }
        return this;
    }

    public PutMetricAlarmRequest withInsufficientDataActions(String... strArr) {
        if (getInsufficientDataActions() == null) {
            setInsufficientDataActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getInsufficientDataActions().add(add);
        }
        return this;
    }

    public PutMetricAlarmRequest withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public PutMetricAlarmRequest withNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public PutMetricAlarmRequest withOKActions(Collection<String> collection) {
        if (collection == null) {
            this.oKActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.oKActions = arrayList;
        }
        return this;
    }

    public PutMetricAlarmRequest withOKActions(String... strArr) {
        if (getOKActions() == null) {
            setOKActions(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getOKActions().add(add);
        }
        return this;
    }

    public PutMetricAlarmRequest withPeriod(Integer num) {
        this.period = num;
        return this;
    }

    public PutMetricAlarmRequest withStatistic(Statistic statistic) {
        this.statistic = statistic.toString();
        return this;
    }

    public PutMetricAlarmRequest withStatistic(String str) {
        this.statistic = str;
        return this;
    }

    public PutMetricAlarmRequest withThreshold(Double d) {
        this.threshold = d;
        return this;
    }

    public PutMetricAlarmRequest withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public PutMetricAlarmRequest withUnit(String str) {
        this.unit = str;
        return this;
    }
}
