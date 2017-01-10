package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteMessageBatchRequestMarshaller implements Marshaller<Request<DeleteMessageBatchRequest>, DeleteMessageBatchRequest> {
    public Request<DeleteMessageBatchRequest> marshall(DeleteMessageBatchRequest deleteMessageBatchRequest) {
        if (deleteMessageBatchRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteMessageBatchRequest> defaultRequest = new DefaultRequest(deleteMessageBatchRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "DeleteMessageBatch");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (deleteMessageBatchRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(deleteMessageBatchRequest.getQueueUrl()));
        }
        int i = 1;
        for (DeleteMessageBatchRequestEntry deleteMessageBatchRequestEntry : deleteMessageBatchRequest.getEntries()) {
            if (deleteMessageBatchRequestEntry != null) {
                if (deleteMessageBatchRequestEntry.getId() != null) {
                    defaultRequest.addParameter("DeleteMessageBatchRequestEntry." + i + ".Id", StringUtils.fromString(deleteMessageBatchRequestEntry.getId()));
                }
                if (deleteMessageBatchRequestEntry.getReceiptHandle() != null) {
                    defaultRequest.addParameter("DeleteMessageBatchRequestEntry." + i + ".ReceiptHandle", StringUtils.fromString(deleteMessageBatchRequestEntry.getReceiptHandle()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
