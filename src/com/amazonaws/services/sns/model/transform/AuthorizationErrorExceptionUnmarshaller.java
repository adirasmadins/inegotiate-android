package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.model.AuthorizationErrorException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class AuthorizationErrorExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public AuthorizationErrorExceptionUnmarshaller() {
        super(AuthorizationErrorException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AuthorizationError")) ? null : (AuthorizationErrorException) super.unmarshall(node);
    }
}
