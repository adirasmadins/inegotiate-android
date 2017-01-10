package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.ResourceInUseException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class ResourceInUseExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public ResourceInUseExceptionUnmarshaller() {
        super(ResourceInUseException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("ResourceInUse")) ? null : (ResourceInUseException) super.unmarshall(node);
    }
}
