package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.InvalidParameterCombinationException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidParameterCombinationExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidParameterCombinationExceptionUnmarshaller() {
        super(InvalidParameterCombinationException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidParameterCombination")) ? null : (InvalidParameterCombinationException) super.unmarshall(node);
    }
}
