package com.amazonaws.services.cloudwatch.model;

import com.amazonaws.AmazonServiceException;

public class InvalidFormatException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidFormatException(String str) {
        super(str);
    }
}
