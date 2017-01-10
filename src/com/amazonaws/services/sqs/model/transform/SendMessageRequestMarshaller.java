package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SendMessageRequestMarshaller implements Marshaller<Request<SendMessageRequest>, SendMessageRequest> {
    public Request<SendMessageRequest> marshall(SendMessageRequest sendMessageRequest) {
        if (sendMessageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SendMessageRequest> defaultRequest = new DefaultRequest(sendMessageRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "SendMessage");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (sendMessageRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(sendMessageRequest.getQueueUrl()));
        }
        if (sendMessageRequest.getMessageBody() != null) {
            defaultRequest.addParameter("MessageBody", StringUtils.fromString(sendMessageRequest.getMessageBody()));
        }
        if (sendMessageRequest.getDelaySeconds() != null) {
            defaultRequest.addParameter("DelaySeconds", StringUtils.fromInteger(sendMessageRequest.getDelaySeconds()));
        }
        return defaultRequest;
    }
}
