package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class InvalidBatchEntryIdException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidBatchEntryIdException(String str) {
        super(str);
    }
}
