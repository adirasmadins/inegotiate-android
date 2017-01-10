package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthorizeSecurityGroupIngressRequest extends AmazonWebServiceRequest {
    private String cidrIp;
    private Integer fromPort;
    private String groupId;
    private String groupName;
    private List<IpPermission> ipPermissions;
    private String ipProtocol;
    private String sourceSecurityGroupName;
    private String sourceSecurityGroupOwnerId;
    private Integer toPort;

    public AuthorizeSecurityGroupIngressRequest(String str, List<IpPermission> list) {
        this.groupName = str;
        this.ipPermissions = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthorizeSecurityGroupIngressRequest)) {
            return false;
        }
        AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest = (AuthorizeSecurityGroupIngressRequest) obj;
        if (((authorizeSecurityGroupIngressRequest.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getGroupName() != null && !authorizeSecurityGroupIngressRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getGroupId() == null ? 1 : 0) ^ (getGroupId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getGroupId() != null && !authorizeSecurityGroupIngressRequest.getGroupId().equals(getGroupId())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getSourceSecurityGroupName() == null ? 1 : 0) ^ (getSourceSecurityGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getSourceSecurityGroupName() != null && !authorizeSecurityGroupIngressRequest.getSourceSecurityGroupName().equals(getSourceSecurityGroupName())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() == null ? 1 : 0) ^ (getSourceSecurityGroupOwnerId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId() != null && !authorizeSecurityGroupIngressRequest.getSourceSecurityGroupOwnerId().equals(getSourceSecurityGroupOwnerId())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getIpProtocol() == null ? 1 : 0) ^ (getIpProtocol() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getIpProtocol() != null && !authorizeSecurityGroupIngressRequest.getIpProtocol().equals(getIpProtocol())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getFromPort() == null ? 1 : 0) ^ (getFromPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getFromPort() != null && !authorizeSecurityGroupIngressRequest.getFromPort().equals(getFromPort())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getToPort() == null ? 1 : 0) ^ (getToPort() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getToPort() != null && !authorizeSecurityGroupIngressRequest.getToPort().equals(getToPort())) {
            return false;
        }
        if (((authorizeSecurityGroupIngressRequest.getCidrIp() == null ? 1 : 0) ^ (getCidrIp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (authorizeSecurityGroupIngressRequest.getCidrIp() != null && !authorizeSecurityGroupIngressRequest.getCidrIp().equals(getCidrIp())) {
            return false;
        }
        return ((authorizeSecurityGroupIngressRequest.getIpPermissions() == null ? 1 : 0) ^ (getIpPermissions() == null ? 1 : 0)) == 0 ? authorizeSecurityGroupIngressRequest.getIpPermissions() == null || authorizeSecurityGroupIngressRequest.getIpPermissions().equals(getIpPermissions()) : false;
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

    public AuthorizeSecurityGroupIngressRequest withCidrIp(String str) {
        this.cidrIp = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withFromPort(Integer num) {
        this.fromPort = num;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withIpPermissions(Collection<IpPermission> collection) {
        if (collection == null) {
            this.ipPermissions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.ipPermissions = arrayList;
        }
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withIpPermissions(IpPermission... ipPermissionArr) {
        if (getIpPermissions() == null) {
            setIpPermissions(new ArrayList(ipPermissionArr.length));
        }
        for (Object add : ipPermissionArr) {
            getIpPermissions().add(add);
        }
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withIpProtocol(String str) {
        this.ipProtocol = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withSourceSecurityGroupName(String str) {
        this.sourceSecurityGroupName = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withSourceSecurityGroupOwnerId(String str) {
        this.sourceSecurityGroupOwnerId = str;
        return this;
    }

    public AuthorizeSecurityGroupIngressRequest withToPort(Integer num) {
        this.toPort = num;
        return this;
    }
}
