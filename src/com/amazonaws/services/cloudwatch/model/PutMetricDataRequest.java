package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PutMetricDataRequest extends AmazonWebServiceRequest {
    private List<MetricDatum> metricData;
    private String namespace;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutMetricDataRequest)) {
            return false;
        }
        PutMetricDataRequest putMetricDataRequest = (PutMetricDataRequest) obj;
        if (((putMetricDataRequest.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (putMetricDataRequest.getNamespace() != null && !putMetricDataRequest.getNamespace().equals(getNamespace())) {
            return false;
        }
        return ((putMetricDataRequest.getMetricData() == null ? 1 : 0) ^ (getMetricData() == null ? 1 : 0)) == 0 ? putMetricDataRequest.getMetricData() == null || putMetricDataRequest.getMetricData().equals(getMetricData()) : false;
    }

    public List<MetricDatum> getMetricData() {
        if (this.metricData == null) {
            this.metricData = new ArrayList();
        }
        return this.metricData;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNamespace() == null ? 0 : getNamespace().hashCode()) + 31) * 31;
        if (getMetricData() != null) {
            i = getMetricData().hashCode();
        }
        return hashCode + i;
    }

    public void setMetricData(Collection<MetricDatum> collection) {
        if (collection == null) {
            this.metricData = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.metricData = arrayList;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.namespace != null) {
            stringBuilder.append("Namespace: " + this.namespace + ", ");
        }
        if (this.metricData != null) {
            stringBuilder.append("MetricData: " + this.metricData + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PutMetricDataRequest withMetricData(Collection<MetricDatum> collection) {
        if (collection == null) {
            this.metricData = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metricData = arrayList;
        }
        return this;
    }

    public PutMetricDataRequest withMetricData(MetricDatum... metricDatumArr) {
        if (getMetricData() == null) {
            setMetricData(new ArrayList(metricDatumArr.length));
        }
        for (Object add : metricDatumArr) {
            getMetricData().add(add);
        }
        return this;
    }

    public PutMetricDataRequest withNamespace(String str) {
        this.namespace = str;
        return this;
    }
}
