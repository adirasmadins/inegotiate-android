package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class OverLimitException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public OverLimitException(String str) {
        super(str);
    }
}
