package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class InvalidSecurityGroupException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidSecurityGroupException(String str) {
        super(str);
    }
}
