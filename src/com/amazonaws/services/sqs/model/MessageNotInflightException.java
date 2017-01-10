package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class MessageNotInflightException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public MessageNotInflightException(String str) {
        super(str);
    }
}
