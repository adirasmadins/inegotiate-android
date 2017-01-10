package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.DuplicatePolicyNameException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class DuplicatePolicyNameExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public DuplicatePolicyNameExceptionUnmarshaller() {
        super(DuplicatePolicyNameException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("DuplicatePolicyName")) ? null : (DuplicatePolicyNameException) super.unmarshall(node);
    }
}
