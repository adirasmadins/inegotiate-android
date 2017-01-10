package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class InvalidNextTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidNextTokenException(String str) {
        super(str);
    }
}
