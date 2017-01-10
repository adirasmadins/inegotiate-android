package com.amazonaws.services.securitytoken;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import java.util.concurrent.Future;

public interface AWSSecurityTokenServiceAsync extends AWSSecurityTokenService {
    Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest getFederationTokenRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest getFederationTokenRequest, AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest getSessionTokenRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest getSessionTokenRequest, AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
