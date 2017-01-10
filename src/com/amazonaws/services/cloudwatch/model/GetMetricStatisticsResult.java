package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetMetricStatisticsResult {
    private List<Datapoint> datapoints;
    private String label;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetMetricStatisticsResult)) {
            return false;
        }
        GetMetricStatisticsResult getMetricStatisticsResult = (GetMetricStatisticsResult) obj;
        if (((getMetricStatisticsResult.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (getMetricStatisticsResult.getLabel() != null && !getMetricStatisticsResult.getLabel().equals(getLabel())) {
            return false;
        }
        return ((getMetricStatisticsResult.getDatapoints() == null ? 1 : 0) ^ (getDatapoints() == null ? 1 : 0)) == 0 ? getMetricStatisticsResult.getDatapoints() == null || getMetricStatisticsResult.getDatapoints().equals(getDatapoints()) : false;
    }

    public List<Datapoint> getDatapoints() {
        if (this.datapoints == null) {
            this.datapoints = new ArrayList();
        }
        return this.datapoints;
    }

    public String getLabel() {
        return this.label;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLabel() == null ? 0 : getLabel().hashCode()) + 31) * 31;
        if (getDatapoints() != null) {
            i = getDatapoints().hashCode();
        }
        return hashCode + i;
    }

    public void setDatapoints(Collection<Datapoint> collection) {
        if (collection == null) {
            this.datapoints = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.datapoints = arrayList;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.label != null) {
            stringBuilder.append("Label: " + this.label + ", ");
        }
        if (this.datapoints != null) {
            stringBuilder.append("Datapoints: " + this.datapoints + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public GetMetricStatisticsResult withDatapoints(Collection<Datapoint> collection) {
        if (collection == null) {
            this.datapoints = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.datapoints = arrayList;
        }
        return this;
    }

    public GetMetricStatisticsResult withDatapoints(Datapoint... datapointArr) {
        if (getDatapoints() == null) {
            setDatapoints(new ArrayList(datapointArr.length));
        }
        for (Object add : datapointArr) {
            getDatapoints().add(add);
        }
        return this;
    }

    public GetMetricStatisticsResult withLabel(String str) {
        this.label = str;
        return this;
    }
}
