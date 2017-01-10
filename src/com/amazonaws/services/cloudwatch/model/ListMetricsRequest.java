package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMetricsRequest extends AmazonWebServiceRequest {
    private List<DimensionFilter> dimensions;
    private String metricName;
    private String namespace;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListMetricsRequest)) {
            return false;
        }
        ListMetricsRequest listMetricsRequest = (ListMetricsRequest) obj;
        if (((listMetricsRequest.getNamespace() == null ? 1 : 0) ^ (getNamespace() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listMetricsRequest.getNamespace() != null && !listMetricsRequest.getNamespace().equals(getNamespace())) {
            return false;
        }
        if (((listMetricsRequest.getMetricName() == null ? 1 : 0) ^ (getMetricName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listMetricsRequest.getMetricName() != null && !listMetricsRequest.getMetricName().equals(getMetricName())) {
            return false;
        }
        if (((listMetricsRequest.getDimensions() == null ? 1 : 0) ^ (getDimensions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listMetricsRequest.getDimensions() != null && !listMetricsRequest.getDimensions().equals(getDimensions())) {
            return false;
        }
        return ((listMetricsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listMetricsRequest.getNextToken() == null || listMetricsRequest.getNextToken().equals(getNextToken()) : false;
    }

    public List<DimensionFilter> getDimensions() {
        if (this.dimensions == null) {
            this.dimensions = new ArrayList();
        }
        return this.dimensions;
    }

    public String getMetricName() {
        return this.metricName;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDimensions() == null ? 0 : getDimensions().hashCode()) + (((getMetricName() == null ? 0 : getMetricName().hashCode()) + (((getNamespace() == null ? 0 : getNamespace().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setDimensions(Collection<DimensionFilter> collection) {
        if (collection == null) {
            this.dimensions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.dimensions = arrayList;
    }

    public void setMetricName(String str) {
        this.metricName = str;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.namespace != null) {
            stringBuilder.append("Namespace: " + this.namespace + ", ");
        }
        if (this.metricName != null) {
            stringBuilder.append("MetricName: " + this.metricName + ", ");
        }
        if (this.dimensions != null) {
            stringBuilder.append("Dimensions: " + this.dimensions + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListMetricsRequest withDimensions(Collection<DimensionFilter> collection) {
        if (collection == null) {
            this.dimensions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.dimensions = arrayList;
        }
        return this;
    }

    public ListMetricsRequest withDimensions(DimensionFilter... dimensionFilterArr) {
        if (getDimensions() == null) {
            setDimensions(new ArrayList(dimensionFilterArr.length));
        }
        for (Object add : dimensionFilterArr) {
            getDimensions().add(add);
        }
        return this;
    }

    public ListMetricsRequest withMetricName(String str) {
        this.metricName = str;
        return this;
    }

    public ListMetricsRequest withNamespace(String str) {
        this.namespace = str;
        return this;
    }

    public ListMetricsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
