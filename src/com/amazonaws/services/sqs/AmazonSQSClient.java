package com.amazonaws.services.sqs;

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
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.transform.AddPermissionRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.BatchEntryIdsNotDistinctExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.BatchRequestTooLongExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.CreateQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.CreateQueueResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.DeleteQueueRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.EmptyBatchRequestExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueAttributesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueAttributesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueUrlRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.GetQueueUrlResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidAttributeNameExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidBatchEntryIdExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidIdFormatExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.InvalidMessageContentsExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueuesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ListQueuesResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.MessageNotInflightExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.OverLimitExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueDeletedRecentlyExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueDoesNotExistExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.QueueNameExistsExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiptHandleIsInvalidExceptionUnmarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiveMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.ReceiveMessageResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.RemovePermissionRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageBatchRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageBatchResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.SendMessageResultStaxUnmarshaller;
import com.amazonaws.services.sqs.model.transform.SetQueueAttributesRequestMarshaller;
import com.amazonaws.services.sqs.model.transform.TooManyEntriesInBatchRequestExceptionUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonSQSClient extends AmazonWebServiceClient implements AmazonSQS {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private QueryStringSigner signer;

    public AmazonSQSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonSQSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonSQSClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonSQSClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonSQSClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonSQSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new QueueDeletedRecentlyExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new QueueNameExistsExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new EmptyBatchRequestExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidMessageContentsExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidBatchEntryIdExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new OverLimitExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new TooManyEntriesInBatchRequestExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidIdFormatExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new QueueDoesNotExistExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidAttributeNameExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new BatchRequestTooLongExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ReceiptHandleIsInvalidExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new MessageNotInflightExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new BatchEntryIdsNotDistinctExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("queue.amazonaws.com");
        this.signer = new QueryStringSigner();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/sqs/request.handlers"));
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

    public void changeMessageVisibility(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ChangeMessageVisibilityRequestMarshaller().marshall(changeMessageVisibilityRequest), null);
    }

    public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) throws AmazonServiceException, AmazonClientException {
        return (ChangeMessageVisibilityBatchResult) invoke(new ChangeMessageVisibilityBatchRequestMarshaller().marshall(changeMessageVisibilityBatchRequest), new ChangeMessageVisibilityBatchResultStaxUnmarshaller());
    }

    public CreateQueueResult createQueue(CreateQueueRequest createQueueRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateQueueResult) invoke(new CreateQueueRequestMarshaller().marshall(createQueueRequest), new CreateQueueResultStaxUnmarshaller());
    }

    public void deleteMessage(DeleteMessageRequest deleteMessageRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteMessageRequestMarshaller().marshall(deleteMessageRequest), null);
    }

    public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest deleteMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        return (DeleteMessageBatchResult) invoke(new DeleteMessageBatchRequestMarshaller().marshall(deleteMessageBatchRequest), new DeleteMessageBatchResultStaxUnmarshaller());
    }

    public void deleteQueue(DeleteQueueRequest deleteQueueRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteQueueRequestMarshaller().marshall(deleteQueueRequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest getQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetQueueAttributesResult) invoke(new GetQueueAttributesRequestMarshaller().marshall(getQueueAttributesRequest), new GetQueueAttributesResultStaxUnmarshaller());
    }

    public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest getQueueUrlRequest) throws AmazonServiceException, AmazonClientException {
        return (GetQueueUrlResult) invoke(new GetQueueUrlRequestMarshaller().marshall(getQueueUrlRequest), new GetQueueUrlResultStaxUnmarshaller());
    }

    public ListQueuesResult listQueues() throws AmazonServiceException, AmazonClientException {
        return listQueues(new ListQueuesRequest());
    }

    public ListQueuesResult listQueues(ListQueuesRequest listQueuesRequest) throws AmazonServiceException, AmazonClientException {
        return (ListQueuesResult) invoke(new ListQueuesRequestMarshaller().marshall(listQueuesRequest), new ListQueuesResultStaxUnmarshaller());
    }

    public ReceiveMessageResult receiveMessage(ReceiveMessageRequest receiveMessageRequest) throws AmazonServiceException, AmazonClientException {
        return (ReceiveMessageResult) invoke(new ReceiveMessageRequestMarshaller().marshall(receiveMessageRequest), new ReceiveMessageResultStaxUnmarshaller());
    }

    public void removePermission(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new RemovePermissionRequestMarshaller().marshall(removePermissionRequest), null);
    }

    public SendMessageResult sendMessage(SendMessageRequest sendMessageRequest) throws AmazonServiceException, AmazonClientException {
        return (SendMessageResult) invoke(new SendMessageRequestMarshaller().marshall(sendMessageRequest), new SendMessageResultStaxUnmarshaller());
    }

    public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest sendMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        return (SendMessageBatchResult) invoke(new SendMessageBatchRequestMarshaller().marshall(sendMessageBatchRequest), new SendMessageBatchResultStaxUnmarshaller());
    }

    public void setQueueAttributes(SetQueueAttributesRequest setQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetQueueAttributesRequestMarshaller().marshall(setQueueAttributesRequest), null);
    }
}
