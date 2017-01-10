package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.AssociateAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AssociateAddressRequestMarshaller implements Marshaller<Request<AssociateAddressRequest>, AssociateAddressRequest> {
    public Request<AssociateAddressRequest> marshall(AssociateAddressRequest associateAddressRequest) {
        if (associateAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AssociateAddressRequest> defaultRequest = new DefaultRequest(associateAddressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "AssociateAddress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (associateAddressRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(associateAddressRequest.getInstanceId()));
        }
        if (associateAddressRequest.getPublicIp() != null) {
            defaultRequest.addParameter("PublicIp", StringUtils.fromString(associateAddressRequest.getPublicIp()));
        }
        if (associateAddressRequest.getAllocationId() != null) {
            defaultRequest.addParameter("AllocationId", StringUtils.fromString(associateAddressRequest.getAllocationId()));
        }
        if (associateAddressRequest.getNetworkInterfaceId() != null) {
            defaultRequest.addParameter("NetworkInterfaceId", StringUtils.fromString(associateAddressRequest.getNetworkInterfaceId()));
        }
        if (associateAddressRequest.getPrivateIpAddress() != null) {
            defaultRequest.addParameter("PrivateIpAddress", StringUtils.fromString(associateAddressRequest.getPrivateIpAddress()));
        }
        if (associateAddressRequest.isAllowReassociation() != null) {
            defaultRequest.addParameter("AllowReassociation", StringUtils.fromBoolean(associateAddressRequest.isAllowReassociation()));
        }
        return defaultRequest;
    }
}
