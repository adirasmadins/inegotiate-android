package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class InvalidSubnetException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidSubnetException(String str) {
        super(str);
    }
}
