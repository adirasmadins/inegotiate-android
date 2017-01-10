package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class SendMessageBatchRequestMarshaller implements Marshaller<Request<SendMessageBatchRequest>, SendMessageBatchRequest> {
    public Request<SendMessageBatchRequest> marshall(SendMessageBatchRequest sendMessageBatchRequest) {
        if (sendMessageBatchRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<SendMessageBatchRequest> defaultRequest = new DefaultRequest(sendMessageBatchRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "SendMessageBatch");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (sendMessageBatchRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(sendMessageBatchRequest.getQueueUrl()));
        }
        int i = 1;
        for (SendMessageBatchRequestEntry sendMessageBatchRequestEntry : sendMessageBatchRequest.getEntries()) {
            if (sendMessageBatchRequestEntry != null) {
                if (sendMessageBatchRequestEntry.getId() != null) {
                    defaultRequest.addParameter("SendMessageBatchRequestEntry." + i + ".Id", StringUtils.fromString(sendMessageBatchRequestEntry.getId()));
                }
                if (sendMessageBatchRequestEntry.getMessageBody() != null) {
                    defaultRequest.addParameter("SendMessageBatchRequestEntry." + i + ".MessageBody", StringUtils.fromString(sendMessageBatchRequestEntry.getMessageBody()));
                }
                if (sendMessageBatchRequestEntry.getDelaySeconds() != null) {
                    defaultRequest.addParameter("SendMessageBatchRequestEntry." + i + ".DelaySeconds", StringUtils.fromInteger(sendMessageBatchRequestEntry.getDelaySeconds()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
