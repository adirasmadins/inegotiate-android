package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class LegacyErrorUnmarshaller implements Unmarshaller<AmazonServiceException, Node> {
    private final Class<? extends AmazonServiceException> exceptionClass;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    protected LegacyErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.exceptionClass = cls;
    }

    public String getErrorPropertyPath(String str) {
        return "Response/Errors/Error/" + str;
    }

    public String parseErrorCode(Node node) throws Exception {
        return XpathUtils.asString("Response/Errors/Error/Code", node);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        String asString = XpathUtils.asString("Response/Errors/Error/Message", node);
        String asString2 = XpathUtils.asString("Response/RequestID", node);
        String asString3 = XpathUtils.asString("Response/Errors/Error/Type", node);
        AmazonServiceException amazonServiceException = (AmazonServiceException) this.exceptionClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{asString});
        amazonServiceException.setErrorCode(parseErrorCode);
        amazonServiceException.setRequestId(asString2);
        if (asString3 == null) {
            amazonServiceException.setErrorType(ErrorType.Unknown);
        } else if (asString3.equalsIgnoreCase("server")) {
            amazonServiceException.setErrorType(ErrorType.Service);
        } else if (asString3.equalsIgnoreCase("client")) {
            amazonServiceException.setErrorType(ErrorType.Client);
        }
        return amazonServiceException;
    }
}
