package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class LoadBalancerNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public LoadBalancerNotFoundException(String str) {
        super(str);
    }
}
