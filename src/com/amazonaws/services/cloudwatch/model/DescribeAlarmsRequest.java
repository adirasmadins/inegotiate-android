package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsRequest extends AmazonWebServiceRequest {
    private String actionPrefix;
    private String alarmNamePrefix;
    private List<String> alarmNames;
    private Integer maxRecords;
    private String nextToken;
    private String stateValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeAlarmsRequest)) {
            return false;
        }
        DescribeAlarmsRequest describeAlarmsRequest = (DescribeAlarmsRequest) obj;
        if (((describeAlarmsRequest.getAlarmNames() == null ? 1 : 0) ^ (getAlarmNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsRequest.getAlarmNames() != null && !describeAlarmsRequest.getAlarmNames().equals(getAlarmNames())) {
            return false;
        }
        if (((describeAlarmsRequest.getAlarmNamePrefix() == null ? 1 : 0) ^ (getAlarmNamePrefix() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsRequest.getAlarmNamePrefix() != null && !describeAlarmsRequest.getAlarmNamePrefix().equals(getAlarmNamePrefix())) {
            return false;
        }
        if (((describeAlarmsRequest.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsRequest.getStateValue() != null && !describeAlarmsRequest.getStateValue().equals(getStateValue())) {
            return false;
        }
        if (((describeAlarmsRequest.getActionPrefix() == null ? 1 : 0) ^ (getActionPrefix() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsRequest.getActionPrefix() != null && !describeAlarmsRequest.getActionPrefix().equals(getActionPrefix())) {
            return false;
        }
        if (((describeAlarmsRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeAlarmsRequest.getMaxRecords() != null && !describeAlarmsRequest.getMaxRecords().equals(getMaxRecords())) {
            return false;
        }
        return ((describeAlarmsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeAlarmsRequest.getNextToken() == null || describeAlarmsRequest.getNextToken().equals(getNextToken()) : false;
    }

    public String getActionPrefix() {
        return this.actionPrefix;
    }

    public String getAlarmNamePrefix() {
        return this.alarmNamePrefix;
    }

    public List<String> getAlarmNames() {
        if (this.alarmNames == null) {
            this.alarmNames = new ArrayList();
        }
        return this.alarmNames;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getStateValue() {
        return this.stateValue;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaxRecords() == null ? 0 : getMaxRecords().hashCode()) + (((getActionPrefix() == null ? 0 : getActionPrefix().hashCode()) + (((getStateValue() == null ? 0 : getStateValue().hashCode()) + (((getAlarmNamePrefix() == null ? 0 : getAlarmNamePrefix().hashCode()) + (((getAlarmNames() == null ? 0 : getAlarmNames().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setActionPrefix(String str) {
        this.actionPrefix = str;
    }

    public void setAlarmNamePrefix(String str) {
        this.alarmNamePrefix = str;
    }

    public void setAlarmNames(Collection<String> collection) {
        if (collection == null) {
            this.alarmNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.alarmNames = arrayList;
    }

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
    }

    public void setStateValue(String str) {
        this.stateValue = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmNames != null) {
            stringBuilder.append("AlarmNames: " + this.alarmNames + ", ");
        }
        if (this.alarmNamePrefix != null) {
            stringBuilder.append("AlarmNamePrefix: " + this.alarmNamePrefix + ", ");
        }
        if (this.stateValue != null) {
            stringBuilder.append("StateValue: " + this.stateValue + ", ");
        }
        if (this.actionPrefix != null) {
            stringBuilder.append("ActionPrefix: " + this.actionPrefix + ", ");
        }
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeAlarmsRequest withActionPrefix(String str) {
        this.actionPrefix = str;
        return this;
    }

    public DescribeAlarmsRequest withAlarmNamePrefix(String str) {
        this.alarmNamePrefix = str;
        return this;
    }

    public DescribeAlarmsRequest withAlarmNames(Collection<String> collection) {
        if (collection == null) {
            this.alarmNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarmNames = arrayList;
        }
        return this;
    }

    public DescribeAlarmsRequest withAlarmNames(String... strArr) {
        if (getAlarmNames() == null) {
            setAlarmNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAlarmNames().add(add);
        }
        return this;
    }

    public DescribeAlarmsRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeAlarmsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeAlarmsRequest withStateValue(StateValue stateValue) {
        this.stateValue = stateValue.toString();
        return this;
    }

    public DescribeAlarmsRequest withStateValue(String str) {
        this.stateValue = str;
        return this;
    }
}
