package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ChangeMessageVisibilityRequestMarshaller implements Marshaller<Request<ChangeMessageVisibilityRequest>, ChangeMessageVisibilityRequest> {
    public Request<ChangeMessageVisibilityRequest> marshall(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
        if (changeMessageVisibilityRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ChangeMessageVisibilityRequest> defaultRequest = new DefaultRequest(changeMessageVisibilityRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "ChangeMessageVisibility");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (changeMessageVisibilityRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(changeMessageVisibilityRequest.getQueueUrl()));
        }
        if (changeMessageVisibilityRequest.getReceiptHandle() != null) {
            defaultRequest.addParameter("ReceiptHandle", StringUtils.fromString(changeMessageVisibilityRequest.getReceiptHandle()));
        }
        if (changeMessageVisibilityRequest.getVisibilityTimeout() != null) {
            defaultRequest.addParameter("VisibilityTimeout", StringUtils.fromInteger(changeMessageVisibilityRequest.getVisibilityTimeout()));
        }
        return defaultRequest;
    }
}
