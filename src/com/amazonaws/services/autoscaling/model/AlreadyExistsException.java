package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonServiceException;

public class AlreadyExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public AlreadyExistsException(String str) {
        super(str);
    }
}
