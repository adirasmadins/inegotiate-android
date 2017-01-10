package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeScalingActivitiesRequestMarshaller implements Marshaller<Request<DescribeScalingActivitiesRequest>, DescribeScalingActivitiesRequest> {
    public Request<DescribeScalingActivitiesRequest> marshall(DescribeScalingActivitiesRequest describeScalingActivitiesRequest) {
        if (describeScalingActivitiesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeScalingActivitiesRequest> defaultRequest = new DefaultRequest(describeScalingActivitiesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeScalingActivities");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (String str : describeScalingActivitiesRequest.getActivityIds()) {
            if (str != null) {
                defaultRequest.addParameter("ActivityIds.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeScalingActivitiesRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(describeScalingActivitiesRequest.getAutoScalingGroupName()));
        }
        if (describeScalingActivitiesRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeScalingActivitiesRequest.getMaxRecords()));
        }
        if (describeScalingActivitiesRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeScalingActivitiesRequest.getNextToken()));
        }
        return defaultRequest;
    }
}
