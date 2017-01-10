package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class TooManyPoliciesException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TooManyPoliciesException(String str) {
        super(str);
    }
}
