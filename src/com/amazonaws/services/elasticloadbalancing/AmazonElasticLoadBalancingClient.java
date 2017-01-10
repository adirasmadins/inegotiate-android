package com.amazonaws.services.elasticloadbalancing;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.QueryStringSigner;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
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
import com.amazonaws.services.elasticloadbalancing.model.transform.ApplySecurityGroupsToLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.AttachLoadBalancerToSubnetsRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.AttachLoadBalancerToSubnetsResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CertificateNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.ConfigureHealthCheckRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.ConfigureHealthCheckResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateAppCookieStickinessPolicyRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateAppCookieStickinessPolicyResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLBCookieStickinessPolicyRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLBCookieStickinessPolicyResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLoadBalancerListenersRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLoadBalancerPolicyRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLoadBalancerPolicyResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.CreateLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeleteLoadBalancerListenersRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeleteLoadBalancerPolicyRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeleteLoadBalancerPolicyResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeleteLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeregisterInstancesFromLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeInstanceHealthRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeInstanceHealthResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancerPoliciesRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancerPoliciesResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancerPolicyTypesRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancersRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DescribeLoadBalancersResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DetachLoadBalancerFromSubnetsRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DetachLoadBalancerFromSubnetsResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DisableAvailabilityZonesForLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DuplicateListenerExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DuplicateLoadBalancerNameExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.DuplicatePolicyNameExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.EnableAvailabilityZonesForLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.InvalidConfigurationRequestExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.InvalidInstanceExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.InvalidSchemeExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.InvalidSecurityGroupExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.InvalidSubnetExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.ListenerNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.LoadBalancerNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.PolicyNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.PolicyTypeNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.RegisterInstancesWithLoadBalancerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.RegisterInstancesWithLoadBalancerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SetLoadBalancerListenerSSLCertificateRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SetLoadBalancerPoliciesForBackendServerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SetLoadBalancerPoliciesOfListenerRequestMarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.SubnetNotFoundExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.TooManyLoadBalancersExceptionUnmarshaller;
import com.amazonaws.services.elasticloadbalancing.model.transform.TooManyPoliciesExceptionUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonElasticLoadBalancingClient extends AmazonWebServiceClient implements AmazonElasticLoadBalancing {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private QueryStringSigner signer;

    public AmazonElasticLoadBalancingClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonElasticLoadBalancingClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonElasticLoadBalancingClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonElasticLoadBalancingClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonElasticLoadBalancingClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonElasticLoadBalancingClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new ListenerNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new SubnetNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidConfigurationRequestExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new TooManyPoliciesExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new CertificateNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidSubnetExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidSecurityGroupExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new LoadBalancerNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new PolicyNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new DuplicateListenerExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new TooManyLoadBalancersExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new PolicyTypeNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidSchemeExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidInstanceExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new DuplicatePolicyNameExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new DuplicateLoadBalancerNameExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("elasticloadbalancing.amazonaws.com");
        this.signer = new QueryStringSigner();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/elasticloadbalancing/request.handlers"));
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, Unmarshaller<X, StaxUnmarshallerContext> unmarshaller) {
        request.setEndpoint(this.endpoint);
        for (Entry entry : request.getOriginalRequest().copyPrivateRequestParameters().entrySet()) {
            request.addParameter((String) entry.getKey(), (String) entry.getValue());
        }
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
            credentials = originalRequest.getRequestCredentials();
        }
        ExecutionContext createExecutionContext = createExecutionContext();
        createExecutionContext.setSigner(this.signer);
        createExecutionContext.setCredentials(credentials);
        return this.client.execute(request, new StaxResponseHandler(unmarshaller), new DefaultErrorResponseHandler(this.exceptionUnmarshallers), createExecutionContext);
    }

    public ApplySecurityGroupsToLoadBalancerResult applySecurityGroupsToLoadBalancer(ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (ApplySecurityGroupsToLoadBalancerResult) invoke(new ApplySecurityGroupsToLoadBalancerRequestMarshaller().marshall(applySecurityGroupsToLoadBalancerRequest), new ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller());
    }

    public AttachLoadBalancerToSubnetsResult attachLoadBalancerToSubnets(AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest) throws AmazonServiceException, AmazonClientException {
        return (AttachLoadBalancerToSubnetsResult) invoke(new AttachLoadBalancerToSubnetsRequestMarshaller().marshall(attachLoadBalancerToSubnetsRequest), new AttachLoadBalancerToSubnetsResultStaxUnmarshaller());
    }

    public ConfigureHealthCheckResult configureHealthCheck(ConfigureHealthCheckRequest configureHealthCheckRequest) throws AmazonServiceException, AmazonClientException {
        return (ConfigureHealthCheckResult) invoke(new ConfigureHealthCheckRequestMarshaller().marshall(configureHealthCheckRequest), new ConfigureHealthCheckResultStaxUnmarshaller());
    }

    public CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicy(CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateAppCookieStickinessPolicyResult) invoke(new CreateAppCookieStickinessPolicyRequestMarshaller().marshall(createAppCookieStickinessPolicyRequest), new CreateAppCookieStickinessPolicyResultStaxUnmarshaller());
    }

    public CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicy(CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateLBCookieStickinessPolicyResult) invoke(new CreateLBCookieStickinessPolicyRequestMarshaller().marshall(createLBCookieStickinessPolicyRequest), new CreateLBCookieStickinessPolicyResultStaxUnmarshaller());
    }

    public CreateLoadBalancerResult createLoadBalancer(CreateLoadBalancerRequest createLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateLoadBalancerResult) invoke(new CreateLoadBalancerRequestMarshaller().marshall(createLoadBalancerRequest), new CreateLoadBalancerResultStaxUnmarshaller());
    }

    public void createLoadBalancerListeners(CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateLoadBalancerListenersRequestMarshaller().marshall(createLoadBalancerListenersRequest), null);
    }

    public CreateLoadBalancerPolicyResult createLoadBalancerPolicy(CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateLoadBalancerPolicyResult) invoke(new CreateLoadBalancerPolicyRequestMarshaller().marshall(createLoadBalancerPolicyRequest), new CreateLoadBalancerPolicyResultStaxUnmarshaller());
    }

    public void deleteLoadBalancer(DeleteLoadBalancerRequest deleteLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteLoadBalancerRequestMarshaller().marshall(deleteLoadBalancerRequest), null);
    }

    public void deleteLoadBalancerListeners(DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteLoadBalancerListenersRequestMarshaller().marshall(deleteLoadBalancerListenersRequest), null);
    }

    public DeleteLoadBalancerPolicyResult deleteLoadBalancerPolicy(DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return (DeleteLoadBalancerPolicyResult) invoke(new DeleteLoadBalancerPolicyRequestMarshaller().marshall(deleteLoadBalancerPolicyRequest), new DeleteLoadBalancerPolicyResultStaxUnmarshaller());
    }

    public DeregisterInstancesFromLoadBalancerResult deregisterInstancesFromLoadBalancer(DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (DeregisterInstancesFromLoadBalancerResult) invoke(new DeregisterInstancesFromLoadBalancerRequestMarshaller().marshall(deregisterInstancesFromLoadBalancerRequest), new DeregisterInstancesFromLoadBalancerResultStaxUnmarshaller());
    }

    public DescribeInstanceHealthResult describeInstanceHealth(DescribeInstanceHealthRequest describeInstanceHealthRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeInstanceHealthResult) invoke(new DescribeInstanceHealthRequestMarshaller().marshall(describeInstanceHealthRequest), new DescribeInstanceHealthResultStaxUnmarshaller());
    }

    public DescribeLoadBalancerPoliciesResult describeLoadBalancerPolicies() throws AmazonServiceException, AmazonClientException {
        return describeLoadBalancerPolicies(new DescribeLoadBalancerPoliciesRequest());
    }

    public DescribeLoadBalancerPoliciesResult describeLoadBalancerPolicies(DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeLoadBalancerPoliciesResult) invoke(new DescribeLoadBalancerPoliciesRequestMarshaller().marshall(describeLoadBalancerPoliciesRequest), new DescribeLoadBalancerPoliciesResultStaxUnmarshaller());
    }

    public DescribeLoadBalancerPolicyTypesResult describeLoadBalancerPolicyTypes() throws AmazonServiceException, AmazonClientException {
        return describeLoadBalancerPolicyTypes(new DescribeLoadBalancerPolicyTypesRequest());
    }

    public DescribeLoadBalancerPolicyTypesResult describeLoadBalancerPolicyTypes(DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeLoadBalancerPolicyTypesResult) invoke(new DescribeLoadBalancerPolicyTypesRequestMarshaller().marshall(describeLoadBalancerPolicyTypesRequest), new DescribeLoadBalancerPolicyTypesResultStaxUnmarshaller());
    }

    public DescribeLoadBalancersResult describeLoadBalancers() throws AmazonServiceException, AmazonClientException {
        return describeLoadBalancers(new DescribeLoadBalancersRequest());
    }

    public DescribeLoadBalancersResult describeLoadBalancers(DescribeLoadBalancersRequest describeLoadBalancersRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeLoadBalancersResult) invoke(new DescribeLoadBalancersRequestMarshaller().marshall(describeLoadBalancersRequest), new DescribeLoadBalancersResultStaxUnmarshaller());
    }

    public DetachLoadBalancerFromSubnetsResult detachLoadBalancerFromSubnets(DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest) throws AmazonServiceException, AmazonClientException {
        return (DetachLoadBalancerFromSubnetsResult) invoke(new DetachLoadBalancerFromSubnetsRequestMarshaller().marshall(detachLoadBalancerFromSubnetsRequest), new DetachLoadBalancerFromSubnetsResultStaxUnmarshaller());
    }

    public DisableAvailabilityZonesForLoadBalancerResult disableAvailabilityZonesForLoadBalancer(DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (DisableAvailabilityZonesForLoadBalancerResult) invoke(new DisableAvailabilityZonesForLoadBalancerRequestMarshaller().marshall(disableAvailabilityZonesForLoadBalancerRequest), new DisableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller());
    }

    public EnableAvailabilityZonesForLoadBalancerResult enableAvailabilityZonesForLoadBalancer(EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (EnableAvailabilityZonesForLoadBalancerResult) invoke(new EnableAvailabilityZonesForLoadBalancerRequestMarshaller().marshall(enableAvailabilityZonesForLoadBalancerRequest), new EnableAvailabilityZonesForLoadBalancerResultStaxUnmarshaller());
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public RegisterInstancesWithLoadBalancerResult registerInstancesWithLoadBalancer(RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest) throws AmazonServiceException, AmazonClientException {
        return (RegisterInstancesWithLoadBalancerResult) invoke(new RegisterInstancesWithLoadBalancerRequestMarshaller().marshall(registerInstancesWithLoadBalancerRequest), new RegisterInstancesWithLoadBalancerResultStaxUnmarshaller());
    }

    public void setLoadBalancerListenerSSLCertificate(SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetLoadBalancerListenerSSLCertificateRequestMarshaller().marshall(setLoadBalancerListenerSSLCertificateRequest), null);
    }

    public SetLoadBalancerPoliciesForBackendServerResult setLoadBalancerPoliciesForBackendServer(SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest) throws AmazonServiceException, AmazonClientException {
        return (SetLoadBalancerPoliciesForBackendServerResult) invoke(new SetLoadBalancerPoliciesForBackendServerRequestMarshaller().marshall(setLoadBalancerPoliciesForBackendServerRequest), new SetLoadBalancerPoliciesForBackendServerResultStaxUnmarshaller());
    }

    public SetLoadBalancerPoliciesOfListenerResult setLoadBalancerPoliciesOfListener(SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest) throws AmazonServiceException, AmazonClientException {
        return (SetLoadBalancerPoliciesOfListenerResult) invoke(new SetLoadBalancerPoliciesOfListenerRequestMarshaller().marshall(setLoadBalancerPoliciesOfListenerRequest), new SetLoadBalancerPoliciesOfListenerResultStaxUnmarshaller());
    }
}
