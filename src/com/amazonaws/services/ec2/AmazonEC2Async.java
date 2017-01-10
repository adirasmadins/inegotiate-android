package com.amazonaws.services.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
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
import java.util.concurrent.Future;

public interface AmazonEC2Async extends AmazonEC2 {
    Future<Void> activateLicenseAsync(ActivateLicenseRequest activateLicenseRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> activateLicenseAsync(ActivateLicenseRequest activateLicenseRequest, AsyncHandler<ActivateLicenseRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<AllocateAddressResult> allocateAddressAsync(AllocateAddressRequest allocateAddressRequest) throws AmazonServiceException, AmazonClientException;

    Future<AllocateAddressResult> allocateAddressAsync(AllocateAddressRequest allocateAddressRequest, AsyncHandler<AllocateAddressRequest, AllocateAddressResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<AssociateAddressResult> associateAddressAsync(AssociateAddressRequest associateAddressRequest) throws AmazonServiceException, AmazonClientException;

    Future<AssociateAddressResult> associateAddressAsync(AssociateAddressRequest associateAddressRequest, AsyncHandler<AssociateAddressRequest, AssociateAddressResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<AttachVolumeResult> attachVolumeAsync(AttachVolumeRequest attachVolumeRequest) throws AmazonServiceException, AmazonClientException;

    Future<AttachVolumeResult> attachVolumeAsync(AttachVolumeRequest attachVolumeRequest, AsyncHandler<AttachVolumeRequest, AttachVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> authorizeSecurityGroupIngressAsync(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> authorizeSecurityGroupIngressAsync(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest, AsyncHandler<AuthorizeSecurityGroupIngressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<BundleInstanceResult> bundleInstanceAsync(BundleInstanceRequest bundleInstanceRequest) throws AmazonServiceException, AmazonClientException;

    Future<BundleInstanceResult> bundleInstanceAsync(BundleInstanceRequest bundleInstanceRequest, AsyncHandler<BundleInstanceRequest, BundleInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CancelBundleTaskResult> cancelBundleTaskAsync(CancelBundleTaskRequest cancelBundleTaskRequest) throws AmazonServiceException, AmazonClientException;

    Future<CancelBundleTaskResult> cancelBundleTaskAsync(CancelBundleTaskRequest cancelBundleTaskRequest, AsyncHandler<CancelBundleTaskRequest, CancelBundleTaskResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> cancelConversionTaskAsync(CancelConversionTaskRequest cancelConversionTaskRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> cancelConversionTaskAsync(CancelConversionTaskRequest cancelConversionTaskRequest, AsyncHandler<CancelConversionTaskRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> cancelExportTaskAsync(CancelExportTaskRequest cancelExportTaskRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> cancelExportTaskAsync(CancelExportTaskRequest cancelExportTaskRequest, AsyncHandler<CancelExportTaskRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CancelReservedInstancesListingResult> cancelReservedInstancesListingAsync(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException;

    Future<CancelReservedInstancesListingResult> cancelReservedInstancesListingAsync(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest, AsyncHandler<CancelReservedInstancesListingRequest, CancelReservedInstancesListingResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CancelSpotInstanceRequestsResult> cancelSpotInstanceRequestsAsync(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException;

    Future<CancelSpotInstanceRequestsResult> cancelSpotInstanceRequestsAsync(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest, AsyncHandler<CancelSpotInstanceRequestsRequest, CancelSpotInstanceRequestsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ConfirmProductInstanceResult> confirmProductInstanceAsync(ConfirmProductInstanceRequest confirmProductInstanceRequest) throws AmazonServiceException, AmazonClientException;

    Future<ConfirmProductInstanceResult> confirmProductInstanceAsync(ConfirmProductInstanceRequest confirmProductInstanceRequest, AsyncHandler<ConfirmProductInstanceRequest, ConfirmProductInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateImageResult> createImageAsync(CreateImageRequest createImageRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateImageResult> createImageAsync(CreateImageRequest createImageRequest, AsyncHandler<CreateImageRequest, CreateImageResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateInstanceExportTaskResult> createInstanceExportTaskAsync(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateInstanceExportTaskResult> createInstanceExportTaskAsync(CreateInstanceExportTaskRequest createInstanceExportTaskRequest, AsyncHandler<CreateInstanceExportTaskRequest, CreateInstanceExportTaskResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateKeyPairResult> createKeyPairAsync(CreateKeyPairRequest createKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateKeyPairResult> createKeyPairAsync(CreateKeyPairRequest createKeyPairRequest, AsyncHandler<CreateKeyPairRequest, CreateKeyPairResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> createPlacementGroupAsync(CreatePlacementGroupRequest createPlacementGroupRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> createPlacementGroupAsync(CreatePlacementGroupRequest createPlacementGroupRequest, AsyncHandler<CreatePlacementGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateReservedInstancesListingResult> createReservedInstancesListingAsync(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateReservedInstancesListingResult> createReservedInstancesListingAsync(CreateReservedInstancesListingRequest createReservedInstancesListingRequest, AsyncHandler<CreateReservedInstancesListingRequest, CreateReservedInstancesListingResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateSecurityGroupResult> createSecurityGroupAsync(CreateSecurityGroupRequest createSecurityGroupRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateSecurityGroupResult> createSecurityGroupAsync(CreateSecurityGroupRequest createSecurityGroupRequest, AsyncHandler<CreateSecurityGroupRequest, CreateSecurityGroupResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateSnapshotResult> createSnapshotAsync(CreateSnapshotRequest createSnapshotRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateSnapshotResult> createSnapshotAsync(CreateSnapshotRequest createSnapshotRequest, AsyncHandler<CreateSnapshotRequest, CreateSnapshotResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateSpotDatafeedSubscriptionResult> createSpotDatafeedSubscriptionAsync(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateSpotDatafeedSubscriptionResult> createSpotDatafeedSubscriptionAsync(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest, AsyncHandler<CreateSpotDatafeedSubscriptionRequest, CreateSpotDatafeedSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> createTagsAsync(CreateTagsRequest createTagsRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> createTagsAsync(CreateTagsRequest createTagsRequest, AsyncHandler<CreateTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateVolumeResult> createVolumeAsync(CreateVolumeRequest createVolumeRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateVolumeResult> createVolumeAsync(CreateVolumeRequest createVolumeRequest, AsyncHandler<CreateVolumeRequest, CreateVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deactivateLicenseAsync(DeactivateLicenseRequest deactivateLicenseRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deactivateLicenseAsync(DeactivateLicenseRequest deactivateLicenseRequest, AsyncHandler<DeactivateLicenseRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteKeyPairAsync(DeleteKeyPairRequest deleteKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteKeyPairAsync(DeleteKeyPairRequest deleteKeyPairRequest, AsyncHandler<DeleteKeyPairRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deletePlacementGroupAsync(DeletePlacementGroupRequest deletePlacementGroupRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deletePlacementGroupAsync(DeletePlacementGroupRequest deletePlacementGroupRequest, AsyncHandler<DeletePlacementGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSecurityGroupAsync(DeleteSecurityGroupRequest deleteSecurityGroupRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSecurityGroupAsync(DeleteSecurityGroupRequest deleteSecurityGroupRequest, AsyncHandler<DeleteSecurityGroupRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSnapshotAsync(DeleteSnapshotRequest deleteSnapshotRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSnapshotAsync(DeleteSnapshotRequest deleteSnapshotRequest, AsyncHandler<DeleteSnapshotRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSpotDatafeedSubscriptionAsync(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteSpotDatafeedSubscriptionAsync(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest, AsyncHandler<DeleteSpotDatafeedSubscriptionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteTagsAsync(DeleteTagsRequest deleteTagsRequest, AsyncHandler<DeleteTagsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteVolumeAsync(DeleteVolumeRequest deleteVolumeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteVolumeAsync(DeleteVolumeRequest deleteVolumeRequest, AsyncHandler<DeleteVolumeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deregisterImageAsync(DeregisterImageRequest deregisterImageRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deregisterImageAsync(DeregisterImageRequest deregisterImageRequest, AsyncHandler<DeregisterImageRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAddressesResult> describeAddressesAsync(DescribeAddressesRequest describeAddressesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAddressesResult> describeAddressesAsync(DescribeAddressesRequest describeAddressesRequest, AsyncHandler<DescribeAddressesRequest, DescribeAddressesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAvailabilityZonesResult> describeAvailabilityZonesAsync(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAvailabilityZonesResult> describeAvailabilityZonesAsync(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest, AsyncHandler<DescribeAvailabilityZonesRequest, DescribeAvailabilityZonesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeBundleTasksResult> describeBundleTasksAsync(DescribeBundleTasksRequest describeBundleTasksRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeBundleTasksResult> describeBundleTasksAsync(DescribeBundleTasksRequest describeBundleTasksRequest, AsyncHandler<DescribeBundleTasksRequest, DescribeBundleTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeConversionTasksResult> describeConversionTasksAsync(DescribeConversionTasksRequest describeConversionTasksRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeConversionTasksResult> describeConversionTasksAsync(DescribeConversionTasksRequest describeConversionTasksRequest, AsyncHandler<DescribeConversionTasksRequest, DescribeConversionTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeExportTasksResult> describeExportTasksAsync(DescribeExportTasksRequest describeExportTasksRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeExportTasksResult> describeExportTasksAsync(DescribeExportTasksRequest describeExportTasksRequest, AsyncHandler<DescribeExportTasksRequest, DescribeExportTasksResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeImageAttributeResult> describeImageAttributeAsync(DescribeImageAttributeRequest describeImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeImageAttributeResult> describeImageAttributeAsync(DescribeImageAttributeRequest describeImageAttributeRequest, AsyncHandler<DescribeImageAttributeRequest, DescribeImageAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeImagesResult> describeImagesAsync(DescribeImagesRequest describeImagesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeImagesResult> describeImagesAsync(DescribeImagesRequest describeImagesRequest, AsyncHandler<DescribeImagesRequest, DescribeImagesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstanceAttributeResult> describeInstanceAttributeAsync(DescribeInstanceAttributeRequest describeInstanceAttributeRequest, AsyncHandler<DescribeInstanceAttributeRequest, DescribeInstanceAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstanceStatusResult> describeInstanceStatusAsync(DescribeInstanceStatusRequest describeInstanceStatusRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstanceStatusResult> describeInstanceStatusAsync(DescribeInstanceStatusRequest describeInstanceStatusRequest, AsyncHandler<DescribeInstanceStatusRequest, DescribeInstanceStatusResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstancesResult> describeInstancesAsync(DescribeInstancesRequest describeInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeInstancesResult> describeInstancesAsync(DescribeInstancesRequest describeInstancesRequest, AsyncHandler<DescribeInstancesRequest, DescribeInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeKeyPairsResult> describeKeyPairsAsync(DescribeKeyPairsRequest describeKeyPairsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeKeyPairsResult> describeKeyPairsAsync(DescribeKeyPairsRequest describeKeyPairsRequest, AsyncHandler<DescribeKeyPairsRequest, DescribeKeyPairsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeLicensesResult> describeLicensesAsync(DescribeLicensesRequest describeLicensesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeLicensesResult> describeLicensesAsync(DescribeLicensesRequest describeLicensesRequest, AsyncHandler<DescribeLicensesRequest, DescribeLicensesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribePlacementGroupsResult> describePlacementGroupsAsync(DescribePlacementGroupsRequest describePlacementGroupsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribePlacementGroupsResult> describePlacementGroupsAsync(DescribePlacementGroupsRequest describePlacementGroupsRequest, AsyncHandler<DescribePlacementGroupsRequest, DescribePlacementGroupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeRegionsResult> describeRegionsAsync(DescribeRegionsRequest describeRegionsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeRegionsResult> describeRegionsAsync(DescribeRegionsRequest describeRegionsRequest, AsyncHandler<DescribeRegionsRequest, DescribeRegionsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesResult> describeReservedInstancesAsync(DescribeReservedInstancesRequest describeReservedInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesResult> describeReservedInstancesAsync(DescribeReservedInstancesRequest describeReservedInstancesRequest, AsyncHandler<DescribeReservedInstancesRequest, DescribeReservedInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesListingsResult> describeReservedInstancesListingsAsync(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesListingsResult> describeReservedInstancesListingsAsync(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest, AsyncHandler<DescribeReservedInstancesListingsRequest, DescribeReservedInstancesListingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesOfferingsResult> describeReservedInstancesOfferingsAsync(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeReservedInstancesOfferingsResult> describeReservedInstancesOfferingsAsync(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest, AsyncHandler<DescribeReservedInstancesOfferingsRequest, DescribeReservedInstancesOfferingsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSecurityGroupsResult> describeSecurityGroupsAsync(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSecurityGroupsResult> describeSecurityGroupsAsync(DescribeSecurityGroupsRequest describeSecurityGroupsRequest, AsyncHandler<DescribeSecurityGroupsRequest, DescribeSecurityGroupsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSnapshotAttributeResult> describeSnapshotAttributeAsync(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSnapshotAttributeResult> describeSnapshotAttributeAsync(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest, AsyncHandler<DescribeSnapshotAttributeRequest, DescribeSnapshotAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSnapshotsResult> describeSnapshotsAsync(DescribeSnapshotsRequest describeSnapshotsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSnapshotsResult> describeSnapshotsAsync(DescribeSnapshotsRequest describeSnapshotsRequest, AsyncHandler<DescribeSnapshotsRequest, DescribeSnapshotsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotDatafeedSubscriptionResult> describeSpotDatafeedSubscriptionAsync(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotDatafeedSubscriptionResult> describeSpotDatafeedSubscriptionAsync(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest, AsyncHandler<DescribeSpotDatafeedSubscriptionRequest, DescribeSpotDatafeedSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotInstanceRequestsResult> describeSpotInstanceRequestsAsync(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotInstanceRequestsResult> describeSpotInstanceRequestsAsync(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest, AsyncHandler<DescribeSpotInstanceRequestsRequest, DescribeSpotInstanceRequestsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotPriceHistoryResult> describeSpotPriceHistoryAsync(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeSpotPriceHistoryResult> describeSpotPriceHistoryAsync(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest, AsyncHandler<DescribeSpotPriceHistoryRequest, DescribeSpotPriceHistoryResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeTagsResult> describeTagsAsync(DescribeTagsRequest describeTagsRequest, AsyncHandler<DescribeTagsRequest, DescribeTagsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumeAttributeResult> describeVolumeAttributeAsync(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumeAttributeResult> describeVolumeAttributeAsync(DescribeVolumeAttributeRequest describeVolumeAttributeRequest, AsyncHandler<DescribeVolumeAttributeRequest, DescribeVolumeAttributeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumeStatusResult> describeVolumeStatusAsync(DescribeVolumeStatusRequest describeVolumeStatusRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumeStatusResult> describeVolumeStatusAsync(DescribeVolumeStatusRequest describeVolumeStatusRequest, AsyncHandler<DescribeVolumeStatusRequest, DescribeVolumeStatusResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumesResult> describeVolumesAsync(DescribeVolumesRequest describeVolumesRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeVolumesResult> describeVolumesAsync(DescribeVolumesRequest describeVolumesRequest, AsyncHandler<DescribeVolumesRequest, DescribeVolumesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DetachVolumeResult> detachVolumeAsync(DetachVolumeRequest detachVolumeRequest) throws AmazonServiceException, AmazonClientException;

    Future<DetachVolumeResult> detachVolumeAsync(DetachVolumeRequest detachVolumeRequest, AsyncHandler<DetachVolumeRequest, DetachVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> disassociateAddressAsync(DisassociateAddressRequest disassociateAddressRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> disassociateAddressAsync(DisassociateAddressRequest disassociateAddressRequest, AsyncHandler<DisassociateAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> enableVolumeIOAsync(EnableVolumeIORequest enableVolumeIORequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> enableVolumeIOAsync(EnableVolumeIORequest enableVolumeIORequest, AsyncHandler<EnableVolumeIORequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetConsoleOutputResult> getConsoleOutputAsync(GetConsoleOutputRequest getConsoleOutputRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetConsoleOutputResult> getConsoleOutputAsync(GetConsoleOutputRequest getConsoleOutputRequest, AsyncHandler<GetConsoleOutputRequest, GetConsoleOutputResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetPasswordDataResult> getPasswordDataAsync(GetPasswordDataRequest getPasswordDataRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetPasswordDataResult> getPasswordDataAsync(GetPasswordDataRequest getPasswordDataRequest, AsyncHandler<GetPasswordDataRequest, GetPasswordDataResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ImportInstanceResult> importInstanceAsync(ImportInstanceRequest importInstanceRequest) throws AmazonServiceException, AmazonClientException;

    Future<ImportInstanceResult> importInstanceAsync(ImportInstanceRequest importInstanceRequest, AsyncHandler<ImportInstanceRequest, ImportInstanceResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ImportKeyPairResult> importKeyPairAsync(ImportKeyPairRequest importKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    Future<ImportKeyPairResult> importKeyPairAsync(ImportKeyPairRequest importKeyPairRequest, AsyncHandler<ImportKeyPairRequest, ImportKeyPairResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ImportVolumeResult> importVolumeAsync(ImportVolumeRequest importVolumeRequest) throws AmazonServiceException, AmazonClientException;

    Future<ImportVolumeResult> importVolumeAsync(ImportVolumeRequest importVolumeRequest, AsyncHandler<ImportVolumeRequest, ImportVolumeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyImageAttributeAsync(ModifyImageAttributeRequest modifyImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyImageAttributeAsync(ModifyImageAttributeRequest modifyImageAttributeRequest, AsyncHandler<ModifyImageAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyInstanceAttributeAsync(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyInstanceAttributeAsync(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest, AsyncHandler<ModifyInstanceAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifySnapshotAttributeAsync(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifySnapshotAttributeAsync(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest, AsyncHandler<ModifySnapshotAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyVolumeAttributeAsync(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> modifyVolumeAttributeAsync(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest, AsyncHandler<ModifyVolumeAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<MonitorInstancesResult> monitorInstancesAsync(MonitorInstancesRequest monitorInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<MonitorInstancesResult> monitorInstancesAsync(MonitorInstancesRequest monitorInstancesRequest, AsyncHandler<MonitorInstancesRequest, MonitorInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<PurchaseReservedInstancesOfferingResult> purchaseReservedInstancesOfferingAsync(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) throws AmazonServiceException, AmazonClientException;

    Future<PurchaseReservedInstancesOfferingResult> purchaseReservedInstancesOfferingAsync(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest, AsyncHandler<PurchaseReservedInstancesOfferingRequest, PurchaseReservedInstancesOfferingResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> rebootInstancesAsync(RebootInstancesRequest rebootInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> rebootInstancesAsync(RebootInstancesRequest rebootInstancesRequest, AsyncHandler<RebootInstancesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<RegisterImageResult> registerImageAsync(RegisterImageRequest registerImageRequest) throws AmazonServiceException, AmazonClientException;

    Future<RegisterImageResult> registerImageAsync(RegisterImageRequest registerImageRequest, AsyncHandler<RegisterImageRequest, RegisterImageResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> releaseAddressAsync(ReleaseAddressRequest releaseAddressRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> releaseAddressAsync(ReleaseAddressRequest releaseAddressRequest, AsyncHandler<ReleaseAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> reportInstanceStatusAsync(ReportInstanceStatusRequest reportInstanceStatusRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> reportInstanceStatusAsync(ReportInstanceStatusRequest reportInstanceStatusRequest, AsyncHandler<ReportInstanceStatusRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<RequestSpotInstancesResult> requestSpotInstancesAsync(RequestSpotInstancesRequest requestSpotInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<RequestSpotInstancesResult> requestSpotInstancesAsync(RequestSpotInstancesRequest requestSpotInstancesRequest, AsyncHandler<RequestSpotInstancesRequest, RequestSpotInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetImageAttributeAsync(ResetImageAttributeRequest resetImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetImageAttributeAsync(ResetImageAttributeRequest resetImageAttributeRequest, AsyncHandler<ResetImageAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetInstanceAttributeAsync(ResetInstanceAttributeRequest resetInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetInstanceAttributeAsync(ResetInstanceAttributeRequest resetInstanceAttributeRequest, AsyncHandler<ResetInstanceAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetSnapshotAttributeAsync(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> resetSnapshotAttributeAsync(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest, AsyncHandler<ResetSnapshotAttributeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> revokeSecurityGroupIngressAsync(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> revokeSecurityGroupIngressAsync(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest, AsyncHandler<RevokeSecurityGroupIngressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<RunInstancesResult> runInstancesAsync(RunInstancesRequest runInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<RunInstancesResult> runInstancesAsync(RunInstancesRequest runInstancesRequest, AsyncHandler<RunInstancesRequest, RunInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<StartInstancesResult> startInstancesAsync(StartInstancesRequest startInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<StartInstancesResult> startInstancesAsync(StartInstancesRequest startInstancesRequest, AsyncHandler<StartInstancesRequest, StartInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<StopInstancesResult> stopInstancesAsync(StopInstancesRequest stopInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<StopInstancesResult> stopInstancesAsync(StopInstancesRequest stopInstancesRequest, AsyncHandler<StopInstancesRequest, StopInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<TerminateInstancesResult> terminateInstancesAsync(TerminateInstancesRequest terminateInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<TerminateInstancesResult> terminateInstancesAsync(TerminateInstancesRequest terminateInstancesRequest, AsyncHandler<TerminateInstancesRequest, TerminateInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<UnmonitorInstancesResult> unmonitorInstancesAsync(UnmonitorInstancesRequest unmonitorInstancesRequest) throws AmazonServiceException, AmazonClientException;

    Future<UnmonitorInstancesResult> unmonitorInstancesAsync(UnmonitorInstancesRequest unmonitorInstancesRequest, AsyncHandler<UnmonitorInstancesRequest, UnmonitorInstancesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
