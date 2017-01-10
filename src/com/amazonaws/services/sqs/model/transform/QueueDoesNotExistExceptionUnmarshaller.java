package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class QueueDoesNotExistExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public QueueDoesNotExistExceptionUnmarshaller() {
        super(QueueDoesNotExistException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.QueueDoesNotExist")) ? null : (QueueDoesNotExistException) super.unmarshall(node);
    }
}
