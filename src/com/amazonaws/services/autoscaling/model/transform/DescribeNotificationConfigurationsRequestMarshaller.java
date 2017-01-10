package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeNotificationConfigurationsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeNotificationConfigurationsRequestMarshaller implements Marshaller<Request<DescribeNotificationConfigurationsRequest>, DescribeNotificationConfigurationsRequest> {
    public Request<DescribeNotificationConfigurationsRequest> marshall(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) {
        if (describeNotificationConfigurationsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeNotificationConfigurationsRequest> defaultRequest = new DefaultRequest(describeNotificationConfigurationsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeNotificationConfigurations");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (String str : describeNotificationConfigurationsRequest.getAutoScalingGroupNames()) {
            if (str != null) {
                defaultRequest.addParameter("AutoScalingGroupNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeNotificationConfigurationsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeNotificationConfigurationsRequest.getNextToken()));
        }
        if (describeNotificationConfigurationsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeNotificationConfigurationsRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
