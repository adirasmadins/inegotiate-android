package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class EmptyBatchRequestException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public EmptyBatchRequestException(String str) {
        super(str);
    }
}
