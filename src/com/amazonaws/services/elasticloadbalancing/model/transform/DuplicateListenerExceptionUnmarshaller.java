package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.DuplicateListenerException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class DuplicateListenerExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public DuplicateListenerExceptionUnmarshaller() {
        super(DuplicateListenerException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("DuplicateListener")) ? null : (DuplicateListenerException) super.unmarshall(node);
    }
}
