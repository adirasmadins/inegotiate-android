package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class QueueNameExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public QueueNameExistsException(String str) {
        super(str);
    }
}
