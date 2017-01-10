package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeleteNotificationConfigurationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteNotificationConfigurationRequestMarshaller implements Marshaller<Request<DeleteNotificationConfigurationRequest>, DeleteNotificationConfigurationRequest> {
    public Request<DeleteNotificationConfigurationRequest> marshall(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) {
        if (deleteNotificationConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteNotificationConfigurationRequest> defaultRequest = new DefaultRequest(deleteNotificationConfigurationRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeleteNotificationConfiguration");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (deleteNotificationConfigurationRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(deleteNotificationConfigurationRequest.getAutoScalingGroupName()));
        }
        if (deleteNotificationConfigurationRequest.getTopicARN() != null) {
            defaultRequest.addParameter("TopicARN", StringUtils.fromString(deleteNotificationConfigurationRequest.getTopicARN()));
        }
        return defaultRequest;
    }
}
