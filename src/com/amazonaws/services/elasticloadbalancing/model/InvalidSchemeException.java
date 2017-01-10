package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class InvalidSchemeException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidSchemeException(String str) {
        super(str);
    }
}
