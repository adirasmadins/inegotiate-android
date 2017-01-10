package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.TooManyEntriesInBatchRequestException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class TooManyEntriesInBatchRequestExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public TooManyEntriesInBatchRequestExceptionUnmarshaller() {
        super(TooManyEntriesInBatchRequestException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.TooManyEntriesInBatchRequest")) ? null : (TooManyEntriesInBatchRequestException) super.unmarshall(node);
    }
}
