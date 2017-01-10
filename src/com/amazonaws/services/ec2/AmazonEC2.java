package com.amazonaws.services.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
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

public interface AmazonEC2 {
    void activateLicense(ActivateLicenseRequest activateLicenseRequest) throws AmazonServiceException, AmazonClientException;

    AllocateAddressResult allocateAddress() throws AmazonServiceException, AmazonClientException;

    AllocateAddressResult allocateAddress(AllocateAddressRequest allocateAddressRequest) throws AmazonServiceException, AmazonClientException;

    AssociateAddressResult associateAddress(AssociateAddressRequest associateAddressRequest) throws AmazonServiceException, AmazonClientException;

    AttachVolumeResult attachVolume(AttachVolumeRequest attachVolumeRequest) throws AmazonServiceException, AmazonClientException;

    void authorizeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException;

    void authorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException;

    BundleInstanceResult bundleInstance(BundleInstanceRequest bundleInstanceRequest) throws AmazonServiceException, AmazonClientException;

    CancelBundleTaskResult cancelBundleTask(CancelBundleTaskRequest cancelBundleTaskRequest) throws AmazonServiceException, AmazonClientException;

    void cancelConversionTask(CancelConversionTaskRequest cancelConversionTaskRequest) throws AmazonServiceException, AmazonClientException;

    void cancelExportTask(CancelExportTaskRequest cancelExportTaskRequest) throws AmazonServiceException, AmazonClientException;

    CancelReservedInstancesListingResult cancelReservedInstancesListing(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException;

    CancelSpotInstanceRequestsResult cancelSpotInstanceRequests(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException;

    ConfirmProductInstanceResult confirmProductInstance(ConfirmProductInstanceRequest confirmProductInstanceRequest) throws AmazonServiceException, AmazonClientException;

    CreateImageResult createImage(CreateImageRequest createImageRequest) throws AmazonServiceException, AmazonClientException;

    CreateInstanceExportTaskResult createInstanceExportTask(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) throws AmazonServiceException, AmazonClientException;

    CreateKeyPairResult createKeyPair(CreateKeyPairRequest createKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    void createPlacementGroup(CreatePlacementGroupRequest createPlacementGroupRequest) throws AmazonServiceException, AmazonClientException;

    CreateReservedInstancesListingResult createReservedInstancesListing(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException;

    CreateSecurityGroupResult createSecurityGroup(CreateSecurityGroupRequest createSecurityGroupRequest) throws AmazonServiceException, AmazonClientException;

    CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws AmazonServiceException, AmazonClientException;

    CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscription(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    void createTags(CreateTagsRequest createTagsRequest) throws AmazonServiceException, AmazonClientException;

    CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest) throws AmazonServiceException, AmazonClientException;

    void deactivateLicense(DeactivateLicenseRequest deactivateLicenseRequest) throws AmazonServiceException, AmazonClientException;

    void deleteKeyPair(DeleteKeyPairRequest deleteKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    void deletePlacementGroup(DeletePlacementGroupRequest deletePlacementGroupRequest) throws AmazonServiceException, AmazonClientException;

    void deleteSecurityGroup() throws AmazonServiceException, AmazonClientException;

    void deleteSecurityGroup(DeleteSecurityGroupRequest deleteSecurityGroupRequest) throws AmazonServiceException, AmazonClientException;

    void deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) throws AmazonServiceException, AmazonClientException;

    void deleteSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException;

    void deleteSpotDatafeedSubscription(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    void deleteTags(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException;

    void deleteVolume(DeleteVolumeRequest deleteVolumeRequest) throws AmazonServiceException, AmazonClientException;

    void deregisterImage(DeregisterImageRequest deregisterImageRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAddressesResult describeAddresses() throws AmazonServiceException, AmazonClientException;

    DescribeAddressesResult describeAddresses(DescribeAddressesRequest describeAddressesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAvailabilityZonesResult describeAvailabilityZones() throws AmazonServiceException, AmazonClientException;

    DescribeAvailabilityZonesResult describeAvailabilityZones(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeBundleTasksResult describeBundleTasks() throws AmazonServiceException, AmazonClientException;

    DescribeBundleTasksResult describeBundleTasks(DescribeBundleTasksRequest describeBundleTasksRequest) throws AmazonServiceException, AmazonClientException;

    DescribeConversionTasksResult describeConversionTasks() throws AmazonServiceException, AmazonClientException;

    DescribeConversionTasksResult describeConversionTasks(DescribeConversionTasksRequest describeConversionTasksRequest) throws AmazonServiceException, AmazonClientException;

    DescribeExportTasksResult describeExportTasks() throws AmazonServiceException, AmazonClientException;

    DescribeExportTasksResult describeExportTasks(DescribeExportTasksRequest describeExportTasksRequest) throws AmazonServiceException, AmazonClientException;

    DescribeImageAttributeResult describeImageAttribute(DescribeImageAttributeRequest describeImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    DescribeImagesResult describeImages() throws AmazonServiceException, AmazonClientException;

    DescribeImagesResult describeImages(DescribeImagesRequest describeImagesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeInstanceAttributeResult describeInstanceAttribute(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    DescribeInstanceStatusResult describeInstanceStatus() throws AmazonServiceException, AmazonClientException;

    DescribeInstanceStatusResult describeInstanceStatus(DescribeInstanceStatusRequest describeInstanceStatusRequest) throws AmazonServiceException, AmazonClientException;

    DescribeInstancesResult describeInstances() throws AmazonServiceException, AmazonClientException;

    DescribeInstancesResult describeInstances(DescribeInstancesRequest describeInstancesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeKeyPairsResult describeKeyPairs() throws AmazonServiceException, AmazonClientException;

    DescribeKeyPairsResult describeKeyPairs(DescribeKeyPairsRequest describeKeyPairsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeLicensesResult describeLicenses() throws AmazonServiceException, AmazonClientException;

    DescribeLicensesResult describeLicenses(DescribeLicensesRequest describeLicensesRequest) throws AmazonServiceException, AmazonClientException;

    DescribePlacementGroupsResult describePlacementGroups() throws AmazonServiceException, AmazonClientException;

    DescribePlacementGroupsResult describePlacementGroups(DescribePlacementGroupsRequest describePlacementGroupsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeRegionsResult describeRegions() throws AmazonServiceException, AmazonClientException;

    DescribeRegionsResult describeRegions(DescribeRegionsRequest describeRegionsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesResult describeReservedInstances() throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesResult describeReservedInstances(DescribeReservedInstancesRequest describeReservedInstancesRequest) throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesListingsResult describeReservedInstancesListings() throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesListingsResult describeReservedInstancesListings(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings() throws AmazonServiceException, AmazonClientException;

    DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSecurityGroupsResult describeSecurityGroups() throws AmazonServiceException, AmazonClientException;

    DescribeSecurityGroupsResult describeSecurityGroups(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSnapshotAttributeResult describeSnapshotAttribute(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSnapshotsResult describeSnapshots() throws AmazonServiceException, AmazonClientException;

    DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException;

    DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSpotInstanceRequestsResult describeSpotInstanceRequests() throws AmazonServiceException, AmazonClientException;

    DescribeSpotInstanceRequestsResult describeSpotInstanceRequests(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeSpotPriceHistoryResult describeSpotPriceHistory() throws AmazonServiceException, AmazonClientException;

    DescribeSpotPriceHistoryResult describeSpotPriceHistory(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) throws AmazonServiceException, AmazonClientException;

    DescribeTagsResult describeTags() throws AmazonServiceException, AmazonClientException;

    DescribeTagsResult describeTags(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeVolumeAttributeResult describeVolumeAttribute(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException;

    DescribeVolumeStatusResult describeVolumeStatus() throws AmazonServiceException, AmazonClientException;

    DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest describeVolumeStatusRequest) throws AmazonServiceException, AmazonClientException;

    DescribeVolumesResult describeVolumes() throws AmazonServiceException, AmazonClientException;

    DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest) throws AmazonServiceException, AmazonClientException;

    DetachVolumeResult detachVolume(DetachVolumeRequest detachVolumeRequest) throws AmazonServiceException, AmazonClientException;

    void disassociateAddress(DisassociateAddressRequest disassociateAddressRequest) throws AmazonServiceException, AmazonClientException;

    void enableVolumeIO(EnableVolumeIORequest enableVolumeIORequest) throws AmazonServiceException, AmazonClientException;

    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    GetConsoleOutputResult getConsoleOutput(GetConsoleOutputRequest getConsoleOutputRequest) throws AmazonServiceException, AmazonClientException;

    GetPasswordDataResult getPasswordData(GetPasswordDataRequest getPasswordDataRequest) throws AmazonServiceException, AmazonClientException;

    ImportInstanceResult importInstance(ImportInstanceRequest importInstanceRequest) throws AmazonServiceException, AmazonClientException;

    ImportKeyPairResult importKeyPair(ImportKeyPairRequest importKeyPairRequest) throws AmazonServiceException, AmazonClientException;

    ImportVolumeResult importVolume() throws AmazonServiceException, AmazonClientException;

    ImportVolumeResult importVolume(ImportVolumeRequest importVolumeRequest) throws AmazonServiceException, AmazonClientException;

    void modifyImageAttribute(ModifyImageAttributeRequest modifyImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void modifyInstanceAttribute(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void modifySnapshotAttribute(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void modifyVolumeAttribute(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException;

    MonitorInstancesResult monitorInstances(MonitorInstancesRequest monitorInstancesRequest) throws AmazonServiceException, AmazonClientException;

    PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOffering(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) throws AmazonServiceException, AmazonClientException;

    void rebootInstances(RebootInstancesRequest rebootInstancesRequest) throws AmazonServiceException, AmazonClientException;

    RegisterImageResult registerImage() throws AmazonServiceException, AmazonClientException;

    RegisterImageResult registerImage(RegisterImageRequest registerImageRequest) throws AmazonServiceException, AmazonClientException;

    void releaseAddress() throws AmazonServiceException, AmazonClientException;

    void releaseAddress(ReleaseAddressRequest releaseAddressRequest) throws AmazonServiceException, AmazonClientException;

    void reportInstanceStatus() throws AmazonServiceException, AmazonClientException;

    void reportInstanceStatus(ReportInstanceStatusRequest reportInstanceStatusRequest) throws AmazonServiceException, AmazonClientException;

    RequestSpotInstancesResult requestSpotInstances(RequestSpotInstancesRequest requestSpotInstancesRequest) throws AmazonServiceException, AmazonClientException;

    void resetImageAttribute(ResetImageAttributeRequest resetImageAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void resetInstanceAttribute(ResetInstanceAttributeRequest resetInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void resetSnapshotAttribute(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException;

    void revokeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException;

    void revokeSecurityGroupIngress(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException;

    RunInstancesResult runInstances(RunInstancesRequest runInstancesRequest) throws AmazonServiceException, AmazonClientException;

    void setEndpoint(String str) throws IllegalArgumentException;

    void shutdown();

    StartInstancesResult startInstances(StartInstancesRequest startInstancesRequest) throws AmazonServiceException, AmazonClientException;

    StopInstancesResult stopInstances(StopInstancesRequest stopInstancesRequest) throws AmazonServiceException, AmazonClientException;

    TerminateInstancesResult terminateInstances(TerminateInstancesRequest terminateInstancesRequest) throws AmazonServiceException, AmazonClientException;

    UnmonitorInstancesResult unmonitorInstances(UnmonitorInstancesRequest unmonitorInstancesRequest) throws AmazonServiceException, AmazonClientException;
}
