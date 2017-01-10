package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SetIdentityNotificationTopicRequestMarshaller implements Marshaller<Request<SetIdentityNotificationTopicRequest>, SetIdentityNotificationTopicRequest> {
    public Request<SetIdentityNotificationTopicRequest> marshall(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest) {
        if (setIdentityNotificationTopicRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SetIdentityNotificationTopicRequest> defaultRequest = new DefaultRequest(setIdentityNotificationTopicRequest, "AmazonSimpleEmailService");
        defaultRequest.addParameter("Action", "SetIdentityNotificationTopic");
        defaultRequest.addParameter("Version", "2010-12-01");
        if (setIdentityNotificationTopicRequest.getIdentity() != null) {
            defaultRequest.addParameter("Identity", StringUtils.fromString(setIdentityNotificationTopicRequest.getIdentity()));
        }
        if (setIdentityNotificationTopicRequest.getNotificationType() != null) {
            defaultRequest.addParameter("NotificationType", StringUtils.fromString(setIdentityNotificationTopicRequest.getNotificationType()));
        }
        if (setIdentityNotificationTopicRequest.getSnsTopic() != null) {
            defaultRequest.addParameter("SnsTopic", StringUtils.fromString(setIdentityNotificationTopicRequest.getSnsTopic()));
        }
        return defaultRequest;
    }
}
