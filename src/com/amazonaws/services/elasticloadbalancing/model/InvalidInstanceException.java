package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class InvalidInstanceException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidInstanceException(String str) {
        super(str);
    }
}
