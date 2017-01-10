package com.amazonaws.services.simpledb;

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
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.simpledb.internal.SimpleDBStaxResponseHandler;
import com.amazonaws.services.simpledb.model.BatchDeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataResult;
import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.amazonaws.services.simpledb.model.GetAttributesResult;
import com.amazonaws.services.simpledb.model.ListDomainsRequest;
import com.amazonaws.services.simpledb.model.ListDomainsResult;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;
import com.amazonaws.services.simpledb.model.transform.AttributeDoesNotExistExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.BatchDeleteAttributesRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.BatchPutAttributesRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.CreateDomainRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.DeleteAttributesRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.DeleteDomainRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.DomainMetadataRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.DomainMetadataResultStaxUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.DuplicateItemNameExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.GetAttributesRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.GetAttributesResultStaxUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.InvalidNextTokenExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.InvalidNumberPredicatesExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.InvalidNumberValueTestsExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.InvalidParameterValueExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.InvalidQueryExpressionExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.ListDomainsRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.ListDomainsResultStaxUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.MissingParameterExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NoSuchDomainExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberDomainAttributesExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberDomainBytesExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberDomainsExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberItemAttributesExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberSubmittedAttributesExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.NumberSubmittedItemsExceededExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.PutAttributesRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.RequestTimeoutExceptionUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.SelectRequestMarshaller;
import com.amazonaws.services.simpledb.model.transform.SelectResultStaxUnmarshaller;
import com.amazonaws.services.simpledb.model.transform.TooManyRequestedAttributesExceptionUnmarshaller;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonSimpleDBClient extends AmazonWebServiceClient implements AmazonSimpleDB {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private QueryStringSigner signer;

    public AmazonSimpleDBClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonSimpleDBClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonSimpleDBClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonSimpleDBClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonSimpleDBClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonSimpleDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new InvalidParameterValueExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberDomainBytesExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NoSuchDomainExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberDomainsExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberSubmittedItemsExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new RequestTimeoutExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidQueryExpressionExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberSubmittedAttributesExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new DuplicateItemNameExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberDomainAttributesExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidNumberPredicatesExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new TooManyRequestedAttributesExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new NumberItemAttributesExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new AttributeDoesNotExistExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new MissingParameterExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidNumberValueTestsExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new LegacyErrorUnmarshaller());
        setEndpoint("sdb.amazonaws.com");
        this.signer = new QueryStringSigner();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/simpledb/request.handlers"));
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
        return this.client.execute(request, new SimpleDBStaxResponseHandler(unmarshaller), new DefaultErrorResponseHandler(this.exceptionUnmarshallers), createExecutionContext);
    }

    public void batchDeleteAttributes(BatchDeleteAttributesRequest batchDeleteAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new BatchDeleteAttributesRequestMarshaller().marshall(batchDeleteAttributesRequest), null);
    }

    public void batchPutAttributes(BatchPutAttributesRequest batchPutAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new BatchPutAttributesRequestMarshaller().marshall(batchPutAttributesRequest), null);
    }

    public void createDomain(CreateDomainRequest createDomainRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateDomainRequestMarshaller().marshall(createDomainRequest), null);
    }

    public void deleteAttributes(DeleteAttributesRequest deleteAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteAttributesRequestMarshaller().marshall(deleteAttributesRequest), null);
    }

    public void deleteDomain(DeleteDomainRequest deleteDomainRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteDomainRequestMarshaller().marshall(deleteDomainRequest), null);
    }

    public DomainMetadataResult domainMetadata(DomainMetadataRequest domainMetadataRequest) throws AmazonServiceException, AmazonClientException {
        return (DomainMetadataResult) invoke(new DomainMetadataRequestMarshaller().marshall(domainMetadataRequest), new DomainMetadataResultStaxUnmarshaller());
    }

    public GetAttributesResult getAttributes(GetAttributesRequest getAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetAttributesResult) invoke(new GetAttributesRequestMarshaller().marshall(getAttributesRequest), new GetAttributesResultStaxUnmarshaller());
    }

    public SimpleDBResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        ResponseMetadata responseMetadataForRequest = this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
        return responseMetadataForRequest != null ? new SimpleDBResponseMetadata(responseMetadataForRequest) : null;
    }

    public ListDomainsResult listDomains() throws AmazonServiceException, AmazonClientException {
        return listDomains(new ListDomainsRequest());
    }

    public ListDomainsResult listDomains(ListDomainsRequest listDomainsRequest) throws AmazonServiceException, AmazonClientException {
        return (ListDomainsResult) invoke(new ListDomainsRequestMarshaller().marshall(listDomainsRequest), new ListDomainsResultStaxUnmarshaller());
    }

    public void putAttributes(PutAttributesRequest putAttributesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new PutAttributesRequestMarshaller().marshall(putAttributesRequest), null);
    }

    public SelectResult select(SelectRequest selectRequest) throws AmazonServiceException, AmazonClientException {
        return (SelectResult) invoke(new SelectRequestMarshaller().marshall(selectRequest), new SelectResultStaxUnmarshaller());
    }
}
