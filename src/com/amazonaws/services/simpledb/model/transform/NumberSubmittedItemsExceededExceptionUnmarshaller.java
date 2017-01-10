package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.NumberSubmittedItemsExceededException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class NumberSubmittedItemsExceededExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public NumberSubmittedItemsExceededExceptionUnmarshaller() {
        super(NumberSubmittedItemsExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("NumberSubmittedItemsExceeded")) {
            return null;
        }
        NumberSubmittedItemsExceededException numberSubmittedItemsExceededException = (NumberSubmittedItemsExceededException) super.unmarshall(node);
        numberSubmittedItemsExceededException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return numberSubmittedItemsExceededException;
    }
}
