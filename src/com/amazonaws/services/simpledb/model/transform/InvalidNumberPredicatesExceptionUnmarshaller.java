package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.InvalidNumberPredicatesException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class InvalidNumberPredicatesExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public InvalidNumberPredicatesExceptionUnmarshaller() {
        super(InvalidNumberPredicatesException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidNumberPredicates")) {
            return null;
        }
        InvalidNumberPredicatesException invalidNumberPredicatesException = (InvalidNumberPredicatesException) super.unmarshall(node);
        invalidNumberPredicatesException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return invalidNumberPredicatesException;
    }
}
