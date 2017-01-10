package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class SubnetNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public SubnetNotFoundException(String str) {
        super(str);
    }
}
