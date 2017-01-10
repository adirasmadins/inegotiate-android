package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonServiceException;

public class AuthorizationErrorException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public AuthorizationErrorException(String str) {
        super(str);
    }
}
