package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberDomainBytesExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberDomainBytesExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberDomainBytesExceededExceptionUnmarshaller() {
        super(NumberDomainBytesExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberDomainBytesExceeded")) {
            return null;
        }
        NumberDomainBytesExceededException numberDomainBytesExceededException = (NumberDomainBytesExceededException) super.unmarshall(node);
        numberDomainBytesExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberDomainBytesExceededException;
    }
}
