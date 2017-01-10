package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class TerminateInstancesRequestMarshaller implements Marshaller<Request<TerminateInstancesRequest>, TerminateInstancesRequest> {
    public Request<TerminateInstancesRequest> marshall(TerminateInstancesRequest terminateInstancesRequest) {
        if (terminateInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<TerminateInstancesRequest> defaultRequest = new DefaultRequest(terminateInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "TerminateInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : terminateInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
