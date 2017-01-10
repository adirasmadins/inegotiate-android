package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.DuplicateLoadBalancerNameException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class DuplicateLoadBalancerNameExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public DuplicateLoadBalancerNameExceptionUnmarshaller() {
        super(DuplicateLoadBalancerNameException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("DuplicateLoadBalancerName")) ? null : (DuplicateLoadBalancerNameException) super.unmarshall(node);
    }
}
