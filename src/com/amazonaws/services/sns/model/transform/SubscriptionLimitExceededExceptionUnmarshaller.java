package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.model.SubscriptionLimitExceededException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class SubscriptionLimitExceededExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public SubscriptionLimitExceededExceptionUnmarshaller() {
        super(SubscriptionLimitExceededException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("SubscriptionLimitExceeded")) ? null : (SubscriptionLimitExceededException) super.unmarshall(node);
    }
}
