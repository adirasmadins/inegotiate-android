package com.amazonaws.services.sns.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AddPermissionRequestMarshaller implements Marshaller<Request<AddPermissionRequest>, AddPermissionRequest> {
    public Request<AddPermissionRequest> marshall(AddPermissionRequest addPermissionRequest) {
        int i = 1;
        if (addPermissionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AddPermissionRequest> defaultRequest = new DefaultRequest(addPermissionRequest, "AmazonSNS");
        defaultRequest.addParameter("Action", "AddPermission");
        defaultRequest.addParameter("Version", "2010-03-31");
        if (addPermissionRequest.getTopicArn() != null) {
            defaultRequest.addParameter("TopicArn", StringUtils.fromString(addPermissionRequest.getTopicArn()));
        }
        if (addPermissionRequest.getLabel() != null) {
            defaultRequest.addParameter("Label", StringUtils.fromString(addPermissionRequest.getLabel()));
        }
        int i2 = 1;
        for (String str : addPermissionRequest.getAWSAccountIds()) {
            if (str != null) {
                defaultRequest.addParameter("AWSAccountId.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        for (String str2 : addPermissionRequest.getActionNames()) {
            if (str2 != null) {
                defaultRequest.addParameter("ActionName.member." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        return defaultRequest;
    }
}
