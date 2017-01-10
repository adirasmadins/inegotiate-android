package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.InvalidQueryExpressionException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class InvalidQueryExpressionExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public InvalidQueryExpressionExceptionUnmarshaller() {
        super(InvalidQueryExpressionException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("InvalidQueryExpression")) {
            return null;
        }
        InvalidQueryExpressionException invalidQueryExpressionException = (InvalidQueryExpressionException) super.unmarshall(node);
        invalidQueryExpressionException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return invalidQueryExpressionException;
    }
}
