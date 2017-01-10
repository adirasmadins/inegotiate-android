package com.amazonaws.services.sns;

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
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.services.sns.model.transform.AddPermissionRequestMarshaller;
import com.amazonaws.services.sns.model.transform.AuthorizationErrorExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.ConfirmSubscriptionRequestMarshaller;
import com.amazonaws.services.sns.model.transform.ConfirmSubscriptionResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.CreateTopicRequestMarshaller;
import com.amazonaws.services.sns.model.transform.CreateTopicResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.DeleteTopicRequestMarshaller;
import com.amazonaws.services.sns.model.transform.GetSubscriptionAttributesRequestMarshaller;
import com.amazonaws.services.sns.model.transform.GetSubscriptionAttributesResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.GetTopicAttributesRequestMarshaller;
import com.amazonaws.services.sns.model.transform.GetTopicAttributesResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.ListSubscriptionsByTopicRequestMarshaller;
import com.amazonaws.services.sns.model.transform.ListSubscriptionsByTopicResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.ListSubscriptionsRequestMarshaller;
import com.amazonaws.services.sns.model.transform.ListSubscriptionsResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.ListTopicsRequestMarshaller;
import com.amazonaws.services.sns.model.transform.ListTopicsResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.NotFoundExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.PublishRequestMarshaller;
import com.amazonaws.services.sns.model.transform.PublishResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.RemovePermissionRequestMarshaller;
import com.amazonaws.services.sns.model.transform.SetSubscriptionAttributesRequestMarshaller;
import com.amazonaws.services.sns.model.transform.SetTopicAttributesRequestMarshaller;
import com.amazonaws.services.sns.model.transform.SubscribeRequestMarshaller;
import com.amazonaws.services.sns.model.transform.SubscribeResultStaxUnmarshaller;
import com.amazonaws.services.sns.model.transform.SubscriptionLimitExceededExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.TopicLimitExceededExceptionUnmarshaller;
import com.amazonaws.services.sns.model.transform.UnsubscribeRequestMarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonSNSClient extends AmazonWebServiceClient implements AmazonSNS {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private QueryStringSigner signer;

    public AmazonSNSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonSNSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonSNSClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonSNSClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonSNSClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonSNSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new AuthorizationErrorExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new TopicLimitExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InternalErrorExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new SubscriptionLimitExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidParameterExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("sns.us-east-1.amazonaws.com");
        this.signer = new QueryStringSigner();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/sns/request.handlers"));
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

    public void addPermission(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new AddPermissionRequestMarshaller().marshall(addPermissionRequest), null);
    }

    public ConfirmSubscriptionResult confirmSubscription(ConfirmSubscriptionRequest confirmSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return (ConfirmSubscriptionResult) invoke(new ConfirmSubscriptionRequestMarshaller().marshall(confirmSubscriptionRequest), new ConfirmSubscriptionResultStaxUnmarshaller());
    }

    public CreateTopicResult createTopic(CreateTopicRequest createTopicRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateTopicResult) invoke(new CreateTopicRequestMarshaller().marshall(createTopicRequest), new CreateTopicResultStaxUnmarshaller());
    }

    public void deleteTopic(DeleteTopicRequest deleteTopicRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteTopicRequestMarshaller().marshall(deleteTopicRequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetSubscriptionAttributesResult getSubscriptionAttributes(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetSubscriptionAttributesResult) invoke(new GetSubscriptionAttributesRequestMarshaller().marshall(getSubscriptionAttributesRequest), new GetSubscriptionAttributesResultStaxUnmarshaller());
    }

    public GetTopicAttributesResult getTopicAttributes(GetTopicAttributesRequest getTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetTopicAttributesResult) invoke(new GetTopicAttributesRequestMarshaller().marshall(getTopicAttributesRequest), new GetTopicAttributesResultStaxUnmarshaller());
    }

    public ListSubscriptionsResult listSubscriptions() throws AmazonServiceException, AmazonClientException {
        return listSubscriptions(new ListSubscriptionsRequest());
    }

    public ListSubscriptionsResult listSubscriptions(ListSubscriptionsRequest listSubscriptionsRequest) throws AmazonServiceException, AmazonClientException {
        return (ListSubscriptionsResult) invoke(new ListSubscriptionsRequestMarshaller().marshall(listSubscriptionsRequest), new ListSubscriptionsResultStaxUnmarshaller());
    }

    public ListSubscriptionsByTopicResult listSubscriptionsByTopic(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) throws AmazonServiceException, AmazonClientException {
        return (ListSubscriptionsByTopicResult) invoke(new ListSubscriptionsByTopicRequestMarshaller().marshall(listSubscriptionsByTopicRequest), new ListSubscriptionsByTopicResultStaxUnmarshaller());
    }

    public ListTopicsResult listTopics() throws AmazonServiceException, AmazonClientException {
        return listTopics(new ListTopicsRequest());
    }

    public ListTopicsResult listTopics(ListTopicsRequest listTopicsRequest) throws AmazonServiceException, AmazonClientException {
        return (ListTopicsResult) invoke(new ListTopicsRequestMarshaller().marshall(listTopicsRequest), new ListTopicsResultStaxUnmarshaller());
    }

    public PublishResult publish(PublishRequest publishRequest) throws AmazonServiceException, AmazonClientException {
        return (PublishResult) invoke(new PublishRequestMarshaller().marshall(publishRequest), new PublishResultStaxUnmarshaller());
    }

    public void removePermission(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new RemovePermissionRequestMarshaller().marshall(removePermissionRequest), null);
    }

    public void setSubscriptionAttributes(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetSubscriptionAttributesRequestMarshaller().marshall(setSubscriptionAttributesRequest), null);
    }

    public void setTopicAttributes(SetTopicAttributesRequest setTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetTopicAttributesRequestMarshaller().marshall(setTopicAttributesRequest), null);
    }

    public SubscribeResult subscribe(SubscribeRequest subscribeRequest) throws AmazonServiceException, AmazonClientException {
        return (SubscribeResult) invoke(new SubscribeRequestMarshaller().marshall(subscribeRequest), new SubscribeResultStaxUnmarshaller());
    }

    public void unsubscribe(UnsubscribeRequest unsubscribeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new UnsubscribeRequestMarshaller().marshall(unsubscribeRequest), null);
    }
}
