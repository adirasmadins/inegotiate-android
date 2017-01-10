package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class QueueDoesNotExistException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public QueueDoesNotExistException(String str) {
        super(str);
    }
}
