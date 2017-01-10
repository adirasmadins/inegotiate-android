package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteMessageRequestMarshaller implements Marshaller<Request<DeleteMessageRequest>, DeleteMessageRequest> {
    public Request<DeleteMessageRequest> marshall(DeleteMessageRequest deleteMessageRequest) {
        if (deleteMessageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteMessageRequest> defaultRequest = new DefaultRequest(deleteMessageRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "DeleteMessage");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (deleteMessageRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(deleteMessageRequest.getQueueUrl()));
        }
        if (deleteMessageRequest.getReceiptHandle() != null) {
            defaultRequest.addParameter("ReceiptHandle", StringUtils.fromString(deleteMessageRequest.getReceiptHandle()));
        }
        return defaultRequest;
    }
}
