package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DisassociateAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DisassociateAddressRequestMarshaller implements Marshaller<Request<DisassociateAddressRequest>, DisassociateAddressRequest> {
    public Request<DisassociateAddressRequest> marshall(DisassociateAddressRequest disassociateAddressRequest) {
        if (disassociateAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DisassociateAddressRequest> defaultRequest = new DefaultRequest(disassociateAddressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DisassociateAddress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (disassociateAddressRequest.getPublicIp() != null) {
            defaultRequest.addParameter("PublicIp", StringUtils.fromString(disassociateAddressRequest.getPublicIp()));
        }
        if (disassociateAddressRequest.getAssociationId() != null) {
            defaultRequest.addParameter("AssociationId", StringUtils.fromString(disassociateAddressRequest.getAssociationId()));
        }
        return defaultRequest;
    }
}
