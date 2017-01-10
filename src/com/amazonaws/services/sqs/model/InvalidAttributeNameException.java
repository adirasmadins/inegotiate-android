package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class InvalidAttributeNameException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidAttributeNameException(String str) {
        super(str);
    }
}
