package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.TooManyLoadBalancersException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class TooManyLoadBalancersExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public TooManyLoadBalancersExceptionUnmarshaller() {
        super(TooManyLoadBalancersException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("TooManyLoadBalancers")) ? null : (TooManyLoadBalancersException) super.unmarshall(node);
    }
}
