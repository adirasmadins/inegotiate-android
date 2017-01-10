package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeleteLaunchConfigurationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteLaunchConfigurationRequestMarshaller implements Marshaller<Request<DeleteLaunchConfigurationRequest>, DeleteLaunchConfigurationRequest> {
    public Request<DeleteLaunchConfigurationRequest> marshall(DeleteLaunchConfigurationRequest deleteLaunchConfigurationRequest) {
        if (deleteLaunchConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteLaunchConfigurationRequest> defaultRequest = new DefaultRequest(deleteLaunchConfigurationRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeleteLaunchConfiguration");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (deleteLaunchConfigurationRequest.getLaunchConfigurationName() != null) {
            defaultRequest.addParameter("LaunchConfigurationName", StringUtils.fromString(deleteLaunchConfigurationRequest.getLaunchConfigurationName()));
        }
        return defaultRequest;
    }
}
