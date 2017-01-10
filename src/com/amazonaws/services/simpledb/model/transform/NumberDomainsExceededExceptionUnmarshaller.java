package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberDomainsExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberDomainsExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberDomainsExceededExceptionUnmarshaller() {
        super(NumberDomainsExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberDomainsExceeded")) {
            return null;
        }
        NumberDomainsExceededException numberDomainsExceededException = (NumberDomainsExceededException) super.unmarshall(node);
        numberDomainsExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberDomainsExceededException;
    }
}
