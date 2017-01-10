package com.amazonaws.services.autoscaling;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonAutoScalingAsyncClient extends AmazonAutoScalingClient implements AmazonAutoScalingAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.10 */
    class AnonymousClass10 implements Callable<DescribePoliciesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribePoliciesRequest val$describePoliciesRequest;

        AnonymousClass10(DescribePoliciesRequest describePoliciesRequest, AsyncHandler asyncHandler) {
            this.val$describePoliciesRequest = describePoliciesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribePoliciesResult call() throws Exception {
            try {
                DescribePoliciesResult describePolicies = AmazonAutoScalingAsyncClient.this.describePolicies(this.val$describePoliciesRequest);
                this.val$asyncHandler.onSuccess(this.val$describePoliciesRequest, describePolicies);
                return describePolicies;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.11 */
    class AnonymousClass11 implements Callable<DescribeScalingProcessTypesResult> {
        final /* synthetic */ DescribeScalingProcessTypesRequest val$describeScalingProcessTypesRequest;

        AnonymousClass11(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) {
            this.val$describeScalingProcessTypesRequest = describeScalingProcessTypesRequest;
        }

        public DescribeScalingProcessTypesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeScalingProcessTypes(this.val$describeScalingProcessTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.12 */
    class AnonymousClass12 implements Callable<DescribeScalingProcessTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeScalingProcessTypesRequest val$describeScalingProcessTypesRequest;

        AnonymousClass12(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeScalingProcessTypesRequest = describeScalingProcessTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeScalingProcessTypesResult call() throws Exception {
            try {
                DescribeScalingProcessTypesResult describeScalingProcessTypes = AmazonAutoScalingAsyncClient.this.describeScalingProcessTypes(this.val$describeScalingProcessTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeScalingProcessTypesRequest, describeScalingProcessTypes);
                return describeScalingProcessTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.13 */
    class AnonymousClass13 implements Callable<Void> {
        final /* synthetic */ CreateAutoScalingGroupRequest val$createAutoScalingGroupRequest;

        AnonymousClass13(CreateAutoScalingGroupRequest createAutoScalingGroupRequest) {
            this.val$createAutoScalingGroupRequest = createAutoScalingGroupRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.createAutoScalingGroup(this.val$createAutoScalingGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.14 */
    class AnonymousClass14 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateAutoScalingGroupRequest val$createAutoScalingGroupRequest;

        AnonymousClass14(CreateAutoScalingGroupRequest createAutoScalingGroupRequest, AsyncHandler asyncHandler) {
            this.val$createAutoScalingGroupRequest = createAutoScalingGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.createAutoScalingGroup(this.val$createAutoScalingGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$createAutoScalingGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.15 */
    class AnonymousClass15 implements Callable<DescribeScalingActivitiesResult> {
        final /* synthetic */ DescribeScalingActivitiesRequest val$describeScalingActivitiesRequest;

        AnonymousClass15(DescribeScalingActivitiesRequest describeScalingActivitiesRequest) {
            this.val$describeScalingActivitiesRequest = describeScalingActivitiesRequest;
        }

        public DescribeScalingActivitiesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeScalingActivities(this.val$describeScalingActivitiesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.16 */
    class AnonymousClass16 implements Callable<DescribeScalingActivitiesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeScalingActivitiesRequest val$describeScalingActivitiesRequest;

        AnonymousClass16(DescribeScalingActivitiesRequest describeScalingActivitiesRequest, AsyncHandler asyncHandler) {
            this.val$describeScalingActivitiesRequest = describeScalingActivitiesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeScalingActivitiesResult call() throws Exception {
            try {
                DescribeScalingActivitiesResult describeScalingActivities = AmazonAutoScalingAsyncClient.this.describeScalingActivities(this.val$describeScalingActivitiesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeScalingActivitiesRequest, describeScalingActivities);
                return describeScalingActivities;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.17 */
    class AnonymousClass17 implements Callable<DescribeNotificationConfigurationsResult> {
        final /* synthetic */ DescribeNotificationConfigurationsRequest val$describeNotificationConfigurationsRequest;

        AnonymousClass17(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) {
            this.val$describeNotificationConfigurationsRequest = describeNotificationConfigurationsRequest;
        }

        public DescribeNotificationConfigurationsResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeNotificationConfigurations(this.val$describeNotificationConfigurationsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.18 */
    class AnonymousClass18 implements Callable<DescribeNotificationConfigurationsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeNotificationConfigurationsRequest val$describeNotificationConfigurationsRequest;

        AnonymousClass18(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest, AsyncHandler asyncHandler) {
            this.val$describeNotificationConfigurationsRequest = describeNotificationConfigurationsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeNotificationConfigurationsResult call() throws Exception {
            try {
                DescribeNotificationConfigurationsResult describeNotificationConfigurations = AmazonAutoScalingAsyncClient.this.describeNotificationConfigurations(this.val$describeNotificationConfigurationsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeNotificationConfigurationsRequest, describeNotificationConfigurations);
                return describeNotificationConfigurations;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.19 */
    class AnonymousClass19 implements Callable<DescribeTerminationPolicyTypesResult> {
        final /* synthetic */ DescribeTerminationPolicyTypesRequest val$describeTerminationPolicyTypesRequest;

        AnonymousClass19(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) {
            this.val$describeTerminationPolicyTypesRequest = describeTerminationPolicyTypesRequest;
        }

        public DescribeTerminationPolicyTypesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeTerminationPolicyTypes(this.val$describeTerminationPolicyTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.1 */
    class C00171 implements Callable<DescribeAutoScalingGroupsResult> {
        final /* synthetic */ DescribeAutoScalingGroupsRequest val$describeAutoScalingGroupsRequest;

        C00171(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) {
            this.val$describeAutoScalingGroupsRequest = describeAutoScalingGroupsRequest;
        }

        public DescribeAutoScalingGroupsResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeAutoScalingGroups(this.val$describeAutoScalingGroupsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.20 */
    class AnonymousClass20 implements Callable<DescribeTerminationPolicyTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeTerminationPolicyTypesRequest val$describeTerminationPolicyTypesRequest;

        AnonymousClass20(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeTerminationPolicyTypesRequest = describeTerminationPolicyTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeTerminationPolicyTypesResult call() throws Exception {
            try {
                DescribeTerminationPolicyTypesResult describeTerminationPolicyTypes = AmazonAutoScalingAsyncClient.this.describeTerminationPolicyTypes(this.val$describeTerminationPolicyTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeTerminationPolicyTypesRequest, describeTerminationPolicyTypes);
                return describeTerminationPolicyTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.21 */
    class AnonymousClass21 implements Callable<DescribeTagsResult> {
        final /* synthetic */ DescribeTagsRequest val$describeTagsRequest;

        AnonymousClass21(DescribeTagsRequest describeTagsRequest) {
            this.val$describeTagsRequest = describeTagsRequest;
        }

        public DescribeTagsResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeTags(this.val$describeTagsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.22 */
    class AnonymousClass22 implements Callable<DescribeTagsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeTagsRequest val$describeTagsRequest;

        AnonymousClass22(DescribeTagsRequest describeTagsRequest, AsyncHandler asyncHandler) {
            this.val$describeTagsRequest = describeTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeTagsResult call() throws Exception {
            try {
                DescribeTagsResult describeTags = AmazonAutoScalingAsyncClient.this.describeTags(this.val$describeTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeTagsRequest, describeTags);
                return describeTags;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.23 */
    class AnonymousClass23 implements Callable<Void> {
        final /* synthetic */ ExecutePolicyRequest val$executePolicyRequest;

        AnonymousClass23(ExecutePolicyRequest executePolicyRequest) {
            this.val$executePolicyRequest = executePolicyRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.executePolicy(this.val$executePolicyRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.24 */
    class AnonymousClass24 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ExecutePolicyRequest val$executePolicyRequest;

        AnonymousClass24(ExecutePolicyRequest executePolicyRequest, AsyncHandler asyncHandler) {
            this.val$executePolicyRequest = executePolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.executePolicy(this.val$executePolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$executePolicyRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.25 */
    class AnonymousClass25 implements Callable<Void> {
        final /* synthetic */ DeleteTagsRequest val$deleteTagsRequest;

        AnonymousClass25(DeleteTagsRequest deleteTagsRequest) {
            this.val$deleteTagsRequest = deleteTagsRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deleteTags(this.val$deleteTagsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.26 */
    class AnonymousClass26 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteTagsRequest val$deleteTagsRequest;

        AnonymousClass26(DeleteTagsRequest deleteTagsRequest, AsyncHandler asyncHandler) {
            this.val$deleteTagsRequest = deleteTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deleteTags(this.val$deleteTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteTagsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.27 */
    class AnonymousClass27 implements Callable<PutScalingPolicyResult> {
        final /* synthetic */ PutScalingPolicyRequest val$putScalingPolicyRequest;

        AnonymousClass27(PutScalingPolicyRequest putScalingPolicyRequest) {
            this.val$putScalingPolicyRequest = putScalingPolicyRequest;
        }

        public PutScalingPolicyResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.putScalingPolicy(this.val$putScalingPolicyRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.28 */
    class AnonymousClass28 implements Callable<PutScalingPolicyResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutScalingPolicyRequest val$putScalingPolicyRequest;

        AnonymousClass28(PutScalingPolicyRequest putScalingPolicyRequest, AsyncHandler asyncHandler) {
            this.val$putScalingPolicyRequest = putScalingPolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public PutScalingPolicyResult call() throws Exception {
            try {
                PutScalingPolicyResult putScalingPolicy = AmazonAutoScalingAsyncClient.this.putScalingPolicy(this.val$putScalingPolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$putScalingPolicyRequest, putScalingPolicy);
                return putScalingPolicy;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.29 */
    class AnonymousClass29 implements Callable<Void> {
        final /* synthetic */ PutNotificationConfigurationRequest val$putNotificationConfigurationRequest;

        AnonymousClass29(PutNotificationConfigurationRequest putNotificationConfigurationRequest) {
            this.val$putNotificationConfigurationRequest = putNotificationConfigurationRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.putNotificationConfiguration(this.val$putNotificationConfigurationRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.2 */
    class C00182 implements Callable<DescribeAutoScalingGroupsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAutoScalingGroupsRequest val$describeAutoScalingGroupsRequest;

        C00182(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest, AsyncHandler asyncHandler) {
            this.val$describeAutoScalingGroupsRequest = describeAutoScalingGroupsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAutoScalingGroupsResult call() throws Exception {
            try {
                DescribeAutoScalingGroupsResult describeAutoScalingGroups = AmazonAutoScalingAsyncClient.this.describeAutoScalingGroups(this.val$describeAutoScalingGroupsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAutoScalingGroupsRequest, describeAutoScalingGroups);
                return describeAutoScalingGroups;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.30 */
    class AnonymousClass30 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutNotificationConfigurationRequest val$putNotificationConfigurationRequest;

        AnonymousClass30(PutNotificationConfigurationRequest putNotificationConfigurationRequest, AsyncHandler asyncHandler) {
            this.val$putNotificationConfigurationRequest = putNotificationConfigurationRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.putNotificationConfiguration(this.val$putNotificationConfigurationRequest);
                this.val$asyncHandler.onSuccess(this.val$putNotificationConfigurationRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.31 */
    class AnonymousClass31 implements Callable<Void> {
        final /* synthetic */ DeletePolicyRequest val$deletePolicyRequest;

        AnonymousClass31(DeletePolicyRequest deletePolicyRequest) {
            this.val$deletePolicyRequest = deletePolicyRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deletePolicy(this.val$deletePolicyRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.32 */
    class AnonymousClass32 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeletePolicyRequest val$deletePolicyRequest;

        AnonymousClass32(DeletePolicyRequest deletePolicyRequest, AsyncHandler asyncHandler) {
            this.val$deletePolicyRequest = deletePolicyRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deletePolicy(this.val$deletePolicyRequest);
                this.val$asyncHandler.onSuccess(this.val$deletePolicyRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.33 */
    class AnonymousClass33 implements Callable<Void> {
        final /* synthetic */ DeleteNotificationConfigurationRequest val$deleteNotificationConfigurationRequest;

        AnonymousClass33(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) {
            this.val$deleteNotificationConfigurationRequest = deleteNotificationConfigurationRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deleteNotificationConfiguration(this.val$deleteNotificationConfigurationRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.34 */
    class AnonymousClass34 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteNotificationConfigurationRequest val$deleteNotificationConfigurationRequest;

        AnonymousClass34(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest, AsyncHandler asyncHandler) {
            this.val$deleteNotificationConfigurationRequest = deleteNotificationConfigurationRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deleteNotificationConfiguration(this.val$deleteNotificationConfigurationRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteNotificationConfigurationRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.35 */
    class AnonymousClass35 implements Callable<Void> {
        final /* synthetic */ DeleteScheduledActionRequest val$deleteScheduledActionRequest;

        AnonymousClass35(DeleteScheduledActionRequest deleteScheduledActionRequest) {
            this.val$deleteScheduledActionRequest = deleteScheduledActionRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deleteScheduledAction(this.val$deleteScheduledActionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.36 */
    class AnonymousClass36 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteScheduledActionRequest val$deleteScheduledActionRequest;

        AnonymousClass36(DeleteScheduledActionRequest deleteScheduledActionRequest, AsyncHandler asyncHandler) {
            this.val$deleteScheduledActionRequest = deleteScheduledActionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deleteScheduledAction(this.val$deleteScheduledActionRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteScheduledActionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.37 */
    class AnonymousClass37 implements Callable<Void> {
        final /* synthetic */ SetInstanceHealthRequest val$setInstanceHealthRequest;

        AnonymousClass37(SetInstanceHealthRequest setInstanceHealthRequest) {
            this.val$setInstanceHealthRequest = setInstanceHealthRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.setInstanceHealth(this.val$setInstanceHealthRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.38 */
    class AnonymousClass38 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetInstanceHealthRequest val$setInstanceHealthRequest;

        AnonymousClass38(SetInstanceHealthRequest setInstanceHealthRequest, AsyncHandler asyncHandler) {
            this.val$setInstanceHealthRequest = setInstanceHealthRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.setInstanceHealth(this.val$setInstanceHealthRequest);
                this.val$asyncHandler.onSuccess(this.val$setInstanceHealthRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.39 */
    class AnonymousClass39 implements Callable<DescribeAutoScalingNotificationTypesResult> {
        final /* synthetic */ DescribeAutoScalingNotificationTypesRequest val$describeAutoScalingNotificationTypesRequest;

        AnonymousClass39(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) {
            this.val$describeAutoScalingNotificationTypesRequest = describeAutoScalingNotificationTypesRequest;
        }

        public DescribeAutoScalingNotificationTypesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeAutoScalingNotificationTypes(this.val$describeAutoScalingNotificationTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.3 */
    class C00193 implements Callable<Void> {
        final /* synthetic */ EnableMetricsCollectionRequest val$enableMetricsCollectionRequest;

        C00193(EnableMetricsCollectionRequest enableMetricsCollectionRequest) {
            this.val$enableMetricsCollectionRequest = enableMetricsCollectionRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.enableMetricsCollection(this.val$enableMetricsCollectionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.40 */
    class AnonymousClass40 implements Callable<DescribeAutoScalingNotificationTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAutoScalingNotificationTypesRequest val$describeAutoScalingNotificationTypesRequest;

        AnonymousClass40(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeAutoScalingNotificationTypesRequest = describeAutoScalingNotificationTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAutoScalingNotificationTypesResult call() throws Exception {
            try {
                DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypes = AmazonAutoScalingAsyncClient.this.describeAutoScalingNotificationTypes(this.val$describeAutoScalingNotificationTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAutoScalingNotificationTypesRequest, describeAutoScalingNotificationTypes);
                return describeAutoScalingNotificationTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.41 */
    class AnonymousClass41 implements Callable<Void> {
        final /* synthetic */ CreateOrUpdateTagsRequest val$createOrUpdateTagsRequest;

        AnonymousClass41(CreateOrUpdateTagsRequest createOrUpdateTagsRequest) {
            this.val$createOrUpdateTagsRequest = createOrUpdateTagsRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.createOrUpdateTags(this.val$createOrUpdateTagsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.42 */
    class AnonymousClass42 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateOrUpdateTagsRequest val$createOrUpdateTagsRequest;

        AnonymousClass42(CreateOrUpdateTagsRequest createOrUpdateTagsRequest, AsyncHandler asyncHandler) {
            this.val$createOrUpdateTagsRequest = createOrUpdateTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.createOrUpdateTags(this.val$createOrUpdateTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$createOrUpdateTagsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.43 */
    class AnonymousClass43 implements Callable<Void> {
        final /* synthetic */ SuspendProcessesRequest val$suspendProcessesRequest;

        AnonymousClass43(SuspendProcessesRequest suspendProcessesRequest) {
            this.val$suspendProcessesRequest = suspendProcessesRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.suspendProcesses(this.val$suspendProcessesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.44 */
    class AnonymousClass44 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SuspendProcessesRequest val$suspendProcessesRequest;

        AnonymousClass44(SuspendProcessesRequest suspendProcessesRequest, AsyncHandler asyncHandler) {
            this.val$suspendProcessesRequest = suspendProcessesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.suspendProcesses(this.val$suspendProcessesRequest);
                this.val$asyncHandler.onSuccess(this.val$suspendProcessesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.45 */
    class AnonymousClass45 implements Callable<DescribeAutoScalingInstancesResult> {
        final /* synthetic */ DescribeAutoScalingInstancesRequest val$describeAutoScalingInstancesRequest;

        AnonymousClass45(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) {
            this.val$describeAutoScalingInstancesRequest = describeAutoScalingInstancesRequest;
        }

        public DescribeAutoScalingInstancesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeAutoScalingInstances(this.val$describeAutoScalingInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.46 */
    class AnonymousClass46 implements Callable<DescribeAutoScalingInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAutoScalingInstancesRequest val$describeAutoScalingInstancesRequest;

        AnonymousClass46(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest, AsyncHandler asyncHandler) {
            this.val$describeAutoScalingInstancesRequest = describeAutoScalingInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAutoScalingInstancesResult call() throws Exception {
            try {
                DescribeAutoScalingInstancesResult describeAutoScalingInstances = AmazonAutoScalingAsyncClient.this.describeAutoScalingInstances(this.val$describeAutoScalingInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAutoScalingInstancesRequest, describeAutoScalingInstances);
                return describeAutoScalingInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.47 */
    class AnonymousClass47 implements Callable<Void> {
        final /* synthetic */ CreateLaunchConfigurationRequest val$createLaunchConfigurationRequest;

        AnonymousClass47(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) {
            this.val$createLaunchConfigurationRequest = createLaunchConfigurationRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.createLaunchConfiguration(this.val$createLaunchConfigurationRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.48 */
    class AnonymousClass48 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateLaunchConfigurationRequest val$createLaunchConfigurationRequest;

        AnonymousClass48(CreateLaunchConfigurationRequest createLaunchConfigurationRequest, AsyncHandler asyncHandler) {
            this.val$createLaunchConfigurationRequest = createLaunchConfigurationRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.createLaunchConfiguration(this.val$createLaunchConfigurationRequest);
                this.val$asyncHandler.onSuccess(this.val$createLaunchConfigurationRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.49 */
    class AnonymousClass49 implements Callable<Void> {
        final /* synthetic */ DeleteAutoScalingGroupRequest val$deleteAutoScalingGroupRequest;

        AnonymousClass49(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) {
            this.val$deleteAutoScalingGroupRequest = deleteAutoScalingGroupRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deleteAutoScalingGroup(this.val$deleteAutoScalingGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.4 */
    class C00204 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ EnableMetricsCollectionRequest val$enableMetricsCollectionRequest;

        C00204(EnableMetricsCollectionRequest enableMetricsCollectionRequest, AsyncHandler asyncHandler) {
            this.val$enableMetricsCollectionRequest = enableMetricsCollectionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.enableMetricsCollection(this.val$enableMetricsCollectionRequest);
                this.val$asyncHandler.onSuccess(this.val$enableMetricsCollectionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.50 */
    class AnonymousClass50 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteAutoScalingGroupRequest val$deleteAutoScalingGroupRequest;

        AnonymousClass50(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest, AsyncHandler asyncHandler) {
            this.val$deleteAutoScalingGroupRequest = deleteAutoScalingGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deleteAutoScalingGroup(this.val$deleteAutoScalingGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteAutoScalingGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.51 */
    class AnonymousClass51 implements Callable<Void> {
        final /* synthetic */ DisableMetricsCollectionRequest val$disableMetricsCollectionRequest;

        AnonymousClass51(DisableMetricsCollectionRequest disableMetricsCollectionRequest) {
            this.val$disableMetricsCollectionRequest = disableMetricsCollectionRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.disableMetricsCollection(this.val$disableMetricsCollectionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.52 */
    class AnonymousClass52 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DisableMetricsCollectionRequest val$disableMetricsCollectionRequest;

        AnonymousClass52(DisableMetricsCollectionRequest disableMetricsCollectionRequest, AsyncHandler asyncHandler) {
            this.val$disableMetricsCollectionRequest = disableMetricsCollectionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.disableMetricsCollection(this.val$disableMetricsCollectionRequest);
                this.val$asyncHandler.onSuccess(this.val$disableMetricsCollectionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.53 */
    class AnonymousClass53 implements Callable<Void> {
        final /* synthetic */ UpdateAutoScalingGroupRequest val$updateAutoScalingGroupRequest;

        AnonymousClass53(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) {
            this.val$updateAutoScalingGroupRequest = updateAutoScalingGroupRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.updateAutoScalingGroup(this.val$updateAutoScalingGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.54 */
    class AnonymousClass54 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ UpdateAutoScalingGroupRequest val$updateAutoScalingGroupRequest;

        AnonymousClass54(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest, AsyncHandler asyncHandler) {
            this.val$updateAutoScalingGroupRequest = updateAutoScalingGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.updateAutoScalingGroup(this.val$updateAutoScalingGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$updateAutoScalingGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.55 */
    class AnonymousClass55 implements Callable<DescribeLaunchConfigurationsResult> {
        final /* synthetic */ DescribeLaunchConfigurationsRequest val$describeLaunchConfigurationsRequest;

        AnonymousClass55(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) {
            this.val$describeLaunchConfigurationsRequest = describeLaunchConfigurationsRequest;
        }

        public DescribeLaunchConfigurationsResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeLaunchConfigurations(this.val$describeLaunchConfigurationsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.56 */
    class AnonymousClass56 implements Callable<DescribeLaunchConfigurationsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeLaunchConfigurationsRequest val$describeLaunchConfigurationsRequest;

        AnonymousClass56(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest, AsyncHandler asyncHandler) {
            this.val$describeLaunchConfigurationsRequest = describeLaunchConfigurationsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeLaunchConfigurationsResult call() throws Exception {
            try {
                DescribeLaunchConfigurationsResult describeLaunchConfigurations = AmazonAutoScalingAsyncClient.this.describeLaunchConfigurations(this.val$describeLaunchConfigurationsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeLaunchConfigurationsRequest, describeLaunchConfigurations);
                return describeLaunchConfigurations;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.57 */
    class AnonymousClass57 implements Callable<DescribeAdjustmentTypesResult> {
        final /* synthetic */ DescribeAdjustmentTypesRequest val$describeAdjustmentTypesRequest;

        AnonymousClass57(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) {
            this.val$describeAdjustmentTypesRequest = describeAdjustmentTypesRequest;
        }

        public DescribeAdjustmentTypesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeAdjustmentTypes(this.val$describeAdjustmentTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.58 */
    class AnonymousClass58 implements Callable<DescribeAdjustmentTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAdjustmentTypesRequest val$describeAdjustmentTypesRequest;

        AnonymousClass58(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeAdjustmentTypesRequest = describeAdjustmentTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAdjustmentTypesResult call() throws Exception {
            try {
                DescribeAdjustmentTypesResult describeAdjustmentTypes = AmazonAutoScalingAsyncClient.this.describeAdjustmentTypes(this.val$describeAdjustmentTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAdjustmentTypesRequest, describeAdjustmentTypes);
                return describeAdjustmentTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.59 */
    class AnonymousClass59 implements Callable<DescribeScheduledActionsResult> {
        final /* synthetic */ DescribeScheduledActionsRequest val$describeScheduledActionsRequest;

        AnonymousClass59(DescribeScheduledActionsRequest describeScheduledActionsRequest) {
            this.val$describeScheduledActionsRequest = describeScheduledActionsRequest;
        }

        public DescribeScheduledActionsResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeScheduledActions(this.val$describeScheduledActionsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.5 */
    class C00215 implements Callable<Void> {
        final /* synthetic */ ResumeProcessesRequest val$resumeProcessesRequest;

        C00215(ResumeProcessesRequest resumeProcessesRequest) {
            this.val$resumeProcessesRequest = resumeProcessesRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.resumeProcesses(this.val$resumeProcessesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.60 */
    class AnonymousClass60 implements Callable<DescribeScheduledActionsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeScheduledActionsRequest val$describeScheduledActionsRequest;

        AnonymousClass60(DescribeScheduledActionsRequest describeScheduledActionsRequest, AsyncHandler asyncHandler) {
            this.val$describeScheduledActionsRequest = describeScheduledActionsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeScheduledActionsResult call() throws Exception {
            try {
                DescribeScheduledActionsResult describeScheduledActions = AmazonAutoScalingAsyncClient.this.describeScheduledActions(this.val$describeScheduledActionsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeScheduledActionsRequest, describeScheduledActions);
                return describeScheduledActions;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.61 */
    class AnonymousClass61 implements Callable<Void> {
        final /* synthetic */ PutScheduledUpdateGroupActionRequest val$putScheduledUpdateGroupActionRequest;

        AnonymousClass61(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) {
            this.val$putScheduledUpdateGroupActionRequest = putScheduledUpdateGroupActionRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.putScheduledUpdateGroupAction(this.val$putScheduledUpdateGroupActionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.62 */
    class AnonymousClass62 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutScheduledUpdateGroupActionRequest val$putScheduledUpdateGroupActionRequest;

        AnonymousClass62(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest, AsyncHandler asyncHandler) {
            this.val$putScheduledUpdateGroupActionRequest = putScheduledUpdateGroupActionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.putScheduledUpdateGroupAction(this.val$putScheduledUpdateGroupActionRequest);
                this.val$asyncHandler.onSuccess(this.val$putScheduledUpdateGroupActionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.63 */
    class AnonymousClass63 implements Callable<DescribeMetricCollectionTypesResult> {
        final /* synthetic */ DescribeMetricCollectionTypesRequest val$describeMetricCollectionTypesRequest;

        AnonymousClass63(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) {
            this.val$describeMetricCollectionTypesRequest = describeMetricCollectionTypesRequest;
        }

        public DescribeMetricCollectionTypesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describeMetricCollectionTypes(this.val$describeMetricCollectionTypesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.64 */
    class AnonymousClass64 implements Callable<DescribeMetricCollectionTypesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeMetricCollectionTypesRequest val$describeMetricCollectionTypesRequest;

        AnonymousClass64(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest, AsyncHandler asyncHandler) {
            this.val$describeMetricCollectionTypesRequest = describeMetricCollectionTypesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeMetricCollectionTypesResult call() throws Exception {
            try {
                DescribeMetricCollectionTypesResult describeMetricCollectionTypes = AmazonAutoScalingAsyncClient.this.describeMetricCollectionTypes(this.val$describeMetricCollectionTypesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeMetricCollectionTypesRequest, describeMetricCollectionTypes);
                return describeMetricCollectionTypes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.65 */
    class AnonymousClass65 implements Callable<Void> {
        final /* synthetic */ SetDesiredCapacityRequest val$setDesiredCapacityRequest;

        AnonymousClass65(SetDesiredCapacityRequest setDesiredCapacityRequest) {
            this.val$setDesiredCapacityRequest = setDesiredCapacityRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.setDesiredCapacity(this.val$setDesiredCapacityRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.66 */
    class AnonymousClass66 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetDesiredCapacityRequest val$setDesiredCapacityRequest;

        AnonymousClass66(SetDesiredCapacityRequest setDesiredCapacityRequest, AsyncHandler asyncHandler) {
            this.val$setDesiredCapacityRequest = setDesiredCapacityRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.setDesiredCapacity(this.val$setDesiredCapacityRequest);
                this.val$asyncHandler.onSuccess(this.val$setDesiredCapacityRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.67 */
    class AnonymousClass67 implements Callable<TerminateInstanceInAutoScalingGroupResult> {
        final /* synthetic */ TerminateInstanceInAutoScalingGroupRequest val$terminateInstanceInAutoScalingGroupRequest;

        AnonymousClass67(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) {
            this.val$terminateInstanceInAutoScalingGroupRequest = terminateInstanceInAutoScalingGroupRequest;
        }

        public TerminateInstanceInAutoScalingGroupResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.terminateInstanceInAutoScalingGroup(this.val$terminateInstanceInAutoScalingGroupRequest);
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.68 */
    class AnonymousClass68 implements Callable<TerminateInstanceInAutoScalingGroupResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ TerminateInstanceInAutoScalingGroupRequest val$terminateInstanceInAutoScalingGroupRequest;

        AnonymousClass68(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest, AsyncHandler asyncHandler) {
            this.val$terminateInstanceInAutoScalingGroupRequest = terminateInstanceInAutoScalingGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public TerminateInstanceInAutoScalingGroupResult call() throws Exception {
            try {
                TerminateInstanceInAutoScalingGroupResult terminateInstanceInAutoScalingGroup = AmazonAutoScalingAsyncClient.this.terminateInstanceInAutoScalingGroup(this.val$terminateInstanceInAutoScalingGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$terminateInstanceInAutoScalingGroupRequest, terminateInstanceInAutoScalingGroup);
                return terminateInstanceInAutoScalingGroup;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.6 */
    class C00226 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ResumeProcessesRequest val$resumeProcessesRequest;

        C00226(ResumeProcessesRequest resumeProcessesRequest, AsyncHandler asyncHandler) {
            this.val$resumeProcessesRequest = resumeProcessesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.resumeProcesses(this.val$resumeProcessesRequest);
                this.val$asyncHandler.onSuccess(this.val$resumeProcessesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.7 */
    class C00237 implements Callable<Void> {
        final /* synthetic */ DeleteLaunchConfigurationRequest val$deleteLaunchConfigurationRequest;

        C00237(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) {
            this.val$deleteLaunchConfigurationRequest = deleteLaunchConfigurationRequest;
        }

        public Void call() throws Exception {
            AmazonAutoScalingAsyncClient.this.deleteLaunchConfiguration(this.val$deleteLaunchConfigurationRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.8 */
    class C00248 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteLaunchConfigurationRequest val$deleteLaunchConfigurationRequest;

        C00248(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest, AsyncHandler asyncHandler) {
            this.val$deleteLaunchConfigurationRequest = deleteLaunchConfigurationRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonAutoScalingAsyncClient.this.deleteLaunchConfiguration(this.val$deleteLaunchConfigurationRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteLaunchConfigurationRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.autoscaling.AmazonAutoScalingAsyncClient.9 */
    class C00259 implements Callable<DescribePoliciesResult> {
        final /* synthetic */ DescribePoliciesRequest val$describePoliciesRequest;

        C00259(DescribePoliciesRequest describePoliciesRequest) {
            this.val$describePoliciesRequest = describePoliciesRequest;
        }

        public DescribePoliciesResult call() throws Exception {
            return AmazonAutoScalingAsyncClient.this.describePolicies(this.val$describePoliciesRequest);
        }
    }

    public AmazonAutoScalingAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonAutoScalingAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonAutoScalingAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonAutoScalingAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonAutoScalingAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonAutoScalingAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> createAutoScalingGroupAsync(CreateAutoScalingGroupRequest createAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(createAutoScalingGroupRequest));
    }

    public Future<Void> createAutoScalingGroupAsync(CreateAutoScalingGroupRequest createAutoScalingGroupRequest, AsyncHandler<CreateAutoScalingGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(createAutoScalingGroupRequest, asyncHandler));
    }

    public Future<Void> createLaunchConfigurationAsync(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass47(createLaunchConfigurationRequest));
    }

    public Future<Void> createLaunchConfigurationAsync(CreateLaunchConfigurationRequest createLaunchConfigurationRequest, AsyncHandler<CreateLaunchConfigurationRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass48(createLaunchConfigurationRequest, asyncHandler));
    }

    public Future<Void> createOrUpdateTagsAsync(CreateOrUpdateTagsRequest createOrUpdateTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass41(createOrUpdateTagsRequest));
    }

    public Future<Void> createOrUpdateTagsAsync(CreateOrUpdateTagsRequest createOrUpdateTagsRequest, AsyncHandler<CreateOrUpdateTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass42(createOrUpdateTagsRequest, asyncHandler));
    }

    public Future<Void> deleteAutoScalingGroupAsync(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass49(deleteAutoScalingGroupRequest));
    }

    public Future<Void> deleteAutoScalingGroupAsync(DeleteAutoScalingGroupRequest deleteAutoScalingGroupRequest, AsyncHandler<DeleteAutoScalingGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass50(deleteAutoScalingGroupRequest, asyncHandler));
    }

    public Future<Void> deleteLaunchConfigurationAsync(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00237(deleteLaunchConfigurationRequest));
    }

    public Future<Void> deleteLaunchConfigurationAsync(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest, AsyncHandler<DeleteLaunchConfigurationRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00248(deleteLaunchConfigurationRequest, asyncHandler));
    }

    public Future<Void> deleteNotificationConfigurationAsync(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass33(deleteNotificationConfigurationRequest));
    }

    public Future<Void> deleteNotificationConfigurationAsync(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest, AsyncHandler<DeleteNotificationConfigurationRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass34(deleteNotificationConfigurationRequest, asyncHandler));
    }

    public Future<Void> deletePolicyAsync(DeletePolicyRequest deletePolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass31(deletePolicyRequest));
    }

    public Future<Void> deletePolicyAsync(DeletePolicyRequest deletePolicyRequest, AsyncHandler<DeletePolicyRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass32(deletePolicyRequest, asyncHandler));
    }

    public Future<Void> deleteScheduledActionAsync(DeleteScheduledActionRequest deleteScheduledActionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass35(deleteScheduledActionRequest));
    }

    public Future<Void> deleteScheduledActionAsync(DeleteScheduledActionRequest deleteScheduledActionRequest, AsyncHandler<DeleteScheduledActionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass36(deleteScheduledActionRequest, asyncHandler));
    }

    public Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(deleteTagsRequest));
    }

    public Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest, AsyncHandler<DeleteTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(deleteTagsRequest, asyncHandler));
    }

    public Future<DescribeAdjustmentTypesResult> describeAdjustmentTypesAsync(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass57(describeAdjustmentTypesRequest));
    }

    public Future<DescribeAdjustmentTypesResult> describeAdjustmentTypesAsync(DescribeAdjustmentTypesRequest describeAdjustmentTypesRequest, AsyncHandler<DescribeAdjustmentTypesRequest, DescribeAdjustmentTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass58(describeAdjustmentTypesRequest, asyncHandler));
    }

    public Future<DescribeAutoScalingGroupsResult> describeAutoScalingGroupsAsync(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00171(describeAutoScalingGroupsRequest));
    }

    public Future<DescribeAutoScalingGroupsResult> describeAutoScalingGroupsAsync(DescribeAutoScalingGroupsRequest describeAutoScalingGroupsRequest, AsyncHandler<DescribeAutoScalingGroupsRequest, DescribeAutoScalingGroupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00182(describeAutoScalingGroupsRequest, asyncHandler));
    }

    public Future<DescribeAutoScalingInstancesResult> describeAutoScalingInstancesAsync(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass45(describeAutoScalingInstancesRequest));
    }

    public Future<DescribeAutoScalingInstancesResult> describeAutoScalingInstancesAsync(DescribeAutoScalingInstancesRequest describeAutoScalingInstancesRequest, AsyncHandler<DescribeAutoScalingInstancesRequest, DescribeAutoScalingInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass46(describeAutoScalingInstancesRequest, asyncHandler));
    }

    public Future<DescribeAutoScalingNotificationTypesResult> describeAutoScalingNotificationTypesAsync(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass39(describeAutoScalingNotificationTypesRequest));
    }

    public Future<DescribeAutoScalingNotificationTypesResult> describeAutoScalingNotificationTypesAsync(DescribeAutoScalingNotificationTypesRequest describeAutoScalingNotificationTypesRequest, AsyncHandler<DescribeAutoScalingNotificationTypesRequest, DescribeAutoScalingNotificationTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass40(describeAutoScalingNotificationTypesRequest, asyncHandler));
    }

    public Future<DescribeLaunchConfigurationsResult> describeLaunchConfigurationsAsync(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass55(describeLaunchConfigurationsRequest));
    }

    public Future<DescribeLaunchConfigurationsResult> describeLaunchConfigurationsAsync(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest, AsyncHandler<DescribeLaunchConfigurationsRequest, DescribeLaunchConfigurationsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass56(describeLaunchConfigurationsRequest, asyncHandler));
    }

    public Future<DescribeMetricCollectionTypesResult> describeMetricCollectionTypesAsync(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass63(describeMetricCollectionTypesRequest));
    }

    public Future<DescribeMetricCollectionTypesResult> describeMetricCollectionTypesAsync(DescribeMetricCollectionTypesRequest describeMetricCollectionTypesRequest, AsyncHandler<DescribeMetricCollectionTypesRequest, DescribeMetricCollectionTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass64(describeMetricCollectionTypesRequest, asyncHandler));
    }

    public Future<DescribeNotificationConfigurationsResult> describeNotificationConfigurationsAsync(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(describeNotificationConfigurationsRequest));
    }

    public Future<DescribeNotificationConfigurationsResult> describeNotificationConfigurationsAsync(DescribeNotificationConfigurationsRequest describeNotificationConfigurationsRequest, AsyncHandler<DescribeNotificationConfigurationsRequest, DescribeNotificationConfigurationsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(describeNotificationConfigurationsRequest, asyncHandler));
    }

    public Future<DescribePoliciesResult> describePoliciesAsync(DescribePoliciesRequest describePoliciesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00259(describePoliciesRequest));
    }

    public Future<DescribePoliciesResult> describePoliciesAsync(DescribePoliciesRequest describePoliciesRequest, AsyncHandler<DescribePoliciesRequest, DescribePoliciesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(describePoliciesRequest, asyncHandler));
    }

    public Future<DescribeScalingActivitiesResult> describeScalingActivitiesAsync(DescribeScalingActivitiesRequest describeScalingActivitiesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(describeScalingActivitiesRequest));
    }

    public Future<DescribeScalingActivitiesResult> describeScalingActivitiesAsync(DescribeScalingActivitiesRequest describeScalingActivitiesRequest, AsyncHandler<DescribeScalingActivitiesRequest, DescribeScalingActivitiesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(describeScalingActivitiesRequest, asyncHandler));
    }

    public Future<DescribeScalingProcessTypesResult> describeScalingProcessTypesAsync(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(describeScalingProcessTypesRequest));
    }

    public Future<DescribeScalingProcessTypesResult> describeScalingProcessTypesAsync(DescribeScalingProcessTypesRequest describeScalingProcessTypesRequest, AsyncHandler<DescribeScalingProcessTypesRequest, DescribeScalingProcessTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(describeScalingProcessTypesRequest, asyncHandler));
    }

    public Future<DescribeScheduledActionsResult> describeScheduledActionsAsync(DescribeScheduledActionsRequest describeScheduledActionsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass59(describeScheduledActionsRequest));
    }

    public Future<DescribeScheduledActionsResult> describeScheduledActionsAsync(DescribeScheduledActionsRequest describeScheduledActionsRequest, AsyncHandler<DescribeScheduledActionsRequest, DescribeScheduledActionsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass60(describeScheduledActionsRequest, asyncHandler));
    }

    public Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(describeTagsRequest));
    }

    public Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest, AsyncHandler<DescribeTagsRequest, DescribeTagsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(describeTagsRequest, asyncHandler));
    }

    public Future<DescribeTerminationPolicyTypesResult> describeTerminationPolicyTypesAsync(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(describeTerminationPolicyTypesRequest));
    }

    public Future<DescribeTerminationPolicyTypesResult> describeTerminationPolicyTypesAsync(DescribeTerminationPolicyTypesRequest describeTerminationPolicyTypesRequest, AsyncHandler<DescribeTerminationPolicyTypesRequest, DescribeTerminationPolicyTypesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(describeTerminationPolicyTypesRequest, asyncHandler));
    }

    public Future<Void> disableMetricsCollectionAsync(DisableMetricsCollectionRequest disableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass51(disableMetricsCollectionRequest));
    }

    public Future<Void> disableMetricsCollectionAsync(DisableMetricsCollectionRequest disableMetricsCollectionRequest, AsyncHandler<DisableMetricsCollectionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass52(disableMetricsCollectionRequest, asyncHandler));
    }

    public Future<Void> enableMetricsCollectionAsync(EnableMetricsCollectionRequest enableMetricsCollectionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00193(enableMetricsCollectionRequest));
    }

    public Future<Void> enableMetricsCollectionAsync(EnableMetricsCollectionRequest enableMetricsCollectionRequest, AsyncHandler<EnableMetricsCollectionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00204(enableMetricsCollectionRequest, asyncHandler));
    }

    public Future<Void> executePolicyAsync(ExecutePolicyRequest executePolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(executePolicyRequest));
    }

    public Future<Void> executePolicyAsync(ExecutePolicyRequest executePolicyRequest, AsyncHandler<ExecutePolicyRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(executePolicyRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<Void> putNotificationConfigurationAsync(PutNotificationConfigurationRequest putNotificationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(putNotificationConfigurationRequest));
    }

    public Future<Void> putNotificationConfigurationAsync(PutNotificationConfigurationRequest putNotificationConfigurationRequest, AsyncHandler<PutNotificationConfigurationRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(putNotificationConfigurationRequest, asyncHandler));
    }

    public Future<PutScalingPolicyResult> putScalingPolicyAsync(PutScalingPolicyRequest putScalingPolicyRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(putScalingPolicyRequest));
    }

    public Future<PutScalingPolicyResult> putScalingPolicyAsync(PutScalingPolicyRequest putScalingPolicyRequest, AsyncHandler<PutScalingPolicyRequest, PutScalingPolicyResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(putScalingPolicyRequest, asyncHandler));
    }

    public Future<Void> putScheduledUpdateGroupActionAsync(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass61(putScheduledUpdateGroupActionRequest));
    }

    public Future<Void> putScheduledUpdateGroupActionAsync(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest, AsyncHandler<PutScheduledUpdateGroupActionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass62(putScheduledUpdateGroupActionRequest, asyncHandler));
    }

    public Future<Void> resumeProcessesAsync(ResumeProcessesRequest resumeProcessesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00215(resumeProcessesRequest));
    }

    public Future<Void> resumeProcessesAsync(ResumeProcessesRequest resumeProcessesRequest, AsyncHandler<ResumeProcessesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00226(resumeProcessesRequest, asyncHandler));
    }

    public Future<Void> setDesiredCapacityAsync(SetDesiredCapacityRequest setDesiredCapacityRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass65(setDesiredCapacityRequest));
    }

    public Future<Void> setDesiredCapacityAsync(SetDesiredCapacityRequest setDesiredCapacityRequest, AsyncHandler<SetDesiredCapacityRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass66(setDesiredCapacityRequest, asyncHandler));
    }

    public Future<Void> setInstanceHealthAsync(SetInstanceHealthRequest setInstanceHealthRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass37(setInstanceHealthRequest));
    }

    public Future<Void> setInstanceHealthAsync(SetInstanceHealthRequest setInstanceHealthRequest, AsyncHandler<SetInstanceHealthRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass38(setInstanceHealthRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<Void> suspendProcessesAsync(SuspendProcessesRequest suspendProcessesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass43(suspendProcessesRequest));
    }

    public Future<Void> suspendProcessesAsync(SuspendProcessesRequest suspendProcessesRequest, AsyncHandler<SuspendProcessesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass44(suspendProcessesRequest, asyncHandler));
    }

    public Future<TerminateInstanceInAutoScalingGroupResult> terminateInstanceInAutoScalingGroupAsync(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass67(terminateInstanceInAutoScalingGroupRequest));
    }

    public Future<TerminateInstanceInAutoScalingGroupResult> terminateInstanceInAutoScalingGroupAsync(TerminateInstanceInAutoScalingGroupRequest terminateInstanceInAutoScalingGroupRequest, AsyncHandler<TerminateInstanceInAutoScalingGroupRequest, TerminateInstanceInAutoScalingGroupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass68(terminateInstanceInAutoScalingGroupRequest, asyncHandler));
    }

    public Future<Void> updateAutoScalingGroupAsync(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass53(updateAutoScalingGroupRequest));
    }

    public Future<Void> updateAutoScalingGroupAsync(UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest, AsyncHandler<UpdateAutoScalingGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass54(updateAutoScalingGroupRequest, asyncHandler));
    }
}
