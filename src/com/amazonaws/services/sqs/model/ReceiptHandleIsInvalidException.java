package com.amazonaws.services.sqs.model;

import com.amazonaws.AmazonServiceException;

public class ReceiptHandleIsInvalidException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ReceiptHandleIsInvalidException(String str) {
        super(str);
    }
}
