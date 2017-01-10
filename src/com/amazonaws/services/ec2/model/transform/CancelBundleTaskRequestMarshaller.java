package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CancelBundleTaskRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CancelBundleTaskRequestMarshaller implements Marshaller<Request<CancelBundleTaskRequest>, CancelBundleTaskRequest> {
    public Request<CancelBundleTaskRequest> marshall(CancelBundleTaskRequest cancelBundleTaskRequest) {
        if (cancelBundleTaskRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CancelBundleTaskRequest> defaultRequest = new DefaultRequest(cancelBundleTaskRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CancelBundleTask");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (cancelBundleTaskRequest.getBundleId() != null) {
            defaultRequest.addParameter("BundleId", StringUtils.fromString(cancelBundleTaskRequest.getBundleId()));
        }
        return defaultRequest;
    }
}
