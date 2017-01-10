package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.InvalidMessageContentsException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidMessageContentsExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidMessageContentsExceptionUnmarshaller() {
        super(InvalidMessageContentsException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidMessageContents")) ? null : (InvalidMessageContentsException) super.unmarshall(node);
    }
}
