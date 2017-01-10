package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.AttributeDoesNotExistException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class AttributeDoesNotExistExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public AttributeDoesNotExistExceptionUnmarshaller() {
        super(AttributeDoesNotExistException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("AttributeDoesNotExist")) {
            return null;
        }
        AttributeDoesNotExistException attributeDoesNotExistException = (AttributeDoesNotExistException) super.unmarshall(node);
        attributeDoesNotExistException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return attributeDoesNotExistException;
    }
}
