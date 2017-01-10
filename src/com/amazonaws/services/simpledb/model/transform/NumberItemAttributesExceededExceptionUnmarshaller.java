package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberItemAttributesExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberItemAttributesExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberItemAttributesExceededExceptionUnmarshaller() {
        super(NumberItemAttributesExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberItemAttributesExceeded")) {
            return null;
        }
        NumberItemAttributesExceededException numberItemAttributesExceededException = (NumberItemAttributesExceededException) super.unmarshall(node);
        numberItemAttributesExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberItemAttributesExceededException;
    }
}
