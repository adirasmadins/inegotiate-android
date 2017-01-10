package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeScheduledActionsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeScheduledActionsRequestMarshaller implements Marshaller<Request<DescribeScheduledActionsRequest>, DescribeScheduledActionsRequest> {
    public Request<DescribeScheduledActionsRequest> marshall(DescribeScheduledActionsRequest describeScheduledActionsRequest) {
        if (describeScheduledActionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeScheduledActionsRequest> defaultRequest = new DefaultRequest(describeScheduledActionsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeScheduledActions");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (describeScheduledActionsRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(describeScheduledActionsRequest.getAutoScalingGroupName()));
        }
        int i = 1;
        for (String str : describeScheduledActionsRequest.getScheduledActionNames()) {
            if (str != null) {
                defaultRequest.addParameter("ScheduledActionNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeScheduledActionsRequest.getStartTime() != null) {
            defaultRequest.addParameter("StartTime", StringUtils.fromDate(describeScheduledActionsRequest.getStartTime()));
        }
        if (describeScheduledActionsRequest.getEndTime() != null) {
            defaultRequest.addParameter("EndTime", StringUtils.fromDate(describeScheduledActionsRequest.getEndTime()));
        }
        if (describeScheduledActionsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeScheduledActionsRequest.getNextToken()));
        }
        if (describeScheduledActionsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeScheduledActionsRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
