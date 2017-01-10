package com.amazonaws.services.cloudwatch.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMetricsResult {
    private List<Metric> metrics;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListMetricsResult)) {
            return false;
        }
        ListMetricsResult listMetricsResult = (ListMetricsResult) obj;
        if (((listMetricsResult.getMetrics() == null ? 1 : 0) ^ (getMetrics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listMetricsResult.getMetrics() != null && !listMetricsResult.getMetrics().equals(getMetrics())) {
            return false;
        }
        return ((listMetricsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listMetricsResult.getNextToken() == null || listMetricsResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<Metric> getMetrics() {
        if (this.metrics == null) {
            this.metrics = new ArrayList();
        }
        return this.metrics;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMetrics() == null ? 0 : getMetrics().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setMetrics(Collection<Metric> collection) {
        if (collection == null) {
            this.metrics = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.metrics = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.metrics != null) {
            stringBuilder.append("Metrics: " + this.metrics + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListMetricsResult withMetrics(Collection<Metric> collection) {
        if (collection == null) {
            this.metrics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.metrics = arrayList;
        }
        return this;
    }

    public ListMetricsResult withMetrics(Metric... metricArr) {
        if (getMetrics() == null) {
            setMetrics(new ArrayList(metricArr.length));
        }
        for (Object add : metricArr) {
            getMetrics().add(add);
        }
        return this;
    }

    public ListMetricsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
