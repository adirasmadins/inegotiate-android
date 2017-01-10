package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeleteScheduledActionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteScheduledActionRequestMarshaller implements Marshaller<Request<DeleteScheduledActionRequest>, DeleteScheduledActionRequest> {
    public Request<DeleteScheduledActionRequest> marshall(DeleteScheduledActionRequest deleteScheduledActionRequest) {
        if (deleteScheduledActionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteScheduledActionRequest> defaultRequest = new DefaultRequest(deleteScheduledActionRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeleteScheduledAction");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (deleteScheduledActionRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(deleteScheduledActionRequest.getAutoScalingGroupName()));
        }
        if (deleteScheduledActionRequest.getScheduledActionName() != null) {
            defaultRequest.addParameter("ScheduledActionName", StringUtils.fromString(deleteScheduledActionRequest.getScheduledActionName()));
        }
        return defaultRequest;
    }
}
