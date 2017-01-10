package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeleteSecurityGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteSecurityGroupRequestMarshaller implements Marshaller<Request<DeleteSecurityGroupRequest>, DeleteSecurityGroupRequest> {
    public Request<DeleteSecurityGroupRequest> marshall(DeleteSecurityGroupRequest deleteSecurityGroupRequest) {
        if (deleteSecurityGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteSecurityGroupRequest> defaultRequest = new DefaultRequest(deleteSecurityGroupRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeleteSecurityGroup");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deleteSecurityGroupRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(deleteSecurityGroupRequest.getGroupName()));
        }
        if (deleteSecurityGroupRequest.getGroupId() != null) {
            defaultRequest.addParameter("GroupId", StringUtils.fromString(deleteSecurityGroupRequest.getGroupId()));
        }
        return defaultRequest;
    }
}
