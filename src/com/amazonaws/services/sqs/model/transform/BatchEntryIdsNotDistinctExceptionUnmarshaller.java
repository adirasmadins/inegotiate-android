package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.BatchEntryIdsNotDistinctException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class BatchEntryIdsNotDistinctExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public BatchEntryIdsNotDistinctExceptionUnmarshaller() {
        super(BatchEntryIdsNotDistinctException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.BatchEntryIdsNotDistinct")) ? null : (BatchEntryIdsNotDistinctException) super.unmarshall(node);
    }
}
