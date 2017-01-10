package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.UserIdGroupPair;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class AuthorizeSecurityGroupIngressRequestMarshaller implements Marshaller<Request<AuthorizeSecurityGroupIngressRequest>, AuthorizeSecurityGroupIngressRequest> {
    public Request<AuthorizeSecurityGroupIngressRequest> marshall(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) {
        if (authorizeSecurityGroupIngressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<AuthorizeSecurityGroupIngressRequest> defaultRequest = new DefaultRequest(authorizeSecurityGroupIngressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "AuthorizeSecurityGroupIngress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (authorizeSecurityGroupIngressRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getGroupName()));
        }
        if (authorizeSecurityGroupIngressRequest.getGroupId() != null) {
            defaultRequest.addParameter("GroupId", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getGroupId()));
        }
        if (authorizeSecurityGroupIngressRequest.getSourceSecurityGroupName() != null) {
            defaultRequest.addParameter("SourceSecurityGroupName", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getSourceSecurityGroupName()));
        }
        if (authorizeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() != null) {
            defaultRequest.addParameter("SourceSecurityGroupOwnerId", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId()));
        }
        if (authorizeSecurityGroupIngressRequest.getIpProtocol() != null) {
            defaultRequest.addParameter("IpProtocol", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getIpProtocol()));
        }
        if (authorizeSecurityGroupIngressRequest.getFromPort() != null) {
            defaultRequest.addParameter("FromPort", StringUtils.fromInteger(authorizeSecurityGroupIngressRequest.getFromPort()));
        }
        if (authorizeSecurityGroupIngressRequest.getToPort() != null) {
            defaultRequest.addParameter("ToPort", StringUtils.fromInteger(authorizeSecurityGroupIngressRequest.getToPort()));
        }
        if (authorizeSecurityGroupIngressRequest.getCidrIp() != null) {
            defaultRequest.addParameter("CidrIp", StringUtils.fromString(authorizeSecurityGroupIngressRequest.getCidrIp()));
        }
        int i = 1;
        for (IpPermission ipPermission : authorizeSecurityGroupIngressRequest.getIpPermissions()) {
            if (ipPermission != null) {
                if (ipPermission.getIpProtocol() != null) {
                    defaultRequest.addParameter("IpPermissions." + i + ".IpProtocol", StringUtils.fromString(ipPermission.getIpProtocol()));
                }
                if (ipPermission.getFromPort() != null) {
                    defaultRequest.addParameter("IpPermissions." + i + ".FromPort", StringUtils.fromInteger(ipPermission.getFromPort()));
                }
                if (ipPermission.getToPort() != null) {
                    defaultRequest.addParameter("IpPermissions." + i + ".ToPort", StringUtils.fromInteger(ipPermission.getToPort()));
                }
                int i2 = 1;
                for (UserIdGroupPair userIdGroupPair : ipPermission.getUserIdGroupPairs()) {
                    if (userIdGroupPair != null) {
                        if (userIdGroupPair.getUserId() != null) {
                            defaultRequest.addParameter("IpPermissions." + i + ".Groups." + i2 + ".UserId", StringUtils.fromString(userIdGroupPair.getUserId()));
                        }
                        if (userIdGroupPair.getGroupName() != null) {
                            defaultRequest.addParameter("IpPermissions." + i + ".Groups." + i2 + ".GroupName", StringUtils.fromString(userIdGroupPair.getGroupName()));
                        }
                        if (userIdGroupPair.getGroupId() != null) {
                            defaultRequest.addParameter("IpPermissions." + i + ".Groups." + i2 + ".GroupId", StringUtils.fromString(userIdGroupPair.getGroupId()));
                        }
                    }
                    i2++;
                }
                int i3 = 1;
                for (String str : ipPermission.getIpRanges()) {
                    if (str != null) {
                        defaultRequest.addParameter("IpPermissions." + i + ".IpRanges." + i3 + ".CidrIp", StringUtils.fromString(str));
                    }
                    i3++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
