package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.RevokeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.UserIdGroupPair;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RevokeSecurityGroupIngressRequestMarshaller implements Marshaller<Request<RevokeSecurityGroupIngressRequest>, RevokeSecurityGroupIngressRequest> {
    public Request<RevokeSecurityGroupIngressRequest> marshall(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) {
        if (revokeSecurityGroupIngressRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RevokeSecurityGroupIngressRequest> defaultRequest = new DefaultRequest(revokeSecurityGroupIngressRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "RevokeSecurityGroupIngress");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (revokeSecurityGroupIngressRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(revokeSecurityGroupIngressRequest.getGroupName()));
        }
        if (revokeSecurityGroupIngressRequest.getGroupId() != null) {
            defaultRequest.addParameter("GroupId", StringUtils.fromString(revokeSecurityGroupIngressRequest.getGroupId()));
        }
        if (revokeSecurityGroupIngressRequest.getSourceSecurityGroupName() != null) {
            defaultRequest.addParameter("SourceSecurityGroupName", StringUtils.fromString(revokeSecurityGroupIngressRequest.getSourceSecurityGroupName()));
        }
        if (revokeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() != null) {
            defaultRequest.addParameter("SourceSecurityGroupOwnerId", StringUtils.fromString(revokeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId()));
        }
        if (revokeSecurityGroupIngressRequest.getIpProtocol() != null) {
            defaultRequest.addParameter("IpProtocol", StringUtils.fromString(revokeSecurityGroupIngressRequest.getIpProtocol()));
        }
        if (revokeSecurityGroupIngressRequest.getFromPort() != null) {
            defaultRequest.addParameter("FromPort", StringUtils.fromInteger(revokeSecurityGroupIngressRequest.getFromPort()));
        }
        if (revokeSecurityGroupIngressRequest.getToPort() != null) {
            defaultRequest.addParameter("ToPort", StringUtils.fromInteger(revokeSecurityGroupIngressRequest.getToPort()));
        }
        if (revokeSecurityGroupIngressRequest.getCidrIp() != null) {
            defaultRequest.addParameter("CidrIp", StringUtils.fromString(revokeSecurityGroupIngressRequest.getCidrIp()));
        }
        int i = 1;
        for (IpPermission ipPermission : revokeSecurityGroupIngressRequest.getIpPermissions()) {
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
