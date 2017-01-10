package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.UnmonitorInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class UnmonitorInstancesRequestMarshaller implements Marshaller<Request<UnmonitorInstancesRequest>, UnmonitorInstancesRequest> {
    public Request<UnmonitorInstancesRequest> marshall(UnmonitorInstancesRequest unmonitorInstancesRequest) {
        if (unmonitorInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<UnmonitorInstancesRequest> defaultRequest = new DefaultRequest(unmonitorInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "UnmonitorInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : unmonitorInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
