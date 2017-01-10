package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.AlreadyExistsException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class AlreadyExistsExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public AlreadyExistsExceptionUnmarshaller() {
        super(AlreadyExistsException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AlreadyExists")) ? null : (AlreadyExistsException) super.unmarshall(node);
    }
}
