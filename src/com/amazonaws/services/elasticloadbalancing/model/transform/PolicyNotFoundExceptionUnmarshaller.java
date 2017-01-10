package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.PolicyNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class PolicyNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public PolicyNotFoundExceptionUnmarshaller() {
        super(PolicyNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("PolicyNotFound")) ? null : (PolicyNotFoundException) super.unmarshall(node);
    }
}
