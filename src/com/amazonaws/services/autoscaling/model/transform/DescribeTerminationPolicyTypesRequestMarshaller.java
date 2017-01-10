package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeTerminationPolicyTypesRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeTerminationPolicyTypesRequestMarshaller implements Marshaller<Request<DescribeTerminationPolicyTypesRequest>, DescribeTerminationPolicyTypesRequest> {
    public Request<DescribeTerminationPolicyTypesRequest> marshall(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) {
        if (describeTerminationPolicyTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeTerminationPolicyTypesRequest> defaultRequest = new DefaultRequest(describeTerminationPolicyTypesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeTerminationPolicyTypes");
        defaultRequest.addParameter("Version", "2011-01-01");
        return defaultRequest;
    }
}
