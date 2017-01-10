package com.amazonaws.services.sqs;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.handlers.AbstractRequestHandler;
import java.net.URI;

public class QueueUrlHandler extends AbstractRequestHandler {
    private static final String QUEUE_URL_PARAMETER = "QueueUrl";

    public void beforeRequest(Request<?> request) {
        if (request.getParameters().get(QUEUE_URL_PARAMETER) != null) {
            String str = (String) request.getParameters().remove(QUEUE_URL_PARAMETER);
            try {
                request.setResourcePath(new URI(str).getPath());
            } catch (Throwable e) {
                throw new AmazonClientException("Unable to parse SQS queue URL '" + str + "'", e);
            }
        }
    }
}
