package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class InvalidIdFormatException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidIdFormatException(String str) {
        super(str);
    }
}
