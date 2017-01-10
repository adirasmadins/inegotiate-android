package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.InvalidInstanceException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidInstanceExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidInstanceExceptionUnmarshaller() {
        super(InvalidInstanceException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidInstance")) ? null : (InvalidInstanceException) super.unmarshall(node);
    }
}
