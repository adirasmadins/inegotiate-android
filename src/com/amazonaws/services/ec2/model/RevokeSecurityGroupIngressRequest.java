package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RevokeSecurityGroupIngressRequest extends AmazonWebServiceRequest {
    private String cidrIp;
    private Integer fromPort;
    private String groupId;
    private String groupName;
    private List<IpPermission> ipPermissions;
    private String ipProtocol;
    private String sourceSecurityGroupName;
    private String sourceSecurityGroupOwnerId;
    private Integer toPort;

    public RevokeSecurityGroupIngressRequest(String str, List<IpPermission> list) {
        this.groupName = str;
        this.ipPermissions = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RevokeSecurityGroupIngressRequest)) {
            return false;
        }
        RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest = (RevokeSecurityGroupIngressRequest) obj;
        if (((revokeSecurityGroupIngressRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getGroupName() != null && !revokeSecurityGroupIngressRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getGroupId() != null && !revokeSecurityGroupIngressRequest.getGroupId().equals(getGroupId())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getSourceSecurityGroupName() == null ? 1 : 0) ^ (getSourceSecurityGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getSourceSecurityGroupName() != null && !revokeSecurityGroupIngressRequest.getSourceSecurityGroupName().equals(getSourceSecurityGroupName())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() == null ? 1 : 0) ^ (getSourceSecurityGroupOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() != null && !revokeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId().equals(getSourceSecurityGroupOwnerId())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getIpProtocol() == null ? 1 : 0) ^ (getIpProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getIpProtocol() != null && !revokeSecurityGroupIngressRequest.getIpProtocol().equals(getIpProtocol())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getFromPort() == null ? 1 : 0) ^ (getFromPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getFromPort() != null && !revokeSecurityGroupIngressRequest.getFromPort().equals(getFromPort())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getToPort() == null ? 1 : 0) ^ (getToPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getToPort() != null && !revokeSecurityGroupIngressRequest.getToPort().equals(getToPort())) {
            return false;
        }
        if (((revokeSecurityGroupIngressRequest.getCidrIp() == null ? 1 : 0) ^ (getCidrIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (revokeSecurityGroupIngressRequest.getCidrIp() != null && !revokeSecurityGroupIngressRequest.getCidrIp().equals(getCidrIp())) {
            return false;
        }
        return ((revokeSecurityGroupIngressRequest.getIpPermissions() == null ? 1 : 0) ^ (getIpPermissions() == null ? 1 : 0)) == 0 ? revokeSecurityGroupIngressRequest.getIpPermissions() == null || revokeSecurityGroupIngressRequest.getIpPermissions().equals(getIpPermissions()) : false;
    }

    public String getCidrIp() {
        return this.cidrIp;
    }

    public Integer getFromPort() {
        return this.fromPort;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<IpPermission> getIpPermissions() {
        if (this.ipPermissions == null) {
            this.ipPermissions = new ArrayList();
        }
        return this.ipPermissions;
    }

    public String getIpProtocol() {
        return this.ipProtocol;
    }

    public String getSourceSecurityGroupName() {
        return this.sourceSecurityGroupName;
    }

    public String getSourceSecurityGroupOwnerId() {
        return this.sourceSecurityGroupOwnerId;
    }

    public Integer getToPort() {
        return this.toPort;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCidrIp() == null ? 0 : getCidrIp().hashCode()) + (((getToPort() == null ? 0 : getToPort().hashCode()) + (((getFromPort() == null ? 0 : getFromPort().hashCode()) + (((getIpProtocol() == null ? 0 : getIpProtocol().hashCode()) + (((getSourceSecurityGroupOwnerId() == null ? 0 : getSourceSecurityGroupOwnerId().hashCode()) + (((getSourceSecurityGroupName() == null ? 0 : getSourceSecurityGroupName().hashCode()) + (((getGroupId() == null ? 0 : getGroupId().hashCode()) + (((getGroupName() == null ? 0 : getGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getIpPermissions() != null) {
            i = getIpPermissions().hashCode();
        }
        return hashCode + i;
    }

    public void setCidrIp(String str) {
        this.cidrIp = str;
    }

    public void setFromPort(Integer num) {
        this.fromPort = num;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIpPermissions(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.ipPermissions = arrayList;
    }

    public void setIpProtocol(String str) {
        this.ipProtocol = str;
    }

    public void setSourceSecurityGroupName(String str) {
        this.sourceSecurityGroupName = str;
    }

    public void setSourceSecurityGroupOwnerId(String str) {
        this.sourceSecurityGroupOwnerId = str;
    }

    public void setToPort(Integer num) {
        this.toPort = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.groupName != null) {
            stringBuilder.append("GroupName: " + this.groupName + ", ");
        }
        if (this.groupId != null) {
            stringBuilder.append("GroupId: " + this.groupId + ", ");
        }
        if (this.sourceSecurityGroupName != null) {
            stringBuilder.append("SourceSecurityGroupName: " + this.sourceSecurityGroupName + ", ");
        }
        if (this.sourceSecurityGroupOwnerId != null) {
            stringBuilder.append("SourceSecurityGroupOwnerId: " + this.sourceSecurityGroupOwnerId + ", ");
        }
        if (this.ipProtocol != null) {
            stringBuilder.append("IpProtocol: " + this.ipProtocol + ", ");
        }
        if (this.fromPort != null) {
            stringBuilder.append("FromPort: " + this.fromPort + ", ");
        }
        if (this.toPort != null) {
            stringBuilder.append("ToPort: " + this.toPort + ", ");
        }
        if (this.cidrIp != null) {
            stringBuilder.append("CidrIp: " + this.cidrIp + ", ");
        }
        if (this.ipPermissions != null) {
            stringBuilder.append("IpPermissions: " + this.ipPermissions + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RevokeSecurityGroupIngressRequest withCidrIp(String str) {
        this.cidrIp = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withFromPort(Integer num) {
        this.fromPort = num;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withIpPermissions(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ipPermissions = arrayList;
        }
        return this;
    }

    public RevokeSecurityGroupIngressRequest withIpPermissions(IpPermission... ipPermissionArr) {
        if (getIpPermissions() == null) {
            setIpPermissions(new ArrayList(ipPermissionArr.length));
        }
        for (Object add : ipPermissionArr) {
            getIpPermissions().add(add);
        }
        return this;
    }

    public RevokeSecurityGroupIngressRequest withIpProtocol(String str) {
        this.ipProtocol = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withSourceSecurityGroupName(String str) {
        this.sourceSecurityGroupName = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withSourceSecurityGroupOwnerId(String str) {
        this.sourceSecurityGroupOwnerId = str;
        return this;
    }

    public RevokeSecurityGroupIngressRequest withToPort(Integer num) {
        this.toPort = num;
        return this;
    }
}
