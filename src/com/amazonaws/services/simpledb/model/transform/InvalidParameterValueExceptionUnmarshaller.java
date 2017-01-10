package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.InvalidParameterValueException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class InvalidParameterValueExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public InvalidParameterValueExceptionUnmarshaller() {
        super(InvalidParameterValueException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidParameterValue")) {
            return null;
        }
        InvalidParameterValueException invalidParameterValueException = (InvalidParameterValueException) super.unmarshall(node);
        invalidParameterValueException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return invalidParameterValueException;
    }
}
