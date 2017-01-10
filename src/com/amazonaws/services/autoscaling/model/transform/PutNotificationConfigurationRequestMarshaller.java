package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.PutNotificationConfigurationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutNotificationConfigurationRequestMarshaller implements Marshaller<Request<PutNotificationConfigurationRequest>, PutNotificationConfigurationRequest> {
    public Request<PutNotificationConfigurationRequest> marshall(PutNotificationConfigurationRequest putNotificationConfigurationRequest) {
        if (putNotificationConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutNotificationConfigurationRequest> defaultRequest = new DefaultRequest(putNotificationConfigurationRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "PutNotificationConfiguration");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (putNotificationConfigurationRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(putNotificationConfigurationRequest.getAutoScalingGroupName()));
        }
        if (putNotificationConfigurationRequest.getTopicARN() != null) {
            defaultRequest.addParameter("TopicARN", StringUtils.fromString(putNotificationConfigurationRequest.getTopicARN()));
        }
        int i = 1;
        for (String str : putNotificationConfigurationRequest.getNotificationTypes()) {
            if (str != null) {
                defaultRequest.addParameter("NotificationTypes.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
