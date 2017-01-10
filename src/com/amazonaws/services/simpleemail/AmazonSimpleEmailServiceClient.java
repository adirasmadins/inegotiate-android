package com.amazonaws.services.simpleemail;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWS3Signer;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.simpleemail.model.DeleteIdentityRequest;
import com.amazonaws.services.simpleemail.model.DeleteIdentityResult;
import com.amazonaws.services.simpleemail.model.DeleteVerifiedEmailAddressRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesResult;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesResult;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesResult;
import com.amazonaws.services.simpleemail.model.GetSendQuotaRequest;
import com.amazonaws.services.simpleemail.model.GetSendQuotaResult;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsRequest;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsResult;
import com.amazonaws.services.simpleemail.model.ListIdentitiesRequest;
import com.amazonaws.services.simpleemail.model.ListIdentitiesResult;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesRequest;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.services.simpleemail.model.SendRawEmailResult;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledResult;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledResult;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicResult;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimRequest;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimResult;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityRequest;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityResult;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityResult;
import com.amazonaws.services.simpleemail.model.transform.DeleteIdentityRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.DeleteIdentityResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.DeleteVerifiedEmailAddressRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityDkimAttributesRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityDkimAttributesResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityNotificationAttributesRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityNotificationAttributesResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityVerificationAttributesRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetIdentityVerificationAttributesResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetSendQuotaRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetSendQuotaResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetSendStatisticsRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.GetSendStatisticsResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.ListIdentitiesRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.ListIdentitiesResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.ListVerifiedEmailAddressesRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.ListVerifiedEmailAddressesResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.MessageRejectedExceptionUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.SendEmailRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.SendEmailResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.SendRawEmailRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.SendRawEmailResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityDkimEnabledRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityDkimEnabledResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityFeedbackForwardingEnabledRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityNotificationTopicRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.SetIdentityNotificationTopicResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyDomainDkimRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyDomainDkimResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyDomainIdentityRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyDomainIdentityResultStaxUnmarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyEmailAddressRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyEmailIdentityRequestMarshaller;
import com.amazonaws.services.simpleemail.model.transform.VerifyEmailIdentityResultStaxUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonSimpleEmailServiceClient extends AmazonWebServiceClient implements AmazonSimpleEmailService {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private AWS3Signer signer;

    public AmazonSimpleEmailServiceClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonSimpleEmailServiceClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonSimpleEmailServiceClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonSimpleEmailServiceClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonSimpleEmailServiceClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonSimpleEmailServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new MessageRejectedExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("email.us-east-1.amazonaws.com");
        this.signer = new AWS3Signer();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/simpleemail/request.handlers"));
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

    public DeleteIdentityResult deleteIdentity(DeleteIdentityRequest deleteIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return (DeleteIdentityResult) invoke(new DeleteIdentityRequestMarshaller().marshall(deleteIdentityRequest), new DeleteIdentityResultStaxUnmarshaller());
    }

    public void deleteVerifiedEmailAddress(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteVerifiedEmailAddressRequestMarshaller().marshall(deleteVerifiedEmailAddressRequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetIdentityDkimAttributesResult getIdentityDkimAttributes(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetIdentityDkimAttributesResult) invoke(new GetIdentityDkimAttributesRequestMarshaller().marshall(getIdentityDkimAttributesRequest), new GetIdentityDkimAttributesResultStaxUnmarshaller());
    }

    public GetIdentityNotificationAttributesResult getIdentityNotificationAttributes(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetIdentityNotificationAttributesResult) invoke(new GetIdentityNotificationAttributesRequestMarshaller().marshall(getIdentityNotificationAttributesRequest), new GetIdentityNotificationAttributesResultStaxUnmarshaller());
    }

    public GetIdentityVerificationAttributesResult getIdentityVerificationAttributes(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return (GetIdentityVerificationAttributesResult) invoke(new GetIdentityVerificationAttributesRequestMarshaller().marshall(getIdentityVerificationAttributesRequest), new GetIdentityVerificationAttributesResultStaxUnmarshaller());
    }

    public GetSendQuotaResult getSendQuota() throws AmazonServiceException, AmazonClientException {
        return getSendQuota(new GetSendQuotaRequest());
    }

    public GetSendQuotaResult getSendQuota(GetSendQuotaRequest getSendQuotaRequest) throws AmazonServiceException, AmazonClientException {
        return (GetSendQuotaResult) invoke(new GetSendQuotaRequestMarshaller().marshall(getSendQuotaRequest), new GetSendQuotaResultStaxUnmarshaller());
    }

    public GetSendStatisticsResult getSendStatistics() throws AmazonServiceException, AmazonClientException {
        return getSendStatistics(new GetSendStatisticsRequest());
    }

    public GetSendStatisticsResult getSendStatistics(GetSendStatisticsRequest getSendStatisticsRequest) throws AmazonServiceException, AmazonClientException {
        return (GetSendStatisticsResult) invoke(new GetSendStatisticsRequestMarshaller().marshall(getSendStatisticsRequest), new GetSendStatisticsResultStaxUnmarshaller());
    }

    public ListIdentitiesResult listIdentities() throws AmazonServiceException, AmazonClientException {
        return listIdentities(new ListIdentitiesRequest());
    }

    public ListIdentitiesResult listIdentities(ListIdentitiesRequest listIdentitiesRequest) throws AmazonServiceException, AmazonClientException {
        return (ListIdentitiesResult) invoke(new ListIdentitiesRequestMarshaller().marshall(listIdentitiesRequest), new ListIdentitiesResultStaxUnmarshaller());
    }

    public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses() throws AmazonServiceException, AmazonClientException {
        return listVerifiedEmailAddresses(new ListVerifiedEmailAddressesRequest());
    }

    public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest) throws AmazonServiceException, AmazonClientException {
        return (ListVerifiedEmailAddressesResult) invoke(new ListVerifiedEmailAddressesRequestMarshaller().marshall(listVerifiedEmailAddressesRequest), new ListVerifiedEmailAddressesResultStaxUnmarshaller());
    }

    public SendEmailResult sendEmail(SendEmailRequest sendEmailRequest) throws AmazonServiceException, AmazonClientException {
        return (SendEmailResult) invoke(new SendEmailRequestMarshaller().marshall(sendEmailRequest), new SendEmailResultStaxUnmarshaller());
    }

    public SendRawEmailResult sendRawEmail(SendRawEmailRequest sendRawEmailRequest) throws AmazonServiceException, AmazonClientException {
        return (SendRawEmailResult) invoke(new SendRawEmailRequestMarshaller().marshall(sendRawEmailRequest), new SendRawEmailResultStaxUnmarshaller());
    }

    public SetIdentityDkimEnabledResult setIdentityDkimEnabled(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest) throws AmazonServiceException, AmazonClientException {
        return (SetIdentityDkimEnabledResult) invoke(new SetIdentityDkimEnabledRequestMarshaller().marshall(setIdentityDkimEnabledRequest), new SetIdentityDkimEnabledResultStaxUnmarshaller());
    }

    public SetIdentityFeedbackForwardingEnabledResult setIdentityFeedbackForwardingEnabled(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest) throws AmazonServiceException, AmazonClientException {
        return (SetIdentityFeedbackForwardingEnabledResult) invoke(new SetIdentityFeedbackForwardingEnabledRequestMarshaller().marshall(setIdentityFeedbackForwardingEnabledRequest), new SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller());
    }

    public SetIdentityNotificationTopicResult setIdentityNotificationTopic(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest) throws AmazonServiceException, AmazonClientException {
        return (SetIdentityNotificationTopicResult) invoke(new SetIdentityNotificationTopicRequestMarshaller().marshall(setIdentityNotificationTopicRequest), new SetIdentityNotificationTopicResultStaxUnmarshaller());
    }

    public VerifyDomainDkimResult verifyDomainDkim(VerifyDomainDkimRequest verifyDomainDkimRequest) throws AmazonServiceException, AmazonClientException {
        return (VerifyDomainDkimResult) invoke(new VerifyDomainDkimRequestMarshaller().marshall(verifyDomainDkimRequest), new VerifyDomainDkimResultStaxUnmarshaller());
    }

    public VerifyDomainIdentityResult verifyDomainIdentity(VerifyDomainIdentityRequest verifyDomainIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return (VerifyDomainIdentityResult) invoke(new VerifyDomainIdentityRequestMarshaller().marshall(verifyDomainIdentityRequest), new VerifyDomainIdentityResultStaxUnmarshaller());
    }

    public void verifyEmailAddress(VerifyEmailAddressRequest verifyEmailAddressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new VerifyEmailAddressRequestMarshaller().marshall(verifyEmailAddressRequest), null);
    }

    public VerifyEmailIdentityResult verifyEmailIdentity(VerifyEmailIdentityRequest verifyEmailIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return (VerifyEmailIdentityResult) invoke(new VerifyEmailIdentityRequestMarshaller().marshall(verifyEmailIdentityRequest), new VerifyEmailIdentityResultStaxUnmarshaller());
    }
}
