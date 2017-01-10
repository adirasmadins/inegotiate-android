package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.InvalidFormatException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidFormatExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidFormatExceptionUnmarshaller() {
        super(InvalidFormatException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidFormat")) ? null : (InvalidFormatException) super.unmarshall(node);
    }
}
