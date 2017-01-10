package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.InvalidNextTokenException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidNextTokenExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidNextTokenExceptionUnmarshaller() {
        super(InvalidNextTokenException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidNextToken")) ? null : (InvalidNextTokenException) super.unmarshall(node);
    }
}
