package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonServiceException;

public class TopicLimitExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TopicLimitExceededException(String str) {
        super(str);
    }
}
