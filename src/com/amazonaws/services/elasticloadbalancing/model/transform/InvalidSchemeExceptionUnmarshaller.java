package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.InvalidSchemeException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidSchemeExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidSchemeExceptionUnmarshaller() {
        super(InvalidSchemeException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidScheme")) ? null : (InvalidSchemeException) super.unmarshall(node);
    }
}
