package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.QueueDeletedRecentlyException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class QueueDeletedRecentlyExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public QueueDeletedRecentlyExceptionUnmarshaller() {
        super(QueueDeletedRecentlyException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.QueueDeletedRecently")) ? null : (QueueDeletedRecentlyException) super.unmarshall(node);
    }
}
