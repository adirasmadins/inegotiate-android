package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.model.TopicLimitExceededException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class TopicLimitExceededExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public TopicLimitExceededExceptionUnmarshaller() {
        super(TopicLimitExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("TopicLimitExceeded")) ? null : (TopicLimitExceededException) super.unmarshall(node);
    }
}
