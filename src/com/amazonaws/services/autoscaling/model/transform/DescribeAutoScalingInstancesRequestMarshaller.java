package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAutoScalingInstancesRequestMarshaller implements Marshaller<Request<DescribeAutoScalingInstancesRequest>, DescribeAutoScalingInstancesRequest> {
    public Request<DescribeAutoScalingInstancesRequest> marshall(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) {
        if (describeAutoScalingInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAutoScalingInstancesRequest> defaultRequest = new DefaultRequest(describeAutoScalingInstancesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeAutoScalingInstances");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (String str : describeAutoScalingInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceIds.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeAutoScalingInstancesRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeAutoScalingInstancesRequest.getMaxRecords()));
        }
        if (describeAutoScalingInstancesRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeAutoScalingInstancesRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
