package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class QueueDeletedRecentlyException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public QueueDeletedRecentlyException(String str) {
        super(str);
    }
}
