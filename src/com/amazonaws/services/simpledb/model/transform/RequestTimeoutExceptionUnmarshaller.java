package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.RequestTimeoutException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class RequestTimeoutExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public RequestTimeoutExceptionUnmarshaller() {
        super(RequestTimeoutException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("RequestTimeout")) {
            return null;
        }
        RequestTimeoutException requestTimeoutException = (RequestTimeoutException) super.unmarshall(node);
        requestTimeoutException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return requestTimeoutException;
    }
}
