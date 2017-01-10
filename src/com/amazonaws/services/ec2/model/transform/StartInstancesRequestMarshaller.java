package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class StartInstancesRequestMarshaller implements Marshaller<Request<StartInstancesRequest>, StartInstancesRequest> {
    public Request<StartInstancesRequest> marshall(StartInstancesRequest startInstancesRequest) {
        if (startInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<StartInstancesRequest> defaultRequest = new DefaultRequest(startInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "StartInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : startInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (startInstancesRequest.getAdditionalInfo() != null) {
            defaultRequest.addParameter("AdditionalInfo", StringUtils.fromString(startInstancesRequest.getAdditionalInfo()));
        }
        return defaultRequest;
    }
}
