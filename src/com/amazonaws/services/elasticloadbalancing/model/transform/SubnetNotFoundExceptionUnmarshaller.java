package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.SubnetNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class SubnetNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public SubnetNotFoundExceptionUnmarshaller() {
        super(SubnetNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("SubnetNotFound")) ? null : (SubnetNotFoundException) super.unmarshall(node);
    }
}
