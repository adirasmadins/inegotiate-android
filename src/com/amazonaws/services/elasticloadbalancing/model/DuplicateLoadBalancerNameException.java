package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class DuplicateLoadBalancerNameException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DuplicateLoadBalancerNameException(String str) {
        super(str);
    }
}
