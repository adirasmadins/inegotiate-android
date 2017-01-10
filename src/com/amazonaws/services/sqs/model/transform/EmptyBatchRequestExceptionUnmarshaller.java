package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.EmptyBatchRequestException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class EmptyBatchRequestExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public EmptyBatchRequestExceptionUnmarshaller() {
        super(EmptyBatchRequestException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.EmptyBatchRequest")) ? null : (EmptyBatchRequestException) super.unmarshall(node);
    }
}
