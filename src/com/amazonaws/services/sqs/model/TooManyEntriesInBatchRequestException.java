package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class TooManyEntriesInBatchRequestException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TooManyEntriesInBatchRequestException(String str) {
        super(str);
    }
}
