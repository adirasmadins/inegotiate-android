package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RemovePermissionRequestMarshaller implements Marshaller<Request<RemovePermissionRequest>, RemovePermissionRequest> {
    public Request<RemovePermissionRequest> marshall(RemovePermissionRequest removePermissionRequest) {
        if (removePermissionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RemovePermissionRequest> defaultRequest = new DefaultRequest(removePermissionRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "RemovePermission");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (removePermissionRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(removePermissionRequest.getQueueUrl()));
        }
        if (removePermissionRequest.getLabel() != null) {
            defaultRequest.addParameter("Label", StringUtils.fromString(removePermissionRequest.getLabel()));
        }
        return defaultRequest;
    }
}
