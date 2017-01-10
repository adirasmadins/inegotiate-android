package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeAutoScalingNotificationTypesRequest extends AmazonWebServiceRequest {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DescribeAutoScalingNotificationTypesRequest)) {
            return false;
        }
        DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest = (DescribeAutoScalingNotificationTypesRequest) obj;
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
