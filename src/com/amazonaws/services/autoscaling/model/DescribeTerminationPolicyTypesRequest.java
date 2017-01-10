package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;

public class DescribeTerminationPolicyTypesRequest extends AmazonWebServiceRequest {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof DescribeTerminationPolicyTypesRequest)) {
            return false;
        }
        DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest = (DescribeTerminationPolicyTypesRequest) obj;
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
