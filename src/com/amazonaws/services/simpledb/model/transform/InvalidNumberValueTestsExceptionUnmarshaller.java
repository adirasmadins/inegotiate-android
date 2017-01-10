package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.InvalidNumberValueTestsException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class InvalidNumberValueTestsExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public InvalidNumberValueTestsExceptionUnmarshaller() {
        super(InvalidNumberValueTestsException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidNumberValueTests")) {
            return null;
        }
        InvalidNumberValueTestsException invalidNumberValueTestsException = (InvalidNumberValueTestsException) super.unmarshall(node);
        invalidNumberValueTestsException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return invalidNumberValueTestsException;
    }
}
