package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CancelSpotInstanceRequestsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CancelSpotInstanceRequestsRequestMarshaller implements Marshaller<Request<CancelSpotInstanceRequestsRequest>, CancelSpotInstanceRequestsRequest> {
    public Request<CancelSpotInstanceRequestsRequest> marshall(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) {
        if (cancelSpotInstanceRequestsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CancelSpotInstanceRequestsRequest> defaultRequest = new DefaultRequest(cancelSpotInstanceRequestsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CancelSpotInstanceRequests");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : cancelSpotInstanceRequestsRequest.getSpotInstanceRequestIds()) {
            if (str != null) {
                defaultRequest.addParameter("SpotInstanceRequestId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
