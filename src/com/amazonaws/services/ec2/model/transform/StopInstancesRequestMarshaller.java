package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class StopInstancesRequestMarshaller implements Marshaller<Request<StopInstancesRequest>, StopInstancesRequest> {
    public Request<StopInstancesRequest> marshall(StopInstancesRequest stopInstancesRequest) {
        if (stopInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<StopInstancesRequest> defaultRequest = new DefaultRequest(stopInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "StopInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : stopInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (stopInstancesRequest.isForce() != null) {
            defaultRequest.addParameter("Force", StringUtils.fromBoolean(stopInstancesRequest.isForce()));
        }
        return defaultRequest;
    }
}
