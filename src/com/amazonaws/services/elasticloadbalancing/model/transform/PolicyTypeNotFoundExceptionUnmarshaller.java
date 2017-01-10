package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.PolicyTypeNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class PolicyTypeNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public PolicyTypeNotFoundExceptionUnmarshaller() {
        super(PolicyTypeNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("PolicyTypeNotFound")) ? null : (PolicyTypeNotFoundException) super.unmarshall(node);
    }
}
