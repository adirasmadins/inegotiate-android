package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.InvalidBatchEntryIdException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidBatchEntryIdExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidBatchEntryIdExceptionUnmarshaller() {
        super(InvalidBatchEntryIdException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.InvalidBatchEntryId")) ? null : (InvalidBatchEntryIdException) super.unmarshall(node);
    }
}
