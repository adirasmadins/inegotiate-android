package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class BatchEntryIdsNotDistinctException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public BatchEntryIdsNotDistinctException(String str) {
        super(str);
    }
}
