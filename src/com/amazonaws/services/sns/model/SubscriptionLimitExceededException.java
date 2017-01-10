package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonServiceException;

public class SubscriptionLimitExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public SubscriptionLimitExceededException(String str) {
        super(str);
    }
}
