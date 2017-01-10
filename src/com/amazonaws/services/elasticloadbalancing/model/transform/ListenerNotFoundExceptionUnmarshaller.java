package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elasticloadbalancing.model.ListenerNotFoundException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class ListenerNotFoundExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public ListenerNotFoundExceptionUnmarshaller() {
        super(ListenerNotFoundException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("ListenerNotFound")) ? null : (ListenerNotFoundException) super.unmarshall(node);
    }
}
