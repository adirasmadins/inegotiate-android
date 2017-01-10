package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class ListenerNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ListenerNotFoundException(String str) {
        super(str);
    }
}
