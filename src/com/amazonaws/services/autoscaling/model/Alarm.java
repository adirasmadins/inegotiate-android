package com.amazonaws.services.autoscaling.model;

public class Alarm {
    private String alarmARN;
    private String alarmName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Alarm)) {
            return false;
        }
        Alarm alarm = (Alarm) obj;
        if (((alarm.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (alarm.getAlarmName() != null && !alarm.getAlarmName().equals(getAlarmName())) {
            return false;
        }
        return ((alarm.getAlarmARN() == null ? 1 : 0) ^ (getAlarmARN() == null ? 1 : 0)) == 0 ? alarm.getAlarmARN() == null || alarm.getAlarmARN().equals(getAlarmARN()) : false;
    }

    public String getAlarmARN() {
        return this.alarmARN;
    }

    public String getAlarmName() {
        return this.alarmName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAlarmName() == null ? 0 : getAlarmName().hashCode()) + 31) * 31;
        if (getAlarmARN() != null) {
            i = getAlarmARN().hashCode();
        }
        return hashCode + i;
    }

    public void setAlarmARN(String str) {
        this.alarmARN = str;
    }

    public void setAlarmName(String str) {
        this.alarmName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.alarmName != null) {
            stringBuilder.append("AlarmName: " + this.alarmName + ", ");
        }
        if (this.alarmARN != null) {
            stringBuilder.append("AlarmARN: " + this.alarmARN + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Alarm withAlarmARN(String str) {
        this.alarmARN = str;
        return this;
    }

    public Alarm withAlarmName(String str) {
        this.alarmName = str;
        return this;
    }
}
