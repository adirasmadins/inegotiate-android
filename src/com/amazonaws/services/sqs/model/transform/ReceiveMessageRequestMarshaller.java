package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ReceiveMessageRequestMarshaller implements Marshaller<Request<ReceiveMessageRequest>, ReceiveMessageRequest> {
    public Request<ReceiveMessageRequest> marshall(ReceiveMessageRequest receiveMessageRequest) {
        if (receiveMessageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ReceiveMessageRequest> defaultRequest = new DefaultRequest(receiveMessageRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "ReceiveMessage");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (receiveMessageRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(receiveMessageRequest.getQueueUrl()));
        }
        int i = 1;
        for (String str : receiveMessageRequest.getAttributeNames()) {
            if (str != null) {
                defaultRequest.addParameter("AttributeName." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (receiveMessageRequest.getMaxNumberOfMessages() != null) {
            defaultRequest.addParameter("MaxNumberOfMessages", StringUtils.fromInteger(receiveMessageRequest.getMaxNumberOfMessages()));
        }
        if (receiveMessageRequest.getVisibilityTimeout() != null) {
            defaultRequest.addParameter("VisibilityTimeout", StringUtils.fromInteger(receiveMessageRequest.getVisibilityTimeout()));
        }
        return defaultRequest;
    }
}
