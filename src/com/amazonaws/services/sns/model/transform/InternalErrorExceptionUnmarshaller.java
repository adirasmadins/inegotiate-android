package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.model.InternalErrorException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InternalErrorExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InternalErrorExceptionUnmarshaller() {
        super(InternalErrorException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InternalError")) ? null : (InternalErrorException) super.unmarshall(node);
    }
}
