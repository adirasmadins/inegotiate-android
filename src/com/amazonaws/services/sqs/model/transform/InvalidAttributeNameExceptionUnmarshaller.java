package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.InvalidAttributeNameException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidAttributeNameExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidAttributeNameExceptionUnmarshaller() {
        super(InvalidAttributeNameException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidAttributeName")) ? null : (InvalidAttributeNameException) super.unmarshall(node);
    }
}
