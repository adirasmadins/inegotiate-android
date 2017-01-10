package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class InternalServiceException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InternalServiceException(String str) {
        super(str);
    }
}
