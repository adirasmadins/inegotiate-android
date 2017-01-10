package com.amazonaws.services.securitytoken;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AWSSecurityTokenServiceAsyncClient extends AWSSecurityTokenServiceClient implements AWSSecurityTokenServiceAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.1 */
    class C00711 implements Callable<GetSessionTokenResult> {
        final /* synthetic */ GetSessionTokenRequest val$getSessionTokenRequest;

        C00711(GetSessionTokenRequest getSessionTokenRequest) {
            this.val$getSessionTokenRequest = getSessionTokenRequest;
        }

        public GetSessionTokenResult call() throws Exception {
            return AWSSecurityTokenServiceAsyncClient.this.getSessionToken(this.val$getSessionTokenRequest);
        }
    }

    /* renamed from: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.2 */
    class C00722 implements Callable<GetSessionTokenResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetSessionTokenRequest val$getSessionTokenRequest;

        C00722(GetSessionTokenRequest getSessionTokenRequest, AsyncHandler asyncHandler) {
            this.val$getSessionTokenRequest = getSessionTokenRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetSessionTokenResult call() throws Exception {
            try {
                GetSessionTokenResult sessionToken = AWSSecurityTokenServiceAsyncClient.this.getSessionToken(this.val$getSessionTokenRequest);
                this.val$asyncHandler.onSuccess(this.val$getSessionTokenRequest, sessionToken);
                return sessionToken;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.3 */
    class C00733 implements Callable<GetFederationTokenResult> {
        final /* synthetic */ GetFederationTokenRequest val$getFederationTokenRequest;

        C00733(GetFederationTokenRequest getFederationTokenRequest) {
            this.val$getFederationTokenRequest = getFederationTokenRequest;
        }

        public GetFederationTokenResult call() throws Exception {
            return AWSSecurityTokenServiceAsyncClient.this.getFederationToken(this.val$getFederationTokenRequest);
        }
    }

    /* renamed from: com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.4 */
    class C00744 implements Callable<GetFederationTokenResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetFederationTokenRequest val$getFederationTokenRequest;

        C00744(GetFederationTokenRequest getFederationTokenRequest, AsyncHandler asyncHandler) {
            this.val$getFederationTokenRequest = getFederationTokenRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetFederationTokenResult call() throws Exception {
            try {
                GetFederationTokenResult federationToken = AWSSecurityTokenServiceAsyncClient.this.getFederationToken(this.val$getFederationTokenRequest);
                this.val$asyncHandler.onSuccess(this.val$getFederationTokenRequest, federationToken);
                return federationToken;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    public AWSSecurityTokenServiceAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AWSSecurityTokenServiceAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest getFederationTokenRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00733(getFederationTokenRequest));
    }

    public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest getFederationTokenRequest, AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00744(getFederationTokenRequest, asyncHandler));
    }

    public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest getSessionTokenRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00711(getSessionTokenRequest));
    }

    public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest getSessionTokenRequest, AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00722(getSessionTokenRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }
}
