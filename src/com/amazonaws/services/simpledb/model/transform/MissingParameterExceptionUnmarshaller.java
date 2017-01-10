package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.MissingParameterException;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class MissingParameterExceptionUnmarshaller extends LegacyErrorUnmarshaller {
    public MissingParameterExceptionUnmarshaller() {
        super(MissingParameterException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        if (parseErrorCode == null || !parseErrorCode.equals("MissingParameter")) {
            return null;
        }
        MissingParameterException missingParameterException = (MissingParameterException) super.unmarshall(node);
        missingParameterException.setBoxUsage(XpathUtils.asFloat(getErrorPropertyPath("BoxUsage"), node));
        return missingParameterException;
    }
}
