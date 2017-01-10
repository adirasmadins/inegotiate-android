package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NoSuchDomainException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NoSuchDomainExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NoSuchDomainExceptionUnmarshaller() {
        super(NoSuchDomainException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NoSuchDomain")) {
            return null;
        }
        NoSuchDomainException noSuchDomainException = (NoSuchDomainException) super.unmarshall(node);
        noSuchDomainException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return noSuchDomainException;
    }
}
