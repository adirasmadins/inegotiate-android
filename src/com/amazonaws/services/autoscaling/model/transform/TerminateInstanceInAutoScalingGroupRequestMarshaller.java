package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.TerminateInstanceInAutoScalingGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class TerminateInstanceInAutoScalingGroupRequestMarshaller implements Marshaller<Request<TerminateInstanceInAutoScalingGroupRequest>, TerminateInstanceInAutoScalingGroupRequest> {
    public Request<TerminateInstanceInAutoScalingGroupRequest> marshall(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) {
        if (terminateInstanceInAutoScalingGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<TerminateInstanceInAutoScalingGroupRequest> defaultRequest = new DefaultRequest(terminateInstanceInAutoScalingGroupRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "TerminateInstanceInAutoScalingGroup");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (terminateInstanceInAutoScalingGroupRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(terminateInstanceInAutoScalingGroupRequest.getInstanceId()));
        }
        if (terminateInstanceInAutoScalingGroupRequest.isShouldDecrementDesiredCapacity() != null) {
            defaultRequest.addParameter("ShouldDecrementDesiredCapacity", StringUtils.fromBoolean(terminateInstanceInAutoScalingGroupRequest.isShouldDecrementDesiredCapacity()));
        }
        return defaultRequest;
    }
}
