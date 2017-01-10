package com.amazonaws.services.simpleemail.model;

import com.amazonaws.AmazonServiceException;

public class MessageRejectedException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public MessageRejectedException(String str) {
        super(str);
    }
}
