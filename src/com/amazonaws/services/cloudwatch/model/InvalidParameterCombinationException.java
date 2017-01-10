package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class InvalidParameterCombinationException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidParameterCombinationException(String str) {
        super(str);
    }
}
