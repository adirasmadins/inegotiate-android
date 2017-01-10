package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeMetricCollectionTypesRequest extends AmazonWebServiceRequest {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DescribeMetricCollectionTypesRequest)) {
            return false;
        }
        DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest = (DescribeMetricCollectionTypesRequest) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
