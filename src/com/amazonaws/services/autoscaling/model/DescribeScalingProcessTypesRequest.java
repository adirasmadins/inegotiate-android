package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeScalingProcessTypesRequest extends AmazonWebServiceRequest {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DescribeScalingProcessTypesRequest)) {
            return false;
        }
        DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest = (DescribeScalingProcessTypesRequest) obj;
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
