package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.MonitorInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class MonitorInstancesRequestMarshaller implements Marshaller<Request<MonitorInstancesRequest>, MonitorInstancesRequest> {
    public Request<MonitorInstancesRequest> marshall(MonitorInstancesRequest monitorInstancesRequest) {
        if (monitorInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<MonitorInstancesRequest> defaultRequest = new DefaultRequest(monitorInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "MonitorInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : monitorInstancesRequest.getInstanceIds()) {
            if (str != null) {
                defaultRequest.addParameter("InstanceId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        return defaultRequest;
    }
}
