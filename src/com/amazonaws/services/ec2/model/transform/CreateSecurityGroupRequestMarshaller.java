package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateSecurityGroupRequestMarshaller implements Marshaller<Request<CreateSecurityGroupRequest>, CreateSecurityGroupRequest> {
    public Request<CreateSecurityGroupRequest> marshall(CreateSecurityGroupRequest createSecurityGroupRequest) {
        if (createSecurityGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateSecurityGroupRequest> defaultRequest = new DefaultRequest(createSecurityGroupRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateSecurityGroup");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createSecurityGroupRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(createSecurityGroupRequest.getGroupName()));
        }
        if (createSecurityGroupRequest.getDescription() != null) {
            defaultRequest.addParameter("GroupDescription", StringUtils.fromString(createSecurityGroupRequest.getDescription()));
        }
        if (createSecurityGroupRequest.getVpcId() != null) {
            defaultRequest.addParameter("VpcId", StringUtils.fromString(createSecurityGroupRequest.getVpcId()));
        }
        return defaultRequest;
    }
}
