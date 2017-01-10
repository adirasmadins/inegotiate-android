package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.BatchRequestTooLongException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class BatchRequestTooLongExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public BatchRequestTooLongExceptionUnmarshaller() {
        super(BatchRequestTooLongException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.BatchRequestTooLong")) ? null : (BatchRequestTooLongException) super.unmarshall(node);
    }
}
