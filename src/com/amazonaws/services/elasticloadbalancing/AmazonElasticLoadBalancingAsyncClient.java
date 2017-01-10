package com.amazonaws.services.elasticloadbalancing;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.elasticloadbalancing.model.ApplySecurityGroupsToLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.ApplySecurityGroupsToLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.AttachLoadBalancerToSubnetsRequest;
import com.amazonaws.services.elasticloadbalancing.model.AttachLoadBalancerToSubnetsResult;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckRequest;
import com.amazonaws.services.elasticloadbalancing.model.ConfigureHealthCheckResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerListenersRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerListenersRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerPolicyRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerPolicyResult;
import com.amazonaws.services.elasticloadbalancing.model.DeleteLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DeregisterInstancesFromLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeInstanceHealthRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeInstanceHealthResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPoliciesRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPoliciesResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPolicyTypesRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancerPolicyTypesResult;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersRequest;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersResult;
import com.amazonaws.services.elasticloadbalancing.model.DetachLoadBalancerFromSubnetsRequest;
import com.amazonaws.services.elasticloadbalancing.model.DetachLoadBalancerFromSubnetsResult;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.DisableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.EnableAvailabilityZonesForLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerRequest;
import com.amazonaws.services.elasticloadbalancing.model.RegisterInstancesWithLoadBalancerResult;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerListenerSSLCertificateRequest;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesForBackendServerRequest;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesForBackendServerResult;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerRequest;
import com.amazonaws.services.elasticloadbalancing.model.SetLoadBalancerPoliciesOfListenerResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonElasticLoadBalancingAsyncClient extends AmazonElasticLoadBalancingClient implements AmazonElasticLoadBalancingAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.10 */
    class AnonymousClass10 implements Callable<SetLoadBalancerPoliciesOfListenerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetLoadBalancerPoliciesOfListenerRequest val$setLoadBalancerPoliciesOfListenerRequest;

        AnonymousClass10(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest, AsyncHandler asyncHandler) {
            this.val$setLoadBalancerPoliciesOfListenerRequest = setLoadBalancerPoliciesOfListenerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SetLoadBalancerPoliciesOfListenerResult call() throws Exception {
            try {
                SetLoadBalancerPoliciesOfListenerResult loadBalancerPoliciesOfListener = AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerPoliciesOfListener(this.val$setLoadBalancerPoliciesOfListenerRequest);
                this.val$asyncHandler.onSuccess(this.val$setLoadBalancerPoliciesOfListenerRequest, loadBalancerPoliciesOfListener);
                return loadBalancerPoliciesOfListener;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.11 */
    class AnonymousClass11 implements Callable<DisableAvailabilityZonesForLoadBalancerResult> {
        final /* synthetic */ DisableAvailabilityZonesForLoadBalancerRequest val$disableAvailabilityZonesForLoadBalancerRequest;

        AnonymousClass11(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest) {
            this.val$disableAvailabilityZonesForLoadBalancerRequest = disableAvailabilityZonesForLoadBalancerRequest;
        }

        public DisableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.disableAvailabilityZonesForLoadBalancer(this.val$disableAvailabilityZonesForLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.12 */
    class AnonymousClass12 implements Callable<DisableAvailabilityZonesForLoadBalancerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DisableAvailabilityZonesForLoadBalancerRequest val$disableAvailabilityZonesForLoadBalancerRequest;

        AnonymousClass12(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$disableAvailabilityZonesForLoadBalancerRequest = disableAvailabilityZonesForLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DisableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            try {
                DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.disableAvailabilityZonesForLoadBalancer(this.val$disableAvailabilityZonesForLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$disableAvailabilityZonesForLoadBalancerRequest, disableAvailabilityZonesForLoadBalancer);
                return disableAvailabilityZonesForLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.13 */
    class AnonymousClass13 implements Callable<DescribeInstanceHealthResult> {
        final /* synthetic */ DescribeInstanceHealthRequest val$describeInstanceHealthRequest;

        AnonymousClass13(DescribeInstanceHealthRequest describeInstanceHealthRequest) {
            this.val$describeInstanceHealthRequest = describeInstanceHealthRequest;
        }

        public DescribeInstanceHealthResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.describeInstanceHealth(this.val$describeInstanceHealthRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.14 */
    class AnonymousClass14 implements Callable<DescribeInstanceHealthResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeInstanceHealthRequest val$describeInstanceHealthRequest;

        AnonymousClass14(DescribeInstanceHealthRequest describeInstanceHealthRequest, AsyncHandler asyncHandler) {
            this.val$describeInstanceHealthRequest = describeInstanceHealthRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeInstanceHealthResult call() throws Exception {
            try {
                DescribeInstanceHealthResult describeInstanceHealth = AmazonElasticLoadBalancingAsyncClient.this.describeInstanceHealth(this.val$describeInstanceHealthRequest);
                this.val$asyncHandler.onSuccess(this.val$describeInstanceHealthRequest, describeInstanceHealth);
                return describeInstanceHealth;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.15 */
    class AnonymousClass15 implements Callable<DeleteLoadBalancerPolicyResult> {
        final /* synthetic */ DeleteLoadBalancerPolicyRequest val$deleteLoadBalancerPolicyRequest;

        AnonymousClass15(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest) {
            this.val$deleteLoadBalancerPolicyRequest = deleteLoadBalancerPolicyRequest;
        }

        public DeleteLoadBalancerPolicyResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancerPolicy(this.val$deleteLoadBalancerPolicyRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.16 */
    class AnonymousClass16 implements Callable<DeleteLoadBalancerPolicyResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteLoadBalancerPolicyRequest val$deleteLoadBalancerPolicyRequest;

        AnonymousClass16(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest, AsyncHandler asyncHandler) {
            this.val$deleteLoadBalancerPolicyRequest = deleteLoadBalancerPolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeleteLoadBalancerPolicyResult call() throws Exception {
            try {
                DeleteLoadBalancerPolicyResult deleteLoadBalancerPolicy = AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancerPolicy(this.val$deleteLoadBalancerPolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteLoadBalancerPolicyRequest, deleteLoadBalancerPolicy);
                return deleteLoadBalancerPolicy;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.17 */
    class AnonymousClass17 implements Callable<CreateLoadBalancerPolicyResult> {
        final /* synthetic */ CreateLoadBalancerPolicyRequest val$createLoadBalancerPolicyRequest;

        AnonymousClass17(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest) {
            this.val$createLoadBalancerPolicyRequest = createLoadBalancerPolicyRequest;
        }

        public CreateLoadBalancerPolicyResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancerPolicy(this.val$createLoadBalancerPolicyRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.18 */
    class AnonymousClass18 implements Callable<CreateLoadBalancerPolicyResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateLoadBalancerPolicyRequest val$createLoadBalancerPolicyRequest;

        AnonymousClass18(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest, AsyncHandler asyncHandler) {
            this.val$createLoadBalancerPolicyRequest = createLoadBalancerPolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateLoadBalancerPolicyResult call() throws Exception {
            try {
                CreateLoadBalancerPolicyResult createLoadBalancerPolicy = AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancerPolicy(this.val$createLoadBalancerPolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$createLoadBalancerPolicyRequest, createLoadBalancerPolicy);
                return createLoadBalancerPolicy;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.19 */
    class AnonymousClass19 implements Callable<EnableAvailabilityZonesForLoadBalancerResult> {
        final /* synthetic */ EnableAvailabilityZonesForLoadBalancerRequest val$enableAvailabilityZonesForLoadBalancerRequest;

        AnonymousClass19(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest) {
            this.val$enableAvailabilityZonesForLoadBalancerRequest = enableAvailabilityZonesForLoadBalancerRequest;
        }

        public EnableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.enableAvailabilityZonesForLoadBalancer(this.val$enableAvailabilityZonesForLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.1 */
    class C00531 implements Callable<DescribeLoadBalancerPolicyTypesResult> {
        final /* synthetic */ DescribeLoadBalancerPolicyTypesRequest val$describeLoadBalancerPolicyTypesRequest;

        C00531(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) {
            this.val$describeLoadBalancerPolicyTypesRequest = describeLoadBalancerPolicyTypesRequest;
        }

        public DescribeLoadBalancerPolicyTypesResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancerPolicyTypes(this.val$describeLoadBalancerPolicyTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.20 */
    class AnonymousClass20 implements Callable<EnableAvailabilityZonesForLoadBalancerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ EnableAvailabilityZonesForLoadBalancerRequest val$enableAvailabilityZonesForLoadBalancerRequest;

        AnonymousClass20(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$enableAvailabilityZonesForLoadBalancerRequest = enableAvailabilityZonesForLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public EnableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            try {
                EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.enableAvailabilityZonesForLoadBalancer(this.val$enableAvailabilityZonesForLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$enableAvailabilityZonesForLoadBalancerRequest, enableAvailabilityZonesForLoadBalancer);
                return enableAvailabilityZonesForLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.21 */
    class AnonymousClass21 implements Callable<Void> {
        final /* synthetic */ CreateLoadBalancerListenersRequest val$createLoadBalancerListenersRequest;

        AnonymousClass21(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest) {
            this.val$createLoadBalancerListenersRequest = createLoadBalancerListenersRequest;
        }

        public Void call() throws Exception {
            AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancerListeners(this.val$createLoadBalancerListenersRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.22 */
    class AnonymousClass22 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateLoadBalancerListenersRequest val$createLoadBalancerListenersRequest;

        AnonymousClass22(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest, AsyncHandler asyncHandler) {
            this.val$createLoadBalancerListenersRequest = createLoadBalancerListenersRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancerListeners(this.val$createLoadBalancerListenersRequest);
                this.val$asyncHandler.onSuccess(this.val$createLoadBalancerListenersRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.23 */
    class AnonymousClass23 implements Callable<CreateLoadBalancerResult> {
        final /* synthetic */ CreateLoadBalancerRequest val$createLoadBalancerRequest;

        AnonymousClass23(CreateLoadBalancerRequest createLoadBalancerRequest) {
            this.val$createLoadBalancerRequest = createLoadBalancerRequest;
        }

        public CreateLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancer(this.val$createLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.24 */
    class AnonymousClass24 implements Callable<CreateLoadBalancerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateLoadBalancerRequest val$createLoadBalancerRequest;

        AnonymousClass24(CreateLoadBalancerRequest createLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$createLoadBalancerRequest = createLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateLoadBalancerResult call() throws Exception {
            try {
                CreateLoadBalancerResult createLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.createLoadBalancer(this.val$createLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$createLoadBalancerRequest, createLoadBalancer);
                return createLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.25 */
    class AnonymousClass25 implements Callable<Void> {
        final /* synthetic */ DeleteLoadBalancerRequest val$deleteLoadBalancerRequest;

        AnonymousClass25(DeleteLoadBalancerRequest deleteLoadBalancerRequest) {
            this.val$deleteLoadBalancerRequest = deleteLoadBalancerRequest;
        }

        public Void call() throws Exception {
            AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancer(this.val$deleteLoadBalancerRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.26 */
    class AnonymousClass26 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteLoadBalancerRequest val$deleteLoadBalancerRequest;

        AnonymousClass26(DeleteLoadBalancerRequest deleteLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$deleteLoadBalancerRequest = deleteLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancer(this.val$deleteLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteLoadBalancerRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.27 */
    class AnonymousClass27 implements Callable<SetLoadBalancerPoliciesForBackendServerResult> {
        final /* synthetic */ SetLoadBalancerPoliciesForBackendServerRequest val$setLoadBalancerPoliciesForBackendServerRequest;

        AnonymousClass27(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest) {
            this.val$setLoadBalancerPoliciesForBackendServerRequest = setLoadBalancerPoliciesForBackendServerRequest;
        }

        public SetLoadBalancerPoliciesForBackendServerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerPoliciesForBackendServer(this.val$setLoadBalancerPoliciesForBackendServerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.28 */
    class AnonymousClass28 implements Callable<SetLoadBalancerPoliciesForBackendServerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetLoadBalancerPoliciesForBackendServerRequest val$setLoadBalancerPoliciesForBackendServerRequest;

        AnonymousClass28(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest, AsyncHandler asyncHandler) {
            this.val$setLoadBalancerPoliciesForBackendServerRequest = setLoadBalancerPoliciesForBackendServerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SetLoadBalancerPoliciesForBackendServerResult call() throws Exception {
            try {
                SetLoadBalancerPoliciesForBackendServerResult loadBalancerPoliciesForBackendServer = AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerPoliciesForBackendServer(this.val$setLoadBalancerPoliciesForBackendServerRequest);
                this.val$asyncHandler.onSuccess(this.val$setLoadBalancerPoliciesForBackendServerRequest, loadBalancerPoliciesForBackendServer);
                return loadBalancerPoliciesForBackendServer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.29 */
    class AnonymousClass29 implements Callable<Void> {
        final /* synthetic */ DeleteLoadBalancerListenersRequest val$deleteLoadBalancerListenersRequest;

        AnonymousClass29(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest) {
            this.val$deleteLoadBalancerListenersRequest = deleteLoadBalancerListenersRequest;
        }

        public Void call() throws Exception {
            AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancerListeners(this.val$deleteLoadBalancerListenersRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.2 */
    class C00542 implements Callable<DescribeLoadBalancerPolicyTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeLoadBalancerPolicyTypesRequest val$describeLoadBalancerPolicyTypesRequest;

        C00542(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeLoadBalancerPolicyTypesRequest = describeLoadBalancerPolicyTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeLoadBalancerPolicyTypesResult call() throws Exception {
            try {
                DescribeLoadBalancerPolicyTypesResult describeLoadBalancerPolicyTypes = AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancerPolicyTypes(this.val$describeLoadBalancerPolicyTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeLoadBalancerPolicyTypesRequest, describeLoadBalancerPolicyTypes);
                return describeLoadBalancerPolicyTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.30 */
    class AnonymousClass30 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteLoadBalancerListenersRequest val$deleteLoadBalancerListenersRequest;

        AnonymousClass30(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest, AsyncHandler asyncHandler) {
            this.val$deleteLoadBalancerListenersRequest = deleteLoadBalancerListenersRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonElasticLoadBalancingAsyncClient.this.deleteLoadBalancerListeners(this.val$deleteLoadBalancerListenersRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteLoadBalancerListenersRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.31 */
    class AnonymousClass31 implements Callable<DeregisterInstancesFromLoadBalancerResult> {
        final /* synthetic */ DeregisterInstancesFromLoadBalancerRequest val$deregisterInstancesFromLoadBalancerRequest;

        AnonymousClass31(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest) {
            this.val$deregisterInstancesFromLoadBalancerRequest = deregisterInstancesFromLoadBalancerRequest;
        }

        public DeregisterInstancesFromLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.deregisterInstancesFromLoadBalancer(this.val$deregisterInstancesFromLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.32 */
    class AnonymousClass32 implements Callable<DeregisterInstancesFromLoadBalancerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeregisterInstancesFromLoadBalancerRequest val$deregisterInstancesFromLoadBalancerRequest;

        AnonymousClass32(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$deregisterInstancesFromLoadBalancerRequest = deregisterInstancesFromLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeregisterInstancesFromLoadBalancerResult call() throws Exception {
            try {
                DeregisterInstancesFromLoadBalancerResult deregisterInstancesFromLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.deregisterInstancesFromLoadBalancer(this.val$deregisterInstancesFromLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$deregisterInstancesFromLoadBalancerRequest, deregisterInstancesFromLoadBalancer);
                return deregisterInstancesFromLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.33 */
    class AnonymousClass33 implements Callable<Void> {
        final /* synthetic */ SetLoadBalancerListenerSSLCertificateRequest val$setLoadBalancerListenerSSLCertificateRequest;

        AnonymousClass33(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest) {
            this.val$setLoadBalancerListenerSSLCertificateRequest = setLoadBalancerListenerSSLCertificateRequest;
        }

        public Void call() throws Exception {
            AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerListenerSSLCertificate(this.val$setLoadBalancerListenerSSLCertificateRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.34 */
    class AnonymousClass34 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetLoadBalancerListenerSSLCertificateRequest val$setLoadBalancerListenerSSLCertificateRequest;

        AnonymousClass34(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest, AsyncHandler asyncHandler) {
            this.val$setLoadBalancerListenerSSLCertificateRequest = setLoadBalancerListenerSSLCertificateRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerListenerSSLCertificate(this.val$setLoadBalancerListenerSSLCertificateRequest);
                this.val$asyncHandler.onSuccess(this.val$setLoadBalancerListenerSSLCertificateRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.35 */
    class AnonymousClass35 implements Callable<CreateLBCookieStickinessPolicyResult> {
        final /* synthetic */ CreateLBCookieStickinessPolicyRequest val$createLBCookieStickinessPolicyRequest;

        AnonymousClass35(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest) {
            this.val$createLBCookieStickinessPolicyRequest = createLBCookieStickinessPolicyRequest;
        }

        public CreateLBCookieStickinessPolicyResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.createLBCookieStickinessPolicy(this.val$createLBCookieStickinessPolicyRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.36 */
    class AnonymousClass36 implements Callable<CreateLBCookieStickinessPolicyResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateLBCookieStickinessPolicyRequest val$createLBCookieStickinessPolicyRequest;

        AnonymousClass36(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest, AsyncHandler asyncHandler) {
            this.val$createLBCookieStickinessPolicyRequest = createLBCookieStickinessPolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateLBCookieStickinessPolicyResult call() throws Exception {
            try {
                CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy = AmazonElasticLoadBalancingAsyncClient.this.createLBCookieStickinessPolicy(this.val$createLBCookieStickinessPolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$createLBCookieStickinessPolicyRequest, createLBCookieStickinessPolicy);
                return createLBCookieStickinessPolicy;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.37 */
    class AnonymousClass37 implements Callable<AttachLoadBalancerToSubnetsResult> {
        final /* synthetic */ AttachLoadBalancerToSubnetsRequest val$attachLoadBalancerToSubnetsRequest;

        AnonymousClass37(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest) {
            this.val$attachLoadBalancerToSubnetsRequest = attachLoadBalancerToSubnetsRequest;
        }

        public AttachLoadBalancerToSubnetsResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.attachLoadBalancerToSubnets(this.val$attachLoadBalancerToSubnetsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.38 */
    class AnonymousClass38 implements Callable<AttachLoadBalancerToSubnetsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ AttachLoadBalancerToSubnetsRequest val$attachLoadBalancerToSubnetsRequest;

        AnonymousClass38(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest, AsyncHandler asyncHandler) {
            this.val$attachLoadBalancerToSubnetsRequest = attachLoadBalancerToSubnetsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public AttachLoadBalancerToSubnetsResult call() throws Exception {
            try {
                AttachLoadBalancerToSubnetsResult attachLoadBalancerToSubnets = AmazonElasticLoadBalancingAsyncClient.this.attachLoadBalancerToSubnets(this.val$attachLoadBalancerToSubnetsRequest);
                this.val$asyncHandler.onSuccess(this.val$attachLoadBalancerToSubnetsRequest, attachLoadBalancerToSubnets);
                return attachLoadBalancerToSubnets;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.39 */
    class AnonymousClass39 implements Callable<CreateAppCookieStickinessPolicyResult> {
        final /* synthetic */ CreateAppCookieStickinessPolicyRequest val$createAppCookieStickinessPolicyRequest;

        AnonymousClass39(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest) {
            this.val$createAppCookieStickinessPolicyRequest = createAppCookieStickinessPolicyRequest;
        }

        public CreateAppCookieStickinessPolicyResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.createAppCookieStickinessPolicy(this.val$createAppCookieStickinessPolicyRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.3 */
    class C00553 implements Callable<ConfigureHealthCheckResult> {
        final /* synthetic */ ConfigureHealthCheckRequest val$configureHealthCheckRequest;

        C00553(ConfigureHealthCheckRequest configureHealthCheckRequest) {
            this.val$configureHealthCheckRequest = configureHealthCheckRequest;
        }

        public ConfigureHealthCheckResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.configureHealthCheck(this.val$configureHealthCheckRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.40 */
    class AnonymousClass40 implements Callable<CreateAppCookieStickinessPolicyResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateAppCookieStickinessPolicyRequest val$createAppCookieStickinessPolicyRequest;

        AnonymousClass40(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest, AsyncHandler asyncHandler) {
            this.val$createAppCookieStickinessPolicyRequest = createAppCookieStickinessPolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateAppCookieStickinessPolicyResult call() throws Exception {
            try {
                CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicy = AmazonElasticLoadBalancingAsyncClient.this.createAppCookieStickinessPolicy(this.val$createAppCookieStickinessPolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$createAppCookieStickinessPolicyRequest, createAppCookieStickinessPolicy);
                return createAppCookieStickinessPolicy;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.41 */
    class AnonymousClass41 implements Callable<RegisterInstancesWithLoadBalancerResult> {
        final /* synthetic */ RegisterInstancesWithLoadBalancerRequest val$registerInstancesWithLoadBalancerRequest;

        AnonymousClass41(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest) {
            this.val$registerInstancesWithLoadBalancerRequest = registerInstancesWithLoadBalancerRequest;
        }

        public RegisterInstancesWithLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.registerInstancesWithLoadBalancer(this.val$registerInstancesWithLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.42 */
    class AnonymousClass42 implements Callable<RegisterInstancesWithLoadBalancerResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RegisterInstancesWithLoadBalancerRequest val$registerInstancesWithLoadBalancerRequest;

        AnonymousClass42(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$registerInstancesWithLoadBalancerRequest = registerInstancesWithLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public RegisterInstancesWithLoadBalancerResult call() throws Exception {
            try {
                RegisterInstancesWithLoadBalancerResult registerInstancesWithLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.registerInstancesWithLoadBalancer(this.val$registerInstancesWithLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$registerInstancesWithLoadBalancerRequest, registerInstancesWithLoadBalancer);
                return registerInstancesWithLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.43 */
    class AnonymousClass43 implements Callable<ApplySecurityGroupsToLoadBalancerResult> {
        final /* synthetic */ ApplySecurityGroupsToLoadBalancerRequest val$applySecurityGroupsToLoadBalancerRequest;

        AnonymousClass43(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) {
            this.val$applySecurityGroupsToLoadBalancerRequest = applySecurityGroupsToLoadBalancerRequest;
        }

        public ApplySecurityGroupsToLoadBalancerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.applySecurityGroupsToLoadBalancer(this.val$applySecurityGroupsToLoadBalancerRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.44 */
    class AnonymousClass44 implements Callable<ApplySecurityGroupsToLoadBalancerResult> {
        final /* synthetic */ ApplySecurityGroupsToLoadBalancerRequest val$applySecurityGroupsToLoadBalancerRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass44(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest, AsyncHandler asyncHandler) {
            this.val$applySecurityGroupsToLoadBalancerRequest = applySecurityGroupsToLoadBalancerRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ApplySecurityGroupsToLoadBalancerResult call() throws Exception {
            try {
                ApplySecurityGroupsToLoadBalancerResult applySecurityGroupsToLoadBalancer = AmazonElasticLoadBalancingAsyncClient.this.applySecurityGroupsToLoadBalancer(this.val$applySecurityGroupsToLoadBalancerRequest);
                this.val$asyncHandler.onSuccess(this.val$applySecurityGroupsToLoadBalancerRequest, applySecurityGroupsToLoadBalancer);
                return applySecurityGroupsToLoadBalancer;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.45 */
    class AnonymousClass45 implements Callable<DescribeLoadBalancersResult> {
        final /* synthetic */ DescribeLoadBalancersRequest val$describeLoadBalancersRequest;

        AnonymousClass45(DescribeLoadBalancersRequest describeLoadBalancersRequest) {
            this.val$describeLoadBalancersRequest = describeLoadBalancersRequest;
        }

        public DescribeLoadBalancersResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancers(this.val$describeLoadBalancersRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.46 */
    class AnonymousClass46 implements Callable<DescribeLoadBalancersResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeLoadBalancersRequest val$describeLoadBalancersRequest;

        AnonymousClass46(DescribeLoadBalancersRequest describeLoadBalancersRequest, AsyncHandler asyncHandler) {
            this.val$describeLoadBalancersRequest = describeLoadBalancersRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeLoadBalancersResult call() throws Exception {
            try {
                DescribeLoadBalancersResult describeLoadBalancers = AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancers(this.val$describeLoadBalancersRequest);
                this.val$asyncHandler.onSuccess(this.val$describeLoadBalancersRequest, describeLoadBalancers);
                return describeLoadBalancers;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.4 */
    class C00564 implements Callable<ConfigureHealthCheckResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ConfigureHealthCheckRequest val$configureHealthCheckRequest;

        C00564(ConfigureHealthCheckRequest configureHealthCheckRequest, AsyncHandler asyncHandler) {
            this.val$configureHealthCheckRequest = configureHealthCheckRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ConfigureHealthCheckResult call() throws Exception {
            try {
                ConfigureHealthCheckResult configureHealthCheck = AmazonElasticLoadBalancingAsyncClient.this.configureHealthCheck(this.val$configureHealthCheckRequest);
                this.val$asyncHandler.onSuccess(this.val$configureHealthCheckRequest, configureHealthCheck);
                return configureHealthCheck;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.5 */
    class C00575 implements Callable<DetachLoadBalancerFromSubnetsResult> {
        final /* synthetic */ DetachLoadBalancerFromSubnetsRequest val$detachLoadBalancerFromSubnetsRequest;

        C00575(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest) {
            this.val$detachLoadBalancerFromSubnetsRequest = detachLoadBalancerFromSubnetsRequest;
        }

        public DetachLoadBalancerFromSubnetsResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.detachLoadBalancerFromSubnets(this.val$detachLoadBalancerFromSubnetsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.6 */
    class C00586 implements Callable<DetachLoadBalancerFromSubnetsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DetachLoadBalancerFromSubnetsRequest val$detachLoadBalancerFromSubnetsRequest;

        C00586(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest, AsyncHandler asyncHandler) {
            this.val$detachLoadBalancerFromSubnetsRequest = detachLoadBalancerFromSubnetsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DetachLoadBalancerFromSubnetsResult call() throws Exception {
            try {
                DetachLoadBalancerFromSubnetsResult detachLoadBalancerFromSubnets = AmazonElasticLoadBalancingAsyncClient.this.detachLoadBalancerFromSubnets(this.val$detachLoadBalancerFromSubnetsRequest);
                this.val$asyncHandler.onSuccess(this.val$detachLoadBalancerFromSubnetsRequest, detachLoadBalancerFromSubnets);
                return detachLoadBalancerFromSubnets;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.7 */
    class C00597 implements Callable<DescribeLoadBalancerPoliciesResult> {
        final /* synthetic */ DescribeLoadBalancerPoliciesRequest val$describeLoadBalancerPoliciesRequest;

        C00597(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest) {
            this.val$describeLoadBalancerPoliciesRequest = describeLoadBalancerPoliciesRequest;
        }

        public DescribeLoadBalancerPoliciesResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancerPolicies(this.val$describeLoadBalancerPoliciesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.8 */
    class C00608 implements Callable<DescribeLoadBalancerPoliciesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeLoadBalancerPoliciesRequest val$describeLoadBalancerPoliciesRequest;

        C00608(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest, AsyncHandler asyncHandler) {
            this.val$describeLoadBalancerPoliciesRequest = describeLoadBalancerPoliciesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeLoadBalancerPoliciesResult call() throws Exception {
            try {
                DescribeLoadBalancerPoliciesResult describeLoadBalancerPolicies = AmazonElasticLoadBalancingAsyncClient.this.describeLoadBalancerPolicies(this.val$describeLoadBalancerPoliciesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeLoadBalancerPoliciesRequest, describeLoadBalancerPolicies);
                return describeLoadBalancerPolicies;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.elasticloadbalancing.AmazonElasticLoadBalancingAsyncClient.9 */
    class C00619 implements Callable<SetLoadBalancerPoliciesOfListenerResult> {
        final /* synthetic */ SetLoadBalancerPoliciesOfListenerRequest val$setLoadBalancerPoliciesOfListenerRequest;

        C00619(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest) {
            this.val$setLoadBalancerPoliciesOfListenerRequest = setLoadBalancerPoliciesOfListenerRequest;
        }

        public SetLoadBalancerPoliciesOfListenerResult call() throws Exception {
            return AmazonElasticLoadBalancingAsyncClient.this.setLoadBalancerPoliciesOfListener(this.val$setLoadBalancerPoliciesOfListenerRequest);
        }
    }

    public AmazonElasticLoadBalancingAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonElasticLoadBalancingAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass43(applySecurityGroupsToLoadBalancerRequest));
    }

    public Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest, AsyncHandler<ApplySecurityGroupsToLoadBalancerRequest, ApplySecurityGroupsToLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass44(applySecurityGroupsToLoadBalancerRequest, asyncHandler));
    }

    public Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass37(attachLoadBalancerToSubnetsRequest));
    }

    public Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest, AsyncHandler<AttachLoadBalancerToSubnetsRequest, AttachLoadBalancerToSubnetsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass38(attachLoadBalancerToSubnetsRequest, asyncHandler));
    }

    public Future<ConfigureHealthCheckResult> configureHealthCheckAsync(ConfigureHealthCheckRequest configureHealthCheckRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00553(configureHealthCheckRequest));
    }

    public Future<ConfigureHealthCheckResult> configureHealthCheckAsync(ConfigureHealthCheckRequest configureHealthCheckRequest, AsyncHandler<ConfigureHealthCheckRequest, ConfigureHealthCheckResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00564(configureHealthCheckRequest, asyncHandler));
    }

    public Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass39(createAppCookieStickinessPolicyRequest));
    }

    public Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest, AsyncHandler<CreateAppCookieStickinessPolicyRequest, CreateAppCookieStickinessPolicyResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass40(createAppCookieStickinessPolicyRequest, asyncHandler));
    }

    public Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass35(createLBCookieStickinessPolicyRequest));
    }

    public Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest, AsyncHandler<CreateLBCookieStickinessPolicyRequest, CreateLBCookieStickinessPolicyResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass36(createLBCookieStickinessPolicyRequest, asyncHandler));
    }

    public Future<CreateLoadBalancerResult> createLoadBalancerAsync(CreateLoadBalancerRequest createLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(createLoadBalancerRequest));
    }

    public Future<CreateLoadBalancerResult> createLoadBalancerAsync(CreateLoadBalancerRequest createLoadBalancerRequest, AsyncHandler<CreateLoadBalancerRequest, CreateLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(createLoadBalancerRequest, asyncHandler));
    }

    public Future<Void> createLoadBalancerListenersAsync(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(createLoadBalancerListenersRequest));
    }

    public Future<Void> createLoadBalancerListenersAsync(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest, AsyncHandler<CreateLoadBalancerListenersRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(createLoadBalancerListenersRequest, asyncHandler));
    }

    public Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(createLoadBalancerPolicyRequest));
    }

    public Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest, AsyncHandler<CreateLoadBalancerPolicyRequest, CreateLoadBalancerPolicyResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(createLoadBalancerPolicyRequest, asyncHandler));
    }

    public Future<Void> deleteLoadBalancerAsync(DeleteLoadBalancerRequest deleteLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(deleteLoadBalancerRequest));
    }

    public Future<Void> deleteLoadBalancerAsync(DeleteLoadBalancerRequest deleteLoadBalancerRequest, AsyncHandler<DeleteLoadBalancerRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(deleteLoadBalancerRequest, asyncHandler));
    }

    public Future<Void> deleteLoadBalancerListenersAsync(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(deleteLoadBalancerListenersRequest));
    }

    public Future<Void> deleteLoadBalancerListenersAsync(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest, AsyncHandler<DeleteLoadBalancerListenersRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(deleteLoadBalancerListenersRequest, asyncHandler));
    }

    public Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(deleteLoadBalancerPolicyRequest));
    }

    public Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest, AsyncHandler<DeleteLoadBalancerPolicyRequest, DeleteLoadBalancerPolicyResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(deleteLoadBalancerPolicyRequest, asyncHandler));
    }

    public Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass31(deregisterInstancesFromLoadBalancerRequest));
    }

    public Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest, AsyncHandler<DeregisterInstancesFromLoadBalancerRequest, DeregisterInstancesFromLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass32(deregisterInstancesFromLoadBalancerRequest, asyncHandler));
    }

    public Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(DescribeInstanceHealthRequest describeInstanceHealthRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(describeInstanceHealthRequest));
    }

    public Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(DescribeInstanceHealthRequest describeInstanceHealthRequest, AsyncHandler<DescribeInstanceHealthRequest, DescribeInstanceHealthResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(describeInstanceHealthRequest, asyncHandler));
    }

    public Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00597(describeLoadBalancerPoliciesRequest));
    }

    public Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest, AsyncHandler<DescribeLoadBalancerPoliciesRequest, DescribeLoadBalancerPoliciesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00608(describeLoadBalancerPoliciesRequest, asyncHandler));
    }

    public Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00531(describeLoadBalancerPolicyTypesRequest));
    }

    public Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest, AsyncHandler<DescribeLoadBalancerPolicyTypesRequest, DescribeLoadBalancerPolicyTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00542(describeLoadBalancerPolicyTypesRequest, asyncHandler));
    }

    public Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(DescribeLoadBalancersRequest describeLoadBalancersRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass45(describeLoadBalancersRequest));
    }

    public Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(DescribeLoadBalancersRequest describeLoadBalancersRequest, AsyncHandler<DescribeLoadBalancersRequest, DescribeLoadBalancersResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass46(describeLoadBalancersRequest, asyncHandler));
    }

    public Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00575(detachLoadBalancerFromSubnetsRequest));
    }

    public Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest, AsyncHandler<DetachLoadBalancerFromSubnetsRequest, DetachLoadBalancerFromSubnetsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00586(detachLoadBalancerFromSubnetsRequest, asyncHandler));
    }

    public Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(disableAvailabilityZonesForLoadBalancerRequest));
    }

    public Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest, AsyncHandler<DisableAvailabilityZonesForLoadBalancerRequest, DisableAvailabilityZonesForLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(disableAvailabilityZonesForLoadBalancerRequest, asyncHandler));
    }

    public Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(enableAvailabilityZonesForLoadBalancerRequest));
    }

    public Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest, AsyncHandler<EnableAvailabilityZonesForLoadBalancerRequest, EnableAvailabilityZonesForLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(enableAvailabilityZonesForLoadBalancerRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass41(registerInstancesWithLoadBalancerRequest));
    }

    public Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest, AsyncHandler<RegisterInstancesWithLoadBalancerRequest, RegisterInstancesWithLoadBalancerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass42(registerInstancesWithLoadBalancerRequest, asyncHandler));
    }

    public Future<Void> setLoadBalancerListenerSSLCertificateAsync(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass33(setLoadBalancerListenerSSLCertificateRequest));
    }

    public Future<Void> setLoadBalancerListenerSSLCertificateAsync(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest, AsyncHandler<SetLoadBalancerListenerSSLCertificateRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass34(setLoadBalancerListenerSSLCertificateRequest, asyncHandler));
    }

    public Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(setLoadBalancerPoliciesForBackendServerRequest));
    }

    public Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest, AsyncHandler<SetLoadBalancerPoliciesForBackendServerRequest, SetLoadBalancerPoliciesForBackendServerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(setLoadBalancerPoliciesForBackendServerRequest, asyncHandler));
    }

    public Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00619(setLoadBalancerPoliciesOfListenerRequest));
    }

    public Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest, AsyncHandler<SetLoadBalancerPoliciesOfListenerRequest, SetLoadBalancerPoliciesOfListenerResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(setLoadBalancerPoliciesOfListenerRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }
}
