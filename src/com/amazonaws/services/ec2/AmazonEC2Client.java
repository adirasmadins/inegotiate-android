package com.amazonaws.services.ec2;

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
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.internal.StaticCredentialsProvider;
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
import com.amazonaws.services.ec2.model.transform.ActivateLicenseRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.AllocateAddressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.AllocateAddressResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.AssociateAddressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.AssociateAddressResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.AttachVolumeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.AttachVolumeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.AuthorizeSecurityGroupIngressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.BundleInstanceRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.BundleInstanceResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CancelBundleTaskRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CancelBundleTaskResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CancelConversionTaskRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CancelExportTaskRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CancelReservedInstancesListingRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CancelReservedInstancesListingResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CancelSpotInstanceRequestsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CancelSpotInstanceRequestsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ConfirmProductInstanceRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ConfirmProductInstanceResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateImageRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateImageResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateInstanceExportTaskRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateInstanceExportTaskResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateKeyPairRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateKeyPairResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreatePlacementGroupRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateReservedInstancesListingRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateReservedInstancesListingResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSecurityGroupRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSecurityGroupResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSnapshotRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSnapshotResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSpotDatafeedSubscriptionRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateSpotDatafeedSubscriptionResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.CreateTagsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateVolumeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.CreateVolumeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DeactivateLicenseRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteKeyPairRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeletePlacementGroupRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteSecurityGroupRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteSnapshotRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteSpotDatafeedSubscriptionRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteTagsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeleteVolumeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DeregisterImageRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeAddressesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeAddressesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeAvailabilityZonesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeAvailabilityZonesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeBundleTasksRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeBundleTasksResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeConversionTasksRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeConversionTasksResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeExportTasksRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeExportTasksResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeImageAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeImageAttributeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeImagesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeImagesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstanceAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstanceAttributeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstanceStatusRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstanceStatusResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeKeyPairsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeKeyPairsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeLicensesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeLicensesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribePlacementGroupsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribePlacementGroupsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeRegionsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeRegionsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesListingsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesListingsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesOfferingsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesOfferingsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeReservedInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSecurityGroupsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSecurityGroupsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSnapshotAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSnapshotAttributeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSnapshotsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSnapshotsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotDatafeedSubscriptionRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotInstanceRequestsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotInstanceRequestsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotPriceHistoryRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeSpotPriceHistoryResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeTagsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeTagsResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumeAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumeAttributeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumeStatusRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumeStatusResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeVolumesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DetachVolumeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DetachVolumeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DisassociateAddressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.EnableVolumeIORequestMarshaller;
import com.amazonaws.services.ec2.model.transform.GetConsoleOutputRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.GetConsoleOutputResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.GetPasswordDataRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.GetPasswordDataResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ImportInstanceRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ImportInstanceResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ImportKeyPairRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ImportKeyPairResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ImportVolumeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ImportVolumeResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ModifyImageAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ModifyInstanceAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ModifySnapshotAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ModifyVolumeAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.MonitorInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.MonitorInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.PurchaseReservedInstancesOfferingRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.PurchaseReservedInstancesOfferingResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.RebootInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RegisterImageRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RegisterImageResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ReleaseAddressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ReportInstanceStatusRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RequestSpotInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RequestSpotInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.ResetImageAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ResetInstanceAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.ResetSnapshotAttributeRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RevokeSecurityGroupIngressRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RunInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.RunInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.StartInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.StartInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.StopInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.StopInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.TerminateInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.TerminateInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.UnmonitorInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.UnmonitorInstancesResultStaxUnmarshaller;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.w3c.dom.Node;

public class AmazonEC2Client extends AmazonWebServiceClient implements AmazonEC2 {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;
    private QueryStringSigner signer;

    public AmazonEC2Client() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    public AmazonEC2Client(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonEC2Client(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonEC2Client(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = new StaticCredentialsProvider(aWSCredentials);
        init();
    }

    public AmazonEC2Client(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonEC2Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new LegacyErrorUnmarshaller());
        setEndpoint("ec2.amazonaws.com");
        this.signer = new QueryStringSigner();
        this.requestHandlers.addAll(new HandlerChainFactory().newRequestHandlerChain("/com/amazonaws/services/ec2/request.handlers"));
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

    public void activateLicense(ActivateLicenseRequest activateLicenseRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ActivateLicenseRequestMarshaller().marshall(activateLicenseRequest), null);
    }

    public AllocateAddressResult allocateAddress() throws AmazonServiceException, AmazonClientException {
        return allocateAddress(new AllocateAddressRequest());
    }

    public AllocateAddressResult allocateAddress(AllocateAddressRequest allocateAddressRequest) throws AmazonServiceException, AmazonClientException {
        return (AllocateAddressResult) invoke(new AllocateAddressRequestMarshaller().marshall(allocateAddressRequest), new AllocateAddressResultStaxUnmarshaller());
    }

    public AssociateAddressResult associateAddress(AssociateAddressRequest associateAddressRequest) throws AmazonServiceException, AmazonClientException {
        return (AssociateAddressResult) invoke(new AssociateAddressRequestMarshaller().marshall(associateAddressRequest), new AssociateAddressResultStaxUnmarshaller());
    }

    public AttachVolumeResult attachVolume(AttachVolumeRequest attachVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return (AttachVolumeResult) invoke(new AttachVolumeRequestMarshaller().marshall(attachVolumeRequest), new AttachVolumeResultStaxUnmarshaller());
    }

    public void authorizeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException {
        authorizeSecurityGroupIngress(new AuthorizeSecurityGroupIngressRequest());
    }

    public void authorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new AuthorizeSecurityGroupIngressRequestMarshaller().marshall(authorizeSecurityGroupIngressRequest), null);
    }

    public BundleInstanceResult bundleInstance(BundleInstanceRequest bundleInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return (BundleInstanceResult) invoke(new BundleInstanceRequestMarshaller().marshall(bundleInstanceRequest), new BundleInstanceResultStaxUnmarshaller());
    }

    public CancelBundleTaskResult cancelBundleTask(CancelBundleTaskRequest cancelBundleTaskRequest) throws AmazonServiceException, AmazonClientException {
        return (CancelBundleTaskResult) invoke(new CancelBundleTaskRequestMarshaller().marshall(cancelBundleTaskRequest), new CancelBundleTaskResultStaxUnmarshaller());
    }

    public void cancelConversionTask(CancelConversionTaskRequest cancelConversionTaskRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CancelConversionTaskRequestMarshaller().marshall(cancelConversionTaskRequest), null);
    }

    public void cancelExportTask(CancelExportTaskRequest cancelExportTaskRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CancelExportTaskRequestMarshaller().marshall(cancelExportTaskRequest), null);
    }

    public CancelReservedInstancesListingResult cancelReservedInstancesListing(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException {
        return (CancelReservedInstancesListingResult) invoke(new CancelReservedInstancesListingRequestMarshaller().marshall(cancelReservedInstancesListingRequest), new CancelReservedInstancesListingResultStaxUnmarshaller());
    }

    public CancelSpotInstanceRequestsResult cancelSpotInstanceRequests(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException {
        return (CancelSpotInstanceRequestsResult) invoke(new CancelSpotInstanceRequestsRequestMarshaller().marshall(cancelSpotInstanceRequestsRequest), new CancelSpotInstanceRequestsResultStaxUnmarshaller());
    }

    public ConfirmProductInstanceResult confirmProductInstance(ConfirmProductInstanceRequest confirmProductInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return (ConfirmProductInstanceResult) invoke(new ConfirmProductInstanceRequestMarshaller().marshall(confirmProductInstanceRequest), new ConfirmProductInstanceResultStaxUnmarshaller());
    }

    public CreateImageResult createImage(CreateImageRequest createImageRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateImageResult) invoke(new CreateImageRequestMarshaller().marshall(createImageRequest), new CreateImageResultStaxUnmarshaller());
    }

    public CreateInstanceExportTaskResult createInstanceExportTask(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateInstanceExportTaskResult) invoke(new CreateInstanceExportTaskRequestMarshaller().marshall(createInstanceExportTaskRequest), new CreateInstanceExportTaskResultStaxUnmarshaller());
    }

    public CreateKeyPairResult createKeyPair(CreateKeyPairRequest createKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateKeyPairResult) invoke(new CreateKeyPairRequestMarshaller().marshall(createKeyPairRequest), new CreateKeyPairResultStaxUnmarshaller());
    }

    public void createPlacementGroup(CreatePlacementGroupRequest createPlacementGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreatePlacementGroupRequestMarshaller().marshall(createPlacementGroupRequest), null);
    }

    public CreateReservedInstancesListingResult createReservedInstancesListing(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateReservedInstancesListingResult) invoke(new CreateReservedInstancesListingRequestMarshaller().marshall(createReservedInstancesListingRequest), new CreateReservedInstancesListingResultStaxUnmarshaller());
    }

    public CreateSecurityGroupResult createSecurityGroup(CreateSecurityGroupRequest createSecurityGroupRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateSecurityGroupResult) invoke(new CreateSecurityGroupRequestMarshaller().marshall(createSecurityGroupRequest), new CreateSecurityGroupResultStaxUnmarshaller());
    }

    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateSnapshotResult) invoke(new CreateSnapshotRequestMarshaller().marshall(createSnapshotRequest), new CreateSnapshotResultStaxUnmarshaller());
    }

    public CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscription(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateSpotDatafeedSubscriptionResult) invoke(new CreateSpotDatafeedSubscriptionRequestMarshaller().marshall(createSpotDatafeedSubscriptionRequest), new CreateSpotDatafeedSubscriptionResultStaxUnmarshaller());
    }

    public void createTags(CreateTagsRequest createTagsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new CreateTagsRequestMarshaller().marshall(createTagsRequest), null);
    }

    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return (CreateVolumeResult) invoke(new CreateVolumeRequestMarshaller().marshall(createVolumeRequest), new CreateVolumeResultStaxUnmarshaller());
    }

    public void deactivateLicense(DeactivateLicenseRequest deactivateLicenseRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeactivateLicenseRequestMarshaller().marshall(deactivateLicenseRequest), null);
    }

    public void deleteKeyPair(DeleteKeyPairRequest deleteKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteKeyPairRequestMarshaller().marshall(deleteKeyPairRequest), null);
    }

    public void deletePlacementGroup(DeletePlacementGroupRequest deletePlacementGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeletePlacementGroupRequestMarshaller().marshall(deletePlacementGroupRequest), null);
    }

    public void deleteSecurityGroup() throws AmazonServiceException, AmazonClientException {
        deleteSecurityGroup(new DeleteSecurityGroupRequest());
    }

    public void deleteSecurityGroup(DeleteSecurityGroupRequest deleteSecurityGroupRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteSecurityGroupRequestMarshaller().marshall(deleteSecurityGroupRequest), null);
    }

    public void deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteSnapshotRequestMarshaller().marshall(deleteSnapshotRequest), null);
    }

    public void deleteSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException {
        deleteSpotDatafeedSubscription(new DeleteSpotDatafeedSubscriptionRequest());
    }

    public void deleteSpotDatafeedSubscription(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteSpotDatafeedSubscriptionRequestMarshaller().marshall(deleteSpotDatafeedSubscriptionRequest), null);
    }

    public void deleteTags(DeleteTagsRequest deleteTagsRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteTagsRequestMarshaller().marshall(deleteTagsRequest), null);
    }

    public void deleteVolume(DeleteVolumeRequest deleteVolumeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeleteVolumeRequestMarshaller().marshall(deleteVolumeRequest), null);
    }

    public void deregisterImage(DeregisterImageRequest deregisterImageRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DeregisterImageRequestMarshaller().marshall(deregisterImageRequest), null);
    }

    public DescribeAddressesResult describeAddresses() throws AmazonServiceException, AmazonClientException {
        return describeAddresses(new DescribeAddressesRequest());
    }

    public DescribeAddressesResult describeAddresses(DescribeAddressesRequest describeAddressesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAddressesResult) invoke(new DescribeAddressesRequestMarshaller().marshall(describeAddressesRequest), new DescribeAddressesResultStaxUnmarshaller());
    }

    public DescribeAvailabilityZonesResult describeAvailabilityZones() throws AmazonServiceException, AmazonClientException {
        return describeAvailabilityZones(new DescribeAvailabilityZonesRequest());
    }

    public DescribeAvailabilityZonesResult describeAvailabilityZones(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeAvailabilityZonesResult) invoke(new DescribeAvailabilityZonesRequestMarshaller().marshall(describeAvailabilityZonesRequest), new DescribeAvailabilityZonesResultStaxUnmarshaller());
    }

    public DescribeBundleTasksResult describeBundleTasks() throws AmazonServiceException, AmazonClientException {
        return describeBundleTasks(new DescribeBundleTasksRequest());
    }

    public DescribeBundleTasksResult describeBundleTasks(DescribeBundleTasksRequest describeBundleTasksRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeBundleTasksResult) invoke(new DescribeBundleTasksRequestMarshaller().marshall(describeBundleTasksRequest), new DescribeBundleTasksResultStaxUnmarshaller());
    }

    public DescribeConversionTasksResult describeConversionTasks() throws AmazonServiceException, AmazonClientException {
        return describeConversionTasks(new DescribeConversionTasksRequest());
    }

    public DescribeConversionTasksResult describeConversionTasks(DescribeConversionTasksRequest describeConversionTasksRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeConversionTasksResult) invoke(new DescribeConversionTasksRequestMarshaller().marshall(describeConversionTasksRequest), new DescribeConversionTasksResultStaxUnmarshaller());
    }

    public DescribeExportTasksResult describeExportTasks() throws AmazonServiceException, AmazonClientException {
        return describeExportTasks(new DescribeExportTasksRequest());
    }

    public DescribeExportTasksResult describeExportTasks(DescribeExportTasksRequest describeExportTasksRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeExportTasksResult) invoke(new DescribeExportTasksRequestMarshaller().marshall(describeExportTasksRequest), new DescribeExportTasksResultStaxUnmarshaller());
    }

    public DescribeImageAttributeResult describeImageAttribute(DescribeImageAttributeRequest describeImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeImageAttributeResult) invoke(new DescribeImageAttributeRequestMarshaller().marshall(describeImageAttributeRequest), new DescribeImageAttributeResultStaxUnmarshaller());
    }

    public DescribeImagesResult describeImages() throws AmazonServiceException, AmazonClientException {
        return describeImages(new DescribeImagesRequest());
    }

    public DescribeImagesResult describeImages(DescribeImagesRequest describeImagesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeImagesResult) invoke(new DescribeImagesRequestMarshaller().marshall(describeImagesRequest), new DescribeImagesResultStaxUnmarshaller());
    }

    public DescribeInstanceAttributeResult describeInstanceAttribute(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeInstanceAttributeResult) invoke(new DescribeInstanceAttributeRequestMarshaller().marshall(describeInstanceAttributeRequest), new DescribeInstanceAttributeResultStaxUnmarshaller());
    }

    public DescribeInstanceStatusResult describeInstanceStatus() throws AmazonServiceException, AmazonClientException {
        return describeInstanceStatus(new DescribeInstanceStatusRequest());
    }

    public DescribeInstanceStatusResult describeInstanceStatus(DescribeInstanceStatusRequest describeInstanceStatusRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeInstanceStatusResult) invoke(new DescribeInstanceStatusRequestMarshaller().marshall(describeInstanceStatusRequest), new DescribeInstanceStatusResultStaxUnmarshaller());
    }

    public DescribeInstancesResult describeInstances() throws AmazonServiceException, AmazonClientException {
        return describeInstances(new DescribeInstancesRequest());
    }

    public DescribeInstancesResult describeInstances(DescribeInstancesRequest describeInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeInstancesResult) invoke(new DescribeInstancesRequestMarshaller().marshall(describeInstancesRequest), new DescribeInstancesResultStaxUnmarshaller());
    }

    public DescribeKeyPairsResult describeKeyPairs() throws AmazonServiceException, AmazonClientException {
        return describeKeyPairs(new DescribeKeyPairsRequest());
    }

    public DescribeKeyPairsResult describeKeyPairs(DescribeKeyPairsRequest describeKeyPairsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeKeyPairsResult) invoke(new DescribeKeyPairsRequestMarshaller().marshall(describeKeyPairsRequest), new DescribeKeyPairsResultStaxUnmarshaller());
    }

    public DescribeLicensesResult describeLicenses() throws AmazonServiceException, AmazonClientException {
        return describeLicenses(new DescribeLicensesRequest());
    }

    public DescribeLicensesResult describeLicenses(DescribeLicensesRequest describeLicensesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeLicensesResult) invoke(new DescribeLicensesRequestMarshaller().marshall(describeLicensesRequest), new DescribeLicensesResultStaxUnmarshaller());
    }

    public DescribePlacementGroupsResult describePlacementGroups() throws AmazonServiceException, AmazonClientException {
        return describePlacementGroups(new DescribePlacementGroupsRequest());
    }

    public DescribePlacementGroupsResult describePlacementGroups(DescribePlacementGroupsRequest describePlacementGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribePlacementGroupsResult) invoke(new DescribePlacementGroupsRequestMarshaller().marshall(describePlacementGroupsRequest), new DescribePlacementGroupsResultStaxUnmarshaller());
    }

    public DescribeRegionsResult describeRegions() throws AmazonServiceException, AmazonClientException {
        return describeRegions(new DescribeRegionsRequest());
    }

    public DescribeRegionsResult describeRegions(DescribeRegionsRequest describeRegionsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeRegionsResult) invoke(new DescribeRegionsRequestMarshaller().marshall(describeRegionsRequest), new DescribeRegionsResultStaxUnmarshaller());
    }

    public DescribeReservedInstancesResult describeReservedInstances() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstances(new DescribeReservedInstancesRequest());
    }

    public DescribeReservedInstancesResult describeReservedInstances(DescribeReservedInstancesRequest describeReservedInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeReservedInstancesResult) invoke(new DescribeReservedInstancesRequestMarshaller().marshall(describeReservedInstancesRequest), new DescribeReservedInstancesResultStaxUnmarshaller());
    }

    public DescribeReservedInstancesListingsResult describeReservedInstancesListings() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstancesListings(new DescribeReservedInstancesListingsRequest());
    }

    public DescribeReservedInstancesListingsResult describeReservedInstancesListings(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeReservedInstancesListingsResult) invoke(new DescribeReservedInstancesListingsRequestMarshaller().marshall(describeReservedInstancesListingsRequest), new DescribeReservedInstancesListingsResultStaxUnmarshaller());
    }

    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstancesOfferings(new DescribeReservedInstancesOfferingsRequest());
    }

    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeReservedInstancesOfferingsResult) invoke(new DescribeReservedInstancesOfferingsRequestMarshaller().marshall(describeReservedInstancesOfferingsRequest), new DescribeReservedInstancesOfferingsResultStaxUnmarshaller());
    }

    public DescribeSecurityGroupsResult describeSecurityGroups() throws AmazonServiceException, AmazonClientException {
        return describeSecurityGroups(new DescribeSecurityGroupsRequest());
    }

    public DescribeSecurityGroupsResult describeSecurityGroups(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSecurityGroupsResult) invoke(new DescribeSecurityGroupsRequestMarshaller().marshall(describeSecurityGroupsRequest), new DescribeSecurityGroupsResultStaxUnmarshaller());
    }

    public DescribeSnapshotAttributeResult describeSnapshotAttribute(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSnapshotAttributeResult) invoke(new DescribeSnapshotAttributeRequestMarshaller().marshall(describeSnapshotAttributeRequest), new DescribeSnapshotAttributeResultStaxUnmarshaller());
    }

    public DescribeSnapshotsResult describeSnapshots() throws AmazonServiceException, AmazonClientException {
        return describeSnapshots(new DescribeSnapshotsRequest());
    }

    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSnapshotsResult) invoke(new DescribeSnapshotsRequestMarshaller().marshall(describeSnapshotsRequest), new DescribeSnapshotsResultStaxUnmarshaller());
    }

    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException {
        return describeSpotDatafeedSubscription(new DescribeSpotDatafeedSubscriptionRequest());
    }

    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSpotDatafeedSubscriptionResult) invoke(new DescribeSpotDatafeedSubscriptionRequestMarshaller().marshall(describeSpotDatafeedSubscriptionRequest), new DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller());
    }

    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests() throws AmazonServiceException, AmazonClientException {
        return describeSpotInstanceRequests(new DescribeSpotInstanceRequestsRequest());
    }

    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSpotInstanceRequestsResult) invoke(new DescribeSpotInstanceRequestsRequestMarshaller().marshall(describeSpotInstanceRequestsRequest), new DescribeSpotInstanceRequestsResultStaxUnmarshaller());
    }

    public DescribeSpotPriceHistoryResult describeSpotPriceHistory() throws AmazonServiceException, AmazonClientException {
        return describeSpotPriceHistory(new DescribeSpotPriceHistoryRequest());
    }

    public DescribeSpotPriceHistoryResult describeSpotPriceHistory(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeSpotPriceHistoryResult) invoke(new DescribeSpotPriceHistoryRequestMarshaller().marshall(describeSpotPriceHistoryRequest), new DescribeSpotPriceHistoryResultStaxUnmarshaller());
    }

    public DescribeTagsResult describeTags() throws AmazonServiceException, AmazonClientException {
        return describeTags(new DescribeTagsRequest());
    }

    public DescribeTagsResult describeTags(DescribeTagsRequest describeTagsRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeTagsResult) invoke(new DescribeTagsRequestMarshaller().marshall(describeTagsRequest), new DescribeTagsResultStaxUnmarshaller());
    }

    public DescribeVolumeAttributeResult describeVolumeAttribute(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeVolumeAttributeResult) invoke(new DescribeVolumeAttributeRequestMarshaller().marshall(describeVolumeAttributeRequest), new DescribeVolumeAttributeResultStaxUnmarshaller());
    }

    public DescribeVolumeStatusResult describeVolumeStatus() throws AmazonServiceException, AmazonClientException {
        return describeVolumeStatus(new DescribeVolumeStatusRequest());
    }

    public DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest describeVolumeStatusRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeVolumeStatusResult) invoke(new DescribeVolumeStatusRequestMarshaller().marshall(describeVolumeStatusRequest), new DescribeVolumeStatusResultStaxUnmarshaller());
    }

    public DescribeVolumesResult describeVolumes() throws AmazonServiceException, AmazonClientException {
        return describeVolumes(new DescribeVolumesRequest());
    }

    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest) throws AmazonServiceException, AmazonClientException {
        return (DescribeVolumesResult) invoke(new DescribeVolumesRequestMarshaller().marshall(describeVolumesRequest), new DescribeVolumesResultStaxUnmarshaller());
    }

    public DetachVolumeResult detachVolume(DetachVolumeRequest detachVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return (DetachVolumeResult) invoke(new DetachVolumeRequestMarshaller().marshall(detachVolumeRequest), new DetachVolumeResultStaxUnmarshaller());
    }

    public void disassociateAddress(DisassociateAddressRequest disassociateAddressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new DisassociateAddressRequestMarshaller().marshall(disassociateAddressRequest), null);
    }

    public void enableVolumeIO(EnableVolumeIORequest enableVolumeIORequest) throws AmazonServiceException, AmazonClientException {
        invoke(new EnableVolumeIORequestMarshaller().marshall(enableVolumeIORequest), null);
    }

    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    public GetConsoleOutputResult getConsoleOutput(GetConsoleOutputRequest getConsoleOutputRequest) throws AmazonServiceException, AmazonClientException {
        return (GetConsoleOutputResult) invoke(new GetConsoleOutputRequestMarshaller().marshall(getConsoleOutputRequest), new GetConsoleOutputResultStaxUnmarshaller());
    }

    public GetPasswordDataResult getPasswordData(GetPasswordDataRequest getPasswordDataRequest) throws AmazonServiceException, AmazonClientException {
        return (GetPasswordDataResult) invoke(new GetPasswordDataRequestMarshaller().marshall(getPasswordDataRequest), new GetPasswordDataResultStaxUnmarshaller());
    }

    public ImportInstanceResult importInstance(ImportInstanceRequest importInstanceRequest) throws AmazonServiceException, AmazonClientException {
        return (ImportInstanceResult) invoke(new ImportInstanceRequestMarshaller().marshall(importInstanceRequest), new ImportInstanceResultStaxUnmarshaller());
    }

    public ImportKeyPairResult importKeyPair(ImportKeyPairRequest importKeyPairRequest) throws AmazonServiceException, AmazonClientException {
        return (ImportKeyPairResult) invoke(new ImportKeyPairRequestMarshaller().marshall(importKeyPairRequest), new ImportKeyPairResultStaxUnmarshaller());
    }

    public ImportVolumeResult importVolume() throws AmazonServiceException, AmazonClientException {
        return importVolume(new ImportVolumeRequest());
    }

    public ImportVolumeResult importVolume(ImportVolumeRequest importVolumeRequest) throws AmazonServiceException, AmazonClientException {
        return (ImportVolumeResult) invoke(new ImportVolumeRequestMarshaller().marshall(importVolumeRequest), new ImportVolumeResultStaxUnmarshaller());
    }

    public void modifyImageAttribute(ModifyImageAttributeRequest modifyImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ModifyImageAttributeRequestMarshaller().marshall(modifyImageAttributeRequest), null);
    }

    public void modifyInstanceAttribute(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ModifyInstanceAttributeRequestMarshaller().marshall(modifyInstanceAttributeRequest), null);
    }

    public void modifySnapshotAttribute(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ModifySnapshotAttributeRequestMarshaller().marshall(modifySnapshotAttributeRequest), null);
    }

    public void modifyVolumeAttribute(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ModifyVolumeAttributeRequestMarshaller().marshall(modifyVolumeAttributeRequest), null);
    }

    public MonitorInstancesResult monitorInstances(MonitorInstancesRequest monitorInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (MonitorInstancesResult) invoke(new MonitorInstancesRequestMarshaller().marshall(monitorInstancesRequest), new MonitorInstancesResultStaxUnmarshaller());
    }

    public PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOffering(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) throws AmazonServiceException, AmazonClientException {
        return (PurchaseReservedInstancesOfferingResult) invoke(new PurchaseReservedInstancesOfferingRequestMarshaller().marshall(purchaseReservedInstancesOfferingRequest), new PurchaseReservedInstancesOfferingResultStaxUnmarshaller());
    }

    public void rebootInstances(RebootInstancesRequest rebootInstancesRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new RebootInstancesRequestMarshaller().marshall(rebootInstancesRequest), null);
    }

    public RegisterImageResult registerImage() throws AmazonServiceException, AmazonClientException {
        return registerImage(new RegisterImageRequest());
    }

    public RegisterImageResult registerImage(RegisterImageRequest registerImageRequest) throws AmazonServiceException, AmazonClientException {
        return (RegisterImageResult) invoke(new RegisterImageRequestMarshaller().marshall(registerImageRequest), new RegisterImageResultStaxUnmarshaller());
    }

    public void releaseAddress() throws AmazonServiceException, AmazonClientException {
        releaseAddress(new ReleaseAddressRequest());
    }

    public void releaseAddress(ReleaseAddressRequest releaseAddressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ReleaseAddressRequestMarshaller().marshall(releaseAddressRequest), null);
    }

    public void reportInstanceStatus() throws AmazonServiceException, AmazonClientException {
        reportInstanceStatus(new ReportInstanceStatusRequest());
    }

    public void reportInstanceStatus(ReportInstanceStatusRequest reportInstanceStatusRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ReportInstanceStatusRequestMarshaller().marshall(reportInstanceStatusRequest), null);
    }

    public RequestSpotInstancesResult requestSpotInstances(RequestSpotInstancesRequest requestSpotInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (RequestSpotInstancesResult) invoke(new RequestSpotInstancesRequestMarshaller().marshall(requestSpotInstancesRequest), new RequestSpotInstancesResultStaxUnmarshaller());
    }

    public void resetImageAttribute(ResetImageAttributeRequest resetImageAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ResetImageAttributeRequestMarshaller().marshall(resetImageAttributeRequest), null);
    }

    public void resetInstanceAttribute(ResetInstanceAttributeRequest resetInstanceAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ResetInstanceAttributeRequestMarshaller().marshall(resetInstanceAttributeRequest), null);
    }

    public void resetSnapshotAttribute(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new ResetSnapshotAttributeRequestMarshaller().marshall(resetSnapshotAttributeRequest), null);
    }

    public void revokeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException {
        revokeSecurityGroupIngress(new RevokeSecurityGroupIngressRequest());
    }

    public void revokeSecurityGroupIngress(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) throws AmazonServiceException, AmazonClientException {
        invoke(new RevokeSecurityGroupIngressRequestMarshaller().marshall(revokeSecurityGroupIngressRequest), null);
    }

    public RunInstancesResult runInstances(RunInstancesRequest runInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (RunInstancesResult) invoke(new RunInstancesRequestMarshaller().marshall(runInstancesRequest), new RunInstancesResultStaxUnmarshaller());
    }

    public StartInstancesResult startInstances(StartInstancesRequest startInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (StartInstancesResult) invoke(new StartInstancesRequestMarshaller().marshall(startInstancesRequest), new StartInstancesResultStaxUnmarshaller());
    }

    public StopInstancesResult stopInstances(StopInstancesRequest stopInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (StopInstancesResult) invoke(new StopInstancesRequestMarshaller().marshall(stopInstancesRequest), new StopInstancesResultStaxUnmarshaller());
    }

    public TerminateInstancesResult terminateInstances(TerminateInstancesRequest terminateInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (TerminateInstancesResult) invoke(new TerminateInstancesRequestMarshaller().marshall(terminateInstancesRequest), new TerminateInstancesResultStaxUnmarshaller());
    }

    public UnmonitorInstancesResult unmonitorInstances(UnmonitorInstancesRequest unmonitorInstancesRequest) throws AmazonServiceException, AmazonClientException {
        return (UnmonitorInstancesResult) invoke(new UnmonitorInstancesRequestMarshaller().marshall(unmonitorInstancesRequest), new UnmonitorInstancesResultStaxUnmarshaller());
    }
}
