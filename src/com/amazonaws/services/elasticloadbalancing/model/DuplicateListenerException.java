package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class DuplicateListenerException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public DuplicateListenerException(String str) {
        super(str);
    }
}
