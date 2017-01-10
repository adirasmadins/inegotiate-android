package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonServiceException;

public class InvalidParameterException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidParameterException(String str) {
        super(str);
    }
}
