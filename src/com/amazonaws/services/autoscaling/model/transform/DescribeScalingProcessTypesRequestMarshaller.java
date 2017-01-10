package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeScalingProcessTypesRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeScalingProcessTypesRequestMarshaller implements Marshaller<Request<DescribeScalingProcessTypesRequest>, DescribeScalingProcessTypesRequest> {
    public Request<DescribeScalingProcessTypesRequest> marshall(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) {
        if (describeScalingProcessTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeScalingProcessTypesRequest> defaultRequest = new DefaultRequest(describeScalingProcessTypesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeScalingProcessTypes");
        defaultRequest.addParameter("Version", "2011-01-01");
        return defaultRequest;
    }
}
