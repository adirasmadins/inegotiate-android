package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class MissingRequiredParameterException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public MissingRequiredParameterException(String str) {
        super(str);
    }
}
