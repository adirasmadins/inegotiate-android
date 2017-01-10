package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.InvalidParameterValueException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidParameterValueExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidParameterValueExceptionUnmarshaller() {
        super(InvalidParameterValueException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidParameterValue")) ? null : (InvalidParameterValueException) super.unmarshall(node);
    }
}
