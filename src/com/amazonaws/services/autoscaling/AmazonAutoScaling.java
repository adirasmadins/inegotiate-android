package com.amazonaws.services.autoscaling;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
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

public interface AmazonAutoScaling {
    void createAutoScalingGroup(CreateAutoScalingGroupRequest createAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException;

    void createLaunchConfiguration(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void createOrUpdateTags(CreateOrUpdateTagsRequest createOrUpdateTagsRequest) throws AmazonServiceException, AmazonClientException;

    void deleteAutoScalingGroup(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException;

    void deleteLaunchConfiguration(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void deleteNotificationConfiguration(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    void deletePolicy(DeletePolicyRequest deletePolicyRequest) throws AmazonServiceException, AmazonClientException;

    void deleteScheduledAction(DeleteScheduledActionRequest deleteScheduledActionRequest) throws AmazonServiceException, AmazonClientException;

    void deleteTags(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAdjustmentTypesResult describeAdjustmentTypes() throws AmazonServiceException, AmazonClientException;

    DescribeAdjustmentTypesResult describeAdjustmentTypes(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingGroupsResult describeAutoScalingGroups() throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingGroupsResult describeAutoScalingGroups(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingInstancesResult describeAutoScalingInstances() throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingInstancesResult describeAutoScalingInstances(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes() throws AmazonServiceException, AmazonClientException;

    DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeLaunchConfigurationsResult describeLaunchConfigurations() throws AmazonServiceException, AmazonClientException;

    DescribeLaunchConfigurationsResult describeLaunchConfigurations(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeMetricCollectionTypesResult describeMetricCollectionTypes() throws AmazonServiceException, AmazonClientException;

    DescribeMetricCollectionTypesResult describeMetricCollectionTypes(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeNotificationConfigurationsResult describeNotificationConfigurations() throws AmazonServiceException, AmazonClientException;

    DescribeNotificationConfigurationsResult describeNotificationConfigurations(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) throws AmazonServiceException, AmazonClientException;

    DescribePoliciesResult describePolicies() throws AmazonServiceException, AmazonClientException;

    DescribePoliciesResult describePolicies(DescribePoliciesRequest describePoliciesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeScalingActivitiesResult describeScalingActivities() throws AmazonServiceException, AmazonClientException;

    DescribeScalingActivitiesResult describeScalingActivities(DescribeScalingActivitiesRequest describeScalingActivitiesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeScalingProcessTypesResult describeScalingProcessTypes() throws AmazonServiceException, AmazonClientException;

    DescribeScalingProcessTypesResult describeScalingProcessTypes(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeScheduledActionsResult describeScheduledActions() throws AmazonServiceException, AmazonClientException;

    DescribeScheduledActionsResult describeScheduledActions(DescribeScheduledActionsRequest describeScheduledActionsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeTagsResult describeTags() throws AmazonServiceException, AmazonClientException;

    DescribeTagsResult describeTags(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeTerminationPolicyTypesResult describeTerminationPolicyTypes() throws AmazonServiceException, AmazonClientException;

    DescribeTerminationPolicyTypesResult describeTerminationPolicyTypes(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) throws AmazonServiceException, AmazonClientException;

    void disableMetricsCollection(DisableMetricsCollectionRequest disableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException;

    void enableMetricsCollection(EnableMetricsCollectionRequest enableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException;

    void executePolicy(ExecutePolicyRequest executePolicyRequest) throws AmazonServiceException, AmazonClientException;

    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    void putNotificationConfiguration(PutNotificationConfigurationRequest putNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException;

    PutScalingPolicyResult putScalingPolicy(PutScalingPolicyRequest putScalingPolicyRequest) throws AmazonServiceException, AmazonClientException;

    void putScheduledUpdateGroupAction(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) throws AmazonServiceException, AmazonClientException;

    void resumeProcesses(ResumeProcessesRequest resumeProcessesRequest) throws AmazonServiceException, AmazonClientException;

    void setDesiredCapacity(SetDesiredCapacityRequest setDesiredCapacityRequest) throws AmazonServiceException, AmazonClientException;

    void setEndpoint(String str) throws IllegalArgumentException;

    void setInstanceHealth(SetInstanceHealthRequest setInstanceHealthRequest) throws AmazonServiceException, AmazonClientException;

    void shutdown();

    void suspendProcesses(SuspendProcessesRequest suspendProcessesRequest) throws AmazonServiceException, AmazonClientException;

    TerminateInstanceInAutoScalingGroupResult terminateInstanceInAutoScalingGroup(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException;

    void updateAutoScalingGroup(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException;
}
