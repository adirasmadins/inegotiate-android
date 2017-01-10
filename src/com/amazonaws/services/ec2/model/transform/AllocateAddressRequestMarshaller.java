package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.AllocateAddressRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AllocateAddressRequestMarshaller implements Marshaller<Request<AllocateAddressRequest>, AllocateAddressRequest> {
    public Request<AllocateAddressRequest> marshall(AllocateAddressRequest allocateAddressRequest) {
        if (allocateAddressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AllocateAddressRequest> defaultRequest = new DefaultRequest(allocateAddressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "AllocateAddress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (allocateAddressRequest.getDomain() != null) {
            defaultRequest.addParameter("Domain", StringUtils.fromString(allocateAddressRequest.getDomain()));
        }
        return defaultRequest;
    }
}
