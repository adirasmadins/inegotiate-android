package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.DuplicateItemNameException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class DuplicateItemNameExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public DuplicateItemNameExceptionUnmarshaller() {
        super(DuplicateItemNameException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("DuplicateItemName")) {
            return null;
        }
        DuplicateItemNameException duplicateItemNameException = (DuplicateItemNameException) super.unmarshall(node);
        duplicateItemNameException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return duplicateItemNameException;
    }
}
