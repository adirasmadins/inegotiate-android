package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.LimitExceededException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class LimitExceededExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public LimitExceededExceptionUnmarshaller() {
        super(LimitExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("LimitExceeded")) ? null : (LimitExceededException) super.unmarshall(node);
    }
}
