package com.amazonaws.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimingInfo {
    private final Map<String, Number> countersByName;
    private long endTime;
    private final long startTime;
    private final Map<String, List<TimingInfo>> subMeasurementsByName;

    public TimingInfo() {
        this(System.currentTimeMillis(), -1);
    }

    public TimingInfo(long j) {
        this(j, -1);
    }

    public TimingInfo(long j, long j2) {
        this.subMeasurementsByName = new HashMap();
        this.countersByName = new HashMap();
        this.startTime = j;
        this.endTime = j2;
    }

    public void addSubMeasurement(String str, TimingInfo timingInfo) {
        List list = (List) this.subMeasurementsByName.get(str);
        if (list == null) {
            list = new ArrayList();
            this.subMeasurementsByName.put(str, list);
        }
        list.add(timingInfo);
    }

    public Map<String, Number> getAllCounters() {
        return this.countersByName;
    }

    public List<TimingInfo> getAllSubMeasurements(String str) {
        return (List) this.subMeasurementsByName.get(str);
    }

    public Number getCounter(String str) {
        return (Number) this.countersByName.get(str);
    }

    public long getEndTime() {
        return this.endTime;
    }

    public TimingInfo getLastSubMeasurement(String str) {
        return (this.subMeasurementsByName == null || this.subMeasurementsByName.size() == 0) ? null : getSubMeasurement(str, this.subMeasurementsByName.size() - 1);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public TimingInfo getSubMeasurement(String str) {
        return getSubMeasurement(str, 0);
    }

    public TimingInfo getSubMeasurement(String str, int i) {
        List list = (List) this.subMeasurementsByName.get(str);
        return (i < 0 || list == null || list.size() == 0 || i >= list.size()) ? null : (TimingInfo) list.get(i);
    }

    public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
        return this.subMeasurementsByName;
    }

    public double getTimeTakenMillis() {
        return ((double) TimeUnit.NANOSECONDS.toMicros(this.endTime - this.startTime)) / 1000.0d;
    }

    public void incrementCounter(String str) {
        int i = 0;
        Number counter = getCounter(str);
        if (counter != null) {
            i = counter.intValue();
        }
        setCounter(str, (long) (i + 1));
    }

    public void setCounter(String str, long j) {
        this.countersByName.put(str, Long.valueOf(j));
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public String toString() {
        return String.valueOf(getTimeTakenMillis());
    }
}
