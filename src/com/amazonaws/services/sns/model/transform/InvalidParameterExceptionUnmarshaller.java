package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.model.InvalidParameterException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidParameterExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidParameterExceptionUnmarshaller() {
        super(InvalidParameterException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidParameter")) ? null : (InvalidParameterException) super.unmarshall(node);
    }
}
