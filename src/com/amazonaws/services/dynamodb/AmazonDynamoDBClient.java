package com.amazonaws.services.dynamodb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.internal.DynamoDBBackoffStrategy;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.dynamodb.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodb.model.BatchGetItemResult;
import com.amazonaws.services.dynamodb.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodb.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodb.model.CreateTableRequest;
import com.amazonaws.services.dynamodb.model.CreateTableResult;
import com.amazonaws.services.dynamodb.model.DeleteItemRequest;
import com.amazonaws.services.dynamodb.model.DeleteItemResult;
import com.amazonaws.services.dynamodb.model.DeleteTableRequest;
import com.amazonaws.services.dynamodb.model.DeleteTableResult;
import com.amazonaws.services.dynamodb.model.DescribeTableRequest;
import com.amazonaws.services.dynamodb.model.DescribeTableResult;
import com.amazonaws.services.dynamodb.model.GetItemRequest;
import com.amazonaws.services.dynamodb.model.GetItemResult;
import com.amazonaws.services.dynamodb.model.ListTablesRequest;
import com.amazonaws.services.dynamodb.model.ListTablesResult;
import com.amazonaws.services.dynamodb.model.PutItemRequest;
import com.amazonaws.services.dynamodb.model.PutItemResult;
import com.amazonaws.services.dynamodb.model.QueryRequest;
import com.amazonaws.services.dynamodb.model.QueryResult;
import com.amazonaws.services.dynamodb.model.ScanRequest;
import com.amazonaws.services.dynamodb.model.ScanResult;
import com.amazonaws.services.dynamodb.model.UpdateItemRequest;
import com.amazonaws.services.dynamodb.model.UpdateItemResult;
import com.amazonaws.services.dynamodb.model.UpdateTableRequest;
import com.amazonaws.services.dynamodb.model.UpdateTableResult;
import com.amazonaws.services.dynamodb.model.transform.BatchGetItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.BatchGetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.BatchWriteItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.BatchWriteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ConditionalCheckFailedExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.CreateTableRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.CreateTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.DeleteItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.DeleteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.DeleteTableRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.DeleteTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.DescribeTableRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.DescribeTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.GetItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.GetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ListTablesRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.ListTablesResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.PutItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.PutItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.QueryRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.QueryResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.ScanRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.ScanResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.UpdateItemRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.UpdateItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodb.model.transform.UpdateTableRequestMarshaller;
import com.amazonaws.services.dynamodb.model.transform.UpdateTableResultJsonUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AmazonDynamoDBClient extends AmazonWebServiceClient implements AmazonDynamoDB {
    private static final Log log;
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<Unmarshaller<AmazonServiceException, JSONObject>> exceptionUnmarshallers;
    private AWS4Signer signer;

    static {
        log = LogFactory.getLog(AmazonDynamoDB.class);
    }

    public AmazonDynamoDBClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonDynamoDBClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers = new ArrayList();
        this.exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InternalServerErrorExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ConditionalCheckFailedExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("dynamodb.us-east-1.amazonaws.com/");
        this.signer = new AWS4Signer();
        this.signer.setServiceName("dynamodb");
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/dynamodb/request.handlers"));
        this.clientConfiguration = new ClientConfiguration(this.clientConfiguration);
        if (this.clientConfiguration.getMaxErrorRetry() == 3) {
            log.debug("Overriding default max error retry value to: 10");
            this.clientConfiguration.setMaxErrorRetry(10);
        }
        setConfiguration(this.clientConfiguration);
    }

    private <X, Y extends AmazonWebServiceRequest> X invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) throws AmazonClientException {
        request.setEndpoint(this.endpoint);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.CredentialsRequestTime.name());
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        awsRequestMetrics.endEvent(Field.CredentialsRequestTime.name());
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (!(originalRequest == null || originalRequest.getRequestCredentials() == null)) {
            credentials = originalRequest.getRequestCredentials();
        }
        executionContext.setSigner(this.signer);
        executionContext.setCredentials(credentials);
        executionContext.setCustomBackoffStrategy(DynamoDBBackoffStrategy.DEFAULT);
        HttpResponseHandler jsonErrorResponseHandler = new JsonErrorResponseHandler(this.exceptionUnmarshallers);
        awsRequestMetrics.startEvent(Field.ClientExecuteTime.name());
        X execute = this.client.execute(request, httpResponseHandler, jsonErrorResponseHandler, executionContext);
        awsRequestMetrics.endEvent(Field.ClientExecuteTime.name());
        awsRequestMetrics.log();
        return execute;
    }

    public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new BatchGetItemRequestMarshaller().marshall(batchGetItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (BatchGetItemResult) invoke(marshall, new JsonResponseHandler(new BatchGetItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new BatchWriteItemRequestMarshaller().marshall(batchWriteItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (BatchWriteItemResult) invoke(marshall, new JsonResponseHandler(new BatchWriteItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public CreateTableResult createTable(CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new CreateTableRequestMarshaller().marshall(createTableRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (CreateTableResult) invoke(marshall, new JsonResponseHandler(new CreateTableResultJsonUnmarshaller()), createExecutionContext);
    }

    public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new DeleteItemRequestMarshaller().marshall(deleteItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (DeleteItemResult) invoke(marshall, new JsonResponseHandler(new DeleteItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new DeleteTableRequestMarshaller().marshall(deleteTableRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (DeleteTableResult) invoke(marshall, new JsonResponseHandler(new DeleteTableResultJsonUnmarshaller()), createExecutionContext);
    }

    public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new DescribeTableRequestMarshaller().marshall(describeTableRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (DescribeTableResult) invoke(marshall, new JsonResponseHandler(new DescribeTableResultJsonUnmarshaller()), createExecutionContext);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetItemResult getItem(GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new GetItemRequestMarshaller().marshall(getItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (GetItemResult) invoke(marshall, new JsonResponseHandler(new GetItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public ListTablesResult listTables() throws AmazonServiceException, AmazonClientException {
        return listTables(new ListTablesRequest());
    }

    public ListTablesResult listTables(ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new ListTablesRequestMarshaller().marshall(listTablesRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (ListTablesResult) invoke(marshall, new JsonResponseHandler(new ListTablesResultJsonUnmarshaller()), createExecutionContext);
    }

    public PutItemResult putItem(PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new PutItemRequestMarshaller().marshall(putItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (PutItemResult) invoke(marshall, new JsonResponseHandler(new PutItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public QueryResult query(QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new QueryRequestMarshaller().marshall(queryRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (QueryResult) invoke(marshall, new JsonResponseHandler(new QueryResultJsonUnmarshaller()), createExecutionContext);
    }

    public ScanResult scan(ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new ScanRequestMarshaller().marshall(scanRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (ScanResult) invoke(marshall, new JsonResponseHandler(new ScanResultJsonUnmarshaller()), createExecutionContext);
    }

    public void setEndpoint(String str, String str2, String str3) throws IllegalArgumentException {
        setEndpoint(str);
        this.signer.setServiceName(str2);
        this.signer.setRegionName(str3);
    }

    public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new UpdateItemRequestMarshaller().marshall(updateItemRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (UpdateItemResult) invoke(marshall, new JsonResponseHandler(new UpdateItemResultJsonUnmarshaller()), createExecutionContext);
    }

    public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
        ExecutionContext createExecutionContext = createExecutionContext();
        AWSRequestMetrics awsRequestMetrics = createExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(Field.RequestMarshallTime.name());
        Request marshall = new UpdateTableRequestMarshaller().marshall(updateTableRequest);
        awsRequestMetrics.endEvent(Field.RequestMarshallTime.name());
        return (UpdateTableResult) invoke(marshall, new JsonResponseHandler(new UpdateTableResultJsonUnmarshaller()), createExecutionContext);
    }
}
