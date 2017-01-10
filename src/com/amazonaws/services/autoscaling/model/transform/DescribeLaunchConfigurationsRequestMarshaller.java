package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeLaunchConfigurationsRequestMarshaller implements Marshaller<Request<DescribeLaunchConfigurationsRequest>, DescribeLaunchConfigurationsRequest> {
    public Request<DescribeLaunchConfigurationsRequest> marshall(DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest) {
        if (describeLaunchConfigurationsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeLaunchConfigurationsRequest> defaultRequest = new DefaultRequest(describeLaunchConfigurationsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DescribeLaunchConfigurations");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (String str : describeLaunchConfigurationsRequest.getLaunchConfigurationNames()) {
            if (str != null) {
                defaultRequest.addParameter("LaunchConfigurationNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeLaunchConfigurationsRequest.getNextToken() != null) {
            defaultRequest.addParameter("NextToken", StringUtils.fromString(describeLaunchConfigurationsRequest.getNextToken()));
        }
        if (describeLaunchConfigurationsRequest.getMaxRecords() != null) {
            defaultRequest.addParameter("MaxRecords", StringUtils.fromInteger(describeLaunchConfigurationsRequest.getMaxRecords()));
        }
        return defaultRequest;
    }
}
