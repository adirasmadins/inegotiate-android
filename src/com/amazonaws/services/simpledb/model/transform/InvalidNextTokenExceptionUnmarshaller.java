package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.InvalidNextTokenException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class InvalidNextTokenExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public InvalidNextTokenExceptionUnmarshaller() {
        super(InvalidNextTokenException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidNextToken")) {
            return null;
        }
        InvalidNextTokenException invalidNextTokenException = (InvalidNextTokenException) super.unmarshall(node);
        invalidNextTokenException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return invalidNextTokenException;
    }
}
