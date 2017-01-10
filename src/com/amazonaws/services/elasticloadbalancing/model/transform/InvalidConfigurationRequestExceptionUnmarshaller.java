package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.InvalidConfigurationRequestException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class InvalidConfigurationRequestExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public InvalidConfigurationRequestExceptionUnmarshaller() {
        super(InvalidConfigurationRequestException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("InvalidConfigurationRequest")) ? null : (InvalidConfigurationRequestException) super.unmarshall(node);
    }
}
