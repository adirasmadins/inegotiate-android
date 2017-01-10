package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ChangeMessageVisibilityBatchRequestMarshaller implements Marshaller<Request<ChangeMessageVisibilityBatchRequest>, ChangeMessageVisibilityBatchRequest> {
    public Request<ChangeMessageVisibilityBatchRequest> marshall(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
        if (changeMessageVisibilityBatchRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ChangeMessageVisibilityBatchRequest> defaultRequest = new DefaultRequest(changeMessageVisibilityBatchRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "ChangeMessageVisibilityBatch");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (changeMessageVisibilityBatchRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(changeMessageVisibilityBatchRequest.getQueueUrl()));
        }
        int i = 1;
        for (ChangeMessageVisibilityBatchRequestEntry changeMessageVisibilityBatchRequestEntry : changeMessageVisibilityBatchRequest.getEntries()) {
            if (changeMessageVisibilityBatchRequestEntry != null) {
                if (changeMessageVisibilityBatchRequestEntry.getId() != null) {
                    defaultRequest.addParameter("ChangeMessageVisibilityBatchRequestEntry." + i + ".Id", StringUtils.fromString(changeMessageVisibilityBatchRequestEntry.getId()));
                }
                if (changeMessageVisibilityBatchRequestEntry.getReceiptHandle() != null) {
                    defaultRequest.addParameter("ChangeMessageVisibilityBatchRequestEntry." + i + ".ReceiptHandle", StringUtils.fromString(changeMessageVisibilityBatchRequestEntry.getReceiptHandle()));
                }
                if (changeMessageVisibilityBatchRequestEntry.getVisibilityTimeout() != null) {
                    defaultRequest.addParameter("ChangeMessageVisibilityBatchRequestEntry." + i + ".VisibilityTimeout", StringUtils.fromInteger(changeMessageVisibilityBatchRequestEntry.getVisibilityTimeout()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
