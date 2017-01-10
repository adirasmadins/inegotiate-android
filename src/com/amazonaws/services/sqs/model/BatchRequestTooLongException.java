package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class BatchRequestTooLongException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public BatchRequestTooLongException(String str) {
        super(str);
    }
}
