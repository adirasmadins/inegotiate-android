package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class DuplicatePolicyNameException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DuplicatePolicyNameException(String str) {
        super(str);
    }
}
