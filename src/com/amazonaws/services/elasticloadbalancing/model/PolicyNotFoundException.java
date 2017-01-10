package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class PolicyNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public PolicyNotFoundException(String str) {
        super(str);
    }
}
