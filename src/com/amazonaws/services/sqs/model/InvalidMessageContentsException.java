package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class InvalidMessageContentsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidMessageContentsException(String str) {
        super(str);
    }
}
