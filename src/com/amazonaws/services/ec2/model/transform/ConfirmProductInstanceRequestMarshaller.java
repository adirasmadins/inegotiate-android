package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.ConfirmProductInstanceRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ConfirmProductInstanceRequestMarshaller implements Marshaller<Request<ConfirmProductInstanceRequest>, ConfirmProductInstanceRequest> {
    public Request<ConfirmProductInstanceRequest> marshall(ConfirmProductInstanceRequest confirmProductInstanceRequest) {
        if (confirmProductInstanceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ConfirmProductInstanceRequest> defaultRequest = new DefaultRequest(confirmProductInstanceRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ConfirmProductInstance");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (confirmProductInstanceRequest.getProductCode() != null) {
            defaultRequest.addParameter("ProductCode", StringUtils.fromString(confirmProductInstanceRequest.getProductCode()));
        }
        if (confirmProductInstanceRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(confirmProductInstanceRequest.getInstanceId()));
        }
        return defaultRequest;
    }
}
