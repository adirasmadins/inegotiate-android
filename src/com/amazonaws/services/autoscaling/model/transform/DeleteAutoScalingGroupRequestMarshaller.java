package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeleteAutoScalingGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteAutoScalingGroupRequestMarshaller implements Marshaller<Request<DeleteAutoScalingGroupRequest>, DeleteAutoScalingGroupRequest> {
    public Request<DeleteAutoScalingGroupRequest> marshall(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) {
        if (deleteAutoScalingGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteAutoScalingGroupRequest> defaultRequest = new DefaultRequest(deleteAutoScalingGroupRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeleteAutoScalingGroup");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (deleteAutoScalingGroupRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(deleteAutoScalingGroupRequest.getAutoScalingGroupName()));
        }
        if (deleteAutoScalingGroupRequest.isForceDelete() != null) {
            defaultRequest.addParameter("ForceDelete", StringUtils.fromBoolean(deleteAutoScalingGroupRequest.isForceDelete()));
        }
        return defaultRequest;
    }
}
