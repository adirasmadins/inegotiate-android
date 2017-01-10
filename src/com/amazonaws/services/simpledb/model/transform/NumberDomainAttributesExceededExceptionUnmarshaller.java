package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberDomainAttributesExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberDomainAttributesExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberDomainAttributesExceededExceptionUnmarshaller() {
        super(NumberDomainAttributesExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberDomainAttributesExceeded")) {
            return null;
        }
        NumberDomainAttributesExceededException numberDomainAttributesExceededException = (NumberDomainAttributesExceededException) super.unmarshall(node);
        numberDomainAttributesExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberDomainAttributesExceededException;
    }
}
