package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.model.MessageRejectedException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class MessageRejectedExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public MessageRejectedExceptionUnmarshaller() {
        super(MessageRejectedException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("MessageRejected")) ? null : (MessageRejectedException) super.unmarshall(node);
    }
}
