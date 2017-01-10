package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.cloudwatch.model.MissingRequiredParameterException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class MissingRequiredParameterExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public MissingRequiredParameterExceptionUnmarshaller() {
        super(MissingRequiredParameterException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("MissingParameter")) ? null : (MissingRequiredParameterException) super.unmarshall(node);
    }
}
