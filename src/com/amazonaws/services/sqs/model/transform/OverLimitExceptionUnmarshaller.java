package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.OverLimitException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class OverLimitExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public OverLimitExceptionUnmarshaller() {
        super(OverLimitException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("OverLimit")) ? null : (OverLimitException) super.unmarshall(node);
    }
}
