package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.ReceiptHandleIsInvalidException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class ReceiptHandleIsInvalidExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public ReceiptHandleIsInvalidExceptionUnmarshaller() {
        super(ReceiptHandleIsInvalidException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("ReceiptHandleIsInvalid")) ? null : (ReceiptHandleIsInvalidException) super.unmarshall(node);
    }
}
