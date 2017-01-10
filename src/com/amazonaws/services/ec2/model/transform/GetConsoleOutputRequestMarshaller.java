package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.GetConsoleOutputRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class GetConsoleOutputRequestMarshaller implements Marshaller<Request<GetConsoleOutputRequest>, GetConsoleOutputRequest> {
    public Request<GetConsoleOutputRequest> marshall(GetConsoleOutputRequest getConsoleOutputRequest) {
        if (getConsoleOutputRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetConsoleOutputRequest> defaultRequest = new DefaultRequest(getConsoleOutputRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "GetConsoleOutput");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (getConsoleOutputRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(getConsoleOutputRequest.getInstanceId()));
        }
        return defaultRequest;
    }
}
