package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AddPermissionRequestMarshaller implements Marshaller<Request<AddPermissionRequest>, AddPermissionRequest> {
    public Request<AddPermissionRequest> marshall(AddPermissionRequest addPermissionRequest) {
        int i = 1;
        if (addPermissionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AddPermissionRequest> defaultRequest = new DefaultRequest(addPermissionRequest, "AmazonSQS");
        defaultRequest.addParameter("Action", "AddPermission");
        defaultRequest.addParameter("Version", "2011-10-01");
        if (addPermissionRequest.getQueueUrl() != null) {
            defaultRequest.addParameter("QueueUrl", StringUtils.fromString(addPermissionRequest.getQueueUrl()));
        }
        if (addPermissionRequest.getLabel() != null) {
            defaultRequest.addParameter("Label", StringUtils.fromString(addPermissionRequest.getLabel()));
        }
        int i2 = 1;
        for (String str : addPermissionRequest.getAWSAccountIds()) {
            if (str != null) {
                defaultRequest.addParameter("AWSAccountId." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        for (String str2 : addPermissionRequest.getActions()) {
            if (str2 != null) {
                defaultRequest.addParameter("ActionName." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        return defaultRequest;
    }
}
