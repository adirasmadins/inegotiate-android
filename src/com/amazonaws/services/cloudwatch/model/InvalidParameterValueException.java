package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class InvalidParameterValueException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidParameterValueException(String str) {
        super(str);
    }
}
