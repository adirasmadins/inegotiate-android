package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonServiceException;

public class ScalingActivityInProgressException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ScalingActivityInProgressException(String str) {
        super(str);
    }
}
