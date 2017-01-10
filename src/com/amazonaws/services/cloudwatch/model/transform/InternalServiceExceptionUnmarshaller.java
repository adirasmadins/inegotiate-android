package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.InternalServiceException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InternalServiceExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InternalServiceExceptionUnmarshaller() {
        super(InternalServiceException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InternalServiceError")) ? null : (InternalServiceException) super.unmarshall(node);
    }
}
