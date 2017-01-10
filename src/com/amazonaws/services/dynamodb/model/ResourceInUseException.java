package com.amazonaws.services.dynamodb.model;

import com.amazonaws.AmazonServiceException;

public class ResourceInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ResourceInUseException(String str) {
        super(str);
    }
}
