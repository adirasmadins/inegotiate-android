package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.QueueNameExistsException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class QueueNameExistsExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public QueueNameExistsExceptionUnmarshaller() {
        super(QueueNameExistsException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.QueueNameExists")) ? null : (QueueNameExistsException) super.unmarshall(node);
    }
}
