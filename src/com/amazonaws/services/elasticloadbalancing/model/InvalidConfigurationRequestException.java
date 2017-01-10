package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class InvalidConfigurationRequestException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidConfigurationRequestException(String str) {
        super(str);
    }
}
