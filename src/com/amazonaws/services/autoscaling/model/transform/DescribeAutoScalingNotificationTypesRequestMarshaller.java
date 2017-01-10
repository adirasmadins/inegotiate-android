package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingNotificationTypesRequest;
import com.amazonaws.transform.Marshaller;

public class DescribeAutoScalingNotificationTypesRequestMarshaller implements Marshaller<Request<DescribeAutoScalingNotificationTypesRequest>, DescribeAutoScalingNotificationTypesRequest> {
    public Request<DescribeAutoScalingNotificationTypesRequest> marshall(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) {
        if (describeAutoScalingNotificationTypesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeAutoScalingNotificationTypesRequest> defaultRequest = new DefaultRequest(describeAutoScalingNotificationTypesRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeAutoScalingNotificationTypes");
        defaultRequest.addParameter("Version", "2011-01-01");
        return defaultRequest;
    }
}
