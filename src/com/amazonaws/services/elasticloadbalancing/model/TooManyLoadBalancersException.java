package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class TooManyLoadBalancersException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TooManyLoadBalancersException(String str) {
        super(str);
    }
}
