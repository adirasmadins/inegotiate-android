package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.RebootInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RebootInstancesRequestMarshaller implements Marshaller<Request<RebootInstancesRequest>, RebootInstancesRequest> {
    public Request<RebootInstancesRequest> marshall(RebootInstancesRequest rebootInstancesRequest) {
        if (rebootInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RebootInstancesRequest> defaultRequest = new DefaultRequest(rebootInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "RebootInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : rebootInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
