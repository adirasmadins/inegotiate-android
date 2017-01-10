package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;

public interface Signer {
    void sign(Request<?> request, AWSCredentials aWSCredentials) throws AmazonClientException;
}
