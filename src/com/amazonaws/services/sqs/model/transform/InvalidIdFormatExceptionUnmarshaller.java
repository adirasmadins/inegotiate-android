package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.InvalidIdFormatException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidIdFormatExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidIdFormatExceptionUnmarshaller() {
        super(InvalidIdFormatException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidIdFormat")) ? null : (InvalidIdFormatException) super.unmarshall(node);
    }
}
