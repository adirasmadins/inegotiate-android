package com.amazonaws.services.simpledb.model;

import com.amazonaws.AmazonServiceException;

public class NumberDomainsExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1;
    private Float boxUsage;

    public NumberDomainsExceededException(String str) {
        super(str);
    }

    public Float getBoxUsage() {
        return this.boxUsage;
    }

    public void setBoxUsage(Float f) {
        this.boxUsage = f;
    }
}
