package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeAutoScalingGroupsRequestMarshaller implements Marshaller<Request<DescribeAutoScalingGroupsRequest>, DescribeAutoScalingGroupsRequest> {
    public Request<DescribeAutoScalingGroupsRequest> marshall(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) {
        if (describeAutoScalingGroupsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAutoScalingGroupsRequest> defaultRequest = new DefaultRequest(describeAutoScalingGroupsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeAutoScalingGroups");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (String str : describeAutoScalingGroupsRequest.getAutoScalingGroupNames()) {
            if (str != null) {
                defaultRequest.addParameter("AutoScalingGroupNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeAutoScalingGroupsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeAutoScalingGroupsRequest.getNextToken()));
        }
        if (describeAutoScalingGroupsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeAutoScalingGroupsRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
