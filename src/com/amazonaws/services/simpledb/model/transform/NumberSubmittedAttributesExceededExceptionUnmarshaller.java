package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberSubmittedAttributesExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberSubmittedAttributesExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberSubmittedAttributesExceededExceptionUnmarshaller() {
        super(NumberSubmittedAttributesExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberSubmittedAttributesExceeded")) {
            return null;
        }
        NumberSubmittedAttributesExceededException numberSubmittedAttributesExceededException = (NumberSubmittedAttributesExceededException) super.unmarshall(node);
        numberSubmittedAttributesExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberSubmittedAttributesExceededException;
    }
}
