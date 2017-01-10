package com.amazonaws.services.cloudwatch;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazonaws.services.cloudwatch.model.transform.DeleteAlarmsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryResultStaxUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricResultStaxUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsResultStaxUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.DisableAlarmActionsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.EnableAlarmActionsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsResultStaxUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.InternalServiceExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.InvalidFormatExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.InvalidNextTokenExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.InvalidParameterCombinationExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.InvalidParameterValueExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.ListMetricsRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.ListMetricsResultStaxUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.MissingRequiredParameterExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.PutMetricAlarmRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.PutMetricDataRequestMarshaller;
import com.amazonaws.services.cloudwatch.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cloudwatch.model.transform.SetAlarmStateRequestMarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonCloudWatchClient extends AmazonWebServiceClient implements AmazonCloudWatch {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private AWS4Signer signer;

    public AmazonCloudWatchClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonCloudWatchClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonCloudWatchClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonCloudWatchClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonCloudWatchClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonCloudWatchClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidParameterCombinationExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidFormatExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InternalServiceExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new MissingRequiredParameterExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidParameterValueExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("monitoring.amazonaws.com");
        this.signer = new AWS4Signer();
        this.signer.setServiceName("monitoring");
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/cloudwatch/request.handlers"));
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

    public void deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteAlarmsRequestMarshaller().marshall(deleteAlarmsRequest), null);
    }

    public DescribeAlarmHistoryResult describeAlarmHistory() throws AmazonServiceException, AmazonClientException {
        return describeAlarmHistory(new DescribeAlarmHistoryRequest());
    }

    public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAlarmHistoryResult) invoke(new DescribeAlarmHistoryRequestMarshaller().marshall(describeAlarmHistoryRequest), new DescribeAlarmHistoryResultStaxUnmarshaller());
    }

    public DescribeAlarmsResult describeAlarms() throws AmazonServiceException, AmazonClientException {
        return describeAlarms(new DescribeAlarmsRequest());
    }

    public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAlarmsResult) invoke(new DescribeAlarmsRequestMarshaller().marshall(describeAlarmsRequest), new DescribeAlarmsResultStaxUnmarshaller());
    }

    public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAlarmsForMetricResult) invoke(new DescribeAlarmsForMetricRequestMarshaller().marshall(describeAlarmsForMetricRequest), new DescribeAlarmsForMetricResultStaxUnmarshaller());
    }

    public void disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DisableAlarmActionsRequestMarshaller().marshall(disableAlarmActionsRequest), null);
    }

    public void enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new EnableAlarmActionsRequestMarshaller().marshall(enableAlarmActionsRequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) throws AmazonServiceException, AmazonClientException {
        return (GetMetricStatisticsResult) invoke(new GetMetricStatisticsRequestMarshaller().marshall(getMetricStatisticsRequest), new GetMetricStatisticsResultStaxUnmarshaller());
    }

    public ListMetricsResult listMetrics() throws AmazonServiceException, AmazonClientException {
        return listMetrics(new ListMetricsRequest());
    }

    public ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) throws AmazonServiceException, AmazonClientException {
        return (ListMetricsResult) invoke(new ListMetricsRequestMarshaller().marshall(listMetricsRequest), new ListMetricsResultStaxUnmarshaller());
    }

    public void putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new PutMetricAlarmRequestMarshaller().marshall(putMetricAlarmRequest), null);
    }

    public void putMetricData(PutMetricDataRequest putMetricDataRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new PutMetricDataRequestMarshaller().marshall(putMetricDataRequest), null);
    }

    public void setAlarmState(SetAlarmStateRequest setAlarmStateRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetAlarmStateRequestMarshaller().marshall(setAlarmStateRequest), null);
    }

    public void setEndpoint(String str, String str2, String str3) throws IllegalArgumentException {
        setEndpoint(str);
        this.signer.setServiceName(str2);
        this.signer.setRegionName(str3);
    }
}
