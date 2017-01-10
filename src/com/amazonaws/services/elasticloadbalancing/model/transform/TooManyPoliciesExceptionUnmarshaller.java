package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.TooManyPoliciesException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class TooManyPoliciesExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public TooManyPoliciesExceptionUnmarshaller() {
        super(TooManyPoliciesException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("TooManyPolicies")) ? null : (TooManyPoliciesException) super.unmarshall(node);
    }
}
