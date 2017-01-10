package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonServiceException;

public class ResourceInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ResourceInUseException(String str) {
        super(str);
    }
}
