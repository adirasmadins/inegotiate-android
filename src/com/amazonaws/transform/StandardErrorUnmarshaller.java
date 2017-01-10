package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class StandardErrorUnmarshaller extends AbstractErrorUnmarshaller<Node> {
    protected StandardErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        super(cls);
    }

    public String getErrorPropertyPath(String str) {
        return "ErrorResponse/Error/" + str;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("ErrorResponse/Error/Code", node);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        String asString = XpathUtils.asString("ErrorResponse/Error/Type", node);
        String asString2 = XpathUtils.asString("ErrorResponse/RequestId", node);
        AmazonServiceException newException = newException(XpathUtils.asString("ErrorResponse/Error/Message", node));
        newException.setErrorCode(parseErrorCode);
        newException.setRequestId(asString2);
        if (asString == null) {
            newException.setErrorType(ErrorType.Unknown);
        } else if (asString.equalsIgnoreCase("Receiver")) {
            newException.setErrorType(ErrorType.Service);
        } else if (asString.equalsIgnoreCase("Sender")) {
            newException.setErrorType(ErrorType.Client);
        }
        return newException;
    }
}
