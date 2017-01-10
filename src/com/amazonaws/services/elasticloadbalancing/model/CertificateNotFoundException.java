package com.amazonaws.services.elasticloadbalancing.model;

import com.amazonaws.AmazonServiceException;

public class CertificateNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CertificateNotFoundException(String str) {
        super(str);
    }
}
