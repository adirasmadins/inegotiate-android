package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.LoadBalancerNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class LoadBalancerNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public LoadBalancerNotFoundExceptionUnmarshaller() {
        super(LoadBalancerNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("LoadBalancerNotFound")) ? null : (LoadBalancerNotFoundException) super.unmarshall(node);
    }
}
