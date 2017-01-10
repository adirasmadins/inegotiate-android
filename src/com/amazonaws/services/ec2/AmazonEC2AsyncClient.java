package com.amazonaws.services.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.ec2.model.ActivateLicenseRequest;
import com.amazonaws.services.ec2.model.AllocateAddressRequest;
import com.amazonaws.services.ec2.model.AllocateAddressResult;
import com.amazonaws.services.ec2.model.AssociateAddressRequest;
import com.amazonaws.services.ec2.model.AssociateAddressResult;
import com.amazonaws.services.ec2.model.AttachVolumeRequest;
import com.amazonaws.services.ec2.model.AttachVolumeResult;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.BundleInstanceRequest;
import com.amazonaws.services.ec2.model.BundleInstanceResult;
import com.amazonaws.services.ec2.model.CancelBundleTaskRequest;
import com.amazonaws.services.ec2.model.CancelBundleTaskResult;
import com.amazonaws.services.ec2.model.CancelConversionTaskRequest;
import com.amazonaws.services.ec2.model.CancelExportTaskRequest;
import com.amazonaws.services.ec2.model.CancelReservedInstancesListingRequest;
import com.amazonaws.services.ec2.model.CancelReservedInstancesListingResult;
import com.amazonaws.services.ec2.model.CancelSpotInstanceRequestsRequest;
import com.amazonaws.services.ec2.model.CancelSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.ConfirmProductInstanceRequest;
import com.amazonaws.services.ec2.model.ConfirmProductInstanceResult;
import com.amazonaws.services.ec2.model.CreateImageRequest;
import com.amazonaws.services.ec2.model.CreateImageResult;
import com.amazonaws.services.ec2.model.CreateInstanceExportTaskRequest;
import com.amazonaws.services.ec2.model.CreateInstanceExportTaskResult;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreatePlacementGroupRequest;
import com.amazonaws.services.ec2.model.CreateReservedInstancesListingRequest;
import com.amazonaws.services.ec2.model.CreateReservedInstancesListingResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.CreateSnapshotRequest;
import com.amazonaws.services.ec2.model.CreateSnapshotResult;
import com.amazonaws.services.ec2.model.CreateSpotDatafeedSubscriptionRequest;
import com.amazonaws.services.ec2.model.CreateSpotDatafeedSubscriptionResult;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.CreateVolumeRequest;
import com.amazonaws.services.ec2.model.CreateVolumeResult;
import com.amazonaws.services.ec2.model.DeactivateLicenseRequest;
import com.amazonaws.services.ec2.model.DeleteKeyPairRequest;
import com.amazonaws.services.ec2.model.DeletePlacementGroupRequest;
import com.amazonaws.services.ec2.model.DeleteSecurityGroupRequest;
import com.amazonaws.services.ec2.model.DeleteSnapshotRequest;
import com.amazonaws.services.ec2.model.DeleteSpotDatafeedSubscriptionRequest;
import com.amazonaws.services.ec2.model.DeleteTagsRequest;
import com.amazonaws.services.ec2.model.DeleteVolumeRequest;
import com.amazonaws.services.ec2.model.DeregisterImageRequest;
import com.amazonaws.services.ec2.model.DescribeAddressesRequest;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesRequest;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeBundleTasksRequest;
import com.amazonaws.services.ec2.model.DescribeBundleTasksResult;
import com.amazonaws.services.ec2.model.DescribeConversionTasksRequest;
import com.amazonaws.services.ec2.model.DescribeConversionTasksResult;
import com.amazonaws.services.ec2.model.DescribeExportTasksRequest;
import com.amazonaws.services.ec2.model.DescribeExportTasksResult;
import com.amazonaws.services.ec2.model.DescribeImageAttributeRequest;
import com.amazonaws.services.ec2.model.DescribeImageAttributeResult;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.DescribeInstanceAttributeRequest;
import com.amazonaws.services.ec2.model.DescribeInstanceAttributeResult;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusRequest;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusResult;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeKeyPairsRequest;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.services.ec2.model.DescribeLicensesRequest;
import com.amazonaws.services.ec2.model.DescribeLicensesResult;
import com.amazonaws.services.ec2.model.DescribePlacementGroupsRequest;
import com.amazonaws.services.ec2.model.DescribePlacementGroupsResult;
import com.amazonaws.services.ec2.model.DescribeRegionsRequest;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesListingsRequest;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesListingsResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsRequest;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsRequest;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.services.ec2.model.DescribeSnapshotAttributeRequest;
import com.amazonaws.services.ec2.model.DescribeSnapshotAttributeResult;
import com.amazonaws.services.ec2.model.DescribeSnapshotsRequest;
import com.amazonaws.services.ec2.model.DescribeSnapshotsResult;
import com.amazonaws.services.ec2.model.DescribeSpotDatafeedSubscriptionRequest;
import com.amazonaws.services.ec2.model.DescribeSpotDatafeedSubscriptionResult;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsRequest;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryRequest;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryResult;
import com.amazonaws.services.ec2.model.DescribeTagsRequest;
import com.amazonaws.services.ec2.model.DescribeTagsResult;
import com.amazonaws.services.ec2.model.DescribeVolumeAttributeRequest;
import com.amazonaws.services.ec2.model.DescribeVolumeAttributeResult;
import com.amazonaws.services.ec2.model.DescribeVolumeStatusRequest;
import com.amazonaws.services.ec2.model.DescribeVolumeStatusResult;
import com.amazonaws.services.ec2.model.DescribeVolumesRequest;
import com.amazonaws.services.ec2.model.DescribeVolumesResult;
import com.amazonaws.services.ec2.model.DetachVolumeRequest;
import com.amazonaws.services.ec2.model.DetachVolumeResult;
import com.amazonaws.services.ec2.model.DisassociateAddressRequest;
import com.amazonaws.services.ec2.model.EnableVolumeIORequest;
import com.amazonaws.services.ec2.model.GetConsoleOutputRequest;
import com.amazonaws.services.ec2.model.GetConsoleOutputResult;
import com.amazonaws.services.ec2.model.GetPasswordDataRequest;
import com.amazonaws.services.ec2.model.GetPasswordDataResult;
import com.amazonaws.services.ec2.model.ImportInstanceRequest;
import com.amazonaws.services.ec2.model.ImportInstanceResult;
import com.amazonaws.services.ec2.model.ImportKeyPairRequest;
import com.amazonaws.services.ec2.model.ImportKeyPairResult;
import com.amazonaws.services.ec2.model.ImportVolumeRequest;
import com.amazonaws.services.ec2.model.ImportVolumeResult;
import com.amazonaws.services.ec2.model.ModifyImageAttributeRequest;
import com.amazonaws.services.ec2.model.ModifyInstanceAttributeRequest;
import com.amazonaws.services.ec2.model.ModifySnapshotAttributeRequest;
import com.amazonaws.services.ec2.model.ModifyVolumeAttributeRequest;
import com.amazonaws.services.ec2.model.MonitorInstancesRequest;
import com.amazonaws.services.ec2.model.MonitorInstancesResult;
import com.amazonaws.services.ec2.model.PurchaseReservedInstancesOfferingRequest;
import com.amazonaws.services.ec2.model.PurchaseReservedInstancesOfferingResult;
import com.amazonaws.services.ec2.model.RebootInstancesRequest;
import com.amazonaws.services.ec2.model.RegisterImageRequest;
import com.amazonaws.services.ec2.model.RegisterImageResult;
import com.amazonaws.services.ec2.model.ReleaseAddressRequest;
import com.amazonaws.services.ec2.model.ReportInstanceStatusRequest;
import com.amazonaws.services.ec2.model.RequestSpotInstancesRequest;
import com.amazonaws.services.ec2.model.RequestSpotInstancesResult;
import com.amazonaws.services.ec2.model.ResetImageAttributeRequest;
import com.amazonaws.services.ec2.model.ResetInstanceAttributeRequest;
import com.amazonaws.services.ec2.model.ResetSnapshotAttributeRequest;
import com.amazonaws.services.ec2.model.RevokeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.amazonaws.services.ec2.model.UnmonitorInstancesRequest;
import com.amazonaws.services.ec2.model.UnmonitorInstancesResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonEC2AsyncClient extends AmazonEC2Client implements AmazonEC2Async {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.100 */
    class AnonymousClass100 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ModifyVolumeAttributeRequest val$modifyVolumeAttributeRequest;

        AnonymousClass100(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest, AsyncHandler asyncHandler) {
            this.val$modifyVolumeAttributeRequest = modifyVolumeAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.modifyVolumeAttribute(this.val$modifyVolumeAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$modifyVolumeAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.101 */
    class AnonymousClass101 implements Callable<DescribeImagesResult> {
        final /* synthetic */ DescribeImagesRequest val$describeImagesRequest;

        AnonymousClass101(DescribeImagesRequest describeImagesRequest) {
            this.val$describeImagesRequest = describeImagesRequest;
        }

        public DescribeImagesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeImages(this.val$describeImagesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.102 */
    class AnonymousClass102 implements Callable<DescribeImagesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeImagesRequest val$describeImagesRequest;

        AnonymousClass102(DescribeImagesRequest describeImagesRequest, AsyncHandler asyncHandler) {
            this.val$describeImagesRequest = describeImagesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeImagesResult call() throws Exception {
            try {
                DescribeImagesResult describeImages = AmazonEC2AsyncClient.this.describeImages(this.val$describeImagesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeImagesRequest, describeImages);
                return describeImages;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.103 */
    class AnonymousClass103 implements Callable<StartInstancesResult> {
        final /* synthetic */ StartInstancesRequest val$startInstancesRequest;

        AnonymousClass103(StartInstancesRequest startInstancesRequest) {
            this.val$startInstancesRequest = startInstancesRequest;
        }

        public StartInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.startInstances(this.val$startInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.104 */
    class AnonymousClass104 implements Callable<StartInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ StartInstancesRequest val$startInstancesRequest;

        AnonymousClass104(StartInstancesRequest startInstancesRequest, AsyncHandler asyncHandler) {
            this.val$startInstancesRequest = startInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public StartInstancesResult call() throws Exception {
            try {
                StartInstancesResult startInstances = AmazonEC2AsyncClient.this.startInstances(this.val$startInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$startInstancesRequest, startInstances);
                return startInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.105 */
    class AnonymousClass105 implements Callable<CancelReservedInstancesListingResult> {
        final /* synthetic */ CancelReservedInstancesListingRequest val$cancelReservedInstancesListingRequest;

        AnonymousClass105(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) {
            this.val$cancelReservedInstancesListingRequest = cancelReservedInstancesListingRequest;
        }

        public CancelReservedInstancesListingResult call() throws Exception {
            return AmazonEC2AsyncClient.this.cancelReservedInstancesListing(this.val$cancelReservedInstancesListingRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.106 */
    class AnonymousClass106 implements Callable<CancelReservedInstancesListingResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CancelReservedInstancesListingRequest val$cancelReservedInstancesListingRequest;

        AnonymousClass106(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest, AsyncHandler asyncHandler) {
            this.val$cancelReservedInstancesListingRequest = cancelReservedInstancesListingRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CancelReservedInstancesListingResult call() throws Exception {
            try {
                CancelReservedInstancesListingResult cancelReservedInstancesListing = AmazonEC2AsyncClient.this.cancelReservedInstancesListing(this.val$cancelReservedInstancesListingRequest);
                this.val$asyncHandler.onSuccess(this.val$cancelReservedInstancesListingRequest, cancelReservedInstancesListing);
                return cancelReservedInstancesListing;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.107 */
    class AnonymousClass107 implements Callable<Void> {
        final /* synthetic */ ModifyInstanceAttributeRequest val$modifyInstanceAttributeRequest;

        AnonymousClass107(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) {
            this.val$modifyInstanceAttributeRequest = modifyInstanceAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.modifyInstanceAttribute(this.val$modifyInstanceAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.108 */
    class AnonymousClass108 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ModifyInstanceAttributeRequest val$modifyInstanceAttributeRequest;

        AnonymousClass108(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest, AsyncHandler asyncHandler) {
            this.val$modifyInstanceAttributeRequest = modifyInstanceAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.modifyInstanceAttribute(this.val$modifyInstanceAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$modifyInstanceAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.109 */
    class AnonymousClass109 implements Callable<Void> {
        final /* synthetic */ AuthorizeSecurityGroupIngressRequest val$authorizeSecurityGroupIngressRequest;

        AnonymousClass109(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) {
            this.val$authorizeSecurityGroupIngressRequest = authorizeSecurityGroupIngressRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.authorizeSecurityGroupIngress(this.val$authorizeSecurityGroupIngressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteKeyPairRequest val$deleteKeyPairRequest;

        AnonymousClass10(DeleteKeyPairRequest deleteKeyPairRequest, AsyncHandler asyncHandler) {
            this.val$deleteKeyPairRequest = deleteKeyPairRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteKeyPair(this.val$deleteKeyPairRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteKeyPairRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.110 */
    class AnonymousClass110 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ AuthorizeSecurityGroupIngressRequest val$authorizeSecurityGroupIngressRequest;

        AnonymousClass110(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest, AsyncHandler asyncHandler) {
            this.val$authorizeSecurityGroupIngressRequest = authorizeSecurityGroupIngressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.authorizeSecurityGroupIngress(this.val$authorizeSecurityGroupIngressRequest);
                this.val$asyncHandler.onSuccess(this.val$authorizeSecurityGroupIngressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.111 */
    class AnonymousClass111 implements Callable<DescribeSpotInstanceRequestsResult> {
        final /* synthetic */ DescribeSpotInstanceRequestsRequest val$describeSpotInstanceRequestsRequest;

        AnonymousClass111(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) {
            this.val$describeSpotInstanceRequestsRequest = describeSpotInstanceRequestsRequest;
        }

        public DescribeSpotInstanceRequestsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSpotInstanceRequests(this.val$describeSpotInstanceRequestsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.112 */
    class AnonymousClass112 implements Callable<DescribeSpotInstanceRequestsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSpotInstanceRequestsRequest val$describeSpotInstanceRequestsRequest;

        AnonymousClass112(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest, AsyncHandler asyncHandler) {
            this.val$describeSpotInstanceRequestsRequest = describeSpotInstanceRequestsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSpotInstanceRequestsResult call() throws Exception {
            try {
                DescribeSpotInstanceRequestsResult describeSpotInstanceRequests = AmazonEC2AsyncClient.this.describeSpotInstanceRequests(this.val$describeSpotInstanceRequestsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSpotInstanceRequestsRequest, describeSpotInstanceRequests);
                return describeSpotInstanceRequests;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.113 */
    class AnonymousClass113 implements Callable<Void> {
        final /* synthetic */ CancelExportTaskRequest val$cancelExportTaskRequest;

        AnonymousClass113(CancelExportTaskRequest cancelExportTaskRequest) {
            this.val$cancelExportTaskRequest = cancelExportTaskRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.cancelExportTask(this.val$cancelExportTaskRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.114 */
    class AnonymousClass114 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CancelExportTaskRequest val$cancelExportTaskRequest;

        AnonymousClass114(CancelExportTaskRequest cancelExportTaskRequest, AsyncHandler asyncHandler) {
            this.val$cancelExportTaskRequest = cancelExportTaskRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.cancelExportTask(this.val$cancelExportTaskRequest);
                this.val$asyncHandler.onSuccess(this.val$cancelExportTaskRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.115 */
    class AnonymousClass115 implements Callable<RequestSpotInstancesResult> {
        final /* synthetic */ RequestSpotInstancesRequest val$requestSpotInstancesRequest;

        AnonymousClass115(RequestSpotInstancesRequest requestSpotInstancesRequest) {
            this.val$requestSpotInstancesRequest = requestSpotInstancesRequest;
        }

        public RequestSpotInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.requestSpotInstances(this.val$requestSpotInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.116 */
    class AnonymousClass116 implements Callable<RequestSpotInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RequestSpotInstancesRequest val$requestSpotInstancesRequest;

        AnonymousClass116(RequestSpotInstancesRequest requestSpotInstancesRequest, AsyncHandler asyncHandler) {
            this.val$requestSpotInstancesRequest = requestSpotInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public RequestSpotInstancesResult call() throws Exception {
            try {
                RequestSpotInstancesResult requestSpotInstances = AmazonEC2AsyncClient.this.requestSpotInstances(this.val$requestSpotInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$requestSpotInstancesRequest, requestSpotInstances);
                return requestSpotInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.117 */
    class AnonymousClass117 implements Callable<Void> {
        final /* synthetic */ CreateTagsRequest val$createTagsRequest;

        AnonymousClass117(CreateTagsRequest createTagsRequest) {
            this.val$createTagsRequest = createTagsRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.createTags(this.val$createTagsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.118 */
    class AnonymousClass118 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateTagsRequest val$createTagsRequest;

        AnonymousClass118(CreateTagsRequest createTagsRequest, AsyncHandler asyncHandler) {
            this.val$createTagsRequest = createTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.createTags(this.val$createTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$createTagsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.119 */
    class AnonymousClass119 implements Callable<DescribeVolumeAttributeResult> {
        final /* synthetic */ DescribeVolumeAttributeRequest val$describeVolumeAttributeRequest;

        AnonymousClass119(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) {
            this.val$describeVolumeAttributeRequest = describeVolumeAttributeRequest;
        }

        public DescribeVolumeAttributeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeVolumeAttribute(this.val$describeVolumeAttributeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.11 */
    class AnonymousClass11 implements Callable<UnmonitorInstancesResult> {
        final /* synthetic */ UnmonitorInstancesRequest val$unmonitorInstancesRequest;

        AnonymousClass11(UnmonitorInstancesRequest unmonitorInstancesRequest) {
            this.val$unmonitorInstancesRequest = unmonitorInstancesRequest;
        }

        public UnmonitorInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.unmonitorInstances(this.val$unmonitorInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.120 */
    class AnonymousClass120 implements Callable<DescribeVolumeAttributeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeVolumeAttributeRequest val$describeVolumeAttributeRequest;

        AnonymousClass120(DescribeVolumeAttributeRequest describeVolumeAttributeRequest, AsyncHandler asyncHandler) {
            this.val$describeVolumeAttributeRequest = describeVolumeAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeVolumeAttributeResult call() throws Exception {
            try {
                DescribeVolumeAttributeResult describeVolumeAttribute = AmazonEC2AsyncClient.this.describeVolumeAttribute(this.val$describeVolumeAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$describeVolumeAttributeRequest, describeVolumeAttribute);
                return describeVolumeAttribute;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.121 */
    class AnonymousClass121 implements Callable<DescribeTagsResult> {
        final /* synthetic */ DescribeTagsRequest val$describeTagsRequest;

        AnonymousClass121(DescribeTagsRequest describeTagsRequest) {
            this.val$describeTagsRequest = describeTagsRequest;
        }

        public DescribeTagsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeTags(this.val$describeTagsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.122 */
    class AnonymousClass122 implements Callable<DescribeTagsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeTagsRequest val$describeTagsRequest;

        AnonymousClass122(DescribeTagsRequest describeTagsRequest, AsyncHandler asyncHandler) {
            this.val$describeTagsRequest = describeTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeTagsResult call() throws Exception {
            try {
                DescribeTagsResult describeTags = AmazonEC2AsyncClient.this.describeTags(this.val$describeTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeTagsRequest, describeTags);
                return describeTags;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.123 */
    class AnonymousClass123 implements Callable<CancelBundleTaskResult> {
        final /* synthetic */ CancelBundleTaskRequest val$cancelBundleTaskRequest;

        AnonymousClass123(CancelBundleTaskRequest cancelBundleTaskRequest) {
            this.val$cancelBundleTaskRequest = cancelBundleTaskRequest;
        }

        public CancelBundleTaskResult call() throws Exception {
            return AmazonEC2AsyncClient.this.cancelBundleTask(this.val$cancelBundleTaskRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.124 */
    class AnonymousClass124 implements Callable<CancelBundleTaskResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CancelBundleTaskRequest val$cancelBundleTaskRequest;

        AnonymousClass124(CancelBundleTaskRequest cancelBundleTaskRequest, AsyncHandler asyncHandler) {
            this.val$cancelBundleTaskRequest = cancelBundleTaskRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CancelBundleTaskResult call() throws Exception {
            try {
                CancelBundleTaskResult cancelBundleTask = AmazonEC2AsyncClient.this.cancelBundleTask(this.val$cancelBundleTaskRequest);
                this.val$asyncHandler.onSuccess(this.val$cancelBundleTaskRequest, cancelBundleTask);
                return cancelBundleTask;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.125 */
    class AnonymousClass125 implements Callable<CancelSpotInstanceRequestsResult> {
        final /* synthetic */ CancelSpotInstanceRequestsRequest val$cancelSpotInstanceRequestsRequest;

        AnonymousClass125(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) {
            this.val$cancelSpotInstanceRequestsRequest = cancelSpotInstanceRequestsRequest;
        }

        public CancelSpotInstanceRequestsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.cancelSpotInstanceRequests(this.val$cancelSpotInstanceRequestsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.126 */
    class AnonymousClass126 implements Callable<CancelSpotInstanceRequestsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CancelSpotInstanceRequestsRequest val$cancelSpotInstanceRequestsRequest;

        AnonymousClass126(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest, AsyncHandler asyncHandler) {
            this.val$cancelSpotInstanceRequestsRequest = cancelSpotInstanceRequestsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CancelSpotInstanceRequestsResult call() throws Exception {
            try {
                CancelSpotInstanceRequestsResult cancelSpotInstanceRequests = AmazonEC2AsyncClient.this.cancelSpotInstanceRequests(this.val$cancelSpotInstanceRequestsRequest);
                this.val$asyncHandler.onSuccess(this.val$cancelSpotInstanceRequestsRequest, cancelSpotInstanceRequests);
                return cancelSpotInstanceRequests;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.127 */
    class AnonymousClass127 implements Callable<PurchaseReservedInstancesOfferingResult> {
        final /* synthetic */ PurchaseReservedInstancesOfferingRequest val$purchaseReservedInstancesOfferingRequest;

        AnonymousClass127(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) {
            this.val$purchaseReservedInstancesOfferingRequest = purchaseReservedInstancesOfferingRequest;
        }

        public PurchaseReservedInstancesOfferingResult call() throws Exception {
            return AmazonEC2AsyncClient.this.purchaseReservedInstancesOffering(this.val$purchaseReservedInstancesOfferingRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.128 */
    class AnonymousClass128 implements Callable<PurchaseReservedInstancesOfferingResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PurchaseReservedInstancesOfferingRequest val$purchaseReservedInstancesOfferingRequest;

        AnonymousClass128(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest, AsyncHandler asyncHandler) {
            this.val$purchaseReservedInstancesOfferingRequest = purchaseReservedInstancesOfferingRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public PurchaseReservedInstancesOfferingResult call() throws Exception {
            try {
                PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOffering = AmazonEC2AsyncClient.this.purchaseReservedInstancesOffering(this.val$purchaseReservedInstancesOfferingRequest);
                this.val$asyncHandler.onSuccess(this.val$purchaseReservedInstancesOfferingRequest, purchaseReservedInstancesOffering);
                return purchaseReservedInstancesOffering;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.129 */
    class AnonymousClass129 implements Callable<Void> {
        final /* synthetic */ ModifySnapshotAttributeRequest val$modifySnapshotAttributeRequest;

        AnonymousClass129(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) {
            this.val$modifySnapshotAttributeRequest = modifySnapshotAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.modifySnapshotAttribute(this.val$modifySnapshotAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.12 */
    class AnonymousClass12 implements Callable<UnmonitorInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ UnmonitorInstancesRequest val$unmonitorInstancesRequest;

        AnonymousClass12(UnmonitorInstancesRequest unmonitorInstancesRequest, AsyncHandler asyncHandler) {
            this.val$unmonitorInstancesRequest = unmonitorInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public UnmonitorInstancesResult call() throws Exception {
            try {
                UnmonitorInstancesResult unmonitorInstances = AmazonEC2AsyncClient.this.unmonitorInstances(this.val$unmonitorInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$unmonitorInstancesRequest, unmonitorInstances);
                return unmonitorInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.130 */
    class AnonymousClass130 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ModifySnapshotAttributeRequest val$modifySnapshotAttributeRequest;

        AnonymousClass130(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest, AsyncHandler asyncHandler) {
            this.val$modifySnapshotAttributeRequest = modifySnapshotAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.modifySnapshotAttribute(this.val$modifySnapshotAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$modifySnapshotAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.131 */
    class AnonymousClass131 implements Callable<TerminateInstancesResult> {
        final /* synthetic */ TerminateInstancesRequest val$terminateInstancesRequest;

        AnonymousClass131(TerminateInstancesRequest terminateInstancesRequest) {
            this.val$terminateInstancesRequest = terminateInstancesRequest;
        }

        public TerminateInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.terminateInstances(this.val$terminateInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.132 */
    class AnonymousClass132 implements Callable<TerminateInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ TerminateInstancesRequest val$terminateInstancesRequest;

        AnonymousClass132(TerminateInstancesRequest terminateInstancesRequest, AsyncHandler asyncHandler) {
            this.val$terminateInstancesRequest = terminateInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public TerminateInstancesResult call() throws Exception {
            try {
                TerminateInstancesResult terminateInstances = AmazonEC2AsyncClient.this.terminateInstances(this.val$terminateInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$terminateInstancesRequest, terminateInstances);
                return terminateInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.133 */
    class AnonymousClass133 implements Callable<Void> {
        final /* synthetic */ DeleteSpotDatafeedSubscriptionRequest val$deleteSpotDatafeedSubscriptionRequest;

        AnonymousClass133(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) {
            this.val$deleteSpotDatafeedSubscriptionRequest = deleteSpotDatafeedSubscriptionRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteSpotDatafeedSubscription(this.val$deleteSpotDatafeedSubscriptionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.134 */
    class AnonymousClass134 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteSpotDatafeedSubscriptionRequest val$deleteSpotDatafeedSubscriptionRequest;

        AnonymousClass134(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest, AsyncHandler asyncHandler) {
            this.val$deleteSpotDatafeedSubscriptionRequest = deleteSpotDatafeedSubscriptionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteSpotDatafeedSubscription(this.val$deleteSpotDatafeedSubscriptionRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteSpotDatafeedSubscriptionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.135 */
    class AnonymousClass135 implements Callable<DescribeSnapshotAttributeResult> {
        final /* synthetic */ DescribeSnapshotAttributeRequest val$describeSnapshotAttributeRequest;

        AnonymousClass135(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) {
            this.val$describeSnapshotAttributeRequest = describeSnapshotAttributeRequest;
        }

        public DescribeSnapshotAttributeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSnapshotAttribute(this.val$describeSnapshotAttributeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.136 */
    class AnonymousClass136 implements Callable<DescribeSnapshotAttributeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSnapshotAttributeRequest val$describeSnapshotAttributeRequest;

        AnonymousClass136(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest, AsyncHandler asyncHandler) {
            this.val$describeSnapshotAttributeRequest = describeSnapshotAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSnapshotAttributeResult call() throws Exception {
            try {
                DescribeSnapshotAttributeResult describeSnapshotAttribute = AmazonEC2AsyncClient.this.describeSnapshotAttribute(this.val$describeSnapshotAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSnapshotAttributeRequest, describeSnapshotAttribute);
                return describeSnapshotAttribute;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.137 */
    class AnonymousClass137 implements Callable<DescribeAddressesResult> {
        final /* synthetic */ DescribeAddressesRequest val$describeAddressesRequest;

        AnonymousClass137(DescribeAddressesRequest describeAddressesRequest) {
            this.val$describeAddressesRequest = describeAddressesRequest;
        }

        public DescribeAddressesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeAddresses(this.val$describeAddressesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.138 */
    class AnonymousClass138 implements Callable<DescribeAddressesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAddressesRequest val$describeAddressesRequest;

        AnonymousClass138(DescribeAddressesRequest describeAddressesRequest, AsyncHandler asyncHandler) {
            this.val$describeAddressesRequest = describeAddressesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAddressesResult call() throws Exception {
            try {
                DescribeAddressesResult describeAddresses = AmazonEC2AsyncClient.this.describeAddresses(this.val$describeAddressesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAddressesRequest, describeAddresses);
                return describeAddresses;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.139 */
    class AnonymousClass139 implements Callable<DescribeImageAttributeResult> {
        final /* synthetic */ DescribeImageAttributeRequest val$describeImageAttributeRequest;

        AnonymousClass139(DescribeImageAttributeRequest describeImageAttributeRequest) {
            this.val$describeImageAttributeRequest = describeImageAttributeRequest;
        }

        public DescribeImageAttributeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeImageAttribute(this.val$describeImageAttributeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.13 */
    class AnonymousClass13 implements Callable<CreateImageResult> {
        final /* synthetic */ CreateImageRequest val$createImageRequest;

        AnonymousClass13(CreateImageRequest createImageRequest) {
            this.val$createImageRequest = createImageRequest;
        }

        public CreateImageResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createImage(this.val$createImageRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.140 */
    class AnonymousClass140 implements Callable<DescribeImageAttributeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeImageAttributeRequest val$describeImageAttributeRequest;

        AnonymousClass140(DescribeImageAttributeRequest describeImageAttributeRequest, AsyncHandler asyncHandler) {
            this.val$describeImageAttributeRequest = describeImageAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeImageAttributeResult call() throws Exception {
            try {
                DescribeImageAttributeResult describeImageAttribute = AmazonEC2AsyncClient.this.describeImageAttribute(this.val$describeImageAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$describeImageAttributeRequest, describeImageAttribute);
                return describeImageAttribute;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.141 */
    class AnonymousClass141 implements Callable<DescribeKeyPairsResult> {
        final /* synthetic */ DescribeKeyPairsRequest val$describeKeyPairsRequest;

        AnonymousClass141(DescribeKeyPairsRequest describeKeyPairsRequest) {
            this.val$describeKeyPairsRequest = describeKeyPairsRequest;
        }

        public DescribeKeyPairsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeKeyPairs(this.val$describeKeyPairsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.142 */
    class AnonymousClass142 implements Callable<DescribeKeyPairsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeKeyPairsRequest val$describeKeyPairsRequest;

        AnonymousClass142(DescribeKeyPairsRequest describeKeyPairsRequest, AsyncHandler asyncHandler) {
            this.val$describeKeyPairsRequest = describeKeyPairsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeKeyPairsResult call() throws Exception {
            try {
                DescribeKeyPairsResult describeKeyPairs = AmazonEC2AsyncClient.this.describeKeyPairs(this.val$describeKeyPairsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeKeyPairsRequest, describeKeyPairs);
                return describeKeyPairs;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.143 */
    class AnonymousClass143 implements Callable<ConfirmProductInstanceResult> {
        final /* synthetic */ ConfirmProductInstanceRequest val$confirmProductInstanceRequest;

        AnonymousClass143(ConfirmProductInstanceRequest confirmProductInstanceRequest) {
            this.val$confirmProductInstanceRequest = confirmProductInstanceRequest;
        }

        public ConfirmProductInstanceResult call() throws Exception {
            return AmazonEC2AsyncClient.this.confirmProductInstance(this.val$confirmProductInstanceRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.144 */
    class AnonymousClass144 implements Callable<ConfirmProductInstanceResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ConfirmProductInstanceRequest val$confirmProductInstanceRequest;

        AnonymousClass144(ConfirmProductInstanceRequest confirmProductInstanceRequest, AsyncHandler asyncHandler) {
            this.val$confirmProductInstanceRequest = confirmProductInstanceRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ConfirmProductInstanceResult call() throws Exception {
            try {
                ConfirmProductInstanceResult confirmProductInstance = AmazonEC2AsyncClient.this.confirmProductInstance(this.val$confirmProductInstanceRequest);
                this.val$asyncHandler.onSuccess(this.val$confirmProductInstanceRequest, confirmProductInstance);
                return confirmProductInstance;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.145 */
    class AnonymousClass145 implements Callable<CreateVolumeResult> {
        final /* synthetic */ CreateVolumeRequest val$createVolumeRequest;

        AnonymousClass145(CreateVolumeRequest createVolumeRequest) {
            this.val$createVolumeRequest = createVolumeRequest;
        }

        public CreateVolumeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createVolume(this.val$createVolumeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.146 */
    class AnonymousClass146 implements Callable<CreateVolumeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateVolumeRequest val$createVolumeRequest;

        AnonymousClass146(CreateVolumeRequest createVolumeRequest, AsyncHandler asyncHandler) {
            this.val$createVolumeRequest = createVolumeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateVolumeResult call() throws Exception {
            try {
                CreateVolumeResult createVolume = AmazonEC2AsyncClient.this.createVolume(this.val$createVolumeRequest);
                this.val$asyncHandler.onSuccess(this.val$createVolumeRequest, createVolume);
                return createVolume;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.147 */
    class AnonymousClass147 implements Callable<DescribeInstanceStatusResult> {
        final /* synthetic */ DescribeInstanceStatusRequest val$describeInstanceStatusRequest;

        AnonymousClass147(DescribeInstanceStatusRequest describeInstanceStatusRequest) {
            this.val$describeInstanceStatusRequest = describeInstanceStatusRequest;
        }

        public DescribeInstanceStatusResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeInstanceStatus(this.val$describeInstanceStatusRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.148 */
    class AnonymousClass148 implements Callable<DescribeInstanceStatusResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeInstanceStatusRequest val$describeInstanceStatusRequest;

        AnonymousClass148(DescribeInstanceStatusRequest describeInstanceStatusRequest, AsyncHandler asyncHandler) {
            this.val$describeInstanceStatusRequest = describeInstanceStatusRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeInstanceStatusResult call() throws Exception {
            try {
                DescribeInstanceStatusResult describeInstanceStatus = AmazonEC2AsyncClient.this.describeInstanceStatus(this.val$describeInstanceStatusRequest);
                this.val$asyncHandler.onSuccess(this.val$describeInstanceStatusRequest, describeInstanceStatus);
                return describeInstanceStatus;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.149 */
    class AnonymousClass149 implements Callable<DescribeReservedInstancesOfferingsResult> {
        final /* synthetic */ DescribeReservedInstancesOfferingsRequest val$describeReservedInstancesOfferingsRequest;

        AnonymousClass149(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) {
            this.val$describeReservedInstancesOfferingsRequest = describeReservedInstancesOfferingsRequest;
        }

        public DescribeReservedInstancesOfferingsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeReservedInstancesOfferings(this.val$describeReservedInstancesOfferingsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.14 */
    class AnonymousClass14 implements Callable<CreateImageResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateImageRequest val$createImageRequest;

        AnonymousClass14(CreateImageRequest createImageRequest, AsyncHandler asyncHandler) {
            this.val$createImageRequest = createImageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateImageResult call() throws Exception {
            try {
                CreateImageResult createImage = AmazonEC2AsyncClient.this.createImage(this.val$createImageRequest);
                this.val$asyncHandler.onSuccess(this.val$createImageRequest, createImage);
                return createImage;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.150 */
    class AnonymousClass150 implements Callable<DescribeReservedInstancesOfferingsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeReservedInstancesOfferingsRequest val$describeReservedInstancesOfferingsRequest;

        AnonymousClass150(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest, AsyncHandler asyncHandler) {
            this.val$describeReservedInstancesOfferingsRequest = describeReservedInstancesOfferingsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeReservedInstancesOfferingsResult call() throws Exception {
            try {
                DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings = AmazonEC2AsyncClient.this.describeReservedInstancesOfferings(this.val$describeReservedInstancesOfferingsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeReservedInstancesOfferingsRequest, describeReservedInstancesOfferings);
                return describeReservedInstancesOfferings;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.151 */
    class AnonymousClass151 implements Callable<Void> {
        final /* synthetic */ DeleteSnapshotRequest val$deleteSnapshotRequest;

        AnonymousClass151(DeleteSnapshotRequest deleteSnapshotRequest) {
            this.val$deleteSnapshotRequest = deleteSnapshotRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteSnapshot(this.val$deleteSnapshotRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.152 */
    class AnonymousClass152 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteSnapshotRequest val$deleteSnapshotRequest;

        AnonymousClass152(DeleteSnapshotRequest deleteSnapshotRequest, AsyncHandler asyncHandler) {
            this.val$deleteSnapshotRequest = deleteSnapshotRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteSnapshot(this.val$deleteSnapshotRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteSnapshotRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.153 */
    class AnonymousClass153 implements Callable<Void> {
        final /* synthetic */ DisassociateAddressRequest val$disassociateAddressRequest;

        AnonymousClass153(DisassociateAddressRequest disassociateAddressRequest) {
            this.val$disassociateAddressRequest = disassociateAddressRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.disassociateAddress(this.val$disassociateAddressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.154 */
    class AnonymousClass154 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DisassociateAddressRequest val$disassociateAddressRequest;

        AnonymousClass154(DisassociateAddressRequest disassociateAddressRequest, AsyncHandler asyncHandler) {
            this.val$disassociateAddressRequest = disassociateAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.disassociateAddress(this.val$disassociateAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$disassociateAddressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.155 */
    class AnonymousClass155 implements Callable<Void> {
        final /* synthetic */ CreatePlacementGroupRequest val$createPlacementGroupRequest;

        AnonymousClass155(CreatePlacementGroupRequest createPlacementGroupRequest) {
            this.val$createPlacementGroupRequest = createPlacementGroupRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.createPlacementGroup(this.val$createPlacementGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.156 */
    class AnonymousClass156 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreatePlacementGroupRequest val$createPlacementGroupRequest;

        AnonymousClass156(CreatePlacementGroupRequest createPlacementGroupRequest, AsyncHandler asyncHandler) {
            this.val$createPlacementGroupRequest = createPlacementGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.createPlacementGroup(this.val$createPlacementGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$createPlacementGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.157 */
    class AnonymousClass157 implements Callable<BundleInstanceResult> {
        final /* synthetic */ BundleInstanceRequest val$bundleInstanceRequest;

        AnonymousClass157(BundleInstanceRequest bundleInstanceRequest) {
            this.val$bundleInstanceRequest = bundleInstanceRequest;
        }

        public BundleInstanceResult call() throws Exception {
            return AmazonEC2AsyncClient.this.bundleInstance(this.val$bundleInstanceRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.158 */
    class AnonymousClass158 implements Callable<BundleInstanceResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ BundleInstanceRequest val$bundleInstanceRequest;

        AnonymousClass158(BundleInstanceRequest bundleInstanceRequest, AsyncHandler asyncHandler) {
            this.val$bundleInstanceRequest = bundleInstanceRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public BundleInstanceResult call() throws Exception {
            try {
                BundleInstanceResult bundleInstance = AmazonEC2AsyncClient.this.bundleInstance(this.val$bundleInstanceRequest);
                this.val$asyncHandler.onSuccess(this.val$bundleInstanceRequest, bundleInstance);
                return bundleInstance;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.159 */
    class AnonymousClass159 implements Callable<Void> {
        final /* synthetic */ DeletePlacementGroupRequest val$deletePlacementGroupRequest;

        AnonymousClass159(DeletePlacementGroupRequest deletePlacementGroupRequest) {
            this.val$deletePlacementGroupRequest = deletePlacementGroupRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deletePlacementGroup(this.val$deletePlacementGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.15 */
    class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ DeleteSecurityGroupRequest val$deleteSecurityGroupRequest;

        AnonymousClass15(DeleteSecurityGroupRequest deleteSecurityGroupRequest) {
            this.val$deleteSecurityGroupRequest = deleteSecurityGroupRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteSecurityGroup(this.val$deleteSecurityGroupRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.160 */
    class AnonymousClass160 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeletePlacementGroupRequest val$deletePlacementGroupRequest;

        AnonymousClass160(DeletePlacementGroupRequest deletePlacementGroupRequest, AsyncHandler asyncHandler) {
            this.val$deletePlacementGroupRequest = deletePlacementGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deletePlacementGroup(this.val$deletePlacementGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$deletePlacementGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.161 */
    class AnonymousClass161 implements Callable<AllocateAddressResult> {
        final /* synthetic */ AllocateAddressRequest val$allocateAddressRequest;

        AnonymousClass161(AllocateAddressRequest allocateAddressRequest) {
            this.val$allocateAddressRequest = allocateAddressRequest;
        }

        public AllocateAddressResult call() throws Exception {
            return AmazonEC2AsyncClient.this.allocateAddress(this.val$allocateAddressRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.162 */
    class AnonymousClass162 implements Callable<AllocateAddressResult> {
        final /* synthetic */ AllocateAddressRequest val$allocateAddressRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass162(AllocateAddressRequest allocateAddressRequest, AsyncHandler asyncHandler) {
            this.val$allocateAddressRequest = allocateAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public AllocateAddressResult call() throws Exception {
            try {
                AllocateAddressResult allocateAddress = AmazonEC2AsyncClient.this.allocateAddress(this.val$allocateAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$allocateAddressRequest, allocateAddress);
                return allocateAddress;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.163 */
    class AnonymousClass163 implements Callable<Void> {
        final /* synthetic */ ReleaseAddressRequest val$releaseAddressRequest;

        AnonymousClass163(ReleaseAddressRequest releaseAddressRequest) {
            this.val$releaseAddressRequest = releaseAddressRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.releaseAddress(this.val$releaseAddressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.164 */
    class AnonymousClass164 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ReleaseAddressRequest val$releaseAddressRequest;

        AnonymousClass164(ReleaseAddressRequest releaseAddressRequest, AsyncHandler asyncHandler) {
            this.val$releaseAddressRequest = releaseAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.releaseAddress(this.val$releaseAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$releaseAddressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.165 */
    class AnonymousClass165 implements Callable<Void> {
        final /* synthetic */ ResetInstanceAttributeRequest val$resetInstanceAttributeRequest;

        AnonymousClass165(ResetInstanceAttributeRequest resetInstanceAttributeRequest) {
            this.val$resetInstanceAttributeRequest = resetInstanceAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.resetInstanceAttribute(this.val$resetInstanceAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.166 */
    class AnonymousClass166 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ResetInstanceAttributeRequest val$resetInstanceAttributeRequest;

        AnonymousClass166(ResetInstanceAttributeRequest resetInstanceAttributeRequest, AsyncHandler asyncHandler) {
            this.val$resetInstanceAttributeRequest = resetInstanceAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.resetInstanceAttribute(this.val$resetInstanceAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$resetInstanceAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.167 */
    class AnonymousClass167 implements Callable<CreateKeyPairResult> {
        final /* synthetic */ CreateKeyPairRequest val$createKeyPairRequest;

        AnonymousClass167(CreateKeyPairRequest createKeyPairRequest) {
            this.val$createKeyPairRequest = createKeyPairRequest;
        }

        public CreateKeyPairResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createKeyPair(this.val$createKeyPairRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.168 */
    class AnonymousClass168 implements Callable<CreateKeyPairResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateKeyPairRequest val$createKeyPairRequest;

        AnonymousClass168(CreateKeyPairRequest createKeyPairRequest, AsyncHandler asyncHandler) {
            this.val$createKeyPairRequest = createKeyPairRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateKeyPairResult call() throws Exception {
            try {
                CreateKeyPairResult createKeyPair = AmazonEC2AsyncClient.this.createKeyPair(this.val$createKeyPairRequest);
                this.val$asyncHandler.onSuccess(this.val$createKeyPairRequest, createKeyPair);
                return createKeyPair;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.169 */
    class AnonymousClass169 implements Callable<DescribeSnapshotsResult> {
        final /* synthetic */ DescribeSnapshotsRequest val$describeSnapshotsRequest;

        AnonymousClass169(DescribeSnapshotsRequest describeSnapshotsRequest) {
            this.val$describeSnapshotsRequest = describeSnapshotsRequest;
        }

        public DescribeSnapshotsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSnapshots(this.val$describeSnapshotsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.16 */
    class AnonymousClass16 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteSecurityGroupRequest val$deleteSecurityGroupRequest;

        AnonymousClass16(DeleteSecurityGroupRequest deleteSecurityGroupRequest, AsyncHandler asyncHandler) {
            this.val$deleteSecurityGroupRequest = deleteSecurityGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteSecurityGroup(this.val$deleteSecurityGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteSecurityGroupRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.170 */
    class AnonymousClass170 implements Callable<DescribeSnapshotsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSnapshotsRequest val$describeSnapshotsRequest;

        AnonymousClass170(DescribeSnapshotsRequest describeSnapshotsRequest, AsyncHandler asyncHandler) {
            this.val$describeSnapshotsRequest = describeSnapshotsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSnapshotsResult call() throws Exception {
            try {
                DescribeSnapshotsResult describeSnapshots = AmazonEC2AsyncClient.this.describeSnapshots(this.val$describeSnapshotsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSnapshotsRequest, describeSnapshots);
                return describeSnapshots;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.171 */
    class AnonymousClass171 implements Callable<RegisterImageResult> {
        final /* synthetic */ RegisterImageRequest val$registerImageRequest;

        AnonymousClass171(RegisterImageRequest registerImageRequest) {
            this.val$registerImageRequest = registerImageRequest;
        }

        public RegisterImageResult call() throws Exception {
            return AmazonEC2AsyncClient.this.registerImage(this.val$registerImageRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.172 */
    class AnonymousClass172 implements Callable<RegisterImageResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RegisterImageRequest val$registerImageRequest;

        AnonymousClass172(RegisterImageRequest registerImageRequest, AsyncHandler asyncHandler) {
            this.val$registerImageRequest = registerImageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public RegisterImageResult call() throws Exception {
            try {
                RegisterImageResult registerImage = AmazonEC2AsyncClient.this.registerImage(this.val$registerImageRequest);
                this.val$asyncHandler.onSuccess(this.val$registerImageRequest, registerImage);
                return registerImage;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.17 */
    class AnonymousClass17 implements Callable<CreateInstanceExportTaskResult> {
        final /* synthetic */ CreateInstanceExportTaskRequest val$createInstanceExportTaskRequest;

        AnonymousClass17(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) {
            this.val$createInstanceExportTaskRequest = createInstanceExportTaskRequest;
        }

        public CreateInstanceExportTaskResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createInstanceExportTask(this.val$createInstanceExportTaskRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.18 */
    class AnonymousClass18 implements Callable<CreateInstanceExportTaskResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateInstanceExportTaskRequest val$createInstanceExportTaskRequest;

        AnonymousClass18(CreateInstanceExportTaskRequest createInstanceExportTaskRequest, AsyncHandler asyncHandler) {
            this.val$createInstanceExportTaskRequest = createInstanceExportTaskRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateInstanceExportTaskResult call() throws Exception {
            try {
                CreateInstanceExportTaskResult createInstanceExportTask = AmazonEC2AsyncClient.this.createInstanceExportTask(this.val$createInstanceExportTaskRequest);
                this.val$asyncHandler.onSuccess(this.val$createInstanceExportTaskRequest, createInstanceExportTask);
                return createInstanceExportTask;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.19 */
    class AnonymousClass19 implements Callable<GetPasswordDataResult> {
        final /* synthetic */ GetPasswordDataRequest val$getPasswordDataRequest;

        AnonymousClass19(GetPasswordDataRequest getPasswordDataRequest) {
            this.val$getPasswordDataRequest = getPasswordDataRequest;
        }

        public GetPasswordDataResult call() throws Exception {
            return AmazonEC2AsyncClient.this.getPasswordData(this.val$getPasswordDataRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.1 */
    class C00441 implements Callable<Void> {
        final /* synthetic */ RebootInstancesRequest val$rebootInstancesRequest;

        C00441(RebootInstancesRequest rebootInstancesRequest) {
            this.val$rebootInstancesRequest = rebootInstancesRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.rebootInstances(this.val$rebootInstancesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.20 */
    class AnonymousClass20 implements Callable<GetPasswordDataResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetPasswordDataRequest val$getPasswordDataRequest;

        AnonymousClass20(GetPasswordDataRequest getPasswordDataRequest, AsyncHandler asyncHandler) {
            this.val$getPasswordDataRequest = getPasswordDataRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetPasswordDataResult call() throws Exception {
            try {
                GetPasswordDataResult passwordData = AmazonEC2AsyncClient.this.getPasswordData(this.val$getPasswordDataRequest);
                this.val$asyncHandler.onSuccess(this.val$getPasswordDataRequest, passwordData);
                return passwordData;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.21 */
    class AnonymousClass21 implements Callable<StopInstancesResult> {
        final /* synthetic */ StopInstancesRequest val$stopInstancesRequest;

        AnonymousClass21(StopInstancesRequest stopInstancesRequest) {
            this.val$stopInstancesRequest = stopInstancesRequest;
        }

        public StopInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.stopInstances(this.val$stopInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.22 */
    class AnonymousClass22 implements Callable<StopInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ StopInstancesRequest val$stopInstancesRequest;

        AnonymousClass22(StopInstancesRequest stopInstancesRequest, AsyncHandler asyncHandler) {
            this.val$stopInstancesRequest = stopInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public StopInstancesResult call() throws Exception {
            try {
                StopInstancesResult stopInstances = AmazonEC2AsyncClient.this.stopInstances(this.val$stopInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$stopInstancesRequest, stopInstances);
                return stopInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.23 */
    class AnonymousClass23 implements Callable<ImportKeyPairResult> {
        final /* synthetic */ ImportKeyPairRequest val$importKeyPairRequest;

        AnonymousClass23(ImportKeyPairRequest importKeyPairRequest) {
            this.val$importKeyPairRequest = importKeyPairRequest;
        }

        public ImportKeyPairResult call() throws Exception {
            return AmazonEC2AsyncClient.this.importKeyPair(this.val$importKeyPairRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.24 */
    class AnonymousClass24 implements Callable<ImportKeyPairResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ImportKeyPairRequest val$importKeyPairRequest;

        AnonymousClass24(ImportKeyPairRequest importKeyPairRequest, AsyncHandler asyncHandler) {
            this.val$importKeyPairRequest = importKeyPairRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ImportKeyPairResult call() throws Exception {
            try {
                ImportKeyPairResult importKeyPair = AmazonEC2AsyncClient.this.importKeyPair(this.val$importKeyPairRequest);
                this.val$asyncHandler.onSuccess(this.val$importKeyPairRequest, importKeyPair);
                return importKeyPair;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.25 */
    class AnonymousClass25 implements Callable<CreateSecurityGroupResult> {
        final /* synthetic */ CreateSecurityGroupRequest val$createSecurityGroupRequest;

        AnonymousClass25(CreateSecurityGroupRequest createSecurityGroupRequest) {
            this.val$createSecurityGroupRequest = createSecurityGroupRequest;
        }

        public CreateSecurityGroupResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createSecurityGroup(this.val$createSecurityGroupRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.26 */
    class AnonymousClass26 implements Callable<CreateSecurityGroupResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateSecurityGroupRequest val$createSecurityGroupRequest;

        AnonymousClass26(CreateSecurityGroupRequest createSecurityGroupRequest, AsyncHandler asyncHandler) {
            this.val$createSecurityGroupRequest = createSecurityGroupRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateSecurityGroupResult call() throws Exception {
            try {
                CreateSecurityGroupResult createSecurityGroup = AmazonEC2AsyncClient.this.createSecurityGroup(this.val$createSecurityGroupRequest);
                this.val$asyncHandler.onSuccess(this.val$createSecurityGroupRequest, createSecurityGroup);
                return createSecurityGroup;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.27 */
    class AnonymousClass27 implements Callable<DescribeSpotPriceHistoryResult> {
        final /* synthetic */ DescribeSpotPriceHistoryRequest val$describeSpotPriceHistoryRequest;

        AnonymousClass27(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) {
            this.val$describeSpotPriceHistoryRequest = describeSpotPriceHistoryRequest;
        }

        public DescribeSpotPriceHistoryResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSpotPriceHistory(this.val$describeSpotPriceHistoryRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.28 */
    class AnonymousClass28 implements Callable<DescribeSpotPriceHistoryResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSpotPriceHistoryRequest val$describeSpotPriceHistoryRequest;

        AnonymousClass28(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest, AsyncHandler asyncHandler) {
            this.val$describeSpotPriceHistoryRequest = describeSpotPriceHistoryRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSpotPriceHistoryResult call() throws Exception {
            try {
                DescribeSpotPriceHistoryResult describeSpotPriceHistory = AmazonEC2AsyncClient.this.describeSpotPriceHistory(this.val$describeSpotPriceHistoryRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSpotPriceHistoryRequest, describeSpotPriceHistory);
                return describeSpotPriceHistory;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.29 */
    class AnonymousClass29 implements Callable<DescribeRegionsResult> {
        final /* synthetic */ DescribeRegionsRequest val$describeRegionsRequest;

        AnonymousClass29(DescribeRegionsRequest describeRegionsRequest) {
            this.val$describeRegionsRequest = describeRegionsRequest;
        }

        public DescribeRegionsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeRegions(this.val$describeRegionsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.2 */
    class C00452 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RebootInstancesRequest val$rebootInstancesRequest;

        C00452(RebootInstancesRequest rebootInstancesRequest, AsyncHandler asyncHandler) {
            this.val$rebootInstancesRequest = rebootInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.rebootInstances(this.val$rebootInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$rebootInstancesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.30 */
    class AnonymousClass30 implements Callable<DescribeRegionsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeRegionsRequest val$describeRegionsRequest;

        AnonymousClass30(DescribeRegionsRequest describeRegionsRequest, AsyncHandler asyncHandler) {
            this.val$describeRegionsRequest = describeRegionsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeRegionsResult call() throws Exception {
            try {
                DescribeRegionsResult describeRegions = AmazonEC2AsyncClient.this.describeRegions(this.val$describeRegionsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeRegionsRequest, describeRegions);
                return describeRegions;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.31 */
    class AnonymousClass31 implements Callable<CreateReservedInstancesListingResult> {
        final /* synthetic */ CreateReservedInstancesListingRequest val$createReservedInstancesListingRequest;

        AnonymousClass31(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) {
            this.val$createReservedInstancesListingRequest = createReservedInstancesListingRequest;
        }

        public CreateReservedInstancesListingResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createReservedInstancesListing(this.val$createReservedInstancesListingRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.32 */
    class AnonymousClass32 implements Callable<CreateReservedInstancesListingResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateReservedInstancesListingRequest val$createReservedInstancesListingRequest;

        AnonymousClass32(CreateReservedInstancesListingRequest createReservedInstancesListingRequest, AsyncHandler asyncHandler) {
            this.val$createReservedInstancesListingRequest = createReservedInstancesListingRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateReservedInstancesListingResult call() throws Exception {
            try {
                CreateReservedInstancesListingResult createReservedInstancesListing = AmazonEC2AsyncClient.this.createReservedInstancesListing(this.val$createReservedInstancesListingRequest);
                this.val$asyncHandler.onSuccess(this.val$createReservedInstancesListingRequest, createReservedInstancesListing);
                return createReservedInstancesListing;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.33 */
    class AnonymousClass33 implements Callable<Void> {
        final /* synthetic */ ResetSnapshotAttributeRequest val$resetSnapshotAttributeRequest;

        AnonymousClass33(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) {
            this.val$resetSnapshotAttributeRequest = resetSnapshotAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.resetSnapshotAttribute(this.val$resetSnapshotAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.34 */
    class AnonymousClass34 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ResetSnapshotAttributeRequest val$resetSnapshotAttributeRequest;

        AnonymousClass34(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest, AsyncHandler asyncHandler) {
            this.val$resetSnapshotAttributeRequest = resetSnapshotAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.resetSnapshotAttribute(this.val$resetSnapshotAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$resetSnapshotAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.35 */
    class AnonymousClass35 implements Callable<ImportVolumeResult> {
        final /* synthetic */ ImportVolumeRequest val$importVolumeRequest;

        AnonymousClass35(ImportVolumeRequest importVolumeRequest) {
            this.val$importVolumeRequest = importVolumeRequest;
        }

        public ImportVolumeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.importVolume(this.val$importVolumeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.36 */
    class AnonymousClass36 implements Callable<ImportVolumeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ImportVolumeRequest val$importVolumeRequest;

        AnonymousClass36(ImportVolumeRequest importVolumeRequest, AsyncHandler asyncHandler) {
            this.val$importVolumeRequest = importVolumeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ImportVolumeResult call() throws Exception {
            try {
                ImportVolumeResult importVolume = AmazonEC2AsyncClient.this.importVolume(this.val$importVolumeRequest);
                this.val$asyncHandler.onSuccess(this.val$importVolumeRequest, importVolume);
                return importVolume;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.37 */
    class AnonymousClass37 implements Callable<DescribeSecurityGroupsResult> {
        final /* synthetic */ DescribeSecurityGroupsRequest val$describeSecurityGroupsRequest;

        AnonymousClass37(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) {
            this.val$describeSecurityGroupsRequest = describeSecurityGroupsRequest;
        }

        public DescribeSecurityGroupsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSecurityGroups(this.val$describeSecurityGroupsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.38 */
    class AnonymousClass38 implements Callable<DescribeSecurityGroupsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSecurityGroupsRequest val$describeSecurityGroupsRequest;

        AnonymousClass38(DescribeSecurityGroupsRequest describeSecurityGroupsRequest, AsyncHandler asyncHandler) {
            this.val$describeSecurityGroupsRequest = describeSecurityGroupsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSecurityGroupsResult call() throws Exception {
            try {
                DescribeSecurityGroupsResult describeSecurityGroups = AmazonEC2AsyncClient.this.describeSecurityGroups(this.val$describeSecurityGroupsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSecurityGroupsRequest, describeSecurityGroups);
                return describeSecurityGroups;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.39 */
    class AnonymousClass39 implements Callable<Void> {
        final /* synthetic */ DeregisterImageRequest val$deregisterImageRequest;

        AnonymousClass39(DeregisterImageRequest deregisterImageRequest) {
            this.val$deregisterImageRequest = deregisterImageRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deregisterImage(this.val$deregisterImageRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.3 */
    class C00463 implements Callable<DescribeReservedInstancesResult> {
        final /* synthetic */ DescribeReservedInstancesRequest val$describeReservedInstancesRequest;

        C00463(DescribeReservedInstancesRequest describeReservedInstancesRequest) {
            this.val$describeReservedInstancesRequest = describeReservedInstancesRequest;
        }

        public DescribeReservedInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeReservedInstances(this.val$describeReservedInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.40 */
    class AnonymousClass40 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeregisterImageRequest val$deregisterImageRequest;

        AnonymousClass40(DeregisterImageRequest deregisterImageRequest, AsyncHandler asyncHandler) {
            this.val$deregisterImageRequest = deregisterImageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deregisterImage(this.val$deregisterImageRequest);
                this.val$asyncHandler.onSuccess(this.val$deregisterImageRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.41 */
    class AnonymousClass41 implements Callable<DescribeSpotDatafeedSubscriptionResult> {
        final /* synthetic */ DescribeSpotDatafeedSubscriptionRequest val$describeSpotDatafeedSubscriptionRequest;

        AnonymousClass41(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) {
            this.val$describeSpotDatafeedSubscriptionRequest = describeSpotDatafeedSubscriptionRequest;
        }

        public DescribeSpotDatafeedSubscriptionResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeSpotDatafeedSubscription(this.val$describeSpotDatafeedSubscriptionRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.42 */
    class AnonymousClass42 implements Callable<DescribeSpotDatafeedSubscriptionResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeSpotDatafeedSubscriptionRequest val$describeSpotDatafeedSubscriptionRequest;

        AnonymousClass42(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest, AsyncHandler asyncHandler) {
            this.val$describeSpotDatafeedSubscriptionRequest = describeSpotDatafeedSubscriptionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeSpotDatafeedSubscriptionResult call() throws Exception {
            try {
                DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription = AmazonEC2AsyncClient.this.describeSpotDatafeedSubscription(this.val$describeSpotDatafeedSubscriptionRequest);
                this.val$asyncHandler.onSuccess(this.val$describeSpotDatafeedSubscriptionRequest, describeSpotDatafeedSubscription);
                return describeSpotDatafeedSubscription;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.43 */
    class AnonymousClass43 implements Callable<Void> {
        final /* synthetic */ DeleteTagsRequest val$deleteTagsRequest;

        AnonymousClass43(DeleteTagsRequest deleteTagsRequest) {
            this.val$deleteTagsRequest = deleteTagsRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteTags(this.val$deleteTagsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.44 */
    class AnonymousClass44 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteTagsRequest val$deleteTagsRequest;

        AnonymousClass44(DeleteTagsRequest deleteTagsRequest, AsyncHandler asyncHandler) {
            this.val$deleteTagsRequest = deleteTagsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteTags(this.val$deleteTagsRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteTagsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.45 */
    class AnonymousClass45 implements Callable<Void> {
        final /* synthetic */ EnableVolumeIORequest val$enableVolumeIORequest;

        AnonymousClass45(EnableVolumeIORequest enableVolumeIORequest) {
            this.val$enableVolumeIORequest = enableVolumeIORequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.enableVolumeIO(this.val$enableVolumeIORequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.46 */
    class AnonymousClass46 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ EnableVolumeIORequest val$enableVolumeIORequest;

        AnonymousClass46(EnableVolumeIORequest enableVolumeIORequest, AsyncHandler asyncHandler) {
            this.val$enableVolumeIORequest = enableVolumeIORequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.enableVolumeIO(this.val$enableVolumeIORequest);
                this.val$asyncHandler.onSuccess(this.val$enableVolumeIORequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.47 */
    class AnonymousClass47 implements Callable<AttachVolumeResult> {
        final /* synthetic */ AttachVolumeRequest val$attachVolumeRequest;

        AnonymousClass47(AttachVolumeRequest attachVolumeRequest) {
            this.val$attachVolumeRequest = attachVolumeRequest;
        }

        public AttachVolumeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.attachVolume(this.val$attachVolumeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.48 */
    class AnonymousClass48 implements Callable<AttachVolumeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ AttachVolumeRequest val$attachVolumeRequest;

        AnonymousClass48(AttachVolumeRequest attachVolumeRequest, AsyncHandler asyncHandler) {
            this.val$attachVolumeRequest = attachVolumeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public AttachVolumeResult call() throws Exception {
            try {
                AttachVolumeResult attachVolume = AmazonEC2AsyncClient.this.attachVolume(this.val$attachVolumeRequest);
                this.val$asyncHandler.onSuccess(this.val$attachVolumeRequest, attachVolume);
                return attachVolume;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.49 */
    class AnonymousClass49 implements Callable<DescribeLicensesResult> {
        final /* synthetic */ DescribeLicensesRequest val$describeLicensesRequest;

        AnonymousClass49(DescribeLicensesRequest describeLicensesRequest) {
            this.val$describeLicensesRequest = describeLicensesRequest;
        }

        public DescribeLicensesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeLicenses(this.val$describeLicensesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.4 */
    class C00474 implements Callable<DescribeReservedInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeReservedInstancesRequest val$describeReservedInstancesRequest;

        C00474(DescribeReservedInstancesRequest describeReservedInstancesRequest, AsyncHandler asyncHandler) {
            this.val$describeReservedInstancesRequest = describeReservedInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeReservedInstancesResult call() throws Exception {
            try {
                DescribeReservedInstancesResult describeReservedInstances = AmazonEC2AsyncClient.this.describeReservedInstances(this.val$describeReservedInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeReservedInstancesRequest, describeReservedInstances);
                return describeReservedInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.50 */
    class AnonymousClass50 implements Callable<DescribeLicensesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeLicensesRequest val$describeLicensesRequest;

        AnonymousClass50(DescribeLicensesRequest describeLicensesRequest, AsyncHandler asyncHandler) {
            this.val$describeLicensesRequest = describeLicensesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeLicensesResult call() throws Exception {
            try {
                DescribeLicensesResult describeLicenses = AmazonEC2AsyncClient.this.describeLicenses(this.val$describeLicensesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeLicensesRequest, describeLicenses);
                return describeLicenses;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.51 */
    class AnonymousClass51 implements Callable<DescribeVolumeStatusResult> {
        final /* synthetic */ DescribeVolumeStatusRequest val$describeVolumeStatusRequest;

        AnonymousClass51(DescribeVolumeStatusRequest describeVolumeStatusRequest) {
            this.val$describeVolumeStatusRequest = describeVolumeStatusRequest;
        }

        public DescribeVolumeStatusResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeVolumeStatus(this.val$describeVolumeStatusRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.52 */
    class AnonymousClass52 implements Callable<DescribeVolumeStatusResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeVolumeStatusRequest val$describeVolumeStatusRequest;

        AnonymousClass52(DescribeVolumeStatusRequest describeVolumeStatusRequest, AsyncHandler asyncHandler) {
            this.val$describeVolumeStatusRequest = describeVolumeStatusRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeVolumeStatusResult call() throws Exception {
            try {
                DescribeVolumeStatusResult describeVolumeStatus = AmazonEC2AsyncClient.this.describeVolumeStatus(this.val$describeVolumeStatusRequest);
                this.val$asyncHandler.onSuccess(this.val$describeVolumeStatusRequest, describeVolumeStatus);
                return describeVolumeStatus;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.53 */
    class AnonymousClass53 implements Callable<Void> {
        final /* synthetic */ ActivateLicenseRequest val$activateLicenseRequest;

        AnonymousClass53(ActivateLicenseRequest activateLicenseRequest) {
            this.val$activateLicenseRequest = activateLicenseRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.activateLicense(this.val$activateLicenseRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.54 */
    class AnonymousClass54 implements Callable<Void> {
        final /* synthetic */ ActivateLicenseRequest val$activateLicenseRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass54(ActivateLicenseRequest activateLicenseRequest, AsyncHandler asyncHandler) {
            this.val$activateLicenseRequest = activateLicenseRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.activateLicense(this.val$activateLicenseRequest);
                this.val$asyncHandler.onSuccess(this.val$activateLicenseRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.55 */
    class AnonymousClass55 implements Callable<Void> {
        final /* synthetic */ ResetImageAttributeRequest val$resetImageAttributeRequest;

        AnonymousClass55(ResetImageAttributeRequest resetImageAttributeRequest) {
            this.val$resetImageAttributeRequest = resetImageAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.resetImageAttribute(this.val$resetImageAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.56 */
    class AnonymousClass56 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ResetImageAttributeRequest val$resetImageAttributeRequest;

        AnonymousClass56(ResetImageAttributeRequest resetImageAttributeRequest, AsyncHandler asyncHandler) {
            this.val$resetImageAttributeRequest = resetImageAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.resetImageAttribute(this.val$resetImageAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$resetImageAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.57 */
    class AnonymousClass57 implements Callable<CreateSnapshotResult> {
        final /* synthetic */ CreateSnapshotRequest val$createSnapshotRequest;

        AnonymousClass57(CreateSnapshotRequest createSnapshotRequest) {
            this.val$createSnapshotRequest = createSnapshotRequest;
        }

        public CreateSnapshotResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createSnapshot(this.val$createSnapshotRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.58 */
    class AnonymousClass58 implements Callable<CreateSnapshotResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateSnapshotRequest val$createSnapshotRequest;

        AnonymousClass58(CreateSnapshotRequest createSnapshotRequest, AsyncHandler asyncHandler) {
            this.val$createSnapshotRequest = createSnapshotRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateSnapshotResult call() throws Exception {
            try {
                CreateSnapshotResult createSnapshot = AmazonEC2AsyncClient.this.createSnapshot(this.val$createSnapshotRequest);
                this.val$asyncHandler.onSuccess(this.val$createSnapshotRequest, createSnapshot);
                return createSnapshot;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.59 */
    class AnonymousClass59 implements Callable<Void> {
        final /* synthetic */ DeleteVolumeRequest val$deleteVolumeRequest;

        AnonymousClass59(DeleteVolumeRequest deleteVolumeRequest) {
            this.val$deleteVolumeRequest = deleteVolumeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteVolume(this.val$deleteVolumeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.5 */
    class C00485 implements Callable<DescribeAvailabilityZonesResult> {
        final /* synthetic */ DescribeAvailabilityZonesRequest val$describeAvailabilityZonesRequest;

        C00485(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) {
            this.val$describeAvailabilityZonesRequest = describeAvailabilityZonesRequest;
        }

        public DescribeAvailabilityZonesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeAvailabilityZones(this.val$describeAvailabilityZonesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.60 */
    class AnonymousClass60 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteVolumeRequest val$deleteVolumeRequest;

        AnonymousClass60(DeleteVolumeRequest deleteVolumeRequest, AsyncHandler asyncHandler) {
            this.val$deleteVolumeRequest = deleteVolumeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deleteVolume(this.val$deleteVolumeRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteVolumeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.61 */
    class AnonymousClass61 implements Callable<AssociateAddressResult> {
        final /* synthetic */ AssociateAddressRequest val$associateAddressRequest;

        AnonymousClass61(AssociateAddressRequest associateAddressRequest) {
            this.val$associateAddressRequest = associateAddressRequest;
        }

        public AssociateAddressResult call() throws Exception {
            return AmazonEC2AsyncClient.this.associateAddress(this.val$associateAddressRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.62 */
    class AnonymousClass62 implements Callable<AssociateAddressResult> {
        final /* synthetic */ AssociateAddressRequest val$associateAddressRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass62(AssociateAddressRequest associateAddressRequest, AsyncHandler asyncHandler) {
            this.val$associateAddressRequest = associateAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public AssociateAddressResult call() throws Exception {
            try {
                AssociateAddressResult associateAddress = AmazonEC2AsyncClient.this.associateAddress(this.val$associateAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$associateAddressRequest, associateAddress);
                return associateAddress;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.63 */
    class AnonymousClass63 implements Callable<Void> {
        final /* synthetic */ CancelConversionTaskRequest val$cancelConversionTaskRequest;

        AnonymousClass63(CancelConversionTaskRequest cancelConversionTaskRequest) {
            this.val$cancelConversionTaskRequest = cancelConversionTaskRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.cancelConversionTask(this.val$cancelConversionTaskRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.64 */
    class AnonymousClass64 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CancelConversionTaskRequest val$cancelConversionTaskRequest;

        AnonymousClass64(CancelConversionTaskRequest cancelConversionTaskRequest, AsyncHandler asyncHandler) {
            this.val$cancelConversionTaskRequest = cancelConversionTaskRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.cancelConversionTask(this.val$cancelConversionTaskRequest);
                this.val$asyncHandler.onSuccess(this.val$cancelConversionTaskRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.65 */
    class AnonymousClass65 implements Callable<Void> {
        final /* synthetic */ DeactivateLicenseRequest val$deactivateLicenseRequest;

        AnonymousClass65(DeactivateLicenseRequest deactivateLicenseRequest) {
            this.val$deactivateLicenseRequest = deactivateLicenseRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deactivateLicense(this.val$deactivateLicenseRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.66 */
    class AnonymousClass66 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeactivateLicenseRequest val$deactivateLicenseRequest;

        AnonymousClass66(DeactivateLicenseRequest deactivateLicenseRequest, AsyncHandler asyncHandler) {
            this.val$deactivateLicenseRequest = deactivateLicenseRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.deactivateLicense(this.val$deactivateLicenseRequest);
                this.val$asyncHandler.onSuccess(this.val$deactivateLicenseRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.67 */
    class AnonymousClass67 implements Callable<DescribeExportTasksResult> {
        final /* synthetic */ DescribeExportTasksRequest val$describeExportTasksRequest;

        AnonymousClass67(DescribeExportTasksRequest describeExportTasksRequest) {
            this.val$describeExportTasksRequest = describeExportTasksRequest;
        }

        public DescribeExportTasksResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeExportTasks(this.val$describeExportTasksRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.68 */
    class AnonymousClass68 implements Callable<DescribeExportTasksResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeExportTasksRequest val$describeExportTasksRequest;

        AnonymousClass68(DescribeExportTasksRequest describeExportTasksRequest, AsyncHandler asyncHandler) {
            this.val$describeExportTasksRequest = describeExportTasksRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeExportTasksResult call() throws Exception {
            try {
                DescribeExportTasksResult describeExportTasks = AmazonEC2AsyncClient.this.describeExportTasks(this.val$describeExportTasksRequest);
                this.val$asyncHandler.onSuccess(this.val$describeExportTasksRequest, describeExportTasks);
                return describeExportTasks;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.69 */
    class AnonymousClass69 implements Callable<DescribeVolumesResult> {
        final /* synthetic */ DescribeVolumesRequest val$describeVolumesRequest;

        AnonymousClass69(DescribeVolumesRequest describeVolumesRequest) {
            this.val$describeVolumesRequest = describeVolumesRequest;
        }

        public DescribeVolumesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeVolumes(this.val$describeVolumesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.6 */
    class C00496 implements Callable<DescribeAvailabilityZonesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAvailabilityZonesRequest val$describeAvailabilityZonesRequest;

        C00496(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest, AsyncHandler asyncHandler) {
            this.val$describeAvailabilityZonesRequest = describeAvailabilityZonesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAvailabilityZonesResult call() throws Exception {
            try {
                DescribeAvailabilityZonesResult describeAvailabilityZones = AmazonEC2AsyncClient.this.describeAvailabilityZones(this.val$describeAvailabilityZonesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAvailabilityZonesRequest, describeAvailabilityZones);
                return describeAvailabilityZones;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.70 */
    class AnonymousClass70 implements Callable<DescribeVolumesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeVolumesRequest val$describeVolumesRequest;

        AnonymousClass70(DescribeVolumesRequest describeVolumesRequest, AsyncHandler asyncHandler) {
            this.val$describeVolumesRequest = describeVolumesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeVolumesResult call() throws Exception {
            try {
                DescribeVolumesResult describeVolumes = AmazonEC2AsyncClient.this.describeVolumes(this.val$describeVolumesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeVolumesRequest, describeVolumes);
                return describeVolumes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.71 */
    class AnonymousClass71 implements Callable<DescribeReservedInstancesListingsResult> {
        final /* synthetic */ DescribeReservedInstancesListingsRequest val$describeReservedInstancesListingsRequest;

        AnonymousClass71(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) {
            this.val$describeReservedInstancesListingsRequest = describeReservedInstancesListingsRequest;
        }

        public DescribeReservedInstancesListingsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeReservedInstancesListings(this.val$describeReservedInstancesListingsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.72 */
    class AnonymousClass72 implements Callable<DescribeReservedInstancesListingsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeReservedInstancesListingsRequest val$describeReservedInstancesListingsRequest;

        AnonymousClass72(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest, AsyncHandler asyncHandler) {
            this.val$describeReservedInstancesListingsRequest = describeReservedInstancesListingsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeReservedInstancesListingsResult call() throws Exception {
            try {
                DescribeReservedInstancesListingsResult describeReservedInstancesListings = AmazonEC2AsyncClient.this.describeReservedInstancesListings(this.val$describeReservedInstancesListingsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeReservedInstancesListingsRequest, describeReservedInstancesListings);
                return describeReservedInstancesListings;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.73 */
    class AnonymousClass73 implements Callable<Void> {
        final /* synthetic */ ReportInstanceStatusRequest val$reportInstanceStatusRequest;

        AnonymousClass73(ReportInstanceStatusRequest reportInstanceStatusRequest) {
            this.val$reportInstanceStatusRequest = reportInstanceStatusRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.reportInstanceStatus(this.val$reportInstanceStatusRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.74 */
    class AnonymousClass74 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ReportInstanceStatusRequest val$reportInstanceStatusRequest;

        AnonymousClass74(ReportInstanceStatusRequest reportInstanceStatusRequest, AsyncHandler asyncHandler) {
            this.val$reportInstanceStatusRequest = reportInstanceStatusRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.reportInstanceStatus(this.val$reportInstanceStatusRequest);
                this.val$asyncHandler.onSuccess(this.val$reportInstanceStatusRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.75 */
    class AnonymousClass75 implements Callable<MonitorInstancesResult> {
        final /* synthetic */ MonitorInstancesRequest val$monitorInstancesRequest;

        AnonymousClass75(MonitorInstancesRequest monitorInstancesRequest) {
            this.val$monitorInstancesRequest = monitorInstancesRequest;
        }

        public MonitorInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.monitorInstances(this.val$monitorInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.76 */
    class AnonymousClass76 implements Callable<MonitorInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ MonitorInstancesRequest val$monitorInstancesRequest;

        AnonymousClass76(MonitorInstancesRequest monitorInstancesRequest, AsyncHandler asyncHandler) {
            this.val$monitorInstancesRequest = monitorInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public MonitorInstancesResult call() throws Exception {
            try {
                MonitorInstancesResult monitorInstances = AmazonEC2AsyncClient.this.monitorInstances(this.val$monitorInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$monitorInstancesRequest, monitorInstances);
                return monitorInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.77 */
    class AnonymousClass77 implements Callable<DescribeBundleTasksResult> {
        final /* synthetic */ DescribeBundleTasksRequest val$describeBundleTasksRequest;

        AnonymousClass77(DescribeBundleTasksRequest describeBundleTasksRequest) {
            this.val$describeBundleTasksRequest = describeBundleTasksRequest;
        }

        public DescribeBundleTasksResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeBundleTasks(this.val$describeBundleTasksRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.78 */
    class AnonymousClass78 implements Callable<DescribeBundleTasksResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeBundleTasksRequest val$describeBundleTasksRequest;

        AnonymousClass78(DescribeBundleTasksRequest describeBundleTasksRequest, AsyncHandler asyncHandler) {
            this.val$describeBundleTasksRequest = describeBundleTasksRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeBundleTasksResult call() throws Exception {
            try {
                DescribeBundleTasksResult describeBundleTasks = AmazonEC2AsyncClient.this.describeBundleTasks(this.val$describeBundleTasksRequest);
                this.val$asyncHandler.onSuccess(this.val$describeBundleTasksRequest, describeBundleTasks);
                return describeBundleTasks;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.79 */
    class AnonymousClass79 implements Callable<ImportInstanceResult> {
        final /* synthetic */ ImportInstanceRequest val$importInstanceRequest;

        AnonymousClass79(ImportInstanceRequest importInstanceRequest) {
            this.val$importInstanceRequest = importInstanceRequest;
        }

        public ImportInstanceResult call() throws Exception {
            return AmazonEC2AsyncClient.this.importInstance(this.val$importInstanceRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.7 */
    class C00507 implements Callable<DetachVolumeResult> {
        final /* synthetic */ DetachVolumeRequest val$detachVolumeRequest;

        C00507(DetachVolumeRequest detachVolumeRequest) {
            this.val$detachVolumeRequest = detachVolumeRequest;
        }

        public DetachVolumeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.detachVolume(this.val$detachVolumeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.80 */
    class AnonymousClass80 implements Callable<ImportInstanceResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ImportInstanceRequest val$importInstanceRequest;

        AnonymousClass80(ImportInstanceRequest importInstanceRequest, AsyncHandler asyncHandler) {
            this.val$importInstanceRequest = importInstanceRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ImportInstanceResult call() throws Exception {
            try {
                ImportInstanceResult importInstance = AmazonEC2AsyncClient.this.importInstance(this.val$importInstanceRequest);
                this.val$asyncHandler.onSuccess(this.val$importInstanceRequest, importInstance);
                return importInstance;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.81 */
    class AnonymousClass81 implements Callable<Void> {
        final /* synthetic */ RevokeSecurityGroupIngressRequest val$revokeSecurityGroupIngressRequest;

        AnonymousClass81(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) {
            this.val$revokeSecurityGroupIngressRequest = revokeSecurityGroupIngressRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.revokeSecurityGroupIngress(this.val$revokeSecurityGroupIngressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.82 */
    class AnonymousClass82 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RevokeSecurityGroupIngressRequest val$revokeSecurityGroupIngressRequest;

        AnonymousClass82(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest, AsyncHandler asyncHandler) {
            this.val$revokeSecurityGroupIngressRequest = revokeSecurityGroupIngressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.revokeSecurityGroupIngress(this.val$revokeSecurityGroupIngressRequest);
                this.val$asyncHandler.onSuccess(this.val$revokeSecurityGroupIngressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.83 */
    class AnonymousClass83 implements Callable<GetConsoleOutputResult> {
        final /* synthetic */ GetConsoleOutputRequest val$getConsoleOutputRequest;

        AnonymousClass83(GetConsoleOutputRequest getConsoleOutputRequest) {
            this.val$getConsoleOutputRequest = getConsoleOutputRequest;
        }

        public GetConsoleOutputResult call() throws Exception {
            return AmazonEC2AsyncClient.this.getConsoleOutput(this.val$getConsoleOutputRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.84 */
    class AnonymousClass84 implements Callable<GetConsoleOutputResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetConsoleOutputRequest val$getConsoleOutputRequest;

        AnonymousClass84(GetConsoleOutputRequest getConsoleOutputRequest, AsyncHandler asyncHandler) {
            this.val$getConsoleOutputRequest = getConsoleOutputRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetConsoleOutputResult call() throws Exception {
            try {
                GetConsoleOutputResult consoleOutput = AmazonEC2AsyncClient.this.getConsoleOutput(this.val$getConsoleOutputRequest);
                this.val$asyncHandler.onSuccess(this.val$getConsoleOutputRequest, consoleOutput);
                return consoleOutput;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.85 */
    class AnonymousClass85 implements Callable<Void> {
        final /* synthetic */ ModifyImageAttributeRequest val$modifyImageAttributeRequest;

        AnonymousClass85(ModifyImageAttributeRequest modifyImageAttributeRequest) {
            this.val$modifyImageAttributeRequest = modifyImageAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.modifyImageAttribute(this.val$modifyImageAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.86 */
    class AnonymousClass86 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ModifyImageAttributeRequest val$modifyImageAttributeRequest;

        AnonymousClass86(ModifyImageAttributeRequest modifyImageAttributeRequest, AsyncHandler asyncHandler) {
            this.val$modifyImageAttributeRequest = modifyImageAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonEC2AsyncClient.this.modifyImageAttribute(this.val$modifyImageAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$modifyImageAttributeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.87 */
    class AnonymousClass87 implements Callable<CreateSpotDatafeedSubscriptionResult> {
        final /* synthetic */ CreateSpotDatafeedSubscriptionRequest val$createSpotDatafeedSubscriptionRequest;

        AnonymousClass87(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) {
            this.val$createSpotDatafeedSubscriptionRequest = createSpotDatafeedSubscriptionRequest;
        }

        public CreateSpotDatafeedSubscriptionResult call() throws Exception {
            return AmazonEC2AsyncClient.this.createSpotDatafeedSubscription(this.val$createSpotDatafeedSubscriptionRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.88 */
    class AnonymousClass88 implements Callable<CreateSpotDatafeedSubscriptionResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateSpotDatafeedSubscriptionRequest val$createSpotDatafeedSubscriptionRequest;

        AnonymousClass88(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest, AsyncHandler asyncHandler) {
            this.val$createSpotDatafeedSubscriptionRequest = createSpotDatafeedSubscriptionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateSpotDatafeedSubscriptionResult call() throws Exception {
            try {
                CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscription = AmazonEC2AsyncClient.this.createSpotDatafeedSubscription(this.val$createSpotDatafeedSubscriptionRequest);
                this.val$asyncHandler.onSuccess(this.val$createSpotDatafeedSubscriptionRequest, createSpotDatafeedSubscription);
                return createSpotDatafeedSubscription;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.89 */
    class AnonymousClass89 implements Callable<DescribeConversionTasksResult> {
        final /* synthetic */ DescribeConversionTasksRequest val$describeConversionTasksRequest;

        AnonymousClass89(DescribeConversionTasksRequest describeConversionTasksRequest) {
            this.val$describeConversionTasksRequest = describeConversionTasksRequest;
        }

        public DescribeConversionTasksResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeConversionTasks(this.val$describeConversionTasksRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.8 */
    class C00518 implements Callable<DetachVolumeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DetachVolumeRequest val$detachVolumeRequest;

        C00518(DetachVolumeRequest detachVolumeRequest, AsyncHandler asyncHandler) {
            this.val$detachVolumeRequest = detachVolumeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DetachVolumeResult call() throws Exception {
            try {
                DetachVolumeResult detachVolume = AmazonEC2AsyncClient.this.detachVolume(this.val$detachVolumeRequest);
                this.val$asyncHandler.onSuccess(this.val$detachVolumeRequest, detachVolume);
                return detachVolume;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.90 */
    class AnonymousClass90 implements Callable<DescribeConversionTasksResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeConversionTasksRequest val$describeConversionTasksRequest;

        AnonymousClass90(DescribeConversionTasksRequest describeConversionTasksRequest, AsyncHandler asyncHandler) {
            this.val$describeConversionTasksRequest = describeConversionTasksRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeConversionTasksResult call() throws Exception {
            try {
                DescribeConversionTasksResult describeConversionTasks = AmazonEC2AsyncClient.this.describeConversionTasks(this.val$describeConversionTasksRequest);
                this.val$asyncHandler.onSuccess(this.val$describeConversionTasksRequest, describeConversionTasks);
                return describeConversionTasks;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.91 */
    class AnonymousClass91 implements Callable<DescribeInstanceAttributeResult> {
        final /* synthetic */ DescribeInstanceAttributeRequest val$describeInstanceAttributeRequest;

        AnonymousClass91(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) {
            this.val$describeInstanceAttributeRequest = describeInstanceAttributeRequest;
        }

        public DescribeInstanceAttributeResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeInstanceAttribute(this.val$describeInstanceAttributeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.92 */
    class AnonymousClass92 implements Callable<DescribeInstanceAttributeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeInstanceAttributeRequest val$describeInstanceAttributeRequest;

        AnonymousClass92(DescribeInstanceAttributeRequest describeInstanceAttributeRequest, AsyncHandler asyncHandler) {
            this.val$describeInstanceAttributeRequest = describeInstanceAttributeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeInstanceAttributeResult call() throws Exception {
            try {
                DescribeInstanceAttributeResult describeInstanceAttribute = AmazonEC2AsyncClient.this.describeInstanceAttribute(this.val$describeInstanceAttributeRequest);
                this.val$asyncHandler.onSuccess(this.val$describeInstanceAttributeRequest, describeInstanceAttribute);
                return describeInstanceAttribute;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.93 */
    class AnonymousClass93 implements Callable<RunInstancesResult> {
        final /* synthetic */ RunInstancesRequest val$runInstancesRequest;

        AnonymousClass93(RunInstancesRequest runInstancesRequest) {
            this.val$runInstancesRequest = runInstancesRequest;
        }

        public RunInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.runInstances(this.val$runInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.94 */
    class AnonymousClass94 implements Callable<RunInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RunInstancesRequest val$runInstancesRequest;

        AnonymousClass94(RunInstancesRequest runInstancesRequest, AsyncHandler asyncHandler) {
            this.val$runInstancesRequest = runInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public RunInstancesResult call() throws Exception {
            try {
                RunInstancesResult runInstances = AmazonEC2AsyncClient.this.runInstances(this.val$runInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$runInstancesRequest, runInstances);
                return runInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.95 */
    class AnonymousClass95 implements Callable<DescribePlacementGroupsResult> {
        final /* synthetic */ DescribePlacementGroupsRequest val$describePlacementGroupsRequest;

        AnonymousClass95(DescribePlacementGroupsRequest describePlacementGroupsRequest) {
            this.val$describePlacementGroupsRequest = describePlacementGroupsRequest;
        }

        public DescribePlacementGroupsResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describePlacementGroups(this.val$describePlacementGroupsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.96 */
    class AnonymousClass96 implements Callable<DescribePlacementGroupsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribePlacementGroupsRequest val$describePlacementGroupsRequest;

        AnonymousClass96(DescribePlacementGroupsRequest describePlacementGroupsRequest, AsyncHandler asyncHandler) {
            this.val$describePlacementGroupsRequest = describePlacementGroupsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribePlacementGroupsResult call() throws Exception {
            try {
                DescribePlacementGroupsResult describePlacementGroups = AmazonEC2AsyncClient.this.describePlacementGroups(this.val$describePlacementGroupsRequest);
                this.val$asyncHandler.onSuccess(this.val$describePlacementGroupsRequest, describePlacementGroups);
                return describePlacementGroups;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.97 */
    class AnonymousClass97 implements Callable<DescribeInstancesResult> {
        final /* synthetic */ DescribeInstancesRequest val$describeInstancesRequest;

        AnonymousClass97(DescribeInstancesRequest describeInstancesRequest) {
            this.val$describeInstancesRequest = describeInstancesRequest;
        }

        public DescribeInstancesResult call() throws Exception {
            return AmazonEC2AsyncClient.this.describeInstances(this.val$describeInstancesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.98 */
    class AnonymousClass98 implements Callable<DescribeInstancesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeInstancesRequest val$describeInstancesRequest;

        AnonymousClass98(DescribeInstancesRequest describeInstancesRequest, AsyncHandler asyncHandler) {
            this.val$describeInstancesRequest = describeInstancesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeInstancesResult call() throws Exception {
            try {
                DescribeInstancesResult describeInstances = AmazonEC2AsyncClient.this.describeInstances(this.val$describeInstancesRequest);
                this.val$asyncHandler.onSuccess(this.val$describeInstancesRequest, describeInstances);
                return describeInstances;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.99 */
    class AnonymousClass99 implements Callable<Void> {
        final /* synthetic */ ModifyVolumeAttributeRequest val$modifyVolumeAttributeRequest;

        AnonymousClass99(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) {
            this.val$modifyVolumeAttributeRequest = modifyVolumeAttributeRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.modifyVolumeAttribute(this.val$modifyVolumeAttributeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.ec2.AmazonEC2AsyncClient.9 */
    class C00529 implements Callable<Void> {
        final /* synthetic */ DeleteKeyPairRequest val$deleteKeyPairRequest;

        C00529(DeleteKeyPairRequest deleteKeyPairRequest) {
            this.val$deleteKeyPairRequest = deleteKeyPairRequest;
        }

        public Void call() throws Exception {
            AmazonEC2AsyncClient.this.deleteKeyPair(this.val$deleteKeyPairRequest);
            return null;
        }
    }

    public AmazonEC2AsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonEC2AsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonEC2AsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonEC2AsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonEC2AsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonEC2AsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonEC2AsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonEC2AsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> activateLicenseAsync(ActivateLicenseRequest activateLicenseRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass53(activateLicenseRequest));
    }

    public Future<Void> activateLicenseAsync(ActivateLicenseRequest activateLicenseRequest, AsyncHandler<ActivateLicenseRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass54(activateLicenseRequest, asyncHandler));
    }

    public Future<AllocateAddressResult> allocateAddressAsync(AllocateAddressRequest allocateAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass161(allocateAddressRequest));
    }

    public Future<AllocateAddressResult> allocateAddressAsync(AllocateAddressRequest allocateAddressRequest, AsyncHandler<AllocateAddressRequest, AllocateAddressResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass162(allocateAddressRequest, asyncHandler));
    }

    public Future<AssociateAddressResult> associateAddressAsync(AssociateAddressRequest associateAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass61(associateAddressRequest));
    }

    public Future<AssociateAddressResult> associateAddressAsync(AssociateAddressRequest associateAddressRequest, AsyncHandler<AssociateAddressRequest, AssociateAddressResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass62(associateAddressRequest, asyncHandler));
    }

    public Future<AttachVolumeResult> attachVolumeAsync(AttachVolumeRequest attachVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass47(attachVolumeRequest));
    }

    public Future<AttachVolumeResult> attachVolumeAsync(AttachVolumeRequest attachVolumeRequest, AsyncHandler<AttachVolumeRequest, AttachVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass48(attachVolumeRequest, asyncHandler));
    }

    public Future<Void> authorizeSecurityGroupIngressAsync(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass109(authorizeSecurityGroupIngressRequest));
    }

    public Future<Void> authorizeSecurityGroupIngressAsync(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest, AsyncHandler<AuthorizeSecurityGroupIngressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass110(authorizeSecurityGroupIngressRequest, asyncHandler));
    }

    public Future<BundleInstanceResult> bundleInstanceAsync(BundleInstanceRequest bundleInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass157(bundleInstanceRequest));
    }

    public Future<BundleInstanceResult> bundleInstanceAsync(BundleInstanceRequest bundleInstanceRequest, AsyncHandler<BundleInstanceRequest, BundleInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass158(bundleInstanceRequest, asyncHandler));
    }

    public Future<CancelBundleTaskResult> cancelBundleTaskAsync(CancelBundleTaskRequest cancelBundleTaskRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass123(cancelBundleTaskRequest));
    }

    public Future<CancelBundleTaskResult> cancelBundleTaskAsync(CancelBundleTaskRequest cancelBundleTaskRequest, AsyncHandler<CancelBundleTaskRequest, CancelBundleTaskResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass124(cancelBundleTaskRequest, asyncHandler));
    }

    public Future<Void> cancelConversionTaskAsync(CancelConversionTaskRequest cancelConversionTaskRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass63(cancelConversionTaskRequest));
    }

    public Future<Void> cancelConversionTaskAsync(CancelConversionTaskRequest cancelConversionTaskRequest, AsyncHandler<CancelConversionTaskRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass64(cancelConversionTaskRequest, asyncHandler));
    }

    public Future<Void> cancelExportTaskAsync(CancelExportTaskRequest cancelExportTaskRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass113(cancelExportTaskRequest));
    }

    public Future<Void> cancelExportTaskAsync(CancelExportTaskRequest cancelExportTaskRequest, AsyncHandler<CancelExportTaskRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass114(cancelExportTaskRequest, asyncHandler));
    }

    public Future<CancelReservedInstancesListingResult> cancelReservedInstancesListingAsync(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass105(cancelReservedInstancesListingRequest));
    }

    public Future<CancelReservedInstancesListingResult> cancelReservedInstancesListingAsync(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest, AsyncHandler<CancelReservedInstancesListingRequest, CancelReservedInstancesListingResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass106(cancelReservedInstancesListingRequest, asyncHandler));
    }

    public Future<CancelSpotInstanceRequestsResult> cancelSpotInstanceRequestsAsync(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass125(cancelSpotInstanceRequestsRequest));
    }

    public Future<CancelSpotInstanceRequestsResult> cancelSpotInstanceRequestsAsync(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest, AsyncHandler<CancelSpotInstanceRequestsRequest, CancelSpotInstanceRequestsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass126(cancelSpotInstanceRequestsRequest, asyncHandler));
    }

    public Future<ConfirmProductInstanceResult> confirmProductInstanceAsync(ConfirmProductInstanceRequest confirmProductInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass143(confirmProductInstanceRequest));
    }

    public Future<ConfirmProductInstanceResult> confirmProductInstanceAsync(ConfirmProductInstanceRequest confirmProductInstanceRequest, AsyncHandler<ConfirmProductInstanceRequest, ConfirmProductInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass144(confirmProductInstanceRequest, asyncHandler));
    }

    public Future<CreateImageResult> createImageAsync(CreateImageRequest createImageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(createImageRequest));
    }

    public Future<CreateImageResult> createImageAsync(CreateImageRequest createImageRequest, AsyncHandler<CreateImageRequest, CreateImageResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(createImageRequest, asyncHandler));
    }

    public Future<CreateInstanceExportTaskResult> createInstanceExportTaskAsync(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(createInstanceExportTaskRequest));
    }

    public Future<CreateInstanceExportTaskResult> createInstanceExportTaskAsync(CreateInstanceExportTaskRequest createInstanceExportTaskRequest, AsyncHandler<CreateInstanceExportTaskRequest, CreateInstanceExportTaskResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(createInstanceExportTaskRequest, asyncHandler));
    }

    public Future<CreateKeyPairResult> createKeyPairAsync(CreateKeyPairRequest createKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass167(createKeyPairRequest));
    }

    public Future<CreateKeyPairResult> createKeyPairAsync(CreateKeyPairRequest createKeyPairRequest, AsyncHandler<CreateKeyPairRequest, CreateKeyPairResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass168(createKeyPairRequest, asyncHandler));
    }

    public Future<Void> createPlacementGroupAsync(CreatePlacementGroupRequest createPlacementGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass155(createPlacementGroupRequest));
    }

    public Future<Void> createPlacementGroupAsync(CreatePlacementGroupRequest createPlacementGroupRequest, AsyncHandler<CreatePlacementGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass156(createPlacementGroupRequest, asyncHandler));
    }

    public Future<CreateReservedInstancesListingResult> createReservedInstancesListingAsync(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass31(createReservedInstancesListingRequest));
    }

    public Future<CreateReservedInstancesListingResult> createReservedInstancesListingAsync(CreateReservedInstancesListingRequest createReservedInstancesListingRequest, AsyncHandler<CreateReservedInstancesListingRequest, CreateReservedInstancesListingResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass32(createReservedInstancesListingRequest, asyncHandler));
    }

    public Future<CreateSecurityGroupResult> createSecurityGroupAsync(CreateSecurityGroupRequest createSecurityGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(createSecurityGroupRequest));
    }

    public Future<CreateSecurityGroupResult> createSecurityGroupAsync(CreateSecurityGroupRequest createSecurityGroupRequest, AsyncHandler<CreateSecurityGroupRequest, CreateSecurityGroupResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(createSecurityGroupRequest, asyncHandler));
    }

    public Future<CreateSnapshotResult> createSnapshotAsync(CreateSnapshotRequest createSnapshotRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass57(createSnapshotRequest));
    }

    public Future<CreateSnapshotResult> createSnapshotAsync(CreateSnapshotRequest createSnapshotRequest, AsyncHandler<CreateSnapshotRequest, CreateSnapshotResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass58(createSnapshotRequest, asyncHandler));
    }

    public Future<CreateSpotDatafeedSubscriptionResult> createSpotDatafeedSubscriptionAsync(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass87(createSpotDatafeedSubscriptionRequest));
    }

    public Future<CreateSpotDatafeedSubscriptionResult> createSpotDatafeedSubscriptionAsync(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest, AsyncHandler<CreateSpotDatafeedSubscriptionRequest, CreateSpotDatafeedSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass88(createSpotDatafeedSubscriptionRequest, asyncHandler));
    }

    public Future<Void> createTagsAsync(CreateTagsRequest createTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass117(createTagsRequest));
    }

    public Future<Void> createTagsAsync(CreateTagsRequest createTagsRequest, AsyncHandler<CreateTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass118(createTagsRequest, asyncHandler));
    }

    public Future<CreateVolumeResult> createVolumeAsync(CreateVolumeRequest createVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass145(createVolumeRequest));
    }

    public Future<CreateVolumeResult> createVolumeAsync(CreateVolumeRequest createVolumeRequest, AsyncHandler<CreateVolumeRequest, CreateVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass146(createVolumeRequest, asyncHandler));
    }

    public Future<Void> deactivateLicenseAsync(DeactivateLicenseRequest deactivateLicenseRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass65(deactivateLicenseRequest));
    }

    public Future<Void> deactivateLicenseAsync(DeactivateLicenseRequest deactivateLicenseRequest, AsyncHandler<DeactivateLicenseRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass66(deactivateLicenseRequest, asyncHandler));
    }

    public Future<Void> deleteKeyPairAsync(DeleteKeyPairRequest deleteKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00529(deleteKeyPairRequest));
    }

    public Future<Void> deleteKeyPairAsync(DeleteKeyPairRequest deleteKeyPairRequest, AsyncHandler<DeleteKeyPairRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(deleteKeyPairRequest, asyncHandler));
    }

    public Future<Void> deletePlacementGroupAsync(DeletePlacementGroupRequest deletePlacementGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass159(deletePlacementGroupRequest));
    }

    public Future<Void> deletePlacementGroupAsync(DeletePlacementGroupRequest deletePlacementGroupRequest, AsyncHandler<DeletePlacementGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass160(deletePlacementGroupRequest, asyncHandler));
    }

    public Future<Void> deleteSecurityGroupAsync(DeleteSecurityGroupRequest deleteSecurityGroupRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(deleteSecurityGroupRequest));
    }

    public Future<Void> deleteSecurityGroupAsync(DeleteSecurityGroupRequest deleteSecurityGroupRequest, AsyncHandler<DeleteSecurityGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(deleteSecurityGroupRequest, asyncHandler));
    }

    public Future<Void> deleteSnapshotAsync(DeleteSnapshotRequest deleteSnapshotRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass151(deleteSnapshotRequest));
    }

    public Future<Void> deleteSnapshotAsync(DeleteSnapshotRequest deleteSnapshotRequest, AsyncHandler<DeleteSnapshotRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass152(deleteSnapshotRequest, asyncHandler));
    }

    public Future<Void> deleteSpotDatafeedSubscriptionAsync(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass133(deleteSpotDatafeedSubscriptionRequest));
    }

    public Future<Void> deleteSpotDatafeedSubscriptionAsync(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest, AsyncHandler<DeleteSpotDatafeedSubscriptionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass134(deleteSpotDatafeedSubscriptionRequest, asyncHandler));
    }

    public Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass43(deleteTagsRequest));
    }

    public Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest, AsyncHandler<DeleteTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass44(deleteTagsRequest, asyncHandler));
    }

    public Future<Void> deleteVolumeAsync(DeleteVolumeRequest deleteVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass59(deleteVolumeRequest));
    }

    public Future<Void> deleteVolumeAsync(DeleteVolumeRequest deleteVolumeRequest, AsyncHandler<DeleteVolumeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass60(deleteVolumeRequest, asyncHandler));
    }

    public Future<Void> deregisterImageAsync(DeregisterImageRequest deregisterImageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass39(deregisterImageRequest));
    }

    public Future<Void> deregisterImageAsync(DeregisterImageRequest deregisterImageRequest, AsyncHandler<DeregisterImageRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass40(deregisterImageRequest, asyncHandler));
    }

    public Future<DescribeAddressesResult> describeAddressesAsync(DescribeAddressesRequest describeAddressesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass137(describeAddressesRequest));
    }

    public Future<DescribeAddressesResult> describeAddressesAsync(DescribeAddressesRequest describeAddressesRequest, AsyncHandler<DescribeAddressesRequest, DescribeAddressesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass138(describeAddressesRequest, asyncHandler));
    }

    public Future<DescribeAvailabilityZonesResult> describeAvailabilityZonesAsync(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00485(describeAvailabilityZonesRequest));
    }

    public Future<DescribeAvailabilityZonesResult> describeAvailabilityZonesAsync(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest, AsyncHandler<DescribeAvailabilityZonesRequest, DescribeAvailabilityZonesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00496(describeAvailabilityZonesRequest, asyncHandler));
    }

    public Future<DescribeBundleTasksResult> describeBundleTasksAsync(DescribeBundleTasksRequest describeBundleTasksRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass77(describeBundleTasksRequest));
    }

    public Future<DescribeBundleTasksResult> describeBundleTasksAsync(DescribeBundleTasksRequest describeBundleTasksRequest, AsyncHandler<DescribeBundleTasksRequest, DescribeBundleTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass78(describeBundleTasksRequest, asyncHandler));
    }

    public Future<DescribeConversionTasksResult> describeConversionTasksAsync(DescribeConversionTasksRequest describeConversionTasksRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass89(describeConversionTasksRequest));
    }

    public Future<DescribeConversionTasksResult> describeConversionTasksAsync(DescribeConversionTasksRequest describeConversionTasksRequest, AsyncHandler<DescribeConversionTasksRequest, DescribeConversionTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass90(describeConversionTasksRequest, asyncHandler));
    }

    public Future<DescribeExportTasksResult> describeExportTasksAsync(DescribeExportTasksRequest describeExportTasksRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass67(describeExportTasksRequest));
    }

    public Future<DescribeExportTasksResult> describeExportTasksAsync(DescribeExportTasksRequest describeExportTasksRequest, AsyncHandler<DescribeExportTasksRequest, DescribeExportTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass68(describeExportTasksRequest, asyncHandler));
    }

    public Future<DescribeImageAttributeResult> describeImageAttributeAsync(DescribeImageAttributeRequest describeImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass139(describeImageAttributeRequest));
    }

    public Future<DescribeImageAttributeResult> describeImageAttributeAsync(DescribeImageAttributeRequest describeImageAttributeRequest, AsyncHandler<DescribeImageAttributeRequest, DescribeImageAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass140(describeImageAttributeRequest, asyncHandler));
    }

    public Future<DescribeImagesResult> describeImagesAsync(DescribeImagesRequest describeImagesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass101(describeImagesRequest));
    }

    public Future<DescribeImagesResult> describeImagesAsync(DescribeImagesRequest describeImagesRequest, AsyncHandler<DescribeImagesRequest, DescribeImagesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass102(describeImagesRequest, asyncHandler));
    }

    public Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass91(describeInstanceAttributeRequest));
    }

    public Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(DescribeInstanceAttributeRequest describeInstanceAttributeRequest, AsyncHandler<DescribeInstanceAttributeRequest, DescribeInstanceAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass92(describeInstanceAttributeRequest, asyncHandler));
    }

    public Future<DescribeInstanceStatusResult> describeInstanceStatusAsync(DescribeInstanceStatusRequest describeInstanceStatusRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass147(describeInstanceStatusRequest));
    }

    public Future<DescribeInstanceStatusResult> describeInstanceStatusAsync(DescribeInstanceStatusRequest describeInstanceStatusRequest, AsyncHandler<DescribeInstanceStatusRequest, DescribeInstanceStatusResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass148(describeInstanceStatusRequest, asyncHandler));
    }

    public Future<DescribeInstancesResult> describeInstancesAsync(DescribeInstancesRequest describeInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass97(describeInstancesRequest));
    }

    public Future<DescribeInstancesResult> describeInstancesAsync(DescribeInstancesRequest describeInstancesRequest, AsyncHandler<DescribeInstancesRequest, DescribeInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass98(describeInstancesRequest, asyncHandler));
    }

    public Future<DescribeKeyPairsResult> describeKeyPairsAsync(DescribeKeyPairsRequest describeKeyPairsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass141(describeKeyPairsRequest));
    }

    public Future<DescribeKeyPairsResult> describeKeyPairsAsync(DescribeKeyPairsRequest describeKeyPairsRequest, AsyncHandler<DescribeKeyPairsRequest, DescribeKeyPairsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass142(describeKeyPairsRequest, asyncHandler));
    }

    public Future<DescribeLicensesResult> describeLicensesAsync(DescribeLicensesRequest describeLicensesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass49(describeLicensesRequest));
    }

    public Future<DescribeLicensesResult> describeLicensesAsync(DescribeLicensesRequest describeLicensesRequest, AsyncHandler<DescribeLicensesRequest, DescribeLicensesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass50(describeLicensesRequest, asyncHandler));
    }

    public Future<DescribePlacementGroupsResult> describePlacementGroupsAsync(DescribePlacementGroupsRequest describePlacementGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass95(describePlacementGroupsRequest));
    }

    public Future<DescribePlacementGroupsResult> describePlacementGroupsAsync(DescribePlacementGroupsRequest describePlacementGroupsRequest, AsyncHandler<DescribePlacementGroupsRequest, DescribePlacementGroupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass96(describePlacementGroupsRequest, asyncHandler));
    }

    public Future<DescribeRegionsResult> describeRegionsAsync(DescribeRegionsRequest describeRegionsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(describeRegionsRequest));
    }

    public Future<DescribeRegionsResult> describeRegionsAsync(DescribeRegionsRequest describeRegionsRequest, AsyncHandler<DescribeRegionsRequest, DescribeRegionsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(describeRegionsRequest, asyncHandler));
    }

    public Future<DescribeReservedInstancesResult> describeReservedInstancesAsync(DescribeReservedInstancesRequest describeReservedInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00463(describeReservedInstancesRequest));
    }

    public Future<DescribeReservedInstancesResult> describeReservedInstancesAsync(DescribeReservedInstancesRequest describeReservedInstancesRequest, AsyncHandler<DescribeReservedInstancesRequest, DescribeReservedInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00474(describeReservedInstancesRequest, asyncHandler));
    }

    public Future<DescribeReservedInstancesListingsResult> describeReservedInstancesListingsAsync(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass71(describeReservedInstancesListingsRequest));
    }

    public Future<DescribeReservedInstancesListingsResult> describeReservedInstancesListingsAsync(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest, AsyncHandler<DescribeReservedInstancesListingsRequest, DescribeReservedInstancesListingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass72(describeReservedInstancesListingsRequest, asyncHandler));
    }

    public Future<DescribeReservedInstancesOfferingsResult> describeReservedInstancesOfferingsAsync(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass149(describeReservedInstancesOfferingsRequest));
    }

    public Future<DescribeReservedInstancesOfferingsResult> describeReservedInstancesOfferingsAsync(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest, AsyncHandler<DescribeReservedInstancesOfferingsRequest, DescribeReservedInstancesOfferingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass150(describeReservedInstancesOfferingsRequest, asyncHandler));
    }

    public Future<DescribeSecurityGroupsResult> describeSecurityGroupsAsync(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass37(describeSecurityGroupsRequest));
    }

    public Future<DescribeSecurityGroupsResult> describeSecurityGroupsAsync(DescribeSecurityGroupsRequest describeSecurityGroupsRequest, AsyncHandler<DescribeSecurityGroupsRequest, DescribeSecurityGroupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass38(describeSecurityGroupsRequest, asyncHandler));
    }

    public Future<DescribeSnapshotAttributeResult> describeSnapshotAttributeAsync(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass135(describeSnapshotAttributeRequest));
    }

    public Future<DescribeSnapshotAttributeResult> describeSnapshotAttributeAsync(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest, AsyncHandler<DescribeSnapshotAttributeRequest, DescribeSnapshotAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass136(describeSnapshotAttributeRequest, asyncHandler));
    }

    public Future<DescribeSnapshotsResult> describeSnapshotsAsync(DescribeSnapshotsRequest describeSnapshotsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass169(describeSnapshotsRequest));
    }

    public Future<DescribeSnapshotsResult> describeSnapshotsAsync(DescribeSnapshotsRequest describeSnapshotsRequest, AsyncHandler<DescribeSnapshotsRequest, DescribeSnapshotsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass170(describeSnapshotsRequest, asyncHandler));
    }

    public Future<DescribeSpotDatafeedSubscriptionResult> describeSpotDatafeedSubscriptionAsync(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass41(describeSpotDatafeedSubscriptionRequest));
    }

    public Future<DescribeSpotDatafeedSubscriptionResult> describeSpotDatafeedSubscriptionAsync(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest, AsyncHandler<DescribeSpotDatafeedSubscriptionRequest, DescribeSpotDatafeedSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass42(describeSpotDatafeedSubscriptionRequest, asyncHandler));
    }

    public Future<DescribeSpotInstanceRequestsResult> describeSpotInstanceRequestsAsync(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass111(describeSpotInstanceRequestsRequest));
    }

    public Future<DescribeSpotInstanceRequestsResult> describeSpotInstanceRequestsAsync(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest, AsyncHandler<DescribeSpotInstanceRequestsRequest, DescribeSpotInstanceRequestsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass112(describeSpotInstanceRequestsRequest, asyncHandler));
    }

    public Future<DescribeSpotPriceHistoryResult> describeSpotPriceHistoryAsync(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(describeSpotPriceHistoryRequest));
    }

    public Future<DescribeSpotPriceHistoryResult> describeSpotPriceHistoryAsync(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest, AsyncHandler<DescribeSpotPriceHistoryRequest, DescribeSpotPriceHistoryResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(describeSpotPriceHistoryRequest, asyncHandler));
    }

    public Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass121(describeTagsRequest));
    }

    public Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest, AsyncHandler<DescribeTagsRequest, DescribeTagsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass122(describeTagsRequest, asyncHandler));
    }

    public Future<DescribeVolumeAttributeResult> describeVolumeAttributeAsync(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass119(describeVolumeAttributeRequest));
    }

    public Future<DescribeVolumeAttributeResult> describeVolumeAttributeAsync(DescribeVolumeAttributeRequest describeVolumeAttributeRequest, AsyncHandler<DescribeVolumeAttributeRequest, DescribeVolumeAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass120(describeVolumeAttributeRequest, asyncHandler));
    }

    public Future<DescribeVolumeStatusResult> describeVolumeStatusAsync(DescribeVolumeStatusRequest describeVolumeStatusRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass51(describeVolumeStatusRequest));
    }

    public Future<DescribeVolumeStatusResult> describeVolumeStatusAsync(DescribeVolumeStatusRequest describeVolumeStatusRequest, AsyncHandler<DescribeVolumeStatusRequest, DescribeVolumeStatusResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass52(describeVolumeStatusRequest, asyncHandler));
    }

    public Future<DescribeVolumesResult> describeVolumesAsync(DescribeVolumesRequest describeVolumesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass69(describeVolumesRequest));
    }

    public Future<DescribeVolumesResult> describeVolumesAsync(DescribeVolumesRequest describeVolumesRequest, AsyncHandler<DescribeVolumesRequest, DescribeVolumesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass70(describeVolumesRequest, asyncHandler));
    }

    public Future<DetachVolumeResult> detachVolumeAsync(DetachVolumeRequest detachVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00507(detachVolumeRequest));
    }

    public Future<DetachVolumeResult> detachVolumeAsync(DetachVolumeRequest detachVolumeRequest, AsyncHandler<DetachVolumeRequest, DetachVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00518(detachVolumeRequest, asyncHandler));
    }

    public Future<Void> disassociateAddressAsync(DisassociateAddressRequest disassociateAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass153(disassociateAddressRequest));
    }

    public Future<Void> disassociateAddressAsync(DisassociateAddressRequest disassociateAddressRequest, AsyncHandler<DisassociateAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass154(disassociateAddressRequest, asyncHandler));
    }

    public Future<Void> enableVolumeIOAsync(EnableVolumeIORequest enableVolumeIORequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass45(enableVolumeIORequest));
    }

    public Future<Void> enableVolumeIOAsync(EnableVolumeIORequest enableVolumeIORequest, AsyncHandler<EnableVolumeIORequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass46(enableVolumeIORequest, asyncHandler));
    }

    public Future<GetConsoleOutputResult> getConsoleOutputAsync(GetConsoleOutputRequest getConsoleOutputRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass83(getConsoleOutputRequest));
    }

    public Future<GetConsoleOutputResult> getConsoleOutputAsync(GetConsoleOutputRequest getConsoleOutputRequest, AsyncHandler<GetConsoleOutputRequest, GetConsoleOutputResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass84(getConsoleOutputRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetPasswordDataResult> getPasswordDataAsync(GetPasswordDataRequest getPasswordDataRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(getPasswordDataRequest));
    }

    public Future<GetPasswordDataResult> getPasswordDataAsync(GetPasswordDataRequest getPasswordDataRequest, AsyncHandler<GetPasswordDataRequest, GetPasswordDataResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(getPasswordDataRequest, asyncHandler));
    }

    public Future<ImportInstanceResult> importInstanceAsync(ImportInstanceRequest importInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass79(importInstanceRequest));
    }

    public Future<ImportInstanceResult> importInstanceAsync(ImportInstanceRequest importInstanceRequest, AsyncHandler<ImportInstanceRequest, ImportInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass80(importInstanceRequest, asyncHandler));
    }

    public Future<ImportKeyPairResult> importKeyPairAsync(ImportKeyPairRequest importKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(importKeyPairRequest));
    }

    public Future<ImportKeyPairResult> importKeyPairAsync(ImportKeyPairRequest importKeyPairRequest, AsyncHandler<ImportKeyPairRequest, ImportKeyPairResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(importKeyPairRequest, asyncHandler));
    }

    public Future<ImportVolumeResult> importVolumeAsync(ImportVolumeRequest importVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass35(importVolumeRequest));
    }

    public Future<ImportVolumeResult> importVolumeAsync(ImportVolumeRequest importVolumeRequest, AsyncHandler<ImportVolumeRequest, ImportVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass36(importVolumeRequest, asyncHandler));
    }

    public Future<Void> modifyImageAttributeAsync(ModifyImageAttributeRequest modifyImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass85(modifyImageAttributeRequest));
    }

    public Future<Void> modifyImageAttributeAsync(ModifyImageAttributeRequest modifyImageAttributeRequest, AsyncHandler<ModifyImageAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass86(modifyImageAttributeRequest, asyncHandler));
    }

    public Future<Void> modifyInstanceAttributeAsync(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass107(modifyInstanceAttributeRequest));
    }

    public Future<Void> modifyInstanceAttributeAsync(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest, AsyncHandler<ModifyInstanceAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass108(modifyInstanceAttributeRequest, asyncHandler));
    }

    public Future<Void> modifySnapshotAttributeAsync(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass129(modifySnapshotAttributeRequest));
    }

    public Future<Void> modifySnapshotAttributeAsync(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest, AsyncHandler<ModifySnapshotAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass130(modifySnapshotAttributeRequest, asyncHandler));
    }

    public Future<Void> modifyVolumeAttributeAsync(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass99(modifyVolumeAttributeRequest));
    }

    public Future<Void> modifyVolumeAttributeAsync(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest, AsyncHandler<ModifyVolumeAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass100(modifyVolumeAttributeRequest, asyncHandler));
    }

    public Future<MonitorInstancesResult> monitorInstancesAsync(MonitorInstancesRequest monitorInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass75(monitorInstancesRequest));
    }

    public Future<MonitorInstancesResult> monitorInstancesAsync(MonitorInstancesRequest monitorInstancesRequest, AsyncHandler<MonitorInstancesRequest, MonitorInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass76(monitorInstancesRequest, asyncHandler));
    }

    public Future<PurchaseReservedInstancesOfferingResult> purchaseReservedInstancesOfferingAsync(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass127(purchaseReservedInstancesOfferingRequest));
    }

    public Future<PurchaseReservedInstancesOfferingResult> purchaseReservedInstancesOfferingAsync(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest, AsyncHandler<PurchaseReservedInstancesOfferingRequest, PurchaseReservedInstancesOfferingResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass128(purchaseReservedInstancesOfferingRequest, asyncHandler));
    }

    public Future<Void> rebootInstancesAsync(RebootInstancesRequest rebootInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00441(rebootInstancesRequest));
    }

    public Future<Void> rebootInstancesAsync(RebootInstancesRequest rebootInstancesRequest, AsyncHandler<RebootInstancesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00452(rebootInstancesRequest, asyncHandler));
    }

    public Future<RegisterImageResult> registerImageAsync(RegisterImageRequest registerImageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass171(registerImageRequest));
    }

    public Future<RegisterImageResult> registerImageAsync(RegisterImageRequest registerImageRequest, AsyncHandler<RegisterImageRequest, RegisterImageResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass172(registerImageRequest, asyncHandler));
    }

    public Future<Void> releaseAddressAsync(ReleaseAddressRequest releaseAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass163(releaseAddressRequest));
    }

    public Future<Void> releaseAddressAsync(ReleaseAddressRequest releaseAddressRequest, AsyncHandler<ReleaseAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass164(releaseAddressRequest, asyncHandler));
    }

    public Future<Void> reportInstanceStatusAsync(ReportInstanceStatusRequest reportInstanceStatusRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass73(reportInstanceStatusRequest));
    }

    public Future<Void> reportInstanceStatusAsync(ReportInstanceStatusRequest reportInstanceStatusRequest, AsyncHandler<ReportInstanceStatusRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass74(reportInstanceStatusRequest, asyncHandler));
    }

    public Future<RequestSpotInstancesResult> requestSpotInstancesAsync(RequestSpotInstancesRequest requestSpotInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass115(requestSpotInstancesRequest));
    }

    public Future<RequestSpotInstancesResult> requestSpotInstancesAsync(RequestSpotInstancesRequest requestSpotInstancesRequest, AsyncHandler<RequestSpotInstancesRequest, RequestSpotInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass116(requestSpotInstancesRequest, asyncHandler));
    }

    public Future<Void> resetImageAttributeAsync(ResetImageAttributeRequest resetImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass55(resetImageAttributeRequest));
    }

    public Future<Void> resetImageAttributeAsync(ResetImageAttributeRequest resetImageAttributeRequest, AsyncHandler<ResetImageAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass56(resetImageAttributeRequest, asyncHandler));
    }

    public Future<Void> resetInstanceAttributeAsync(ResetInstanceAttributeRequest resetInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass165(resetInstanceAttributeRequest));
    }

    public Future<Void> resetInstanceAttributeAsync(ResetInstanceAttributeRequest resetInstanceAttributeRequest, AsyncHandler<ResetInstanceAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass166(resetInstanceAttributeRequest, asyncHandler));
    }

    public Future<Void> resetSnapshotAttributeAsync(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass33(resetSnapshotAttributeRequest));
    }

    public Future<Void> resetSnapshotAttributeAsync(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest, AsyncHandler<ResetSnapshotAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass34(resetSnapshotAttributeRequest, asyncHandler));
    }

    public Future<Void> revokeSecurityGroupIngressAsync(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass81(revokeSecurityGroupIngressRequest));
    }

    public Future<Void> revokeSecurityGroupIngressAsync(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest, AsyncHandler<RevokeSecurityGroupIngressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass82(revokeSecurityGroupIngressRequest, asyncHandler));
    }

    public Future<RunInstancesResult> runInstancesAsync(RunInstancesRequest runInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass93(runInstancesRequest));
    }

    public Future<RunInstancesResult> runInstancesAsync(RunInstancesRequest runInstancesRequest, AsyncHandler<RunInstancesRequest, RunInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass94(runInstancesRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<StartInstancesResult> startInstancesAsync(StartInstancesRequest startInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass103(startInstancesRequest));
    }

    public Future<StartInstancesResult> startInstancesAsync(StartInstancesRequest startInstancesRequest, AsyncHandler<StartInstancesRequest, StartInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass104(startInstancesRequest, asyncHandler));
    }

    public Future<StopInstancesResult> stopInstancesAsync(StopInstancesRequest stopInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(stopInstancesRequest));
    }

    public Future<StopInstancesResult> stopInstancesAsync(StopInstancesRequest stopInstancesRequest, AsyncHandler<StopInstancesRequest, StopInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(stopInstancesRequest, asyncHandler));
    }

    public Future<TerminateInstancesResult> terminateInstancesAsync(TerminateInstancesRequest terminateInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass131(terminateInstancesRequest));
    }

    public Future<TerminateInstancesResult> terminateInstancesAsync(TerminateInstancesRequest terminateInstancesRequest, AsyncHandler<TerminateInstancesRequest, TerminateInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass132(terminateInstancesRequest, asyncHandler));
    }

    public Future<UnmonitorInstancesResult> unmonitorInstancesAsync(UnmonitorInstancesRequest unmonitorInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(unmonitorInstancesRequest));
    }

    public Future<UnmonitorInstancesResult> unmonitorInstancesAsync(UnmonitorInstancesRequest unmonitorInstancesRequest, AsyncHandler<UnmonitorInstancesRequest, UnmonitorInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(unmonitorInstancesRequest, asyncHandler));
    }
}
