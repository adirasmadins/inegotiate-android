package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class PolicyTypeNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public PolicyTypeNotFoundException(String str) {
        super(str);
    }
}
