package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RemovePermissionRequestMarshaller implements Marshaller<Request<RemovePermissionRequest>, RemovePermissionRequest> {
    public Request<RemovePermissionRequest> marshall(RemovePermissionRequest removePermissionRequest) {
        if (removePermissionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RemovePermissionRequest> defaultRequest = new DefaultRequest(removePermissionRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "RemovePermission");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (removePermissionRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(removePermissionRequest.getTopicArn()));
        }
        if (removePermissionRequest.getLabel() != null) {
            defaultRequest.addParameter("Label", StringUtils.fromString(removePermissionRequest.getLabel()));
        }
        return defaultRequest;
    }
}
