package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.InvalidSecurityGroupException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidSecurityGroupExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidSecurityGroupExceptionUnmarshaller() {
        super(InvalidSecurityGroupException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidSecurityGroup")) ? null : (InvalidSecurityGroupException) super.unmarshall(node);
    }
}
