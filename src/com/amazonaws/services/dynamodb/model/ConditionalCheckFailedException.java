package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonServiceException;

public class ConditionalCheckFailedException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ConditionalCheckFailedException(String str) {
        super(str);
    }
}
