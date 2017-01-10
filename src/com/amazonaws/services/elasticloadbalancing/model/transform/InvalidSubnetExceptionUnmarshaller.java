package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.InvalidSubnetException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidSubnetExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidSubnetExceptionUnmarshaller() {
        super(InvalidSubnetException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidSubnet")) ? null : (InvalidSubnetException) super.unmarshall(node);
    }
}
