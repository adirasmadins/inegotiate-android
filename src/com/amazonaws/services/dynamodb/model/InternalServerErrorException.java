package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonServiceException;

public class InternalServerErrorException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InternalServerErrorException(String str) {
        super(str);
    }
}
