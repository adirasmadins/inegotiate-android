package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.TooManyRequestedAttributesException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class TooManyRequestedAttributesExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public TooManyRequestedAttributesExceptionUnmarshaller() {
        super(TooManyRequestedAttributesException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("TooManyRequestedAttributes")) {
            return null;
        }
        TooManyRequestedAttributesException tooManyRequestedAttributesException = (TooManyRequestedAttributesException) super.unmarshall(node);
        tooManyRequestedAttributesException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return tooManyRequestedAttributesException;
    }
}
