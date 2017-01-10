package com.amazonaws.services.autoscaling;

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
import com.amazonaws.services.autoscaling.model.CreateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.CreateOrUpdateTagsRequest;
import com.amazonaws.services.autoscaling.model.DeleteAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.DeleteLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.DeleteNotificationConfigurationRequest;
import com.amazonaws.services.autoscaling.model.DeletePolicyRequest;
import com.amazonaws.services.autoscaling.model.DeleteScheduledActionRequest;
import com.amazonaws.services.autoscaling.model.DeleteTagsRequest;
import com.amazonaws.services.autoscaling.model.DescribeAdjustmentTypesRequest;
import com.amazonaws.services.autoscaling.model.DescribeAdjustmentTypesResult;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsRequest;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingGroupsResult;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingInstancesRequest;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingInstancesResult;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingNotificationTypesRequest;
import com.amazonaws.services.autoscaling.model.DescribeAutoScalingNotificationTypesResult;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsRequest;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.services.autoscaling.model.DescribeMetricCollectionTypesRequest;
import com.amazonaws.services.autoscaling.model.DescribeMetricCollectionTypesResult;
import com.amazonaws.services.autoscaling.model.DescribeNotificationConfigurationsRequest;
import com.amazonaws.services.autoscaling.model.DescribeNotificationConfigurationsResult;
import com.amazonaws.services.autoscaling.model.DescribePoliciesRequest;
import com.amazonaws.services.autoscaling.model.DescribePoliciesResult;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesRequest;
import com.amazonaws.services.autoscaling.model.DescribeScalingActivitiesResult;
import com.amazonaws.services.autoscaling.model.DescribeScalingProcessTypesRequest;
import com.amazonaws.services.autoscaling.model.DescribeScalingProcessTypesResult;
import com.amazonaws.services.autoscaling.model.DescribeScheduledActionsRequest;
import com.amazonaws.services.autoscaling.model.DescribeScheduledActionsResult;
import com.amazonaws.services.autoscaling.model.DescribeTagsRequest;
import com.amazonaws.services.autoscaling.model.DescribeTagsResult;
import com.amazonaws.services.autoscaling.model.DescribeTerminationPolicyTypesRequest;
import com.amazonaws.services.autoscaling.model.DescribeTerminationPolicyTypesResult;
import com.amazonaws.services.autoscaling.model.DisableMetricsCollectionRequest;
import com.amazonaws.services.autoscaling.model.EnableMetricsCollectionRequest;
import com.amazonaws.services.autoscaling.model.ExecutePolicyRequest;
import com.amazonaws.services.autoscaling.model.PutNotificationConfigurationRequest;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyRequest;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.amazonaws.services.autoscaling.model.PutScheduledUpdateGroupActionRequest;
import com.amazonaws.services.autoscaling.model.ResumeProcessesRequest;
import com.amazonaws.services.autoscaling.model.SetDesiredCapacityRequest;
import com.amazonaws.services.autoscaling.model.SetInstanceHealthRequest;
import com.amazonaws.services.autoscaling.model.SuspendProcessesRequest;
import com.amazonaws.services.autoscaling.model.TerminateInstanceInAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.TerminateInstanceInAutoScalingGroupResult;
import com.amazonaws.services.autoscaling.model.UpdateAutoScalingGroupRequest;
import com.amazonaws.services.autoscaling.model.transform.AlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.CreateAutoScalingGroupRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.CreateLaunchConfigurationRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.CreateOrUpdateTagsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeleteAutoScalingGroupRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeleteLaunchConfigurationRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeleteNotificationConfigurationRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeletePolicyRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeleteScheduledActionRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DeleteTagsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAdjustmentTypesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAdjustmentTypesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingGroupsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingGroupsResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingInstancesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingInstancesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingNotificationTypesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeAutoScalingNotificationTypesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeLaunchConfigurationsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeLaunchConfigurationsResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeMetricCollectionTypesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeMetricCollectionTypesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeNotificationConfigurationsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeNotificationConfigurationsResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribePoliciesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribePoliciesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScalingActivitiesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScalingActivitiesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScalingProcessTypesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScalingProcessTypesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScheduledActionsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeScheduledActionsResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeTagsRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeTagsResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeTerminationPolicyTypesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.DescribeTerminationPolicyTypesResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.DisableMetricsCollectionRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.EnableMetricsCollectionRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.ExecutePolicyRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.InvalidNextTokenExceptionUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.PutNotificationConfigurationRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.PutScalingPolicyRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.PutScalingPolicyResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.PutScheduledUpdateGroupActionRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.ResumeProcessesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.ScalingActivityInProgressExceptionUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.SetDesiredCapacityRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.SetInstanceHealthRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.SuspendProcessesRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.TerminateInstanceInAutoScalingGroupRequestMarshaller;
import com.amazonaws.services.autoscaling.model.transform.TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller;
import com.amazonaws.services.autoscaling.model.transform.UpdateAutoScalingGroupRequestMarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonAutoScalingClient extends AmazonWebServiceClient implements AmazonAutoScaling {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private AWS4Signer signer;

    public AmazonAutoScalingClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonAutoScalingClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonAutoScalingClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonAutoScalingClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonAutoScalingClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonAutoScalingClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new InvalidNextTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ScalingActivityInProgressExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new AlreadyExistsExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("autoscaling.amazonaws.com");
        this.signer = new AWS4Signer();
        this.signer.setServiceName("autoscaling");
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/autoscaling/request.handlers"));
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

    public void createAutoScalingGroup(CreateAutoScalingGroupRequest createAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateAutoScalingGroupRequestMarshaller().marshall(createAutoScalingGroupRequest), null);
    }

    public void createLaunchConfiguration(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateLaunchConfigurationRequestMarshaller().marshall(createLaunchConfigurationRequest), null);
    }

    public void createOrUpdateTags(CreateOrUpdateTagsRequest createOrUpdateTagsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateOrUpdateTagsRequestMarshaller().marshall(createOrUpdateTagsRequest), null);
    }

    public void deleteAutoScalingGroup(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteAutoScalingGroupRequestMarshaller().marshall(deleteAutoScalingGroupRequest), null);
    }

    public void deleteLaunchConfiguration(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteLaunchConfigurationRequestMarshaller().marshall(deleteLaunchConfigurationRequest), null);
    }

    public void deleteNotificationConfiguration(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteNotificationConfigurationRequestMarshaller().marshall(deleteNotificationConfigurationRequest), null);
    }

    public void deletePolicy(DeletePolicyRequest deletePolicyRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeletePolicyRequestMarshaller().marshall(deletePolicyRequest), null);
    }

    public void deleteScheduledAction(DeleteScheduledActionRequest deleteScheduledActionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteScheduledActionRequestMarshaller().marshall(deleteScheduledActionRequest), null);
    }

    public void deleteTags(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteTagsRequestMarshaller().marshall(deleteTagsRequest), null);
    }

    public DescribeAdjustmentTypesResult describeAdjustmentTypes() throws AmazonServiceException, AmazonClientException {
        return describeAdjustmentTypes(new DescribeAdjustmentTypesRequest());
    }

    public DescribeAdjustmentTypesResult describeAdjustmentTypes(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAdjustmentTypesResult) invoke(new DescribeAdjustmentTypesRequestMarshaller().marshall(describeAdjustmentTypesRequest), new DescribeAdjustmentTypesResultStaxUnmarshaller());
    }

    public DescribeAutoScalingGroupsResult describeAutoScalingGroups() throws AmazonServiceException, AmazonClientException {
        return describeAutoScalingGroups(new DescribeAutoScalingGroupsRequest());
    }

    public DescribeAutoScalingGroupsResult describeAutoScalingGroups(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAutoScalingGroupsResult) invoke(new DescribeAutoScalingGroupsRequestMarshaller().marshall(describeAutoScalingGroupsRequest), new DescribeAutoScalingGroupsResultStaxUnmarshaller());
    }

    public DescribeAutoScalingInstancesResult describeAutoScalingInstances() throws AmazonServiceException, AmazonClientException {
        return describeAutoScalingInstances(new DescribeAutoScalingInstancesRequest());
    }

    public DescribeAutoScalingInstancesResult describeAutoScalingInstances(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAutoScalingInstancesResult) invoke(new DescribeAutoScalingInstancesRequestMarshaller().marshall(describeAutoScalingInstancesRequest), new DescribeAutoScalingInstancesResultStaxUnmarshaller());
    }

    public DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes() throws AmazonServiceException, AmazonClientException {
        return describeAutoScalingNotificationTypes(new DescribeAutoScalingNotificationTypesRequest());
    }

    public DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAutoScalingNotificationTypesResult) invoke(new DescribeAutoScalingNotificationTypesRequestMarshaller().marshall(describeAutoScalingNotificationTypesRequest), new DescribeAutoScalingNotificationTypesResultStaxUnmarshaller());
    }

    public DescribeLaunchConfigurationsResult describeLaunchConfigurations() throws AmazonServiceException, AmazonClientException {
        return describeLaunchConfigurations(new DescribeLaunchConfigurationsRequest());
    }

    public DescribeLaunchConfigurationsResult describeLaunchConfigurations(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeLaunchConfigurationsResult) invoke(new DescribeLaunchConfigurationsRequestMarshaller().marshall(describeLaunchConfigurationsRequest), new DescribeLaunchConfigurationsResultStaxUnmarshaller());
    }

    public DescribeMetricCollectionTypesResult describeMetricCollectionTypes() throws AmazonServiceException, AmazonClientException {
        return describeMetricCollectionTypes(new DescribeMetricCollectionTypesRequest());
    }

    public DescribeMetricCollectionTypesResult describeMetricCollectionTypes(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeMetricCollectionTypesResult) invoke(new DescribeMetricCollectionTypesRequestMarshaller().marshall(describeMetricCollectionTypesRequest), new DescribeMetricCollectionTypesResultStaxUnmarshaller());
    }

    public DescribeNotificationConfigurationsResult describeNotificationConfigurations() throws AmazonServiceException, AmazonClientException {
        return describeNotificationConfigurations(new DescribeNotificationConfigurationsRequest());
    }

    public DescribeNotificationConfigurationsResult describeNotificationConfigurations(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeNotificationConfigurationsResult) invoke(new DescribeNotificationConfigurationsRequestMarshaller().marshall(describeNotificationConfigurationsRequest), new DescribeNotificationConfigurationsResultStaxUnmarshaller());
    }

    public DescribePoliciesResult describePolicies() throws AmazonServiceException, AmazonClientException {
        return describePolicies(new DescribePoliciesRequest());
    }

    public DescribePoliciesResult describePolicies(DescribePoliciesRequest describePoliciesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribePoliciesResult) invoke(new DescribePoliciesRequestMarshaller().marshall(describePoliciesRequest), new DescribePoliciesResultStaxUnmarshaller());
    }

    public DescribeScalingActivitiesResult describeScalingActivities() throws AmazonServiceException, AmazonClientException {
        return describeScalingActivities(new DescribeScalingActivitiesRequest());
    }

    public DescribeScalingActivitiesResult describeScalingActivities(DescribeScalingActivitiesRequest describeScalingActivitiesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeScalingActivitiesResult) invoke(new DescribeScalingActivitiesRequestMarshaller().marshall(describeScalingActivitiesRequest), new DescribeScalingActivitiesResultStaxUnmarshaller());
    }

    public DescribeScalingProcessTypesResult describeScalingProcessTypes() throws AmazonServiceException, AmazonClientException {
        return describeScalingProcessTypes(new DescribeScalingProcessTypesRequest());
    }

    public DescribeScalingProcessTypesResult describeScalingProcessTypes(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeScalingProcessTypesResult) invoke(new DescribeScalingProcessTypesRequestMarshaller().marshall(describeScalingProcessTypesRequest), new DescribeScalingProcessTypesResultStaxUnmarshaller());
    }

    public DescribeScheduledActionsResult describeScheduledActions() throws AmazonServiceException, AmazonClientException {
        return describeScheduledActions(new DescribeScheduledActionsRequest());
    }

    public DescribeScheduledActionsResult describeScheduledActions(DescribeScheduledActionsRequest describeScheduledActionsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeScheduledActionsResult) invoke(new DescribeScheduledActionsRequestMarshaller().marshall(describeScheduledActionsRequest), new DescribeScheduledActionsResultStaxUnmarshaller());
    }

    public DescribeTagsResult describeTags() throws AmazonServiceException, AmazonClientException {
        return describeTags(new DescribeTagsRequest());
    }

    public DescribeTagsResult describeTags(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeTagsResult) invoke(new DescribeTagsRequestMarshaller().marshall(describeTagsRequest), new DescribeTagsResultStaxUnmarshaller());
    }

    public DescribeTerminationPolicyTypesResult describeTerminationPolicyTypes() throws AmazonServiceException, AmazonClientException {
        return describeTerminationPolicyTypes(new DescribeTerminationPolicyTypesRequest());
    }

    public DescribeTerminationPolicyTypesResult describeTerminationPolicyTypes(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeTerminationPolicyTypesResult) invoke(new DescribeTerminationPolicyTypesRequestMarshaller().marshall(describeTerminationPolicyTypesRequest), new DescribeTerminationPolicyTypesResultStaxUnmarshaller());
    }

    public void disableMetricsCollection(DisableMetricsCollectionRequest disableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DisableMetricsCollectionRequestMarshaller().marshall(disableMetricsCollectionRequest), null);
    }

    public void enableMetricsCollection(EnableMetricsCollectionRequest enableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new EnableMetricsCollectionRequestMarshaller().marshall(enableMetricsCollectionRequest), null);
    }

    public void executePolicy(ExecutePolicyRequest executePolicyRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ExecutePolicyRequestMarshaller().marshall(executePolicyRequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public void putNotificationConfiguration(PutNotificationConfigurationRequest putNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new PutNotificationConfigurationRequestMarshaller().marshall(putNotificationConfigurationRequest), null);
    }

    public PutScalingPolicyResult putScalingPolicy(PutScalingPolicyRequest putScalingPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return (PutScalingPolicyResult) invoke(new PutScalingPolicyRequestMarshaller().marshall(putScalingPolicyRequest), new PutScalingPolicyResultStaxUnmarshaller());
    }

    public void putScheduledUpdateGroupAction(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new PutScheduledUpdateGroupActionRequestMarshaller().marshall(putScheduledUpdateGroupActionRequest), null);
    }

    public void resumeProcesses(ResumeProcessesRequest resumeProcessesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ResumeProcessesRequestMarshaller().marshall(resumeProcessesRequest), null);
    }

    public void setDesiredCapacity(SetDesiredCapacityRequest setDesiredCapacityRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetDesiredCapacityRequestMarshaller().marshall(setDesiredCapacityRequest), null);
    }

    public void setEndpoint(String str, String str2, String str3) throws IllegalArgumentException {
        setEndpoint(str);
        this.signer.setServiceName(str2);
        this.signer.setRegionName(str3);
    }

    public void setInstanceHealth(SetInstanceHealthRequest setInstanceHealthRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SetInstanceHealthRequestMarshaller().marshall(setInstanceHealthRequest), null);
    }

    public void suspendProcesses(SuspendProcessesRequest suspendProcessesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new SuspendProcessesRequestMarshaller().marshall(suspendProcessesRequest), null);
    }

    public TerminateInstanceInAutoScalingGroupResult terminateInstanceInAutoScalingGroup(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        return (TerminateInstanceInAutoScalingGroupResult) invoke(new TerminateInstanceInAutoScalingGroupRequestMarshaller().marshall(terminateInstanceInAutoScalingGroupRequest), new TerminateInstanceInAutoScalingGroupResultStaxUnmarshaller());
    }

    public void updateAutoScalingGroup(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new UpdateAutoScalingGroupRequestMarshaller().marshall(updateAutoScalingGroupRequest), null);
    }
}
